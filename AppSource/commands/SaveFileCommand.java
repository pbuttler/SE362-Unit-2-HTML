/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5seconds.commands;

import java.util.HashMap;
import pkg5seconds.app.App;
import pkg5seconds.editor.Editor;

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
       
       editor.saveBuffer(tabIdentifier);
       
   }
    
}
