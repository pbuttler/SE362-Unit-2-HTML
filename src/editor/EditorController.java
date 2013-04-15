/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import actioncontext.GeneralActionContext;
import editor.EditorView.EditorInChan;
import editor.actioncontext.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.FSViewManager;
import viewcontroller.GeneralController;
import viewcontroller.GeneralView.InputChannel;
import org.w3c.tidy.Tidy;
import utils.Utilities;

/**
 *
 * @author Isioma
 */
public class EditorController extends GeneralController {

    Tidy tidy = new Tidy();

    
    /**
        * The states of this controller.
        */
    private enum EditorState implements ControllerState {
        SAMPLESTATE
    }
    
    public void enterInitialState() {
        FSViewManager.pushView( (EditorViewGUI) view );
    }
    
    /**
     * It takes the given context, and send it to a specific action 
     * - Luke
     **/
    public void respondToInput(GeneralActionContext context) {
        if ( context instanceof NewFileActionContext ) {
            
            handleNewFileAction((NewFileActionContext)context);
            
        } else if ( context instanceof OpenFileActionContext ) {
            
            this.handleOpenFileAction((OpenFileActionContext)context);
            
        } else if ( context instanceof SaveFileAsActionContext ) {
            
            this.handleSaveAsAction((SaveFileAsActionContext)context);
            
        } else if ( context instanceof SaveFileActionContext ) {
            
            this.handleSaveAction((SaveFileActionContext)context);
            
        }
        
    }


    
//    public void respondToInput(String message, InputChannel channel) {
//        
//        switch ( (EditorState) currentState ) {
//            case SAMPLESTATE:
//                handleSampleState(message, (EditorInChan) channel);
//                    break;
//        }
//        
//    }
    /**
     *  The actions are performed here, and the views take the context
     *  The view is EditorViewGUI.displayOutput
     * - Luke
     **/
    public void handleNewFileAction(NewFileActionContext context) {
        
        // TODO create new buffer
        
        this.view.displayOutput(context);
    }

    public void handleOpenFileAction(OpenFileActionContext context) {
        try {
            File file = context.getFile();
            String fileName = file.getName();
            String contents = Utilities.readFileToString(file);
            
            context.setTitle(fileName);
            context.setContents(contents);
            
            
            // TODO create new buffer 
            
            this.view.displayOutput(context);
            
        } catch (IOException ex) {
            Logger.getLogger(EditorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
<<<<<<< HEAD
    public void handleSaveAction(SaveFileActionContext context) {
      /*  try{
            //stuff
        } catch (IOException ex) {
            
        } */
=======
    private void handleSaveAction(SaveFileActionContext context) {
        
>>>>>>> 90a4a9fd3bd5af6441bb9307cf832c31a86fdb1f
    }

    public void handleSaveAsAction(SaveFileAsActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void handleInputError(String message) {
        
    }
    
}
