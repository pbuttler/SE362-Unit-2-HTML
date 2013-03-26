/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Observable;

/**
 *
 * @author Danielle Neuberger and Luke Coy
 */
public class ObservableBuffer extends Observable {
    String contents = "";
    int number;    
    
    public ObservableBuffer(int number, String contents){
        this.number = number;
        this.contents = contents;
    }
    
    public void updateContents(String s){
        contents = s;
    }

    String getContents() {
        return this.contents;
    }
}
