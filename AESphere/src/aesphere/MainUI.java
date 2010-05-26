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
        MainScrollPane = new javax.swing.JScrollPane();
        MainPanel = new javax.swing.JPanel();
        BotonInfo = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        BotonCifrar = new javax.swing.JButton();
        CifrarLabel = new javax.swing.JLabel();
        BotonDescifrar = new javax.swing.JButton();
        DescifrarLabel = new javax.swing.JLabel();
        BotonAtaques = new javax.swing.JButton();
        AtaquesLabel = new javax.swing.JLabel();
        BotonHerramientas = new javax.swing.JButton();
        HerramientasLabel = new javax.swing.JLabel();
        mainMenuBar = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        mainMenuEditar = new javax.swing.JMenu();
        mainMenuOperaciones = new javax.swing.JMenu();
        mainMenuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setPreferredSize(new java.awt.Dimension(750, 550));

        BotonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfo.setBorder(null);
        BotonInfo.setContentAreaFilled(false);
        BotonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInfoActionPerformed(evt);
            }
        });

        BotonCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lock2.png"))); // NOI18N
        BotonCifrar.setBorder(null);
        BotonCifrar.setContentAreaFilled(false);
        BotonCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCifrarActionPerformed(evt);
            }
        });
        BotonCifrar.setBounds(110, 10, 100, 110);
        jLayeredPane1.add(BotonCifrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        CifrarLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CifrarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CifrarLabel.setText("CIFRAR");
        CifrarLabel.setBounds(240, 10, 92, 110);
        jLayeredPane1.add(CifrarLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        BotonDescifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/unlock3.png"))); // NOI18N
        BotonDescifrar.setBorder(null);
        BotonDescifrar.setContentAreaFilled(false);
        BotonDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDescifrarActionPerformed(evt);
            }
        });
        BotonDescifrar.setBounds(110, 130, 100, 132);
        jLayeredPane1.add(BotonDescifrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        DescifrarLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
        DescifrarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DescifrarLabel.setText("DESCIFRAR");
        DescifrarLabel.setBounds(240, 130, 140, 132);
        jLayeredPane1.add(DescifrarLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        BotonAtaques.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ataques.png"))); // NOI18N
        BotonAtaques.setBorder(null);
        BotonAtaques.setContentAreaFilled(false);
        BotonAtaques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAtaquesActionPerformed(evt);
            }
        });
        BotonAtaques.setBounds(110, 270, 100, 123);
        jLayeredPane1.add(BotonAtaques, javax.swing.JLayeredPane.DEFAULT_LAYER);

        AtaquesLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        AtaquesLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AtaquesLabel.setText("SIMULAR ATAQUES");
        AtaquesLabel.setBounds(240, 270, 282, 123);
        jLayeredPane1.add(AtaquesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        BotonHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/herramientas.png"))); // NOI18N
        BotonHerramientas.setBorder(null);
        BotonHerramientas.setBorderPainted(false);
        BotonHerramientas.setContentAreaFilled(false);
        BotonHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonHerramientasActionPerformed(evt);
            }
        });
        BotonHerramientas.setBounds(110, 400, 100, 128);
        jLayeredPane1.add(BotonHerramientas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        HerramientasLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        HerramientasLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HerramientasLabel.setText("HERRAMIENTAS");
        HerramientasLabel.setBounds(240, 450, 195, 29);
        jLayeredPane1.add(HerramientasLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addComponent(BotonInfo)
                .addContainerGap())
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void BotonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonInfoActionPerformed

    public void wclosed (javax.swing.JFrame hijo){
        if (hijo.equals(cifrarUIhijo)) {
            cifrarUIhijo.dispose();
            cifrarUIhijo = null;
        }
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
    private javax.swing.JPanel MainPanel;
    private javax.swing.JScrollPane MainScrollPane;
    private javax.swing.JLayeredPane jLayeredPane1;
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
