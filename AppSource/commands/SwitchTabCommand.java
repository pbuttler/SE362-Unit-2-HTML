/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.HashMap;
import app.App;
import common.BufferObserver;
import editor.Editor;
import gui.htmleditor.GUI;


/**
 *
 * @author Isioma
 */
public class SwitchTabCommand implements Command {

    private App _appRef;
    public SwitchTabCommand(App app) {
        this._appRef = app;
    }
    
    public void execute(CommandArgs args) {
        SwitchTabCommandArgs arguments = (SwitchTabCommandArgs) args;
        
        Editor editor = this._appRef.getEditor();
        GUI gui = this._appRef.getCommander().getGUI();
        
        // retrieve the file name (used to reference the file buffer in the editor)
        String currentTabIdentifier = arguments.CurrentTabIdentifier;
        
        // tell the editor to close the buffer
        // the editor should check to see if buffer contents have been saved
        // before closing the buffer
        
        // TODO put this code in one place (method name switch bufferObserver)
        this._appRef.unregisterBufferObserver();
        BufferObserver activeBufferObserver = editor.getBufferObserver(currentTabIdentifier);
        this._appRef.registerBufferObserver(activeBufferObserver);
        
    }

    
    
}
