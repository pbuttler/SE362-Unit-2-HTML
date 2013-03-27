package editor;

import common.BufferObserver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public BufferObserver createBufferObserver(File file, String fileString) {
        
    	// Create a new buffer with a given fileName and contents
    	// VALIDATED
    	
    	BufferObserver newBufferObserver = new BufferObserver(file, fileString);
    	_bufferList.put(file.getName(), newBufferObserver);
		
    	return newBufferObserver;
    }

    public BufferObserver getBufferObserver(String bufferIdentifier) {
        
    	//Returns a buffer based on identifier
        
        return _bufferList.get(bufferIdentifier);
    	
    	 
    }

    public void saveBufferObserver(String bufferIdentifier) throws IOException {
        
    	BufferObserver currentBuffer = _bufferList.get(bufferIdentifier);
        File file = currentBuffer.getFile();
        
        // if file doesnt exists, then create it
        if (!file.exists()) {
		file.createNewFile();
	}
 
	FileWriter fw = new FileWriter(file.getAbsoluteFile());
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write(currentBuffer.getContents());
	bw.close();    
        
    	
    }
    
    public void destroy() {
    	
    }

    public BufferObserver createBufferObserver(File file, String[] fileContents) {
        BufferObserver newBufferObserver = new BufferObserver(file, Utilities.arrayToString(fileContents));
    	_bufferList.put(file.getName(), newBufferObserver);
		
    	return newBufferObserver;
    }
}