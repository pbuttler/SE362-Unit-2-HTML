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
   public void execute(Object source, HashMap<String, Object> arguments) {
       
       Editor editor = this._app.getEditor();
       
       String tabIdentifier = (String) arguments.get("tabIdentifier");
       
       editor.saveBufferObserver(tabIdentifier);
       
   }
    
}
