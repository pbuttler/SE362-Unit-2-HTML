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
public class IndentCurrentLineActionContext extends GeneralActionContext{
    private int currentTab;
    private int currentLine;
    public IndentCurrentLineActionContext(){
        
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
     * @return the currentLine
     */
    public int getCurrentLine() {
        return currentLine;
    }

    /**
     * @param currentLine the currentLine to set
     */
    public void setCurrentLine(int currentLine) {
        this.currentLine = currentLine;
    }
    
}
