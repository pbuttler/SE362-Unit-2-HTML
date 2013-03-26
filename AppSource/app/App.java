/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JFrame;
import commands.CommandFactory;
import common.BufferObserver;
import editor.Editor;
import gui.htmleditor.testGUI;


/**
 *
 * @author Isioma
 */
public class App {
    
    private editor.Editor _editor;
    private testGUI _gui;
    private Commander _dave;
    
    public App() {
        
        this._editor = new Editor();
        
        this._dave = new Commander(this);
        
        this._gui = new testGUI(this._dave);
        
        this._gui.instantiate();
        
    }
    
    public Editor getEditor() {
        return this._editor;
    }
    
    public testGUI getGUI() {
        return this._gui;
    }
    
    
    
    public void destroy() {
        
        // kill the GUI
        
        this._gui.destroy();
        
        
        
    }

    public void unregisterBufferObserver() {
        
        // only one observer so no parameters 
        this._gui.unregisterBufferObserver();
    }

    public void registerBufferObserver(BufferObserver activeBuffer) {
        this._gui.registerBufferObserver(activeBuffer);
    }
    
}
