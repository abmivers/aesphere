/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProcesoCifrarUI.java
 *
 * Created on 27-may-2010, 16:06:21
 */

package aesphere;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;


/**
 *
 * @author antonio
 */

public class InfoArchivos extends javax.swing.JFrame {

    private String ruta = null;
    private MainUI wpadre;

    public InfoArchivos(MainUI padre, String folder) {
        initComponents();
        wpadre = padre;
        wpadre.newchild(this);

        int index = folder.lastIndexOf(File.separator);
        if (index != -1) ruta = folder.substring(0, index);

        this.setLocationRelativeTo(wpadre);
        this.setVisible(true);        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        AbrirButton = new javax.swing.JButton();
        OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AESphere - Proceso Cifrado");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ok.png"))); // NOI18N
        jLabel2.setText("  La operación se ha realizado correctamente ");

        AbrirButton.setText("Abrir Carpeta");
        AbrirButton.setActionCommand("Abrir Carpeta");
        AbrirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirButtonActionPerformed(evt);
            }
        });

        OK.setText("Aceptar");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(44, 44, 44)
                        .add(jLabel2))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(111, 111, 111)
                        .add(OK)
                        .add(29, 29, 29)
                        .add(AbrirButton)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(jLabel2)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(OK)
                    .add(AbrirButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_OKActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);
    }//GEN-LAST:event_formWindowClosing

    private void AbrirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirButtonActionPerformed
        if (Desktop.isDesktopSupported())
            try {
                Desktop.getDesktop().open(new File(ruta));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al abrir la carpeta");
            } else
                JOptionPane.showMessageDialog(this, "Esta acción no está soportada en este entorno");
    }//GEN-LAST:event_AbrirButtonActionPerformed

    /**
    * @param args the command line arguments
    */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbrirButton;
    private javax.swing.JButton OK;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
