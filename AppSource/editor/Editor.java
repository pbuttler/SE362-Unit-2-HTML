package editor;

import common.BufferObserver;
import java.util.ArrayList;
import java.util.HashMap;

public class Editor {
    
	private BufferObserver _activeBufferObserver;
	private ArrayList<BufferObserver> _bufferList;
	
    
    public Editor() {
        
    	// Constructs Editor
        
    }
    
    public BufferObserver getActiveBufferObserver() {
    	
    	// returns the active buffer as an object
    	
        return _activeBufferObserver;
    }
    
    public BufferObserver setActiveBufferObserver(BufferObserver currentBufferObserver) {
        
    	// Given a buffer object, sets the active buffer
    	
    	_activeBufferObserver = currentBufferObserver;
        
        return _activeBufferObserver;
    }
    
    public void closeBufferObserver(String bufferIdentifier) {
    	
    	// VALIDATED
    	// close a buffer based on its identifier

    }

    public BufferObserver createBufferObserver(String fileName, String fileContents) {
        
    	// Create a new buffer with a given fileName and contents
    	// VALIDATED
    	
    	BufferObserver newBufferObserver = new BufferObserver(fileName, fileContents);
    	_bufferList.add(newBufferObserver);
		
    	return newBufferObserver;
    }

    public BufferObserver getBufferObserver(String bufferIdentifier) {
        
    	//Returns a buffer based on identifier
    	
    	return null;
    }

    public void saveBufferObserver(String bufferIdentifier) {
        
    	// Saves a buffer's status to its attached file
    	// VALIDATED
    	
    }
    
    public void destroy() {
    	
    }
}