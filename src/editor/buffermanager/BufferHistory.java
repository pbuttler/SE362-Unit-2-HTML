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
    private int _index;
    
    public BufferHistory(){
        bufferTreadmill = new ArrayList<>();
    }
    
    public String stepForward(){
        
        
        
        if ( bufferTreadmill.isEmpty() ) return null;
        
        _index++;
        if ( _index >= bufferTreadmill.size() ) {
            _index = bufferTreadmill.size() - 1;
        }
        
        String nextBuffer = bufferTreadmill.get(_index);
        return nextBuffer;
    }
    
    public String stepBack(){
        
        if ( bufferTreadmill.isEmpty() ) {
            return null;
        }
        _index--;
        
        if ( _index <= 0 ) {
            _index = 0;
        }
        
        String lastBuffer = bufferTreadmill.get(_index);
        return lastBuffer;
    }
    
    public void add(String contents) {
        
        bufferTreadmill.add(contents);
        _index = bufferTreadmill.size() - 1;
        
    }
    
    public void dropTail() {
        for ( int i = _index + 1;i< bufferTreadmill.size(); i++ ) {
            bufferTreadmill.remove(i);
        }
        
        if ( bufferTreadmill.isEmpty() ) {
            _index = 0;
        } else {
            _index = bufferTreadmill.size() - 1;
        }
    }
    
}
    