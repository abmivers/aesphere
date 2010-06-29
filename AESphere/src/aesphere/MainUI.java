/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on 05-may-2010, 16:25:19
 */
package aesphere;
//import java.net.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;




/**
 *
 * @author admin
 */
public class MainUI extends javax.swing.JFrame {

    private javax.swing.JFrame hijoActual;
    private String helpErrMsg = "Ha ocurrido un error al cargar la ayuda de la aplicación";
    private String helpErrTitle = "Ayuda - Aviso";

    /** Creates new form Main */
    public MainUI() {
        initComponents();
        setLangLabels();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = getSize();
         
        try {

        File fichero = new File("./help/help_set.hs");
        URL hsURL = fichero.toURI().toURL();
        HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
        HelpBroker hb = helpset.createHelpBroker();
        hb.setLocation(new java.awt.Point((pantalla.width - ventana.width) / 2,
                                (pantalla.height - ventana.height) / 2));
        hb.setSize(new java.awt.Dimension(800, 628));
        hb.enableHelpOnButton(Contenidos, "aplicacion", helpset);
        hb.enableHelpOnButton(BotonInfo, "aplicacion", helpset);
        }

        catch (Exception e) {
             JOptionPane.showMessageDialog(this, helpErrMsg, helpErrTitle,
                     JOptionPane.ERROR_MESSAGE);
        }


    }


    /** Sets all the titles of the interface elements */
    private void setLangLabels () {
        if (Entorno.getProperty("language").equals("ES")) {
            this.setTitle("AESphere - Ventana Principal");
            CifrarLabel.setText("CIFRAR");
            DescifrarLabel.setText("DESCIFRAR");
            AtaquesLabel.setText("SIMULAR ATAQUES");
            HerramientasLabel.setText("HERRAMIENTAS");
            mainMenuArchivo.setText("Archivo");
            Salir.setText("Salir");
            mainMenuOperaciones.setText("Operaciones");
            mainMenuAyuda.setText("Ayuda");
            Cifrar.setText("Cifrar");
            Descifrar.setText("Descifrar");
            SimularAtaques.setText("Simular ataques");
            Herramientas.setText("Herramientas");
            Contenidos.setText("Contenido");
            helpErrMsg = "Ha ocurrido un error al cargar la ayuda de la aplicación";
            helpErrTitle = "Ayuda - Aviso";
        }
        else if (Entorno.getProperty("language").equals("EN")) {
            this.setTitle("AESphere - Main Window");
            CifrarLabel.setText("ENCRYPT");
            DescifrarLabel.setText("DECRYPT");
            AtaquesLabel.setText("SIMULATE ATTACKS");
            HerramientasLabel.setText("TOOLS");
            mainMenuArchivo.setText("File");
            Salir.setText("Exit");
            mainMenuOperaciones.setText("Actions");
            mainMenuAyuda.setText("Help");
            Cifrar.setText("Encrypt");
            Descifrar.setText("Decrypt");
            SimularAtaques.setText("Simulate attacks");
            Herramientas.setText("Tools");
            Contenidos.setText("Contents");
            helpErrMsg = "An error has occurred while loading program help";
            helpErrTitle = "Help - Warning";
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        MainScrollPane = new javax.swing.JScrollPane();
        MainPanel = new javax.swing.JPanel();
        HerramientasLabel = new javax.swing.JLabel();
        BotonHerramientas = new javax.swing.JButton();
        AtaquesLabel = new javax.swing.JLabel();
        BotonAtaques = new javax.swing.JButton();
        DescifrarLabel = new javax.swing.JLabel();
        BotonDescifrar = new javax.swing.JButton();
        CifrarLabel = new javax.swing.JLabel();
        BotonCifrar = new javax.swing.JButton();
        BotonInfo = new javax.swing.JButton();
        EnglishButton = new javax.swing.JButton();
        SpanishButton = new javax.swing.JButton();
        mainMenuBar = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        mainMenuOperaciones = new javax.swing.JMenu();
        Cifrar = new javax.swing.JMenuItem();
        Descifrar = new javax.swing.JMenuItem();
        ComprobarVectores = new javax.swing.JMenuItem();
        SimularAtaques = new javax.swing.JMenuItem();
        Herramientas = new javax.swing.JMenuItem();
        mainMenuAyuda = new javax.swing.JMenu();
        Contenidos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainScrollPane.setPreferredSize(new java.awt.Dimension(700, 500));

        MainPanel.setPreferredSize(new java.awt.Dimension(700, 500));

        HerramientasLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
        HerramientasLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HerramientasLabel.setText("HERRAMIENTAS");

        BotonHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/herramientas.png"))); // NOI18N
        BotonHerramientas.setBorder(null);
        BotonHerramientas.setBorderPainted(false);
        BotonHerramientas.setContentAreaFilled(false);
        BotonHerramientas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonHerramientas.setFocusPainted(false);
        BotonHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonHerramientasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BotonHerramientasMouseReleased(evt);
            }
        });
        BotonHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonHerramientasActionPerformed(evt);
            }
        });

        AtaquesLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
        AtaquesLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AtaquesLabel.setText("SIMULAR ATAQUES");

        BotonAtaques.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ataques.png"))); // NOI18N
        BotonAtaques.setBorder(null);
        BotonAtaques.setBorderPainted(false);
        BotonAtaques.setContentAreaFilled(false);
        BotonAtaques.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonAtaques.setFocusPainted(false);
        BotonAtaques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAtaquesActionPerformed(evt);
            }
        });

        DescifrarLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
        DescifrarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DescifrarLabel.setText("DESCIFRAR");

        BotonDescifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/unlock3.png"))); // NOI18N
        BotonDescifrar.setBorder(null);
        BotonDescifrar.setBorderPainted(false);
        BotonDescifrar.setContentAreaFilled(false);
        BotonDescifrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonDescifrar.setFocusPainted(false);
        BotonDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDescifrarActionPerformed(evt);
            }
        });

        CifrarLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
        CifrarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CifrarLabel.setText("CIFRAR");

        BotonCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lock2.png"))); // NOI18N
        BotonCifrar.setBorder(null);
        BotonCifrar.setBorderPainted(false);
        BotonCifrar.setContentAreaFilled(false);
        BotonCifrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCifrar.setFocusPainted(false);
        BotonCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCifrarActionPerformed(evt);
            }
        });

        BotonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfo.setBorder(null);
        BotonInfo.setBorderPainted(false);
        BotonInfo.setContentAreaFilled(false);
        BotonInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonInfo.setFocusPainted(false);
        BotonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInfoActionPerformed(evt);
            }
        });

        EnglishButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/english.png"))); // NOI18N
        EnglishButton.setBorder(null);
        EnglishButton.setBorderPainted(false);
        EnglishButton.setContentAreaFilled(false);
        EnglishButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EnglishButton.setFocusPainted(false);
        EnglishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnglishButtonActionPerformed(evt);
            }
        });

        SpanishButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/spanish.png"))); // NOI18N
        SpanishButton.setBorder(null);
        SpanishButton.setBorderPainted(false);
        SpanishButton.setContentAreaFilled(false);
        SpanishButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SpanishButton.setFocusPainted(false);
        SpanishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpanishButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(BotonAtaques)
                        .addGap(50, 50, 50)
                        .addComponent(AtaquesLabel))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(BotonDescifrar)
                        .addGap(50, 50, 50)
                        .addComponent(DescifrarLabel))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(BotonCifrar)
                        .addGap(50, 50, 50)
                        .addComponent(CifrarLabel))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(BotonHerramientas)
                        .addGap(50, 50, 50)
                        .addComponent(HerramientasLabel)))
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SpanishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(EnglishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 707, Short.MAX_VALUE)
                .addComponent(BotonInfo)
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CifrarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(BotonCifrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescifrarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(BotonDescifrar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AtaquesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(BotonAtaques, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HerramientasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(BotonHerramientas, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpanishButton)
                    .addComponent(EnglishButton)
                    .addComponent(BotonInfo))
                .addGap(12, 12, 12))
        );

        MainScrollPane.setViewportView(MainPanel);

        mainMenuArchivo.setText("Archivo");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        mainMenuArchivo.add(Salir);

        mainMenuBar.add(mainMenuArchivo);

        mainMenuOperaciones.setText("Operaciones");

        Cifrar.setText("Cifrar");
        Cifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CifrarActionPerformed(evt);
            }
        });
        mainMenuOperaciones.add(Cifrar);

        Descifrar.setText("Descifrar");
        Descifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescifrarActionPerformed(evt);
            }
        });
        mainMenuOperaciones.add(Descifrar);

        ComprobarVectores.setText("Comprobar Vectores");
        ComprobarVectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprobarVectoresActionPerformed(evt);
            }
        });
        mainMenuOperaciones.add(ComprobarVectores);

        SimularAtaques.setText("Simular Ataques");
        SimularAtaques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimularAtaquesActionPerformed(evt);
            }
        });
        mainMenuOperaciones.add(SimularAtaques);

        Herramientas.setText("Herramientas");
        Herramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HerramientasActionPerformed(evt);
            }
        });
        mainMenuOperaciones.add(Herramientas);

        mainMenuBar.add(mainMenuOperaciones);

        mainMenuAyuda.setText("Ayuda");
        mainMenuAyuda.setComponentPopupMenu(jPopupMenu1);

        Contenidos.setText("Contenido");
        Contenidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContenidosActionPerformed(evt);
            }
        });
        mainMenuAyuda.add(Contenidos);

        mainMenuBar.add(mainMenuAyuda);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDescifrarActionPerformed
         
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new MainDescifrarUI(this);
            hijoActual.setLocationRelativeTo(this);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_BotonDescifrarActionPerformed

    private void BotonAtaquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAtaquesActionPerformed
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new MainAtaquesUI(this);
            hijoActual.setLocationRelativeTo(this);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_BotonAtaquesActionPerformed

    private void BotonCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCifrarActionPerformed
      
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new MainCifrarUI(this);
            hijoActual.setLocationRelativeTo(this);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_BotonCifrarActionPerformed

    private void BotonHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonHerramientasActionPerformed
         
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new MainHerramientasUI(this);
            hijoActual.setLocationRelativeTo(this);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_BotonHerramientasActionPerformed

    private void BotonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInfoActionPerformed
         
    }//GEN-LAST:event_BotonInfoActionPerformed

    private void BotonHerramientasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonHerramientasMousePressed
         
        //BotonHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/herramientasPres.png")));

    }//GEN-LAST:event_BotonHerramientasMousePressed

    private void BotonHerramientasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonHerramientasMouseReleased
         
        //BotonHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/herramientas.png")));

    }//GEN-LAST:event_BotonHerramientasMouseReleased

    private void CifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CifrarActionPerformed

        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new MainCifrarUI(this);
            hijoActual.setLocationRelativeTo(this);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
}//GEN-LAST:event_CifrarActionPerformed

    private void DescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescifrarActionPerformed

        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new MainDescifrarUI(this);
            hijoActual.setLocationRelativeTo(this);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();

}//GEN-LAST:event_DescifrarActionPerformed

    private void HerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HerramientasActionPerformed

        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new MainHerramientasUI(this);
            hijoActual.setLocationRelativeTo(this);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();

}//GEN-LAST:event_HerramientasActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed

        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
}//GEN-LAST:event_SalirActionPerformed

    private void SimularAtaquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimularAtaquesActionPerformed
    }//GEN-LAST:event_SimularAtaquesActionPerformed

    private void SpanishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpanishButtonActionPerformed
        if (!Entorno.getProperty("language").equals("ES")) {
            int resul = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea cambiar el idioma a Español?",
                    "Idioma - Aviso", JOptionPane.OK_CANCEL_OPTION);
            if (resul == 0) {
                Entorno.setProperty("language", "ES");
                setLangLabels();
            }
        }
    }//GEN-LAST:event_SpanishButtonActionPerformed

    private void EnglishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnglishButtonActionPerformed
        if (!Entorno.getProperty("language").equals("EN")) {
            int resul = JOptionPane.showConfirmDialog(this,
                    "Are you sure that you want to change language to English?",
                    "Language - Warning", JOptionPane.OK_CANCEL_OPTION);
            if (resul == 0) {
                Entorno.setProperty("language","EN");
                setLangLabels();
            }
        }
    }//GEN-LAST:event_EnglishButtonActionPerformed

    private void ContenidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContenidosActionPerformed

    }//GEN-LAST:event_ContenidosActionPerformed

    private void ComprobarVectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprobarVectoresActionPerformed
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new CifrarDescifrarSimple(this);
            hijoActual.setLocationRelativeTo(this);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_ComprobarVectoresActionPerformed

    public void wclosed (javax.swing.JFrame hijo){
        if (hijoActual.equals(hijo)) {
            hijoActual.dispose();
            hijoActual = null;            
        }        
    }

    public void newchild (javax.swing.JFrame newhijo){
        if (hijoActual == null) hijoActual = newhijo;
        else {
            hijoActual.dispose();
            hijoActual = newhijo;
        }
    }

    /**
    * @param args the command line arguments
    */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AtaquesLabel;
    private javax.swing.JButton BotonAtaques;
    private javax.swing.JButton BotonCifrar;
    private javax.swing.JButton BotonDescifrar;
    private javax.swing.JButton BotonHerramientas;
    private javax.swing.JButton BotonInfo;
    private javax.swing.JMenuItem Cifrar;
    private javax.swing.JLabel CifrarLabel;
    private javax.swing.JMenuItem ComprobarVectores;
    private javax.swing.JMenuItem Contenidos;
    private javax.swing.JMenuItem Descifrar;
    private javax.swing.JLabel DescifrarLabel;
    private javax.swing.JButton EnglishButton;
    private javax.swing.JMenuItem Herramientas;
    private javax.swing.JLabel HerramientasLabel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JScrollPane MainScrollPane;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem SimularAtaques;
    private javax.swing.JButton SpanishButton;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JMenu mainMenuArchivo;
    private javax.swing.JMenu mainMenuAyuda;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenu mainMenuOperaciones;
    // End of variables declaration//GEN-END:variables

}
