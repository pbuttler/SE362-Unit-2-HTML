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
    public OpenFileActionContext(){
    
    }

    public void setFile(File file) {
        this.openFile = file;
    }
    
    public File getFile() {
     return openFile;   
    }

    public void setTitle(String fileName) {
        _title = fileName;
    }
    public String getTitle() {
        return _title;
    }

    public void setContents(String contents) {
        _contents = contents;
    }
    public String getContents() {
        return _contents;
    }
}
