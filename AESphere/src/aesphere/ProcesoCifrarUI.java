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

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;


/**
 *
 * @author antonio
 */

public class ProcesoCifrarUI extends javax.swing.JFrame {

    private String cadenaInput;
    private String cadenaKey;
    private String cadenaOutput;
    private MainUI wpadre;
    private int tamanoclave;
    private int blockMode;
    private byte[] IV = null;

    /** Creates new form ProcesoCifrarUI */

    public ProcesoCifrarUI(MainUI padre,String Texto1, String Texto2, 
            String Texto3,int opcionentrada,int opcionkey,int opcionsalida,
            int modoBloque, int tamano, boolean manualIV, byte [] iv) {
        initComponents();
        setLangLabels();
        setHelp();
        wpadre=padre;
        cadenaInput = Texto1;
        cadenaKey = Texto2;
        cadenaOutput = Texto3;
        tamanoclave = tamano;
        blockMode = modoBloque;

        this.setSize(800, 620);
        wpadre.newchild(this);

        //Comenzamos el cifrado
        if (manualIV) {            
            IV = iv;
        }
        byte [] in = getIn (opcionentrada);
        byte [] key = getKey (opcionkey);

        int numWords = tamanoclave / 32;

        in= Conversor.pad(in, 16);

        BlockManager aesenc = null;
        byte[] salida = null;
        if (blockMode == 0) {
            aesenc = new BlockManager(key, numWords, 16, true);
            salida = aesenc.ECB(in, true);
        }
        else if (blockMode == 1) {
            aesenc = new BlockManager(key, numWords, 16, true, IV);
            salida = aesenc.CBC(in, true);
            //habilitamos el campo para mostrar el IV
            ivLabel.setEnabled(true);
            ivTextArea.setEnabled(true);
            ivTextArea.setText(Conversor.byteToHexString(aesenc.getIV()));
        }

        switch (opcionsalida) {
            case 0:
                jTextArea3.setText(Base64.encodeToString(salida, true));
                break;
            case 1:
                jTextArea3.setText(Conversor.byteToHexString(salida));
                break;
            case 2:
                Conversor.byteToFile(salida,cadenaOutput);
        }

        if ( (opcionsalida != 2) || (opcionentrada !=2) ) {
            RondasTextArea.setText(aesenc.getResultado());
            Plaintextfield.setText(Conversor.byteToHexString(in));
        }

        this.setLocationRelativeTo(wpadre);
        this.setResizable(false);
        this.setVisible(true);
    }

    private byte [] getBytesArchivo (String ruta) {
        byte [] aux = null;
        try {
         aux = ReadFileIntoByteArray.getBytesFromFile(new File(ruta));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, Entorno.getTrans("gen.fileErr") +
                    ruta, Entorno.getTrans("gen.err"), JOptionPane.ERROR_MESSAGE);
        }
        return aux;
    }

    private byte [] getIn (int opcion) {
        byte [] aux = null;
        switch(opcion) {
            case 0:
                aux = Conversor.stringToASCII(cadenaInput);
                break;
            case 1:
                aux = Conversor.hexStringToByte(cadenaInput);
                break;
            case 2:
               aux = getBytesArchivo(cadenaInput);
        }
        return aux;
    }

    private byte [] getKey (int opcion) {
        byte [] aux = null;
        switch(opcion) {
            case 0:
                aux = Conversor.stringToASCII(cadenaKey);
                break;
            case 1:
                aux = Conversor.hexStringToByte(cadenaKey);
                break;
            case 2:
               aux = Base64.decode(cadenaKey);
        }
        return aux;
    }
    
    private void setLangLabels () {
        this.setTitle(Entorno.getTrans("AES.titleEnc"));
        mainMenuArchivo.setText(Entorno.getTrans("gen.file"));
        mainMenuEditar.setText(Entorno.getTrans("gen.edit"));
        mainMenuAyuda.setText(Entorno.getTrans("gen.help"));
        Salir.setText(Entorno.getTrans("gen.exit"));
        CopiarCiphertext.setText(Entorno.getTrans("Att.copyCipher"));
        CopiarPlaintext.setText(Entorno.getTrans("Att.copyPlain"));
        copyIVMenu.setText(Entorno.getTrans("AES.copyIV"));
        Contenidos.setText(Entorno.getTrans("gen.cont"));
        acercade.setText(Entorno.getTrans("gen.about"));
        plainLabel.setText(Entorno.getTrans("AES.plain"));
        cipherLabel.setText(Entorno.getTrans("AES.cipher"));
        ivLabel.setText(Entorno.getTrans("AES.ivTxt"));
        roundsLabel.setText(Entorno.getTrans("AES.roundsTxt"));
        CopiarRondas.setText(Entorno.getTrans("AES.copyRounds"));
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
            hb.enableHelpOnButton(Contenidos, "ventana_shiftrows", helpset);
            hb.enableHelpOnButton(BotonInfo, "ventana_shiftrows", helpset);
            hb.enableHelpOnButton(acercade, "aplicacion", helpset);
        }

        catch (Exception e) {
             JOptionPane.showMessageDialog(this, Entorno.getTrans("gen.helpErrMsg"), 
                     Entorno.getTrans("gen.helpErrTitle"), JOptionPane.ERROR_MESSAGE);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        plainLabel = new javax.swing.JLabel();
        Plaintextfield = new javax.swing.JTextField();
        roundsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RondasTextArea = new javax.swing.JTextArea();
        cipherLabel = new javax.swing.JLabel();
        BotonInfo = new javax.swing.JButton();
        ivLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ivTextArea = new javax.swing.JTextArea();
        cifradoMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditar = new javax.swing.JMenu();
        CopiarPlaintext = new javax.swing.JMenuItem();
        CopiarRondas = new javax.swing.JMenuItem();
        CopiarCiphertext = new javax.swing.JMenuItem();
        copyIVMenu = new javax.swing.JMenuItem();
        mainMenuAyuda = new javax.swing.JMenu();
        Contenidos = new javax.swing.JMenuItem();
        acercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AESphere - Proceso Cifrado");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setEditable(false);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        plainLabel.setText("Texto en claro:");

        Plaintextfield.setEditable(false);
        Plaintextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaintextfieldActionPerformed(evt);
            }
        });

        roundsLabel.setText("Rondas AES:");

        RondasTextArea.setColumns(20);
        RondasTextArea.setEditable(false);
        RondasTextArea.setLineWrap(true);
        RondasTextArea.setRows(5);
        RondasTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(RondasTextArea);

        cipherLabel.setText("Ciphertext:");

        BotonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfo.setBorder(null);
        BotonInfo.setContentAreaFilled(false);

        ivLabel.setText("Vector de inicialización:");
        ivLabel.setEnabled(false);

        ivTextArea.setColumns(20);
        ivTextArea.setEditable(false);
        ivTextArea.setLineWrap(true);
        ivTextArea.setRows(1);
        ivTextArea.setEnabled(false);
        jScrollPane4.setViewportView(ivTextArea);

        mainMenuArchivo.setText("Archivo");

        jMenuItem2.setText("jMenuItem2");
        mainMenuArchivo.add(jMenuItem2);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        mainMenuArchivo.add(Salir);

        cifradoMenuBarMain.add(mainMenuArchivo);

        mainMenuEditar.setText("Editar");

        CopiarPlaintext.setText("Copiar Plaintext");
        CopiarPlaintext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarPlaintextActionPerformed(evt);
            }
        });
        mainMenuEditar.add(CopiarPlaintext);

        CopiarRondas.setText("Copiar Rondas AES");
        CopiarRondas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarRondasActionPerformed(evt);
            }
        });
        mainMenuEditar.add(CopiarRondas);

        CopiarCiphertext.setText("Copiar Ciphertext");
        CopiarCiphertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarCiphertextActionPerformed(evt);
            }
        });
        mainMenuEditar.add(CopiarCiphertext);

        copyIVMenu.setText("Copiar IV");
        copyIVMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyIVMenuActionPerformed(evt);
            }
        });
        mainMenuEditar.add(copyIVMenu);

        cifradoMenuBarMain.add(mainMenuEditar);

        mainMenuAyuda.setText("Ayuda");

        Contenidos.setText("Contenido");
        Contenidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContenidosActionPerformed(evt);
            }
        });
        mainMenuAyuda.add(Contenidos);

        acercade.setText("Acerca de");
        mainMenuAyuda.add(acercade);

        cifradoMenuBarMain.add(mainMenuAyuda);

        setJMenuBar(cifradoMenuBarMain);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(BotonInfo))
                    .add(layout.createSequentialGroup()
                        .add(27, 27, 27)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(ivLabel)
                            .add(roundsLabel)
                            .add(cipherLabel)
                            .add(plainLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                            .add(Plaintextfield, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(35, 35, 35)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Plaintextfield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(plainLabel))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(roundsLabel)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 271, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(cipherLabel)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ivLabel)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(BotonInfo)))
                .add(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);       
    }//GEN-LAST:event_formWindowClosing

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
}//GEN-LAST:event_SalirActionPerformed

    private void PlaintextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaintextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlaintextfieldActionPerformed

    private void CopiarPlaintextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarPlaintextActionPerformed
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(Plaintextfield.getText());
        cb.setContents(ss, ss);
}//GEN-LAST:event_CopiarPlaintextActionPerformed

    private void CopiarRondasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarRondasActionPerformed
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(RondasTextArea.getText());
        cb.setContents(ss, ss);
}//GEN-LAST:event_CopiarRondasActionPerformed

    private void CopiarCiphertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarCiphertextActionPerformed
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(jTextArea3.getText());
        cb.setContents(ss, ss);
    }//GEN-LAST:event_CopiarCiphertextActionPerformed

private void ContenidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContenidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContenidosActionPerformed

private void copyIVMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyIVMenuActionPerformed
    Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
    StringSelection ss = new StringSelection(ivTextArea.getText());
    cb.setContents(ss, ss);
}//GEN-LAST:event_copyIVMenuActionPerformed

    /**
    * @param args the command line arguments
    */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonInfo;
    private javax.swing.JMenuItem Contenidos;
    private javax.swing.JMenuItem CopiarCiphertext;
    private javax.swing.JMenuItem CopiarPlaintext;
    private javax.swing.JMenuItem CopiarRondas;
    private javax.swing.JTextField Plaintextfield;
    private javax.swing.JTextArea RondasTextArea;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem acercade;
    private javax.swing.JMenuBar cifradoMenuBarMain;
    private javax.swing.JLabel cipherLabel;
    private javax.swing.JMenuItem copyIVMenu;
    private javax.swing.JLabel ivLabel;
    private javax.swing.JTextArea ivTextArea;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JMenu mainMenuArchivo;
    private javax.swing.JMenu mainMenuAyuda;
    private javax.swing.JMenu mainMenuEditar;
    private javax.swing.JLabel plainLabel;
    private javax.swing.JLabel roundsLabel;
    // End of variables declaration//GEN-END:variables

}
