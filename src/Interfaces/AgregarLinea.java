/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.ListaSimple;
import static Interfaces.CargarRed.grafoApp;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author salom
 * Clase AgregarLinea que representa una ventana para agregar líneas al grafo de estaciones.
 * Esta ventana permite al usuario seleccionar estaciones de inicio y fin para una línea.
 */

public class AgregarLinea extends javax.swing.JFrame {
    // Modelos para ComboBoxes que contienen las estaciones de inicio y fin.
    DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
    DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
    
    /**
     * Constructor de la clase AgregarLinea.
     * Inicializa los componentes y actualiza las opciones de estaciones en los ComboBoxes.
     */
    public AgregarLinea() {
        initComponents();
        this.setResizable(false);  // Evita que el usuario pueda cambiar el tamaño de la ventana
        this.ActualizarComboBox(); // Llama a la función para llenar los ComboBoxes con estaciones
    }
    
    /**
     * Metodo para actualizar los comboBox cada vez que se modifique algo en el grafo
     */
    private void ActualizarComboBox(){
       this.NuevoBoxAdy1();// Actualiza el ComboBox para la estación inicial
       this.NuevoBoxAdy2();// Actualiza el ComboBox para la estación final
    }
    
    // Método para actualizar el modelo del primer combo box con las estaciones disponibles
    private void NuevoBoxAdy1() {
        // Limpia todos los elementos actuales del modelo
        modelo1.removeAllElements();
    
        // Obtiene la lista de estaciones desde el grafo de la aplicación
        ListaSimple estaciones = grafoApp.verEstaciones();
    
        // Verifica que la lista de estaciones no esté vacía o nula
        if (estaciones != null) {
            // Recorre cada estación en la lista de estaciones
            for (int i = 0; i < estaciones.getSize(); i++) {
                // Obtiene el nombre de la estación en la posición actual
                String nombreEstacion = (String) estaciones.getValor(i);
                // Agrega el nombre de la estación al modelo del combo box
                modelo1.addElement(nombreEstacion);
            }
        }
    }

    // Método para actualizar el modelo del segundo combo box con las estaciones disponibles
    private void NuevoBoxAdy2() {
        // Limpia todos los elementos actuales del modelo
        modelo2.removeAllElements();
    
        // Obtiene la lista de estaciones desde el grafo de la aplicación
        ListaSimple estaciones = grafoApp.verEstaciones();
    
        // Verifica que la lista de estaciones no esté vacía o nula
        if (estaciones != null) {
            // Recorre cada estación en la lista de estaciones
            for (int i = 0; i < estaciones.getSize(); i++) {
                // Obtiene el nombre de la estación en la posición actual
                String nombreEstacion = (String) estaciones.getValor(i);
                // Agrega el nombre de la estación al modelo del combo box
                modelo2.addElement(nombreEstacion);
            }
        }
    }
  /**
     * Este método es llamado dentro del constructor para inicializar los componentes gráficos.
     * ADVERTENCIA: No modifique este código. El contenido de este método es siempre
     * generado por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nuevaEstacion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        agregarEstacion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Menu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        agregarAdyacencia = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        primeraEstacion = new javax.swing.JComboBox<>();
        ultimaEstacion = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Escriba el nombre de la estación.");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 270, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AGREGAR LINEA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 350, 40));

        nuevaEstacion.setBackground(new java.awt.Color(255, 255, 255));
        nuevaEstacion.setForeground(new java.awt.Color(0, 0, 0));
        nuevaEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaEstacionActionPerformed(evt);
            }
        });
        getContentPane().add(nuevaEstacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 270, 30));

        jPanel2.setBackground(new java.awt.Color(102, 0, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 0, 204), new java.awt.Color(153, 0, 204), new java.awt.Color(51, 0, 102), new java.awt.Color(51, 0, 102)));
        jPanel2.setForeground(new java.awt.Color(102, 0, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarEstacion.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        agregarEstacion.setForeground(new java.awt.Color(255, 255, 255));
        agregarEstacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agregarEstacion.setText("AGREGAR");
        agregarEstacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarEstacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarEstacionMouseClicked(evt);
            }
        });
        jPanel2.add(agregarEstacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 130, 30));

        jPanel4.setBackground(new java.awt.Color(102, 0, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 255), new java.awt.Color(204, 0, 255), new java.awt.Color(51, 0, 102), new java.awt.Color(51, 0, 102)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        Menu.setForeground(new java.awt.Color(255, 255, 255));
        Menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menu.setText("MENU");
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMouseClicked(evt);
            }
        });
        jPanel4.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 240, 50));

        jPanel3.setBackground(new java.awt.Color(102, 0, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 255), new java.awt.Color(204, 0, 255), new java.awt.Color(51, 0, 102), new java.awt.Color(51, 0, 102)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarAdyacencia.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        agregarAdyacencia.setForeground(new java.awt.Color(255, 255, 255));
        agregarAdyacencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agregarAdyacencia.setText("AGREGAR");
        agregarAdyacencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarAdyacencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarAdyacenciaMouseClicked(evt);
            }
        });
        jPanel3.add(agregarAdyacencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 130, 50));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Seleccione las adyacencias.");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 270, -1));

        primeraEstacion.setModel(modelo1);
        getContentPane().add(primeraEstacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 270, 30));

        ultimaEstacion.setModel(modelo2);
        getContentPane().add(ultimaEstacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 270, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevaEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaEstacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevaEstacionActionPerformed
    // Método que maneja el evento de clic en el botón para abrir el menú principal
    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked
        // Crea una nueva instancia de la ventana del menú
        Menu v2 = new Menu();
        // Centra la ventana en la pantalla
        v2.setLocationRelativeTo(null);
        // Evita que la ventana pueda ser redimensionada
        v2.setResizable(false);
        // Hace visible la ventana del menú
        v2.setVisible(true);
        // Cierra la ventana actual
        this.dispose();
    }//GEN-LAST:event_MenuMouseClicked
    
    // Método que maneja el evento de clic para agregar una nueva estación
    private void agregarEstacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarEstacionMouseClicked
        // Verifica que el campo de texto no esté vacío
        if (!nuevaEstacion.getText().isEmpty()) {
            // Obtiene el nombre de la estación ingresado por el usuario
            String nombreEstacion = nuevaEstacion.getText();
            // Agrega la nueva estación al grafo
            grafoApp.StringAggEstacion(nombreEstacion);
            // Actualiza los elementos del combo box para reflejar la nueva estación
            this.ActualizarComboBox();
        } else {
            // Muestra un mensaje si no se ha ingresado el nombre de la estación
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre "
                + "de la estación que desea agregar");
        }
    }//GEN-LAST:event_agregarEstacionMouseClicked
    
    // Método que maneja el evento de clic para agregar una adyacencia entre estaciones
    private void agregarAdyacenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarAdyacenciaMouseClicked
        // Verifica que las estaciones seleccionadas no sean las mismas
        if (!primeraEstacion.getSelectedItem().equals(ultimaEstacion.getSelectedItem())) {
            // Obtiene los nombres de las estaciones seleccionadas en los combo boxes
            String nombreEstacion1 = (String) primeraEstacion.getSelectedItem();
            String nombreEstacion2 = (String) ultimaEstacion.getSelectedItem();
        
            // Agrega una conexión (adyacencia) entre las estaciones seleccionadas en el grafo
            grafoApp.agregarConexion(nombreEstacion1, nombreEstacion2);
            // Actualiza los elementos del combo box para reflejar los cambios en el grafo
            this.ActualizarComboBox();
        } else {
            // Muestra un mensaje si las estaciones seleccionadas son iguales
            JOptionPane.showMessageDialog(null, "No se puede "
                + "conectar una estación con ella misma, "
                + "por favor escoger estaciones distintas");
        }
    }//GEN-LAST:event_agregarAdyacenciaMouseClicked

    /**
     * @param args the command line arguments
     *//**
    * Método principal de la aplicación.
    * Configura la apariencia gráfica (Look and Feel) de la interfaz de usuario y
    * lanza la ventana principal para agregar una línea en la aplicación.
    *
    * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
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
            java.util.logging.Logger.getLogger(AgregarLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Crea y muestra la ventana principal de la aplicación */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Muestra la ventana para agregar una nueva línea en la aplicación
                new AgregarLinea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Menu;
    private javax.swing.JLabel agregarAdyacencia;
    private javax.swing.JLabel agregarEstacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nuevaEstacion;
    private javax.swing.JComboBox<String> primeraEstacion;
    private javax.swing.JComboBox<String> ultimaEstacion;
    // End of variables declaration//GEN-END:variables
   
}
