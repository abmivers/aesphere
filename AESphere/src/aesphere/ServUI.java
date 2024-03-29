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
import javax.swing.JOptionPane;

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
    private long iniTime;
    private long clavesTotales;

    /** Creates new form ServUI */
    public ServUI(MainUI padreMain, MainAtaquesUI padre, byte [] plainBytes, byte [] cipherBytes,
            int numeroclientes, byte [] claveinicial, long numClaves,
            int blockMode, byte[] IV) {
        initComponents();
        wpadre = padreMain;
        wpadre.newchild(padre, this);
        numclientes = numeroclientes;
        clientesIP = new InetAddress [numclientes];
        clientesPort = new int [numclientes];
        setSize(400, 400);       
        
        this.setTitle(Entorno.getTrans("Net.servTitle"));
        clavesTotales = numClaves;
        
        try {
            socket = new DatagramSocket(3000);
            socket.setSoTimeout(0);
        } catch (SocketException excepcionSocket) {
            JOptionPane.showMessageDialog(this, Entorno.getTrans("Net.srvPermErr"),
                    Entorno.getTrans("gen.err"), JOptionPane.ERROR_MESSAGE);            
            this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
        }

        setLocationRelativeTo(wpadre);
        setVisible(true);

        if (numClaves == 1) 
            debugArea.append("1 " + Entorno.getTrans("Net.nKey"));
        else debugArea.append(Long.toString(numClaves) + " " + Entorno.getTrans("Net.nKeys"));
        //declaramos el array con el número de claves que cada cliente deberá probar
        long [] clavesPorCliente = new long [numclientes];                
        //calculamos el número de claves a probar por cada cliente
        long clavesCliente = numClaves / numclientes;
        //si la división no es exacta, no todos los clientesIP probarán el mismo número de claves
        numClaves -= clavesCliente * numclientes;
        //rellenamos el array de claves a probar por cada cliente
        int extra = 0;
        long clavesCli = 0;
        debugArea.append("\n");
        for (int i = 0; i < numclientes; i++, extra++) {
            if (extra < numClaves) clavesCli = clavesCliente + 1;
            else clavesCli = clavesCliente;
            
            if (clavesCli == 1)
                debugArea.append(Entorno.getTrans("Net.cli") + " " + i + ": " + 
                        "1 " + Entorno.getTrans("Net.keyLower"));
            else debugArea.append(Entorno.getTrans("Net.cli") + " " + i + ": " + 
                        clavesCli + " " + Entorno.getTrans("Net.keys"));
            
            clavesPorCliente[i] = clavesCli;
        }

        //si estamos en modo CBC, hacemos XOR del IV con el texto en claro
        if (blockMode == 1) plainBytes = BlockManager.XOR(IV, plainBytes);
        
        detectarClientes();

        //generamos la clave inicial para cada cliente
        long acum = 0;
        debugArea.append("\n");
        byte [] auxClave = null;
        for (int i=0; i < numclientes; i++) {
            auxClave = getClientKey(claveinicial, acum);
            debugArea.append(Entorno.getTrans("Net.key") + " " + i + ": " +
                    Conversor.byteToHexString(auxClave) + "\n");
            debugArea.append(Entorno.getTrans("Net.sendKey") + " ");
            enviarClaveCliente(auxClave,clavesPorCliente[i],i);
            debugArea.append(Entorno.getTrans("Net.sendText") + " ");
            enviarTextoCliente(plainBytes, cipherBytes, i);
            acum += clavesPorCliente[i];
        }     
                      
        debugArea.append(Entorno.getTrans("Net.okKeyGen"));     
        debugArea.append(Entorno.getTrans("Net.startEncCli"));        
        esperarClaves();       
        
        this.setTitle(Entorno.getTrans("Net.servTitleEnd"));
        debugArea.append(Entorno.getTrans("Net.end"));
        //calculamos el tiempo total tardado
        long time = (System.currentTimeMillis() - iniTime) / 1000;
        if (time == 0) time++;
        if (time == 1)
            debugArea.append(Entorno.getTrans("Net.totalTime") + " 1 " + 
                    Entorno.getTrans("Net.second") + "\n");
        else
            debugArea.append(Entorno.getTrans("Net.totalTime") + " " +
                    Long.toString(time) + " " + Entorno.getTrans("Net.seconds") + "\n");
        //calculamos la velocidad de test al final de todo el proceso
        long keysPerSec = clavesTotales / time;
        if (keysPerSec == 1)
            debugArea.append(Entorno.getTrans("Net.speed") + " 1 " + 
                    Entorno.getTrans("Net.keyPerSec") + "\n");
        else
            debugArea.append(Entorno.getTrans("Net.speed") + " " +
                    Long.toString(keysPerSec) + " " + Entorno.getTrans("Net.keysPerSec") + "\n");
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
        //wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);        
    }

    private void enviarClaveCliente (byte [] auxClave, long clavesAprobar, int num) {
        try {
            InetAddress ip = clientesIP[num];
            int port = clientesPort[num];

            //enviamos la longitud de la clave
            byte [] tamClave = Conversor.intToByte(auxClave.length);
            DatagramPacket tamPacket = new DatagramPacket(tamClave, tamClave.length,
                    ip, port);
            socket.send(tamPacket);           

            //esperamos confirmación del cliente TamOK
            esperarMensaje("TamOK");

            //enviamos la clave
            DatagramPacket keyPacket = new DatagramPacket(auxClave, auxClave.length, 
                    ip, port);
            socket.send(keyPacket);            
            
            //esperamos confirmación del cliente ClaveOK
            esperarMensaje("ClaveOK");            
                        
            //enviamos el número de claves a probar
            byte[] numClaves = Conversor.longToByte(clavesAprobar);
            DatagramPacket longPacket = new DatagramPacket(numClaves, numClaves.length,
                    ip, port);

            socket.send(longPacket);            
            
            //esperamos la confirmación del cliente LongOK
            esperarMensaje("LongOK");                       
                       
            debugArea.append(Entorno.getTrans("Net.keySent"));
        }
        
        catch (Exception e) {
            debugArea.append(Entorno.getTrans("Net.keySentErr"));            
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

            //esperamos confirmación del cliente ClaroOK
            esperarMensaje("ClaroOK");            

            //enviamos el texto cifrado
            DatagramPacket cifradoPacket = new DatagramPacket(cifrado, cifrado.length,
                    ip, port);
            socket.send(cifradoPacket);            

            //esperamos la confirmación del cliente CifradoOK
            esperarMensaje("CifradoOK");            

            debugArea.append(Entorno.getTrans("Net.textSent"));
        }

        catch (Exception e) {
            debugArea.append(Entorno.getTrans("Net.textErr"));            
        }
    }

    private void detectarClientes() {
        debugArea.append(Entorno.getTrans("Net.conecWait"));
        int numCliente = 0;
        while (!Thread.currentThread().isInterrupted() && numCliente < numclientes) {
            try {                
                //controlamos el paquete que devuelve la función
                //en otras llamadas no haría falta almacenar el paquete que la función devuelve
                DatagramPacket helloPacket = esperarMensaje("ClientHello");
                 
                InetAddress ipcliente = helloPacket.getAddress();
                if (!esta(clientesIP,ipcliente)) {
                    clientesIP[numCliente] = ipcliente;
                    clientesPort[numCliente] = helloPacket.getPort();                    
                    debugArea.append(Entorno.getTrans("Net.conecWithCli") + " " + ipcliente.toString() + "\n");
                }

                //generamos un ServerHello de confirmación de recepción del ClientHello                
                enviarMensaje( "ServerHello", numCliente);                

                //esperamos a que el cliente nos deje continuar
                recibirIgnorar("OK", numCliente);                

                numCliente++;
                
            } catch( Exception e ) {
                debugArea.append(Entorno.getTrans("Net.conecWithCliErr"));                
            }
        }
    }

    private void esperarClaves() {
        debugArea.append(Entorno.getTrans("Net.keySearch"));
        try {
            //enviamos un mensaje a todos los clientes para que comiencen a cifrar
            for(int i = 0; i < numclientes; i++)
                enviarMensaje("START", i);
            
            //guardamos el momento en que el cifrado comienza
            iniTime = System.currentTimeMillis();

            //nos quedamos esperando claves
            DatagramPacket clave = new DatagramPacket(new byte[16],16);
            int numfin = 0;
            long numClaves = 0;
            long time = 0L;
            long keysPerSec = 0L;
            while (numfin < numclientes) {
                socket.receive(clave);

                String end = new String(clave.getData(), 0, 3);
                InetAddress clientAddress = clave.getAddress();
                if (end.equals("END")) {                    
                    debugArea.append(Entorno.getTrans("Net.cliEnd1") + " " + 
                            clientAddress.toString() + " " + Entorno.getTrans("Net.cliEnd2"));
                    numfin++;
                } else {
                    debugArea.append(Entorno.getTrans("Net.cliFound1") + " " + clientAddress.toString() +
                            Entorno.getTrans("Net.cliFound2") + " " + 
                            Conversor.byteToHexString(clave.getData()) + "\n");
                    //calculamos el tiempo en segundos que ha tardado hasta aquí
                    time = (System.currentTimeMillis() - iniTime) / 1000;
                    if (time == 0) time++;
                    if (time == 1)
                        debugArea.append(Entorno.getTrans("Net.keyFoundIn") + " 1 " + 
                                Entorno.getTrans("Net.second") + "\n");
                    else
                        debugArea.append(Entorno.getTrans("Net.keyFoundIn") + " " +
                                Long.toString(time) + " " + Entorno.getTrans("Net.seconds") + "\n");                    
                    numClaves++;
                    enviarMensaje("NEXT", clientAddress, clave.getPort());                    
                }
            }

            if (numClaves == 1) 
                debugArea.append(Entorno.getTrans("Net.keySearchEnd") +
                    "1 " + Entorno.getTrans("Net.keyFoundEnd"));
            else debugArea.append(Entorno.getTrans("Net.keySearchEnd") +
                    Long.toString(numClaves) + " " + Entorno.getTrans("Net.keysFound"));

        } catch (Exception e) {
            debugArea.append(Entorno.getTrans("Net.keySearchErr"));            
        }
    }

    private void recibirIgnorar(String mensaje, int nclient) throws Exception {
        int len = mensaje.length();
        DatagramPacket received = new DatagramPacket (new byte[len],len);
        //variable para almacenar el número de reintentos cuando la recepción falla
        int reintentos = 10;
        String msg = "";

        do {            

            try {
                socket.receive(received);                
                msg = new String(received.getData(), 0, received.getLength());                
            } catch (Exception e) {
                if (--reintentos == 0)
                    throw e;
            }

        } while ( !Thread.currentThread().isInterrupted() &&
                    !( msg.equals(mensaje) &&
                       (received.getAddress().equals(clientesIP[nclient])) &&
                       (received.getPort() == clientesPort[nclient])) );
    }

    private DatagramPacket esperarMensaje (String mensaje) throws Exception {
        int len = mensaje.length();
        DatagramPacket received = new DatagramPacket(new byte[len],len);
        
        socket.receive(received);
                
        String aux = new String(received.getData(), 0, received.getLength());
        if (!aux.equals(mensaje)) 
            throw new Exception("Se ha recibido " + aux + " cuando se esperaba " + mensaje);        

        return received;
    }

    private void enviarMensaje(String mensaje, int nclient)
            throws IOException {
        //generamos el datagrama con el mensaje a enviar
        DatagramPacket toSend = new DatagramPacket(mensaje.getBytes(), mensaje.length(),
                clientesIP[nclient], clientesPort[nclient]);

        socket.send(toSend);        
    }

    private void enviarMensaje(String mensaje, InetAddress client, int port)
            throws IOException {
        //generamos el datagrama con el mensaje a enviar
        DatagramPacket toSend = new DatagramPacket(mensaje.getBytes(), mensaje.length(),
                client, port);

        socket.send(toSend);        
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
