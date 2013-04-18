/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.linkview;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.util.Iterator;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
public class LinkView extends JPanel {
   
    JEditorPane split = new JEditorPane();
    
    // For Testing purposes
    
     // Constuctor adds JEP with html to the panel 
    public LinkView(String html) {
        split.setContentType("text/html");
        split.setEditable(false);
        updateLinkView(html);
        split.addHyperlinkListener(new HyperlinkListener() {
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
        this.setLayout(new BorderLayout(1,1));
        this.add(split);
     }
    
    // Sets the link view
    public void updateLinkView(String html) {
        Document doc = Jsoup.parse(html);
        // get all a tags with the attribute href
        Elements e = doc.select("a[href]");
        Iterator i = e.iterator();
        String content = "";
        
        while (i.hasNext()) {
            Element href = (Element)i.next();
            System.out.println(href+":"+href.attr("href"));
            content += "<h1>" + href.attr("href") + "-" + href + "</h1>";
        }
        
        split.setText(content);
        
    }
    
    public JFrame returnPopupView(String html) { 
         // Do code to make JEditorPane show the link view
         updateLinkView(html);
        JFrame frame = new JFrame();
        JScrollPane jsp = new JScrollPane(split);
        frame.getContentPane().add(jsp);
        frame.setSize(620, 450);
        frame.setLocationRelativeTo(null);
        return frame;
    }
}
