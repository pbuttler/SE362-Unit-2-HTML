/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.buffermanager;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class Buffer {   
    
    private boolean hasChanged = false;              
    
    private int lineIndex;    
    private ArrayList<Line> lines;
    String contentsString;
    private File file;
    
    public Buffer(){
        this.file = file;   	
    }
    
    public File getFile(){        
        return file;
    }
    
    public void printLines(){
        contentsString = "";
        for(Line l : lines){
            contentsString += l.getContents();
            contentsString += "\n";
        }
        
        // Set Displayed text to contentsString
    }
        
}
