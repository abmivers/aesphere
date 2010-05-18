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

/**
 *
 * @author admin
 */
public class MainUI extends javax.swing.JFrame {

    private MainCifrarUI cifrarUIhijo;

    /** Creates new form Main */
    public MainUI() {
        initComponents();
        setLangLabels();
    }


    /** Sets all the titles of the interface elements */
    private void setLangLabels () {
        if (Entorno.lang.equals("ES")) {
            this.setTitle("AESphere - Ventana Principal");
        }
        else if (Entorno.lang.equals("EN")) {
            this.setTitle("AESphere - Main Window");
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
        mainScrollPane = new javax.swing.JScrollPane();
        PanelMain = new javax.swing.JPanel();
        BotonCifrar = new javax.swing.JButton();
        BotonDescifrar = new javax.swing.JButton();
        BotonAtaques = new javax.swing.JButton();
        BotonInfo = new javax.swing.JButton();
        CifrarLabel = new javax.swing.JLabel();
        DescifrarLabel = new javax.swing.JLabel();
        AtaquesLabel = new javax.swing.JLabel();
        BotonHerramientas = new javax.swing.JButton();
        HerramientasLabel = new javax.swing.JLabel();
        mainMenuBar = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        mainMenuEditar = new javax.swing.JMenu();
        mainMenuOperaciones = new javax.swing.JMenu();
        mainMenuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainScrollPane.setBorder(null);

        PanelMain.setPreferredSize(new java.awt.Dimension(788, 566));

        BotonCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lock2.png"))); // NOI18N
        BotonCifrar.setBorder(null);
        BotonCifrar.setContentAreaFilled(false);
        BotonCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCifrarActionPerformed(evt);
            }
        });

        BotonDescifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/unlock3.png"))); // NOI18N
        BotonDescifrar.setBorder(null);
        BotonDescifrar.setContentAreaFilled(false);
        BotonDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDescifrarActionPerformed(evt);
            }
        });

        BotonAtaques.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ataques.png"))); // NOI18N
        BotonAtaques.setBorder(null);
        BotonAtaques.setContentAreaFilled(false);
        BotonAtaques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAtaquesActionPerformed(evt);
            }
        });

        BotonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfo.setBorder(null);
        BotonInfo.setContentAreaFilled(false);

        CifrarLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CifrarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CifrarLabel.setText("CIFRAR");

        DescifrarLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DescifrarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DescifrarLabel.setText("DESCIFRAR");

        AtaquesLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        AtaquesLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AtaquesLabel.setText("SIMULAR ATAQUES");

        BotonHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/herramientas.png"))); // NOI18N
        BotonHerramientas.setBorder(null);
        BotonHerramientas.setBorderPainted(false);
        BotonHerramientas.setContentAreaFilled(false);
        BotonHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonHerramientasActionPerformed(evt);
            }
        });

        HerramientasLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        HerramientasLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HerramientasLabel.setText("HERRAMIENTAS");

        javax.swing.GroupLayout PanelMainLayout = new javax.swing.GroupLayout(PanelMain);
        PanelMain.setLayout(PanelMainLayout);
        PanelMainLayout.setHorizontalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMainLayout.createSequentialGroup()
                .addContainerGap(786, Short.MAX_VALUE)
                .addComponent(BotonInfo)
                .addContainerGap())
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonDescifrar)
                    .addComponent(BotonAtaques)
                    .addComponent(BotonHerramientas)
                    .addComponent(BotonCifrar))
                .addGap(70, 70, 70)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AtaquesLabel)
                    .addComponent(DescifrarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HerramientasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CifrarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        PanelMainLayout.setVerticalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMainLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CifrarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(BotonCifrar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DescifrarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonDescifrar))
                .addGap(18, 18, 18)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AtaquesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonAtaques, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HerramientasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonHerramientas))
                .addGap(35, 35, 35)
                .addComponent(BotonInfo)
                .addContainerGap())
        );

        PanelMainLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotonAtaques, BotonCifrar, BotonDescifrar, BotonHerramientas});

        mainScrollPane.setViewportView(PanelMain);

        mainMenuArchivo.setText("Archivo");
        mainMenuBar.add(mainMenuArchivo);

        mainMenuEditar.setText("Editar");
        mainMenuBar.add(mainMenuEditar);

        mainMenuOperaciones.setText("Operaciones");
        mainMenuBar.add(mainMenuOperaciones);

        mainMenuAyuda.setText("Ayuda");
        mainMenuAyuda.setComponentPopupMenu(jPopupMenu1);
        mainMenuBar.add(mainMenuAyuda);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDescifrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonDescifrarActionPerformed

    private void BotonAtaquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAtaquesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonAtaquesActionPerformed

    private void BotonCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCifrarActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        if (cifrarUIhijo == null) {
            cifrarUIhijo = new MainCifrarUI(this);
            cifrarUIhijo.setVisible(true);
        }
        else cifrarUIhijo.requestFocus();    
    }//GEN-LAST:event_BotonCifrarActionPerformed

    private void BotonHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonHerramientasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonHerramientasActionPerformed

    public void wclosed (javax.swing.JFrame hijo){
        if (hijo.equals(cifrarUIhijo)) cifrarUIhijo = null;
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AtaquesLabel;
    private javax.swing.JButton BotonAtaques;
    private javax.swing.JButton BotonCifrar;
    private javax.swing.JButton BotonDescifrar;
    private javax.swing.JButton BotonHerramientas;
    private javax.swing.JButton BotonInfo;
    private javax.swing.JLabel CifrarLabel;
    private javax.swing.JLabel DescifrarLabel;
    private javax.swing.JLabel HerramientasLabel;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JMenu mainMenuArchivo;
    private javax.swing.JMenu mainMenuAyuda;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenu mainMenuEditar;
    private javax.swing.JMenu mainMenuOperaciones;
    private javax.swing.JScrollPane mainScrollPane;
    // End of variables declaration//GEN-END:variables

}