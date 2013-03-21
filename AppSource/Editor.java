/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg362unit2.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Isioma
 */
public class Editor implements Observer {
    
    private ArrayList<Buffer> Buffers;
    private int ActiveBufferIndex;
    
    public Editor(ArrayList<Buffer> newBuffers) {
        ActiveBufferIndex = 0;
        Buffers = newBuffers;
    }
    
    public Editor() {
        this(new ArrayList<Buffer>());
    }
    
    public void SwitchActiveBuffer(int newBufferIndex) {
        
        this.ActiveBufferIndex = newBufferIndex;
        SetActiveBuffer(this.Buffers.get(this.ActiveBufferIndex));
        
    }
    
    public void SetActiveBuffer(Buffer newBuffer) {
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        // TODO Update the active buffer with changes
        
    }
}
