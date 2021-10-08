package texteditor;

import javax.swing.*;
import java.awt.*;

public class about_Window extends JFrame{
    private JButton btn_ok;
    private JLabel about_label;
    private JLabel about_label2;

    private JPanel panel ;
    private BoxLayout boxlayout;

    public about_Window() {
        panel = new JPanel();
        boxlayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);

        btn_ok = new JButton("OK");
        btn_ok.setAlignmentX(CENTER_ALIGNMENT);

        about_label = new JLabel("Heqing Peng");
        about_label2 = new JLabel("Yanpeng Xu");
        about_label.setFont(new Font("Serif",Font.BOLD,64));
        about_label2.setFont(new Font("Serif",Font.BOLD,64));

        about_label.setAlignmentX(CENTER_ALIGNMENT);
        about_label2.setAlignmentX(CENTER_ALIGNMENT);

        panel.add(about_label);
        panel.add(about_label2);

        panel.add(btn_ok);


        this.add(panel);
        this.setSize(600,400);
        this.setTitle("About");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btn_ok.addActionListener(e->{
            this.dispose();
        });
    }
}
