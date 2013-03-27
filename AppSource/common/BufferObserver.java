/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import editor.Validator;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import utils.Utilities;

/**
*
* @author Isioma, Peter
*/
public class BufferObserver implements Observer {
    
	private ArrayList<Object> Contents;
	private String ContentsString;
        private String filename;
	
   
    public BufferObserver(String systemPath, String bufferContents) {
        
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
        
        Validator validator = new Validator();
        validator.parseBuffer(this.ContentsString);
    	
    }
    
    public void saveBuffer() {
        
    }

    @Override
    public void update(Observable o, Object arg) {
    	ObservableBuffer guiBuffer = (ObservableBuffer) o;
        String[] contents = guiBuffer.getContents();
        
        String contentsAsString = Utilities.arrayToString(contents);
        
        this.ContentsString = contentsAsString;
        
        this.validateBufferContents();
    }
    
}