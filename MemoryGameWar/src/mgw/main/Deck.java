/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package mgw.main;

/**
 *
 * @author user
 */
public class Deck extends javax.swing.JPanel {

    /**
     * Creates new form Deck
     */
    boolean clicked = false;
    static int counter = 1;
    public Deck() {
        initComponents();
        //jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mgw/main/" + counter++ + ".png")));
        //jlabel1();
    }
    public void jlabel1(){
        //jLabel1.setIcon(new javax.swing.ImageIcon("E:\\Ruben Data\\Kuliah\\INFORMATIKA\\Semester 2\\PBO or OOP\\Projek\\2022_PBO_P1\\cardType\\10.png"));
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
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
