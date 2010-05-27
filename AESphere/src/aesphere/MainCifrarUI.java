/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on 05-may-2010, 16:25:19
 */
package aesphere;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;

/**
 *
 * @author admin
 */
public class MainCifrarUI extends javax.swing.JFrame {

    private MainUI wpadre;

    /** Creates new form Main */
    public MainCifrarUI(MainUI padre) {
        initComponents();
        setLangLabels();
        wpadre = padre;
        BotonBrowseCifrar.setEnabled(false);
        BotonBrowseCifrarKey.setEnabled(false);
        BotonBrowseCifrarOutput.setEnabled(false);
        TextoOutput.setEnabled(false);

    }



    /** Sets all the titles of the interface elements */
    private void setLangLabels () {
        if (Entorno.lang.equals("ES")) {
            this.setTitle("AESphere - Cifrar");
            cifrarPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " ENTRADA ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
            cifrarPanelOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " SALIDA ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
            cifrarPanelAdvOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " OPCIONES AVANZADAS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
        }
        else if (Entorno.lang.equals("EN")) {
            this.setTitle("AESphere - Cipher");
            cifrarPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " INPUT ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
            cifrarPanelOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " OUTPUT ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
            cifrarPanelAdvOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " ADVANCED OPTIONS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        cifrarScrollPaneMain = new javax.swing.JScrollPane();
        cifrarPanelMain = new javax.swing.JPanel();
        cifrarPanelInput = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ComboBoxKey = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextoKey = new javax.swing.JTextArea();
        BotonBrowseCifrarKey = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextoInput = new javax.swing.JTextArea();
        BotonBrowseCifrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxInputCifrar = new javax.swing.JComboBox();
        cifrarPanelAdvOptions = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ModoCifrado = new javax.swing.JComboBox();
        cifrarPanelOutput = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ComboBoxOutputCifrar = new javax.swing.JComboBox();
        BotonBrowseCifrarOutput = new javax.swing.JButton();
        TextoOutput = new javax.swing.JTextField();
        BotonInfoCifrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cifrarMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditar = new javax.swing.JMenu();
        mainMenuOperaciones = new javax.swing.JMenu();
        mainMenuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        cifrarScrollPaneMain.setBorder(null);

        cifrarPanelMain.setPreferredSize(new java.awt.Dimension(788, 566));

        cifrarPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " INPUT ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Key"));

        ComboBoxKey.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Texto", "Hexadecimal", "Archivo" }));
        ComboBoxKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxKeyActionPerformed(evt);
            }
        });

        TextoKey.setColumns(20);
        TextoKey.setRows(5);
        TextoKey.setText("Introduce la clave aquí");
        jScrollPane3.setViewportView(TextoKey);

        BotonBrowseCifrarKey.setText("Buscar");
        BotonBrowseCifrarKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBrowseCifrarKeyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboBoxKey, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(BotonBrowseCifrarKey, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBrowseCifrarKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        TextoInput.setColumns(20);
        TextoInput.setRows(5);
        TextoInput.setText("Introduce el texto a cifrar aquí");
        jScrollPane1.setViewportView(TextoInput);

        BotonBrowseCifrar.setText("Buscar");
        BotonBrowseCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBrowseCifrarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botondef1.png"))); // NOI18N

        ComboBoxInputCifrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Texto", "Hexadecimal", "Archivo" }));
        ComboBoxInputCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxInputCifrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxInputCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonBrowseCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxInputCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonBrowseCifrar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout cifrarPanelInputLayout = new javax.swing.GroupLayout(cifrarPanelInput);
        cifrarPanelInput.setLayout(cifrarPanelInputLayout);
        cifrarPanelInputLayout.setHorizontalGroup(
            cifrarPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelInputLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        cifrarPanelInputLayout.setVerticalGroup(
            cifrarPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelInputLayout.createSequentialGroup()
                .addGroup(cifrarPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cifrarPanelAdvOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " ADVANCED OPTIONS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botondef3.png"))); // NOI18N

        jLabel4.setText("Método de Cifrado:");

        ModoCifrado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modo ECB", "Modo CBC" }));

        javax.swing.GroupLayout cifrarPanelAdvOptionsLayout = new javax.swing.GroupLayout(cifrarPanelAdvOptions);
        cifrarPanelAdvOptions.setLayout(cifrarPanelAdvOptionsLayout);
        cifrarPanelAdvOptionsLayout.setHorizontalGroup(
            cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(ModoCifrado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        cifrarPanelAdvOptionsLayout.setVerticalGroup(
            cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                .addGroup(cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModoCifrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        cifrarPanelOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " OUTPUT ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botondef2.png"))); // NOI18N

        ComboBoxOutputCifrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Texto", "Hexadecimal", "Archivo" }));
        ComboBoxOutputCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxOutputCifrarActionPerformed(evt);
            }
        });

        BotonBrowseCifrarOutput.setText("Buscar");
        BotonBrowseCifrarOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBrowseCifrarOutputActionPerformed(evt);
            }
        });

        TextoOutput.setText("Archivo de Salida");
        TextoOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cifrarPanelOutputLayout = new javax.swing.GroupLayout(cifrarPanelOutput);
        cifrarPanelOutput.setLayout(cifrarPanelOutputLayout);
        cifrarPanelOutputLayout.setHorizontalGroup(
            cifrarPanelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(ComboBoxOutputCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TextoOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonBrowseCifrarOutput)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        cifrarPanelOutputLayout.setVerticalGroup(
            cifrarPanelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelOutputLayout.createSequentialGroup()
                .addGroup(cifrarPanelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cifrarPanelOutputLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cifrarPanelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxOutputCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextoOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonBrowseCifrarOutput)))
                    .addComponent(jLabel1))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        BotonInfoCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfoCifrar.setBorder(null);
        BotonInfoCifrar.setContentAreaFilled(false);
        BotonInfoCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInfoCifrarActionPerformed(evt);
            }
        });

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cifrarPanelMainLayout = new javax.swing.GroupLayout(cifrarPanelMain);
        cifrarPanelMain.setLayout(cifrarPanelMainLayout);
        cifrarPanelMainLayout.setHorizontalGroup(
            cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cifrarPanelMainLayout.createSequentialGroup()
                        .addComponent(cifrarPanelAdvOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cifrarPanelMainLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(65, 65, 65)
                        .addComponent(BotonInfoCifrar)
                        .addContainerGap())
                    .addGroup(cifrarPanelMainLayout.createSequentialGroup()
                        .addGroup(cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cifrarPanelOutput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cifrarPanelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        cifrarPanelMainLayout.setVerticalGroup(
            cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cifrarPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cifrarPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cifrarPanelOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(cifrarPanelAdvOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(BotonInfoCifrar))
                .addContainerGap())
        );

        cifrarScrollPaneMain.setViewportView(cifrarPanelMain);

        mainMenuArchivo.setText("Archivo");

        jMenuItem2.setText("jMenuItem2");
        mainMenuArchivo.add(jMenuItem2);

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

        mainMenuOperaciones.setText("Operaciones");
        cifrarMenuBarMain.add(mainMenuOperaciones);

        mainMenuAyuda.setText("Ayuda");
        mainMenuAyuda.setComponentPopupMenu(jPopupMenu1);
        cifrarMenuBarMain.add(mainMenuAyuda);

        setJMenuBar(cifrarMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cifrarScrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cifrarScrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Enable calling/father window and notify it that the current windows
     * is closed. Also gives the focus to the calling/father window.
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);
         
        
    }//GEN-LAST:event_formWindowClosed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSED));
    }//GEN-LAST:event_SalirActionPerformed

    private void ComboBoxInputCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxInputCifrarActionPerformed
        // TODO add your handling code here:

       int selectedIndex = ComboBoxInputCifrar.getSelectedIndex();
        switch (selectedIndex) {
            case 0: BotonBrowseCifrar.setEnabled(false);
                    TextoInput.setEnabled(true);
                    TextoInput.setText("");

                break;
            case 1: BotonBrowseCifrar.setEnabled(false);
                    TextoInput.setEnabled(true);
                    TextoInput.setText("");

                break;
            case 2: BotonBrowseCifrar.setEnabled(true);
                    TextoInput.setEnabled(false);

                break;
        }


    }//GEN-LAST:event_ComboBoxInputCifrarActionPerformed

    private void ComboBoxOutputCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxOutputCifrarActionPerformed
        // TODO add your handling code here:

         int selectedIndex = ComboBoxOutputCifrar.getSelectedIndex();
        switch (selectedIndex) {
            case 0: BotonBrowseCifrarOutput.setEnabled(false);
                    

                break;
            case 1: BotonBrowseCifrarOutput.setEnabled(false);
                    

                break;
            case 2: BotonBrowseCifrarOutput.setEnabled(true);
                   

                break;
        }
    }//GEN-LAST:event_ComboBoxOutputCifrarActionPerformed

    private void BotonBrowseCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBrowseCifrarActionPerformed
        // TODO add your handling code here:
        String rutaInput;
        JFileChooser archivos = new JFileChooser();
        archivos.showOpenDialog(null);
        File arch= archivos.getSelectedFile();
        rutaInput = arch.getPath();
        this.TextoInput.setText(rutaInput);


    }//GEN-LAST:event_BotonBrowseCifrarActionPerformed

    private void BotonBrowseCifrarOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBrowseCifrarOutputActionPerformed
        // TODO add your handling code here:

        String rutaOutput;
        JFileChooser archivos = new JFileChooser();
        archivos.showOpenDialog(null);
        File archi= archivos.getSelectedFile();
        rutaOutput = archi.getPath();
        this.TextoOutput.setText(rutaOutput);

    }//GEN-LAST:event_BotonBrowseCifrarOutputActionPerformed

    private void ComboBoxKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxKeyActionPerformed
        // TODO add your handling code here:

         int selectedIndex = ComboBoxKey.getSelectedIndex();
        switch (selectedIndex) {
            case 0: BotonBrowseCifrarKey.setEnabled(false);
                    TextoKey.setEnabled(true);
                    TextoKey.setText("");

                break;
            case 1: BotonBrowseCifrarKey.setEnabled(false);
                    TextoKey.setEnabled(true);
                    TextoKey.setText("");

                break;
            case 2: BotonBrowseCifrarKey.setEnabled(true);
                    TextoKey.setEnabled(false);

                break;
        }
    }//GEN-LAST:event_ComboBoxKeyActionPerformed

    private void BotonBrowseCifrarKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBrowseCifrarKeyActionPerformed
        // TODO add your handling code here:

        String rutaKey;
        JFileChooser archivos = new JFileChooser();
        archivos.showOpenDialog(null);
        File archi= archivos.getSelectedFile();
        rutaKey = archi.getPath();
        this.TextoKey.setText(rutaKey);

    }//GEN-LAST:event_BotonBrowseCifrarKeyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotonInfoCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInfoCifrarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_BotonInfoCifrarActionPerformed

    private void TextoOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoOutputActionPerformed









    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBrowseCifrar;
    private javax.swing.JButton BotonBrowseCifrarKey;
    private javax.swing.JButton BotonBrowseCifrarOutput;
    private javax.swing.JButton BotonInfoCifrar;
    private javax.swing.JComboBox ComboBoxInputCifrar;
    private javax.swing.JComboBox ComboBoxKey;
    private javax.swing.JComboBox ComboBoxOutputCifrar;
    private javax.swing.JComboBox ModoCifrado;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JTextArea TextoInput;
    private javax.swing.JTextArea TextoKey;
    private javax.swing.JTextField TextoOutput;
    private javax.swing.JMenuBar cifrarMenuBarMain;
    private javax.swing.JPanel cifrarPanelAdvOptions;
    private javax.swing.JPanel cifrarPanelInput;
    private javax.swing.JPanel cifrarPanelMain;
    private javax.swing.JPanel cifrarPanelOutput;
    private javax.swing.JScrollPane cifrarScrollPaneMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu mainMenuArchivo;
    private javax.swing.JMenu mainMenuAyuda;
    private javax.swing.JMenu mainMenuEditar;
    private javax.swing.JMenu mainMenuOperaciones;
    // End of variables declaration//GEN-END:variables

}