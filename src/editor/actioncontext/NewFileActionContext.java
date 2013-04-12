/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.actioncontext;

import actioncontext.GeneralActionContext;
import java.io.File;

/**
 *
 * @author Isioma
 */
public class NewFileActionContext extends GeneralActionContext {
    private File _newFile;
    public NewFileActionContext() {
    }
    
    public File getFile() {
        return _newFile;
    }
    
    public void setFile(File file) {
        _newFile = file;
    }
}
