/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package mgw.main;

import java.util.Objects;
import javax.swing.Icon;

/**
 *
 * @author user
 */
public class Card extends javax.swing.JPanel implements Cloneable {
    public static String[] resourceImages = {
        "/mgw/main/cardimg/1.jpeg",
        "/mgw/main/cardimg/2.jpeg",
        "/mgw/main/cardimg/3.jpeg",
        "/mgw/main/cardimg/4.jpeg",
        "/mgw/main/cardimg/5.jpeg",
        "/mgw/main/cardimg/6.jpeg",
        "/mgw/main/cardimg/7.jpeg",
        "/mgw/main/cardimg/8.jpeg",
        "/mgw/main/cardimg/9.jpeg",
        "/mgw/main/cardimg/10.jpeg",
    };
    
    /**
     * Creates new form Card
     */
    public final String imagePath;
    boolean flip = false, paired = false;
    Icon img, back = new javax.swing.ImageIcon(getClass().getResource("/mgw/main/cardimg/card back.png"));
    
    public Card() {
        initComponents();
        img = new javax.swing.ImageIcon(getClass().getResource(imagePath = "/mgw/main/imgdeck/Chain Lightning.png"));
        
        jLabel1.setIcon(back);
    }
    
    public Card(String iconResourcePath) {
        initComponents();
        flip = true;
        img = new javax.swing.ImageIcon(getClass().getResource(iconResourcePath));
        imagePath = iconResourcePath;
        jLabel1.setIcon(img);
    }
    
    public void reset()
    {
        flipOpen();
        paired = false;
    }
    
    public void flipOpen()
    {
        flip = true;
        jLabel1.setIcon(img);
    }
    
    public void flipDown()
    {
        flip = false;
        jLabel1.setIcon(back);
    }
    
    public void setIconNull()
    {
        flip = true;
        paired = true;
        jLabel1.setIcon(null);
    }

    @Override
    protected Object clone() {
        try
        {
            return super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            return null;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.imagePath);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        return Objects.equals(this.imagePath, other.imagePath);
    }



    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
