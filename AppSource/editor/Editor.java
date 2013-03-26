package editor;

import java.util.ArrayList;
import java.util.HashMap;

public class Editor {
    
	private Buffer _activeBuffer;
	private ArrayList<Buffer> _bufferList;
	
    
    public Editor() {
        
    	// Constructs Editor
        
    }
    
    public Buffer getActiveBuffer() {
    	
    	// returns the active buffer as an object
    	
        return _activeBuffer;
    }
    
    public Buffer setActiveBuffer(Buffer currentBuffer) {
        
    	// Given a buffer object, sets the active buffer
    	
    	_activeBuffer = currentBuffer;
        
        return _activeBuffer;
    }
    
    public void closeBuffer(String bufferIdentifier) {
    	
    	// VALIDATED
    	// close a buffer based on its identifier

    }

    public Buffer createBuffer(String fileName, String fileContents) {
        
    	// Create a new buffer with a given fileName and contents
    	// VALIDATED
    	
    	Buffer newBuffer = new Buffer(fileName, fileContents);
    	_bufferList.add(newBuffer);
		
    	return newBuffer;
    }

    public Buffer getBuffer(String bufferIdentifier) {
        
    	//Returns a buffer based on identifier
    	
    	return null;
    }

    public void saveBuffer(String bufferIdentifier) {
        
    	// Saves a buffer's status to its attached file
    	// VALIDATED
    	
    }
    
    public void destroy() {
    	
    }
}