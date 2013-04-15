package articles.collapse;

import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;

public class CollapsibleView extends BoxView {
    private boolean isExpanded=true;
    public static final int AREA_SHIFT=10;

    public CollapsibleView(Element elem) {
        super(elem, View.Y_AXIS);
        setInsets((short)0, (short)AREA_SHIFT, (short)0, (short)0);
    }
    
    public void paint(Graphics g, Shape alloc) {
        Rectangle a=alloc instanceof Rectangle ? (Rectangle)alloc : alloc.getBounds();
        Shape oldClip=g.getClip();
        if (!isExpanded()) {
            Area newClip=new Area(oldClip);
            newClip.intersect(new Area(a));
            g.setClip(newClip);
        }
        super.paint(g, a);
        g.setClip(oldClip);
        a.width--;
        a.height--;
        g.setColor(Color.lightGray);
        ((Graphics2D)g).draw(a);
        g.drawRect(a.x,  a.y, AREA_SHIFT,AREA_SHIFT);

        if (!isExpanded()) {
            g.drawLine(a.x+AREA_SHIFT/2, a.y+2, a.x+AREA_SHIFT/2, a.y+AREA_SHIFT-2);
        }
        g.drawLine(a.x+2, a.y+AREA_SHIFT/2, a.x+AREA_SHIFT-2, a.y+AREA_SHIFT/2);
    }

    public float getPreferredSpan(int axis) {
        if (isExpanded() || axis!=View.Y_AXIS) {
            return super.getPreferredSpan(axis);
        }
        else {
            View firstChild=getView(0);
            if (firstChild instanceof BoxView && ((BoxView)firstChild).getAxis()==View.Y_AXIS) {
                return getTopInset()+firstChild.getView(0).getPreferredSpan(View.Y_AXIS);
            }
            else {
                return getTopInset()+firstChild.getPreferredSpan(View.Y_AXIS);
            }
        }
    }

    public float getMinimumSpan(int axis) {
        if (isExpanded() || axis!=View.Y_AXIS) {
            return super.getMinimumSpan(axis);
        }
        else {
            View firstChild=getView(0);
            if (firstChild instanceof BoxView && ((BoxView)firstChild).getAxis()==View.Y_AXIS) {
                return getTopInset()+firstChild.getView(0).getMinimumSpan(View.Y_AXIS);
            }
            else {
                return getTopInset()+firstChild.getMinimumSpan(View.Y_AXIS);
            }
        }
    }

    public float getMaximumSpan(int axis) {
        if (isExpanded() || axis!=View.Y_AXIS) {
            return super.getMaximumSpan(axis);
        }
        else {
            View firstChild=getView(0);
            if (firstChild instanceof BoxView && ((BoxView)firstChild).getAxis()==View.Y_AXIS) {
                return getTopInset()+firstChild.getView(0).getMaximumSpan(View.Y_AXIS);
            }
            else {
                return getTopInset()+firstChild.getMaximumSpan(View.Y_AXIS);
            }
        }
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    protected int getNextNorthSouthVisualPositionFrom(int pos, Position.Bias b,
						      Shape a, int direction,
						      Position.Bias[] biasRet)
	                                        throws BadLocationException {
        int newPos=super.getNextNorthSouthVisualPositionFrom(pos, b, a, direction, biasRet);
        if (!isExpanded()) {
            if (newPos<getView(0).getView(0).getEndOffset()) {
                //first line of first child
                return newPos;
            }
            if (direction== SwingConstants.SOUTH) {
                int ind=getParent().getViewIndex(getStartOffset(), Position.Bias.Forward);
                if (ind<getParent().getViewCount()) {
                    while (newPos<getEndOffset() && newPos>=0) {
                        int p=super.getNextNorthSouthVisualPositionFrom(newPos, b, a, direction, biasRet);
                        if (p<0) {
                            newPos=getParent().getNextVisualPositionFrom(newPos, b, a, direction, biasRet);
                            break;
                        }
                        newPos=p;
                    }
                }
            }
            else {
                int ind=getParent().getViewIndex(getStartOffset(), Position.Bias.Forward);
                if (ind<getParent().getViewCount()) {
                    while (newPos>getStartOffset() && newPos>0) {
                        int p=super.getNextNorthSouthVisualPositionFrom(newPos, b, a, direction, biasRet);
                        if (p<0) {
                            newPos=getParent().getNextVisualPositionFrom(newPos, b, a, direction, biasRet);
                            break;
                        }
                        newPos=p;
                        if (newPos<getView(0).getView(0).getEndOffset()) {
                            //first line of first child
                            return newPos;
                        }
                    }
                }
            }
        }

        return newPos;
    }

    protected int getNextEastWestVisualPositionFrom(int pos, Position.Bias b,
						    Shape a,
						    int direction,
						    Position.Bias[] biasRet)
	                                        throws BadLocationException {
        int newPos=super.getNextEastWestVisualPositionFrom(pos, b, a, direction, biasRet);
        if (!isExpanded()) {
            if (newPos>=getStartOffset() && newPos<getView(0).getView(0).getEndOffset()) {
                //first line of first child
                return newPos;
            }
            else if (newPos>=getView(0).getView(0).getEndOffset()) {
                if (direction==SwingConstants.EAST) {
                    newPos=Math.min(getDocument().getLength()-1, getEndOffset());
                }
                else {
                    newPos=getView(0).getView(0).getEndOffset()-1;
                }
            }
        }

        return newPos;
    }
}
