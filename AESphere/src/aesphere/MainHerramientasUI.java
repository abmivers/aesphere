/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainHerramientasUI.java
 *
 * Created on 10-jun-2010, 17:12:58
 */

package aesphere;

/**
 *
 * @author antonio
 */
public class MainHerramientasUI extends javax.swing.JFrame {

    private javax.swing.JFrame hijoActual;
    private MainUI wpadre;

    public MainHerramientasUI(MainUI padre) {
        initComponents();
        wpadre=padre;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        BotonInfoCifrar = new javax.swing.JButton();
        cifradoMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivoCifrado = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        mainMenuOperacionesCifrado = new javax.swing.JMenu();
        SubBytes = new javax.swing.JMenuItem();
        ShiftRows = new javax.swing.JMenuItem();
        MixColumns = new javax.swing.JMenuItem();
        AddRoundKey = new javax.swing.JMenuItem();
        mainMenuAyudaCifrado = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/subbytes.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shiftrows.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/AddRoundKey.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mixcolumns.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Cancelar.setLabel("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        BotonInfoCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfoCifrar.setBorder(null);
        BotonInfoCifrar.setContentAreaFilled(false);
        BotonInfoCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInfoCifrarActionPerformed(evt);
            }
        });

        mainMenuArchivoCifrado.setText("Archivo");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        mainMenuArchivoCifrado.add(Salir);

        cifradoMenuBarMain.add(mainMenuArchivoCifrado);

        mainMenuOperacionesCifrado.setText("Operaciones");

        SubBytes.setText("SubBytes");
        SubBytes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubBytesActionPerformed(evt);
            }
        });
        mainMenuOperacionesCifrado.add(SubBytes);

        ShiftRows.setText("ShiftRows");
        ShiftRows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShiftRowsActionPerformed(evt);
            }
        });
        mainMenuOperacionesCifrado.add(ShiftRows);

        MixColumns.setText("MixColumns");
        MixColumns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MixColumnsActionPerformed(evt);
            }
        });
        mainMenuOperacionesCifrado.add(MixColumns);

        AddRoundKey.setText("AddRoundKey");
        AddRoundKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRoundKeyActionPerformed(evt);
            }
        });
        mainMenuOperacionesCifrado.add(AddRoundKey);

        cifradoMenuBarMain.add(mainMenuOperacionesCifrado);

        mainMenuAyudaCifrado.setText("Ayuda");
        cifradoMenuBarMain.add(mainMenuAyudaCifrado);

        setJMenuBar(cifradoMenuBarMain);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 375, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 375, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 375, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 375, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(638, Short.MAX_VALUE)
                .add(Cancelar)
                .add(32, 32, 32)
                .add(BotonInfoCifrar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(32, 32, 32)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 219, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 219, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 219, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 219, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 52, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(BotonInfoCifrar)
                    .add(Cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
}//GEN-LAST:event_SalirActionPerformed

    public void wclosed (javax.swing.JFrame hijo){
        if (hijoActual.equals(hijo)) {
            hijoActual.dispose();
            hijoActual = null;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new ProcesoSubBytesUI(this);
            hijoActual.setLocationRelativeTo(null);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new ProcesoShiftRowsUI(this);
            hijoActual.setLocationRelativeTo(null);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new ProcesoAddRoundKeyUI(this);
            hijoActual.setLocationRelativeTo(null);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed




    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new ProcesoMixColumnsUI(this);
            hijoActual.setLocationRelativeTo(null);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);
    }//GEN-LAST:event_formWindowClosing

    private void SubBytesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubBytesActionPerformed
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new ProcesoSubBytesUI(this);
            hijoActual.setLocationRelativeTo(null);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_SubBytesActionPerformed

    private void ShiftRowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShiftRowsActionPerformed
       this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new ProcesoShiftRowsUI(this);
            hijoActual.setLocationRelativeTo(null);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_ShiftRowsActionPerformed

    private void MixColumnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MixColumnsActionPerformed
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new ProcesoMixColumnsUI(this);
            hijoActual.setLocationRelativeTo(null);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_MixColumnsActionPerformed

    private void AddRoundKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRoundKeyActionPerformed
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new ProcesoAddRoundKeyUI(this);
            hijoActual.setLocationRelativeTo(null);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_AddRoundKeyActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed

        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
}//GEN-LAST:event_CancelarActionPerformed

    private void BotonInfoCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInfoCifrarActionPerformed

    }//GEN-LAST:event_BotonInfoCifrarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddRoundKey;
    private javax.swing.JButton BotonInfoCifrar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JMenuItem MixColumns;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem ShiftRows;
    private javax.swing.JMenuItem SubBytes;
    private javax.swing.JMenuBar cifradoMenuBarMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu mainMenuArchivoCifrado;
    private javax.swing.JMenu mainMenuAyudaCifrado;
    private javax.swing.JMenu mainMenuOperacionesCifrado;
    // End of variables declaration//GEN-END:variables

}
