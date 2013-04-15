/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.actioncontext;

import actioncontext.GeneralActionContext;
import java.io.File;

/**
 *
 * @author Danielle
 */
public class IndentSelectedTextActionContext extends GeneralActionContext{
    private int currentTab;
    private int startLineNumber;
    private int endLineNumber;
    public IndentSelectedTextActionContext(){
        
    }

    /**
     * @return the currentTab
     */
    public int getCurrentTab() {
        return currentTab;
    }

    /**
     * @param currentTab the currentTab to set
     */
    public void setCurrentTab(int currentTab) {
        this.currentTab = currentTab;
    }

    /**
     * @return the startLineNumber
     */
    public int getStartLineNumber() {
        return startLineNumber;
    }

    /**
     * @param startLineNumber the startLineNumber to set
     */
    public void setStartLineNumber(int startLineNumber) {
        this.startLineNumber = startLineNumber;
    }

    /**
     * @return the endLineNumber
     */
    public int getEndLineNumber() {
        return endLineNumber;
    }

    /**
     * @param endLineNumber the endLineNumber to set
     */
    public void setEndLineNumber(int endLineNumber) {
        this.endLineNumber = endLineNumber;
    }
    
}
