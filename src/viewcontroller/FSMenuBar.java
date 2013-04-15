/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author iun4534
 */
public class FSMenuBar extends JMenuBar {
    
        /**
     *
     */
    public ActionListener parentWindow;
        
        

        private JMenu fileMenu;
        private JMenuItem // File menu items
            newFileMenuItem,
            OpenMenuItem,
            SaveMenuItem,
            SaveAsMenuItem,
            ExitMenuItem;


        private JMenu EditMenu;
        private JMenuItem // Edit menu items
            UndoMenuItem,
            RedoMenuItem,
            CutMenuItem,
            CopyMenuItem,
            PasteMenuItem;

        private JMenu 
                ViewMenu,
                ZoomToMenu;

        private JMenuItem // View menu items
            ViewAsWebpageMenuItem,
            FiftyPercentZoom,
            OneHundredPercentZoom,
            TwoHundredPercentZoom;

        private JMenu SourceMenu;
        private JMenuItem // Options menu items
            ValidateMenuItem,
            OutlineViewMenuItem,
            AutoWordWrapMenuCheckBox,
            AutoIndentMenuCheckBox,
            SyntaxHighlightingMenuCheckbox,
            IndentCurrentLineMenuItem,
            IndentSelectedTextMenuItem,
            IndentEntireBufferMenuItem;

        private JMenu 
                InsertMenu,
                headingsMenu,
                FontEmphasisMenu;

        private JMenuItem // Insert menu items
            h1HeaderMenuItem,
            h2HeaderMenuItem,
            h3HeaderMenuItem,
            h4HeaderMenuItem,
            h5HeaderMenuItem,
            h6HeaderMenuItem,
            TableMenuItem,
            ListMenuItem,
            BoldMenuItem,
            ItalicMenuItem,
            UnderlineMenuItem,
            ParagraphMenuItem,
            PictureMenuItem;
        
        private JMenu  
            WindowMenu;
        
        private JMenuItem
                CloseMenuItem;
        
        /**
         *
         */
        public static final String 
            FILE_MENU_NAME = "File",
            /**
             *
             */
            NEW_FILE_OPTION = "New File...",
            /**
             *
             */
            OPEN_FILE_OPTION = "Open File...",
            /**
             *
             */
            SAVE_OPTION = "Save...",
            /**
             *
             */
            SAVEAS_OPTION = "Save As...",
            /**
             *
             */    
            EXIT_OPTION = "Exit",
            
            /**
             *
             */
            CLOSE_OPTION = "Close Tab",
            /**
             *
             */
            CUT_OPTION = "Cut",
            /**
             *
             */
            COPY_OPTION = "Copy",
            /**
             *
             */
            PASTE_OPTION = "Paste",
            /**
             *
             */
            VIEW_OPTION = "View",
            /**
             *
             */
            VIEWASWEBPAGE_OPTION = "View As Webpage",
            /**
             *
             */
            ZOOMTO_OPTION = "Zoom",
            /**
             *
             */
            FIFTY_OPTION = "Zoom Out",
            /**
             *
             */
            HUNDRED_OPTION = "Reset",
            /**
             *
             */
            TWOHUNDRED_OPTION = "Zoom In",
            /**
             *
             */
            SOURCE_OPTION = "Source",
            /**
             *
             */
            AUTOWORDWRAP_OPTION = "Auto Word Wrap",
            /**
             *
             */
            AUTOINDENT_OPTION = "Auto Indent",
            /**
             *
             */
            SYNTAXHIGHLIGHTING_OPTION = "Syntax Highlighting",
            /**
             *
             */
            INDENTCURRENTLINE_OPTION = "Indent Current Line",
            /**
             *
             */
            INDENTSELECTEDTEXT_OPTION = "Indent Selected Text",
            /**
             *
             */
            INDENTENTIREBUFFER_OPTION = "Indent Entire Buffer",
            /**
             *
             */
            INSERT_OPTION = "Insert",
            /**
             *
             */
            HEADER_OPTION = "Header",
            /**
             *
             */
            H1_OPTION = "H1",
            /**
             *
             */
            H2_OPTION = "H2",
            /**
             *
             */
            H3_OPTION = "H3",
            /**
             *
             */
            H4_OPTION = "H4",
            /**
             *
             */
            H5_OPTION = "H5",
            /**
             *
             */
            H6_OPTION = "H6",
            /**
             *
             */
            TABLE_OPTION = "Table",
            /**
             *
             */
            LIST_OPTION = "List",
            /**
             *
             */
            FONTEMPHASIS_OPTION = "Font Emphasis",
            /**
             *
             */
            BOLD_OPTION = "Bold",
            /**
             *
             */
            ITALIC_OPTION = "Italic",
            /**
             *
             */
            UNDERLINE_OPTION = "Underline",
            /**
             *
             */
            PARAGRAPH_OPTION = "Paragraph",
            /**
             *
             */
            PICTURE_OPTION = "Picture",
            /**
             *
             */
            VALIDATE_OPTION = "Validate",
            /**
             *
             */
            OUTLINE_OPTION = "Outline",
            /**
             *
             */
            EDIT_OPTION = "Edit",
            /**
             *
             */
            UNDO_OPTION = "Undo",
            /**
             *
             */
            REDO_OPTION = "Redo",
            /**
             *
             */
            WINDOW_MENU = "Window";
        
        
        
            
        
        /**
     *
     * @param parentWindow
     */
    public FSMenuBar(ActionListener parentWindow) {
            this.parentWindow = parentWindow;
            initializeMenus();
//            initializeListeners();
            setText();
        }
        
        private void initializeMenus() {
            
            fileMenu = new JMenu();
        
            newFileMenuItem = new JMenuItem();
            OpenMenuItem = new JMenuItem();
            SaveMenuItem = new JMenuItem();
            SaveAsMenuItem = new JMenuItem();
            ExitMenuItem = new JMenuItem();
            
            
            fileMenu.add(newFileMenuItem);
            fileMenu.add(new JSeparator()); // SEPARATOR
            fileMenu.add(OpenMenuItem);
            fileMenu.add(new JSeparator()); // SEPARATOR
            fileMenu.add(SaveMenuItem);
            fileMenu.add(SaveAsMenuItem);
            fileMenu.add(new JSeparator()); // SEPARATOR
            fileMenu.add(ExitMenuItem);
            
            this.add(fileMenu);

            EditMenu = new JMenu();
        
            UndoMenuItem = new JMenuItem();
            RedoMenuItem = new JMenuItem();
            
            CutMenuItem = new JMenuItem();
            CopyMenuItem = new JMenuItem();
            PasteMenuItem = new JMenuItem();
        
            EditMenu.add(UndoMenuItem);
            EditMenu.add(RedoMenuItem);
            EditMenu.add(new JSeparator()); // SEPARATOR
            EditMenu.add(CutMenuItem);
            EditMenu.add(CopyMenuItem);
            EditMenu.add(PasteMenuItem);            
            this.add(EditMenu);
            
            ViewMenu = new JMenu();
            ZoomToMenu = new JMenu();
            
            ViewAsWebpageMenuItem = new JMenuItem();
            FiftyPercentZoom = new JMenuItem();
            OneHundredPercentZoom = new JMenuItem();
            TwoHundredPercentZoom = new JMenuItem();
            
            ViewMenu.add(ViewAsWebpageMenuItem);
            ViewMenu.add(new JSeparator()); // SEPARATOR
            ViewMenu.add(ZoomToMenu);
            ZoomToMenu.add(FiftyPercentZoom);
            ZoomToMenu.add(OneHundredPercentZoom);
            ZoomToMenu.add(TwoHundredPercentZoom);
            
            this.add(ViewMenu);

            SourceMenu = new JMenu();
            
            ValidateMenuItem = new JMenuItem();
            OutlineViewMenuItem = new JMenuItem();
            AutoWordWrapMenuCheckBox = new JCheckBoxMenuItem();
            AutoIndentMenuCheckBox = new JCheckBoxMenuItem();
            SyntaxHighlightingMenuCheckbox = new JCheckBoxMenuItem();
            IndentCurrentLineMenuItem = new JMenuItem();
            IndentSelectedTextMenuItem = new JMenuItem();
            IndentEntireBufferMenuItem = new JMenuItem();
            
            SourceMenu.add(ValidateMenuItem);
            SourceMenu.add(new JSeparator()); // SEPARATOR
            SourceMenu.add(AutoWordWrapMenuCheckBox);
            SourceMenu.add(AutoIndentMenuCheckBox);
            SourceMenu.add(new JSeparator()); // SEPARATOR
            SourceMenu.add(SyntaxHighlightingMenuCheckbox);
            SourceMenu.add(new JSeparator()); // SEPARATOR
            SourceMenu.add(IndentCurrentLineMenuItem);
            SourceMenu.add(IndentSelectedTextMenuItem);
            SourceMenu.add(IndentEntireBufferMenuItem);
            
            this.add(SourceMenu);
            
            InsertMenu = new JMenu();
            headingsMenu = new JMenu();
            FontEmphasisMenu = new JMenu();
            
            InsertMenu.add(headingsMenu);
            InsertMenu.add(FontEmphasisMenu);
        
            h1HeaderMenuItem = new JMenuItem();
            h2HeaderMenuItem = new JMenuItem();
            h3HeaderMenuItem = new JMenuItem();
            h4HeaderMenuItem = new JMenuItem();
            h5HeaderMenuItem = new JMenuItem();
            h6HeaderMenuItem = new JMenuItem();
            
            headingsMenu.add(h1HeaderMenuItem);
            headingsMenu.add(h2HeaderMenuItem);
            headingsMenu.add(h3HeaderMenuItem);
            headingsMenu.add(h4HeaderMenuItem);
            headingsMenu.add(h5HeaderMenuItem);
            headingsMenu.add(h6HeaderMenuItem);
            
            TableMenuItem = new JMenuItem();
            ListMenuItem = new JMenuItem();
            
            InsertMenu.add(TableMenuItem);
            InsertMenu.add(ListMenuItem);
            
            BoldMenuItem = new JMenuItem();
            ItalicMenuItem = new JMenuItem();
            UnderlineMenuItem = new JMenuItem();
            ParagraphMenuItem = new JMenuItem();
            PictureMenuItem = new JMenuItem();
            
            FontEmphasisMenu.add(BoldMenuItem);
            FontEmphasisMenu.add(ItalicMenuItem);
            FontEmphasisMenu.add(UnderlineMenuItem);
            FontEmphasisMenu.add(ParagraphMenuItem);
            FontEmphasisMenu.add(PictureMenuItem);
            
            this.add(InsertMenu);
            
            
            this.WindowMenu = new JMenu();

            CloseMenuItem = new JMenuItem();
            fileMenu.add(CloseMenuItem);
            
            WindowMenu.add(CloseMenuItem);
            
            this.add(WindowMenu);
        }
        
        /**
     *
     * @param parent
     */
    public void setActionListeners(ActionListener parent) {
            
            newFileMenuItem.addActionListener(parent);
            OpenMenuItem.addActionListener(parent);
            SaveMenuItem.addActionListener(parent);
            SaveAsMenuItem.addActionListener(parent);
            ExitMenuItem.addActionListener(parent);
            
            
            CutMenuItem.addActionListener(parent);
            CopyMenuItem.addActionListener(parent);
            PasteMenuItem.addActionListener(parent);
            
            ViewAsWebpageMenuItem.addActionListener(parent);
            FiftyPercentZoom.addActionListener(parent);
            OneHundredPercentZoom.addActionListener(parent);
            TwoHundredPercentZoom.addActionListener(parent);
            ViewAsWebpageMenuItem.addActionListener(parent);
            FiftyPercentZoom.addActionListener(parent);
            OneHundredPercentZoom.addActionListener(parent);
            TwoHundredPercentZoom.addActionListener(parent);
            
            AutoWordWrapMenuCheckBox.addActionListener(parent);
            AutoIndentMenuCheckBox.addActionListener(parent);
            SyntaxHighlightingMenuCheckbox.addActionListener(parent);
            IndentCurrentLineMenuItem.addActionListener(parent);
            IndentSelectedTextMenuItem.addActionListener(parent);
            IndentEntireBufferMenuItem.addActionListener(parent);
            
            h1HeaderMenuItem.addActionListener(parent);
            h2HeaderMenuItem.addActionListener(parent);
            h3HeaderMenuItem.addActionListener(parent);
            h4HeaderMenuItem.addActionListener(parent);
            h5HeaderMenuItem.addActionListener(parent);
            h6HeaderMenuItem.addActionListener(parent);
            TableMenuItem.addActionListener(parent);
            ListMenuItem.addActionListener(parent);
            BoldMenuItem.addActionListener(parent);
            ItalicMenuItem.addActionListener(parent);
            UnderlineMenuItem.addActionListener(parent);
            ParagraphMenuItem.addActionListener(parent);
            PictureMenuItem.addActionListener(parent);

            ValidateMenuItem.addActionListener(parent);
            OutlineViewMenuItem.addActionListener(parent);
            
            CloseMenuItem.addActionListener(parent);
            
            UndoMenuItem.addActionListener(parent);
            RedoMenuItem.addActionListener(parent);
        }
        
        
        private void setText() {
            
            fileMenu.setText(FILE_MENU_NAME);
            newFileMenuItem.setText(NEW_FILE_OPTION);
            OpenMenuItem.setText(OPEN_FILE_OPTION);
            SaveMenuItem.setText(SAVE_OPTION);
            SaveAsMenuItem.setText(SAVEAS_OPTION);
            ExitMenuItem.setText(EXIT_OPTION);
            
            
            this.UndoMenuItem.setText(UNDO_OPTION);
            this.RedoMenuItem.setText(REDO_OPTION);
            
            EditMenu.setText(EDIT_OPTION);
            CutMenuItem.setText(CUT_OPTION);
            CopyMenuItem.setText(COPY_OPTION);
            PasteMenuItem.setText(PASTE_OPTION);
            ViewMenu.setText(VIEW_OPTION);
            ViewAsWebpageMenuItem.setText(VIEWASWEBPAGE_OPTION);
            ZoomToMenu.setText(ZOOMTO_OPTION);
            FiftyPercentZoom.setText(FIFTY_OPTION);
            OneHundredPercentZoom.setText(HUNDRED_OPTION);
            TwoHundredPercentZoom.setText(TWOHUNDRED_OPTION);
            SourceMenu.setText(SOURCE_OPTION);
            AutoWordWrapMenuCheckBox.setText(AUTOWORDWRAP_OPTION);
            AutoIndentMenuCheckBox.setText(AUTOINDENT_OPTION);
            SyntaxHighlightingMenuCheckbox.setText(SYNTAXHIGHLIGHTING_OPTION);
            IndentCurrentLineMenuItem.setText(INDENTCURRENTLINE_OPTION);
            IndentSelectedTextMenuItem.setText(INDENTSELECTEDTEXT_OPTION);
            IndentEntireBufferMenuItem.setText(INDENTENTIREBUFFER_OPTION);
            InsertMenu.setText(INSERT_OPTION);
            headingsMenu.setText(HEADER_OPTION);
            h1HeaderMenuItem.setText(H1_OPTION);
            h2HeaderMenuItem.setText(H2_OPTION);
            h3HeaderMenuItem.setText(H3_OPTION);
            h4HeaderMenuItem.setText(H4_OPTION);
            h5HeaderMenuItem.setText(H5_OPTION);
            h6HeaderMenuItem.setText(H6_OPTION);
            TableMenuItem.setText(TABLE_OPTION);
            ListMenuItem.setText(LIST_OPTION);
            FontEmphasisMenu.setText(FONTEMPHASIS_OPTION);
            BoldMenuItem.setText(BOLD_OPTION);
            ItalicMenuItem.setText(ITALIC_OPTION);
            UnderlineMenuItem.setText(UNDERLINE_OPTION);
            ParagraphMenuItem.setText(PARAGRAPH_OPTION);
            PictureMenuItem.setText(PICTURE_OPTION);
            ValidateMenuItem.setText(VALIDATE_OPTION);
            OutlineViewMenuItem.setText(OUTLINE_OPTION);
            
            WindowMenu.setText(WINDOW_MENU);
            CloseMenuItem.setText(CLOSE_OPTION);
            
            
        }
    
}
