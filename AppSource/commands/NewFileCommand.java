/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;


import java.util.HashMap;
import app.App;
import buffer.BufferObserver;
import editor.Editor;
import java.io.File;


/**
 *
 * @author Isioma
 */
public class NewFileCommand extends Command {
    
    public NewFileCommand(App app) {
        super(app);
    }
    
    /**
     * Will inform the editor that a new file has successfully been opened
     * @param source    the GUI (not used)
     * @param arguments arguments for this command. Expects nothing
     *                  
     */
    public void execute(Object source, HashMap<String, Object> arguments) {
              /**
        * Process
        * prerequisites:
        * 1) the file to read must be present
        * 2) the contents of the file must be present
        * 3) the file path must be present
        */
        
        Editor editor = this._app.getEditor();
        
        String fileName = "New File";
        String fileContents = "Hello";
        
        BufferObserver activeBuffer = editor.createBufferObserver(new File(fileName), fileContents);
        
        this._app.registerBufferObserver(activeBuffer);
        
        
        
        
        
    }
    
}
