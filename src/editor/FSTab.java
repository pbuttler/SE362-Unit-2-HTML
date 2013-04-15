/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentListener;


/**
 *
 * @author innod_000
 */
public class FSTab extends JPanel {
    private JEditorPane _editorPane;
    
    private String _tabName;
    
    public FSTab() {
        
        _editorPane = new JEditorPane();
        
        this.setLayout(new GridLayout(1,1));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(_editorPane);
        
        this.add(scrollPane);
        
    
    }

    public FSTab(String tabName, String textAreaContents) {
        
        this();
        
        _tabName = tabName;
        
        _editorPane.setText(textAreaContents);
        
    }
    
    public void addEditorActionListener(DocumentListener lister) {
        _editorPane.getDocument().addDocumentListener(lister);
    }
}
    
  
