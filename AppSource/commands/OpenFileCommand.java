/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.File;
import java.util.HashMap;
import app.App;
import editor.Buffer;
import editor.Editor;

/**
 *
 * @author Isioma
 */
public class OpenFileCommand extends Command {
    
    
    public OpenFileCommand(App app) {
        super(app);
    }
    
    @Override
    public void execute(Object source, HashMap<String, Object> arguments) {
       /**
        * Process
        * prerequisites:
        * 1) the file to read must be present
        * 2) the contents of the file must be present
        * 3) the file path must be present
        */
        
        Editor editor = this._app.getEditor();
        
        String fileName = (String) arguments.get("fileName");
        File file = (File) arguments.get("file");
        String fileContents = (String) arguments.get("fileContents");
        
        Buffer activeBuffer = editor.createBuffer(fileName,fileContents);
        
        this._app.unregisterBufferObserver();
        
        this._app.registerBufferObserver(activeBuffer);
        
        
        
        
        
        
        
        
    }

    
    
}
