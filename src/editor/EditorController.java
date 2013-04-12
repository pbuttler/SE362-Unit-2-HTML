/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import actioncontext.GeneralActionContext;
import editor.EditorView.EditorInChan;
import editor.actioncontext.NewFileActionContext;
import main.FSViewManager;
import viewcontroller.GeneralController;
import viewcontroller.GeneralView.InputChannel;

/**
 *
 * @author Isioma
 */
public class EditorController extends GeneralController {

    
    /**
        * The states of this controller.
        */
    private enum EditorState implements ControllerState {
        SAMPLESTATE
    }
    
    public void enterInitialState() {
        FSViewManager.pushView( (EditorViewGUI) view );
    }
    
  
    public void respondToInput(GeneralActionContext context) {
        
        if ( context instanceof NewFileActionContext ) {}
        
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

    private void handleSampleState(String message, EditorInChan channel) {
        switch(channel) {
            case ICSampleAction:
                
                // do stuff
                
                break;
        }
    }
    
    public void handleInputError(String message) {
        
    }
    
}