/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.actioncontext;

import actioncontext.GeneralActionContext;
import java.io.File;

/**
 *
 * @author Danielle
 */
public class OpenFileActionContext extends GeneralActionContext{
    
    private File openFile;
    private String _title;
    private String _contents;
    private int _bufferId;
    
    /**
     *
     */
    public OpenFileActionContext(){
    
    }

    /**
     *
     * @param file
     */
    public void setFile(File file) {
        this.openFile = file;
    }
    
    /**
     *
     * @return
     */
    public File getFile() {
     return openFile;   
    }

    /**
     *
     * @param fileName
     */
    public void setTitle(String fileName) {
        _title = fileName;
    }
    /**
     *
     * @return
     */
    public String getTitle() {
        return _title;
    }

    /**
     *
     * @param contents
     */
    public void setContents(String contents) {
        _contents = contents;
    }
    /**
     *
     * @return
     */
    public String getContents() {
        return _contents;
    }

    public void setBufferId(int id) {
        _bufferId = id;
    }
    
    public int getBufferId() {
        return _bufferId;
    }

    public void setBufferName(String name) {
        _title = name;
    }
}
