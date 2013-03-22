/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg5seconds.commands;


import java.util.HashMap;
import pkg5seconds.app.App;
import pkg5seconds.editor.Buffer;
import pkg5seconds.editor.Editor;


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
        
        Buffer activeBuffer = editor.createBuffer(fileName, fileContents);
        
        this._app.unregisterBufferObserver();
        
        this._app.registerBufferObserver(activeBuffer);
        
        
        
        
        
    }
    
}
