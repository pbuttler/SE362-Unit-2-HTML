/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.actioncontext;
import actioncontext.GeneralActionContext;
/**
 *
 * @author Luke
 */
public class LinkViewActionContext extends GeneralActionContext {
    private boolean isPopup;

    public boolean isIsPopup() {
        return isPopup;
    }

    public void setIsPopup(boolean isPopup) {
        this.isPopup = isPopup;
    }
}

