/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.awt.Desktop;
import java.util.Iterator;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Luke
 */
public class ImageDictionary extends JFrame {
    
    // Just for testing
    public static void main(String[] args) {
        ImageDictionary id = new ImageDictionary("<html> <head> <img src='smiley.gif' alt='Smiley face' width='42' height='42'> <title>An example HTMLDocument</title> <style type='text/css'> div { background-color: silver; } ul { color: red; } </style> </head> <body> <img src='smiley.gif' alt='Smiley face' width='42' height='42'> <div id='BOX'> <p>Paragraph 1</p> <img src='smiley.gif' alt='Smiley face' width='42' height='42'> <p>Paragraph 2</p> </div> </body> </html>");
        id.setVisible(true);
    }
    
    // All you have to do is set visible
    public ImageDictionary(String html) {
        Document doc = Jsoup.parse(html);
        Elements e = doc.select("img[src]");
        JEditorPane jep = new JEditorPane();
        jep.setContentType("text/html");
        jep.setEditable(false);
        jep.addHyperlinkListener(new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent hle) {
                        if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                            System.out.println(hle.getURL());
                            Desktop desktop = Desktop.getDesktop();
                            try {
                                desktop.browse(hle.getURL().toURI());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
        Iterator i = e.iterator();
        String content = "";
        
        while (i.hasNext()) {
            Element src = (Element)i.next();
            System.out.println(src+":"+src.attr("src"));
            content += "<h1>" + src.attr("src") + " - " + src + "</h1>";
        }
        jep.setText(content);
        JScrollPane jsp = new JScrollPane(jep);
        this.getContentPane().add(jsp);
        this.setSize(620, 450);
        this.setLocationRelativeTo(null);
    }
}
