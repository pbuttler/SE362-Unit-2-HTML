/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.htmleditor;

import common.ObservableBuffer;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author innod_000
 */
public class FiveSecondsTab extends JPanel implements DocumentListener {
    
    public final JTextArea textArea;
    public ObservableBuffer buffer;
    public String tabName;
    public FiveSecondsTab(String tabName, String textAreaContents) { //, KeyListener parentListener) {
        super(new GridLayout(1, 1));

        this.tabName = tabName;
        textArea = new JTextArea();
        textArea.setText(textAreaContents);
        
//        textArea.addKeyListener(parentListener);
        textArea.getDocument().addDocumentListener(this);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(textArea);
        
        this.add(scrollPane);
        
        this.buffer = new ObservableBuffer(textAreaContents);
    }

    public void append(String text) {
        textArea.append(text);
        this.updateBuffer();
    }

    public String getText() {
        return textArea.getText();
        
    }
    
    public String getTabName() {
    return this.tabName;
    }
    
    public void insertContent(String textToInsert) {
        this.textArea.insert(textToInsert, this.textArea.getCaretPosition());
        this.updateBuffer();
    }
    
    public void insertContent(String textToInsert, int position) {
        this.textArea.insert(textToInsert, position);
        this.updateBuffer();
    }

    public void updateBuffer() {
        String text = this.getText();
        buffer.updateContents(text);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.updateBuffer();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.updateBuffer();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.updateBuffer();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    public void insertH3() {
     this.inserthxHeaderElement(3);
    }
    
    public void insertH2() {
     this.inserthxHeaderElement(2);
    }
    
    public void insertH1() {
     this.inserthxHeaderElement(1);
    }
    
    private void inserthxHeaderElement(int level) {
        this.insertSimpleElement("h" + level);
    }
    
    private void insertSimpleElement(String content) {
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


    private String createSimpleElement(String tagName) {
        String textToInsert = String.format("\n<%s></%s>\n", tagName, tagName);
        return textToInsert;
    }

    void insertBold() {
        this.insertSimpleElement("b");
    }

    void insertImage(String url, String altText) {
        this.insertContent("<img src=\""+ url + "\" alt=\"" + altText + "\">");
    }

    void insertParagraph() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertUnderline() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertItalics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String save(File file) throws IOException {

            BufferedWriter bufferedWriter = null;
            try {
                
                if (!file.exists()) {
                    file.createNewFile();
                }
                
                bufferedWriter =  new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(this.getText());
                
                return file.getName();
                
               
            } catch (IOException ex) {
                throw ex;
            }finally {
                //Close the BufferedWriter
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
    }
    
}
