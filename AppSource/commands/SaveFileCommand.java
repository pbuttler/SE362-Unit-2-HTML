/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.HashMap;
import app.App;
import editor.Editor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isioma
 */
public class SaveFileCommand implements Command {

    private App _appRef;
    public SaveFileCommand(App app) {
        this._appRef = app;
    }
    
   
   /**
     * Will inform the editor that a new file has successfully been opened
     * @param source    the GUI (not used)
     * @param arguments arguments for this command. Expects "tabIdentifier: the 
     *                  name of the file which is used to identify the buffer in
     *                  the editor
     *                  
     */
   public void execute(CommandArgs args) {
       
       SaveFileCommandArgs arguments = (SaveFileCommandArgs) args;
       
       Editor editor = this._appRef.getEditor();
       
       String tabIdentifier = arguments.TabIdentifier;
        try {
            editor.saveBufferObserver(tabIdentifier);
        } catch (IOException ex) {
            Logger.getLogger(SaveFileCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    
}
