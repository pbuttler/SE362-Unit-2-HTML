/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import actioncontext.GeneralActionContext;
import editor.actioncontext.NewFileActionContext;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import viewcontroller.GeneralView;
import viewcontroller.GeneralViewGUI;

/**
 *
 * @author Isioma
 */
public class EditorViewGUI extends EditorView implements GeneralViewGUI {

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
       
       _tabs.add("New Tab", new FSTab());
       
       
       
       
   
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

    
    public void displayOutput(GeneralActionContext context) {
        
        if ( context instanceof NewFileActionContext ) {
            this.addBlankTab();
        }
        
    }
    
    
    
    private void addBlankTab() {
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">";
        String contents = docType + "\n<html>\n</html>";

        this.addTab("New File", contents);
    }
    
    private void addTab(String tabName, String textAreaContents) {

        FSTab newPanel = new FSTab(tabName, textAreaContents);

        _tabs.add(tabName, newPanel);

        _tabs.setSelectedIndex(_tabs.getTabCount() - 1);

    }
    
}
