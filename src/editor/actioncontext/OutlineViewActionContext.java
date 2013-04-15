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
public class OutlineViewActionContext extends GeneralActionContext {
    private String content ="";
    private int currentTab =-1;
    // ^ gathered from jeditorpane current
    public OutlineViewActionContext() {
        
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
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
}
