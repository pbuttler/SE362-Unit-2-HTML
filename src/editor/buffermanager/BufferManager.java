/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.buffermanager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 *
 * @author Peter and Isioma
 */
public class BufferManager {
    
    private HashMap<Integer, Buffer> _db;
    
    /**
     * 
     */
    public BufferManager(){
        
        _db = new HashMap<>();
        
    }
    /**
     * 
     * @param file
     * @return 
     */
    public Buffer addBuffer(File file) throws IOException {
        
        Buffer buffer = new Buffer(file);
        _db.put(buffer.getId(), buffer);
        return buffer;
    }
    
    public Buffer addBuffer(Buffer buffer) {
        _db.put(buffer.getId(), buffer);
        return buffer;
    }
    /**
     * 
     * @param id
     * @return 
     */
    public boolean removeBuffer(int id) {
        if ( _db.containsKey(id)) {
            _db.remove(id);
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Buffer getBuffer(int id) {
        if ( _db.containsKey(id)) {
            Buffer buffer = _db.get(id);
            return buffer;
        }
        return null;
    }

    public Buffer addBuffer() throws IOException {
        Buffer buffer = new Buffer();
        _db.put(buffer.getId(), buffer);
        return buffer;
    }

    public Buffer duplicateBuffer(int id, File newFile) throws IOException {
        
        Buffer originalBuffer = getBuffer(id);
        Buffer newBuffer = new Buffer(newFile);
        
        newBuffer.update(originalBuffer.getContents());
        
        addBuffer(newBuffer);
        
        return newBuffer;
        
    }
    
}
