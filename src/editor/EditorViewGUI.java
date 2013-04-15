/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import actioncontext.GeneralActionContext;
import editor.actioncontext.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
   
   public EditorViewGUI() {
   
       _mainPanel = new JPanel();
       _tabs = new FSTabbedPane();
       
       GroupLayout mainPanelLayout = new GroupLayout(_mainPanel);
       
       _mainPanel.setLayout(mainPanelLayout);

       mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(_tabs, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
       
       mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_tabs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );
       
       
       
       
   
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
        _mainPanel.setVisible( visible );
    }

    
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * So display output is given the context in a switch. 
     * Follow the method you want
     * - Luke
    **/
    public void displayOutput(GeneralActionContext context) {
        
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
    
    
    
    private void addBlankTab() {
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">";
        String contents = docType + "\n<html>\n</html>";

        this.addTab("New File", contents);
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
     * Actions in GUI handled here. and we're done :)
     * - Luke
     **/
    
   
    
    /** DocumentListener methods **/
    
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

    @Override
    public void changedUpdate(DocumentEvent de) {
        
    }
    
    /** Handle GUI Actions **/
    
     public void handleNewFileAction(NewFileActionContext context) {
        this.addBlankTab();
    }

    public void handleOpenFileAction(OpenFileActionContext context) {

        this.addTab(context.getTitle(), context.getContents());
        
    }
    
    public void handleSaveAction(SaveFileActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void handleSaveAsAction(SaveFileAsActionContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
//        System.out.println(context.getContent());
        
    }
    
}
