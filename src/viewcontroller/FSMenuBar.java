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
        
        public static final String FILE_MENU_NAME = "File";
        public static final String NEW_FILE = "New";
        private void setText() {
            
            fileMenu.setText(FILE_MENU_NAME);
            newFileMenuItem.setText(NEW_FILE);
            OpenMenuItem.setText("Open");
            SaveMenuItem.setText("Save");
            SaveAsMenuItem.setText("Save As");
            CloseMenuItem.setText("Close");
            
            EditMenu.setText("Edit");
            CutMenuItem.setText("Cut");
            CopyMenuItem.setText("Copy");
            PasteMenuItem.setText("Paste");
            ViewMenu.setText("View");
            ViewAsWebpageMenuItem.setText("View As Webpage");
            ZoomToMenu.setText("Zoom To..");
            FiftyPercentZoom.setText("50%");
            OneHundredPercentZoom.setText("100%");
            TwoHundredPercentZoom.setText("200%");
            OptionsMenu.setText("Options");
            AutoWordWrapMenuCheckBox.setText("Auto Word Wrap");
            AutoIndentMenuCheckBox.setText("Auto Indent");
            SyntaxHighlightingMenuCheckbox.setText("Syntax Highlighting");
            IndentCurrentLineMenuItem.setText("Indent Current Line");
            IndentSelectedTextMenuItem.setText("Indent Selected Text");
            IndentEntireBufferMenuItem.setText("Indent Entire Buffer");
            InsertMenu.setText("Insert");
            headingsMenu.setText("Header");
            h1HeaderMenuItem.setText("<h1>");
            h2HeaderMenuItem.setText("<h2>");
            h3HeaderMenuItem.setText("<h3>");
            h4HeaderMenuItem.setText("<h4>");
            h5HeaderMenuItem.setText("<h5>");
            h6HeaderMenuItem.setText("<h6>");
            TableMenuItem.setText("Table");
            ListMenuItem.setText("List");
            FontEmphasisMenu.setText("Font Emphasis");
            BoldMenuItem.setText("Bold");
            ItalicMenuItem.setText("Italic");
            UnderlineMenuItem.setText("Underline");
            ParagraphMenuItem.setText("Paragraph");
            PictureMenuItem.setText("Picture");
        }
    
}
