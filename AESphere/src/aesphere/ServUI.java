/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author admin
 */
public class ServUI extends javax.swing.JFrame {

    private DatagramSocket socket;
    private MainUI wpadre;
    private int numclientes;
    private InetAddress [] clientesIP;
    private int [] clientesPort;

    /** Creates new form ServUI */
    public ServUI(MainUI padre, String plaintext, String ciphertext, String numeroclientes, byte [] claveinicial, byte[] clavefinal) {
        initComponents();
        wpadre = padre;
        //wpadre.newchild(this);
        numclientes = Integer.parseInt(numeroclientes);
        clientesIP = new InetAddress [numclientes];
        clientesPort = new int [numclientes];
        setSize(400, 400);

        try {
            socket = new DatagramSocket(3000);
        } catch (SocketException excepcionSocket) {
            excepcionSocket.printStackTrace();
            System.exit(1);
        }

        setLocationRelativeTo(wpadre);
        setVisible(true);

        //declaramos el array con el número de claves que cada cliente deberá probar
        long [] clavesPorCliente = new long [numclientes];
        //obtenemos el número de claves a probar en total
        long numClaves = getKeysToTry(claveinicial, clavefinal);
        debugArea.append(Long.toString(numClaves) + " claves a probar\n");
        //calculamos el número de claves a probar por cada cliente
        long clavesCliente = numClaves / numclientes;
        //si la división no es exacta, no todos los clientesIP probarán el mismo número de claves
        numClaves -= clavesCliente * numclientes;
        //rellenamos el array de claves a probar por cada cliente
        int extra = 0;
        debugArea.append("\n");
        for (int i = 0; i < numclientes; i++, extra++) {
            if (extra < numClaves) clavesPorCliente[i] = clavesCliente + 1;
            else clavesPorCliente[i] = clavesCliente;
            debugArea.append("Cliente " + i + ": " + clavesPorCliente[i] + " claves\n");
        }

        //declaramos el array con el texto en claro
        byte [] plainBytes = Conversor.hexStringToByte(plaintext);
        byte [] cipherBytes = Conversor.hexStringToByte(ciphertext);
        debugArea.append("\nTexto en claro: " + Conversor.byteToHexString(plainBytes) +
                "\nTexto cifrado: " + Conversor.byteToHexString(cipherBytes) + "\n");

        System.out.println("SERVIDOR: Detectando clientes");
        detectarClientes();

        //generamos la clave inicial para cada cliente
        long acum = 0;
        debugArea.append("\n");
        byte [] auxClave = null;
        for (int i=0; i < numclientes; i++) {
            auxClave = getClientKey(claveinicial, acum);
            debugArea.append("Clave " + i + ": " + Conversor.byteToHexString(auxClave) + "\n");
            debugArea.append("Enviando clave... ");
            System.out.println("SERVIDOR: Enviando clave " + i);
            enviarClaveCliente(auxClave,clavesPorCliente[i],i);
            debugArea.append("Enviando texto... ");
            enviarTextoCliente(plainBytes, cipherBytes, i);
            acum += clavesPorCliente[i];
        }

        //generamos la clave final para comprobar si está bien
        auxClave = getClientKey(claveinicial, acum);
        //comprobamos si la última clave generada y la clave final son iguales
        int len = clavefinal.length;
        boolean iguales = true;
        for (int i = 0; iguales && (i < len); i++)
            if (auxClave[i] != clavefinal[i]) iguales = false;

        if (iguales)
            debugArea.append("\nGeneración de claves finalizada correctamente\n");
        else
            debugArea.append("\nHubo un error en la generación de claves\n");

        //debugArea.append("\nComenzando cifrado en clientes\n");
        //esperarClaves();

    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        debugArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        debugArea.setColumns(20);
        debugArea.setRows(5);
        debugArea.setEditable(false);
        jScrollPane1.setViewportView(debugArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>




    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        socket.close();        
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);        
    }

    private void enviarClaveCliente (byte [] auxClave, long clavesAprobar, int num) {
        try {
            InetAddress ip = clientesIP[num];
            int port = clientesPort[num];

            //enviamos la clave
            DatagramPacket keyPacket = new DatagramPacket(auxClave, auxClave.length, 
                    ip, port);
            socket.send(keyPacket);
            System.out.println("SERVIDOR: Clave enviada");
            
            //esperamos confirmación del cliente ClaveOK
            esperarMensaje("ClaveOK");
            System.out.println("SERVIDOR: ClaveOK recibido");
                        
            //enviamos el número de claves a probar
            byte[] numClaves = Conversor.longToByte(clavesAprobar);
            DatagramPacket longPacket = new DatagramPacket(numClaves, numClaves.length,
                    ip, port);

            socket.send(longPacket);
            System.out.println("SERVIDOR: Long enviado");
            
            //esperamos la confirmación del cliente LongOK
            esperarMensaje("LongOK");
            System.out.println("SERVIDOR: LongOK recibido");            
                       
            debugArea.append("Clave enviada\n");
        }
        
        catch (Exception e) {
            debugArea.append("Error al enviar la clave\n");
            e.printStackTrace();
        }
    }

    private void enviarTextoCliente(byte [] claro, byte [] cifrado, int num) {
        try {
            InetAddress ip = clientesIP[num];
            int port = clientesPort[num];

            //enviamos el texto en claro
            DatagramPacket claroPacket = new DatagramPacket(claro, claro.length,
                    ip, port);
            socket.send(claroPacket);
            System.out.println("SERVIDOR: Texto en claro enviado");

            //esperamos confirmación del cliente ClaroOK
            esperarMensaje("ClaroOK");
            System.out.println("SERVIDOR: ClaroOK recibido");

            //enviamos el texto cifrado
            DatagramPacket cifradoPacket = new DatagramPacket(cifrado, cifrado.length,
                    ip, port);
            socket.send(cifradoPacket);
            System.out.println("SERVIDOR: Texto cifrado enviado");

            //esperamos la confirmación del cliente CifradoOK
            esperarMensaje("CifradoOK");
            System.out.println("SERVIDOR: CifradoOK recibido");

            debugArea.append("Texto enviado\n");
        }

        catch (Exception e) {
            debugArea.append("Error al enviar el texto\n");
            e.printStackTrace();
        }
    }

    private void detectarClientes() {
        debugArea.append("\nEsperando conexión...\n");
        int numCliente = 0;
        while (!Thread.currentThread().isInterrupted() && numCliente < numclientes) {
            try {
                System.out.println("SERVIDOR: Detectando cliente " + numCliente);
                //controlamos el paquete que devuelve la función
                //en otras llamadas no haría falta almacenar el paquete que la función devuelve
                DatagramPacket helloPacket = esperarMensaje("ClientHello");
                 
                InetAddress ipcliente = helloPacket.getAddress();
                if (!esta(clientesIP,ipcliente)) {
                    clientesIP[numCliente] = ipcliente;
                    clientesPort[numCliente] = helloPacket.getPort();
                    System.out.println("SERVIDOR: Almacenado cliente " + clientesIP[numCliente].toString());
                    debugArea.append("Conexión establecida con el cliente " + ipcliente.toString() + "\n");
                }

                //generamos un ServerHello de confirmación de recepción del ClientHello                
                enviarMensaje(numCliente, "ServerHello");
                System.out.println("SERVIDOR: ServerHello enviado");

                //esperamos a que el cliente nos deje continuar
                esperarMensaje("OK");
                System.out.println("SERVIDOR: Cliente " + numCliente + " detectado");

                numCliente++;
                
            } catch( Exception e ) {
                debugArea.append("\n" + e.toString() + "\n");
                System.out.println("");
                e.printStackTrace();
            }
        }
    }

    private void esperarClaves() {
        //TODO
    }

    private DatagramPacket esperarMensaje (String mensaje) throws Exception {
        int len = mensaje.length();
        DatagramPacket received = new DatagramPacket(new byte[len],len);
        
        socket.receive(received);
                
        String aux = new String(received.getData(), 0, received.getLength());
        if (!aux.equals(mensaje)) 
            throw new Exception("Se ha recibido " + aux + " cuando se esperaba " + mensaje);
        else System.out.println("SERVIDOR:" + mensaje + "recibido");

        return received;
    }

    private void enviarMensaje(int nclient, String mensaje)
            throws IOException {
        //generamos el datagrama con el mensaje a enviar
        DatagramPacket toSend = new DatagramPacket(mensaje.getBytes(), mensaje.length(),
                clientesIP[nclient], clientesPort[nclient]);

        socket.send(toSend);
    }


     private long getKeysToTry (byte [] iniClave, byte [] finClave) {
         int len = iniClave.length;
         long numKeys = 0;

         for (int i = 0; i < len; i++) {
             numKeys <<= 8;
             numKeys += (Conversor.byteToInt(finClave[i]) - Conversor.byteToInt(iniClave[i]));
         }

         return numKeys;
     }

     private byte[] getClientKey (byte [] iniClave, long offset) {
         int len = iniClave.length;
         byte [] aux = new byte [len];

         boolean acarreo = false;
         int byteSum;
         for (int i = len - 1; i>=0; i--) {
            byteSum = 0;
            if (acarreo) byteSum++;

            byteSum += Conversor.byteToInt(iniClave[i]) + Conversor.byteToInt((byte) offset);
            aux[i] = (byte) byteSum;

            if ((0xff00 & byteSum) != 0) acarreo = true;
            else acarreo = false;

            offset >>= 8;
         }

         return aux;
     }

     private int devolverposicion (InetAddress clientes []) {
         int i=0;

         while (clientes [i] != null) {
             i++;
         }

         return i;
     }

    private boolean esta (InetAddress clientes [] , InetAddress ipcliente) {
        boolean resul = false;

        for (int i = 0; i < numclientes ; i++ ){
          if (ipcliente == clientes [i]) {
              resul = true;
          }
        }

        return resul;
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea debugArea;
    // End of variables declaration

}
