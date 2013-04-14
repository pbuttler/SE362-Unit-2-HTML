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
    JEditorPane editorPane;
    
    public FSTab() {
        
        editorPane = new JEditorPane();
        
        this.setLayout(new GridLayout(1,1));
        
        this.add(editorPane);
    
    }
}
    
  
