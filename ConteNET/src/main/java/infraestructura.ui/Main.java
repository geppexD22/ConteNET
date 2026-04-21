/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PRESENTACIÓN;

import javax.swing.JPanel;
import java.awt.BorderLayout;
/**
 *
 * @author Raul
 */
public class Main extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());
    
    private int nivelPermisoUsuarioActual;
    private String nombreUsuarioActual;
    private boolean sesionTrabajadorActiva = false;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null); 
        
        // Sesión de invitado por defecto
        this.nivelPermisoUsuarioActual = 1; 
        this.nombreUsuarioActual = "Invitado";
        
        configurarBotones();
        MostrarDashboard();
    }
    
    public Main(int nivelPermiso, String nombreUsuario) {
        initComponents();
        this.setLocationRelativeTo(null); 
        
        this.nivelPermisoUsuarioActual = nivelPermiso;
        this.nombreUsuarioActual = nombreUsuario;
        
        // Si el nivel es 2 (definido en nuestro repo), es un trabajador
        if (nivelPermiso == 2) {
            this.sesionTrabajadorActiva = true;
        }

        configurarBotones();
        MostrarDashboard();
        
        // Opcional: Cambiar el título de la ventana según el usuario
        this.setTitle("Sistema Tacna Limpia - Usuario: " + nombreUsuarioActual);
    }
    
    private void configurarBotones() {
        btnCambiarEstado.addActionListener(evt -> AbrirFormularioHijo(new VistaDashboard()));
        btnEstadistica.addActionListener(evt -> AbrirFormularioHijo(new VistaEstadistica()));
        btnAgregarTrabajador.addActionListener(evt -> MostrarRegistroTrabajador());
        btnRutaTrabajador.addActionListener(evt -> {
            if (sesionTrabajadorActiva || nivelPermisoUsuarioActual == 0) {
                AbrirFormularioHijo(new VistaTrabajador());
            } else {
                pedirLoginTrabajador();
            }
        });
    }
    
    private void AbrirFormularioHijo(JPanel panelHijo) {
        try {
            panelContenedor.removeAll();
            panelContenedor.setLayout(new BorderLayout());
            panelContenedor.add(panelHijo, BorderLayout.CENTER);
            panelContenedor.revalidate();
            panelContenedor.repaint();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar el panel: " + e.getMessage());
        }
    }
    
    private void MostrarDashboard() {
        AbrirFormularioHijo(new VistaDashboard());
    }
    
    private void MostrarRegistroTrabajador() {
        if (nivelPermisoUsuarioActual == 0) { // 0 = Administrador en la BD
            AbrirFormularioHijo(new VistaAgregarTrabajador());
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Acceso Denegado: Se requieren permisos de Administrador.", 
                "Seguridad", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void pedirLoginTrabajador() {
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this, 
            "Para acceder a rutas debe validar su cuenta de Trabajador.\n¿Desea ir al Login?", 
            "Validación Requerida", javax.swing.JOptionPane.YES_NO_OPTION);
            
        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.esModoTrabajador = true;
            login.setVisible(true);
            this.dispose();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCambiarEstado = new javax.swing.JButton();
        btnRutaTrabajador = new javax.swing.JButton();
        btnEstadistica = new javax.swing.JButton();
        btnAgregarTrabajador = new javax.swing.JButton();
        panelContenedor = new javax.swing.JPanel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(910, 478));

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestor de Contenedores");

        jLabel2.setMinimumSize(new java.awt.Dimension(684, 365));

        btnCambiarEstado.setText("HOME");

        btnRutaTrabajador.setText("Rutas");

        btnEstadistica.setText("Estadisticas");

        btnAgregarTrabajador.setText("AGREGAR TRABAJADOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarTrabajador)
                    .addComponent(btnEstadistica)
                    .addComponent(btnRutaTrabajador)
                    .addComponent(btnCambiarEstado))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(119, 119, 119)
                .addComponent(btnCambiarEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRutaTrabajador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstadistica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarTrabajador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarTrabajador;
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnEstadistica;
    private javax.swing.JButton btnRutaTrabajador;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
