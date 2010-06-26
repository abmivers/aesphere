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

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
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

    public ProcesoCifrarUI () {

    }

    public ProcesoCifrarUI(MainUI padre,String Texto1, String Texto2, 
            String Texto3,int opcionentrada,int opcionkey,int opcionsalida,
            int modoBloque, int tamano, boolean manualIV) {
        initComponents();
        wpadre=padre;
        cadenaInput = Texto1;
        cadenaKey = Texto2;
        cadenaOutput = Texto3;
        tamanoclave = tamano;
        blockMode = modoBloque;

        this.setSize(800, 622);
        wpadre.newchild(this);

        //Comenzamos el cifrado
        if (manualIV) {
            String strIV = JOptionPane.showInputDialog("Introduzca el IV:");
            IV = Conversor.hexStringToByte(strIV);
        }
        byte [] in = getIn (opcionentrada);
        byte [] key = getKey (opcionkey);

        int numBytes = tamanoclave / 8;
        int numWords = tamanoclave / 32;

        in= Conversor.pad(in, 16);
        if (key.length != numBytes) key = Conversor.pad(key, numBytes);

        BlockManager aesenc = null;
        byte[] salida = null;
        if (blockMode == 0) {
            aesenc = new BlockManager(key, numWords, 16, true);
            salida = aesenc.ECB(in, true);
        }
        else if (blockMode == 1) {
            aesenc = new BlockManager(key, numWords, 16, true, IV);
            salida = aesenc.CBC(in, true);
        }

        switch (opcionsalida) {
            case 0:
                jTextArea3.setText(Conversor.byteToTextString(salida));
                break;
            case 1:
                jTextArea3.setText(Conversor.byteToHexString(salida));
                break;
            case 2:
                Conversor.byteToFile(salida,cadenaOutput);
                if (opcionentrada == 2) {
                    new InfoArchivos (wpadre, cadenaOutput);
                }
        }

        if ( (opcionsalida != 2) || (opcionentrada !=2) ) {
            RondasTextArea.setText(aesenc.getResultado());
            Plaintextfield.setText(Conversor.byteToHexString(in));

            this.setLocationRelativeTo(wpadre);
            this.setVisible(true);
        }
    }

    private byte [] getBytesArchivo (String ruta) {
        byte [] aux = null;
        try {
         aux = ReadFileIntoByteArray.getBytesFromFile(new File(ruta));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al" +
                    "abrir el archivo");
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
               aux = getBytesArchivo(cadenaKey);
        }
        return aux;
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
        jLabel1 = new javax.swing.JLabel();
        Plaintextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RondasTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        cifradoMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivoCifrado = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditarCifrado = new javax.swing.JMenu();
        CopiarPlaintext = new javax.swing.JMenuItem();
        CopiarRondas = new javax.swing.JMenuItem();
        CopiarCiphertext = new javax.swing.JMenuItem();
        mainMenuAyudaCifrado = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AESphere - Proceso Cifrado");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel1.setText("Plaintext:");

        Plaintextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaintextfieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Rondas AES:");

        RondasTextArea.setColumns(20);
        RondasTextArea.setLineWrap(true);
        RondasTextArea.setRows(5);
        RondasTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(RondasTextArea);

        jLabel3.setText("Ciphertext:");

        mainMenuArchivoCifrado.setText("Archivo");

        jMenuItem2.setText("jMenuItem2");
        mainMenuArchivoCifrado.add(jMenuItem2);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        mainMenuArchivoCifrado.add(Salir);

        cifradoMenuBarMain.add(mainMenuArchivoCifrado);

        mainMenuEditarCifrado.setText("Editar");

        CopiarPlaintext.setText("Copiar Plaintext");
        CopiarPlaintext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarPlaintextActionPerformed(evt);
            }
        });
        mainMenuEditarCifrado.add(CopiarPlaintext);

        CopiarRondas.setText("Copiar Rondas AES");
        CopiarRondas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarRondasActionPerformed(evt);
            }
        });
        mainMenuEditarCifrado.add(CopiarRondas);

        CopiarCiphertext.setText("Copiar Ciphertext");
        CopiarCiphertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarCiphertextActionPerformed(evt);
            }
        });
        mainMenuEditarCifrado.add(CopiarCiphertext);

        cifradoMenuBarMain.add(mainMenuEditarCifrado);

        mainMenuAyudaCifrado.setText("Ayuda");
        cifradoMenuBarMain.add(mainMenuAyudaCifrado);

        setJMenuBar(cifradoMenuBarMain);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(50, 50, 50)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 551, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(Plaintextfield, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)))
                .add(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(35, 35, 35)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(Plaintextfield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 271, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(jLabel3))
                    .add(layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(67, 67, 67))
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

    /**
    * @param args the command line arguments
    */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CopiarCiphertext;
    private javax.swing.JMenuItem CopiarPlaintext;
    private javax.swing.JMenuItem CopiarRondas;
    private javax.swing.JTextField Plaintextfield;
    private javax.swing.JTextArea RondasTextArea;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuBar cifradoMenuBarMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JMenu mainMenuArchivoCifrado;
    private javax.swing.JMenu mainMenuAyudaCifrado;
    private javax.swing.JMenu mainMenuEditarCifrado;
    // End of variables declaration//GEN-END:variables

}
