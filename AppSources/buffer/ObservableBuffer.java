/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buffer;

import java.util.Observable;

/**
 *
 * @author Danielle Neuberger and Luke Coy
 */
public class ObservableBuffer extends Observable {
    String[] contents;
    
    
    public ObservableBuffer(String contents){
        
        String[] contentsAsArray = contents.split("\\r?\\n");
        
        
        this.contents = contentsAsArray;
    }
    
    public ObservableBuffer(String[] contents){
        this.contents = contents;
        
        
    }
    
    
    
    public void updateContents(String newContents){
        
        String[] contentsAsArray = newContents.split("\\r?\\n");
        
        contents = contentsAsArray;
        this.setChanged();
        this.notifyObservers();
    }

    public String[] getContents() {
        return this.contents;
    }
}
