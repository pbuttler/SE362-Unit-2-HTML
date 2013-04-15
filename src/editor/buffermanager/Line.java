/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.buffermanager;

import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class Line {
    
    private String contents;
    private boolean collapsed;
    private ArrayList<Line> children;
    
    public String getContents(){
        return contents;
    }
    
    public void setContents( String s ){
        contents = s;
    }
    
    public boolean isCollapsed(){
        return collapsed;
    }
    
    public void setCollapsed( boolean b ){
        collapsed = b;
        for (Line l : children){
            l.setCollapsed(b);
        }
    }    
}
