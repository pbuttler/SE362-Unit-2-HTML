/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import app.App;

/**
 *
 * @author Isioma
 */
public class CommandFactory {
    
    public static NewFileCommand getNewFileCommand(App app) {
        
        return new NewFileCommand(app);
        
    } 
    
    public static ExitAppCommand getExitAppCommand(App app) {
        
        return new ExitAppCommand(app);
        
    } 
    
    public static CloseTabCommand getCloseTabCommand(App app) {
        
        return new CloseTabCommand(app);
        
    } 
    
    public static OpenFileCommand getOpenFileCommand(App app) {
        
        return new OpenFileCommand(app);
        
    } 
    
    public static SaveFileCommand getSaveFileCommand(App app) {
        
        return new SaveFileCommand(app);
        
    } 
    
    public static SwitchTabCommand getSwitchTabCommand(App app) {
        
        return new SwitchTabCommand(app);
        
    } 
    
}
