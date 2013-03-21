/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg362unit2.app;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Isioma
 */
public class Buffer  {
    
    private String Contents;
    
    public Buffer(String contents) {
        this.Contents = contents;
    }
    
    public Buffer() {
        this("");
    }
    
    public String GetBufferContents() {
        return this.Contents;
    }
    
    
    
}
