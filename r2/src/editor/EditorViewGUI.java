/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import actioncontext.GeneralActionContext;
import editor.actioncontext.NewFileActionContext;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import viewcontroller.GeneralView;
import viewcontroller.GeneralViewGUI;

/**
 *
 * @author Isioma
 */
public class EditorViewGUI extends EditorView implements GeneralViewGUI {

    /**
    * The JPanel to which contains everything in this view.
    */
   private JPanel _mainPanel;

    public void setChannelEnabled(InputChannel inChannel, boolean enabled) {
    }

    /**
    * @return This GUI's content panel.
    */
   public JPanel getMainPanel() {
           return _mainPanel;
   }

 
    public void setVisible(boolean visible) {
        // Pass the change on to the main panel.
        _mainPanel.setVisible( visible );
    }

    
    public void actionPerformed(ActionEvent e) {
    }

    
    public void displayOutput(GeneralActionContext context) {
        
        if ( context instanceof NewFileActionContext ) {}
        
    }
    
}
