/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5seconds.app;

import javax.swing.JFrame;
import pkg5seconds.commands.CommandFactory;
import pkg5seconds.editor.Buffer;
import pkg5seconds.editor.Editor;
import pkg5seconds.gui.GUI;

/**
 *
 * @author Isioma
 */
public class App {
    
    private pkg5seconds.commands.NewFileCommand _newFieldCommand;
    private pkg5seconds.commands.OpenFileCommand _openFileCommand;
    private pkg5seconds.commands.SaveFileCommand _saveFileCommand;
    private pkg5seconds.commands.CloseTabCommand _closeFileCommand;
    private pkg5seconds.commands.SwitchTabCommand _switchFileCommand;
    private pkg5seconds.commands.ExitAppCommand _exitAppCommand;
    
    private pkg5seconds.editor.Editor _editor;
    private pkg5seconds.gui.GUI _gui;
    
    
    public App() {
    
        this.setCommands();
        
        this._editor = new Editor();
        this._gui = new GUI(_newFieldCommand, _openFileCommand, _saveFileCommand, _closeFileCommand, _switchFileCommand, _exitAppCommand);
        
    }
    
    public Editor getEditor() {
        return this._editor;
    }
    
    public GUI getGUI() {
        return this._gui;
    }
    
    private void setCommands() {
        this._closeFileCommand = CommandFactory.getCloseTabCommand(this);
        this._exitAppCommand = CommandFactory.getExitAppCommand(this);
        this._newFieldCommand = CommandFactory.getNewFileCommand(this);
        this._openFileCommand = CommandFactory.getOpenFileCommand(this);
        this._saveFileCommand = CommandFactory.getSaveFileCommand(this);
        this._switchFileCommand = CommandFactory.getSwitchTabCommand(this);
    }
    
    public void destroy() {
        
        // kill the GUI
        
        this._gui.destroy();
        
        
        
    }

    public void unregisterBufferObserver() {
        
        // only one observer so no parameters 
        this._gui.unregisterBufferObserver();
    }

    public void registerBufferObserver(Buffer activeBuffer) {
        this._gui.registerBufferObserver(activeBuffer);
    }
    
}
