/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.htmleditor;

import common.ObservableBuffer;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author innod_000
 */
public class FiveSecondsTab extends JPanel implements KeyListener {
    
    public final JTextArea textArea;
    public ObservableBuffer buffer;
    public String tabName;
    public FiveSecondsTab(String tabName, String textAreaContents) {
        super(new GridLayout(1, 1));

        this.tabName = tabName;
        textArea = new JTextArea();
        textArea.setText(textAreaContents);
        
        textArea.addKeyListener(this);
        
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
    public void keyTyped(KeyEvent ke) {
        
        this.insertContent(ke.getKeyChar() + "");
        
        
        this.updateBuffer();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
