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

     void handleCloseAction();

     void handleCutAction();

     void handleCopyAction();

     void handlePasteAction();

     void handleViewAction();

     void handleViewAsWebpageAction();

     void handleZoomToAction();

     void handleOptionsAction();

     void handleAutoWordWrapAction();

     void handleAutoIndentAction();

     void handleSyntaxHighlightAction();

     void handleIndentCurrentLineAction();

     void handleIndentSelectedTextAction();

     void handleIndentEntireBufferAction();

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
