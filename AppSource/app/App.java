/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JFrame;
import commands.CommandFactory;
import editor.Buffer;
import editor.Editor;
import gui.htmleditor.testGUI;


/**
 *
 * @author Isioma
 */
public class App {
    
    private commands.NewFileCommand _newFieldCommand;
    private commands.OpenFileCommand _openFileCommand;
    private commands.SaveFileCommand _saveFileCommand;
    private commands.CloseTabCommand _closeFileCommand;
    private commands.SwitchTabCommand _switchFileCommand;
    private commands.ExitAppCommand _exitAppCommand;
    
    private editor.Editor _editor;
    private testGUI _gui;
    
    
    public App() {
    
        this.setCommands();
        
        this._editor = new Editor();
        //this._gui = new testGUI(_newFieldCommand, _openFileCommand, _saveFileCommand, _closeFileCommand, _switchFileCommand, _exitAppCommand);
        this._gui = new testGUI();
        this._gui.instantiate();
        
    }
    
    public Editor getEditor() {
        return this._editor;
    }
    
    public testGUI getGUI() {
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
