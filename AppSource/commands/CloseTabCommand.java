/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5seconds.commands;

import java.util.HashMap;
import pkg5seconds.app.App;
import pkg5seconds.editor.Buffer;
import pkg5seconds.editor.Editor;
import pkg5seconds.gui.GUI;

/**
 *
 * @author Isioma
 */
public class CloseTabCommand extends Command {

    
    public CloseTabCommand(App app) {
        super(app);
    }
    
    @Override
    public void execute(Object source, HashMap<String, Object> arguments) {
        
        Editor editor = this._app.getEditor();
        GUI gui = this._app.getGUI();
        
        // retrieve the file name (used to reference the file buffer in the editor)
        String closedTabIdentifier = (String) arguments.get("tabIdentifier");
        
        // tell the editor to close the buffer
        // the editor should check to see if buffer contents have been saved
        // before closing the buffer
        editor.closeBuffer(closedTabIdentifier); 
        
        // TODO put this code in one place possibly APP
        // reset the buffer observer
        String activeTabIdentifier = gui.getActiveTabIdentifier();
        this._app.unregisterBufferObserver();
        Buffer activeBuffer = editor.getBuffer(activeTabIdentifier);
        this._app.registerBufferObserver(activeBuffer);
        
        
    }

   
    
}
