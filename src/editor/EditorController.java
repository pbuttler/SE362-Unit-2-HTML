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
public class EditorController extends GeneralController implements EditorActionHandler {

    Tidy tidy = new Tidy();

    

    
    /**
        * The states of this controller.
        */
    private enum EditorState implements ControllerState {
        SAMPLESTATE
    }
    
    public void enterInitialState() {
        FSViewManager.pushView( (EditorViewGUI) view );
        handleNewFileAction(new NewFileActionContext());
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
            
        } else if (context instanceof DocumentUpdateActionContext) {
            
            this.handleDocumentUpdateAction((DocumentUpdateActionContext) context);
            
        }
        
    }

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
    
    public void handleSaveAction(SaveFileActionContext context) {
      /*  try{
            //stuff
        } catch (IOException ex) {
            
        } */
    }

    public void handleSaveAsAction(SaveFileAsActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void handleInputError(String message) {
        
    }
    
    @Override
    public void handleCloseTabAction(CloseTabActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleCutAction(CutActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleCopyAction(CopyActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handlePasteAction(PasteActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleViewAsWebpageAction(ViewAsWebpageActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleZoomToAction(ZoomActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleIndentCurrentLineAction(IndentCurrentLineActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleIndentSelectedTextAction(IndentSelectedTextActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleIndentEntireBufferAction(IndentEntireBufferActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleInsertAction(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleHeaderAction(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleH1Action(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleH2Action(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleH3Action(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleH4Action(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleH5Action(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleH6Action(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleTableAction(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleListAction(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleFontEmphasisAction(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleBoldAction(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleItalicAction(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleUnderlineAction(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleParagraphAction(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handlePictureAction(InsertHTMLActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void handleDocumentUpdateAction(DocumentUpdateActionContext context) {
        
        System.out.println(context.getContent());
        
    }
    
}
