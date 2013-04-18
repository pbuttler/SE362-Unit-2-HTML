/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
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
public class FSTab extends JPanel implements KeyListener {

    private JEditorPane _editorPane;
    private String _title;
    private static final int DEFAULT_FONT_SIZE = 12;
    private static final int DEFAULT_FONT_INCREMENT = DEFAULT_FONT_SIZE / 2;
    private int currentFontSize;
    private int _bufferId;
    private DocumentListener _parent;
    private IndentBreakAction indentAction;

    /**
     *
     */
    public FSTab() {
        _editorPane = new JEditorPane();


        this.setLayout(new GridLayout(1, 1));

        
        this.setLayout(new GridLayout(1,1));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(_editorPane);
        this.add(scrollPane);
        ActionMap am = _editorPane.getActionMap();

        indentAction = new IndentBreakAction();

        am.put(DefaultEditorKit.insertBreakAction, indentAction);


        currentFontSize = DEFAULT_FONT_SIZE;

        zoom(100);

    }

    public void toggleAutoIndent() {
        boolean aiEnabled = indentAction.isActive();
        indentAction.setActive(!aiEnabled);
    }

    /**
     *
     * @param tabName
     * @param textAreaContents
     */
    public FSTab(String tabName, String textAreaContents) {

        this();

        _title = tabName;

        _editorPane.setText(textAreaContents);

    }

    public void setBufferId(int id) {
        _bufferId = id;
    }

    public int getBufferId() {
        return _bufferId;
    }

    /**
     *
     * @return
     */
    public String getTitle() {

        return _title;

    }

    public void setTitle(String title) {
        _title = title;
    }

    /**
     *
     * @return
     */
    public String getContent() {

        return _editorPane.getText();

    }

    /**
     *
     * @param textToInsert
     */
    public void insertContent(String textToInsert) {
        insertContent(textToInsert, _editorPane.getCaretPosition());
    }

    /**
     *
     * @param textToInsert
     * @param position
     */
    public void insertContent(String textToInsert, int position) {
        try {
            this._editorPane.getDocument().insertString(position, textToInsert, null);
        } catch (BadLocationException ex) {
            Logger.getLogger(FSTab.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param listener
     */
    public void addEditorActionListener(DocumentListener listener) {

        _parent = listener;
        _editorPane.getDocument().addDocumentListener(_parent);

        _editorPane.addKeyListener(this);

    }

    /**
     *
     * @param level
     */
    public void inserthxHeaderElement(int level) {
        this.insertSimpleElement("h" + level);
    }

    /**
     *
     * @param content
     */
    public void insertSimpleElement(String content) {
        String textToInsert = this.createSimpleElement(content);
        this.insertContent(textToInsert);
    }

    /**
     *
     * @param numberOfItems
     * @return
     */
    public String createUnorderedListElement(int numberOfItems) {

        String textToInsert = "\n<ul>\n";

        for (int i = 0; i < numberOfItems; i++) {
            textToInsert += "\t<li></li>\n";
        }

        textToInsert += "</ul>\n";


        return textToInsert;
    }

    /**
     *
     * @param numRows
     * @param numCols
     * @return
     */
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

    /**
     *
     * @param tagName
     * @return
     */
    public String createSimpleElement(String tagName) {
        String textToInsert = String.format("\n<%s></%s>\n", tagName, tagName);
        return textToInsert;
    }

    /**
     *
     */
    public void cut() {
        this._editorPane.cut();
    }

    /**
     *
     */
    public void copy() {
        this._editorPane.copy();
    }

    /**
     *
     */
    public void paste() {
        this._editorPane.paste();

    }

    /**
     *
     */
    public void indentSelection() {
    }

    public void zoom(int percent) {


        int newFontSize = DEFAULT_FONT_SIZE;

        if (100 != percent) {
//            float factor = ((float) percent) / 100;
//            newFontSize= (int) (currentFontSize * factor);

            if (percent > 100) {
                newFontSize = currentFontSize + DEFAULT_FONT_INCREMENT;
            }

            if (percent < 100) {

                newFontSize = currentFontSize - DEFAULT_FONT_INCREMENT;

                if (newFontSize < DEFAULT_FONT_INCREMENT) {
                    newFontSize = DEFAULT_FONT_INCREMENT;
                }

            }

        }

        setFontSize(newFontSize);
        currentFontSize = newFontSize;

    }

    
    public void setLineWrap(boolean x){
        this.setLineWrap(x);
    }
    
    private void setFontSize(int size) {
        int f = this.getFont().getStyle();
        Font newFont = new Font("monospaced", f, size);
        this._editorPane.setFont(newFont);
    }

    public void refreshEditorPane(String replacement) {

        this._editorPane.getDocument().removeDocumentListener(_parent);
//            this._editorPane.getDocument().remove(0, this._editorPane.getDocument().getLength());
        this._editorPane.setText(replacement);

        this._editorPane.getDocument().addDocumentListener(_parent);

//            this.insertContent(replacement);

    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == '\t') {
            int startLine, endLine;

            System.out.println("HERE!!");

            int start = _editorPane.getSelectionStart();
            int end = _editorPane.getSelectionEnd();

            startLine = _editorPane.getDocument().getDefaultRootElement().getElementIndex(start);
            endLine = _editorPane.getDocument().getDefaultRootElement().getElementIndex(end);

            int numLines = (endLine - startLine) + 1;
            if (e.isShiftDown()) {
                this.removeTabs(startLine, numLines);
                

            } else {
                if (numLines != 1) {
                    addTabs(startLine, numLines);
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addTabs(int startLine, int numLines) {
        
        Document doc = _editorPane.getDocument();
        Element rootElement = doc.getDefaultRootElement();
//        int line = rootElement.getElementIndex(selectionStart);

        //  Get the text for this line
        String replacement = "";
        for (int i = 0; i < numLines; i++ ) {
            int line = startLine + i;
            int start = rootElement.getElement(line).getStartOffset();
            int end = rootElement.getElement(line).getEndOffset();
            int length = end - start;
        
            String text = "";
            try {
                text = doc.getText(start, length);
            } catch (BadLocationException ex) {
                Logger.getLogger(FSTab.class.getName()).log(Level.SEVERE, null, ex);
            }
            replacement += "\t" + text;
            
        }
        
            
        _editorPane.replaceSelection(replacement);
            
        
    }

    private void removeTabs(int startLine, int numLines) {
        Document doc = _editorPane.getDocument();
        Element rootElement = doc.getDefaultRootElement();
//        int line = rootElement.getElementIndex(selectionStart);

        //  Get the text for this line
        String replacement = "";
        for (int i = 0; i < numLines; i++ ) {
            int line = startLine + i;
            int start = rootElement.getElement(line).getStartOffset();
            int end = rootElement.getElement(line).getEndOffset();
            int length = end - start;
        
            String text = "";
            try {
                text = doc.getText(start, length);
            } catch (BadLocationException ex) {
                Logger.getLogger(FSTab.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            if ( text.charAt(0) == ' ' || text.charAt(0) == '\t') {
                text = text.substring(1);
            }
            
            replacement += text;
            
        }
        
            
        _editorPane.replaceSelection(replacement);
    }

    // Indent code
    /**
     *
     */
    public static class IndentBreakAction extends TextAction {

        private boolean active;

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        /**
         * Creates this object with the appropriate identifier.
         */
        public IndentBreakAction() {
            super(DefaultEditorKit.insertBreakAction);
            active = true;

        }

        /**
         * The operation to perform when this action is triggered.
         *
         * @param e the action event
         */
        public void actionPerformed(ActionEvent e) {


            JTextComponent target = getTextComponent(e);

            if (target == null) {
                return;
            }

            if ((!target.isEditable()) || (!target.isEnabled())) {
                UIManager.getLookAndFeel().provideErrorFeedback(target);
                return;
            }
            //  Determine which line we are on

            String newLine = "\n";

            if (this.active) {
                Document doc = target.getDocument();
                Element rootElement = doc.getDefaultRootElement();
                int selectionStart = target.getSelectionStart();
                int line = rootElement.getElementIndex(selectionStart);

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
                //  Get the number of white spaces characters at the start of the line

                String tabPrefix = "";
                for (int i = 0; i < length; i++) {
                    char c = text.charAt(i);
                    if (c == ' ' || c == '\t') {
                        tabPrefix += c;
                    } else {
                        break;
                    }
                }

                newLine += tabPrefix;
            }

            target.replaceSelection(newLine);

//            for (offset = 0; offset < length; offset++) {
//                char c = text.charAt(offset);
//                if (c != ' ' && c != '\t') {
//                    break;
//                }
//            }

            //  When splitting the text include white space at start of line
            //  else do default processing

//            if (selectionStart - start > offset) {
//                target.replaceSelection("\n" + text.substring(0, offset));
//            } else {
//                target.replaceSelection("\n");
//            }

        }
    }
}
