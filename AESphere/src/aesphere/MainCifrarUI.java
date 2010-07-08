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

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class MainCifrarUI extends javax.swing.JFrame {

    private MainUI wpadre;
    private String key;
    private String helpErrMsg = "Ha ocurrido un error al cargar la ayuda de la aplicación";
    private String helpErrTitle = "Ayuda - Aviso";

    /** Creates new form Main */
    public MainCifrarUI(MainUI padre) {
        initComponents();
        setLangLabels();
        setHelp();
        wpadre = padre;

        archivos = new JFileChooser();

        ButtonGroup group = new ButtonGroup();
        group.add(RadioButton128);
        group.add(RadioButton192);
        group.add(RadioButton256);
    }



    /** Sets all the titles of the interface elements */
    private void setLangLabels () {
        if (Entorno.getProperty("language").equals("ES")) {
            this.setTitle("AESphere - Cifrar");
            cifrarPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " ENTRADA ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
            cifrarPanelOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " SALIDA ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
            cifrarPanelAdvOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " OPCIONES AVANZADAS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
            ComboBoxInputCifrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Texto ASCII", "Hexadecimal", "Archivo" }));
            BotonBrowseCifrar.setText("Buscar");
            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clave"));
            ComboBoxKey.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASCII", "Hexadecimal", "Archivo (Base64)" }));
            BotonBrowseCifrarKey.setText("Buscar");
            ComboBoxOutputCifrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Base64", "Hexadecimal", "Archivo" }));
            BotonBrowseCifrarOutput.setText("Buscar");
            jLabel4.setText("Método de cifrado:");
            ModoCifrado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modo ECB", "Modo CBC" }));
            manualIV.setText("Introducir IV manualmente");
            jLabel5.setText("Modo de ejecución:");
            ModoEjecucion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Paso a Paso", "Directo" }));
            Cancelar.setText("Cancelar");
            BotonSiguiente.setText("Siguiente");
            mainMenuArchivo.setText("Archivo");
            AbrirClave.setText("Abrir clave (Base64)");
            GuardarClave.setText("Guardar clave (Base64)");
        }
        else if (Entorno.getProperty("language").equals("EN")) {
            this.setTitle("AESphere - Cipher");
            cifrarPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " INPUT ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
            cifrarPanelOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " OUTPUT ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
            cifrarPanelAdvOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " ADVANCED OPTIONS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
            ComboBoxInputCifrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASCII text", "Hexadecimal", "File" }));
            BotonBrowseCifrar.setText("Browse");
            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Key"));
            ComboBoxKey.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASCII", "Hexadecimal", "File (Base64)" }));
            BotonBrowseCifrarKey.setText("Browse");
            ComboBoxOutputCifrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Base64", "Hexadecimal", "File"}));
            BotonBrowseCifrarOutput.setText("Browse");
            jLabel4.setText("Encryption mode:");
            ModoCifrado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ECB mode", "CBC mode" }));
            manualIV.setText("Introduce IV manually");
            jLabel5.setText("Execution mode:");
            ModoEjecucion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Step by step", "Direct" }));
            Cancelar.setText("Cancel");
            BotonSiguiente.setText("Next");
            mainMenuArchivo.setText("File");
            AbrirClave.setText("Open key (Base64)");
            GuardarClave.setText("Save key (Base64)");
        }
    }


    private void setHelp () {

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = getSize();

        try {
            File fichero = null;

            if (Entorno.getProperty("language").equals("ES"))
                fichero = new File("help/help_set_ES.hs");
            else if (Entorno.getProperty("language").equals("EN"))
                fichero = new File("help/help_set_EN.hs");
            URL hsURL = fichero.toURI().toURL();
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();
            hb.setLocation(new java.awt.Point((pantalla.width - ventana.width) / 2,
                                (pantalla.height - ventana.height) / 2));
            hb.setSize(new java.awt.Dimension(800, 628));
            hb.enableHelpOnButton(ContenidosCifrar, "ventana_cifrado", helpset);
            hb.enableHelpOnButton(BotonInfoCifrar, "ventana_cifrado", helpset);
        }

        catch (Exception e) {
             JOptionPane.showMessageDialog(this, helpErrMsg, helpErrTitle,
                     JOptionPane.ERROR_MESSAGE);
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
        jLabel5 = new javax.swing.JLabel();
        ModoEjecucion = new javax.swing.JComboBox();
        manualIV = new javax.swing.JCheckBox();
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
        AbrirClave = new javax.swing.JMenuItem();
        GuardarClave = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        mainMenuEditar = new javax.swing.JMenu();
        CopiarInput = new javax.swing.JMenuItem();
        PegarInput = new javax.swing.JMenuItem();
        CopiarKey = new javax.swing.JMenuItem();
        PegarKey = new javax.swing.JMenuItem();
        mainMenuAyuda = new javax.swing.JMenu();
        ContenidosCifrar = new javax.swing.JMenuItem();
        acercade = new javax.swing.JMenuItem();

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

        ComboBoxKey.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASCII", "Hexadecimal", "Archivo (Base64)" }));
        ComboBoxKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxKeyActionPerformed(evt);
            }
        });

        TextoKey.setColumns(20);
        TextoKey.setLineWrap(true);
        TextoKey.setRows(5);
        TextoKey.setWrapStyleWord(true);
        jScrollPane3.setViewportView(TextoKey);

        BotonBrowseCifrarKey.setText("Buscar");
        BotonBrowseCifrarKey.setEnabled(false);
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboBoxKey, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
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
        TextoInput.setWrapStyleWord(true);
        jScrollPane1.setViewportView(TextoInput);

        BotonBrowseCifrar.setText("Buscar");
        BotonBrowseCifrar.setEnabled(false);
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
        ModoCifrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModoCifradoActionPerformed(evt);
            }
        });

        jLabel5.setText("Modo de ejecución:");

        ModoEjecucion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Paso a Paso", "Directo" }));
        ModoEjecucion.setSelectedIndex(1);
        ModoEjecucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModoEjecucionActionPerformed(evt);
            }
        });

        manualIV.setText("Introducir IV manualmente");
        manualIV.setEnabled(false);
        manualIV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualIVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cifrarPanelAdvOptionsLayout = new javax.swing.GroupLayout(cifrarPanelAdvOptions);
        cifrarPanelAdvOptions.setLayout(cifrarPanelAdvOptionsLayout);
        cifrarPanelAdvOptionsLayout.setHorizontalGroup(
            cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                        .addComponent(manualIV)
                        .addContainerGap())
                    .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ModoCifrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(ModoEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
        );
        cifrarPanelAdvOptionsLayout.setVerticalGroup(
            cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                .addGroup(cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(cifrarPanelAdvOptionsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ModoCifrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(ModoEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(manualIV)
                .addGap(17, 17, 17))
        );

        cifrarPanelOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " OUTPUT ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botondef2.png"))); // NOI18N

        ComboBoxOutputCifrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Base64", "Hexadecimal", "Archivo" }));
        ComboBoxOutputCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxOutputCifrarActionPerformed(evt);
            }
        });

        BotonBrowseCifrarOutput.setText("Buscar");
        BotonBrowseCifrarOutput.setEnabled(false);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(cifrarPanelAdvOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        AbrirClave.setText("Abrir Clave (Base64)");
        AbrirClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirClaveActionPerformed(evt);
            }
        });
        mainMenuArchivo.add(AbrirClave);

        GuardarClave.setText("Guardar Clave (Base64)");
        GuardarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarClaveActionPerformed(evt);
            }
        });
        mainMenuArchivo.add(GuardarClave);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        mainMenuArchivo.add(Salir);

        cifrarMenuBarMain.add(mainMenuArchivo);

        mainMenuEditar.setText("Editar");

        CopiarInput.setText("Copiar Input");
        CopiarInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarInputActionPerformed(evt);
            }
        });
        mainMenuEditar.add(CopiarInput);

        PegarInput.setText("Pegar Input");
        PegarInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PegarInputActionPerformed(evt);
            }
        });
        mainMenuEditar.add(PegarInput);

        CopiarKey.setText("Copiar Key");
        CopiarKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarKeyActionPerformed(evt);
            }
        });
        mainMenuEditar.add(CopiarKey);

        PegarKey.setText("Pegar Key");
        PegarKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PegarKeyActionPerformed(evt);
            }
        });
        mainMenuEditar.add(PegarKey);

        cifrarMenuBarMain.add(mainMenuEditar);

        mainMenuAyuda.setText("Ayuda");
        mainMenuAyuda.setComponentPopupMenu(jPopupMenu1);

        ContenidosCifrar.setText("Contenidos");
        mainMenuAyuda.add(ContenidosCifrar);

        acercade.setText("Acerca de");
        mainMenuAyuda.add(acercade);

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
         
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_SalirActionPerformed

    private void ComboBoxInputCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxInputCifrarActionPerformed
         

       int selectedIndex = ComboBoxInputCifrar.getSelectedIndex();     

        switch (selectedIndex) {
            case 0: BotonBrowseCifrar.setEnabled(false);
                    TextoInput.setEditable(true);
                    TextoInput.setText("");

                break;
            case 1: BotonBrowseCifrar.setEnabled(false);
                    TextoInput.setEditable(true);
                    TextoInput.setText("");

                break;
            case 2: BotonBrowseCifrar.setEnabled(true);
                    TextoInput.setEditable(false);
                    TextoInput.setText("");
        }


    }//GEN-LAST:event_ComboBoxInputCifrarActionPerformed

    private void ComboBoxOutputCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxOutputCifrarActionPerformed
         

         int selectedIndex = ComboBoxOutputCifrar.getSelectedIndex();
         int selectedIndex2 = ComboBoxInputCifrar.getSelectedIndex();

        switch (selectedIndex) {
            case 0: ModoEjecucion.setEnabled(true);
                    BotonBrowseCifrarOutput.setEnabled(false);
                    TextoOutput.setText("");
                    TextoOutput.setEnabled(false);

                break;
            case 1: BotonBrowseCifrarOutput.setEnabled(false);
                    TextoOutput.setText("");
                    TextoOutput.setEnabled(false);
                    ModoEjecucion.setEnabled(true);

                break;
            case 2: BotonBrowseCifrarOutput.setEnabled(true);
                    TextoOutput.setEnabled(true);
                    if (selectedIndex2==2) {
                        ModoEjecucion.setSelectedIndex(1);
                        ModoEjecucion.setEnabled(false);
                    }

                break;
        }
    }//GEN-LAST:event_ComboBoxOutputCifrarActionPerformed




    private void BotonBrowseCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBrowseCifrarActionPerformed
         
        int resul = archivos.showOpenDialog(null);
        File arch= archivos.getSelectedFile(); 
        if (resul == JFileChooser.APPROVE_OPTION) this.TextoInput.setText(arch.getPath());
  
    }//GEN-LAST:event_BotonBrowseCifrarActionPerformed

    private void BotonBrowseCifrarOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBrowseCifrarOutputActionPerformed
         
        int resul = archivos.showSaveDialog(null);
        File archi= archivos.getSelectedFile();
        if (resul == JFileChooser.APPROVE_OPTION) this.TextoOutput.setText(archi.getPath());
        
    }//GEN-LAST:event_BotonBrowseCifrarOutputActionPerformed

    private void ComboBoxKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxKeyActionPerformed
         

         int selectedIndex = ComboBoxKey.getSelectedIndex();
        switch (selectedIndex) {
            case 0: BotonBrowseCifrarKey.setEnabled(false);
                    TextoKey.setEditable(true);
                    TextoKey.setText("");

                break;
            case 1: BotonBrowseCifrarKey.setEnabled(false);
                    TextoKey.setEditable(true);
                    TextoKey.setText("");

                break;
            case 2: BotonBrowseCifrarKey.setEnabled(true);
                    TextoKey.setEditable(false);
                    TextoKey.setText("");
        }
    }//GEN-LAST:event_ComboBoxKeyActionPerformed

    private void BotonBrowseCifrarKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBrowseCifrarKeyActionPerformed
         
        int resul = archivos.showOpenDialog(null);
        File archi= archivos.getSelectedFile();        
        if (resul == JFileChooser.APPROVE_OPTION) this.TextoKey.setText(archi.getPath());

    }//GEN-LAST:event_BotonBrowseCifrarKeyActionPerformed



    private boolean ComprobarHexadecimal (String cadena){

    boolean resul = true;

    for (int i = 0; i < cadena.length() ; i++){

      if ( ((cadena.charAt(i) >= 'A') && (cadena.charAt(i) <= 'F')) ||
          ((cadena.charAt(i) >= 'a') && (cadena.charAt(i) <= 'f')) ||
          ((cadena.charAt(i) >= '0') && (cadena.charAt(i) <= '9')));
      else {
          resul=false;
      }
    }

    return resul;


    }

    private boolean comprobarBase64 (String base64) {
        boolean aux = true;
        int len = base64.length();
        //llevamos un contador para comprobar la longitud del string sin '/n' ni '/r'
        int count = 0;
        for (int i = 0; aux && (i < len); i++) {
            char letra = base64.charAt(i);

            if ( ((letra >= 'A') && (letra <= 'Z')) ||
                    ((letra >= 'a') && (letra <= 'z')) ||
                    ((letra >= '0') && (letra <= '9')) ||
                    (letra == '=') || (letra == '/') || (letra == '+') );
            else {
                if ( (letra == '\r') || (letra == '\n') ) //Si es salto de línea aumentamos el contador
                    count++;
                else aux = false;
            }
        }

        //si el número de caracteres (excluyendo salto de línea) no es múltiplo de 4, no es correcto
        if (aux && ((len - count) % 4 != 0) ) aux = false;

        return aux;
    }

    private boolean comprobarArchivo (int numChar) {
        boolean resul = true;

        try {
            //leemos el archivo, actualmente en key se encuentra la ruta
            byte[] keyAux = ReadFileIntoByteArray.getBytesFromFile(new File(key));

            //transformamos la clave a String para realizar la comprobación de Base64
            //key pasa a contener la clave en Base64
            key = Conversor.byteToTextString(keyAux);

            //comprobamos si la longitud es correcta
            if (key.length() != numChar) {
                JOptionPane.showMessageDialog(this, "La longitud de la clave" +
                        " en Base64 del archivo seleccionado debe ser de " +
                        Integer.toString(numChar) + " caracteres.");
                resul = false;
            }
            //comprobamos si el formato es correcto
            if (resul && !comprobarBase64(key)) {
                JOptionPane.showMessageDialog(this, "El formato de la clave " +
                        "en Base64 del archivo seleccionado es incorrecto.");
                resul = false;
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al" +
                    "abrir el archivo de clave");
            resul = false;
        }
        return resul;
    }

    private boolean ComprobarDatos () {
        int indexIn = ComboBoxInputCifrar.getSelectedIndex();
        int indexKey = ComboBoxKey.getSelectedIndex();
        int indexOut = ComboBoxOutputCifrar.getSelectedIndex();
        String contenido = TextoKey.getText();

        boolean aux=true;

        if ( aux && (TextoKey.getText().isEmpty() || TextoInput.getText().isEmpty()) ){
           JOptionPane.showMessageDialog(this, "Tiene que rellenar todos los campos.");
           aux=false;
        }

        if ( aux && (indexOut==2) && TextoOutput.getText().isEmpty() ){
           JOptionPane.showMessageDialog(this, "Tiene que rellenar todos los campos.");
           aux=false;
        }

        if ( aux && (indexIn==1) && !ComprobarHexadecimal(TextoInput.getText()) )
             {
                 JOptionPane.showMessageDialog(this, "Debe introducir un valor hexadecimal en el campo INPUT.");
                 aux=false;
             }
        if ( aux && (indexKey==1) && !ComprobarHexadecimal(TextoKey.getText()) )
             {
            JOptionPane.showMessageDialog(this, "Debe introducir un valor hexadecimal en el campo KEY.");
            aux=false;
            }

        if (aux && RadioButton256.isSelected()) {

            if ( (indexKey == 0) && (contenido.length() != 32) )  {
                JOptionPane.showMessageDialog(this, "El tamaño de la clave debe ser de 32 caracteres ASCII");
                aux=false;
            }

            if ( (indexKey == 1) && (contenido.length() != 64) ) {
                JOptionPane.showMessageDialog(this, "El tamaño de la clave debe ser de 64 dígitos hexadecimales");
                aux=false;
            }

            if ( (indexKey == 2) && !comprobarArchivo(44) )
                aux=false;
        }

        if (aux && RadioButton192.isSelected() ) {

            if ( (indexKey == 0) && (contenido.length() != 24) ) {
                JOptionPane.showMessageDialog(this, "El tamaño de la clave debe ser de 24 caracteres ASCII");
                aux=false;
            }

            if ( (indexKey == 1) && (contenido.length() != 48) ) {
                JOptionPane.showMessageDialog(this, "El tamaño de la clave debe ser de 48 dígitos hexadecimales");
                aux=false;
            }

            if ( (indexKey == 2) && !comprobarArchivo(32) )
                aux=false;
        }

        if (aux && RadioButton128.isSelected()) {

            if ( (indexKey == 0) && (contenido.length() != 16) ) {
                JOptionPane.showMessageDialog(this, "El tamaño de la clave debe ser de 16 caracteres ASCII");
                aux=false;
            }

            if ( (indexKey == 1) && (contenido.length() != 32) ) {
                JOptionPane.showMessageDialog(this, "El tamaño de la clave debe ser de 32 dígitos hexadecimales");
                aux=false;
            }

            if ( (indexKey == 2) && !comprobarArchivo(24) )
                aux=false;
        }

        return aux;
    }


    private void BotonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSiguienteActionPerformed
    
        int opcionIn = ComboBoxInputCifrar.getSelectedIndex();
        int opcionKey = ComboBoxKey.getSelectedIndex();
        int opcionOut = ComboBoxOutputCifrar.getSelectedIndex();
        int op_block = ModoCifrado.getSelectedIndex();
        int opcionejecucion = ModoEjecucion.getSelectedIndex();

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

        //damos valor a key
        //este valor cambiará en ComprobarDatos si la entrada es por archivo y contendrá la clave en Base64
        key = TextoKey.getText();

        if ( (opcionejecucion == 0) && ComprobarDatos() )
            new ProcesoCifrarUI (wpadre,TextoInput.getText(), key,
                TextoOutput.getText(), opcionIn, opcionKey, opcionOut, op_block,
                tamano, manualIV.isSelected());
        else if ( (opcionejecucion == 1) && ComprobarDatos() )
            new ProcesoCifrarDirectoUI
                (wpadre,TextoInput.getText(), key,
                TextoOutput.getText(), opcionIn, opcionKey, opcionOut, op_block,
                tamano, manualIV.isSelected());
    }//GEN-LAST:event_BotonSiguienteActionPerformed





    private void BotonInfoCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInfoCifrarActionPerformed
         

    }//GEN-LAST:event_BotonInfoCifrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         
        wpadre.setEnabled(true);
        wpadre.requestFocus();
        wpadre.wclosed(this);
    }//GEN-LAST:event_formWindowClosing

    private void TextoOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoOutputActionPerformed
         
    }//GEN-LAST:event_TextoOutputActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
         
        this.dispatchEvent(new java.awt.event.WindowEvent(this, java.awt.event.WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_CancelarActionPerformed

    private void RadioButton256ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton256ActionPerformed
           
    }//GEN-LAST:event_RadioButton256ActionPerformed

    private void RadioButton128ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton128ActionPerformed
         
    }//GEN-LAST:event_RadioButton128ActionPerformed

    private void RadioButton192ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButton192ActionPerformed
         
    }//GEN-LAST:event_RadioButton192ActionPerformed

    private void ModoCifradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModoCifradoActionPerformed
        switch (ModoCifrado.getSelectedIndex()) {
            case 0:
                manualIV.setEnabled(false);
                break;
            case 1:
                manualIV.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_ModoCifradoActionPerformed

    private void ModoEjecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModoEjecucionActionPerformed
        
    }//GEN-LAST:event_ModoEjecucionActionPerformed

    private void AbrirClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirClaveActionPerformed

        int resul = archivos.showOpenDialog(null);
        File archi= archivos.getSelectedFile(); 
        ComboBoxKey.setSelectedIndex(2);
        if (resul == JFileChooser.APPROVE_OPTION) this.TextoKey.setText(archi.getPath());


    }//GEN-LAST:event_AbrirClaveActionPerformed

    private void CopiarInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarInputActionPerformed
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(TextoInput.getText());
        cb.setContents(ss, ss);
    }//GEN-LAST:event_CopiarInputActionPerformed

    private void PegarInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PegarInputActionPerformed
      Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
      Transferable t = cb.getContents(this);


       try{
           DataFlavor dataFlavorStringJava = new DataFlavor("application/x-java-serialized-object; class=java.lang.String");
           if (t.isDataFlavorSupported(dataFlavorStringJava)) {
           String texto = (String) t.getTransferData(dataFlavorStringJava);
           TextoInput.setText(texto);}
       }
       catch (Exception e){
           JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar pegar el contenido del Portapapeles");

       }
    }//GEN-LAST:event_PegarInputActionPerformed

    private void GuardarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarClaveActionPerformed

        int resul = archivos.showSaveDialog(null);
        File archi= archivos.getSelectedFile();
        byte [] aux = null;
        if (resul == JFileChooser.APPROVE_OPTION)
            switch (ComboBoxKey.getSelectedIndex()) {
                case 0:
                    aux = Conversor.stringToASCII(TextoKey.getText());
                    Conversor.byteToFile(Base64.encodeToByte(aux, true), archi.getPath());
                    break;
                case 1:
                    aux = Conversor.hexStringToByte(TextoKey.getText());
                    Conversor.byteToFile(Base64.encodeToByte(aux, true), archi.getPath());
            }
    }//GEN-LAST:event_GuardarClaveActionPerformed

    private void CopiarKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarKeyActionPerformed
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(TextoKey.getText());
        cb.setContents(ss, ss);
    }//GEN-LAST:event_CopiarKeyActionPerformed

    private void PegarKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PegarKeyActionPerformed
           Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
      Transferable t = cb.getContents(this);


       try{
           DataFlavor dataFlavorStringJava = new DataFlavor("application/x-java-serialized-object; class=java.lang.String");
           if (t.isDataFlavorSupported(dataFlavorStringJava)) {
           String texto = (String) t.getTransferData(dataFlavorStringJava);
           TextoKey.setText(texto);}
       }
       catch (Exception e){
           JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar pegar el contenido del Portapapeles");

       }
    }//GEN-LAST:event_PegarKeyActionPerformed

    private void manualIVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualIVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manualIVActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AbrirClave;
    private javax.swing.JButton BotonBrowseCifrar;
    private javax.swing.JButton BotonBrowseCifrarKey;
    private javax.swing.JButton BotonBrowseCifrarOutput;
    private javax.swing.JButton BotonInfoCifrar;
    private javax.swing.JButton BotonSiguiente;
    private javax.swing.JButton Cancelar;
    private javax.swing.JComboBox ComboBoxInputCifrar;
    private javax.swing.JComboBox ComboBoxKey;
    private javax.swing.JComboBox ComboBoxOutputCifrar;
    private javax.swing.JMenuItem ContenidosCifrar;
    private javax.swing.JMenuItem CopiarInput;
    private javax.swing.JMenuItem CopiarKey;
    private javax.swing.JMenuItem GuardarClave;
    private javax.swing.JComboBox ModoCifrado;
    private javax.swing.JComboBox ModoEjecucion;
    private javax.swing.JMenuItem PegarInput;
    private javax.swing.JMenuItem PegarKey;
    private javax.swing.JRadioButton RadioButton128;
    private javax.swing.JRadioButton RadioButton192;
    private javax.swing.JRadioButton RadioButton256;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JTextArea TextoInput;
    private javax.swing.JTextArea TextoKey;
    private javax.swing.JTextField TextoOutput;
    private javax.swing.JMenuItem acercade;
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
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JCheckBox manualIV;
    // End of variables declaration//GEN-END:variables

}
