/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;
import java.awt.Font;
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
    
    public void insertContent(String textToInsert) {
        insertContent(textToInsert, _editorPane.getCaretPosition());
    }
    
    public void insertContent(String textToInsert, int position) {
         try {
            this._editorPane.getDocument().insertString(position, textToInsert, null);
        } catch (BadLocationException ex) {
            Logger.getLogger(FSTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addEditorActionListener(DocumentListener lister) {
        
        _editorPane.getDocument().addDocumentListener(lister);
        
    }
    

    public void inserthxHeaderElement(int level) {
        this.insertSimpleElement("h" + level);
    }
    
    public void insertSimpleElement(String content) {
        String textToInsert = this.createSimpleElement(content);
        this.insertContent(textToInsert);
    }
    
    public String createUnorderedListElement(int numberOfItems) {

        String textToInsert = "\n<ul>\n";

        for (int i = 0; i < numberOfItems; i++) {
            textToInsert += "\t<li></li>\n";
        }

        textToInsert += "</ul>\n";


        return textToInsert;
    }
    
    public String createTableElement(int numRows, int numCols) {
        String textToInsert = "\n<table>";
        int currRow = 0;
        int currCol;

        // jTextArea1.insert("<table>", jTextArea1.getCaretPosition());

        String rowsToInsert = "";

        currCol = 0;
        while (currCol < numCols) {
            rowsToInsert += "\t<td></td>\n";

            //jTextArea1.insert("<td>     </td>", jTextArea1.getCaretPosition());

            currCol++;
        }

        while (currRow < numRows) {

            textToInsert += "\n<tr>\n";

            // jTextArea1.insert("<tr>\n", jTextArea1.getCaretPosition());

            textToInsert += rowsToInsert;

            textToInsert += "\n</tr>";

            //jTextArea1.insert("</tr>", jTextArea1.getCaretPosition());

            currRow++;
        }

        textToInsert += "\n</table>\n";

        // jTextArea1.insert("</table>", jTextArea1.getCaretPosition());



        return textToInsert;
    }


    public String createSimpleElement(String tagName) {
        String textToInsert = String.format("\n<%s></%s>\n", tagName, tagName);
        return textToInsert;
    }

    public void cut() {
        this._editorPane.cut();
    }
    
    public void copy() {
        this._editorPane.copy();
    }
    
    public void paste() {
        this._editorPane.paste();

    }

    public void indentCurrentLine() {
        
    }

    public void indentSelection() {
        
    }

    public void indentAll() {
        
    }
    
    void zoom(int percent) {
        
        if ( percent == 50 ) {
            int f = this.getFont().getStyle();
            Font newFont = new Font("", f, 15);
            this._editorPane.setFont(newFont);
        
        } else if (percent == 100 ) {
            
            int f = this.getFont().getStyle();
            Font newFont = new Font("", f, 20);
            this._editorPane.setFont(newFont);
            
        
        } else if ( percent == 200 ) {
            
            int f = this.getFont().getStyle();
            Font newFont = new Font("", f, 30);
            this._editorPane.setFont(newFont);
            
        }
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
    
  
