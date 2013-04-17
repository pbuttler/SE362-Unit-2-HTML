/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import editor.actioncontext.*;

/**
 *
 * @author innod_000
 */
public interface EditorActionHandler {
    
     /**
     *
     * @param context
     */
    void handleNewFileAction(NewFileActionContext context);
    
     /**
     *
     * @param context
     */
    void handleOpenFileAction(OpenFileActionContext context);
    
     /**
     *
     * @param context
     */
    void handleSaveAction(SaveFileActionContext context);

     /**
     *
     * @param context
     */
    void handleSaveAsAction(SaveFileAsActionContext context);

     /**
     *
     * @param context
     */
    void handleCloseTabAction(CloseTabActionContext context);

     /**
     *
     * @param context
     */
    void handleCutAction(CutActionContext context);

     /**
     *
     * @param context
     */
    void handleCopyAction(CopyActionContext context);

     /**
     *
     * @param context
     */
    void handlePasteAction(PasteActionContext context);

//     void handleViewAction(ViewActionContext context);

     /**
     *
     * @param context
     */
    void handleViewAsWebpageAction(ViewAsWebpageActionContext context);

//     void handleZoomToAction(ZoomActionContext context);

//     void handleOptionsAction(OptionsActionContext context);

//     void handleAutoWordWrapAction(AutoWordWrapActionContext context);

//     void handleAutoIndentAction(AutoIndentActionContext context);

//     void handleSyntaxHighlightAction(SyntaxHighlightActionContext context);

     /**
     *
     * @param context
     */
    void handleIndentCurrentLineAction(IndentCurrentLineActionContext context);

    /**
     *
     * @param context
     */
    void handleAutoWordWrapAction(AutoWordWrapActionContext context);
    
     /**
     *
     * @param context
     */
    void handleIndentSelectedTextAction(IndentSelectedTextActionContext context);

     /**
     *
     * @param context
     */
    void handleIndentEntireBufferAction(IndentEntireBufferActionContext context);

//     void handleInsertAction(InsertHTMLActionContext context);

//     void handleHeaderAction(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleH1Action(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleH2Action(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleH3Action(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleH4Action(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleH5Action(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleH6Action(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleTableAction(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleListAction(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleFontEmphasisAction(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleBoldAction(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleItalicAction(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleUnderlineAction(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handleParagraphAction(InsertHTMLActionContext context);

     /**
     *
     * @param context
     */
    void handlePictureAction(InsertHTMLActionContext context);
     
     /**
     *
     * @param context
     */
    void handleDocumentUpdateAction(DocumentUpdateActionContext context);
     

    /**
     *
     * @param context
     */
    void handleZoomToFiftyAction(ZoomActionContext context);

    /**
     *
     * @param context
     */
    void handleZoomToHundredAction(ZoomActionContext context);

    /**
     *
     * @param context
     */
    void handleZoomToTwoHundredAction(ZoomActionContext context);

     /**
     *
     * @param context
     */
    void handleValidateAction(ValidateActionContext context);
     
     /**
     *
     * @param context
     */
    void handleUndoAction(UndoActionContext context);
     
     /**
     *
     * @param context
     */
    void handleRedoAction(RedoActionContext context);
     /**
     *
     * @param context
     */
    void handleExitAction(ExitActionContext context);
     
     


}
