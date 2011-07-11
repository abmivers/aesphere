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
public class ProcesoDescifrarUI extends javax.swing.JFrame {

    private String cadenaInput;
    private String cadenaKey;
    private String cadenaOutput;
    private MainUI wpadre;
    private int tamanoclave;
    private int blockMode;
    private byte [] IV = null;

    /** Creates new form ProcesoDescifrarUI */
    public ProcesoDescifrarUI(MainUI padre,String Texto1, String Texto2, 
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

        this.setSize(800, 622);
        wpadre.newchild(this);
        
        //Comenzamos el descifrado
        if (manualIV) {            
            IV = iv;
        }
        byte [] in = getIn (opcionentrada);
        byte [] key = getKey (opcionkey);

        int numWords = tamanoclave / 32;

        BlockManager aesenc = null;
        byte[] salida = null;
        if (blockMode == 0) {
            aesenc = new BlockManager(key, numWords, 16, true);
            salida = aesenc.ECB(in, false);
        }
        else if (blockMode == 1) {
            aesenc = new BlockManager(key, numWords, 16, true, IV);
            salida = aesenc.CBC(in, false);
        }

        salida = Conversor.unpad(salida, 16);
        
        if (salida == null) {            
            //Mostramos una ventana de error
            JOptionPane.showMessageDialog(this, Entorno.getTrans("AES.decErr"), 
                     Entorno.getTrans("gen.err"), JOptionPane.ERROR_MESSAGE); 
            //Lanzamos el evento de cerrado de la ventana
            this.dispatchEvent(new java.awt.event.WindowEvent(this, 
                    java.awt.event.WindowEvent.WINDOW_CLOSING));
        } else switch (opcionsalida) {
            case 0:
                Plaintextfield.setText(Conversor.byteToTextString(salida));
                break;
            case 1:
                Plaintextfield.setText(Conversor.byteToHexString(salida));
                break;
            case 2:
                Conversor.byteToFile(salida,cadenaOutput);
                Plaintextfield.setText(Conversor.byteToHexShortString(salida));
        }

        RondasTextArea.setText(aesenc.getResultado());
        CiphertextArea.setText(Conversor.byteToHexShortString(in));                    

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
                aux = Base64.decode(cadenaInput);
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
        this.setTitle(Entorno.getTrans("AES.procDecTitle"));
        mainMenuArchivo.setText(Entorno.getTrans("gen.file"));
        mainMenuEditar.setText(Entorno.getTrans("gen.edit"));
        mainMenuAyuda.setText(Entorno.getTrans("gen.help"));
        Salir.setText(Entorno.getTrans("gen.exit"));
        CopiarCiphertext.setText(Entorno.getTrans("Att.copyCipher"));
        CopiarPlaintext1.setText(Entorno.getTrans("Att.copyPlain"));        
        Contenidos.setText(Entorno.getTrans("gen.cont"));
        acercade.setText(Entorno.getTrans("gen.about"));
        plainLabel.setText(Entorno.getTrans("AES.plain"));
        cipherLabel.setText(Entorno.getTrans("AES.cipher"));        
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
            hb.enableHelpOnButton(Contenidos, "resultado_descifrado", helpset);
            hb.enableHelpOnButton(BotonInfo, "resultado_descifrado", helpset);
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
        Plaintextfield = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        RondasTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        CiphertextArea = new javax.swing.JTextArea();
        cipherLabel = new javax.swing.JLabel();
        roundsLabel = new javax.swing.JLabel();
        plainLabel = new javax.swing.JLabel();
        BotonInfo = new javax.swing.JButton();
        cifradoMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditar = new javax.swing.JMenu();
        CopiarCiphertext = new javax.swing.JMenuItem();
        CopiarRondas = new javax.swing.JMenuItem();
        CopiarPlaintext1 = new javax.swing.JMenuItem();
        mainMenuAyuda = new javax.swing.JMenu();
        Contenidos = new javax.swing.JMenuItem();
        acercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AESphere - Proceso Descifrado");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Plaintextfield.setColumns(20);
        Plaintextfield.setEditable(false);
        Plaintextfield.setLineWrap(true);
        Plaintextfield.setRows(5);
        Plaintextfield.setWrapStyleWord(true);
        jScrollPane3.setViewportView(Plaintextfield);

        RondasTextArea.setColumns(20);
        RondasTextArea.setEditable(false);
        RondasTextArea.setRows(5);
        jScrollPane4.setViewportView(RondasTextArea);

        CiphertextArea.setColumns(20);
        CiphertextArea.setEditable(false);
        CiphertextArea.setLineWrap(true);
        CiphertextArea.setRows(5);
        CiphertextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(CiphertextArea);

        cipherLabel.setText("Texto cifrado:");

        roundsLabel.setText("Rondas AES:");

        plainLabel.setText("Texto en claro:");

        BotonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfo.setBorder(null);
        BotonInfo.setContentAreaFilled(false);

        mainMenuArchivo.setText("Archivo");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        mainMenuArchivo.add(Salir);

        cifradoMenuBarMain.add(mainMenuArchivo);

        mainMenuEditar.setText("Editar");

        CopiarCiphertext.setText("Copiar Ciphertext");
        CopiarCiphertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarCiphertextActionPerformed(evt);
            }
        });
        mainMenuEditar.add(CopiarCiphertext);

        CopiarRondas.setText("Copiar Rondas AES");
        CopiarRondas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarRondasActionPerformed(evt);
            }
        });
        mainMenuEditar.add(CopiarRondas);

        CopiarPlaintext1.setText("Copiar Plaintext");
        CopiarPlaintext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarPlaintext1ActionPerformed(evt);
            }
        });
        mainMenuEditar.add(CopiarPlaintext1);

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
            .add(layout.createSequentialGroup()
                .add(49, 49, 49)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(BotonInfo)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(plainLabel)
                            .add(roundsLabel)
                            .add(cipherLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))))
                .add(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(31, 31, 31)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(cipherLabel)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(22, 22, 22)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(roundsLabel)
                    .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 248, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(BotonInfo))
                    .add(plainLabel))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void CopiarPlaintext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarPlaintext1ActionPerformed
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(Plaintextfield.getText());
        cb.setContents(ss, ss);
}//GEN-LAST:event_CopiarPlaintext1ActionPerformed

    private void CopiarRondasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarRondasActionPerformed
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(RondasTextArea.getText());
        cb.setContents(ss, ss);
}//GEN-LAST:event_CopiarRondasActionPerformed

    private void CopiarCiphertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarCiphertextActionPerformed
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(CiphertextArea.getText());
        cb.setContents(ss, ss);
}//GEN-LAST:event_CopiarCiphertextActionPerformed

    private void ContenidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContenidosActionPerformed
        
}//GEN-LAST:event_ContenidosActionPerformed

    /**
    * @param args the command line arguments
    */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonInfo;
    private javax.swing.JTextArea CiphertextArea;
    private javax.swing.JMenuItem Contenidos;
    private javax.swing.JMenuItem CopiarCiphertext;
    private javax.swing.JMenuItem CopiarPlaintext1;
    private javax.swing.JMenuItem CopiarRondas;
    private javax.swing.JTextArea Plaintextfield;
    private javax.swing.JTextArea RondasTextArea;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem acercade;
    private javax.swing.JMenuBar cifradoMenuBarMain;
    private javax.swing.JLabel cipherLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenu mainMenuArchivo;
    private javax.swing.JMenu mainMenuAyuda;
    private javax.swing.JMenu mainMenuEditar;
    private javax.swing.JLabel plainLabel;
    private javax.swing.JLabel roundsLabel;
    // End of variables declaration//GEN-END:variables

}
