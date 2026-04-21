/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package infraestructura.ui;

import aplicacion.ContenedorService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
public class VistaEstadistica extends javax.swing.JPanel {
    
    private final Timer timerRefresco;
    private final ContenedorService service;

    public VistaEstadistica() {
        initComponents();
        
        // Configurar los paneles para recibir los gráficos
        panelChart1.setLayout(new BorderLayout());
        panelChart2.setLayout(new BorderLayout());
        panelChart3.setLayout(new BorderLayout());

        // Configurar el Timer
        timerRefresco = new Timer(5000, (java.awt.event.ActionEvent e) -> {
            CargarGraficos();
        });
        timerRefresco.start();
        
        // Carga inicial
        CargarGraficos();
    }
    
    public void CargarGraficos() {
        RecargarGraficoDonut();
        RecargarGraficoTrabajadores();
        RecargarGraficoTopContenedores();
    }

    // --- 1. DONA (ESTADO CONTENEDORES) ---
    private void RecargarGraficoDonut() {
        // Simulación de datos (En el futuro: var datos = _service.ObtenerEstadisticaEstados())
        Map<String, Integer> datosEstados = new LinkedHashMap<>();
        datosEstados.put("LLENO", 15);
        datosEstados.put("MITAD", 8);
        datosEstados.put("UTIL", 25);
        datosEstados.put("DESCONOCIDO", 2);

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Integer> entry : datosEstados.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        // Crear gráfico de Dona (Anillo)
        JFreeChart chart = ChartFactory.createRingChart(
                "Estado Contenedores", dataset, false, true, false);

        // Estilos
        chart.setTitle(new TextTitle("Estado Contenedores", new Font("Segoe UI", Font.BOLD, 16)));
        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);

        // Colores según estado (Traducción de tu lógica en C#)
        for (Object key : dataset.getKeys()) {
            String estado = key.toString().toUpperCase();
            if (estado.equals("LLENO")) {
                plot.setSectionPaint((Comparable) key, new Color(220, 53, 69)); // Rojo
            } else if (estado.equals("MITAD")) {
                plot.setSectionPaint((Comparable) key, new Color(255, 193, 7)); // Amarillo
            } else if (estado.equals("VACIO") || estado.equals("UTIL")) {
                plot.setSectionPaint((Comparable) key, new Color(40, 167, 69)); // Verde
            } else {
                plot.setSectionPaint((Comparable) key, Color.GRAY);
            }
        }

        // Inyectar al panel
        panelChart1.removeAll();
        panelChart1.add(new ChartPanel(chart), BorderLayout.CENTER);
        panelChart1.validate();
    }

    // --- 2. BARRAS HORIZONTALES (TRABAJADORES) ---
    private void RecargarGraficoTrabajadores() {
        // Simulación de datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(120, "Recolecciones", "Juan Perez");
        dataset.addValue(95, "Recolecciones", "Maria Gomez");
        dataset.addValue(78, "Recolecciones", "Carlos Ruiz");

        // Crear gráfico de Barras (Orientación Horizontal)
        JFreeChart chart = ChartFactory.createBarChart(
                "Recolecciones por Trabajador", "", "", dataset, 
                PlotOrientation.HORIZONTAL, false, true, false);

        chart.setTitle(new TextTitle("Recolecciones por Trabajador", new Font("Segoe UI", Font.BOLD, 16)));
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);

        // Color SeaGreen
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(46, 139, 87)); // SeaGreen

        panelChart2.removeAll();
        panelChart2.add(new ChartPanel(chart), BorderLayout.CENTER);
        panelChart2.validate();
    }

    // --- 3. COLUMNAS VERTICALES (TOP CONTENEDORES) ---
    private void RecargarGraficoTopContenedores() {
        // Simulación de datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(45, "Veces", "Contenedor Centro");
        dataset.addValue(38, "Veces", "Contenedor Plaza");
        dataset.addValue(30, "Veces", "Contenedor Norte");

        // Crear gráfico de Barras (Orientación Vertical)
        JFreeChart chart = ChartFactory.createBarChart(
                "Contenedores más Recolectados", "", "", dataset, 
                PlotOrientation.VERTICAL, false, true, false);

        chart.setTitle(new TextTitle("Contenedores más Recolectados", new Font("Segoe UI", Font.BOLD, 16)));
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);

        // Color Fire (Naranja/Rojo oscuro)
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(226, 88, 34)); // Fire

        panelChart3.removeAll();
        panelChart3.add(new ChartPanel(chart), BorderLayout.CENTER);
        panelChart3.validate();
    }
    
    // Al destruirse el panel, detenemos el timer
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

        panelChart2 = new javax.swing.JPanel();
        panelChart1 = new javax.swing.JPanel();
        panelChart3 = new javax.swing.JPanel();

        panelChart2.setPreferredSize(new java.awt.Dimension(494, 363));

        javax.swing.GroupLayout panelChart2Layout = new javax.swing.GroupLayout(panelChart2);
        panelChart2.setLayout(panelChart2Layout);
        panelChart2Layout.setHorizontalGroup(
            panelChart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );
        panelChart2Layout.setVerticalGroup(
            panelChart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        panelChart1.setPreferredSize(new java.awt.Dimension(494, 363));

        javax.swing.GroupLayout panelChart1Layout = new javax.swing.GroupLayout(panelChart1);
        panelChart1.setLayout(panelChart1Layout);
        panelChart1Layout.setHorizontalGroup(
            panelChart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );
        panelChart1Layout.setVerticalGroup(
            panelChart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        panelChart3.setPreferredSize(new java.awt.Dimension(494, 363));

        javax.swing.GroupLayout panelChart3Layout = new javax.swing.GroupLayout(panelChart3);
        panelChart3.setLayout(panelChart3Layout);
        panelChart3Layout.setHorizontalGroup(
            panelChart3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelChart3Layout.setVerticalGroup(
            panelChart3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelChart3, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelChart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelChart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelChart3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelChart1;
    private javax.swing.JPanel panelChart2;
    private javax.swing.JPanel panelChart3;
    // End of variables declaration//GEN-END:variables
}
