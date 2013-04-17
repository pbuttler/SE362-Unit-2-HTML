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
public class SaveFileActionContext extends GeneralActionContext{
    private int currentTab;
    private File saveFile;
    // Is the title really necessary?
    private String _title;
    // I dont think we need this if we just pass the currentTab. Not sure..
    private String _contents;
    private boolean newBuffer;

    public boolean isNewBuffer() {
        return newBuffer;
    }

    public void setNewBuffer(boolean newBuffer) {
        this.newBuffer = newBuffer;
    }
    
    /**
     *
     */
    public SaveFileActionContext(){
    }

    /**
     * @return the saveFile
     */
    public File getSaveFile() {
        return saveFile;
    }

    /**
     * @param saveFile the saveFile to set
     */
    public void setSaveFile(File saveFile) {
        this.saveFile = saveFile;
    }

    /**
     * @return the _title
     */
    public String getTitle() {
        return _title;
    }

    /**
     * @param title the _title to set
     */
    public void setTitle(String title) {
        this._title = title;
    }

    /**
     * @return the _contents
     */
    public String getContents() {
        return _contents;
    }

    /**
     * @param contents the _contents to set
     */
    public void setContents(String contents) {
        this._contents = contents;
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
