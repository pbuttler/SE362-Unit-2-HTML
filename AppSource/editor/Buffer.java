 package editor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
*
* @author Isioma, Peter
*/
public class Buffer implements Observer {
    
	private ArrayList<Object> Contents;
	private String ContentsString;
        private String filename;
	
   
    public Buffer(String systemPath, String bufferContents) {
        
    	// Constructor for Buffer
    	
    }
    
    public String getContents() {
       
    	// returns the buffer's contents as a String
    	
    	return ContentsString;
        
    }
    
    public void setBufferContents(String bufferContents) {
        
        // Sets the buffer string and the content array
        
    }
    
    public void validateBufferContents() {
    	
    	// Uses validate method to match constructs 
    	
    }
    
    public void saveBuffer() {
        
    }

    @Override
    public void update(Observable o, Object arg) {
    	
    }
    
}