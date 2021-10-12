package texteditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Format extends JFrame implements ItemListener, ActionListener {
    private JComboBox choose_word_style;
    private JComboBox choose_word_big;
    private JComboBox choose_word_pattern;

    private JButton btn_ok;
    private JButton btn_cancel;

    private String[] styles = {"Simsun","Gothic","Regular Script","Microsoft YaHei","Clerical Script"};
    private String[] word_big = {"2","4","8","16","24","32","64","72"};
    private String[] pattern = {"Plain","Italic","Bold"};

    private JTextField showText ;

    private JPanel paneNorth;
    private JPanel paneCenter;
    private JPanel paneSouth;

    private Font selectedFont = new Font("Gothic",Font.PLAIN, 32);
    private String selectedStyle = "Simsun";
    private int selectedBig = 32;
    private int selectedPattern = Font.PLAIN;
    private Color selectedColor = Color.BLACK;


    public Font getSelectedFont() {
        return selectedFont;
    }

    public String getSelectedStyle() {
        return selectedStyle;
    }

    public int getSelectedBig() {
        return selectedBig;
    }

    public int getSelectedPattern() {
        return selectedPattern;
    }

    public Format() {
        initBox();
        initText();
        initButton();
        initLocation();
        initListener();
        addBtnListener();

        this.setSize(550,200);
        this.setTitle("Format");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_cancel) {
            this.dispose();
        }else if (e.getSource() == btn_ok) {
            Main.getEdit_text_area().setFont(selectedFont);
            this.dispose();
        }
    }

    /**
     * Add listener to ComboBox
     */
    private void initListener() {
        choose_word_style.addItemListener(this);
        choose_word_big.addItemListener(this);
        choose_word_pattern.addItemListener(this);
    }

    /**
     * Initial ok and cancel buttons
     */
    private void initButton() {
        btn_ok = new JButton("OK");
        btn_cancel = new JButton("CANCEL");
    }

    /**
     * Add listener for two btn
     */
    public void addBtnListener() {
        btn_ok.addActionListener(this);
        btn_cancel.addActionListener(this);
    }

    /**
     * Initial layout
     */
    public void initLocation() {
        paneNorth = new JPanel();
        paneNorth.add(new JLabel("Font:"));
        paneNorth.add(choose_word_style);
        paneNorth.add(new JLabel("Size:"));
        paneNorth.add(choose_word_big);
        paneNorth.add(new JLabel("Type:"));
        paneNorth.add(choose_word_pattern);
        this.add(paneNorth,BorderLayout.NORTH);

        paneCenter = new JPanel();
        paneCenter.add(showText);
        this.add(paneCenter, BorderLayout.CENTER);

        paneSouth = new JPanel();
        paneSouth.add(btn_ok);
        paneSouth.add(btn_cancel);
        this.add(paneSouth, BorderLayout.SOUTH);

    }

    /**
     * Show area
     */
    public void initText() {
        showText = new JTextField("Hello World");
        showText.setFont(selectedFont);
        showText.setEditable(false);
        showText.setSize(100,160);
    }

    /**
     * Initial some comboBox
     */
    public void initBox() {
        choose_word_style = new JComboBox(styles);
        choose_word_big = new JComboBox(word_big);
        choose_word_pattern = new JComboBox(pattern);
    }


    public void renewFont() {
        selectedFont = new Font(selectedStyle,selectedPattern,selectedBig);
        showText.setFont(selectedFont);
        showText.setForeground(selectedColor);
    }

    /**
     * Change function for each item
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem() == "Simsun") {
            selectedStyle = "Simsun";
            renewFont();
        }else if (e.getItem() == "Gothic") {
            selectedStyle = "Gothic";
            renewFont();
        }else if (e.getItem() == "Regular Script") {
            selectedStyle = "Regular Script";
            renewFont();
        }else if (e.getItem() == "Microsoft YaHei") {
            selectedStyle = "Microsoft YaHei";
            renewFont();
        }else if (e.getItem() == "Clerical Script") {
            selectedStyle = "Clerical Script";
            renewFont();
        }else if (e.getItem() == "Plain") {
            selectedPattern = Font.PLAIN;
            renewFont();
        }else if (e.getItem() == "Italic") {
            selectedPattern = Font.ITALIC;
            renewFont();
        }else if (e.getItem() == "Bold") {
            selectedPattern = Font.BOLD;
            renewFont();
        }else if (e.getItem() == "2") {
            selectedBig = 2;
            renewFont();
        }else if (e.getItem() == "4") {
            selectedBig = 4;
            renewFont();
        }else if (e.getItem() == "8") {
            selectedBig = 8;
            renewFont();
        }else if (e.getItem() == "16") {
            selectedBig = 16;
            renewFont();
        }else if (e.getItem() == "24") {
            selectedBig = 24;
            renewFont();
        }else if (e.getItem() == "32") {
            selectedBig = 32;
            renewFont();
        }else if (e.getItem() == "64") {
            selectedBig = 64;
            renewFont();
        }else if (e.getItem() == "72") {
            selectedBig = 72;
            renewFont();
        }
    }
}
