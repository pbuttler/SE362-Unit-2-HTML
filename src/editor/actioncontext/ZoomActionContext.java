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
public class ZoomActionContext extends GeneralActionContext{
    private int currentTab;
    private int percentZoom;
    public ZoomActionContext(){
        
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
     * @return the percentZoom
     */
    public int getPercentZoom() {
        return percentZoom;
    }

    /**
     * @param percentZoom the percentZoom to set
     */
    public void setPercentZoom(int percentZoom) {
        this.percentZoom = percentZoom;
    }
    
}
