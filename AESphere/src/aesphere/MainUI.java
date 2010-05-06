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
        this.setExtendedState(MAXIMIZED_BOTH);
    }


    /** Sets all the titles of the interface elements */
    private void setLangLabels () {
        if (Entorno.lang.equals("ES")) {
            this.setTitle("AES - Ventana Principal");
        }
        else if (Entorno.lang.equals("EN")) {
            this.setTitle("AES - Main Window");
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

        main_menu_idiomas_popup = new javax.swing.JPopupMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AESphere 0.1 - Hola");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
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
    private javax.swing.JPopupMenu main_menu_idiomas_popup;
    // End of variables declaration//GEN-END:variables

}

class LanguageChekBoxMenuItem extends javax.swing.JCheckBoxMenuItem {

}