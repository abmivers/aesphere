/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Presentation.java
 *
 * Created on 01-jun-2010, 13:15:32
 */

package aesphere;

import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class Presentation extends javax.swing.JFrame {

    /** Creates new form Presentation */
    public Presentation() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pres.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        //java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
                Presentation pres = new Presentation();
                pres.setLocationRelativeTo(null);
                pres.setVisible(true);

                try {
                    //Thread.sleep(2000);
                } catch(Exception exc) {
                    JOptionPane.showMessageDialog(pres, exc);
                }

                MainUI ventana = new MainUI();
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);

                pres.dispose();
                pres=null;
                
            //}
       // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
