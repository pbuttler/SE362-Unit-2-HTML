/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.File;
import java.util.HashMap;
import app.App;
import common.BufferObserver;

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
    
    /**
     * Will inform the editor that a new file has successfully been opened
     * @param source    the GUI (not used)
     * @param arguments arguments for this command. Expects "filename: the name 
     *                  of the file, file: the file object, fileContents: the 
     *                  contents of the file as an array of strings
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
        
        String fileName = (String) arguments.get("fileName");
        File file = (File) arguments.get("file");
        String[] fileContents = (String[]) arguments.get("fileContents");
        
        BufferObserver activeBufferObserver = editor.createBufferObserver(fileName,fileContents);
        
        this._app.registerBufferObserver(activeBufferObserver);
        
        
        
        
        
        
        
        
    }

    
    
}
