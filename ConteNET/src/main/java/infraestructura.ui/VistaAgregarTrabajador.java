/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PRESENTACIÓN;

/**
 *
 * @author Raul
 */
import javax.swing.table.DefaultTableModel;

public class VistaAgregarTrabajador extends javax.swing.JPanel {

    public Runnable onSolicitudVolver;
    // private LinqService _service;
    
    public VistaAgregarTrabajador() {
        initComponents();
        // Configuración inicial
        ConfigurarTurnos();
        CargarTablaTrabajadores();
        
        // --- CONECTAR EVENTOS MANUALMENTE ---
        // Esto evita que NetBeans borre tus eventos al editar el diseño
        btnGuardar.addActionListener(evt -> btnGuardarActionPerformed(evt));
        btnCancelar.addActionListener(evt -> btnCancelarActionPerformed(evt));
        
        // Evento para validar que el DNI solo acepte números (Equivalente al KeyPress de C#)
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });
        
        // Evento para los clics dentro de la tabla (Equivalente a CellContentClick)
        dgvTrabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvTrabajadoresMouseClicked(evt);
            }
        });
    }
    
    private void ConfigurarTurnos() {
        cmbTurno.removeAllItems();
        cmbTurno.addItem("Mañana");
        cmbTurno.addItem("Tarde");
        cmbTurno.addItem("Noche");
        cmbTurno.setSelectedIndex(-1); // Dejarlo sin seleccionar por defecto
    }
    
    private void LimpiarCampos() {
        txtDNI.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtCargo.setText("");
        cmbTurno.setSelectedIndex(-1);
    }
    
    // Método para bloquear letras en el DNI
    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        // Si no es un dígito y no es la tecla de borrar, ignoramos la tecla
        if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
            evt.consume(); 
        }
    }
    
    private void CargarTablaTrabajadores() {
        // En Java, la tabla usa un "Modelo" para definir sus columnas y datos.
        // Aquí creamos una simulación para que se vea el CheckBox de Estado igual que en C#.
        
        DefaultTableModel modelo = new DefaultTableModel(
            new Object [][] {
                // DATOS DE PRUEBA: ID, DNI, Nombres, Apellidos, Cargo, Turno, Estado(Boolean crea un CheckBox)
                {1, "72345678", "Juan", "Perez", "Conductor", "Mañana", true},
                {2, "78654321", "Maria", "Gomez", "Recolector", "Tarde", false}
            },
            new String [] {
                "Id", "DNI", "Nombres", "Apellidos", "Cargo", "Turno", "Estado"
            }
        ) {
            // Le decimos a Java qué tipo de dato es cada columna. 
            // El 'Boolean.class' en la última columna hará que dibuje un cuadradito de CheckBox automáticamente.
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            
            // Hacemos que solo el Checkbox se pueda clicar/editar
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true 
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };

        dgvTrabajadores.setModel(modelo);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbTurno = new javax.swing.JComboBox<>();
        txtDNI = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvTrabajadores = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("REGISTRAR NUEVO TRABAJADOR ");

        jLabel2.setText("Nombre :");

        jLabel3.setText("DNI :");

        jLabel4.setText("Apellidos :");

        jLabel5.setText("Cargo :");

        jLabel6.setText("Turno :");

        cmbTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        dgvTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dgvTrabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvTrabajadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dgvTrabajadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(345, 345, 345))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCargo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtApellidos)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // 1. Validaciones
        if (txtDNI.getText().trim().isEmpty() || 
            txtNombre.getText().trim().isEmpty() || 
            txtApellidos.getText().trim().isEmpty() || 
            cmbTurno.getSelectedIndex() == -1) {
            
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios.", "Faltan Datos", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 2. Aquí iría el Guardado en BD: _service.RegistrarTrabajador(...)
            String dni = txtDNI.getText().trim();
            String nombres = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            
            // 3. Feedback y generación de usuario simulada
            String usuarioGenerado = (nombres.substring(0, 1) + apellidos).toLowerCase().replace(" ", "");

            javax.swing.JOptionPane.showMessageDialog(this, 
                "¡Trabajador registrado!\n\nUsuario: " + usuarioGenerado + "\nContraseña: " + dni, 
                "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            CargarTablaTrabajadores();
            LimpiarCampos();

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al registrar: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (onSolicitudVolver != null) {
            onSolicitudVolver.run();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void dgvTrabajadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvTrabajadoresMouseClicked
        // Detectamos en qué fila y columna se hizo clic
        int col = dgvTrabajadores.columnAtPoint(evt.getPoint());
        int row = dgvTrabajadores.rowAtPoint(evt.getPoint());

        if (row < 0 || col < 0) return;

        // Obtenemos el nombre de la columna (en tu C# buscabas "Estado")
        String columnName = dgvTrabajadores.getColumnName(col);

        if (columnName.equals("Estado")) {
            
            // Obtenemos el valor que tiene actualmente el checkbox y el ID del trabajador
            boolean nuevoEstado = (boolean) dgvTrabajadores.getValueAt(row, col);
            int idTrabajador = (int) dgvTrabajadores.getValueAt(row, 0); // Asumimos que ID es la col 0

            String textoEstado = nuevoEstado ? "ACTIVO" : "INACTIVO";

            int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de cambiar el estado del trabajador a " + textoEstado + "?",
                "Confirmar Cambio",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE
            );

            if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
                try {
                    // _service.ActualizarEstadoTrabajador(idTrabajador, nuevoEstado);
                    javax.swing.JOptionPane.showMessageDialog(this, "Estado actualizado correctamente.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    
                    // En la vida real aquí recargarías de la BD. 
                    // CargarTablaTrabajadores(); 
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar: " + ex.getMessage());
                    CargarTablaTrabajadores(); // Revertimos si hay error
                }
            } else {
                // Si dice que NO, recargamos la tabla para deshacer el clic visual que hizo el usuario
                CargarTablaTrabajadores();
            }
        }
    }//GEN-LAST:event_dgvTrabajadoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbTurno;
    private javax.swing.JTable dgvTrabajadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
