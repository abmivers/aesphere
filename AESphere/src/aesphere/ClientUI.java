/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClientUI.java
 *
 * Created on 03-jul-2010, 18:04:51
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
public class ClientUI extends javax.swing.JFrame {

    private DatagramSocket socket;
    private MainUI wpadre;
    private InetAddress servIP;
    private byte [] claveInicial;
    private long numClaves;
    private byte [] plaintext;
    private byte [] ciphertext;
    private int tamClave; 
    long iniTime;

    /** Creates new form ClientUI */
    public ClientUI(MainUI padreMain, MainAtaquesUI padre, InetAddress dirIP) {
        initComponents();
        wpadre = padreMain;
        wpadre.newchild(padre, this);
        servIP = dirIP;
        plaintext = new byte[16];
        ciphertext = new byte[16];
        setSize(400, 400);
        setLocationRelativeTo(wpadre);
        setVisible(true);
        
        this.setTitle(Entorno.getTrans("Net.cliTitle"));
        // crear objeto DatagramSocket para enviar y recibir paquetes
        try {
            socket = new DatagramSocket();
            socket.setSoTimeout(0);
            socket.connect(servIP, 3000);
        } catch(SocketException excepcionSocket) {
            JOptionPane.showMessageDialog(this, Entorno.getTrans("Net.newCliErr"), 
                    Entorno.getTrans("gen.err"), JOptionPane.ERROR_MESSAGE);            
            this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
        }

        try {
            clientHello();

            esperarClave();
            debugArea.append(Entorno.getTrans("Net.initKey") + " " + Conversor.byteToHexString(claveInicial) +
                    Entorno.getTrans("Net.cliNKeys") + " " + Long.toString(numClaves) + "\n");

            esperarTexto();          
                        
            probarClaves();
            
            this.setTitle(Entorno.getTrans("Net.cliTitleEnd"));
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
            long keysPerSec = numClaves / time;
            if (keysPerSec == 1)
                debugArea.append(Entorno.getTrans("Net.speed") + " 1 " + 
                        Entorno.getTrans("Net.keyPerSec") + "\n");
            else
                debugArea.append(Entorno.getTrans("Net.speed") + " " +
                        Long.toString(keysPerSec) + " " + Entorno.getTrans("Net.keysPerSec") + "\n");
            
        } catch (Exception e) {
            this.setTitle(Entorno.getTrans("Net.cliTitleEnd"));
            debugArea.append(Entorno.getTrans("Net.end"));
        }       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        debugArea.setEditable(false);
        debugArea.setLineWrap(true);
        debugArea.setRows(5);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        socket.close();
        //wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);
    }//GEN-LAST:event_formWindowClosing

    // esperar a que lleguen los paquetes del Servidor, mostrar el contenido de los paquetes
    private void clientHello() throws Exception {
        boolean recibido = false;
        int reintentos = 100;
        debugArea.append(Entorno.getTrans("Net.servConec") + " ");
        try {            
            do {
                try {
                    enviarMensaje("ClientHello");                    

                    //esperamos ServerHello
                    esperarMensaje("ServerHello");                    
                    recibido = true;
                    debugArea.append(Entorno.getTrans("Net.servConecOK"));
                } catch (Exception e) {
                    if (--reintentos == 0)
                        throw e;
                }

            } while (!Thread.currentThread().isInterrupted() && !recibido);            
        } catch(Exception excepcion) {
                debugArea.append(Entorno.getTrans("Net.servConecErr"));                
                throw excepcion;
        }

    }

    private void esperarClave() throws Exception {
        debugArea.append(Entorno.getTrans("Net.keyReceive") + " ");
        try {
            //creamos un DatagramPacket para recibir el tamaño de la clave
            int len = Integer.SIZE/8;
            DatagramPacket tamPacket = new DatagramPacket(new byte[len], len);
            //desbloqueamos al servidor antes de recibir
            enviarMensaje("OK");            
            socket.receive(tamPacket);            

            tamClave = Conversor.byteToInt(tamPacket.getData());

            //mandamos un mensaje de confirmación de recepción de tamaño de clave al servidor
            enviarMensaje("TamOK");

            //creamos un DatagramPacket para recibir la clave
            DatagramPacket clavePacket = new DatagramPacket(new byte[tamClave],
                    tamClave);
            socket.receive(clavePacket);            

            claveInicial = clavePacket.getData();

            //mandamos un mensaje de confirmación de recepción de clave al servidor
            enviarMensaje("ClaveOK");            

            //creamos un DatagramPacket para recibir el número de claves
            len = Long.SIZE/8;
            DatagramPacket longPacket = new DatagramPacket(new byte[len], len);
            socket.receive(longPacket);            

            numClaves = Conversor.byteToLong(longPacket.getData());

            //mandamos un mensaje de confirmación de recepción de número de claves al servidor
            enviarMensaje("LongOK");            

            debugArea.append(Entorno.getTrans("Net.keyReceived"));

        } catch (Exception e) {
            debugArea.append(Entorno.getTrans("Net.keyReceiveErr"));            
            throw e;
        }

    }

    private void esperarTexto () throws Exception {
        debugArea.append(Entorno.getTrans("Net.textReceive") + " ");
        try {
            //creamos un DatagramPacket para recibir el texto en claro
            DatagramPacket claroPacket = new DatagramPacket(new byte[16],16);
            socket.receive(claroPacket);            

            plaintext = claroPacket.getData();

            //mandamos un mensaje de confirmación de recepción de clave al servidor
            enviarMensaje("ClaroOK");            

            //recibimos el texto cifrado
            DatagramPacket cifradoPacket = new DatagramPacket(new byte[16],16);
            socket.receive(cifradoPacket);            

            ciphertext = cifradoPacket.getData();

            //mandamos un mensaje de confirmación de recepción de número de claves al servidor
            enviarMensaje("CifradoOK");            

            debugArea.append(Entorno.getTrans("Net.textReceived"));

        } catch (Exception e) {
            debugArea.append(Entorno.getTrans("Net.textReceiveErr"));            
            throw e;
        }
    }

    private void probarClaves () throws Exception {
        debugArea.append(Entorno.getTrans("Net.keyTest"));        
        try {
            //esperamos a que el servidor nos ordene comenzar
            esperarMensaje("START");

            //hacemos las declaraciones antes del for
            byte [] claveAct = claveInicial;
            byte [] out = new byte[16];
            int numWords = tamClave / 4;
            iniTime = System.currentTimeMillis();
            long time = 0L;
            long keysPerSec = 0L;

            for(long i = numClaves; --i >= 0;) {
                //realizamos el cifrado
                AESencrypt cipher = new AESencrypt(claveAct,numWords, false);
                cipher.Cipher(plaintext, out);

                //comprobamos si es una clave válida
                boolean iguales = true;
                for (int j = 16; iguales && (--j >= 0);)
                    if (out[j] != ciphertext[j]) iguales = false;
                if (iguales) {                            
                    debugArea.append(Entorno.getTrans("Net.keyFound") + " " + Conversor.byteToHexString(claveAct) + "\n");
                    //calculamos el tiempo en segundos que ha tardado hasta aquí
                    time = (System.currentTimeMillis() - iniTime) / 1000;
                    if (time == 0) time++;
                    if (time == 1)
                        debugArea.append(Entorno.getTrans("Net.keyFoundIn") + " 1 " + 
                                Entorno.getTrans("Net.second") + "\n");
                    else
                        debugArea.append(Entorno.getTrans("Net.keyFoundIn") + " " +
                                Long.toString(time) + " " + Entorno.getTrans("Net.seconds") + "\n");
                    //calculamos las claves por segundo hasta ahora                    
                    keysPerSec = (numClaves - i) / time;
                    if (keysPerSec == 1)
                        debugArea.append(Entorno.getTrans("Net.speed") + " 1 " + 
                                Entorno.getTrans("Net.keyPerSec") + "\n");
                    else
                        debugArea.append(Entorno.getTrans("Net.speed") + " " +
                                Long.toString(keysPerSec) + " " + Entorno.getTrans("Net.keysPerSec") + "\n");
                    //estimamos el tiempo que tardará en terminar
                    time =  i / keysPerSec;
                    if (time == 1)
                        debugArea.append(Entorno.getTrans("Net.timeToFinish") + " 1 " + 
                                Entorno.getTrans("Net.second") + "\n");
                    else
                        debugArea.append(Entorno.getTrans("Net.timeToFinish") + " " +
                                Long.toString(time) + " " + Entorno.getTrans("Net.seconds") + "\n");
                    
                    //enviamos la clave
                    DatagramPacket clave = new DatagramPacket (claveAct, claveAct.length,
                                servIP, 3000);
                    socket.send(clave);                    
                    //esperamos a que el servidor nos deje continuar
                    esperarMensaje("NEXT");
                }

                //obtenemos la siguiente clave a probar
                claveAct = getNextKey(claveAct);
            }

            debugArea.append(Entorno.getTrans("Net.keyTestEnd"));

        } catch (Exception e) {            
            debugArea.append(Entorno.getTrans("Net.keyTestErr"));

            try {enviarMensaje("END");} catch (IOException ex) {
                debugArea.append(Entorno.getTrans("Net.keyServErr"));
                throw ex;
            }

            throw e;
        }

        try {enviarMensaje("END");} catch (IOException e) {
            debugArea.append(Entorno.getTrans("Net.keyServErr"));
            throw e;
        }
    }

    private void enviarMensaje(String mensaje)
            throws IOException {
        //generamos el datagrama con el mensaje a enviar
        DatagramPacket toSend = new DatagramPacket(mensaje.getBytes(), mensaje.length(),
                servIP, 3000);

        socket.send(toSend);        
    }

    private void esperarMensaje (String mensaje) throws Exception {
        int len = mensaje.length();
        DatagramPacket received = new DatagramPacket(new byte[len],len);

        socket.receive(received);

        String aux = new String(received.getData(), 0, received.getLength());
        if (!aux.equals(mensaje))
            throw new Exception("Se ha recibido " + aux + " cuando se esperaba " + mensaje);        
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea debugArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
