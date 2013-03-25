/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5seconds.commands;

import java.util.HashMap;
import pkg5seconds.app.App;

/**
 *
 * @author Isioma
 */
public class Command {
    
    public App _app;    
    public Command(App app) {
        this._app = app;
    }
    
    public void execute(Object source, HashMap<String, Object> arguments) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
