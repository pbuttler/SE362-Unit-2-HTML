/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.actioncontext;

import actioncontext.GeneralActionContext;

/**
 *
 * @author innod_000
 */
public class CloseTabActionContext extends GeneralActionContext {
    private boolean forceClose;
    private boolean newBuffer;

    public boolean isNewBuffer() {
        return newBuffer;
    }

    public void setNewBuffer(boolean newBuffer) {
        this.newBuffer = newBuffer;
    }

    public boolean isForceClose() {
        return forceClose;
    }

    public void setForceClose(boolean forceClose) {
        this.forceClose = forceClose;
    }
    
}
