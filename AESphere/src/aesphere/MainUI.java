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
        cifrarPanelMain = new javax.swing.JPanel();
        cifrarPanelInput = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cifrarPanelAdvOptions = new javax.swing.JPanel();
        cifrarPanelOutput = new javax.swing.JPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        mainMenuArchivo = new javax.swing.JMenu();
        mainMenuEditar = new javax.swing.JMenu();
        mainMenuOperaciones = new javax.swing.JMenu();
        mainMenuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cifrarScrollPaneMain.setBorder(null);

        cifrarPanelMain.setPreferredSize(new java.awt.Dimension(788, 566));

        cifrarPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " INPUT ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        javax.swing.GroupLayout cifrarPanelInputLayout = new javax.swing.GroupLayout(cifrarPanelInput);
        cifrarPanelInput.setLayout(cifrarPanelInputLayout);
        cifrarPanelInputLayout.setHorizontalGroup(
            cifrarPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelInputLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(594, Short.MAX_VALUE))
        );
        cifrarPanelInputLayout.setVerticalGroup(
            cifrarPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelInputLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        cifrarPanelAdvOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " ADVANCED OPTIONS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        javax.swing.GroupLayout cifrarPanelAdvOptionsLayout = new javax.swing.GroupLayout(cifrarPanelAdvOptions);
        cifrarPanelAdvOptions.setLayout(cifrarPanelAdvOptionsLayout);
        cifrarPanelAdvOptionsLayout.setHorizontalGroup(
            cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        cifrarPanelAdvOptionsLayout.setVerticalGroup(
            cifrarPanelAdvOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        cifrarPanelOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " OUTPUT ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        javax.swing.GroupLayout cifrarPanelOutputLayout = new javax.swing.GroupLayout(cifrarPanelOutput);
        cifrarPanelOutput.setLayout(cifrarPanelOutputLayout);
        cifrarPanelOutputLayout.setHorizontalGroup(
            cifrarPanelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        cifrarPanelOutputLayout.setVerticalGroup(
            cifrarPanelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cifrarPanelMainLayout = new javax.swing.GroupLayout(cifrarPanelMain);
        cifrarPanelMain.setLayout(cifrarPanelMainLayout);
        cifrarPanelMainLayout.setHorizontalGroup(
            cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cifrarPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cifrarPanelInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cifrarPanelAdvOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cifrarPanelOutput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        cifrarPanelMainLayout.setVerticalGroup(
            cifrarPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cifrarPanelMainLayout.createSequentialGroup()
                .addComponent(cifrarPanelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cifrarPanelOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cifrarPanelAdvOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cifrarScrollPaneMain.setViewportView(cifrarPanelMain);

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
    private javax.swing.JPanel cifrarPanelAdvOptions;
    private javax.swing.JPanel cifrarPanelInput;
    private javax.swing.JPanel cifrarPanelMain;
    private javax.swing.JPanel cifrarPanelOutput;
    private javax.swing.JScrollPane cifrarScrollPaneMain;
    private javax.swing.JLabel jLabel1;
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

class LanguageChekBoxMenuItem extends javax.swing.JCheckBoxMenuItem {

}