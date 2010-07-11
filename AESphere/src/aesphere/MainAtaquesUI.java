
package aesphere;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class MainAtaquesUI extends javax.swing.JFrame {

    private MainUI wpadre;

    /** Creates new form MainAtaquesUI */
    public MainAtaquesUI(MainUI padre) {
        initComponents();
        wpadre = padre;
        ButtonGroup group = new ButtonGroup();
        group.add(ClienteRadioButton);
        group.add(ServidorRadioButton);
        this.setSize(800, 622);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CipherTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        PlainTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ServidorRadioButton = new javax.swing.JRadioButton();
        IPLabel = new javax.swing.JLabel();
        IPTextField = new javax.swing.JTextField();
        ClienteRadioButton = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NumeroClientesTextField = new javax.swing.JTextField();
        BotonInfo = new javax.swing.JButton();
        EjecutarButton = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ClaveFinalTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ClaveInicialTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cifrarMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditar = new javax.swing.JMenu();
        mainMenuAyuda = new javax.swing.JMenu();
        Contenidos = new javax.swing.JMenuItem();
        acercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ENTRADA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 16))); // NOI18N

        CipherTextArea.setColumns(20);
        CipherTextArea.setRows(5);
        jScrollPane2.setViewportView(CipherTextArea);

        PlainTextArea.setColumns(20);
        PlainTextArea.setRows(5);
        jScrollPane1.setViewportView(PlainTextArea);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botondef1.png"))); // NOI18N

        jLabel3.setText("Texto en claro: ");

        jLabel4.setText("Texto cifrado: ");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jLabel2)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 265, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 133, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jLabel4)
                    .add(jLabel3))
                .addContainerGap(91, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane2))
                .add(64, 64, 64))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FUNCIONAMIENTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 16))); // NOI18N

        jLabel1.setText("Este equipo funcionará como:");

        ServidorRadioButton.setSelected(true);
        ServidorRadioButton.setText("Servidor");
        ServidorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServidorRadioButtonActionPerformed(evt);
            }
        });

        IPLabel.setText("Introduce la dirección IP del Servidor:");
        IPLabel.setEnabled(false);

        IPTextField.setEnabled(false);
        IPTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPTextFieldActionPerformed(evt);
            }
        });

        ClienteRadioButton.setText("Cliente");
        ClienteRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteRadioButtonActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botondef2.png"))); // NOI18N

        jLabel8.setText("Introduce el número de clientes:");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jLabel5)
                .add(33, 33, 33)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 198, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(ClienteRadioButton)
                            .add(ServidorRadioButton))
                        .add(37, 37, 37)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(IPLabel)
                            .add(jLabel8))
                        .add(35, 35, 35)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(NumeroClientesTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(IPTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(311, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(ServidorRadioButton)
                            .add(jLabel8)
                            .add(NumeroClientesTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(ClienteRadioButton)
                            .add(IPLabel)
                            .add(IPTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        BotonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfo.setBorder(null);
        BotonInfo.setContentAreaFilled(false);

        EjecutarButton.setText("Ejecutar");
        EjecutarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EjecutarButtonActionPerformed(evt);
            }
        });

        Cancelar.setLabel("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESPACIO DE CLAVES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 16))); // NOI18N

        ClaveFinalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaveFinalTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Clave inicial: ");

        jLabel6.setText("Clave final:  ");

        ClaveInicialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaveInicialTextFieldActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botondef3.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jLabel9)
                .add(43, 43, 43)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .add(38, 38, 38)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ClaveInicialTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 244, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ClaveFinalTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 244, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(475, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jLabel9)
                .addContainerGap(84, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(ClaveInicialTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(ClaveFinalTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mainMenuArchivo.setText("Archivo");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        mainMenuArchivo.add(Salir);

        cifrarMenuBarMain.add(mainMenuArchivo);

        mainMenuEditar.setText("Editar");
        cifrarMenuBarMain.add(mainMenuEditar);

        mainMenuAyuda.setText("Ayuda");

        Contenidos.setText("Contenidos");
        Contenidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContenidosActionPerformed(evt);
            }
        });
        mainMenuAyuda.add(Contenidos);

        acercade.setText("Acerca de");
        mainMenuAyuda.add(acercade);

        cifrarMenuBarMain.add(mainMenuAyuda);

        setJMenuBar(cifrarMenuBarMain);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(Cancelar)
                        .add(18, 18, 18)
                        .add(EjecutarButton)
                        .add(36, 36, 36)
                        .add(BotonInfo))
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Cancelar)
                    .add(EjecutarButton)
                    .add(BotonInfo))
                .add(115, 115, 115))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean ComprobarDatos () {

        boolean aux = true;

        if ( aux && (PlainTextArea.getText().isEmpty() || CipherTextArea.getText().isEmpty()) ){
           JOptionPane.showMessageDialog(this, "Tiene que rellenar todos los campos.");
           aux=false;
        }

        if ( aux && (ServidorRadioButton.isSelected() && NumeroClientesTextField.getText().isEmpty() )){
           JOptionPane.showMessageDialog(this, "Tiene que introducir el número de clientes.");
           aux=false;
        }

        if ( aux && (ClienteRadioButton.isSelected() && IPTextField.getText().isEmpty() )){
           JOptionPane.showMessageDialog(this, "Tiene que introducir la dirección IP del Servidor.");
           aux=false;
        }

        if ( aux && (ClaveInicialTextField.getText().isEmpty() || ClaveFinalTextField.getText().isEmpty()) ){
           JOptionPane.showMessageDialog(this, "Tiene que establecer un rango para delimitar el espacio de claves.");
           aux=false;
        }
       
        return aux;
    }



    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed

        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
}//GEN-LAST:event_SalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);
    }//GEN-LAST:event_formWindowClosing

    private void ServidorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServidorRadioButtonActionPerformed
        IPTextField.setEnabled(false);
        IPLabel.setEnabled(false);
        NumeroClientesTextField.setEnabled(true);
        jLabel8.setEnabled(true);
    }//GEN-LAST:event_ServidorRadioButtonActionPerformed

    private void IPTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IPTextFieldActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed

        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
}//GEN-LAST:event_CancelarActionPerformed

    private void ClienteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteRadioButtonActionPerformed
        IPTextField.setEnabled(true);
        IPLabel.setEnabled(true);
        NumeroClientesTextField.setEnabled(false);
        jLabel8.setEnabled(false);
    }//GEN-LAST:event_ClienteRadioButtonActionPerformed

    private void EjecutarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EjecutarButtonActionPerformed
        
        final byte [] claveini = Conversor.hexStringToByte(ClaveInicialTextField.getText());
        final byte [] clavefin = Conversor.hexStringToByte(ClaveFinalTextField.getText());


        if (ServidorRadioButton.isSelected() && ComprobarDatos()) {
            Thread servThread = new Thread(new Runnable() {
                public void run() {
                    new ServUI(wpadre,PlainTextArea.getText(),CipherTextArea.getText(),NumeroClientesTextField.getText(),claveini,clavefin);
                }
            });
            wpadre.newThread(servThread);
            servThread.start();
        } else if (ClienteRadioButton.isSelected()) {
            Thread clientThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        new ClientUI(wpadre, java.net.InetAddress.getByName(IPTextField.getText()));
                    } catch (java.net.UnknownHostException e) {
                        JOptionPane.showMessageDialog(null, "Error en la IP del servidor");
                    }
                }
            });
            wpadre.newThread(clientThread);
            clientThread.start();
        }
    }//GEN-LAST:event_EjecutarButtonActionPerformed

    private void ClaveInicialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaveInicialTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClaveInicialTextFieldActionPerformed

    private void ClaveFinalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaveFinalTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClaveFinalTextFieldActionPerformed

    private void ContenidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContenidosActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_ContenidosActionPerformed

    /**
    * @param args the command line arguments
    */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonInfo;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextArea CipherTextArea;
    private javax.swing.JTextField ClaveFinalTextField;
    private javax.swing.JTextField ClaveInicialTextField;
    private javax.swing.JRadioButton ClienteRadioButton;
    private javax.swing.JMenuItem Contenidos;
    private javax.swing.JButton EjecutarButton;
    private javax.swing.JLabel IPLabel;
    private javax.swing.JTextField IPTextField;
    private javax.swing.JTextField NumeroClientesTextField;
    private javax.swing.JTextArea PlainTextArea;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JRadioButton ServidorRadioButton;
    private javax.swing.JMenuItem acercade;
    private javax.swing.JMenuBar cifrarMenuBarMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu mainMenuArchivo;
    private javax.swing.JMenu mainMenuAyuda;
    private javax.swing.JMenu mainMenuEditar;
    // End of variables declaration//GEN-END:variables

}
