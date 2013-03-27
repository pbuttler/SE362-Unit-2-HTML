package editor;

import common.BufferObserver;
import java.util.ArrayList;
import java.util.HashMap;
import utils.Utilities;

public class Editor {
    
	private BufferObserver _activeBufferObserver;
	private HashMap<String, BufferObserver> _bufferList;
	
    
    public Editor() {
        
    	// Constructs Editor
        _bufferList = new HashMap<>();
        
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
    	_bufferList.put(fileName, newBufferObserver);
		
    	return newBufferObserver;
    }

    public BufferObserver getBufferObserver(String bufferIdentifier) {
        
    	//Returns a buffer based on identifier
        
        return _bufferList.get(bufferIdentifier);
    	
    	 
    }

    public void saveBufferObserver(String bufferIdentifier) {
        
    	// Saves a buffer's status to its attached file
    	// VALIDATED
    	
    }
    
    public void destroy() {
    	
    }

    public BufferObserver createBufferObserver(String fileName, String[] fileContents) {
        BufferObserver newBufferObserver = new BufferObserver(fileName, Utilities.arrayToString(fileContents));
    	_bufferList.put(fileName, newBufferObserver);
		
    	return newBufferObserver;
    }
}