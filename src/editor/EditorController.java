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
     *  The view is actionContext.EditorViewGUI.displayOutput
     * - Luke
     **/
    public void handleNewFileAction(NewFileActionContext context) {
        
        // TODO create new buffer
        
        this.view.displayOutput(context);
    }

    private void handleOpenFileAction(OpenFileActionContext context) {
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
    
    private void handleSaveAction(SaveFileActionContext context) {
      /*  try{
            //stuff
        } catch (IOException ex) {
            
        } */
    }

    private void handleSaveAsAction(SaveFileAsActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleCloseAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleCutAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleCopyAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handlePasteAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleViewAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleViewAsWebpageAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleZoomToAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleOptionsAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleAutoWordWrapAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleAutoIndentAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleSyntaxHighlightAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleIndentCurrentLineAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleIndentSelectedTextAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleIndentEntireBufferAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleInsertAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleHeaderAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH1Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH2Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH3Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH4Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH5Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH6Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleTableAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleListAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleFontEmphasisAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleBoldAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleItalicAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleUnderlineAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleParagraphAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handlePictureAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void handleInputError(String message) {
        
    }
    
}
