/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import editor.EditorController;
import editor.EditorView;
import editor.EditorViewGUI;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Isioma
 */
public class FiveSecondsHtmlEditor implements WindowListener {

    public static void initialize() {
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        initialize();
        
        // Create the Editor Controller and view
        EditorController cont = new EditorController();
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {        }
        
        EditorView view = new EditorViewGUI();
        FSViewManager.setWindowVisible( true );
        FSViewManager.addNewWindowListener( new FiveSecondsHtmlEditor() );
        
        // connect the view and controller
        cont.setView(view);
        view.setController(cont);
        
        // Tell the controller to enter its initial state
        cont.enterInitialState();
    }

    
    public void windowOpened(WindowEvent e) {}

    
    public void windowClosing(WindowEvent e) {}

    
    public void windowClosed(WindowEvent e) {}

    
    public void windowIconified(WindowEvent e) {}

    
    public void windowDeiconified(WindowEvent e) {}

    
    public void windowActivated(WindowEvent e) {}

    
    public void windowDeactivated(WindowEvent e) {}
}
