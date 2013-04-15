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
public class BufferHistory {
    
    private ArrayList<String> bufferTreadmill;
    private int index;
    
    public BufferHistory(){
        bufferTreadmill = new ArrayList<>();
    }
    
    public String stepForward(){
        
        if (bufferTreadmill.size() == 0) {
            
            return "";
            
        }
        
        index++;
        if (index == bufferTreadmill.size() - 1) {
            index = bufferTreadmill.size() - 1;
        }
        
        String nextBuffer = bufferTreadmill.get(index);
        return nextBuffer;
    }
    
    public String stepBack(){
        
        if (bufferTreadmill.size() == 0) {
            
            return "";
            
        }
        
        index--;
        if (index == 0) {
            index = 0;
        }
        
        String lastBuffer = bufferTreadmill.get(index);
        return lastBuffer;
    }
    
    public void add(String contents) {
        
        bufferTreadmill.add(contents);
        
    }
    
    public void flush() {
        for ( int i = index;i< bufferTreadmill.size(); i++ ) {
            bufferTreadmill.remove(i);
        }
    }
    
}
    