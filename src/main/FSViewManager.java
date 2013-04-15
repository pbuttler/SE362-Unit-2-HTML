 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import editor.actioncontext.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import utils.Utilities;
import viewcontroller.FSMenuBar;
import viewcontroller.GeneralView;
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
        
        private GeneralViewGUI getTopView() {
            
        
            return _viewStack.peek();
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
    /** So the actionPerformed for all events happen here. 
     *  Its starting point and it leads to editor.EditorController.respondToInput
     * - Luke
     **/    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        
        switch (e.getActionCommand()) {
            case FSMenuBar.NEW_FILE_OPTION:
                handleNewFileAction();
                break;
            case FSMenuBar.OPEN_FILE_OPTION:
                handleOpenFileAction();
                break;
            case FSMenuBar.SAVE_OPTION:
                handleSaveAction();
                break;
            case FSMenuBar.SAVEAS_OPTION:
                handleSaveAsAction();
                break;
            case FSMenuBar.CLOSE_OPTION:
                handleCloseAction();
                break;
            case FSMenuBar.CUT_OPTION:
                    handleCutAction();
                    break;
            case FSMenuBar.COPY_OPTION:
                    handleCopyAction();
                    break;
            case FSMenuBar.PASTE_OPTION:
                    handlePasteAction();
                    break;
            case FSMenuBar.VIEW_OPTION:
                    handleViewAction();
                    break;
            case FSMenuBar.VIEWASWEBPAGE_OPTION:
                    handleViewAsWebpageAction();
                    break;
            case FSMenuBar.ZOOMTO_OPTION:
                    handleZoomToAction();
                    break;
            case FSMenuBar.OPTIONS_OPTION:
                    handleOptionsAction();
                    break;
            case FSMenuBar.AUTOWORDWRAP_OPTION:
                    handleAutoWordWrapAction();
                    break;
            case FSMenuBar.AUTOINDENT_OPTION:
                    handleAutoIndentAction();
                    break;
            case FSMenuBar.SYNTAXHIGHLIGHTING_OPTION:
                    handleSyntaxHighlightAction();
                    break;
            case FSMenuBar.INDENTCURRENTLINE_OPTION:
                    handleIndentCurrentLineAction();
                    break;
            case FSMenuBar.INDENTSELECTEDTEXT_OPTION:
                    handleIndentSelectedTextAction();
                    break;
            case FSMenuBar.INDENTENTIREBUFFER_OPTION:
                    handleIndentEntireBufferAction();
                    break;
            case FSMenuBar.INSERT_OPTION:
                    handleInsertAction();
                    break;
            case FSMenuBar.HEADER_OPTION:
                    handleHeaderAction();
                    break;
            case FSMenuBar.H1_OPTION:
                    handleH1Action();
                    break;
            case FSMenuBar.H2_OPTION:
                    handleH2Action();
                    break;
            case FSMenuBar.H3_OPTION:
                    handleH3Action();
                    break;
            case FSMenuBar.H4_OPTION:
                    handleH4Action();
                    break;
            case FSMenuBar.H5_OPTION:
                    handleH5Action();
                    break;
            case FSMenuBar.H6_OPTION:
                    handleH6Action();
                    break;
            case FSMenuBar.TABLE_OPTION:
                    handleTableAction();
                    break;
            case FSMenuBar.LIST_OPTION:
                    handleListAction();
                    break;
            case FSMenuBar.FONTEMPHASIS_OPTION:
                    handleFontEmphasisAction();
                    break;
            case FSMenuBar.BOLD_OPTION:
                    handleBoldAction();
                    break;
            case FSMenuBar.ITALIC_OPTION:
                    handleItalicAction();
                    break;
            case FSMenuBar.UNDERLINE_OPTION:
                    handleUnderlineAction();
                    break;
            case FSMenuBar.PARAGRAPH_OPTION:
                    handleParagraphAction();
                    break;
            case FSMenuBar.PICTURE_OPTION:
                    handlePictureAction();
                    break;    
            case FSMenuBar.VALIDATE_OPTION:
                    handleValidateAction();
                    break;
            default:
                break;
        
        }
    }
    
    public void handleNewFileAction() {
        
        NewFileActionContext actionContext = new NewFileActionContext();
        
        GeneralView currentView = (GeneralView) this.getTopView();
        
        currentView.getController().respondToInput(actionContext);
        
        
    
    }

    private void handleOpenFileAction() {
        JFileChooser fileChooser = new JFileChooser();

        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();
            String fileName = file.getName();
            OpenFileActionContext context = new OpenFileActionContext();
            context.setFile(file);
            
            GeneralView currentView = (GeneralView) this.getTopView();
            
            currentView.getController().respondToInput(context);


        } else {
            // Do nothing, the action was canceled
        }
    }

    private void handleCutAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleCopyAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handlePasteAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleViewAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleViewAsWebpageAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleZoomToAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleOptionsAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleAutoWordWrapAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleAutoIndentAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleSyntaxHighlightAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleIndentCurrentLineAction() {
        IndentCurrentLineActionContext context = new IndentCurrentLineActionContext();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleIndentSelectedTextAction() {
        IndentSelectedTextActionContext context = new IndentSelectedTextActionContext();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleIndentEntireBufferAction() {
        IndentEntireBufferActionContext context = new IndentEntireBufferActionContext();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleInsertAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleHeaderAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH1Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH2Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH3Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH4Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH5Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleH6Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleTableAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleListAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleFontEmphasisAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleBoldAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleItalicAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleUnderlineAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleParagraphAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handlePictureAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleSaveAction() {
        SaveFileActionContext context = new SaveFileActionContext();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleSaveAsAction() {
        SaveFileAsActionContext context = new SaveFileAsActionContext();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void handleCloseAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
    private void handleValidateAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
