/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Funciones.Validaciones;
import static Interfaces.CargarRed.t;
import javax.swing.JOptionPane;
/**
 * Clase que representa la ventana para iniciar el valor de T.
 * Permite al usuario ingresar un valor deseado y lo guarda tras validación.
 * 
 * @author salom
 */
public class IniciarT extends javax.swing.JFrame {

    /**
     * Crea una nueva instancia de la clase IniciarT.
     */
    public IniciarT() {
        initComponents();
    }

    
    /**
     * Este método es llamado desde el constructor para inicializar el formulario.
     * ADVERTENCIA: No modifique este código. El contenido de este método es
     * regenerado por el Editor de Formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tDeseado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        guardarT = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Menu = new javax.swing.JLabel();
        verT = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INICIAR T");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 170, -1));

        tDeseado.setBackground(new java.awt.Color(255, 255, 255));
        tDeseado.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(tDeseado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 360, 40));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingrese el valor de T deseado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 290, -1));

        jPanel2.setBackground(new java.awt.Color(102, 0, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 255), new java.awt.Color(204, 0, 255), new java.awt.Color(51, 0, 102), new java.awt.Color(51, 0, 102)));
        jPanel2.setForeground(new java.awt.Color(102, 0, 153));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guardarT.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        guardarT.setForeground(new java.awt.Color(255, 255, 255));
        guardarT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardarT.setText("GUARDAR T");
        guardarT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardarT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarTMouseClicked(evt);
            }
        });
        jPanel2.add(guardarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 270, -1));

        jPanel3.setBackground(new java.awt.Color(102, 0, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 255), new java.awt.Color(204, 0, 255), new java.awt.Color(51, 0, 102), new java.awt.Color(51, 0, 102)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 3, 330, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 330, 50));

        verT.setEditable(false);
        verT.setBackground(new java.awt.Color(204, 195, 217));
        verT.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        verT.setForeground(new java.awt.Color(0, 0, 0));
        verT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(verT, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 130, 90, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Maneja el evento de clic en el botón "GUARDAR T".
     * Valida la entrada del usuario y actualiza el valor de T.
     * @param evt el evento del mouse que activó el método
     */
    private void guardarTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarTMouseClicked
        String tStr = tDeseado.getText();
        Validaciones val = new Validaciones();
        
        // Valida la entrada del usuario
        if(val.validarEntrada(tStr) != -1){
            t = Integer.parseInt(tStr); // Actualiza el valor de T
            JOptionPane.showMessageDialog(null, "T ha sido actualizado a: " + tStr);
            verT.setText(tStr); // Muestra el nuevo valor de T
            tDeseado.setText(""); // Limpia el campo de entrada

        }else{
            // Muestra un mensaje de error si la entrada no es válida
            JOptionPane.showMessageDialog(null, "El valor ingresado no es válido. "
                    + "Por favor intente nuevamente.");
        }
    }//GEN-LAST:event_guardarTMouseClicked

    /**
     * Maneja el evento de clic en el botón "MENÚ".
     * Abre la ventana del menú y cierra la ventana actual.
     * 
     * @param evt el evento del mouse que activó el método
     */
    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked
        Menu v2 = new Menu(); // Crea una nueva instancia de la ventana del menú
        v2.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        v2.setResizable(false); // Evita que la ventana se pueda redimensionar
        v2.setVisible(true); // Muestra la ventana del menú
        this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_MenuMouseClicked

    /**
     * Método principal para ejecutar la aplicación.
     * 
     * @param args los argumentos de línea de comandos
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
            java.util.logging.Logger.getLogger(IniciarT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Menu;
    private javax.swing.JLabel guardarT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tDeseado;
    private javax.swing.JTextField verT;
    // End of variables declaration//GEN-END:variables
}
