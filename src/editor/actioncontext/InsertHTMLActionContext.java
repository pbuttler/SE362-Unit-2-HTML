/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.actioncontext;

import actioncontext.GeneralActionContext;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Danielle
 */
public class InsertHTMLActionContext extends GeneralActionContext{
    
    private HashMap<String,Object> data;
    //setContent alters tag
    private String tag;
    private String currentTab;
    private String updatedBuffer;
    
    /**
     *
     */
    public static final String 
            H1 = "H1",
            /**
             *
             */
            H2 = "H2",
            /**
             *
             */
            H3 = "H3",
            /**
             *
             */
            H4 = "H4",
            /**
             *
             */
            H5 = "H5",
            /**
             *
             */
            H6 = "H6",
            /**
             *
             */
            AHREF = "AHREF",
            /**
             *
             */
            TABLE = "TABLE",
            /**
             *
             */
            UL = "UL",
            /**
             *
             */
            B = "B",
            /**
             *
             */
            I = "I",
            /**
             *
             */
            U = "U",
            /**
             *
             */
            P = "P",
            /**
             *
             */
            IMG = "IMG",
            /**
             *
             */
            ROWS = "ROWS",
            /**
             *
             */
            COLS = "COLS",
            /**
             *
             */
            ALTTEXT = "ALTTEXT",
            /**
             *
             */
            URL = "URL",
            /**
             *
             */
            ITEMS = "ITEMS";
            
            
            
    
    /**
     *
     */
    public InsertHTMLActionContext(){
        data = new HashMap<>();
    }

    /**
     * @return the content
     */
    public String getContent() {
        return tag;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.tag = content;
    }

    /**
     * @return the currentTab
     */
    public String getCurrentTab() {
        return currentTab;
    }
    
    /**
     *
     * @param key
     * @param value
     */
    public void addData(String key, Object value) {
        this.data.put(key, value);
    }
    
    /**
     *
     * @param data
     */
    public void setData(HashMap data) {
        
        this.data = data;
    }


    /**
     * @param currentTab the currentTab to set
     */
    public void setCurrentTab(String currentTab) {
        this.currentTab = currentTab;
    }
    
    /**
     *
     * @return
     */
    public String getUpdatedBuffer() {
        return this.updatedBuffer;
    }
    
    /**
     *
     * @param updatedBuffer
     */
    public void setUpdatedBuffer(String updatedBuffer) {
        this.updatedBuffer = updatedBuffer;
    }

    /**
     *
     * @return
     */
    public HashMap getData() {
        return this.data;
    }

    /**
     *
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
    /**
     *
     * @return
     */
    public String getTag() {
        return tag;
    }
}
