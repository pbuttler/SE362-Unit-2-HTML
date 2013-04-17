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
    private static BufferManager _bufferManager;

    /**
     *
     */
    private BufferManager() {

        _db = new HashMap<>();

    }

    public static void initializeBufferManager() {
        _bufferManager = new BufferManager();
    }

    /**
     *
     * @param file
     * @return
     */
    public static Buffer addBuffer(File file) throws IOException {

        Buffer buffer = new Buffer(file);
        _bufferManager.getDb().put(buffer.getId(), buffer);
        return buffer;
    }

    public static Buffer addBuffer(Buffer buffer) {
        _bufferManager.getDb().put(buffer.getId(), buffer);
        return buffer;
    }

    /**
     *
     * @param id
     * @return
     */
    public static boolean removeBuffer(int id, boolean force) {
        
        
        if (_bufferManager.getDb().containsKey(id)) {
            
            if (!force) {
                Buffer buffer = getBuffer(id);
                if ( buffer.hasChanges() ) {
                    return false;
                }
            }
            
            _bufferManager.getDb().remove(id);
            return true;
        }
        return false;
    }

    /**
     *
     * @param id
     * @return
     */
    public static Buffer getBuffer(int id) {
        if (_bufferManager.getDb().containsKey(id)) {
            Buffer buffer = _bufferManager.getDb().get(id);
            return buffer;
        }
        return null;
    }

    public static Buffer addBuffer() throws IOException {
        Buffer buffer = new Buffer();
        _bufferManager.getDb().put(buffer.getId(), buffer);
        return buffer;
    }

    public static Buffer duplicateBuffer(int id, File newFile) throws IOException {

        Buffer originalBuffer = getBuffer(id);
        Buffer newBuffer = new Buffer(newFile);

        newBuffer.update(originalBuffer.getContents());

        addBuffer(newBuffer);

        return newBuffer;

    }

    private HashMap<Integer, Buffer> getDb() {
        return _db;
    }
}
