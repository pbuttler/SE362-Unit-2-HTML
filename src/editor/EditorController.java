/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import actioncontext.GeneralActionContext;
import editor.EditorView.EditorInChan;
import editor.actioncontext.*;
import editor.buffermanager.Buffer;
import editor.buffermanager.BufferManager;
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

    

    public EditorController() {
       
    }

    /**
     * The states of this controller.
     */
    private enum EditorState implements ControllerState {

        SAMPLESTATE
    }

    public void enterInitialState() {
        FSViewManager.pushView((EditorViewGUI) view);
        handleNewFileAction(new NewFileActionContext());
    }

    /**
     * It takes the given context, and send it to a specific action We don't
     * have them all here, I figure we can do them as we go. - Luke
     *
     * @param context 
     */
    public void respondToInput(GeneralActionContext context) {
        if (context instanceof NewFileActionContext) {
            handleNewFileAction((NewFileActionContext) context);
        } else if (context instanceof OpenFileActionContext) {
            this.handleOpenFileAction((OpenFileActionContext) context);
        } else if (context instanceof SaveFileAsActionContext) {
            this.handleSaveAsAction((SaveFileAsActionContext) context);
        } else if (context instanceof SaveFileActionContext) {
            this.handleSaveAction((SaveFileActionContext) context);
        } else if (context instanceof OutlineViewActionContext) {
            this.handleOutlineViewAction((OutlineViewActionContext)context);
        } else if (context instanceof NewFileActionContext) {
            handleNewFileAction((NewFileActionContext) context);
        } else if (context instanceof OpenFileActionContext) {
            handleOpenFileAction((OpenFileActionContext) context);
        } else if (context instanceof SaveFileActionContext) {
            handleSaveAction((SaveFileActionContext) context);
        } else if (context instanceof SaveFileAsActionContext) {
            handleSaveAsAction((SaveFileAsActionContext) context);
        } else if (context instanceof CloseTabActionContext) {
            handleCloseTabAction((CloseTabActionContext) context);
        } else if (context instanceof CutActionContext) {
            handleCutAction((CutActionContext) context);
        } else if (context instanceof CopyActionContext) {
            handleCopyAction((CopyActionContext) context);
        } else if (context instanceof ValidateActionContext) {
            handleValidateAction((ValidateActionContext)context);
        } else if (context instanceof PasteActionContext) {
            handlePasteAction((PasteActionContext) context);
        } else if (context instanceof ViewAsWebpageActionContext) {
            handleViewAsWebpageAction((ViewAsWebpageActionContext) context);
        } else if (context instanceof AutoWordWrapActionContext){    
            handleAutoWordWrapAction((AutoWordWrapActionContext) context);
        } else if (context instanceof IndentCurrentLineActionContext) {
            handleIndentCurrentLineAction((IndentCurrentLineActionContext) context);
        } else if (context instanceof ImageDictionaryActionContext){
            handleImageDictionaryAction((ImageDictionaryActionContext) context);
        } else if (context instanceof IndentSelectedTextActionContext) {
            handleIndentSelectedTextAction((IndentSelectedTextActionContext) context);
        } else if (context instanceof IndentEntireBufferActionContext) {
            handleIndentEntireBufferAction((IndentEntireBufferActionContext) context);
        } else if (context instanceof InsertHTMLActionContext) {

            InsertHTMLActionContext htmlActionContext = (InsertHTMLActionContext) context;
            switch (htmlActionContext.getTag()) {
                case InsertHTMLActionContext.H1:
                    handleH1Action(htmlActionContext);
                    break;
                case InsertHTMLActionContext.H2:
                    handleH2Action(htmlActionContext);
                    break;
                case InsertHTMLActionContext.H3:
                    handleH3Action(htmlActionContext);
                    break;
                case InsertHTMLActionContext.H4:
                    handleH4Action(htmlActionContext);
                    break;
                case InsertHTMLActionContext.H5:
                    handleH5Action(htmlActionContext);
                    break;
                case InsertHTMLActionContext.H6:
                    handleH6Action(htmlActionContext);
                    break;
                case InsertHTMLActionContext.AHREF:
                    handleAHREFAction(htmlActionContext);
                    break;
                case InsertHTMLActionContext.TABLE:
                    handleTableAction(htmlActionContext);
                    break;
                case InsertHTMLActionContext.UL:
                    handleListAction(htmlActionContext);
                    break;
                case InsertHTMLActionContext.B:
                    handleBoldAction(htmlActionContext);
                    break;
                case InsertHTMLActionContext.I:
                    handleItalicAction(htmlActionContext);
                    break;
                case InsertHTMLActionContext.U:
                    handleUnderlineAction(htmlActionContext);
                    break;
                case InsertHTMLActionContext.P:
                    handleParagraphAction(htmlActionContext);
                    break;
                case InsertHTMLActionContext.IMG:
                    handlePictureAction(htmlActionContext);
                    break;
            }
        } else if (context instanceof DocumentUpdateActionContext) {
            handleDocumentUpdateAction((DocumentUpdateActionContext) context);
        } else if (context instanceof ZoomActionContext) {
            ZoomActionContext zoomContext = (ZoomActionContext) context;
            switch (zoomContext.getPercentZoom()) {
                case 50:
                    this.handleZoomToFiftyAction(zoomContext);
                    break;
                case 100:
                    this.handleZoomToHundredAction(zoomContext);
                    break;
                case 200:
                    this.handleZoomToTwoHundredAction(zoomContext);
                    break;
            }
        } else if (context instanceof ValidateActionContext) {
            handleViewAsWebpageAction(null);
        } else if (context instanceof UndoActionContext) {
            handleUndoAction((UndoActionContext) context);
        } else if (context instanceof RedoActionContext) {
            handleRedoAction((RedoActionContext) context);
        } else if (context instanceof ExitActionContext) {
            handleExitAction((ExitActionContext) context);
        }

    }

    /**
     * The actions are performed here, and the views take the context The view
     * is EditorViewGUI.displayOutput - Luke
     *
     * @param context 
     */
    public void handleNewFileAction(NewFileActionContext context) {

        // TODO create new buffer
        
        Buffer newBuffer;
        try {
            
            newBuffer = BufferManager.addBuffer();
            
            OpenFileActionContext oContext = new OpenFileActionContext();
            oContext.setFile(context.getFile());
            oContext.setBufferId(newBuffer.getId());
            oContext.setBufferName(newBuffer.getName());
            oContext.setContents(newBuffer.getContents());

            this.view.displayOutput(oContext);
        } catch (IOException ex) {
            Logger.getLogger(EditorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleValidateAction(ValidateActionContext context) {
        this.view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    public void handleOpenFileAction(OpenFileActionContext context) {
        
        File file = context.getFile();

        Buffer newBuffer;
        try {
            newBuffer = BufferManager.addBuffer(file);
            context.setBufferId(newBuffer.getId());
            context.setBufferName(newBuffer.getName());
            context.setContents(newBuffer.getContents());
            this.view.displayOutput(context);
        } catch (IOException ex) {
            Logger.getLogger(EditorController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param context
     */
    public void handleSaveAction(SaveFileActionContext context) {

        int bufferId = (int) view.getInfo("currentTab");
        
        Buffer currentBuffer = BufferManager.getBuffer(bufferId);
        
        if ( null == currentBuffer ) return;
        
        
        boolean isNewBuffer = BufferManager.getBuffer(bufferId).isNewBuffer();
        if (isNewBuffer) {    
            context.setNewBuffer(true);
        } else {
        
            try {
                currentBuffer.save();
            } catch (IOException ex) {
                Logger.getLogger(EditorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        this.view.displayOutput(context);

    }

    /**
     *
     * @param context
     */
    public void handleSaveAsAction(SaveFileAsActionContext context) {
        
        int id = (int) view.getInfo("currentTab");
        
        Buffer currentBuffer = BufferManager.getBuffer(id);
        if ( null == currentBuffer ) return;
        
        try {
                
            currentBuffer.setFile(context.getNewFile());
            currentBuffer.save();

            this.view.displayOutput(context);
        } catch (IOException ex) {
            Logger.getLogger(EditorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    public void handleInputError(String message) {
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleCloseTabAction(CloseTabActionContext context) {
        
        int bufferId = (int) view.getInfo("currentTab");
        
        boolean bufferClosed = BufferManager.removeBuffer(bufferId, context.isForceClose());
        
        if ( !bufferClosed ) {
            
            boolean isNewBuffer = BufferManager.getBuffer(bufferId).isNewBuffer();
            
            context.setNewBuffer(isNewBuffer);
            
        }
        
        context.setForceClose(bufferClosed);
        
        this.view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleCutAction(CutActionContext context) {

        this.view.displayOutput(context);

    }
    
    public void handleOutlineViewAction(OutlineViewActionContext context) {
        this.view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleCopyAction(CopyActionContext context) {

        this.view.displayOutput(context);

    }

    /**
     *
     * @param context
     */
    @Override
    public void handlePasteAction(PasteActionContext context) {

        this.view.displayOutput(context);

    }

    /**
     *
     * @param context
     */
    public void handleAutoWordWrapAction(AutoWordWrapActionContext context) {
        this.view.displayOutput(context);
        
        //boolean x = get whether or not the autowordwrapmenu button is checked
        
    }
    
    
    /**
     *
     * @param context
     */
    @Override
    public void handleViewAsWebpageAction(ViewAsWebpageActionContext context) {
        this.view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    public void handleImageDictionaryAction(ImageDictionaryActionContext context) {
        this.view.displayOutput(context);
        
    }
    
    /**
     *
     * @param context
     */
    @Override
    public void handleIndentCurrentLineAction(IndentCurrentLineActionContext context) {
        this.view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleIndentSelectedTextAction(IndentSelectedTextActionContext context) {
        this.view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleIndentEntireBufferAction(IndentEntireBufferActionContext context) {
        this.view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH1Action(InsertHTMLActionContext context) {


        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH2Action(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH3Action(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH4Action(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH5Action(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH6Action(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    
     /**
     *
     * @param context
     */
    public void handleAHREFAction(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }
    
    
    /**
     *
     * @param context
     */
    @Override
    public void handleTableAction(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleListAction(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleFontEmphasisAction(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleBoldAction(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleItalicAction(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleUnderlineAction(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleParagraphAction(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handlePictureAction(InsertHTMLActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleZoomToFiftyAction(ZoomActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleZoomToHundredAction(ZoomActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleZoomToTwoHundredAction(ZoomActionContext context) {
        view.displayOutput(context);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleDocumentUpdateAction(DocumentUpdateActionContext context) {

//        System.out.println("Controller: Current text area contents: " + context.getContent());
        
        int id = (int) view.getInfo("currentTab");
        Buffer currentBuffer = BufferManager.getBuffer(id);
        
        if ( null == currentBuffer ) return;
        
        currentBuffer.dropTail();
        currentBuffer.update(context.getContent());
        
        
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleRedoAction(RedoActionContext context) {
        System.out.println("Controller: Rolling forward changes");
        
        int id = (int) view.getInfo("currentTab");
        Buffer currentBuffer = BufferManager.getBuffer(id);
        
        currentBuffer.redo();
        
        String bufferContents = currentBuffer.getContents();
        
        DocumentUpdateActionContext dContext = new DocumentUpdateActionContext();
        
        dContext.setContent(bufferContents);
        
        view.displayOutput(dContext);

    }

    /**
     *
     * @param context
     */
    @Override
    public void handleUndoAction(UndoActionContext context) {
        
        int id = (int) view.getInfo("currentTab");
        Buffer currentBuffer = BufferManager.getBuffer(id);
        
        currentBuffer.undo();
        
        String bufferContents = currentBuffer.getContents();
        
        DocumentUpdateActionContext dContext = new DocumentUpdateActionContext();
        
        dContext.setContent(bufferContents);
        
        view.displayOutput(dContext);

    }
    
    @Override
    public void handleExitAction(ExitActionContext context) {
        System.out.println("Controller: Exiting...");
        view.displayOutput(context);
    }
}
