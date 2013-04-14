/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author iun4534
 */
public class FSMenuBar extends JMenuBar {
    
        public ActionListener parentWindow;
        
        

        public JMenu fileMenu;
        public JMenuItem // File menu items
            newFileMenuItem,
            OpenMenuItem,
            SaveMenuItem,
            SaveAsMenuItem,
            CloseMenuItem;


        public JMenu EditMenu;
        public JMenuItem // Edit menu items
            CutMenuItem,
            CopyMenuItem,
            PasteMenuItem;

        public JMenu 
                ViewMenu,
                ZoomToMenu;

        public JMenuItem // View menu items
            ViewAsWebpageMenuItem,
            FiftyPercentZoom,
            OneHundredPercentZoom,
            TwoHundredPercentZoom;

        public JMenu OptionsMenu;
        public JMenuItem // Options menu items
            AutoWordWrapMenuCheckBox,
            AutoIndentMenuCheckBox,
            SyntaxHighlightingMenuCheckbox,
            IndentCurrentLineMenuItem,
            IndentSelectedTextMenuItem,
            IndentEntireBufferMenuItem;

        public JMenu 
                InsertMenu,
                headingsMenu,
                FontEmphasisMenu;

        public JMenuItem // Insert menu items
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
            CloseMenuItem = new JMenuItem();
            
            fileMenu.add(newFileMenuItem);
            fileMenu.add(OpenMenuItem);
            fileMenu.add(SaveMenuItem);
            fileMenu.add(SaveAsMenuItem);
            fileMenu.add(CloseMenuItem);
            this.add(fileMenu);

            EditMenu = new JMenu();
        
            CutMenuItem = new JMenuItem();
            CopyMenuItem = new JMenuItem();
            PasteMenuItem = new JMenuItem();
        
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
            ViewMenu.add(ZoomToMenu);
            ZoomToMenu.add(FiftyPercentZoom);
            ZoomToMenu.add(OneHundredPercentZoom);
            ZoomToMenu.add(TwoHundredPercentZoom);
            
            this.add(ViewMenu);

            OptionsMenu = new JMenu();
            
            AutoWordWrapMenuCheckBox = new JCheckBoxMenuItem();
            AutoIndentMenuCheckBox = new JCheckBoxMenuItem();
            SyntaxHighlightingMenuCheckbox = new JCheckBoxMenuItem();
            IndentCurrentLineMenuItem = new JMenuItem();
            IndentSelectedTextMenuItem = new JMenuItem();
            IndentEntireBufferMenuItem = new JMenuItem();
            
            OptionsMenu.add(AutoWordWrapMenuCheckBox);
            OptionsMenu.add(AutoIndentMenuCheckBox);
            OptionsMenu.add(SyntaxHighlightingMenuCheckbox);
            OptionsMenu.add(IndentCurrentLineMenuItem);
            OptionsMenu.add(IndentSelectedTextMenuItem);
            OptionsMenu.add(IndentEntireBufferMenuItem);
            
            this.add(OptionsMenu);
            
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
            
            
        }
        
        public void setActionListeners(ActionListener parent) {
            
            newFileMenuItem.addActionListener(parent);
            OpenMenuItem.addActionListener(parent);
            SaveMenuItem.addActionListener(parent);
            SaveAsMenuItem.addActionListener(parent);
            CloseMenuItem.addActionListener(parent);
            
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

        }
        
        public static final String 
            FILE_MENU_NAME = "File",
            NEW_FILE_OPTION = "New",
            OPEN_FILE_OPTION = "Open",
            SAVE_OPTION = "Save",
            SAVEAS_OPTION = "Save As",
            CLOSE_OPTION = "Close",
            CUT_OPTION = "Cut",
            COPY_OPTION = "Copy",
            PASTE_OPTION = "Paste",
            VIEW_OPTION = "View",
            VIEWASWEBPAGE_OPTION = "View As Webpage",
            ZOOMTO_OPTION = "Zoom To..",
            FIFTY_OPTION = "50%",
            HUNDRED_OPTION = "100%",
            TWOHUNDRED_OPTION = "200%",
            OPTIONS_OPTION = "Options",
            AUTOWORDWRAP_OPTION = "Auto Word Wrap",
            AUTOINDENT_OPTION = "Auto Indent",
            SYNTAXHIGHLIGHTING_OPTION = "Syntax Highlighting",
            INDENTCURRENTLINE_OPTION = "Indent Current Line",
            INDENTSELECTEDTEXT_OPTION = "Indent Selected Text",
            INDENTENTIREBUFFER_OPTION = "Indent Entire Buffer",
            INSERT_OPTION = "Insert",
            HEADER_OPTION = "Header",
            H1_OPTION = "<h1>",
            H2_OPTION = "<h2>",
            H3_OPTION = "<h3>",
            H4_OPTION = "<h4>",
            H5_OPTION = "<h5>",
            H6_OPTION = "<h6>",
            TABLE_OPTION = "Table",
            LIST_OPTION = "List",
            FONTEMPHASIS_OPTION = "Font Emphasis",
            BOLD_OPTION = "Bold",
            ITALIC_OPTION = "Italic",
            UNDERLINE_OPTION = "Underline",
            PARAGRAPH_OPTION = "Paragraph",
            PICTURE_OPTION = "Picture";
        
        public static final String EDIT_OPTION = "Edit";
        private void setText() {
            
            fileMenu.setText(FILE_MENU_NAME);
            newFileMenuItem.setText(NEW_FILE_OPTION);
            OpenMenuItem.setText(OPEN_FILE_OPTION);
            SaveMenuItem.setText(SAVE_OPTION);
            SaveAsMenuItem.setText(SAVEAS_OPTION);
            CloseMenuItem.setText(CLOSE_OPTION);
            
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
            OptionsMenu.setText(OPTIONS_OPTION);
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
        }
    
}
