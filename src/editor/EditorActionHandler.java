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

     void handleInsertAction();

     void handleHeaderAction();

     void handleH1Action();

     void handleH2Action();

     void handleH3Action();

     void handleH4Action();

     void handleH5Action();

     void handleH6Action();

     void handleTableAction();

     void handleListAction();

     void handleFontEmphasisAction();

     void handleBoldAction();

     void handleItalicAction();

     void handleUnderlineAction();

     void handleParagraphAction();

     void handlePictureAction();

    
}
