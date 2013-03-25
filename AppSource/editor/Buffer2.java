package editor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
*
* @author Isioma, Peter
*/
public abstract class Buffer implements Observer {
    
  private ArrayList<Object> Contents;
	private String ContentsString;
	
   
    public Buffer(String systemPath, String bufferContents) {
        
    }
    
    public String getContents() {
        
       return ContentsString;
        
    }
    
    public void setBufferContents(String bufferContents) {
        
        
        
    }
    
    public void validateBufferContents() {
    	
    }

    @Override
    public void update(Observable o, Object arg) {
    	
    }
    
}
