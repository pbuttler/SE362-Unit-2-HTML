/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import editor.gui.FSTab;
import editor.gui.FSTabbedPane;
import actioncontext.GeneralActionContext;
import articles.outlineView.OutlineView;
import editor.actioncontext.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import main.FSViewManager;
import viewcontroller.FSMenuBar;
import viewcontroller.GeneralView;
import viewcontroller.GeneralViewGUI;

/**
 *
 * @author Isioma
 */
public class EditorViewGUI extends EditorView implements GeneralViewGUI, DocumentListener, EditorActionHandler {

    /**
     * The JPanel to which contains everything in this view.
     */
    private JPanel _mainPanel;
    private FSTabbedPane _tabs;

    /**
     *
     */
    public EditorViewGUI() {

        _mainPanel = new JPanel();
        _tabs = new FSTabbedPane();

        GroupLayout mainPanelLayout = new GroupLayout(_mainPanel);

        _mainPanel.setLayout(mainPanelLayout);

        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(_tabs, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));

        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(_tabs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE));

    }

    public void setChannelEnabled(InputChannel inChannel, boolean enabled) {
    }

    /**
     * @return This GUI's content panel.
     */
    public JPanel getMainPanel() {
        return _mainPanel;
    }

    public void setVisible(boolean visible) {
        // Pass the change on to the main panel.
        _mainPanel.setVisible(visible);
    }

    /**
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
    }
    
    @Override
    public Object getInfo(String id) {
        
        switch(id) {
            
            case "currentTab":
                FSTab currentTab = getCurrentTab();
                
                int data = currentTab.getBufferId();
                
                return data;
                
            default:
                break;
            
        }
        
        return null;
        
    }

    /**
     * So display output is given the context in a switch. Follow the method you
     * want - Luke
    *
    * @param context 
    */
    public void displayOutput(GeneralActionContext context) {

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
        } else if (context instanceof PasteActionContext) {
            handlePasteAction((PasteActionContext) context);
        } else if (context instanceof ViewAsWebpageActionContext) {
            handleViewAsWebpageAction((ViewAsWebpageActionContext) context);
        } else if (context instanceof IndentCurrentLineActionContext) {
            handleIndentCurrentLineAction((IndentCurrentLineActionContext) context);
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
        } else if ( context instanceof ZoomActionContext ) {
    
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
        } else if (context instanceof UndoActionContext) {
            handleUndoAction((UndoActionContext) context);
        } else if (context instanceof RedoActionContext) {

            handleRedoAction((RedoActionContext) context);

        
        } else if (context instanceof ExitActionContext) {

            handleExitAction((ExitActionContext) context);

        }

    }

    private void addBlankTab() {
        //String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">";
        //String contents = docType + "\n<html>\n</html>";
        String contents = "<html>\n</html>";

        this.addTab("New File", contents);
    }

    private void addTab(OpenFileActionContext context) {
        FSTab newPanel = new FSTab(context.getTitle(), context.getContents());
        newPanel.setBufferId(context.getBufferId());

        newPanel.addEditorActionListener(this);

        _tabs.add(context.getTitle(), newPanel);

        _tabs.setSelectedIndex(_tabs.getTabCount() - 1);
    
    }
    private void addTab(String tabName, String textAreaContents) {

        FSTab newPanel = new FSTab(tabName, textAreaContents);

        newPanel.addEditorActionListener(this);

        _tabs.add(tabName, newPanel);

        _tabs.setSelectedIndex(_tabs.getTabCount() - 1);

    }

    private FSTab getCurrentTab() {

        return ((FSTab) _tabs.getSelectedComponent());

    }

    /**
     * Actions in GUI handled here. and we're done :) - Luke
     *
     */
    /**
     * DocumentListener methods *
     * @param de 
     */
    @Override
    public void insertUpdate(DocumentEvent de) {


        DocumentUpdateActionContext context = new DocumentUpdateActionContext();
        FSTab currentTab = getCurrentTab();

        String title = currentTab.getTitle();
        String content = currentTab.getContent();

        context.setTitle(title);
        context.setContent(content);

        this.controller.respondToInput(context);

    }

    /**
     *
     * @param de
     */
    @Override
    public void removeUpdate(DocumentEvent de) {

        DocumentUpdateActionContext context = new DocumentUpdateActionContext();
        FSTab currentTab = getCurrentTab();

        String title = currentTab.getTitle();
        String content = currentTab.getContent();

        context.setTitle(title);
        context.setContent(content);

        this.controller.respondToInput(context);
    }

    /**
     *
     * @param de
     */
    @Override
    public void changedUpdate(DocumentEvent de) {
        DocumentUpdateActionContext context = new DocumentUpdateActionContext();
        FSTab currentTab = getCurrentTab();

        String title = currentTab.getTitle();
        String content = currentTab.getContent();

        context.setTitle(title);
        context.setContent(content);

        this.controller.respondToInput(context);
    }

    /**
     * Handle GUI Actions *
     * @param context 
     */
    public void handleNewFileAction(NewFileActionContext context) {
        this.addBlankTab();
    }

    /**
     *
     * @param context
     */
    public void handleOpenFileAction(OpenFileActionContext context) {

        this.addTab(context);

    }

    /**
     *
     * @param context
     */
    public void handleSaveAction(SaveFileActionContext context) {

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /**
     *
     * @param context
     */
    public void handleSaveAsAction(SaveFileAsActionContext context) {

        FSTab currentTab = getCurrentTab();
        currentTab.setTitle(context.getNewFile().getName());
        _tabs.setTitleAt(_tabs.getSelectedIndex(), context.getNewFile().getName());

    }

    /**
     *
     * @param context
     */
    @Override
    public void handleCloseTabAction(CloseTabActionContext context) {

        Component selected = _tabs.getSelectedComponent();
        if (selected != null) {

            _tabs.remove(selected);
            
        }
        
        
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleCutAction(CutActionContext context) {

        FSTab currentTab = this.getCurrentTab();
        currentTab.cut();

    }

    /**
     *
     * @param context
     */
    @Override
    public void handleCopyAction(CopyActionContext context) {

        FSTab currentTab = this.getCurrentTab();
        currentTab.copy();

    }

    /**
     *
     * @param context
     */
    @Override
    public void handlePasteAction(PasteActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.paste();
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleViewAsWebpageAction(ViewAsWebpageActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void handleOutlineViewAction(OutlineViewActionContext context) {
        OutlineView v = new OutlineView(this.getCurrentTab().getContent());
        if (v.isNoError()==true) {
            v.setVisible(true);
        }
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleIndentCurrentLineAction(IndentCurrentLineActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.indentCurrentLine();
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleIndentSelectedTextAction(IndentSelectedTextActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.indentSelection();
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleIndentEntireBufferAction(IndentEntireBufferActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.indentAll();
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH1Action(InsertHTMLActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.inserthxHeaderElement(1);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH2Action(InsertHTMLActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.inserthxHeaderElement(2);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH3Action(InsertHTMLActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.inserthxHeaderElement(3);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH4Action(InsertHTMLActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.inserthxHeaderElement(4);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH5Action(InsertHTMLActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.inserthxHeaderElement(4);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleH6Action(InsertHTMLActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.inserthxHeaderElement(6);
    }
      
    /**
     *
     * @param context
     */
    public void handleAHREFAction(InsertHTMLActionContext context){
        FSTab currentTab = this.getCurrentTab();
        String url = (String) context.getData().get(InsertHTMLActionContext.URL);
        currentTab.insertContent("<a href=\"" + url + "\"/>");
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleTableAction(InsertHTMLActionContext context) {

        int rows = Integer.parseInt((String) context.getData().get(InsertHTMLActionContext.ROWS));
        int cols = Integer.parseInt((String) context.getData().get(InsertHTMLActionContext.COLS));

        FSTab currentTab = this.getCurrentTab();
        String table = currentTab.createTableElement(rows, cols);
        currentTab.insertContent(table);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleListAction(InsertHTMLActionContext context) {

        int items = Integer.parseInt((String) context.getData().get(InsertHTMLActionContext.ITEMS));


        FSTab currentTab = this.getCurrentTab();
        String list = currentTab.createUnorderedListElement(items);
        currentTab.insertContent(list);
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleFontEmphasisAction(InsertHTMLActionContext context) {
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleBoldAction(InsertHTMLActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.insertSimpleElement("b");
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleItalicAction(InsertHTMLActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.insertSimpleElement("i");
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleUnderlineAction(InsertHTMLActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.insertSimpleElement("u");
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleParagraphAction(InsertHTMLActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.insertSimpleElement("p");
    }

    /**
     *
     * @param context
     */
    @Override
    public void handlePictureAction(InsertHTMLActionContext context) {
        String url = (String) context.getData().get("url");
        String altText = (String) context.getData().get("altText");
        FSTab currentTab = this.getCurrentTab();
        currentTab.insertContent("<img src=\"" + url + "\" alt=\"" + altText + "\">");
    }
    
    /**
     *
     * @param context
     */
    @Override
    public void handleZoomToFiftyAction(ZoomActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.zoom(context.getPercentZoom());
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleZoomToHundredAction(ZoomActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.zoom(context.getPercentZoom());
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleZoomToTwoHundredAction(ZoomActionContext context) {
        FSTab currentTab = this.getCurrentTab();
        currentTab.zoom(context.getPercentZoom());
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleDocumentUpdateAction(DocumentUpdateActionContext context) {

        FSTab currentTab = this.getCurrentTab();
        
        currentTab.replaceText(context.getContent());
        
        
    }


    /**
     *
     * @param context
     */
    @Override
    public void handleValidateAction(ValidateActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleUndoAction(UndoActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param context
     */
    @Override
    public void handleRedoAction(RedoActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleExitAction(ExitActionContext context) {
        
        FSViewManager.close();
       
    }
    

}
