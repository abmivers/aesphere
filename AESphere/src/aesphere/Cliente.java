package aesphere;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cliente extends JFrame {
   private JTextField campoIntroducir;
   private javax.swing.JButton HelloButton;
   private JTextArea areaPantalla;
   private DatagramSocket socket;
   //INTRODUCIR AQUÍ IP DEL SERVIDOR
   private String servIP;

   // configurar GUI y DatagramSocket
   public Cliente(String plaintext, String ciphertext, String dirIP, byte[] claveinicial, byte[] clavefinal )
   {
      super( "Cliente" );
      


      servIP = dirIP;

      Container contenedor = getContentPane();

      campoIntroducir = new JTextField( "Escriba aquí el mensaje" );
      HelloButton = new JButton();

       HelloButton.setText("Saludar");
       HelloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelloButtonActionPerformed(evt);
            }
        });


      
      campoIntroducir.addActionListener(
         new ActionListener() { 
            public void actionPerformed( ActionEvent evento )
            {
               // crear y enviar el paquete
               try {
                  areaPantalla.append( "\nEnviando paquete que contiene: " +
                     evento.getActionCommand() + "\n" );

                  // obtener mensaje del campo de texto y convertirlo en arreglo byte
                  String mensaje = evento.getActionCommand();
                  byte datos[] = mensaje.getBytes();

                  // crear enviarPaquete
                  DatagramPacket enviarPaquete = new DatagramPacket( datos, 
                     datos.length, InetAddress.getByName(servIP), 3000);

                  socket.send( enviarPaquete ); // enviar paquete
                  areaPantalla.append( "Paquete enviado\n" );
                  areaPantalla.setCaretPosition( 
                     areaPantalla.getText().length() );
               }

               // procesar los problemas que pueden ocurrir al crear o enviar el paquete
               catch ( IOException excepcionES ) {
                  mostrarMensaje( excepcionES.toString() + "\n" );
                  excepcionES.printStackTrace();
               }

            } // fin de actionPerformed

         } // fin de la clase interna

      ); // fin de la llamada a addActionListener

      contenedor.add( campoIntroducir, BorderLayout.NORTH );
      contenedor.add( HelloButton, BorderLayout.SOUTH);

      areaPantalla = new JTextArea();
      contenedor.add( new JScrollPane( areaPantalla ),
         BorderLayout.CENTER );

      setSize( 400, 300 );
      setVisible( true );


      // crear objeto DatagramSocket para enviar y recibir paquetes
      try {
         socket = new DatagramSocket();
      }

      // atrapar los problemas que pueden ocurrir al crear objeto DatagramSocket
      catch( SocketException excepcionSocket ) {
         excepcionSocket.printStackTrace();
         System.exit(1);
      }

      esperarClientHello();
      esperarClave();

   } // fin del constructor de Cliente
   
   private void HelloButtonActionPerformed(java.awt.event.ActionEvent evt) {
       String mensaje = "ClientHello";
       byte datos[] = mensaje.getBytes();

       try {
       DatagramPacket enviarPaquete = new DatagramPacket( datos,
       datos.length, InetAddress.getByName(servIP), 3000);

       socket.send( enviarPaquete );
       }

       catch (Exception e) {
           e.printStackTrace();
       }
   }


   // esperar a que lleguen los paquetes del Servidor, mostrar el contenido de los paquetes
   public void esperarClientHello()
   {
      boolean encontrado = false;
      while (!Thread.currentThread().isInterrupted() && !encontrado) {

         // recibir el paquete y mostrar su contenido
         try {

            // establecer el paquete
            byte datos[] = new byte[ 100 ];
            DatagramPacket recibirPaquete = new DatagramPacket( 
               datos, datos.length );

            socket.receive( recibirPaquete ); // esperar un paquete

            String mensajerecibido = new String( recibirPaquete.getData(),
                  0, recibirPaquete.getLength() );

            if (mensajerecibido.equals("ClientHello")) {
                encontrado = true;
                mostrarMensaje ("Conexión establecida");
                HelloButton.setEnabled(false);
            }


            else {
            // mostrar el contenido del paquete
            mostrarMensaje( "\nPaquete recibido:" + 
               "\nDel host: " + recibirPaquete.getAddress() + 
               "\nPuerto del host: " + recibirPaquete.getPort() + 
               "\nLongitud: " + recibirPaquete.getLength() + 
               "\nContenido:\n\t" + mensajerecibido );
            }


         }
 
         // procesar los problemas que pueden ocurrir al recibir o mostrar el paquete
         catch( IOException excepcion ) {
            mostrarMensaje( excepcion.toString() + "\n" );
            excepcion.printStackTrace();
         }

      } 

   } 


   public void esperarClave()
   {
      boolean encontrado = false;
      while (!Thread.currentThread().isInterrupted() && !encontrado) {

         // recibir el paquete y mostrar su contenido
         try {

            // establecer el paquete
            byte datos[] = new byte[ 100 ];
            DatagramPacket recibirPaquete = new DatagramPacket(
               datos, datos.length );

            socket.receive( recibirPaquete ); // esperar un paquete

            String mensajerecibido = new String( recibirPaquete.getData(),
                  0, recibirPaquete.getLength() );

            if (mensajerecibido.equals("ClientHello")) {
                encontrado = true;
                mostrarMensaje ("Conexión establecida");
                HelloButton.setEnabled(false);
            }


            else {
            // mostrar el contenido del paquete
            mostrarMensaje( "\nPaquete recibido:" +
               "\nDel host: " + recibirPaquete.getAddress() +
               "\nPuerto del host: " + recibirPaquete.getPort() +
               "\nLongitud: " + recibirPaquete.getLength() +
               "\nContenido:\n\t" + mensajerecibido );
            }


         }

         // procesar los problemas que pueden ocurrir al recibir o mostrar el paquete
         catch( IOException excepcion ) {
            mostrarMensaje( excepcion.toString() + "\n" );
            excepcion.printStackTrace();
         }

      }

   }
  


   private byte [] getNextKey (byte [] clave)
   throws java.lang.IndexOutOfBoundsException {
        int lastIndex = clave.length - 1;
        /*
         * si en la última posición del array (donde se encuentra el byte de
         * menor peso) hemos alcanzado el valor máximo (-1),
         * la ponemos a 0 (sumando 1) y aumentamos en uno el valor del byte de
         * peso inmediatamente mayor.
         */
        if (clave[lastIndex] == -1) {
            int i;
            /*
             * mientras el byte de peso inmediatamente mayor haya alcanzado
             * también su valor máximo, recorremos el array reiniciando a 0
             * todos los bytes hasta encontrar el primero en el que podamos
             * incrementar su valor
             */
            for (i = lastIndex; (i >= 0) && (clave[i] == -1); i--)
                clave[i]++;

            if (i < 0)
                throw new java.lang.IndexOutOfBoundsException("Last key possible reached");
            else
                clave[i]++;
        } else
            clave[lastIndex]++;

        return clave;
   }



   public void mostrarMensaje( final String mensajeAMostrar )
   {
      // mostrar mensaje del subproceso de ejecuci�n despachador de eventos
      SwingUtilities.invokeLater(
         new Runnable() {  // clase interna para asegurar que la GUI se actualice apropiadamente

            public void run() // actualiza areaPantalla
            {
               areaPantalla.append( mensajeAMostrar );
               areaPantalla.setCaretPosition( 
               areaPantalla.getText().length() );
            }

         }  // fin de la clase interna

      ); // fin de la llamada a SwingUtilities.invokeLater
   }

   /*public static void main( String args[] )
   {
      Cliente aplicacion = new Cliente();
      aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      aplicacion.esperarPaquetes();
   }*/

}  // fin de la clase Cliente