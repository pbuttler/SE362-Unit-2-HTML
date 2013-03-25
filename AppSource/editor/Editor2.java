package editor;

import java.util.ArrayList;
import java.util.HashMap;

public class Editor {
    
  private Buffer _activeBuffer;
	private ArrayList<Buffer> _bufferList;
	
    
    public Editor() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Buffer getActiveBuffer() {
        return _activeBuffer;
    }
    
    public Buffer setActiveBuffer(Buffer currentBuffer) {
        _activeBuffer = currentBuffer;
        
        return _activeBuffer;
    }
    
    public void closeBuffer(String bufferIdentifier) {
    	

    }

    public Buffer createBuffer(String fileName, String fileContents) {
        
    	Buffer newBuffer = new Buffer(fileName, fileContents);
    }

    public Buffer getBuffer(String bufferIdentifier) {
        
    }

    public void saveBuffer(String bufferIdentifier) {
        
    }
    
    public void destroy() {
    	
    }
}
