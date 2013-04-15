package articles.outlineView;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.IOException;

// Makes a new window with the string given to contructor in outline view
// So just pass string of jeditorpanes value, then set this object to visible
// - Luke
public class OutlineView extends JFrame {
    
    JEditorPane edit = new JEditorPane();
    private boolean noError = true;
    
    public OutlineView(String editorPaneHTML) {
        super("Outline View");
        edit.setEditorKit(new XMLEditorKit());        
        edit.setText(editorPaneHTML);
        if (edit.getText().trim().equals("")) {
            noError = false;
        }
        this.getContentPane().add(new JScrollPane(edit));
        this.setSize(620, 450);
        this.setLocationRelativeTo(null);

    }

    /**
     * @return the noError
     */
    public boolean isNoError() {
        return noError;
    }

    /**
     * @param noError the noError to set
     */
    public void setNoError(boolean noError) {
        this.noError = noError;
    }

    
   
}
