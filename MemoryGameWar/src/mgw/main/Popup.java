package mgw.main;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Popup extends JPanel{
    public Popup(){
        setBounds(50, 50, 400, 400);
        setBackground(Color.white);
    }    
}
class PopupChangeAccount extends JPanel{
    JLabel judul;
    JTextField isi;
    public PopupChangeAccount(int height, int width) {
        setBounds(width/2, height/2, JOptionPane.WIDTH, JOptionPane.HEIGHT);
    }
}
