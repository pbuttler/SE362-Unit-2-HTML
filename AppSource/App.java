/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg362unit2.app;

import java.util.List;
import java.util.Observer;

/**
 *
 * @author Isioma
 */
public class App {

    /**
     * @param args the command line arguments
     */
    private GUI Userinterface;  
    private Editor Editor;
    private MiddleBuffer MiddleBuffer;
    
    public App() {
    
         // construct GUI
        Userinterface = new GUI();
        
        // construct Editor
        Editor = new Editor();
        
        MiddleBuffer = new MiddleBuffer();
        
        MiddleBuffer.addObserver(Editor);
        
        GUI.addObserver(MiddleBuffer);
        
        
        
        // get observers from editor
        
        
        // register observers with gui
        
        
        // main loop
    
    }
    
    public static void main(String[] args) {
        
        App application = new App();
        
        // TODO code application logic here
        
       
        
    }
}
