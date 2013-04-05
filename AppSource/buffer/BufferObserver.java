/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

//import editor.Validator;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import utils.Utilities;

/**
*
* @author Isioma, Peter
*/
public class BufferObserver implements Observer {
    
	private String ContentsString;
        private String filename;
        private boolean hasChanged = false;
        private File file;
        
        private ArrayList<Line> lines;
        private int lineIndex;
   
    public BufferObserver(File file, String bufferContents) {
        
       this.file = file;
       ContentsString = bufferContents;        
    	
    }
    
    public File getFile(){
        
        return file;
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
        
//        Validator validator = new Validator();
//        validator.parseBuffer(this.ContentsString);
    	
    }
    
    public void saveBuffer() {
        
    }
    
    public void printLines(){
        
    }

    @Override
    public void update(Observable o, Object arg) {
    	ObservableBuffer guiBuffer = (ObservableBuffer) o;
        String[] contents = guiBuffer.getContents();       
        
        hasChanged = true;
        
        String contentsAsString = Utilities.arrayToString(contents);        
        
        this.ContentsString = contentsAsString;
                
        this.validateBufferContents();
    }
    
}