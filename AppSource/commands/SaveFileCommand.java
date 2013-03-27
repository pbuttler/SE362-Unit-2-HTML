/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.HashMap;
import app.App;
import editor.Editor;

/**
 *
 * @author Isioma
 */
public class SaveFileCommand extends Command {

    public SaveFileCommand(App app) {
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
       
       String tabIdentifier = (String) arguments.get("tabIdentifier");
       
       editor.saveBufferObserver(tabIdentifier);
       
   }
    
}
