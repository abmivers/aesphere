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
public class ProcesoDescifrarUI extends javax.swing.JFrame {

    private String cadenaInput;
    private String cadenaKey;
    private String cadenaOutput;
    private MainUI wpadre;
    private int tamanoclave;

    /** Creates new form ProcesoDescifrarUI */
    public ProcesoDescifrarUI(MainUI padre,String Texto1, String Texto2, String Texto3,int opcionentrada,int opcionkey,int opcionsalida,int tamano) {
        initComponents();
        wpadre=padre;
        cadenaInput = Texto1;
        cadenaKey = Texto2;
        cadenaOutput = Texto3;
        tamanoclave = tamano;

        this.setSize(800, 622);

        byte[] salida = new byte[16];;

        if (opcionentrada==2 & opcionkey==2){
            salida=descifrarArchivoArchivo();
        }

         if (opcionentrada==1 & opcionkey==1){
            salida=descifrarHexaHexa();
        }

         if (opcionentrada==2 & opcionkey==1){
            salida=descifrarArchivoHexa();
        }

         if (opcionentrada==1 & opcionkey==2){
            salida=descifrarHexaArchivo();
        }

         if (opcionentrada==0 & opcionkey==0){
            salida=descifrarTextoTexto();
        }

         if (opcionentrada==0 & opcionkey==1){
            salida=descifrarTextoHexa();
        }

         if (opcionentrada==0 & opcionkey==2){
            salida=descifrarTextoArchivo();
        }

         if (opcionentrada==1 & opcionkey==0){
            salida=descifrarHexaTexto();
        }

         if (opcionentrada==2 & opcionkey==0){
            salida=descifrarArchivoTexto();
        }

        

        
        
        if (opcionsalida==0) {
          TextoSalida.setText(Conversor.byteToTextString(salida).trim());
            
        } else if (opcionsalida == 1){
                TextoSalida.setText(Conversor.byteToHexString(salida));
               }
        else if (opcionsalida==2){
            String cadenaArchivo = Conversor.byteToTextString(salida);
            Conversor.byteToFile(cadenaArchivo,cadenaOutput);
            TextoSalida.setText(Conversor.byteToTextString(salida));
            
        }


        Print.printArray("Plaintext:    ", salida);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextoSalida = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        cifradoMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivoCifrado = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditarCifrado = new javax.swing.JMenu();
        mainMenuOperacionesCifrado = new javax.swing.JMenu();
        mainMenuAyudaCifrado = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AESphere - Proceso Descifrado");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setText("convertir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TextoSalida.setColumns(20);
        TextoSalida.setLineWrap(true);
        TextoSalida.setRows(5);
        jScrollPane3.setViewportView(TextoSalida);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

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
                .add(136, 136, 136)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButton1)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 182, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(50, 50, 50)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1)
                .add(49, 49, 49)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);       
    }//GEN-LAST:event_formWindowClosing


    private byte [] descifrarArchivoTexto (){

        //esto se puede poner en el constructor y pasarselo a cada función..... XD
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

        GetBytes getInput = new GetBytes(cadenaInput, a1);
        byte[] in = getInput.getBytes();

        byte[] key = Conversor.stringToASCII(cadenaKey,a2);
        AESdecrypt aesenc = new AESdecrypt(key, a3);


        jTextArea2.setText(Conversor.byteToHexString(in));
        jTextArea4.setText(Conversor.byteToHexString(key));

        byte[] out = new byte[16];
        aesenc.InvCipher(in, out);

        return out;

    }

    private byte[] descifrarHexaTexto (){

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

      byte[] in = Conversor.hexStringToByte(cadenaInput,16);
      byte[] key = Conversor.stringToASCII(cadenaKey,a);


      AESdecrypt aesenc = new AESdecrypt(key, b);
      jTextArea2.setText(Conversor.byteToHexString(in));
      jTextArea4.setText(Conversor.byteToHexString(key));
      byte[] out = new byte[16];
      aesenc.InvCipher(in, out);

      return out;

    }

    private byte[] descifrarTextoArchivo (){

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

        byte[] in = Conversor.stringToASCII(cadenaInput,16);

        GetBytes getKey = new GetBytes(cadenaKey, a2);
        byte[] key = getKey.getBytes();
        AESdecrypt aesenc = new AESdecrypt(key, a3);


        jTextArea2.setText(Conversor.byteToHexString(in));
        jTextArea4.setText(Conversor.byteToHexString(key));

        byte[] out = new byte[16];
        aesenc.InvCipher(in, out);

        return out;

    }

    private byte[] descifrarTextoHexa (){
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

      byte[] in = Conversor.stringToASCII(cadenaInput,16);
      byte[] key = Conversor.hexStringToByte(cadenaKey,a);


      AESdecrypt aesenc = new AESdecrypt(key, b);
      jTextArea2.setText(Conversor.byteToHexString(in));
      jTextArea4.setText(Conversor.byteToHexString(key));
      byte[] out = new byte[16];
      aesenc.InvCipher(in, out);

      return out;

    }

    private byte[] descifrarTextoTexto (){
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

      byte[] in = Conversor.stringToASCII(cadenaInput,16);
      byte[] key = Conversor.stringToASCII(cadenaKey,a);


      AESdecrypt aesenc = new AESdecrypt(key, b);
      jTextArea2.setText(Conversor.byteToHexString(in));
      jTextArea4.setText(Conversor.byteToHexString(key));
      byte[] out = new byte[16];
      aesenc.InvCipher(in, out);

      return out;

    }



    private byte[] descifrarHexaArchivo(){

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

        byte[] in = Conversor.hexStringToByte(cadenaInput,16);

        GetBytes getKey = new GetBytes(cadenaKey, a2);
        byte[] key = getKey.getBytes();
        AESdecrypt aesenc = new AESdecrypt(key, a3);


        jTextArea2.setText(Conversor.byteToHexString(in));
        jTextArea4.setText(Conversor.byteToHexString(key));

        byte[] out = new byte[16];
        aesenc.InvCipher(in, out);

        return out;

    }

    private byte[] descifrarArchivoHexa (){

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

        GetBytes getInput = new GetBytes(cadenaInput, a1);
        byte[] in = getInput.getBytes();

        byte[] key = Conversor.hexStringToByte(cadenaKey,a2);
        AESdecrypt aesenc = new AESdecrypt(key, a3);


        jTextArea2.setText(Conversor.byteToHexString(in));
        jTextArea4.setText(Conversor.byteToHexString(key));

        byte[] out = new byte[16];
        aesenc.InvCipher(in, out);

        return out;



    }


    private byte[] descifrarHexaHexa (){

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

      byte[] in = Conversor.hexStringToByte(cadenaInput,16);
      byte[] key = Conversor.hexStringToByte(cadenaKey,a);

      
      AESdecrypt aesdec = new AESdecrypt(key, b);
      jTextArea2.setText(Conversor.byteToHexString(in));
      jTextArea4.setText(Conversor.byteToHexString(key));
      byte[] out = new byte[16];
      aesdec.InvCipher(in, out);
      
      return out;
    }




    private byte[] descifrarArchivoArchivo (){

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


      
      
      GetBytes getInput = new GetBytes(cadenaInput, a1);
      byte[] in = getInput.getBytes();
      GetBytes getKey = new GetBytes(cadenaKey, a2);
      byte[] key = getKey.getBytes();
      AESdecrypt aesDec = new AESdecrypt(key, a3);

      byte[] out = new byte[16];
      aesDec.InvCipher(in, out);


        return out;

    }



    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSED));
}//GEN-LAST:event_SalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        byte [] bloqueCifra;
     

        //bloqueCifra = Conversor.stringToASCII(jTextArea1.getText());
        bloqueCifra = Conversor.hexStringToByte(jTextArea1.getText(),16);

        //TextoSalida.setText(Conversor.byteToTextString(bloqueCifra));
        jTextArea2.setText(Conversor.byteToTextString(bloqueCifra).trim());
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Salir;
    private javax.swing.JTextArea TextoSalida;
    private javax.swing.JMenuBar cifradoMenuBarMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JMenu mainMenuArchivoCifrado;
    private javax.swing.JMenu mainMenuAyudaCifrado;
    private javax.swing.JMenu mainMenuEditarCifrado;
    private javax.swing.JMenu mainMenuOperacionesCifrado;
    // End of variables declaration//GEN-END:variables

}
