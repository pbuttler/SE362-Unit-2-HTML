package pkg5seconds.gui;

import pkg5seconds.commands.CloseTabCommand;
import pkg5seconds.commands.ExitAppCommand;
import pkg5seconds.commands.NewFileCommand;
import pkg5seconds.commands.OpenFileCommand;
import pkg5seconds.commands.SaveFileCommand;
import pkg5seconds.commands.SwitchTabCommand;
import pkg5seconds.editor.Buffer;

public  class GUI {

    public GUI(NewFileCommand _newFieldCommand, OpenFileCommand _openFileCommand, SaveFileCommand _saveFileCommand, CloseTabCommand _closeFileCommand, SwitchTabCommand _switchFileCommand, ExitAppCommand _exitAppCommand) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getActiveTabIdentifier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void unregisterBufferObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void registerBufferObserver(Buffer activeBuffer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
