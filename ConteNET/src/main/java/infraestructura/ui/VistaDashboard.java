/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package infraestructura.ui;

import aplicacion.ContenedorService;
import dominio.Contenedor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class VistaDashboard extends javax.swing.JPanel {
    
    private Timer timerRefresco;
    public Runnable onAbrirRegistroSolicitado; 
    private final ContenedorService service;
    
    public VistaDashboard(ContenedorService service) {
        this.service = service;
        initComponents();
        ConfigurarControlesInicial();
        CargarDatosDashboard();
        
        // Timer que refresca los datos cada 5 segundos
        timerRefresco = new Timer(5000, (java.awt.event.ActionEvent e) -> { 
            CargarDatosDashboard(); 
        });
        timerRefresco.start();
    }
    
    private void ConfigurarControlesInicial() {
        panelGrafico.setLayout(new BorderLayout()); 
        panelGMap.setBackground(new Color(230, 230, 230));
        panelGMap.setLayout(new BorderLayout());
        
        javax.swing.JLabel lblMapa = new javax.swing.JLabel("El mapa se cargará aquí", javax.swing.SwingConstants.CENTER);
        panelGMap.add(lblMapa, BorderLayout.CENTER);
        
        DefaultTableModel modelo = new DefaultTableModel(new Object [][] {}, new String [] {"ID", "Nombre", "Estado", "Dirección"}) {
            boolean[] canEdit = new boolean [] {false, false, false, false};
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit [columnIndex]; }
        };
        tablaContenedores.setModel(modelo);
    }
    
    public void CargarDatosDashboard() {
        List<Contenedor> lista = service.obtenerTodos();
        DefaultTableModel modelo = (DefaultTableModel) tablaContenedores.getModel();
        modelo.setRowCount(0); 
        
        for (Contenedor c : lista) { 
            modelo.addRow(new Object[]{c.getIdContenedor(), c.getDescripcion(), c.getEstadoOperativo(), c.getDireccion()}); 
        }
        ActualizarDatosGrafico(lista);
    }
    
    private void ActualizarDatosGrafico(List<Contenedor> lista) {
        if (lista == null || lista.isEmpty()) return;
        int contLleno = 0, contUtil = 0, contMitad = 0;
        
        for (Contenedor c : lista) {
            String estado = c.getEstadoOperativo(); 
            if (estado.equalsIgnoreCase("LLENO")) contLleno++; 
            else if (estado.equalsIgnoreCase("UTIL")) contUtil++; 
            else if (estado.equalsIgnoreCase("MITAD")) contMitad++;
        }
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(contUtil, "Estados", "Util"); 
        dataset.addValue(contMitad, "Estados", "Mitad"); 
        dataset.addValue(contLleno, "Estados", "Lleno");
        
        JFreeChart chart = ChartFactory.createBarChart("CONTENEDORES POR ESTADO", "", "Cantidad", dataset);
        CategoryPlot plot = chart.getCategoryPlot();
        
        BarRenderer customRenderer = new BarRenderer() {
            @Override
            public java.awt.Paint getItemPaint(int row, int column) {
                String categoria = (String) dataset.getColumnKey(column);
                if (categoria.equals("Lleno")) return new Color(220, 53, 69); 
                if (categoria.equals("Util")) return new Color(40, 167, 69); 
                if (categoria.equals("Mitad")) return new Color(255, 193, 7); 
                return super.getItemPaint(row, column);
            }
        };
        plot.setRenderer(customRenderer);
        
        panelGrafico.removeAll();
        panelGrafico.add(new ChartPanel(chart), BorderLayout.CENTER);
        panelGrafico.validate();
    }
    
    @Override
    public void removeNotify() {
        super.removeNotify();
        if (timerRefresco != null) {
            timerRefresco.stop();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGMap = new javax.swing.JPanel();
        panelGrafico = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaContenedores = new javax.swing.JTable();

        javax.swing.GroupLayout panelGMapLayout = new javax.swing.GroupLayout(panelGMap);
        panelGMap.setLayout(panelGMapLayout);
        panelGMapLayout.setHorizontalGroup(
            panelGMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );
        panelGMapLayout.setVerticalGroup(
            panelGMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tablaContenedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaContenedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelGMap;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JTable tablaContenedores;
    // End of variables declaration//GEN-END:variables
}
