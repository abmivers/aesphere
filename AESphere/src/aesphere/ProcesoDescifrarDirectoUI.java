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
public class ProcesoDescifrarDirectoUI extends javax.swing.JFrame {

    private String cadenaInput;
    private String cadenaKey;
    private String cadenaOutput;
    private MainUI wpadre;
    private int tamanoclave;
    private int blockMode;
    private byte [] IV = null;

    /** Creates new form ProcesoDescifrarUI */
    public ProcesoDescifrarDirectoUI(MainUI padre,String Texto1, String Texto2, 
            String Texto3,int opcionentrada,int opcionkey,int opcionsalida,
            int modoBloque, int tamano, boolean manualIV) {
        initComponents();
        wpadre=padre;
        cadenaInput = Texto1;
        cadenaKey = Texto2;
        cadenaOutput = Texto3;
        tamanoclave = tamano;
        blockMode = modoBloque;

        this.setSize(550, 300);
        wpadre.newchild(this);

        //Comenzamos el descifrado
        if (manualIV) {
            String strIV = JOptionPane.showInputDialog("Introduzca el IV:");
            IV = Conversor.hexStringToByte(strIV);
        }
        byte [] in = getIn (opcionentrada);
        byte [] key = getKey (opcionkey);

        int numBytes = tamanoclave / 8;
        int numWords = tamanoclave / 32;

        if (key.length != numBytes) key = Conversor.pad(key, numBytes);

        BlockManager aesenc = null;
        byte[] salida = null;
        if (blockMode == 0) {
            aesenc = new BlockManager(key, numWords, 16, false);
            salida = aesenc.ECB(in, false);
        }
        else if (blockMode == 1) {
            aesenc = new BlockManager(key, numWords, 16, false, IV);
            salida = aesenc.CBC(in, false);
        }        

        salida = Conversor.unpad(salida, 16);

        if (salida == null) {            
            //Mostramos una ventana de error
            JOptionPane.showMessageDialog(this, "Error de Descifrado. " +
                    "Compruebe que ha introducido correctamente los datos");
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
                if (opcionentrada == 2) {
                    //Mostramos una ventana de información
                    JOptionPane.showMessageDialog(null, "La operación se realizó correctamente",
                        "AESphere - Proceso Descifrado", JOptionPane.INFORMATION_MESSAGE,
                        new javax.swing.ImageIcon(getClass().getResource("/resources/ok.png")));
                    //Cerramos este form
                    this.dispatchEvent(new java.awt.event.WindowEvent(this,
                            java.awt.event.WindowEvent.WINDOW_CLOSING));
                }
        }

        if ( (salida != null) && ((opcionsalida != 2) || (opcionentrada !=2)) ) {
            Ciphertextfield.setText(Conversor.byteToHexString(in));

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
        Plaintextfield = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Ciphertextfield = new javax.swing.JTextArea();
        cifradoMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivoCifrado = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditarCifrado = new javax.swing.JMenu();
        CopiarCiphertext = new javax.swing.JMenuItem();
        CopiarPlaintext = new javax.swing.JMenuItem();
        mainMenuAyudaCifrado = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AESphere - Proceso Descifrado");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Plaintextfield.setColumns(20);
        Plaintextfield.setLineWrap(true);
        Plaintextfield.setRows(5);
        jScrollPane3.setViewportView(Plaintextfield);

        jLabel3.setText("Ciphertext:");

        jLabel1.setText("Plaintext:");

        Ciphertextfield.setColumns(20);
        Ciphertextfield.setLineWrap(true);
        Ciphertextfield.setRows(5);
        jScrollPane4.setViewportView(Ciphertextfield);

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

        CopiarCiphertext.setText("Copiar Ciphertext");
        CopiarCiphertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarCiphertextActionPerformed(evt);
            }
        });
        mainMenuEditarCifrado.add(CopiarCiphertext);

        CopiarPlaintext.setText("Copiar Plaintext");
        CopiarPlaintext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarPlaintextActionPerformed(evt);
            }
        });
        mainMenuEditarCifrado.add(CopiarPlaintext);

        cifradoMenuBarMain.add(mainMenuEditarCifrado);

        mainMenuAyudaCifrado.setText("Ayuda");
        cifradoMenuBarMain.add(mainMenuAyudaCifrado);

        setJMenuBar(cifradoMenuBarMain);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(34, 34, 34)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addContainerGap(352, Short.MAX_VALUE))
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

    private void CopiarPlaintextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarPlaintextActionPerformed
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(Plaintextfield.getText());
        cb.setContents(ss, ss);
}//GEN-LAST:event_CopiarPlaintextActionPerformed

    private void CopiarCiphertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarCiphertextActionPerformed
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(Ciphertextfield.getText());
        cb.setContents(ss, ss);
}//GEN-LAST:event_CopiarCiphertextActionPerformed

    /**
    * @param args the command line arguments
    */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Ciphertextfield;
    private javax.swing.JMenuItem CopiarCiphertext;
    private javax.swing.JMenuItem CopiarPlaintext;
    private javax.swing.JTextArea Plaintextfield;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuBar cifradoMenuBarMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenu mainMenuArchivoCifrado;
    private javax.swing.JMenu mainMenuAyudaCifrado;
    private javax.swing.JMenu mainMenuEditarCifrado;
    // End of variables declaration//GEN-END:variables

}
