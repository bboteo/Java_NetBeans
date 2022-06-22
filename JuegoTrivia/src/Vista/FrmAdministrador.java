package Vista;

import javax.swing.table.DefaultTableModel;

public class FrmAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form FrmAdministrador
     */
    public FrmAdministrador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jopAdminMensaje = new javax.swing.JOptionPane();
        lblAdminUsuario = new javax.swing.JLabel();
        jcbAdminLista = new javax.swing.JComboBox<>();
        txbAdminUsuario = new javax.swing.JTextField();
        lblAdminContrasena = new javax.swing.JLabel();
        txbAdminContrasena = new javax.swing.JTextField();
        lblAdminNombre = new javax.swing.JLabel();
        txbAdminNombre = new javax.swing.JTextField();
        lblAdminApellido = new javax.swing.JLabel();
        txbAdminApellido = new javax.swing.JTextField();
        lblAdminEdad = new javax.swing.JLabel();
        txbAdminEdad = new javax.swing.JTextField();
        lblAdminAccion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdminReporte = new javax.swing.JButton();
        btnAdminGuardar = new javax.swing.JButton();
        jpnAdminActualizar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultTableModel dtm = new DefaultTableModel();
        tblAdminMostrar = new javax.swing.JTable();
        jlbAdminModificar = new javax.swing.JLabel();
        jpnAdminAvanzado = new javax.swing.JPanel();
        jcbAdminEstado = new javax.swing.JComboBox<>();
        jcbAdminTipoJugador = new javax.swing.JComboBox<>();
        jlbAdminEstado = new javax.swing.JLabel();
        jlbAdminTipoJugador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal - Administrador");

        lblAdminUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAdminUsuario.setText("Usuario");

        jcbAdminLista.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbAdminLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAdminListaActionPerformed(evt);
            }
        });

        txbAdminUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblAdminContrasena.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAdminContrasena.setText("Contrasena");

        txbAdminContrasena.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblAdminNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAdminNombre.setText("Nombre");

        txbAdminNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblAdminApellido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAdminApellido.setText("Apellido");

        txbAdminApellido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblAdminEdad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAdminEdad.setText("Edad");

        txbAdminEdad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblAdminAccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAdminAccion.setText("Tarea");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnAdminReporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdminReporte.setText("Generar Reporte");

        btnAdminGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdminGuardar.setText("Cambia segun la Accion");

        tblAdminMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblAdminMostrar);

        jlbAdminModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlbAdminModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbAdminModificar.setText("Instrucciones para Actualizar y Modificar");

        javax.swing.GroupLayout jpnAdminActualizarLayout = new javax.swing.GroupLayout(jpnAdminActualizar);
        jpnAdminActualizar.setLayout(jpnAdminActualizarLayout);
        jpnAdminActualizarLayout.setHorizontalGroup(
            jpnAdminActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAdminActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jpnAdminActualizarLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jlbAdminModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnAdminActualizarLayout.setVerticalGroup(
            jpnAdminActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAdminActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbAdminModificar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jpnAdminAvanzado.setBackground(new java.awt.Color(204, 204, 255));

        jcbAdminEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jcbAdminTipoJugador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jlbAdminEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlbAdminEstado.setText("Estado");

        jlbAdminTipoJugador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlbAdminTipoJugador.setText("Tipo Usuario");

        javax.swing.GroupLayout jpnAdminAvanzadoLayout = new javax.swing.GroupLayout(jpnAdminAvanzado);
        jpnAdminAvanzado.setLayout(jpnAdminAvanzadoLayout);
        jpnAdminAvanzadoLayout.setHorizontalGroup(
            jpnAdminAvanzadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAdminAvanzadoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jlbAdminEstado)
                .addGap(18, 18, 18)
                .addComponent(jcbAdminEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbAdminTipoJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbAdminTipoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnAdminAvanzadoLayout.setVerticalGroup(
            jpnAdminAvanzadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAdminAvanzadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnAdminAvanzadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAdminEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbAdminEstado)
                    .addComponent(jlbAdminTipoJugador)
                    .addComponent(jcbAdminTipoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jpnAdminActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAdminContrasena)
                                        .addGap(18, 18, 18)
                                        .addComponent(txbAdminContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAdminUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txbAdminUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAdminAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jcbAdminLista, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAdminApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txbAdminApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAdminNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txbAdminNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAdminEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txbAdminEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAdminGuardar)
                            .addGap(18, 18, 18)
                            .addComponent(btnAdminReporte)))
                    .addComponent(jpnAdminAvanzado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAdminNombre)
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txbAdminNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdminApellido)
                            .addComponent(txbAdminApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbAdminLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAdminAccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdminUsuario)
                            .addComponent(txbAdminUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdminContrasena)
                    .addComponent(lblAdminEdad)
                    .addComponent(txbAdminContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbAdminEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jpnAdminAvanzado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdminReporte)
                    .addComponent(btnAdminGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnAdminActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbAdminListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAdminListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAdminListaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdminGuardar;
    public javax.swing.JButton btnAdminReporte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox<String> jcbAdminEstado;
    public javax.swing.JComboBox<String> jcbAdminLista;
    public javax.swing.JComboBox<String> jcbAdminTipoJugador;
    public javax.swing.JLabel jlbAdminEstado;
    public javax.swing.JLabel jlbAdminModificar;
    public javax.swing.JLabel jlbAdminTipoJugador;
    public javax.swing.JOptionPane jopAdminMensaje;
    public javax.swing.JPanel jpnAdminActualizar;
    public javax.swing.JPanel jpnAdminAvanzado;
    private javax.swing.JLabel lblAdminAccion;
    private javax.swing.JLabel lblAdminApellido;
    private javax.swing.JLabel lblAdminContrasena;
    private javax.swing.JLabel lblAdminEdad;
    private javax.swing.JLabel lblAdminNombre;
    private javax.swing.JLabel lblAdminUsuario;
    public javax.swing.JTable tblAdminMostrar;
    public javax.swing.JTextField txbAdminApellido;
    public javax.swing.JTextField txbAdminContrasena;
    public javax.swing.JTextField txbAdminEdad;
    public javax.swing.JTextField txbAdminNombre;
    public javax.swing.JTextField txbAdminUsuario;
    // End of variables declaration//GEN-END:variables
}
