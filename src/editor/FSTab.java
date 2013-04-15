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
import jsyntaxpane.DefaultSyntaxKit;


/**
 *
 * @author innod_000
 */
public class FSTab extends JPanel {
    private JEditorPane _editorPane;
    
    private String _title;
    
    public FSTab() {
        DefaultSyntaxKit.initKit();
        _editorPane = new JEditorPane();
        
        this.setLayout(new GridLayout(1,1));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(_editorPane);
        _editorPane.setContentType("text/XML");
        this.add(scrollPane);
        
    
    }
    

    public FSTab(String tabName, String textAreaContents) {
        
        this();
        
        _title = tabName;
        
        _editorPane.setText(textAreaContents);
        
    }
    
    public String getTitle() {
        
        return _title;
        
    }
    
    public String getContent() {
        
        return _editorPane.getText();
        
    }
    
    public void addEditorActionListener(DocumentListener lister) {
        
        _editorPane.getDocument().addDocumentListener(lister);
        
    }
}
    
  
