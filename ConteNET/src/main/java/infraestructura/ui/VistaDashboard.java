/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package infraestructura.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
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
    
    // Lista simulada de contenedores
    private List<String[]> listaContenedores = new ArrayList<>();
    
    public VistaDashboard() {
        initComponents();
        ConfigurarControlesInicial();
        CargarDatosDashboard();
        
        // Configurar Timer (Refresco cada 5 segundos para la prueba)
        timerRefresco = new Timer(5000, (java.awt.event.ActionEvent e) -> {
            // ActualizarDireccionesSiHaceFalta(); 
            // CargarDatosDashboard();
        });
        timerRefresco.start();
    }
    
    private void ConfigurarControlesInicial() {
        // 1. Configurar Gráfico
        panelGrafico.setLayout(new BorderLayout()); 
        
        // 2. Configurar Mapa (Por ahora le ponemos un color de fondo para distinguirlo)
        panelGMap.setBackground(new Color(230, 230, 230));
        panelGMap.setLayout(new BorderLayout());
        javax.swing.JLabel lblMapa = new javax.swing.JLabel("El mapa de C# (GMap.NET) se cargará aquí", javax.swing.SwingConstants.CENTER);
        panelGMap.add(lblMapa, BorderLayout.CENTER);
        
        // 3. Configurar Tabla
        DefaultTableModel modelo = new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nombre", "Estado", "Dirección"}
        ) {
            boolean[] canEdit = new boolean [] {false, false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        tablaContenedores.setModel(modelo);
    }
    
    public void CargarDatosDashboard() {
        // --- SIMULACIÓN DE DATOS ---
        listaContenedores.clear();
        listaContenedores.add(new String[]{"1", "Contenedor Centro", "Lleno", "Calle Principal 123"});
        listaContenedores.add(new String[]{"2", "Contenedor Norte", "Util", "Av. Norte 456"});
        listaContenedores.add(new String[]{"3", "Contenedor Sur", "Lleno", "Av. Sur 789"});
        listaContenedores.add(new String[]{"4", "Contenedor Este", "Mitad", "Calle Este 101"});
        listaContenedores.add(new String[]{"5", "Contenedor Plaza", "Util", "Plaza de Armas"});
        // -----------------------------

        // 6. Actualizar Tabla
        DefaultTableModel modelo = (DefaultTableModel) tablaContenedores.getModel();
        modelo.setRowCount(0); 
        for (String[] fila : listaContenedores) {
            modelo.addRow(fila);
        }

        // 7. Actualizar Gráfico
        ActualizarDatosGrafico();
    }
    
    private void ActualizarDatosGrafico() {
        if (listaContenedores == null || listaContenedores.isEmpty()) return;

        // 1. Agrupar y contar por estado
        int contLleno = 0, contUtil = 0, contMitad = 0;
        for (String[] c : listaContenedores) {
            String estado = c[2]; 
            if (estado.equalsIgnoreCase("Lleno")) contLleno++;
            else if (estado.equalsIgnoreCase("Util")) contUtil++;
            else if (estado.equalsIgnoreCase("Mitad")) contMitad++;
        }

        // 2. Crear Dataset para JFreeChart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(contUtil, "Estados", "Util");
        dataset.addValue(contMitad, "Estados", "Mitad");
        dataset.addValue(contLleno, "Estados", "Lleno");

        // 3. Crear Gráfico
        JFreeChart chart = ChartFactory.createBarChart(
                "CONTENEDORES POR ESTADO", // Título
                "", // Eje X
                "Cantidad", // Eje Y
                dataset
        );

        // 4. Personalizar Colores
        CategoryPlot plot = chart.getCategoryPlot();
        
        BarRenderer customRenderer = new BarRenderer() {
            @Override
            public java.awt.Paint getItemPaint(int row, int column) {
                String categoria = (String) dataset.getColumnKey(column);
                if (categoria.equals("Lleno")) return new Color(220, 53, 69); // Rojo
                if (categoria.equals("Util")) return new Color(40, 167, 69); // Verde
                if (categoria.equals("Mitad")) return new Color(255, 193, 7); // Amarillo
                return super.getItemPaint(row, column);
            }
        };
        plot.setRenderer(customRenderer);

        // 5. Mostrar en el Panel
        panelGrafico.removeAll();
        ChartPanel chartPanel = new ChartPanel(chart);
        panelGrafico.add(chartPanel, BorderLayout.CENTER);
        panelGrafico.validate();
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
