/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mgw.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class LatarBelakang extends JPanel{
    Image vithun;
    int h, w;
    public LatarBelakang(Image icon, int width, int heigth) {
        setBounds(0, 0, icon.getWidth(null), icon.getHeight(null));
        vithun = icon;
        h = heigth;
        w = width;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        g = (Graphics2D) g;
        int heigth;
        g.drawImage(vithun, 0,0, w, h, this);
    }
}
