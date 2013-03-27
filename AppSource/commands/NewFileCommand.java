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
        
        String fileName = "";
        String fileContents = "";
        
        BufferObserver activeBuffer = editor.createBufferObserver(fileName, fileContents);
        
        this._app.registerBufferObserver(activeBuffer);
        
        
        
        
        
    }
    
}
