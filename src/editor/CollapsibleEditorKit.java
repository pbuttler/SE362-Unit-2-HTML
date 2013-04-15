package articles.collapse;

import javax.swing.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CollapsibleEditorKit extends StyledEditorKit {
    public static String COLLAPSIBLE_AREA_ELEMENT="collapsible_area_element";
    MouseListener lstCollapse=new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            JEditorPane src=(JEditorPane)e.getSource();

            int pos=src.viewToModel(e.getPoint());
            View v=src.getUI().getRootView(src);
            while (v!=null && !(v instanceof CollapsibleView)) {
                int i=v.getViewIndex(pos, Position.Bias.Forward);
                v=v.getView(i);
            }

            if (v!=null) {
                Shape a=getAllocation(v, src);
                if (a!=null) {
                    Rectangle r=a instanceof Rectangle ? (Rectangle)a : a.getBounds();
                    r.width=CollapsibleView.AREA_SHIFT;
                    r.height=CollapsibleView.AREA_SHIFT;

                    if (r.contains(e.getPoint())) {
                        CollapsibleView cv=(CollapsibleView)v;
                        cv.setExpanded(!cv.isExpanded());

                        DefaultStyledDocument doc= (DefaultStyledDocument)src.getDocument();
                        try {
                            doc.insertString(pos, "\n", new SimpleAttributeSet());
                            doc.remove(pos,1);
                        } catch (BadLocationException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
    };

    Cursor oldCursor;
    MouseMotionListener lstMoveCollapse=new MouseMotionAdapter() {
        public void mouseMoved(MouseEvent e) {
            JEditorPane src=(JEditorPane)e.getSource();
            if (oldCursor==null) {
                oldCursor=src.getCursor();
            }

            int pos=src.viewToModel(e.getPoint());
            View v=src.getUI().getRootView(src);
            while (v!=null && !(v instanceof CollapsibleView)) {
                int i=v.getViewIndex(pos, Position.Bias.Forward);
                v=v.getView(i);
            }

            if (v!=null) {
                Shape a=getAllocation(v, src);
                if (a!=null) {
                    Rectangle r=a instanceof Rectangle ? (Rectangle)a : a.getBounds();
                    r.width=CollapsibleView.AREA_SHIFT;
                    r.height=CollapsibleView.AREA_SHIFT;

                    if (r.contains(e.getPoint())) {
                        CollapsibleView cv=(CollapsibleView)v;

                        src.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        return;
                    }
                }
            }

            src.setCursor(oldCursor);
        }
    };

    public ViewFactory getViewFactory() {
        return new CollapsibleEditorKit.StyledViewFactory();
    }
    public void install(JEditorPane c) {
        super.install(c);
        c.addMouseListener(lstCollapse);
        c.addMouseMotionListener(lstMoveCollapse);
    }
    public void deinstall(JEditorPane c) {
        c.removeMouseListener(lstCollapse);
        c.removeMouseMotionListener(lstMoveCollapse);
        super.deinstall(c);
    }

    protected static Shape getAllocation(View v, JEditorPane edit) {
        Insets ins=edit.getInsets();
        View vParent=v.getParent();
        int x=ins.left;
        int y=ins.top;
        while(vParent!=null) {
            int i=vParent.getViewIndex(v.getStartOffset(), Position.Bias.Forward);
            Shape alloc=vParent.getChildAllocation(i, new Rectangle(0,0, Short.MAX_VALUE, Short.MAX_VALUE));
            x+=alloc.getBounds().x;
            y+=alloc.getBounds().y;

            vParent=vParent.getParent();
        }

        if (v instanceof BoxView) {
            int ind=v.getParent().getViewIndex(v.getStartOffset(), Position.Bias.Forward);
            Rectangle r2=v.getParent().getChildAllocation(ind, new Rectangle(0,0,Integer.MAX_VALUE,Integer.MAX_VALUE)).getBounds();

            return new Rectangle(x,y, r2.width, r2.height);
        }

        return new Rectangle(x,y, (int)v.getPreferredSpan(View.X_AXIS), (int)v.getPreferredSpan(View.Y_AXIS));
    }


    class StyledViewFactory implements ViewFactory {

        public View create(Element elem) {
            String kind = elem.getName();
            if (kind != null) {
                if (kind.equals(AbstractDocument.ContentElementName)) {
                    return new LabelView(elem);
                }
                else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                    return new ParagraphView(elem);
                }
                else if (kind.equals(AbstractDocument.SectionElementName)) {
                    return new BoxView(elem, View.Y_AXIS);
                }
                else if (kind.equals(StyleConstants.ComponentElementName)) {
                    return new ComponentView(elem);
                }
                else if (kind.equals(StyleConstants.IconElementName)) {
                    return new IconView(elem);
                }
                else if (kind.equals(COLLAPSIBLE_AREA_ELEMENT)) {
                    return new CollapsibleView(elem);
                }
            }

            // default to text display
            return new LabelView(elem);
        }

    }
}
