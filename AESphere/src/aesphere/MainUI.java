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
        cifrarScrollPaneMain = new javax.swing.JScrollPane();
        PanelMain = new javax.swing.JPanel();
        BotonCifrar = new javax.swing.JButton();
        BotonDescifrar = new javax.swing.JButton();
        BotonAtaques = new javax.swing.JButton();
        BotonInfo = new javax.swing.JButton();
        mainMenuBar = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        mainMenuEditar = new javax.swing.JMenu();
        mainMenuOperaciones = new javax.swing.JMenu();
        mainMenuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cifrarScrollPaneMain.setBorder(null);

        PanelMain.setPreferredSize(new java.awt.Dimension(788, 566));

        BotonCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lock2.png"))); // NOI18N
        BotonCifrar.setBorder(null);

        BotonDescifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/unlock3.png"))); // NOI18N
        BotonDescifrar.setBorder(null);

        BotonAtaques.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ataques.png"))); // NOI18N
        BotonAtaques.setBorder(null);

        BotonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N
        BotonInfo.setBorder(null);

        javax.swing.GroupLayout PanelMainLayout = new javax.swing.GroupLayout(PanelMain);
        PanelMain.setLayout(PanelMainLayout);
        PanelMainLayout.setHorizontalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonAtaques)
                    .addComponent(BotonDescifrar)
                    .addComponent(BotonCifrar))
                .addContainerGap(583, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMainLayout.createSequentialGroup()
                .addContainerGap(775, Short.MAX_VALUE)
                .addComponent(BotonInfo)
                .addGap(20, 20, 20))
        );
        PanelMainLayout.setVerticalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(BotonCifrar)
                .addGap(59, 59, 59)
                .addComponent(BotonDescifrar)
                .addGap(50, 50, 50)
                .addComponent(BotonAtaques)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(BotonInfo)
                .addGap(17, 17, 17))
        );

        cifrarScrollPaneMain.setViewportView(PanelMain);

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
            .addComponent(cifrarScrollPaneMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cifrarScrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JButton BotonAtaques;
    private javax.swing.JButton BotonCifrar;
    private javax.swing.JButton BotonDescifrar;
    private javax.swing.JButton BotonInfo;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JScrollPane cifrarScrollPaneMain;
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