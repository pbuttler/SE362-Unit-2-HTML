/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.HashMap;
import app.App;

/**
 *
 * @author Isioma
 */
public class ExitAppCommand extends Command {
    
    public ExitAppCommand(App app) {
        super(app);
        
    }
    
    @Override
    public void execute(Object source, HashMap<String, Object> arguments) {
       
        // destroy the editor 
            // editor should check to see if the contents of each buffer have 
            // saved
        
        this._app.getEditor().destroy();
        
        this._app.destroy(); 
        
    }
    
}
