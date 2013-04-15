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
    
     void handleNewFileAction(NewFileActionContext context);
    
     void handleOpenFileAction(OpenFileActionContext context);
    
     void handleSaveAction(SaveFileActionContext context);

     void handleSaveAsAction(SaveFileAsActionContext context);

     void handleCloseTabAction(CloseFileActionContext context);

     void handleCutAction(CutActionContext context);

     void handleCopyAction(CopyActionContext context);

     void handlePasteAction(PasteActionContext context);

//     void handleViewAction(ViewActionContext context);

     void handleViewAsWebpageAction(ViewAsWebpageActionContext context);

     void handleZoomToAction(ZoomActionContext context);

//     void handleOptionsAction(OptionsActionContext context);

//     void handleAutoWordWrapAction(AutoWordWrapActionContext context);

//     void handleAutoIndentAction(AutoIndentActionContext context);

//     void handleSyntaxHighlightAction(SyntaxHighlightActionContext context);

     void handleIndentCurrentLineAction(IndentCurrentLineActionContext context);

     void handleIndentSelectedTextAction(IndentSelectedTextActionContext context);

     void handleIndentEntireBufferAction(IndentEntireBufferActionContext context);

     void handleInsertAction(InsertHTMLActionContext context);

     void handleHeaderAction(InsertHTMLActionContext context);

     void handleH1Action(InsertHTMLActionContext context);

     void handleH2Action(InsertHTMLActionContext context);

     void handleH3Action(InsertHTMLActionContext context);

     void handleH4Action(InsertHTMLActionContext context);

     void handleH5Action(InsertHTMLActionContext context);

     void handleH6Action(InsertHTMLActionContext context);

     void handleTableAction(InsertHTMLActionContext context);

     void handleListAction(InsertHTMLActionContext context);

     void handleFontEmphasisAction(InsertHTMLActionContext context);

     void handleBoldAction(InsertHTMLActionContext context);

     void handleItalicAction(InsertHTMLActionContext context);

     void handleUnderlineAction(InsertHTMLActionContext context);

     void handleParagraphAction(InsertHTMLActionContext context);

     void handlePictureAction(InsertHTMLActionContext context);

}
