/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import articles.collapse.CollapsibleEditorKit;
import articles.collapse.CollapsibleView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.View;

/**
 * So basically, this is a JEditorpane that has collapsability in it.
 * see the makeCollapsableArea and clearCollapsableArea?
 * - You call makeCollapsableArea when you have a section highlighted.
 * - You call clearCollapasableArea when your cursor is in a collapsable area duh
 * - idk how you wanna shove this in. heck, you could wire a shortcut to those 2 methods. but...they work.
 * - all you have to do is make sure you jeditorpanes are instances of this. and then call those methods when you have material selected / you are in a collapse.
 * - understand?
 * @author Luke
 */
public class collapsableJEditorPane extends JEditorPane {
    public collapsableJEditorPane() {
        super();
        final SimpleAttributeSet attrs=new SimpleAttributeSet();

        setEditorKit(new CollapsibleEditorKit());
        Document doc= collapsableJEditorPane.this.getDocument();
        try {
            doc.insertString(doc.getLength(), "Par before area\n", new SimpleAttributeSet());
            doc.insertString(doc.getLength(), "Par after area\n", new SimpleAttributeSet());

            DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[10];
            DefaultStyledDocument.ElementSpec closePar = new DefaultStyledDocument.ElementSpec(attrs, DefaultStyledDocument.ElementSpec.EndTagType);
            specs[0]=closePar;

            attrs.addAttribute(DefaultStyledDocument.ElementNameAttribute, CollapsibleEditorKit.COLLAPSIBLE_AREA_ELEMENT);
            DefaultStyledDocument.ElementSpec areaStart = new DefaultStyledDocument.ElementSpec(attrs, DefaultStyledDocument.ElementSpec.StartTagType);
            specs[1]=areaStart;

            DefaultStyledDocument.ElementSpec parStart = new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), DefaultStyledDocument.ElementSpec.StartTagType);
            specs[2]=parStart;
            String text="Click on the area mark in the top left corner to collapse/expand area.\n";
            DefaultStyledDocument.ElementSpec parContent = new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), DefaultStyledDocument.ElementSpec.ContentType, text.toCharArray(), 0, text.length() );
            specs[3]=parContent;
            DefaultStyledDocument.ElementSpec parEnd = new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), DefaultStyledDocument.ElementSpec.EndTagType);
            specs[4]=parEnd;
            parStart = new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), DefaultStyledDocument.ElementSpec.StartTagType);
            specs[5]=parStart;
            text="To create another collapsible area select appropriate fragment and click on the button on toolbar. The old area will be removed and a new one will be created.\n";parContent = new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), DefaultStyledDocument.ElementSpec.ContentType, text.toCharArray(), 0, text.length());
            specs[6]=parContent;
            parEnd = new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), DefaultStyledDocument.ElementSpec.EndTagType);
            specs[7]=parEnd;

            DefaultStyledDocument.ElementSpec areaEnd = new DefaultStyledDocument.ElementSpec(attrs, DefaultStyledDocument.ElementSpec.EndTagType);
            specs[8]=areaEnd;

            DefaultStyledDocument.ElementSpec openPar = new DefaultStyledDocument.ElementSpec(attrs, DefaultStyledDocument.ElementSpec.StartTagType);
            specs[9]=openPar;


            insertSpecs((DefaultStyledDocument)doc, 16, specs);

        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.isControlDown()) {
                    int offs=viewToModel(e.getPoint());
                    CollapsibleView cv=getCollapsibleView(offs);
                    cv.setExpanded(!cv.isExpanded());
                    DefaultStyledDocument doc= (DefaultStyledDocument)collapsableJEditorPane.this.getDocument();
                    try {
                        doc.insertString(offs, "\n", new SimpleAttributeSet());
                        doc.remove(offs,1);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();  
                    }
                }
            }
        });
    }

    protected void insertSpecs(DefaultStyledDocument doc, int offset, DefaultStyledDocument.ElementSpec[] specs) {
        try {
//            doc.insert(0, specs);  method is protected so we have to
            //extend document or use such a hack
            Method m=DefaultStyledDocument.class.getDeclaredMethod("insert", new Class[] {int.class, DefaultStyledDocument.ElementSpec[].class});
            m.setAccessible(true);
            m.invoke(doc, new Object[] {offset, specs});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected CollapsibleView getCollapsibleView(int offset) {
        View v=getUI().getRootView(this);
        while( v!=null && v.getViewCount()>0) {
            if (v instanceof CollapsibleView) {
                return (CollapsibleView)v;
            }
            int i=v.getViewIndex(offset, Position.Bias.Forward);
            if (i>=0 && i<v.getViewCount()) {
                v=v.getView(i);
            }
            else {
                break;
            }
        }

        return null;
    }

    protected void makeCollapsibleArea() {
        try {
            int start=getSelectionStart();
            int end=getSelectionEnd();
            if (start==end) {
                return;
            }
            clearCollapsibleArea();
            if (start>end) {
                int tmp=start;
                start=end;
                end=tmp;
            }

            DefaultStyledDocument doc=(DefaultStyledDocument)getDocument();
            start=(doc).getParagraphElement(start).getStartOffset();
            end=doc.getParagraphElement(end).getEndOffset();

            ArrayList<DefaultStyledDocument.ElementSpec> specs=new ArrayList<DefaultStyledDocument.ElementSpec>();
            DefaultStyledDocument.ElementSpec spec;
            int offs=start;
            while (offs<end) {
                Element par=doc.getParagraphElement(offs);

                spec=new DefaultStyledDocument.ElementSpec(par.getAttributes(), DefaultStyledDocument.ElementSpec.StartTagType);
                specs.add(spec);
                for (int i=0; i<par.getElementCount(); i++) {
                    Element leaf=par.getElement(i);
                    String text=doc.getText(leaf.getStartOffset(), leaf.getEndOffset()-leaf.getStartOffset());
                    spec=new DefaultStyledDocument.ElementSpec(leaf.getAttributes(),DefaultStyledDocument.ElementSpec.ContentType, text.toCharArray(), 0, text.length());
                    specs.add(spec);
                }
                spec=new DefaultStyledDocument.ElementSpec(par.getAttributes(), DefaultStyledDocument.ElementSpec.EndTagType);
                specs.add(spec);

                offs=par.getEndOffset();
            }

            doc.remove(start, end-start);
            DefaultStyledDocument.ElementSpec[] specArray = new DefaultStyledDocument.ElementSpec[specs.size()+4];
            DefaultStyledDocument.ElementSpec closePar = new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), DefaultStyledDocument.ElementSpec.EndTagType);
            specArray[0]=closePar;

            SimpleAttributeSet attrs=new SimpleAttributeSet();
            attrs.addAttribute(DefaultStyledDocument.ElementNameAttribute, CollapsibleEditorKit.COLLAPSIBLE_AREA_ELEMENT);
            DefaultStyledDocument.ElementSpec areaStart = new DefaultStyledDocument.ElementSpec(attrs, DefaultStyledDocument.ElementSpec.StartTagType);
            specArray[1]=areaStart;

            for (int i=0; i<specs.size(); i++) {
                specArray[i+2]=specs.get(i);
            }

            DefaultStyledDocument.ElementSpec areaEnd = new DefaultStyledDocument.ElementSpec(attrs, DefaultStyledDocument.ElementSpec.EndTagType);
            specArray[specArray.length-2]=areaEnd;

            DefaultStyledDocument.ElementSpec openPar = new DefaultStyledDocument.ElementSpec(attrs, DefaultStyledDocument.ElementSpec.StartTagType);
            specArray[specArray.length-1]=openPar;

            insertSpecs(doc, start, specArray);
        } catch (BadLocationException e) {
            e.printStackTrace();  
        }
    }
    
    protected void clearCollapsibleArea() {
        try {
            DefaultStyledDocument doc=(DefaultStyledDocument)getDocument();
            Element root=doc.getDefaultRootElement();
            for (int i=0; i<root.getElementCount(); i++) {
                Element elem=root.getElement(i);
                if (CollapsibleEditorKit.COLLAPSIBLE_AREA_ELEMENT.equals(elem.getName())) {
                    ArrayList<DefaultStyledDocument.ElementSpec> specs=new ArrayList<DefaultStyledDocument.ElementSpec>();
                    DefaultStyledDocument.ElementSpec spec;
                    for (int j=0; j<elem.getElementCount(); j++) {
                        Element par=elem.getElement(j);
                        spec=new DefaultStyledDocument.ElementSpec(par.getAttributes(), DefaultStyledDocument.ElementSpec.StartTagType);
                        specs.add(spec);
                        for (int k=0; k<par.getElementCount(); k++) {
                            Element leaf=par.getElement(k);
                            String text=doc.getText(leaf.getStartOffset(), leaf.getEndOffset()-leaf.getStartOffset());
                            spec=new DefaultStyledDocument.ElementSpec(leaf.getAttributes(),DefaultStyledDocument.ElementSpec.ContentType, text.toCharArray(), 0, text.length());
                            specs.add(spec);
                        }
                        spec=new DefaultStyledDocument.ElementSpec(par.getAttributes(), DefaultStyledDocument.ElementSpec.EndTagType);
                        specs.add(spec);
                    }

                    int start=elem.getStartOffset();
                    doc.remove(start, elem.getEndOffset()-start);

                    DefaultStyledDocument.ElementSpec[] specArray = new DefaultStyledDocument.ElementSpec[specs.size()+2];
                    DefaultStyledDocument.ElementSpec closePar = new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), DefaultStyledDocument.ElementSpec.EndTagType);
                    specArray[0]=closePar;

                    for (int j=0; j<specs.size(); j++) {
                        specArray[j+1]=specs.get(j);
                    }

                    DefaultStyledDocument.ElementSpec openPar = new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), DefaultStyledDocument.ElementSpec.StartTagType);
                    specArray[specArray.length-1]=openPar;

                    insertSpecs(doc, start, specArray);
                    break;
                }
            }
        } catch (BadLocationException e) {
            e.printStackTrace();  
        }
    }
}
