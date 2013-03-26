/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import commands.CloseTabCommand;
import commands.CommandFactory;
import commands.ExitAppCommand;
import commands.NewFileCommand;
import commands.OpenFileCommand;
import commands.SaveFileCommand;
import commands.SwitchTabCommand;

/**
 *
 * @author innod_000
 */
public class Commander {
    
    private App _app;
    private commands.NewFileCommand _newFileCommand;
    private commands.OpenFileCommand _openFileCommand;
    private commands.SaveFileCommand _saveFileCommand;
    private commands.CloseTabCommand _closeFileCommand;
    private commands.SwitchTabCommand _switchTabCommand;
    private commands.ExitAppCommand _exitAppCommand;
    
    public Commander(App app) {
        this._app = app;
        this.setCommands();
        
    }
    
    private void setCommands() {
        CommandFactory commandFactory = new CommandFactory();
        this._closeFileCommand = commandFactory.getCloseTabCommand(this._app);
        this._exitAppCommand = commandFactory.getExitAppCommand(this._app);
        this._newFileCommand = commandFactory.getNewFileCommand(this._app);
        this._openFileCommand = commandFactory.getOpenFileCommand(this._app);
        this._saveFileCommand = commandFactory.getSaveFileCommand(this._app);
        this._switchTabCommand = commandFactory.getSwitchTabCommand(this._app);
    }
    
    public NewFileCommand getNewFileCommand() {
        
        return this._newFileCommand;
        
    } 
    
    public ExitAppCommand getExitAppCommand() {
        
        return this._exitAppCommand;
        
    } 
    
    public CloseTabCommand getCloseTabCommand() {
        
        return this._closeFileCommand;
        
    } 
    
    public OpenFileCommand getOpenFileCommand() {
        
        return this._openFileCommand;
        
    } 
    
    public SaveFileCommand getSaveFileCommand() {
        
        return this._saveFileCommand;
        
    } 
    
    public SwitchTabCommand getSwitchTabCommand() {
        
        return this._switchTabCommand;
        
    } 
    
}
