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

import java.io.File;


/**
 *
 * @author antonio
 */

public class ProcesoCifrarDirectoUI extends javax.swing.JFrame {

    private String cadenaInput;
    private String cadenaKey;
    private String cadenaOutput;
    private MainUI wpadre;
    private int tamanoclave;
    private int blockMode;

    /** Creates new form ProcesoCifrarUI */

    public ProcesoCifrarDirectoUI () {

    }

    public ProcesoCifrarDirectoUI(MainUI padre,String Texto1, String Texto2, 
            String Texto3,int opcionentrada,int opcionkey,int opcionsalida,
            int modoBloque, int tamano) {
        initComponents();
        wpadre=padre;
        cadenaInput = Texto1;
        cadenaKey = Texto2;
        cadenaOutput = Texto3;
        tamanoclave = tamano;
        blockMode = modoBloque;

        this.setSize(550, 300);

        byte[] salida = new byte[16];

        if (opcionentrada==2 & opcionkey==2){
            salida=cifrarArchivoArchivo();
        }

         if (opcionentrada==1 & opcionkey==1){
            salida=cifrarHexaHexa();
        }

         if (opcionentrada==2 & opcionkey==1){
            salida=cifrarArchivoHexa();
        }

         if (opcionentrada==1 & opcionkey==2){
            salida=cifrarHexaArchivo();
        }

         if (opcionentrada==0 & opcionkey==0){
            salida=cifrarTextoTexto();
        }

         if (opcionentrada==0 & opcionkey==1){
            salida=cifrarTextoHexa();
        }

         if (opcionentrada==0 & opcionkey==2){
            salida=cifrarTextoArchivo();
        }

         if (opcionentrada==1 & opcionkey==0){
            salida=cifrarHexaTexto();
        }

         if (opcionentrada==2 & opcionkey==0){
            salida=cifrarArchivoTexto();
        }

        
        
        if (opcionsalida==0) {
          jTextArea3.setText(Conversor.byteToTextString(salida));
            
        } else if (opcionsalida == 1){
                jTextArea3.setText(Conversor.byteToHexString(salida));
               }
        else if (opcionsalida==2){
            Conversor.byteToFile(salida,cadenaOutput) ;
            //jTextArea3.setText(Conversor.byteToHexString(salida));
            
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
        jLabel1 = new javax.swing.JLabel();
        Plaintextfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cifradoMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivoCifrado = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditarCifrado = new javax.swing.JMenu();
        mainMenuOperacionesCifrado = new javax.swing.JMenu();
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
        cifradoMenuBarMain.add(mainMenuEditarCifrado);

        mainMenuOperacionesCifrado.setText("Operaciones");
        cifradoMenuBarMain.add(mainMenuOperacionesCifrado);

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
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                    .add(Plaintextfield, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(40, 40, 40)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(Plaintextfield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(37, 37, 37)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(357, 357, 357))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);       
    }//GEN-LAST:event_formWindowClosing


    private byte [] cifrarArchivoTexto (){

        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        switch (tamanoclave) {

            case 128: {
                a1 = 16;
                a2 = 16;
                a3 = 4;
                break;
                }

            case 192: {
                a1 = 16;
                a2 = 24;
                a3 = 6;
                break;
                }

            case 256: {
                a1 = 16;
                a2 = 32;
                a3 = 8;
                break;
                }

        }

        byte [] in = null;

        try {
         in = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaInput));

        }
        catch (Exception e){
            e.printStackTrace();
        }

        in= Conversor.pad(in, 16);

        byte[] key = Conversor.stringToASCII(cadenaKey);
        //Para las claves sólo hay que rellenar si no son del tamaño necesario
        if (key.length != a2) key = Conversor.pad(key, a2);
        //BlockManager se encargará de cifrar
        BlockManager aes = new BlockManager(key, a3, 16, false);

        byte[] out = null;
        if (blockMode == 0) out = aes.ECB(in, true);
        else if (blockMode == 1) out = aes.CBC(in, true);
        
        //Plaintextfield.setText(Conversor.byteToHexString(in));
        return out;
    }

    private byte[] cifrarHexaTexto (){

        int a = 0;
      int b = 0;

      if (tamanoclave == 128) {
           a=16;
           b=4;
      }

      if (tamanoclave == 192) {
           a=24;
           b=6;
      }

      if (tamanoclave == 256) {
           a=32;
           b=8;
      }

      byte[] in = Conversor.hexStringToByte(cadenaInput);
      in = Conversor.pad(in, 16);
      byte[] key = Conversor.stringToASCII(cadenaKey);
      if (key.length != a) key = Conversor.pad(key, a);

      BlockManager aes = new BlockManager(key, b, 16, false);

      byte[] out = null;
      if (blockMode == 0) out = aes.ECB(in, true);
      else if (blockMode == 1) out = aes.CBC(in, true);
      
      Plaintextfield.setText(Conversor.byteToHexString(in));

      return out;
    }

    private byte[] cifrarTextoArchivo (){

        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        switch (tamanoclave) {

            case 128: {
                a1 = 16;
                a2 = 16;
                a3 = 4;
                break;
                }

            case 192: {
                a1 = 16;
                a2 = 24;
                a3 = 6;
                break;
                }

            case 256: {
                a1 = 16;
                a2 = 32;
                a3 = 8;
                break;
                }

        }

        byte[] in = Conversor.stringToASCII(cadenaInput);
        in = Conversor.pad(in, 16);

        byte[] key = null;
        try {
         key = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaKey));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if (key.length != a2) key = Conversor.pad(key, a2);

        BlockManager aes = new BlockManager(key, a3, 16, false);

        byte[] out = null;
        if (blockMode == 0) out = aes.ECB(in, true);
        else if (blockMode == 1) out = aes.CBC(in, true);
        Plaintextfield.setText(Conversor.byteToHexString(in));
        return out;
    }

    private byte[] cifrarTextoHexa (){
      int a = 0;
      int b = 0;

      if (tamanoclave == 128) {
           a=16;
           b=4;
      }

      if (tamanoclave == 192) {
           a=24;
           b=6;
      }

      if (tamanoclave == 256) {
           a=32;
           b=8;
      }

      byte[] in = Conversor.stringToASCII(cadenaInput);
      in = Conversor.pad(in, 16);
      byte[] key = Conversor.hexStringToByte(cadenaKey);
      if (key.length != a) key = Conversor.pad(key, a);

      BlockManager aes = new BlockManager(key, b, 16, false);

      byte[] out = null;
      if (blockMode == 0) out = aes.ECB(in, true);
      else if (blockMode == 1) out = aes.CBC(in, true);
      Plaintextfield.setText(Conversor.byteToHexString(in));
      return out;
    }

    private byte[] cifrarTextoTexto (){
      int a = 0;
      int b = 0;

      if (tamanoclave == 128) {
           a=16;
           b=4;
      }

      if (tamanoclave == 192) {
           a=24;
           b=6;
      }

      if (tamanoclave == 256) {
           a=32;
           b=8;
      }

      byte[] in = Conversor.stringToASCII(cadenaInput);
      in = Conversor.pad(in, 16);
      byte[] key = Conversor.stringToASCII(cadenaKey);
      if (key.length != a) key = Conversor.pad(key, a);

      BlockManager aes = new BlockManager(key, b, 16, false);

      byte[] out = null;
      if (blockMode == 0) out = aes.ECB(in, true);
      else if (blockMode == 1) out = aes.CBC(in, true);
      Plaintextfield.setText(Conversor.byteToHexString(in));

      return out;
    }



    private byte[] cifrarHexaArchivo(){

        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        switch (tamanoclave) {

            case 128: {
                a1 = 16;
                a2 = 16;
                a3 = 4;
                break;
                }

            case 192: {
                a1 = 16;
                a2 = 24;
                a3 = 6;
                break;
                }

            case 256: {
                a1 = 16;
                a2 = 32;
                a3 = 8;
                break;
                }

        }

        byte[] in = Conversor.hexStringToByte(cadenaInput);
        in = Conversor.pad(in, 16);

        byte [] key = null;
        try {
         key = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaKey));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if (key.length != a2) key = Conversor.pad(key, a2);

        BlockManager aes = new BlockManager(key, a3, 16, false);

        byte[] out = null;
        if (blockMode == 0) out = aes.ECB(in, true);
        else if (blockMode == 1) out = aes.CBC(in, true);
        Plaintextfield.setText(Conversor.byteToHexString(in));
        return out;
    }

    private byte[] cifrarArchivoHexa (){

        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        switch (tamanoclave) {

            case 128: {
                a1 = 16;
                a2 = 16;
                a3 = 4;
                break;
                }

            case 192: {
                a1 = 16;
                a2 = 24;
                a3 = 6;
                break;
                }

            case 256: {
                a1 = 16;
                a2 = 32;
                a3 = 8;
                break;
                }

        }

        byte [] in = null;
        try {
         in = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaInput));

        }
        catch (Exception e){
            e.printStackTrace();
        }

        in= Conversor.pad(in, 16);

        byte[] key = Conversor.hexStringToByte(cadenaKey);
        if (key.length != a2) key = Conversor.pad(key, a2);

        BlockManager aes = new BlockManager(key, a3, 16, false);

        byte[] out = null;
        if (blockMode == 0) out = aes.ECB(in, true);
        else if (blockMode == 1) out = aes.CBC(in, true);
        Plaintextfield.setText(Conversor.byteToHexString(in));
        return out;
    }


    private byte[] cifrarHexaHexa (){

      //hay que hacer algo con el tema del tamaño de clave
      //rellenar con c0 hasta tamaño de clave o con ceros?
      int a = 0;
      int b = 0;

      if (tamanoclave == 128) {
           a=16;
           b=4;
      }

      if (tamanoclave == 192) {
           a=24;
           b=6;
      }

      if (tamanoclave == 256) {
           a=32;
           b=8;
      }

      byte[] in = Conversor.hexStringToByte(cadenaInput);
      in = Conversor.pad(in, 16);
      byte[] key = Conversor.hexStringToByte(cadenaKey);
      if (key.length != a) key = Conversor.pad(key, a);

      BlockManager aes = new BlockManager(key, b, 16, false);
      
      byte[] out = null;
      if (blockMode == 0) out = aes.ECB(in, true);
      else if (blockMode == 1) out = aes.CBC(in, true);
      Plaintextfield.setText(Conversor.byteToHexString(in));
      return out;
    }




    private byte[] cifrarArchivoArchivo (){

        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        switch (tamanoclave) {

            case 128: {
                a1 = 16;
                a2 = 16;
                a3 = 4;
                break;
                }

            case 192: {
                a1 = 16;
                a2 = 24;
                a3 = 6;
                break;
                }

            case 256: {
                a1 = 16;
                a2 = 32;
                a3 = 8;
                break;
                }

        }

        byte [] in = null;
        byte [] key = null;


        try {
         in = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaInput));
         key = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaKey));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        in = Conversor.pad(in, 16);
        key = Conversor.pad(key, a2);

        BlockManager aes = new BlockManager(key, a3, 16, false);

        byte[] out = null;
        if (blockMode == 0) out = aes.ECB(in, true);
        else if (blockMode == 1) out = aes.CBC(in, true);
        Plaintextfield.setText(Conversor.byteToHexString(in));
        return out;
    }



    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
}//GEN-LAST:event_SalirActionPerformed

    private void PlaintextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaintextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlaintextfieldActionPerformed

    /**
    * @param args the command line arguments
    */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Plaintextfield;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuBar cifradoMenuBarMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JMenu mainMenuArchivoCifrado;
    private javax.swing.JMenu mainMenuAyudaCifrado;
    private javax.swing.JMenu mainMenuEditarCifrado;
    private javax.swing.JMenu mainMenuOperacionesCifrado;
    // End of variables declaration//GEN-END:variables

}
