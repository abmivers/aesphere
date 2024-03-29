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

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class MainHerramientasUI extends javax.swing.JFrame {

    private javax.swing.JFrame hijoActual;
    private MainUI wpadre;    

    public MainHerramientasUI(MainUI padre) {
        initComponents();
        setLangLabels();
        wpadre=padre;
        setHelp();
        this.setResizable(false);
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
        BotonInfo = new javax.swing.JButton();
        cifradoMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivoCifrado = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        mainMenuOperacionesCifrado = new javax.swing.JMenu();
        SubBytes = new javax.swing.JMenuItem();
        ShiftRows = new javax.swing.JMenuItem();
        MixColumns = new javax.swing.JMenuItem();
        AddRoundKey = new javax.swing.JMenuItem();
        mainMenuAyudaCifrado = new javax.swing.JMenu();
        Contenidos = new javax.swing.JMenuItem();
        acercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AESphere - Herramientas");
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

        BotonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfo.setBorder(null);
        BotonInfo.setContentAreaFilled(false);
        BotonInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInfoActionPerformed(evt);
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

        Contenidos.setText("Contenido");
        Contenidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContenidosActionPerformed(evt);
            }
        });
        mainMenuAyudaCifrado.add(Contenidos);

        acercade.setText("Acerca de");
        mainMenuAyudaCifrado.add(acercade);

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
                .addContainerGap(660, Short.MAX_VALUE)
                .add(Cancelar)
                .add(32, 32, 32)
                .add(BotonInfo)
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
                    .add(BotonInfo)
                    .add(Cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
}//GEN-LAST:event_SalirActionPerformed

    /*Traducciones*/
    private void setLangLabels() {
        this.setTitle(Entorno.getTrans("Op.title"));
        mainMenuArchivoCifrado.setText(Entorno.getTrans("gen.file"));
        Salir.setText(Entorno.getTrans("gen.exit"));        
        mainMenuOperacionesCifrado.setText(Entorno.getTrans("MainUI.op"));
        SubBytes.setText(Entorno.getTrans("Op.subBytes"));
        MixColumns.setText(Entorno.getTrans("Op.mixColums"));
        AddRoundKey.setText(Entorno.getTrans("Op.addRoundKey"));
        ShiftRows.setText(Entorno.getTrans("Op.shiftRows"));
        mainMenuAyudaCifrado.setText(Entorno.getTrans("gen.help"));
        Contenidos.setText(Entorno.getTrans("gen.cont"));
        acercade.setText(Entorno.getTrans("gen.about"));
        Cancelar.setText(Entorno.getTrans("gen.back"));
    }
    
    private void setHelp () {

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = getSize();

        try {
            File fichero = null;

            if (Entorno.getProperty("language").equals("ES"))
                fichero = new File("help/help_set_ES.hs");
            else if (Entorno.getProperty("language").equals("EN"))
                fichero = new File("help/help_set_EN.hs");
            URL hsURL = fichero.toURI().toURL();
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();
            hb.setLocation(new java.awt.Point((pantalla.width - ventana.width) / 2,
                                (pantalla.height - ventana.height) / 2));
            hb.setSize(new java.awt.Dimension(800, 628));
            hb.enableHelpOnButton(Contenidos, "ventana_herramientas", helpset);
            hb.enableHelpOnButton(BotonInfo, "ventana_herramientas", helpset);
            hb.enableHelpOnButton(acercade, "aplicacion", helpset);
        }

        catch (Exception e) {
             JOptionPane.showMessageDialog(this, Entorno.getTrans("gen.helpErrMsg"), 
                     Entorno.getTrans("gen.helpErrTitle"), JOptionPane.ERROR_MESSAGE);
        }
    }

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
        //wpadre.setEnabled(true);
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

    private void BotonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInfoActionPerformed

    }//GEN-LAST:event_BotonInfoActionPerformed

    private void ContenidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContenidosActionPerformed

}//GEN-LAST:event_ContenidosActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddRoundKey;
    private javax.swing.JButton BotonInfo;
    private javax.swing.JButton Cancelar;
    private javax.swing.JMenuItem Contenidos;
    private javax.swing.JMenuItem MixColumns;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem ShiftRows;
    private javax.swing.JMenuItem SubBytes;
    private javax.swing.JMenuItem acercade;
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
