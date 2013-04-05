/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.HashMap;
import app.App;
import buffer.BufferObserver;
import editor.Editor;
import gui.htmleditor.testGUI;

/**
 *
 * @author Isioma
 */
public class CloseTabCommand extends Command {

    
    public CloseTabCommand(App app) {
        super(app);
    }
    
    @Override
    /**
     * Will inform the editor that a new file has successfully been opened
     * @param source    the GUI (not used)
     * @param arguments arguments for this command. Expects "tabIdentifier: the 
     *                  name of the file which is used to identify the buffer in
     *                  the editor
     *                  
     */
    public void execute(Object source, HashMap<String, Object> arguments) {
        
        Editor editor = this._app.getEditor();
        testGUI gui = this._app.getCommander().getGUI();
        
        // retrieve the file name (used to reference the file buffer in the editor)
        String closedTabIdentifier = (String) arguments.get("tabIdentifier");
        
        // tell the editor to close the buffer
        // the editor should check to see if buffer contents have been saved
        // before closing the buffer
        editor.closeBufferObserver(closedTabIdentifier); 
        
        // TODO put this code in one place possibly APP
        // reset the buffer observer
        String activeTabIdentifier = gui.getActiveTabIdentifier();
        this._app.unregisterBufferObserver();
        BufferObserver activeBuffer = editor.getBufferObserver(activeTabIdentifier);
        this._app.registerBufferObserver(activeBuffer);
        
        
    }

   
    
}
