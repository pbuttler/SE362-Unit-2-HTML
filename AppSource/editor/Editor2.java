package editor;

import java.util.ArrayList;
import java.util.HashMap;

public class Editor2 {
    
  private Buffer2 _activeBuffer;
	private ArrayList<Buffer> _bufferList;
	
    
    public Editor2() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Buffer2 getActiveBuffer() {
        return _activeBuffer;
    }
    
    public Buffer2 setActiveBuffer(Buffer currentBuffer) {
        _activeBuffer = currentBuffer;
        
        return _activeBuffer;
    }
    
    public void closeBuffer(String bufferIdentifier) {
    	

    }

    public Buffer2 createBuffer(String fileName, String fileContents) {
        
    	Buffer2 newBuffer = new Buffer(fileName, fileContents);
        
        return newBuffer;
    }

    public Buffer2 getBuffer(String bufferIdentifier) {
        
        return null;
    }

    public void saveBuffer(String bufferIdentifier) {
        
    }
    
    public void destroy() {
    	
    }
}
