/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ActionMap;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;


/**
 *
 * @author innod_000
 */
public class FSTab extends JPanel {
    private JEditorPane _editorPane;
    private String _title;
    
    public FSTab() {
        _editorPane = new JEditorPane();
        
        
        this.setLayout(new GridLayout(1,1));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(_editorPane);
        this.add(scrollPane);
        ActionMap am = _editorPane.getActionMap();
        am.put(DefaultEditorKit.insertBreakAction, new IndentBreakAction());
    
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
    
    
    // Indent code
     public static class IndentBreakAction extends TextAction {
         /**
         * Creates this object with the appropriate identifier.
         */
        public IndentBreakAction()
        {
            super(DefaultEditorKit.insertBreakAction);
        }
 
        /**
         * The operation to perform when this action is triggered.
         *
         * @param e the action event
         */
        public void actionPerformed(ActionEvent e)
        {
            JTextComponent target = getTextComponent(e);
 
            if (target == null) return;
 
            if ((! target.isEditable()) || (! target.isEnabled()))
            {
                UIManager.getLookAndFeel().provideErrorFeedback(target);
                return;
            }
                //  Determine which line we are on
 
                Document doc = target.getDocument();
                Element rootElement = doc.getDefaultRootElement();
                int selectionStart = target.getSelectionStart();
                int line = rootElement.getElementIndex( selectionStart );
 
                //  Get the text for this line
 
                int start = rootElement.getElement(line).getStartOffset();
                int end = rootElement.getElement(line).getEndOffset();
                int length = end - start;
                String text = "";
                try {
                    text = doc.getText(start, length);
                } catch (BadLocationException ex) {
                    Logger.getLogger(FSTab.class.getName()).log(Level.SEVERE, null, ex);
                }
                int offset = 0;
 
                //  Get the number of white spaces characters at the start of the line
 
                for (offset = 0; offset < length; offset++)
                {
                    char c = text.charAt(offset);
                    if (c != ' ' && c != '\t')
                        break;
                }
 
                //  When splitting the text include white space at start of line
                //  else do default processing
 
                if (selectionStart - start > offset) {
                    target.replaceSelection("\n" + text.substring(0, offset) );
                }
                else {
                    target.replaceSelection("\n");  
                }
        }
    } 
}
    
  
