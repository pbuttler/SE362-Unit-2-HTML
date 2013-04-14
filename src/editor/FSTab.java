/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;
import java.awt.GridLayout;
import javax.swing.JEditorPane;
import javax.swing.JPanel;


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
        
        this.add(_editorPane);
    
    }

    public FSTab(String tabName, String textAreaContents) {
        
        this();
        
        _tabName = tabName;
        
        _editorPane.setText(textAreaContents);

        
    }
}
    
  
