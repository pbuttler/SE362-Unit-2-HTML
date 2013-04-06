/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.HashMap;
import app.App;
import buffer.BufferObserver;
import editor.Editor;
import gui.htmleditor.GUI;

/**
 *
 * @author Isioma
 */
public class CloseTabCommand implements Command {

    private App _appRef;
    
    public CloseTabCommand(App app) {
        _appRef = app;
    }
    
    
    /**
     * Will inform the editor that a new file has successfully been opened
     * @param arguments arguments for this command. Expects "tabIdentifier: the 
     *                  name of the file which is used to identify the buffer in
     *                  the editor
     *                  
     */
    public void execute(CommandArgs args) {
        
        CloseTabCommandArgs  arguments = (CloseTabCommandArgs) args;
        
        Editor editor = this._appRef.getEditor();
        GUI gui = this._appRef.getCommander().getGUI();
        
        // retrieve the file name (used to reference the file buffer in the editor)
        String closedTabIdentifier = arguments.TabIdentifier;
        
        // tell the editor to close the buffer
        // the editor should check to see if buffer contents have been saved
        // before closing the buffer
        editor.closeBufferObserver(closedTabIdentifier); 
        
        // TODO put this code in one place possibly APP
        // reset the buffer observer
        String activeTabIdentifier = gui.getActiveTabIdentifier();
        this._appRef.unregisterBufferObserver();
        BufferObserver activeBuffer = editor.getBufferObserver(activeTabIdentifier);
        this._appRef.registerBufferObserver(activeBuffer);
        
        
    }


   
    
}
