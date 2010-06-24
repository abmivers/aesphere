/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProcesoSubBytesUI.java
 *
 * Created on 08-jun-2010, 17:46:18
 */

package aesphere;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JOptionPane;

/**
 *
 * @author antonio
 */
public class ProcesoMixColumnsUI extends javax.swing.JFrame {
    private MainHerramientasUI wpadre;
    

    
    public ProcesoMixColumnsUI(MainHerramientasUI padre) {
        initComponents();
        wpadre=padre;
        this.setSize(555, 430);
        CopiarOutput.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        a34 = new javax.swing.JTextField();
        a43 = new javax.swing.JTextField();
        a42 = new javax.swing.JTextField();
        a23 = new javax.swing.JTextField();
        a22 = new javax.swing.JTextField();
        a14 = new javax.swing.JTextField();
        a32 = new javax.swing.JTextField();
        a13 = new javax.swing.JTextField();
        a44 = new javax.swing.JTextField();
        a11 = new javax.swing.JTextField();
        a21 = new javax.swing.JTextField();
        a24 = new javax.swing.JTextField();
        a41 = new javax.swing.JTextField();
        a33 = new javax.swing.JTextField();
        a12 = new javax.swing.JTextField();
        a31 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        b44 = new javax.swing.JTextField();
        b13 = new javax.swing.JTextField();
        b32 = new javax.swing.JTextField();
        b31 = new javax.swing.JTextField();
        b14 = new javax.swing.JTextField();
        b42 = new javax.swing.JTextField();
        b41 = new javax.swing.JTextField();
        b21 = new javax.swing.JTextField();
        b11 = new javax.swing.JTextField();
        b34 = new javax.swing.JTextField();
        b23 = new javax.swing.JTextField();
        b33 = new javax.swing.JTextField();
        b12 = new javax.swing.JTextField();
        b22 = new javax.swing.JTextField();
        b24 = new javax.swing.JTextField();
        b43 = new javax.swing.JTextField();
        AtrasButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cifradoMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivoCifrado = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditarCifrado = new javax.swing.JMenu();
        CopiarInput = new javax.swing.JMenuItem();
        CopiarOutput = new javax.swing.JMenuItem();
        mainMenuAyudaCifrado = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AESphere - MixColumns");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Ejecutar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("INPUT"));

        a23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a23ActionPerformed(evt);
            }
        });

        a14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a14ActionPerformed(evt);
            }
        });

        a44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a44ActionPerformed(evt);
            }
        });

        a21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a21ActionPerformed(evt);
            }
        });

        a24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a24ActionPerformed(evt);
            }
        });

        a33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a33ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                        .add(a41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11)
                        .add(a42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11)
                        .add(a43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                        .add(a31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11)
                        .add(a32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11)
                        .add(a33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                        .add(a11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11)
                        .add(a12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11)
                        .add(a13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                        .add(a21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11)
                        .add(a22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11)
                        .add(a23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(11, 11, 11)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(a44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(a11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(11, 11, 11)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(a21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(11, 11, 11)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(a31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(11, 11, 11)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(a41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(a42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("OUTPUT"));

        b44.setEditable(false);

        b13.setEditable(false);

        b32.setEditable(false);

        b31.setEditable(false);

        b14.setEditable(false);
        b14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b14ActionPerformed(evt);
            }
        });

        b42.setEditable(false);

        b41.setEditable(false);

        b21.setEditable(false);

        b11.setEditable(false);

        b34.setEditable(false);

        b23.setEditable(false);

        b33.setEditable(false);

        b12.setEditable(false);

        b22.setEditable(false);

        b24.setEditable(false);

        b43.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(b41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 11, Short.MAX_VALUE)
                        .add(b42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(b43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(b31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(b32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 11, Short.MAX_VALUE)
                        .add(b33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(b11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11)
                        .add(b12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(b13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(b21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 11, Short.MAX_VALUE)
                        .add(b22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(b23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(b44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(b11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(b21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(b31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(b41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(b42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        AtrasButton.setText("Atrás");
        AtrasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel1.setText("Proceso de MixColumns");

        mainMenuArchivoCifrado.setText("Archivo");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        mainMenuArchivoCifrado.add(Salir);

        cifradoMenuBarMain.add(mainMenuArchivoCifrado);

        mainMenuEditarCifrado.setText("Editar");

        CopiarInput.setText("Copiar Input");
        CopiarInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarInputActionPerformed(evt);
            }
        });
        mainMenuEditarCifrado.add(CopiarInput);

        CopiarOutput.setText("Copiar Output");
        CopiarOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarOutputActionPerformed(evt);
            }
        });
        mainMenuEditarCifrado.add(CopiarOutput);

        cifradoMenuBarMain.add(mainMenuEditarCifrado);

        mainMenuAyudaCifrado.setText("Ayuda");
        cifradoMenuBarMain.add(mainMenuAyudaCifrado);

        setJMenuBar(cifradoMenuBarMain);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(200, 200, 200)
                .add(jLabel1)
                .addContainerGap(385, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(33, 33, 33)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(44, 44, 44)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(11, 11, 11))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(AtrasButton)
                        .add(6, 6, 6)))
                .add(249, 249, 249))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(45, 45, 45)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(28, 28, 28)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(AtrasButton)
                    .add(jButton1))
                .add(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private byte [][] rellenarmatriz () {
        byte[][] matriz = new byte[4][4];

        matriz [0][0]= Conversor.hexPairToByte(a11.getText(), 0);
        matriz [0][1]= Conversor.hexPairToByte(a12.getText(), 0);
        matriz [0][2]= Conversor.hexPairToByte(a13.getText(), 0);
        matriz [0][3]= Conversor.hexPairToByte(a14.getText(), 0);
        matriz [1][0]= Conversor.hexPairToByte(a21.getText(), 0);
        matriz [1][1]= Conversor.hexPairToByte(a22.getText(), 0);
        matriz [1][2]= Conversor.hexPairToByte(a23.getText(), 0);
        matriz [1][3]= Conversor.hexPairToByte(a24.getText(), 0);
        matriz [2][0]= Conversor.hexPairToByte(a31.getText(), 0);
        matriz [2][1]= Conversor.hexPairToByte(a32.getText(), 0);
        matriz [2][2]= Conversor.hexPairToByte(a33.getText(), 0);
        matriz [2][3]= Conversor.hexPairToByte(a34.getText(), 0);
        matriz [3][0]= Conversor.hexPairToByte(a41.getText(), 0);
        matriz [3][1]= Conversor.hexPairToByte(a42.getText(), 0);
        matriz [3][2]= Conversor.hexPairToByte(a43.getText(), 0);
        matriz [3][3]= Conversor.hexPairToByte(a44.getText(), 0);

        return matriz;
    }

    private void rellenaroutput (byte [] [] matrizsalida) {

        b11.setText(Conversor.byteToHexPair(matrizsalida[0][0]));
        b12.setText(Conversor.byteToHexPair(matrizsalida[0][1]));
        b13.setText(Conversor.byteToHexPair(matrizsalida[0][2]));
        b14.setText(Conversor.byteToHexPair(matrizsalida[0][3]));
        b21.setText(Conversor.byteToHexPair(matrizsalida[1][0]));
        b22.setText(Conversor.byteToHexPair(matrizsalida[1][1]));
        b23.setText(Conversor.byteToHexPair(matrizsalida[1][2]));
        b24.setText(Conversor.byteToHexPair(matrizsalida[1][3]));
        b31.setText(Conversor.byteToHexPair(matrizsalida[2][0]));
        b32.setText(Conversor.byteToHexPair(matrizsalida[2][1]));
        b33.setText(Conversor.byteToHexPair(matrizsalida[2][2]));
        b34.setText(Conversor.byteToHexPair(matrizsalida[2][3]));
        b41.setText(Conversor.byteToHexPair(matrizsalida[3][0]));
        b42.setText(Conversor.byteToHexPair(matrizsalida[3][1]));
        b43.setText(Conversor.byteToHexPair(matrizsalida[3][2]));
        b44.setText(Conversor.byteToHexPair(matrizsalida[3][3]));

    }

    private boolean ComprobarHexadecimal (String cadena){

    boolean resul = true;

    for (int i = 0; i < cadena.length() ; i++){

      if ( ((cadena.charAt(i) >= 'A') & (cadena.charAt(i) <= 'F')) ||
          ((cadena.charAt(i) >= 'a') & (cadena.charAt(i) <= 'f')) ||
          ((cadena.charAt(i) >= '0') & (cadena.charAt(i) <= '9')));
      else {
          resul=false;
      }
    }

    return resul;


    }

    private boolean ComprobarDatos (){
        boolean aux=true;

       if (aux && (a11.getText().isEmpty() || a12.getText().isEmpty() || a13.getText().isEmpty() || a14.getText().isEmpty()
                || a21.getText().isEmpty() || a22.getText().isEmpty() || a23.getText().isEmpty() || a24.getText().isEmpty()
                || a31.getText().isEmpty() || a32.getText().isEmpty() || a33.getText().isEmpty() || a34.getText().isEmpty()
                || a41.getText().isEmpty() || a42.getText().isEmpty() || a43.getText().isEmpty() || a44.getText().isEmpty())){
           JOptionPane.showMessageDialog(this, "Tiene que rellenar todos los campos.");
           aux=false;

        }

        if (aux && (!ComprobarHexadecimal (a11.getText()) || !ComprobarHexadecimal (a12.getText()) || !ComprobarHexadecimal (a13.getText()) || !ComprobarHexadecimal (a14.getText())
                 || !ComprobarHexadecimal (a21.getText()) || !ComprobarHexadecimal (a22.getText()) || !ComprobarHexadecimal (a23.getText()) || !ComprobarHexadecimal (a24.getText())
                 || !ComprobarHexadecimal (a31.getText()) || !ComprobarHexadecimal (a32.getText()) || !ComprobarHexadecimal (a33.getText()) || !ComprobarHexadecimal (a34.getText())
                 || !ComprobarHexadecimal (a41.getText()) || !ComprobarHexadecimal (a42.getText()) || !ComprobarHexadecimal (a43.getText()) || !ComprobarHexadecimal (a44.getText()))) {
           JOptionPane.showMessageDialog(this, "Debe introducir únicamente parejas de valores hexadecimales.");
           aux=false;
        }

        if (aux && (a11.getText().length()!=2 || a12.getText().length()!=2 || a13.getText().length()!=2 || a14.getText().length()!=2
                 || a21.getText().length()!=2 || a22.getText().length()!=2 || a23.getText().length()!=2 || a24.getText().length()!=2
                 || a31.getText().length()!=2 || a32.getText().length()!=2 || a33.getText().length()!=2 || a34.getText().length()!=2
                 || a41.getText().length()!=2 || a42.getText().length()!=2 || a43.getText().length()!=2 || a44.getText().length()!=2 )) {

           JOptionPane.showMessageDialog(this, "Debe introducir únicamente parejas de valores hexadecimales.");
           aux=false;
        }

        return aux;
    }



    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
}//GEN-LAST:event_SalirActionPerformed

    private void a14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a14ActionPerformed
         
    }//GEN-LAST:event_a14ActionPerformed

    private void b14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b14ActionPerformed
         
    }//GEN-LAST:event_b14ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
      if (ComprobarDatos()){
        AESencrypt objeto = new AESencrypt();
        byte [][] matrix = rellenarmatriz();
        objeto.MixColumns(matrix);
        rellenaroutput(matrix);
        CopiarOutput.setEnabled(true);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void a21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a21ActionPerformed
         
    }//GEN-LAST:event_a21ActionPerformed

    private void a23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a23ActionPerformed
         
    }//GEN-LAST:event_a23ActionPerformed

    private void a24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a24ActionPerformed
         
    }//GEN-LAST:event_a24ActionPerformed

    private void a33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a33ActionPerformed
         
    }//GEN-LAST:event_a33ActionPerformed

    private void a44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a44ActionPerformed
         
    }//GEN-LAST:event_a44ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);
    }//GEN-LAST:event_formWindowClosing

    private void CopiarInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarInputActionPerformed
        if (ComprobarDatos()) {

        String cadena = new String();
        byte [][] matriz = rellenarmatriz();

        for (int i = 0; i < 4; i++)
         for (int j = 0; j < 4; j++)
            cadena=cadena + (Conversor.byteToHexPair(matriz[i][j]));


        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(cadena);
        cb.setContents(ss, ss);
        }
    }//GEN-LAST:event_CopiarInputActionPerformed

    private void CopiarOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarOutputActionPerformed
        String cadena = new String();
        byte [] [] matriz= new byte [4][4];

        matriz [0][0]= Conversor.hexPairToByte(b11.getText(), 0);
        matriz [0][1]= Conversor.hexPairToByte(b12.getText(), 0);
        matriz [0][2]= Conversor.hexPairToByte(b13.getText(), 0);
        matriz [0][3]= Conversor.hexPairToByte(b14.getText(), 0);
        matriz [1][0]= Conversor.hexPairToByte(b21.getText(), 0);
        matriz [1][1]= Conversor.hexPairToByte(b22.getText(), 0);
        matriz [1][2]= Conversor.hexPairToByte(b23.getText(), 0);
        matriz [1][3]= Conversor.hexPairToByte(b24.getText(), 0);
        matriz [2][0]= Conversor.hexPairToByte(b31.getText(), 0);
        matriz [2][1]= Conversor.hexPairToByte(b32.getText(), 0);
        matriz [2][2]= Conversor.hexPairToByte(b33.getText(), 0);
        matriz [2][3]= Conversor.hexPairToByte(b34.getText(), 0);
        matriz [3][0]= Conversor.hexPairToByte(b41.getText(), 0);
        matriz [3][1]= Conversor.hexPairToByte(b42.getText(), 0);
        matriz [3][2]= Conversor.hexPairToByte(b43.getText(), 0);
        matriz [3][3]= Conversor.hexPairToByte(b44.getText(), 0);

        for (int i = 0; i < 4; i++)
         for (int j = 0; j < 4; j++)
            cadena=cadena + (Conversor.byteToHexPair(matriz[i][j]));

        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(cadena);
        cb.setContents(ss, ss);
    }//GEN-LAST:event_CopiarOutputActionPerformed

    private void AtrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasButtonActionPerformed
       this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_AtrasButtonActionPerformed

    /**
    * @param args the command line arguments
    */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasButton;
    private javax.swing.JMenuItem CopiarInput;
    private javax.swing.JMenuItem CopiarOutput;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JTextField a11;
    private javax.swing.JTextField a12;
    private javax.swing.JTextField a13;
    private javax.swing.JTextField a14;
    private javax.swing.JTextField a21;
    private javax.swing.JTextField a22;
    private javax.swing.JTextField a23;
    private javax.swing.JTextField a24;
    private javax.swing.JTextField a31;
    private javax.swing.JTextField a32;
    private javax.swing.JTextField a33;
    private javax.swing.JTextField a34;
    private javax.swing.JTextField a41;
    private javax.swing.JTextField a42;
    private javax.swing.JTextField a43;
    private javax.swing.JTextField a44;
    private javax.swing.JTextField b11;
    private javax.swing.JTextField b12;
    private javax.swing.JTextField b13;
    private javax.swing.JTextField b14;
    private javax.swing.JTextField b21;
    private javax.swing.JTextField b22;
    private javax.swing.JTextField b23;
    private javax.swing.JTextField b24;
    private javax.swing.JTextField b31;
    private javax.swing.JTextField b32;
    private javax.swing.JTextField b33;
    private javax.swing.JTextField b34;
    private javax.swing.JTextField b41;
    private javax.swing.JTextField b42;
    private javax.swing.JTextField b43;
    private javax.swing.JTextField b44;
    private javax.swing.JMenuBar cifradoMenuBarMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu mainMenuArchivoCifrado;
    private javax.swing.JMenu mainMenuAyudaCifrado;
    private javax.swing.JMenu mainMenuEditarCifrado;
    // End of variables declaration//GEN-END:variables

}
