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
public class MiddleBuffer extends Observable implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        
        this.notifyObservers(arg);
        
    }
    
}
