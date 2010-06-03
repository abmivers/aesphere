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

    private javax.swing.JFrame hijoActual;

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
        MainScrollPane = new javax.swing.JScrollPane();
        MainPanel = new javax.swing.JPanel();
        HerramientasLabel = new javax.swing.JLabel();
        BotonHerramientas = new javax.swing.JButton();
        AtaquesLabel = new javax.swing.JLabel();
        BotonAtaques = new javax.swing.JButton();
        DescifrarLabel = new javax.swing.JLabel();
        BotonDescifrar = new javax.swing.JButton();
        CifrarLabel = new javax.swing.JLabel();
        BotonCifrar = new javax.swing.JButton();
        BotonInfo = new javax.swing.JButton();
        mainMenuBar = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        mainMenuEditar = new javax.swing.JMenu();
        mainMenuOperaciones = new javax.swing.JMenu();
        mainMenuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainScrollPane.setPreferredSize(new java.awt.Dimension(700, 500));

        MainPanel.setPreferredSize(new java.awt.Dimension(700, 500));

        HerramientasLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        HerramientasLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HerramientasLabel.setText("HERRAMIENTAS");

        BotonHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/herramientas.png"))); // NOI18N
        BotonHerramientas.setBorder(null);
        BotonHerramientas.setBorderPainted(false);
        BotonHerramientas.setContentAreaFilled(false);
        BotonHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonHerramientasActionPerformed(evt);
            }
        });

        AtaquesLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        AtaquesLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AtaquesLabel.setText("SIMULAR ATAQUES");

        BotonAtaques.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ataques.png"))); // NOI18N
        BotonAtaques.setBorder(null);
        BotonAtaques.setBorderPainted(false);
        BotonAtaques.setContentAreaFilled(false);
        BotonAtaques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAtaquesActionPerformed(evt);
            }
        });

        DescifrarLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DescifrarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DescifrarLabel.setText("DESCIFRAR");

        BotonDescifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/unlock3.png"))); // NOI18N
        BotonDescifrar.setBorder(null);
        BotonDescifrar.setBorderPainted(false);
        BotonDescifrar.setContentAreaFilled(false);
        BotonDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDescifrarActionPerformed(evt);
            }
        });

        CifrarLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CifrarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CifrarLabel.setText("CIFRAR");

        BotonCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lock2.png"))); // NOI18N
        BotonCifrar.setBorder(null);
        BotonCifrar.setBorderPainted(false);
        BotonCifrar.setContentAreaFilled(false);
        BotonCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCifrarActionPerformed(evt);
            }
        });

        BotonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfo.setBorder(null);
        BotonInfo.setContentAreaFilled(false);
        BotonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(BotonAtaques)
                        .addGap(50, 50, 50)
                        .addComponent(AtaquesLabel))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(BotonDescifrar)
                        .addGap(50, 50, 50)
                        .addComponent(DescifrarLabel))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(BotonCifrar)
                        .addGap(50, 50, 50)
                        .addComponent(CifrarLabel))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(BotonHerramientas)
                        .addGap(50, 50, 50)
                        .addComponent(HerramientasLabel)))
                .addGap(319, 319, 319))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap(762, Short.MAX_VALUE)
                .addComponent(BotonInfo)
                .addGap(49, 49, 49))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CifrarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(BotonCifrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescifrarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(BotonDescifrar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AtaquesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(BotonAtaques, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HerramientasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(BotonHerramientas, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(40, 40, 40)
                .addComponent(BotonInfo)
                .addContainerGap())
        );

        MainScrollPane.setViewportView(MainPanel);

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
            .addComponent(MainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDescifrarActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new ProcesoCifrarUI(this,"","","",0,0,0,0);
            hijoActual.setLocationRelativeTo(null);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_BotonDescifrarActionPerformed

    private void BotonAtaquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAtaquesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonAtaquesActionPerformed

    private void BotonCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCifrarActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        if (hijoActual == null) {
            hijoActual = new MainCifrarUI(this);
            hijoActual.setLocationRelativeTo(null);
            hijoActual.setVisible(true);
        }
        else hijoActual.requestFocus();
    }//GEN-LAST:event_BotonCifrarActionPerformed

    private void BotonHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonHerramientasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonHerramientasActionPerformed

    private void BotonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonInfoActionPerformed

    public void wclosed (javax.swing.JFrame hijo){
        if (hijoActual.equals(hijo)) {
            hijoActual.dispose();
            hijoActual = null;            
        }        
    }

    public void newchild (javax.swing.JFrame newhijo){
        if (hijoActual == null) hijoActual = newhijo;
        else {
            hijoActual.dispose();
            hijoActual = newhijo;
        }
    }

    /**
    * @param args the command line arguments
    */
   

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
    private javax.swing.JPanel MainPanel;
    private javax.swing.JScrollPane MainScrollPane;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JMenu mainMenuArchivo;
    private javax.swing.JMenu mainMenuAyuda;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenu mainMenuEditar;
    private javax.swing.JMenu mainMenuOperaciones;
    // End of variables declaration//GEN-END:variables

}
