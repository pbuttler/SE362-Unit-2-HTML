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
public class ExitAppCommand implements Command {
    
    private App _appRef;
    public ExitAppCommand(App app) {
       this._appRef = app;
        
    }
    
    public void execute(CommandArgs args) {
       
        // destroy the editor 
            // editor should check to see if the contents of each buffer have 
            // saved
        
        this._appRef.getEditor().destroy();
        
        this._appRef.destroy(); 
        
    }
    
}
