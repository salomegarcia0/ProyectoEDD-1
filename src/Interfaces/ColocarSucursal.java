/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.ListaSimple;
//import Funciones.Funciones;
import static Interfaces.CargarRed.grafoApp;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author salom
 */
public class ColocarSucursal extends javax.swing.JFrame {
    DefaultComboBoxModel estacionesSinSucursal = new DefaultComboBoxModel();
    DefaultComboBoxModel estacionesConSucursal = new DefaultComboBoxModel();
    //Funciones fun = new Funciones();
    /**
     * Creates new form ColocarSucursal
     */
    public ColocarSucursal() {
        initComponents();
    }
    
    public void actualizarCombo(){
        estacionesSinSucursal.removeAllElements();
        estacionesConSucursal.removeAllElements();
        
        
        
        /**if(!fun.listarEstacionesConSucursal(grafoApp).isEmpty()){
            ListaSimple nombres = fun.listarEstacionesSinSucursal(grafoApp);
            for (int i = 0; i < nombres.getSize(); i++) {
                estacionesSinSucursal.addElement(nombres.getValor(i));
            }
        }*/
        
        /**if(!fun.listarEstacionesConSucursal(grafoApp).isEmpty()){
            ListaSimple nombres = fun.listarEstacionesConSucursal(grafoApp);
            for (int i = 0; i < nombres.getSize(); i++) {
                estacionesConSucursal.addElement(nombres.getValor(i));
            }
        }*/
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sinSucursal = new javax.swing.JComboBox<>();
        haySucursal = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        guardarSucursal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        eliminarSucursal = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Menu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("COLOCAR SUCURSAL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 320, 40));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Agregar Sucursal:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 170, 30));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Eliminar Sucursal:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 170, 30));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Seleccione una estación:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 210, 20));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Seleccione una estación:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 210, 20));

        sinSucursal.setBackground(new java.awt.Color(255, 255, 255));
        sinSucursal.setModel(estacionesSinSucursal);
        getContentPane().add(sinSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 290, -1));

        haySucursal.setBackground(new java.awt.Color(255, 255, 255));
        haySucursal.setModel(estacionesConSucursal);
        getContentPane().add(haySucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 290, -1));

        jPanel2.setBackground(new java.awt.Color(102, 0, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 255), new java.awt.Color(204, 0, 255), new java.awt.Color(51, 0, 102), new java.awt.Color(51, 0, 102)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guardarSucursal.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        guardarSucursal.setForeground(new java.awt.Color(255, 255, 255));
        guardarSucursal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardarSucursal.setText("AGREGAR");
        guardarSucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardarSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarSucursalMouseClicked(evt);
            }
        });
        jPanel2.add(guardarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 150, 30));

        jPanel3.setBackground(new java.awt.Color(102, 0, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 255), new java.awt.Color(204, 0, 255), new java.awt.Color(51, 0, 102), new java.awt.Color(51, 0, 102)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eliminarSucursal.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        eliminarSucursal.setForeground(new java.awt.Color(255, 255, 255));
        eliminarSucursal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eliminarSucursal.setText("ELIMINAR");
        eliminarSucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarSucursalMouseClicked(evt);
            }
        });
        jPanel3.add(eliminarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 150, 30));

        jPanel4.setBackground(new java.awt.Color(102, 0, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 255), new java.awt.Color(204, 0, 255), new java.awt.Color(51, 0, 102), new java.awt.Color(51, 0, 102)));
        jPanel4.setForeground(new java.awt.Color(102, 0, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Menu.setForeground(new java.awt.Color(255, 255, 255));
        Menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menu.setText("Menu");
        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMouseClicked(evt);
            }
        });
        jPanel4.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 210, 40));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked
        Menu v2 = new Menu();
        v2.setLocationRelativeTo(null);
        v2.setResizable(false);
        v2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuMouseClicked

    private void guardarSucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarSucursalMouseClicked
        String nombre = String.valueOf(sinSucursal.getSelectedItem());
        //fun.agregarSucursal(nombre, grafoApp);
        this.actualizarCombo();
    }//GEN-LAST:event_guardarSucursalMouseClicked

    private void eliminarSucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarSucursalMouseClicked
        String nombre = String.valueOf(haySucursal.getSelectedItem());
        //fun.eliminarSucursal(nombre, grafoApp);
        this.actualizarCombo();
    }//GEN-LAST:event_eliminarSucursalMouseClicked

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColocarSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColocarSucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Menu;
    private javax.swing.JLabel eliminarSucursal;
    private javax.swing.JLabel guardarSucursal;
    private javax.swing.JComboBox<String> haySucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> sinSucursal;
    // End of variables declaration//GEN-END:variables
}
