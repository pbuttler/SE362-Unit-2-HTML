/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import viewcontroller.FSMenuBar;
import viewcontroller.GeneralViewGUI;

/**
 *
 * @author Isioma
 */
@SuppressWarnings("serial")
	
public class FSViewManager extends JFrame implements ActionListener {

	/**
	 * The system-wide default font for text fields.
	 */
	public static final Font DEFAULT_TEXTFIELD_FONT = new Font( "SansSerif", Font.PLAIN, 16 );
	
	/**
	 * The system-wide height for textfields.
	 */
	public static final int DEFAULT_TEXTFIELD_HEIGHT = 28;
	
	/**
	 * The system-wide default font for text fields labels.
	 */
	public static final Font DEFAULT_TF_LABEL_FONT = new Font( "SansSerif", Font.BOLD, 15 );
	
	/**
	 * The system-wide default font for text fields labels.
	 */
	public static final Font DEFAULT_BUTTON_FONT = new Font( "SansSerif", Font.BOLD, 14 );
	
	/**
	 * The title displayed in the main window.
	 */
	public static final String MAIN_WINDOW_NAME = "5Seconds HTML Editor";
	

	
	/**
	 * The single PDSMainWindow manager.
	 */
	private static FSViewManager _mainWindow;
	
	/**
	 * The label of the main window that displays the current component's title.
	 */
	private static JLabel _componentTitleLabel;
        
        public static FSMenuBar menubar;
	

	

	/**
	 * The stack of views displayed in this window.
	 */
	private static Stack<GeneralViewGUI> _viewStack;
	
	/**
	 * Creates a new PDSMainWindow object.  Sets up the JFrame.
	 */
	private FSViewManager() {

		// Set the dimensions of this window.
		this.setSize( 800, 620);
		this.setLocation( 300, 150 );
		this.setResizable( false );

		// Set the default close operation and title of the window.
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setTitle( FSViewManager.MAIN_WINDOW_NAME );

	}
	
	/**
	 * Initializes the main window.
	 */
	private static void initializeMainWindow() {
		
		// Construct the static PDSMainWindow() object.
		_mainWindow = new FSViewManager();
		
		// Create a new stack.
		_viewStack = new Stack<GeneralViewGUI>();
		
		// Setup the mainwindow with a panel on top for the title, 
		// back button, and time.
		_mainWindow.getContentPane().setLayout( new BorderLayout() );
		
		// Create a panel for the top.
		JPanel topPanel = new JPanel();
		topPanel.setLayout( new GridLayout(1,2) ); // one column two rows
		topPanel.setBorder( LineBorder.createGrayLineBorder() );
                
		menubar = new FSMenuBar(_mainWindow);
                menubar.setActionListeners(_mainWindow);
                
//		// Set the title label.
//		_componentTitleLabel = new JLabel();
//		_componentTitleLabel.setFont( new Font( "SansSerif", Font.PLAIN, 30 ) );
//		JPanel titlePanel = new JPanel();
//		titlePanel.setLayout( new FlowLayout( FlowLayout.LEADING ) );
//		titlePanel.add( _componentTitleLabel );
		

		
		// Create a panel for the bottom.
		JPanel workspace = new JPanel();
		workspace.setLayout( new GridLayout(1,2) );
		workspace.setBorder( LineBorder.createGrayLineBorder() );



		// Add the panels to the main window.
		_mainWindow.getContentPane().add( topPanel, BorderLayout.NORTH );
		_mainWindow.getContentPane().add( workspace, BorderLayout.SOUTH );
		
                
                _mainWindow.setJMenuBar(menubar);
	}
	
	/**
	 * Hides or shows this window.
	 * 
	 * @param visible Whether or not to display the window.
	 */
	public static void setWindowVisible( boolean visible ) {
		
		// Initialize the main window if it is null.
		if( _mainWindow == null ) {
			FSViewManager.initializeMainWindow();
		}
		
		_mainWindow.setVisible( visible );
		
	
	}

	
	/**
	 * Adds a view to the stack.
	 * 
	 * @param newView  The new view to display.
	 */
	public static void pushView( GeneralViewGUI newView ) {
		
		// Remove the current view from display, but don't pop it.
		removeTopViewFromDisplay();
		
		// Push the new view and display it.
		_viewStack.push( newView );
		displayTopView();
		
	}
	
	/**
	 * Removes the topmost view from the stack.
	 */
	public static void popView() {

		// Remove the topmost view from display, and pop it.
		removeTopViewFromDisplay();
		_viewStack.pop();
		
		// Now display the top view.
		displayTopView();

	}
	
	/**
	 * Displays the topmost view.
	 */
	private static void displayTopView() {

		if( _viewStack.size() > 0 ) { 
				
			GeneralViewGUI topView = _viewStack.peek();
			
			// Add the top view to the panel.
			topView.getMainPanel().setBorder( LineBorder.createGrayLineBorder() );
			_mainWindow.getContentPane().add( topView.getMainPanel(), BorderLayout.CENTER );
			topView.setVisible( true );
	
			// Change the title label's text.
//			_componentTitleLabel.setText( "  " + topView.getMainPanel().getName() );
	
			
		}

	}

	/**
	 * Removes the topmost view of the stack from display.
	 */
	private static void removeTopViewFromDisplay() {
		
		// Remove the current view.
		if( _viewStack.size() > 0 ) {

			GeneralViewGUI oldView = _viewStack.peek();
			oldView.setVisible( false );
			_mainWindow.getContentPane().remove( oldView.getMainPanel() );


		}

	}

	
	/**
	 * Adds a window listener to the main window.
	 */
	public static void addNewWindowListener( WindowListener wl ) {
		_mainWindow.addWindowListener( wl );
                
                
	}
        
        
        public void newFileActionPerformed() {
            
            // open a JFileChooser
            // which 
            
            
            
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        
        switch (e.getActionCommand()) {
            case FSMenuBar.NEW_FILE:
//                handleNewFileAction();
                break;
        
        }
    }
	
	
}
