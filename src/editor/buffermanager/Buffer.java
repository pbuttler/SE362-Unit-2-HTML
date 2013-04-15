/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.buffermanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import utils.Utilities;

/**
 *
 * @author Peter
 */
public class Buffer {
    
    public static int BUFFER_ID = 92929;
    
    private int _id;
    private boolean _hasChanged = false;
    private String _contentsString;
    private BufferHistory _history;
    private File _file;
    
    
    public Buffer(File file) throws IOException {
        
        this._id = BUFFER_ID + 1;
        BUFFER_ID++;
        
        this._file = file;  
        _history = new BufferHistory();
        
        this._contentsString = Utilities.readFileToString(file);
        
    
    }
    
    public Buffer() throws IOException {
        this(new File("New File"));
    }
    
    public File getFile(){        
        return _file;
    }
    
    public void setFile(File file) throws IOException {
        this._file = file;
    }
    
    public String save() throws IOException {
        return save(_file);
    }
    
    public String save(File file) throws IOException {

            BufferedWriter bufferedWriter = null;
            try {
                
                if (!file.exists()) {
                    file.createNewFile();
                }
                
                bufferedWriter =  new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(_contentsString);
                
                return file.getName();
                
               
            } catch (IOException ex) {
                throw ex;
            }finally {
                //Close the BufferedWriter
                
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    }
                    
            }
               
    }
    
    public void undo() {
        
        _contentsString = _history.stepBack();
        
    }
    
    public void redo() {
        
        _contentsString = _history.stepForward();
        
    }
    
    public void update(String contents) {
        
        _history.flush();
        _history.add(contents);
        _contentsString = contents;
        
    }
    
    public String getName() {
        
        return _file.getName();
        
    }
    
    public int getId() {
        return this._id;
    }
    
    @Override
    public String toString() {
        
        return this._contentsString;
    
    }

    public String getContents() {
        return _contentsString;
    }
        
}
