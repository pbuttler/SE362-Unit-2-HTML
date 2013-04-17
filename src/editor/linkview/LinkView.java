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
public class LinkView {
   
    JEditorPane split1 = new JEditorPane();
    JEditorPane split2 = new JEditorPane();
    
    public static void main(String[] args) {
        LinkView l = new LinkView();
        String h = "<html xmlns=\'http://www.w3.org/1999/xhtml\' xml:lang=\'en\' lang=\'en\'> <head> <a href='http://Stackoverflow.com'>StackOverflow</a> <meta http-equiv=\'Content-Type\' content=\'text/html; charset=utf-8\' /> <a href='http://google.com'>Google</a><title>XHTML 1.0 Strict Example</title> <script type=\'text/javascript\'> //<![CDATA[ function loadpdf() { document.getElementById(\'pdf-object\').src=\'http://www.w3.org/TR/xhtml1/xhtml1.pdf\'; } //]]> </script> </head> <body onload=\'loadpdf()\'> <p>This is an example of an <abbr title=\'Extensible HyperText Markup Language\'>XHTML</abbr> 1.0 Strict document.<br /> <img id=\'validation-icon\' src=\'http://www.w3.org/Icons/valid-xhtml10\' alt=\'Valid XHTML 1.0 Strict\' /><br /> <object id=\'pdf-object\' name=\'pdf-object\' type=\'application/pdf\' data=\'http://www.w3.org/TR/xhtml1/xhtml1.pdf\' width=\'100%\' height=\'500\'> </object> </p> </body> </html>";
        l.split1.setText(h);
        JFrame j = l.getPopupView(h);
        j.setVisible(true);
    }
    
    public LinkView() {
        split2.setContentType("text/html");
        split2.setEditable(false);
//        split2.addHyperlinkListener(new HyperlinkListener() {
//                    @Override
//                    public void hyperlinkUpdate(HyperlinkEvent hle) {
//                        if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
//                            System.out.println(hle.getURL());
//                            Desktop desktop = Desktop.getDesktop();
//                            try {
//                                desktop.browse(hle.getURL().toURI());
//                            } catch (Exception ex) {
//                                ex.printStackTrace();
//                            }
//                        }
//                    }
//                });
    }
    
    // Returns JPanel with LV and JEP. user must give string though
    public JPanel getSplitView(String html) {
        split1.setText(html);
        JPanel panel = new JPanel(new GridLayout(2, 1));
        // For the link view
        //TODO: Make split2 have the right link view content
        updateLinkView(html);
        
        panel.add(new JScrollPane(split2));
        panel.add(new JScrollPane(split1));
        return panel;
    }
    
    // Sets split2 text to specifed string
    // Can be called on refresh, and on insertion of a href, or just on a click!
    public void updateLinkView(String html) {
        Document doc = Jsoup.parse(html);
        // get all a tags with the attribute href
        Elements e = doc.select("a[href]");
        Iterator i = e.iterator();
        String content = "";
        
        while (i.hasNext()) {
            Element href = (Element)i.next();
            System.out.println(href+":"+href.attr("href"));
            content += "<h1>" + href.attr("href") + ":" + href + "</h1>";
        }
        
        split2.setText(content);
        
    }
    
    // Returns a JFrame with the LinkView
    public JFrame getPopupView(String html) { 
        split1.setText(html);
        // Do code to make JEditorPane show the link view
        updateLinkView(html);
        JScrollPane jsp = new JScrollPane(split2);
        
        JFrame f = new JFrame();
        f.getContentPane().add(jsp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(620, 450);
        f.setLocationRelativeTo(null);
        
        return f;
    }
}
