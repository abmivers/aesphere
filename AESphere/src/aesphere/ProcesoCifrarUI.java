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

public class ProcesoCifrarUI extends javax.swing.JFrame {

    private String cadenaInput;
    private String cadenaKey;
    private String cadenaOutput;
    private MainUI wpadre;
    private int tamanoclave;

    /** Creates new form ProcesoCifrarUI */
    public ProcesoCifrarUI(MainUI padre,String Texto1, String Texto2, String Texto3,int opcionentrada,int opcionkey,int opcionsalida,int tamano) {
        initComponents();
        wpadre=padre;
        cadenaInput = Texto1;
        cadenaKey = Texto2;
        cadenaOutput = Texto3;
        tamanoclave = tamano;

        this.setSize(800, 622);

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
            jTextArea3.setText(Conversor.byteToTextString(salida));
            
        }


        Print.printArray("Ciphertext:    ", salida);

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
        jTextArea3 = new javax.swing.JTextArea();
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
        setTitle("AESphere - Proceso Cifrado");
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

        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

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


    private byte [] cifrarArchivoTexto (){

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

        //GetBytes getInput = new GetBytes(cadenaInput, a1);
        //byte[] in = getInput.getBytes();

        byte [] in2 = new byte [a1];
        byte [] in = new byte [a1];

        try {
         in2 = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaInput));

        }
        catch (Exception e){
            e.printStackTrace();
        }

        in= Conversor.pad(in2, 16);


        byte[] key = Conversor.stringToASCII(cadenaKey);
        //Para las claves sólo hay que rellenar si no son del tamaño necesario
        if (key.length != a2) Conversor.pad(key, a2);
        AESencrypt aes = new AESencrypt(key, a3);


        jTextArea2.setText(Conversor.byteToHexString(in));
        jTextArea4.setText(Conversor.byteToHexString(key));

        byte[] out = new byte[16];
        aes.Cipher(in, out);

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
      if (key.length != a) Conversor.pad(key, a);


      AESencrypt aes = new AESencrypt(key, b);
      jTextArea2.setText(Conversor.byteToHexString(in));
      jTextArea4.setText(Conversor.byteToHexString(key));
      byte[] out = new byte[16];
      aes.Cipher(in, out);

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

        AESencrypt aes = new AESencrypt(key, a3);

        jTextArea2.setText(Conversor.byteToHexString(in));
        jTextArea4.setText(Conversor.byteToHexString(key));

        byte[] out = new byte[16];
        aes.Cipher(in, out);

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

      byte[] in = Conversor.stringToASCII(cadenaInput,16);
      byte[] key = Conversor.hexStringToByte(cadenaKey,a);


      AESencrypt aes = new AESencrypt(key, b);
      jTextArea2.setText(Conversor.byteToHexString(in));
      jTextArea4.setText(Conversor.byteToHexString(key));
      byte[] out = new byte[16];
      aes.Cipher(in, out);

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

      byte[] in = Conversor.stringToASCII(cadenaInput,16);
      byte[] key = Conversor.stringToASCII(cadenaKey,a);


      AESencrypt aes = new AESencrypt(key, b);
      jTextArea2.setText(Conversor.byteToHexString(in));
      jTextArea4.setText(Conversor.byteToHexString(key));
      byte[] out = new byte[16];
      aes.Cipher(in, out);

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

        byte[] in = Conversor.hexStringToByte(cadenaInput,16);

        //GetBytes getKey = new GetBytes(cadenaKey, a2);
        //byte[] key = getKey.getBytes();

        byte [] key2 = new byte [a2];
        byte [] key = new byte [a2];

         try {
         key2 = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaKey));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        key=Conversor.hexStringToByte(Conversor.byteToHexString(key2), a2);



        AESencrypt aes = new AESencrypt(key, a3);


        jTextArea2.setText(Conversor.byteToHexString(in));
        jTextArea4.setText(Conversor.byteToHexString(key));

        byte[] out = new byte[16];
        aes.Cipher(in, out);

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

        //GetBytes getInput = new GetBytes(cadenaInput, a1);
        //byte[] in = getInput.getBytes();

        byte [] in2 = new byte [a1];
        byte [] in = new byte [a1];

                try {
         in2 = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaInput));

        }
        catch (Exception e){
            e.printStackTrace();
        }





        //System.out.println("in: "+Conversor.byteToHexString(in));
        in= Conversor.hexStringToByte(Conversor.byteToHexString(in2), a1);


        byte[] key = Conversor.hexStringToByte(cadenaKey,a2);
        AESencrypt aes = new AESencrypt(key, a3);


        jTextArea2.setText(Conversor.byteToHexString(in));
        jTextArea4.setText(Conversor.byteToHexString(key));

        byte[] out = new byte[16];
        aes.Cipher(in, out);

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

      byte[] in = Conversor.hexStringToByte(cadenaInput,16);
      byte[] key = Conversor.hexStringToByte(cadenaKey,a);

      
      AESencrypt aes = new AESencrypt(key, b);
      jTextArea2.setText(Conversor.byteToHexString(in));
      jTextArea4.setText(Conversor.byteToHexString(key));
      byte[] out = new byte[16];
      aes.Cipher(in, out);
      
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


        //paso el integer a cadena. Es solo para probar. Se puede borrar
        String numCadena= String.valueOf(tamanoclave);

        jTextArea1.setText(cadenaInput);



        //GetBytes getInput = new GetBytes(cadenaInput, a1);
        //byte[] in = getInput.getBytes();
        //GetBytes getKey = new GetBytes(cadenaKey, a2);
        //byte[] key = getKey.getBytes();

        byte [] in2 = new byte [a1];
        byte [] key2 = new byte [a2];
        byte [] in = new byte [a1];
        byte [] key = new byte [a2];


        try {
         in2 = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaInput));
         key2 = ReadFileIntoByteArray.getBytesFromFile(new File(cadenaKey));
        }
        catch (Exception e){
            e.printStackTrace();
        }





        //System.out.println("in: "+Conversor.byteToHexString(in));
        in= Conversor.hexStringToByte(Conversor.byteToHexString(in2), a1);
        //System.out.println("key: "+Conversor.byteToHexString(key));
        key=Conversor.hexStringToByte(Conversor.byteToHexString(key2), a2);

        AESencrypt aes = new AESencrypt(key, a3);


        jTextArea2.setText(Conversor.byteToHexString(in));
        jTextArea4.setText(Conversor.byteToHexString(key));

        byte[] out = new byte[16];
        aes.Cipher(in, out);

        return out;

    }



    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSED));
}//GEN-LAST:event_SalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        byte [] bloqueCifra;

        //bloqueCifra = Conversor.stringToASCII(jTextArea1.getText(), 16);
        bloqueCifra = Conversor.hexStringToByte(jTextArea1.getText(),16);

        //jTextArea3.setText(Conversor.byteToTextString(bloqueCifra).trim());
        jTextArea2.setText(Conversor.byteToHexString(bloqueCifra).trim());
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuBar cifradoMenuBarMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JMenu mainMenuArchivoCifrado;
    private javax.swing.JMenu mainMenuAyudaCifrado;
    private javax.swing.JMenu mainMenuEditarCifrado;
    private javax.swing.JMenu mainMenuOperacionesCifrado;
    // End of variables declaration//GEN-END:variables

}
