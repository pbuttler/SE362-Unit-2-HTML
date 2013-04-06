/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JFrame;
import commands.CommandFactory;
import common.BufferObserver;
import editor.Editor;
import gui.htmleditor.GUI;


/**
 *
 * @author Isioma
 */
public class App {
    
    private editor.Editor _editor;
    
    private Commander _dave;
    
    public App() {
        
        this._editor = new Editor();
        
        this._dave = new Commander(this);
        
        GUI.instantiate(this._dave);
        
    }
    
    public Editor getEditor() {
        return this._editor;
    }
    
    public Commander getCommander() {
        return this._dave;
    }
    
    public void destroy() {
        
        // kill the GUI
        
        this._dave.getGUI().destroy();
        
        
        
    }

    public void unregisterBufferObserver() {
        
        // only one observer so no parameters 
        this._dave.getGUI().unregisterBufferObserver();
    }

    public void registerBufferObserver(BufferObserver activeBuffer) {
        this._dave.getGUI().registerBufferObserver(activeBuffer);
    }
    
}
