/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

/**
 * Clase que representa la ventana para ver coberturas en la aplicación.
 * Permite al usuario iniciar búsquedas utilizando algoritmos BFS y DFS,
 * así como regresar al menú principal.
 * 
 * @author salom
 */
public class VerCobertura extends javax.swing.JFrame {

    /**
     * Crea una nueva instancia de VerCobertura.
     */
    public VerCobertura() {
        initComponents();
    }

    /**
     * Este método es llamado desde el constructor para inicializar el formulario.
     * WARNING: No modificar este código. Este método se regenera automáticamente.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BFS = new javax.swing.JLabel();
        DFS = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Menu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BFS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BFS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BFSMouseClicked(evt);
            }
        });
        getContentPane().add(BFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 380, 130));

        DFS.setText("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ");
        DFS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DFS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DFSMouseClicked(evt);
            }
        });
        getContentPane().add(DFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 380, 130));

        jPanel2.setBackground(new java.awt.Color(102, 0, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Menu.setForeground(new java.awt.Color(255, 255, 255));
        Menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menu.setText("MENÚ");
        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMouseClicked(evt);
            }
        });
        jPanel2.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 360, 60));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VER COBERTURAS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 16, 350, 40));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Busqueda.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Método que se ejecuta al hacer clic en el botón para iniciar BFS.
     * Abre la ventana de cobertura BFS y cierra la ventana actual.
     * @param evt el evento del mouse.
     */
    private void BFSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BFSMouseClicked
        CoberturaBFS bfs = new CoberturaBFS(); // Crea una instancia de la ventana de cobertura BFS.
        bfs.setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        bfs.setResizable(false); // Evita que la ventana sea redimensionable.
        this.dispose(); // Cierra la ventana actual.
        bfs.setVisible(true); // Muestra la ventana de cobertura BFS.
    }//GEN-LAST:event_BFSMouseClicked
    
    /**
     * Método que se ejecuta al hacer clic en el botón para iniciar DFS.
     * Abre la ventana de cobertura DFS y cierra la ventana actual.
     * @param evt el evento del mouse.
     */
    private void DFSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DFSMouseClicked
        CoberturaDFS dfs = new CoberturaDFS(); // Crea una instancia de la ventana de cobertura DFS.
        dfs.setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        dfs.setResizable(false); // Evita que la ventana sea redimensionable.
        this.dispose(); // Cierra la ventana actual.
        dfs.setVisible(true); // Muestra la ventana de cobertura DFS.
    }//GEN-LAST:event_DFSMouseClicked
    /**
     * Método que se ejecuta al hacer clic en el botón del menú.
     * Abre la ventana del menú y cierra la ventana actual.
     * @param evt el evento del mouse.
     */
    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked
        Menu v2 = new Menu(); // Crea una instancia de la ventana del menú.
        v2.setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        v2.setResizable(false); // Evita que la ventana sea redimensionable.
        v2.setVisible(true); // Muestra la ventana del menú.
        this.dispose(); // Cierra la ventana actual.
    }//GEN-LAST:event_MenuMouseClicked

    /**
     * Método principal para ejecutar la aplicación.
     * @param args los argumentos de línea de comandos.
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerCobertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerCobertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerCobertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerCobertura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerCobertura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BFS;
    private javax.swing.JLabel DFS;
    private javax.swing.JLabel Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
