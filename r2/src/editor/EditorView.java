/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import viewcontroller.GeneralView;

/**
 *
 * @author Isioma
 */
public abstract class EditorView extends GeneralView {
    public enum EditorInChan implements InputChannel {
		
		ICSampleAction
		
	}
	
	/**
	 * The output channels for this view.
	 */
	public enum EditorOutChan implements OutputChannel {
		
		OCSampleAction
		
	}
}
