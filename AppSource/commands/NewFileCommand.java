/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;


import java.util.HashMap;
import app.App;
import common.BufferObserver;
import editor.Editor;


/**
 *
 * @author Isioma
 */
public class NewFileCommand extends Command {
    
    public NewFileCommand(App app) {
        super(app);
    }
    
    
    public void execute(Object source, HashMap<String, Object> arguments) {
              /**
        * Process
        * prerequisites:
        * 1) the file to read must be present
        * 2) the contents of the file must be present
        * 3) the file path must be present
        */
        
        Editor editor = this._app.getEditor();
        
        String fileName = "";
        String fileContents = "";
        
        BufferObserver activeBuffer = editor.createBufferObserver(fileName, fileContents);
        
        this._app.unregisterBufferObserver();
        
        this._app.registerBufferObserver(activeBuffer);
        
        
        
        
        
    }
    
}
