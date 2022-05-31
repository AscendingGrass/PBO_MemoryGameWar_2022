package mgw.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
class PopupLagi extends JScrollPane{
    
}
/*class Background extends JPanel{
    Image vithun;
    int h, w;
    public Background(Image icon, int height, int width) {
        h=height;
        w=width;
        setBounds(0, 0, w, h);
        vithun = icon;
    }
     @Override
    public void paint(Graphics g) {
        super.paint(g); 
        g = (Graphics2D) g;
        g.drawImage(vithun, 0,0, w, h, this);
    }
}*/