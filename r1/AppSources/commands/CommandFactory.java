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
    
    public NewFileCommand getNewFileCommand(App app) {
        
        return new NewFileCommand(app);
        
    } 
    
    public ExitAppCommand getExitAppCommand(App app) {
        
        return new ExitAppCommand(app);
        
    } 
    
    public CloseTabCommand getCloseTabCommand(App app) {
        
        return new CloseTabCommand(app);
        
    } 
    
    public OpenFileCommand getOpenFileCommand(App app) {
        
        return new OpenFileCommand(app);
        
    } 
    
    public SaveFileCommand getSaveFileCommand(App app) {
        
        return new SaveFileCommand(app);
        
    } 
    
    public SwitchTabCommand getSwitchTabCommand(App app) {
        
        return new SwitchTabCommand(app);
        
    } 
    
}
