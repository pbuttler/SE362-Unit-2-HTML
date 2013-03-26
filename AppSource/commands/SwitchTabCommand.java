/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.HashMap;
import app.App;
import editor.Buffer;
import editor.Editor;
import gui.GUI;

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
        GUI gui = this._app.getGUI();
        
        // retrieve the file name (used to reference the file buffer in the editor)
        String currentTabIdentifier = (String) arguments.get("currentTabIdentifier");
        String previousTabIdentifier = (String) arguments.get("previousTabIdentifier");
        
        // tell the editor to close the buffer
        // the editor should check to see if buffer contents have been saved
        // before closing the buffer
        
        // TODO put this code in one place (method name switch bufferObserver)
        this._app.unregisterBufferObserver();
        Buffer activeBuffer = editor.getBuffer(currentTabIdentifier);
        this._app.registerBufferObserver(activeBuffer);
        
    }

    
    
}
