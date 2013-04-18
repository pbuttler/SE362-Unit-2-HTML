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
public class AutoWordWrapActionContext extends GeneralActionContext {
    private int currentTab;
    private boolean autoWordWrapOptionChecked;
    
    public AutoWordWrapActionContext(){
       
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
     * 
     */
    public boolean getAutoWordWrapOptionChecked(){
        return autoWordWrapOptionChecked;
    }
    
    /**
     * 
     */
    public void setAutoWordWrapOptionChecked(boolean x){
        autoWordWrapOptionChecked = x;
        
    }
}
