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
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class MainCifrarUI extends javax.swing.JFrame {

    private ProcesoCifrarUI procesocifrado;
    private MainUI wpadre;

    /** Creates new form Main */
    public MainCifrarUI(MainUI padre) {
        initComponents();
        setLangLabels();
        wpadre = padre;
        BotonBrowseCifrar.setEnabled(false);
        BotonBrowseCifrarKey.setEnabled(false);
        BotonBrowseCifrarOutput.setEnabled(false);
        archivos = new JFileChooser();

        ButtonGroup group = new ButtonGroup();
        group.add(RadioButton128);
        group.add(RadioButton192);
        group.add(RadioButton256);

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
        archivos = new javax.swing.JFileChooser();
        cifrarScrollPaneMain = new javax.swing.JScrollPane();
        cifrarPanelMain = new javax.swing.JPanel();
        cifrarPanelInput = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ComboBoxKey = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextoKey = new javax.swing.JTextArea();
        BotonBrowseCifrarKey = new javax.swing.JButton();
        RadioButton128 = new javax.swing.JRadioButton();
        RadioButton192 = new javax.swing.JRadioButton();
        RadioButton256 = new javax.swing.JRadioButton();
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
        BotonSiguiente = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        cifrarMenuBarMain = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditar = new javax.swing.JMenu();
        mainMenuOperaciones = new javax.swing.JMenu();
        mainMenuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cifrarScrollPaneMain.setBorder(null);

        cifrarPanelMain.setPreferredSize(new java.awt.Dimension(788, 566));

        cifrarPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " INPUT ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Key"));

        ComboBoxKey.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASCII", "Hexadecimal", "Archivo" }));
        ComboBoxKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxKeyActionPerformed(evt);
            }
        });

        TextoKey.setColumns(20);
        TextoKey.setLineWrap(true);
        TextoKey.setRows(5);
        jScrollPane3.setViewportView(TextoKey);

        BotonBrowseCifrarKey.setText("Buscar");
        BotonBrowseCifrarKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBrowseCifrarKeyActionPerformed(evt);
            }
        });

        RadioButton128.setSelected(true);
        RadioButton128.setText("128 bits");
        RadioButton128.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButton128ActionPerformed(evt);
            }
        });

        RadioButton192.setText("192 bits");
        RadioButton192.setActionCommand("192 bits");
        RadioButton192.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButton192ActionPerformed(evt);
            }
        });

        RadioButton256.setText("256 bits");
        RadioButton256.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButton256ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboBoxKey, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(BotonBrowseCifrarKey, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RadioButton128)
                        .addGap(18, 18, 18)
                        .addComponent(RadioButton192)
                        .addGap(18, 18, 18)
                        .addComponent(RadioButton256)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBrowseCifrarKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButton128)
                    .addComponent(RadioButton192)
                    .addComponent(RadioButton256))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TextoInput.setColumns(20);
        TextoInput.setLineWrap(true);
        TextoInput.setRows(5);
        jScrollPane1.setViewportView(TextoInput);

        BotonBrowseCifrar.setText("Buscar");
        BotonBrowseCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBrowseCifrarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botondef1.png"))); // NOI18N

        ComboBoxInputCifrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Texto ASCII", "Hexadecimal", "Archivo" }));
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxInputCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(BotonBrowseCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cifrarPanelInputLayout = new javax.swing.GroupLayout(cifrarPanelInput);
        cifrarPanelInput.setLayout(cifrarPanelInputLayout);
        cifrarPanelInputLayout.setHorizontalGroup(
            cifrarPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelInputLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cifrarPanelInputLayout.setVerticalGroup(
            cifrarPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelInputLayout.createSequentialGroup()
                .addGroup(cifrarPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(ModoCifrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        cifrarPanelAdvOptionsLayout.setVerticalGroup(
            cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                .addGroup(cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ModoCifrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        TextoOutput.setEnabled(false);
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
                .addContainerGap(82, Short.MAX_VALUE))
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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        BotonInfoCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfoCifrar.setBorder(null);
        BotonInfoCifrar.setContentAreaFilled(false);
        BotonInfoCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInfoCifrarActionPerformed(evt);
            }
        });

        BotonSiguiente.setText("Siguiente");
        BotonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSiguienteActionPerformed(evt);
            }
        });

        Cancelar.setLabel("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cifrarPanelMainLayout = new javax.swing.GroupLayout(cifrarPanelMain);
        cifrarPanelMain.setLayout(cifrarPanelMainLayout);
        cifrarPanelMainLayout.setHorizontalGroup(
            cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cifrarPanelAdvOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cifrarPanelMainLayout.createSequentialGroup()
                        .addComponent(Cancelar)
                        .addGap(18, 18, 18)
                        .addComponent(BotonSiguiente)
                        .addGap(65, 65, 65)
                        .addComponent(BotonInfoCifrar))
                    .addComponent(cifrarPanelOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cifrarPanelInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        cifrarPanelMainLayout.setVerticalGroup(
            cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cifrarPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cifrarPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cifrarPanelOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cifrarPanelAdvOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotonSiguiente)
                        .addComponent(Cancelar))
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
    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
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
                    TextoInput.setText("");
                break;
        }


    }//GEN-LAST:event_ComboBoxInputCifrarActionPerformed

    private void ComboBoxOutputCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxOutputCifrarActionPerformed
        // TODO add your handling code here:

         int selectedIndex = ComboBoxOutputCifrar.getSelectedIndex();
        switch (selectedIndex) {
            case 0: BotonBrowseCifrarOutput.setEnabled(false);
                    TextoOutput.setText("");
                    TextoOutput.setEnabled(false);

                break;
            case 1: BotonBrowseCifrarOutput.setEnabled(false);
                    TextoOutput.setText("");
                    TextoOutput.setEnabled(false);

                break;
            case 2: BotonBrowseCifrarOutput.setEnabled(true);
                    TextoOutput.setEnabled(true);

                break;
        }
    }//GEN-LAST:event_ComboBoxOutputCifrarActionPerformed

    private void BotonBrowseCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBrowseCifrarActionPerformed
        // TODO add your handling code here:

        String rutaInput;
        int resul = archivos.showOpenDialog(null);
        File arch= archivos.getSelectedFile();
        rutaInput = arch.getPath();
        if (resul == archivos.APPROVE_OPTION) this.TextoInput.setText(rutaInput);
  
    }//GEN-LAST:event_BotonBrowseCifrarActionPerformed

    private void BotonBrowseCifrarOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBrowseCifrarOutputActionPerformed
        // TODO add your handling code here:

        String rutaOutput;
        int resul = archivos.showOpenDialog(null);
        File archi= archivos.getSelectedFile();
        rutaOutput = archi.getPath();
        if (resul == archivos.APPROVE_OPTION) this.TextoOutput.setText(rutaOutput);
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
                    TextoKey.setText("");
                break;
        }
    }//GEN-LAST:event_ComboBoxKeyActionPerformed

    private void BotonBrowseCifrarKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBrowseCifrarKeyActionPerformed
        // TODO add your handling code here:

        String rutaKey;
        int resul = archivos.showOpenDialog(null);
        File archi= archivos.getSelectedFile();
        rutaKey = archi.getPath();
        if (resul == archivos.APPROVE_OPTION) this.TextoKey.setText(rutaKey);

    }//GEN-LAST:event_BotonBrowseCifrarKeyActionPerformed



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


    private boolean ComprobarDatos () {
        int selectedIndex1 = ComboBoxInputCifrar.getSelectedIndex();
        int selectedIndex2 = ComboBoxKey.getSelectedIndex();
        int selectedIndex3 = ComboBoxOutputCifrar.getSelectedIndex();
        String contenido = TextoKey.getText();
        boolean aux=true;

        if (TextoKey.getText().isEmpty() || TextoInput.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Tiene que rellenar todos los campos.");
           aux=false;
        }

        if (TextoOutput.getText().isEmpty() & selectedIndex3==2 & aux ){
           JOptionPane.showMessageDialog(this, "Tiene que rellenar todos los campos.");
           aux=false;
        }

        if ( ((selectedIndex1==1) &  (ComprobarHexadecimal(TextoInput.getText()) == false)) & aux)
             {
                 JOptionPane.showMessageDialog(this, "Debe introducir un valor hexadecimal en el campo INPUT.");
                 aux=false;
             }
        if (( selectedIndex2==1)  &  (ComprobarHexadecimal(TextoKey.getText()) == false) & aux)
             {
            JOptionPane.showMessageDialog(this, "Debe introducir un valor hexadecimal en el campo KEY.");
            aux=false;
            }


        if ((RadioButton256.isSelected()) & aux) {

            if ((contenido.length() > 32) & selectedIndex2==0) {
            JOptionPane.showMessageDialog(this, "El tamaño de la clave no puede superar los 32 caracteres ASCII");
            aux=false;
            }

            if ((contenido.length() > 64) & selectedIndex2==1) {
            JOptionPane.showMessageDialog(this, "El tamaño de la clave no puede superar los 64 dígitos hexadecimales");
            aux=false;
            }
        }

        if ((RadioButton192.isSelected()) & aux) {

            if ((contenido.length() > 24) & selectedIndex2==0) {
            JOptionPane.showMessageDialog(this, "El tamaño de la clave no puede superar los 24 caracteres ASCII");
            aux=false;
            }

            if ((contenido.length() > 48) & selectedIndex2==1) {
            JOptionPane.showMessageDialog(this, "El tamaño de la clave no puede superar los 48 dígitos hexadecimales");
            aux=false;
            }
        }

        if ((RadioButton128.isSelected()) & aux) {

            if ((contenido.length() > 16) & selectedIndex2==0) {
            JOptionPane.showMessageDialog(this, "El tamaño de la clave no puede superar los 16 caracteres ASCII");
            aux=false;
            }

            if ((contenido.length() > 32) & selectedIndex2==1) {
            JOptionPane.showMessageDialog(this, "El tamaño de la clave no puede superar los 32 dígitos hexadecimales");
            aux=false;
            }
        }

        return aux;
    }


    private void BotonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSiguienteActionPerformed
    
        int opcion1 = ComboBoxInputCifrar.getSelectedIndex();
        int opcion2 = ComboBoxKey.getSelectedIndex();
        int opcion3 = ComboBoxOutputCifrar.getSelectedIndex();

        int tamano = 0;

        if (RadioButton128.isSelected()) {
            tamano = 128;
        }
        else if (RadioButton192.isSelected()) {
            tamano = 192;
        }
        else if (RadioButton256.isSelected()) {
            tamano = 256;
        }


    if (ComprobarDatos()){
       procesocifrado = new ProcesoCifrarUI (wpadre,TextoInput.getText(),TextoKey.getText(),TextoOutput.getText(),opcion1,opcion2,opcion3,tamano);
       procesocifrado.setLocationRelativeTo(null);
       procesocifrado.setVisible(true);                
       wpadre.newchild(procesocifrado);
      }
    }//GEN-LAST:event_BotonSiguienteActionPerformed

    private void BotonInfoCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInfoCifrarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_BotonInfoCifrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);
    }//GEN-LAST:event_formWindowClosing

    private void TextoOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoOutputActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_CancelarActionPerformed

    private void RadioButton256ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton256ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_RadioButton256ActionPerformed

    private void RadioButton128ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton128ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_RadioButton128ActionPerformed

    private void RadioButton192ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton192ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_RadioButton192ActionPerformed









    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBrowseCifrar;
    private javax.swing.JButton BotonBrowseCifrarKey;
    private javax.swing.JButton BotonBrowseCifrarOutput;
    private javax.swing.JButton BotonInfoCifrar;
    private javax.swing.JButton BotonSiguiente;
    private javax.swing.JButton Cancelar;
    private javax.swing.JComboBox ComboBoxInputCifrar;
    private javax.swing.JComboBox ComboBoxKey;
    private javax.swing.JComboBox ComboBoxOutputCifrar;
    private javax.swing.JComboBox ModoCifrado;
    private javax.swing.JRadioButton RadioButton128;
    private javax.swing.JRadioButton RadioButton192;
    private javax.swing.JRadioButton RadioButton256;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JTextArea TextoInput;
    private javax.swing.JTextArea TextoKey;
    private javax.swing.JTextField TextoOutput;
    private javax.swing.JFileChooser archivos;
    private javax.swing.JMenuBar cifrarMenuBarMain;
    private javax.swing.JPanel cifrarPanelAdvOptions;
    private javax.swing.JPanel cifrarPanelInput;
    private javax.swing.JPanel cifrarPanelMain;
    private javax.swing.JPanel cifrarPanelOutput;
    private javax.swing.JScrollPane cifrarScrollPaneMain;
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
