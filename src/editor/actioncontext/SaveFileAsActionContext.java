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
public class SaveFileAsActionContext extends GeneralActionContext{
    private File newFile;
    private int currentTab;
    /**
     *
     */
    public SaveFileAsActionContext(){
        
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
     * @return the newFile
     */
    public File getNewFile() {
        return newFile;
    }

    /**
     * @param newFile the newFile to set
     */
    public void setNewFile(File newFile) {
        this.newFile = newFile;
    }
    
}
