/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CifrarDescifrarSimple.java
 *
 * Created on 23-jun-2010, 14:36:56
 */

package aesphere;

/**
 *
 * @author antonio
 */
public class CifrarDescifrarSimple extends javax.swing.JFrame {

    /** Creates new form CifrarDescifrarSimple */
    public CifrarDescifrarSimple() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Plaintext = new javax.swing.JTextField();
        Key = new javax.swing.JTextField();
        Ciphertext = new javax.swing.JTextField();
        Decrpyted = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Decrpyted1 = new javax.swing.JTextField();
        Decrpyted2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Ciphertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiphertextActionPerformed(evt);
            }
        });

        Decrpyted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecrpytedActionPerformed(evt);
            }
        });

        jLabel1.setText("Plaintext:");

        jLabel2.setText("Ciphertext:");

        jLabel3.setText("Key:");

        jLabel4.setText("Plaintext:");

        Decrpyted1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Decrpyted1ActionPerformed(evt);
            }
        });

        Decrpyted2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Decrpyted2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Ciphertext:");

        jLabel6.setText("Key:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(jLabel6))
                .add(43, 43, 43)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, Decrpyted2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .add(Decrpyted1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, Decrpyted, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(Key)
                        .add(Ciphertext)
                        .add(Plaintext, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
                .add(198, 198, 198))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(80, 80, 80)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Plaintext, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Key, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Ciphertext, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .add(47, 47, 47)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Decrpyted, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Decrpyted1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .add(27, 27, 27)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Decrpyted2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CiphertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiphertextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CiphertextActionPerformed

    private void DecrpytedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecrpytedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DecrpytedActionPerformed

    private void Decrpyted1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Decrpyted1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Decrpyted1ActionPerformed

    private void Decrpyted2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Decrpyted2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Decrpyted2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CifrarDescifrarSimple().setVisible(true);

                String b = new String();

                GetBytes getInput = new GetBytes("/Users/antonio/plaintext.txt", 16);
              byte[] in = getInput.getBytes();
              GetBytes getKey = new GetBytes("/Users/antonio/key.txt", 32);
              byte[] key = getKey.getBytes();
              String salida = new String ();


                for (int j = 0; j < 16; j++)
                    b=b + (Conversor.byteToHexPair(key[j]));
                System.out.println("keyex: ");
                System.out.println(b +" long: "+ b.length());

              AESencrypt aes = new AESencrypt(key, 8,false);
              System.out.println(Print.printArray("Plaintext:     ", in));
              Print.printArray("Key:           ", key);
              byte[] out = new byte[16];
              aes.Cipher(in, out);
              System.out.println(Conversor.byteToHexString(out));



            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ciphertext;
    private javax.swing.JTextField Decrpyted;
    private javax.swing.JTextField Decrpyted1;
    private javax.swing.JTextField Decrpyted2;
    private javax.swing.JTextField Key;
    private javax.swing.JTextField Plaintext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

}
