package texteditor;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class Main extends JFrame implements ActionListener{

    private JMenuBar menuBar;
    //menu
    private JMenu menu_File,menu_Edit,menu_Help;
    //menu's menu
    private JMenuItem item_new,item_open,item_save,item_print,item_Highlight,item_exit;//file

    private JMenuItem item_undo,item_cut,item_copy,item_stick,findRep;//edit

    private JMenuItem item_about;//help

    //



    //public static JTextArea edit_text_area;//edit area
    public static JTextPane edit_text_area;//edit area


    private JScrollPane scroll_bar;//a rolling pane,with a edit_text_area，JScrollPane is pane，can also set direction


    private JFileChooser fileChooser = null;//JFileChooser component  respond time to pop out话框


    public static void main(String[] args) {
        Main m1 = new Main();
    }

    /*public static JTextArea getEdit_text_area() {
        return edit_text_area;
    }*/
    public static JTextPane getEdit_text_area() {
        return edit_text_area;
    }

    public Main(){
        initMenuBar();
        initEditArea();
        initListener();

        this.setJMenuBar(menuBar);
        this.setSize(800,600);
        this.add(scroll_bar);
        this.setTitle("Test Editor");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * initial edit area
     * use scrollpane to hold textarea
     * set direction of pane
     */
    public void initEditArea() {
        //edit_text_area = new JTextArea();
        edit_text_area = new JTextPane();
        scroll_bar = new JScrollPane(edit_text_area);
        scroll_bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    /**
     * initial menu，add sub-menu
     */
    public void initMenuBar() {
        menuBar = new JMenuBar();
        menu_File = new JMenu("File(F)");
        menu_File.setMnemonic('f');//f+alt
        item_new = new JMenuItem("New");
        item_open = new JMenuItem("Open");
        item_save = new JMenuItem("Save");
        item_print = new JMenuItem("Print");
        item_Highlight = new JMenuItem("Highlight");
        item_exit = new JMenuItem("Exit");
        menu_File.add(item_new);
        menu_File.add(item_open);
        menu_File.add(item_save);
        menu_File.add(item_print);
        menu_File.add(item_Highlight);
        menu_File.add(item_exit);
        //File

        menu_Edit = new JMenu("Edit(E)");
        menu_Edit.setMnemonic('e');
        item_undo = new JMenuItem("Undo");
        item_cut = new JMenuItem("Cut");
        item_copy = new JMenuItem("Copy");
        item_stick = new JMenuItem("Paste");
        findRep = new JMenuItem("Search");//search

        menu_Edit.add(item_undo);
        menu_Edit.add(item_cut);
        menu_Edit.add(item_copy);
        menu_Edit.add(item_stick);
        menu_Edit.add(findRep);
        //Edit

        menu_Help = new JMenu("Help(H)");
        menu_Help.setMnemonic('h');
        item_about = new JMenuItem("About");
        menu_Help.add(item_about);
        //Help








        menuBar.add(menu_File);
        menuBar.add(menu_Edit);

        menuBar.add(menu_Help);
    }

    /**
     * set all btn with item a action-listener
     */
    public void initListener() {
        item_new.addActionListener(this);
        item_open.addActionListener(this);
        item_save.addActionListener(this);
        item_print.addActionListener(this);
        item_Highlight.addActionListener(this);
        item_exit.addActionListener(this);
        item_undo.addActionListener(this);
        item_cut.addActionListener(this);
        item_copy.addActionListener(this);
        item_stick.addActionListener(this);

        item_about.addActionListener(this);
        findRep.addActionListener(this);
    }
    class FindAndReplace extends JDialog implements ActionListener {// search
        JLabel findLabel = new JLabel("Search content：");
        JLabel repLabel = new JLabel("    Replace with：");
        JTextField findTf = new JTextField(8);
        JTextField repTf = new JTextField(8);
        JButton findBtn = new JButton("Search");
        JButton repBtn = new JButton("Replace");
        JPanel findPn = new JPanel();
        JPanel repPn = new JPanel();
        //JTextArea textarea;
        JTextPane textarea;

        String text;
        boolean flg = false;
        int len;
        int start = 0;
        int k = 0;

        public FindAndReplace(JTextPane textarea/*JTextArea textarea*/) {

            this.textarea = textarea;

            findPn.add(findLabel);
            findPn.add(findTf);
            findPn.add(findBtn);
            repPn.add(repLabel);
            repPn.add(repTf);
            repPn.add(repBtn);
            this.add(findPn);
            this.add(repPn);

            findBtn.addActionListener(this);
            repBtn.addActionListener(this);

            this.setTitle("Search and Replace");
            this.setLayout(new GridLayout(2, 1));

            this.pack();
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);
            this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        }

        @SuppressWarnings("deprecation")
        public void actionPerformed(ActionEvent e) {
            String findText = findTf.getText();
            String repText = repTf.getText();
            text = textarea.getText();
            if (e.getSource() == findBtn) {
                findBtn.setLabel("Next one");
                if (findText != null) {
                    len = findText.length();
                    start = text.indexOf(findText, k);
                    k = start + len;
                    textarea.select(start, start + len);
                    flg = true;
                    if (start == -1) {
                        JOptionPane.showMessageDialog(null, "Find bottom！", "Hint", JOptionPane.INFORMATION_MESSAGE);
                        start = 0;
                        k = 0;
                        flg = false;
                    }
                }
            } else if (e.getSource() == repBtn) {
                if (flg) {
                    /*textarea.replaceRange(repText, start, start + len);*/
                    textarea.replaceSelection(repText);
                    flg = false;
                }
            }
        }
    }
    /**
     * listening action in all item of menu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item_about) {
            new about_Window();
        }else if (e.getSource() == item_new) {
            new Main(); //new a new windows ，bug: close any sub-windows can alse let father windows closed
        }else if (e.getSource() == item_print) {
            PrintTest1 p = new PrintTest1();
            p.setVisible(true);
        } else if(e.getSource() ==item_Highlight){
            KeywordsJava k= new KeywordsJava();
        }else if (e.getSource() == item_exit) {
            this.dispose();
        }else if (e.getSource() == item_open) {
            openFile();
        }else if (e.getSource() == item_save) {
            saveFile();
        }else if (e.getSource() == item_cut) {
            edit_text_area.cut();
        } else if (e.getSource() == item_copy) {
            edit_text_area.copy();
        } else if (e.getSource() == item_stick) {
            edit_text_area.paste();
        }else if (e.getSource() == findRep) {
            new FindAndReplace(edit_text_area);
        }
    }

    private void saveFile() {
        File file = null;
        int result ;
        fileChooser = new JFileChooser("C:\\");
        fileChooser.setApproveButtonToolTipText("Save"); // save
        fileChooser.setDialogTitle("Save File"); // set title
        result = fileChooser.showOpenDialog(rootPane); // set Dialog's root View

        if(result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile(); // click the agree button，fill the direction of the file
        }
        try{
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file),"UTF-8"); // coding
            BufferedWriter writer = new BufferedWriter(write);
            String content = edit_text_area.getText();
            writer.write(content);
            writer.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * when click the New item, run the JFileChooser dialog
     * deal with the file reading and writing
     */
    private void openFile() {
        File file = null;
        int result ;
        fileChooser = new JFileChooser("C:\\");
        fileChooser.setApproveButtonToolTipText("OK"); // set the true text of the button Confirm.
        fileChooser.setDialogTitle("Open File"); // set title
        result = fileChooser.showOpenDialog(rootPane); // set Dialog's root View

        if(result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile(); // if click the confirm button，fil the direction of the file
        }

        if(file.isFile() && file.exists()) {
            BufferedReader reader = null;
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"UTF-8");
                reader = new BufferedReader(inputStreamReader);

                String readLine = "";
                while ((readLine = reader.readLine()) != null) { // read the BufferedReader datat line by line
                    //edit_text_area.append(readLine+'\n');  //edit_text_area add line by line
                    //using JTextPane doesn't have "append" method
                    SimpleAttributeSet attrset=new SimpleAttributeSet();
                    Document docs =edit_text_area.getDocument();
                    try{
                    docs.insertString(docs.getLength(), readLine,attrset);}
                    catch (BadLocationException e){
                        e.printStackTrace();
                    }
                }

                reader.close(); // close the reader

            }catch (IOException e) {
                e.printStackTrace();
                TipDialog tmpDialog = new TipDialog(this,"Error File",true,"Wrong file name. Please check again!");
            }


        }
    }

    /**
     * using this inner class，new a DIY Dialog
     * highly custom
     * fit for short,precise situation
     */
    class TipDialog extends JDialog{

        public TipDialog (JFrame jf,String title ,boolean flag ,String info) {
            super(jf,title,flag);
            JLabel Jlb = new JLabel(info);
            this.add(Jlb);
            this.setSize(200, 150);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        }
    }
}

