/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import editor.EditorController;
import editor.EditorView;
import editor.EditorViewGUI;
import editor.actioncontext.OpenFileActionContext;
import editor.buffermanager.BufferManager;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import viewcontroller.GeneralView;

/**
 *
 * @author Isioma
 */
public class FiveSecondsHtmlEditor implements WindowListener {

    /**
     *
     */
    public static void initialize() {
        BufferManager.initializeBufferManager();
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
                // Set System L&F
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {
           // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }
        EditorView view = new EditorViewGUI();
        FSViewManager.setWindowVisible( true );
        FSViewManager.addNewWindowListener( new FiveSecondsHtmlEditor() ); 
        // connect the view and controller
        cont.setView(view);
        view.setController(cont);
        
        // Tell the controller to enter its initial state
        cont.enterInitialState();
        
        
        for (String arg : args) {
            File file = new File(arg);
            
            if (file.exists()) {
                OpenFileActionContext context = new OpenFileActionContext();
                context.setFile(file);

                cont.respondToInput(context);
            }
           
        }
    }

    
    /**
     *
     * @param e
     */
    public void windowOpened(WindowEvent e) {}

    
    /**
     *
     * @param e
     */
    public void windowClosing(WindowEvent e) {}

    
    /**
     *
     * @param e
     */
    public void windowClosed(WindowEvent e) {}

    
    /**
     *
     * @param e
     */
    public void windowIconified(WindowEvent e) {}

    
    /**
     *
     * @param e
     */
    public void windowDeiconified(WindowEvent e) {}

    
    /**
     *
     * @param e
     */
    public void windowActivated(WindowEvent e) {}

    
    /**
     *
     * @param e
     */
    public void windowDeactivated(WindowEvent e) {}
}
