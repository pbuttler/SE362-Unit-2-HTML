
package editor.validator;

import articles.outlineView.XMLEditorKit;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.print.DocFlavor.URL;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.w3c.tidy.Node;
import org.w3c.tidy.Tidy;
import org.xml.sax.SAXException;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
*/

/**
 *
 * @author naw7961
 */
public class EditorChecker  {
    
    JEditorPane edit = new JEditorPane();
    /**
     * @param currentBuffer
     * @return
     */
    public boolean validator(String editorPaneHTML) {
        edit.setEditorKit(new XMLEditorKit());        
        edit.setText(editorPaneHTML);
        if (edit.getText().trim().equals("")) {
            return false;
        } else {
            return true;
        }
        
    }
        
}
