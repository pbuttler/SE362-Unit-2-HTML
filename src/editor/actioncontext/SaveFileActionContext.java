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
    
    private File saveFile;
    private String _title;
    private String _contents;
    
    public SaveFileActionContext(){
    }
    
    //communicate with the file and rewrite the contents
    //receive a boolean whether save was successful
   
    
}
