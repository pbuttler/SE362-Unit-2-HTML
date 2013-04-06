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
import utils.Utilities;

/**
 *
 * @author Isioma
 */
public class OpenFileCommand implements Command {
    
    private App _appRef;
    public OpenFileCommand(App app) {
        this._appRef = app;
    }
    
    
    /**
     * Will inform the editor that a new file has successfully been opened
     * @param source    the GUI (not used)
     * @param arguments arguments for this command. Expects "filename: the name 
     *                  of the file, file: the file object, fileContents: the 
     *                  contents of the file as an array of strings
     *                  
     */
    public void execute(CommandArgs args) {
        
        OpenFileCommandArgs arguments = (OpenFileCommandArgs) args;
       /**
        * Process
        * prerequisites:
        * 1) the file to read must be present
        * 2) the contents of the file must be present
        * 3) the file path must be present
        */
        
        Editor editor = this._appRef.getEditor();
        
        File file = arguments.File;        
        String[] fileContents = arguments.FileContents;
        String fileString = Utilities.arrayToString(fileContents);
        
        BufferObserver activeBufferObserver = editor.createBufferObserver(file , fileString);
        
        this._appRef.registerBufferObserver(activeBufferObserver);       
        
    }

    
    
}
