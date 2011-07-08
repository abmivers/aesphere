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

/**
 *
 * @author admin
 */
public class MonoUI extends javax.swing.JFrame {

    private MainUI wpadre;    
    private byte [] claveInicial;
    private long numClaves;
    private byte [] plaintext;
    private byte [] ciphertext;
    private int tamClave;
    long iniTime;

    /** Creates new form ClientUI */
    public MonoUI(MainUI padre, byte [] plainBytes, byte [] cipherBytes,
            byte [] claveinicial, long nClaves, int blockMode, byte[] IV) {
        initComponents();
        wpadre = padre;
        wpadre.newchild(this);        
        plaintext = plainBytes;
        ciphertext = cipherBytes;
        claveInicial = claveinicial;
        numClaves = nClaves;
        tamClave = claveinicial.length;
        setSize(400, 400);
        setLocationRelativeTo(wpadre);
        setVisible(true);
        
        System.out.println(Conversor.byteToHexString(plaintext));
        System.out.println(Conversor.byteToHexString(ciphertext));
        
        this.setTitle(Entorno.getTrans("Net.monoTitle"));    
       
        debugArea.append(Entorno.getTrans("Net.initKey") + " " + Conversor.byteToHexString(claveInicial) +
                Entorno.getTrans("Net.cliNKeys") + " " + Long.toString(numClaves) + "\n");  
        
        //si estamos en modo CBC, hacemos XOR del IV con el texto en claro
        if (blockMode == 1) plaintext = BlockManager.XOR(IV, plaintext);    

        probarClaves();

        this.setTitle(Entorno.getTrans("Net.monoTitleEnd"));
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
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);
    }//GEN-LAST:event_formWindowClosing
    
    private void probarClaves () {
        debugArea.append(Entorno.getTrans("Net.keyTest"));     
        
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
            }
                //obtenemos la siguiente clave a probar
                claveAct = getNextKey(claveAct);
        }

        debugArea.append(Entorno.getTrans("Net.keyTestEnd"));        
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
