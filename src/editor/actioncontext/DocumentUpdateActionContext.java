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
public class DocumentUpdateActionContext extends GeneralActionContext {
    private String _title;
    private String _content;
    
    public DocumentUpdateActionContext() {
    }

    public void setTitle(String title) {
        _title = title;
    }

    public void setContent(String content) {
        _content = content;
    }
    
    public String getContent() {
        return _content;
    }
    
}
