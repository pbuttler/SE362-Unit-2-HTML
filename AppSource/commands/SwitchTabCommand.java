/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.HashMap;
import app.App;
import common.BufferObserver;
import editor.Editor;
import gui.htmleditor.testGUI;


/**
 *
 * @author Isioma
 */
public class SwitchTabCommand extends Command {

    public SwitchTabCommand(App app) {
        super(app);
    }
    
    @Override
    public void execute(Object source, HashMap<String, Object> arguments) {
        
        Editor editor = this._app.getEditor();
        testGUI gui = this._app.getCommander().getGUI();
        
        // retrieve the file name (used to reference the file buffer in the editor)
        String currentTabIdentifier = (String) arguments.get("currentTabIdentifier");
        String previousTabIdentifier = (String) arguments.get("previousTabIdentifier");
        
        // tell the editor to close the buffer
        // the editor should check to see if buffer contents have been saved
        // before closing the buffer
        
        // TODO put this code in one place (method name switch bufferObserver)
        this._app.unregisterBufferObserver();
        BufferObserver activeBufferObserver = editor.getBufferObserver(currentTabIdentifier);
        this._app.registerBufferObserver(activeBufferObserver);
        
    }

    
    
}
