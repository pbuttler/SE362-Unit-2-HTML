package articles.outlineView;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

// Makes a new window with the string given to contructor in outline view
// So just pass string of jeditorpanes value, then set this object to visible
// - Luke
public class OutlineView extends JFrame {
    
    JEditorPane edit = new JEditorPane();
    
    public OutlineView(String editorPaneHTML) {
        super("Outline View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        edit.setEditorKit(new XMLEditorKit());
        edit.setText(editorPaneHTML);

        this.getContentPane().add(new JScrollPane(edit));

        this.setSize(620, 450);
        this.setLocationRelativeTo(null);

    }
}
