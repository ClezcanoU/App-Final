
package View.pages;

import Modelo.interfaz.ModelPieChart;
import View.Swing.PieChart;
import View.Swing.ScrollBarCustom2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;

public class Page_Metricas extends javax.swing.JPanel {

    public Page_Metricas() {
        initComponents();
        init();
    }

    private void init(){
        
        jScrollGraficas.setBorder(null);
        jScrollGraficas.getViewport().setBackground(Color.WHITE);
        jScrollGraficas.setVerticalScrollBar(new ScrollBarCustom2());
        jScrollGraficas.getVerticalScrollBar().setBackground(Color.WHITE);
        
        showLineChart();
        showHistogram();
        showBarChart();
        
        
        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
        pieChart1.addData(new ModelPieChart("Ajiaco", 213, new Color(23, 126, 238)));
        pieChart1.addData(new ModelPieChart("Pechuga Gratinada", 23, new Color(221, 65, 65)));
        pieChart1.addData(new ModelPieChart("Picada", 87, new Color(47, 157, 64)));
        pieChart1.addData(new ModelPieChart("Chanfaina", 45, new Color(196, 151, 58)));
        pieChart1.addData(new ModelPieChart("Costillas de Cordero", 81, new Color(106, 21, 98)));
        
        pieChart2.setChartType(PieChart.PeiChartType.DONUT_CHART);
        pieChart2.addData(new ModelPieChart("Poker", 168, new Color(23, 126, 238)));
        pieChart2.addData(new ModelPieChart("Cola y Pola", 123, new Color(221, 65, 65)));
        pieChart2.addData(new ModelPieChart("Colombiana", 86, new Color(47, 157, 64)));
        pieChart2.addData(new ModelPieChart("Pepsi", 98, new Color(196, 151, 58)));
        pieChart2.addData(new ModelPieChart("Hit Mora", 84, new Color(106, 21, 98)));
    }
    
    public void showLineChart(){
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(4, "Monto", "E");
        dataset.setValue(2.3, "Monto", "F");
        dataset.setValue(3.1, "Monto", "M");
        dataset.setValue(1.1, "Monto", "A");
        dataset.setValue(2.5, "Monto", "M");
        dataset.setValue(3.6, "Monto", "J");
        dataset.setValue(2.1, "Monto", "J");
        dataset.setValue(4.6, "Monto", "A");
        dataset.setValue(5, "Monto", "S");
        dataset.setValue(4.2, "Monto", "O");
        dataset.setValue(4, "Monto", "N");
//        dataset.setValue(0, "Monto", "D");
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Ingresos","Mes","Monto", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
        //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }
    
    public void showHistogram(){
         double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
                            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
                            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
                            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
                            77, 44, 58, 91, 10, 67, 57, 19, 88, 84                                
                          };
 
 
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Frecuencia de Pedidos", values, 20);
        
        JFreeChart chart = ChartFactory.createHistogram("Frecuencia de Pedidos", "Número de Pedidos", "Dia Semana", 
            dataset, PlotOrientation.VERTICAL, false, true, false);
        
        XYPlot plot= chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);

        
        
        ChartPanel barpChartPanel2 = new ChartPanel(chart);
        panelHistogram.removeAll();
        panelHistogram.add(barpChartPanel2, BorderLayout.CENTER);
        panelHistogram.validate();
    }
    
    public void showBarChart(){
        
        DefaultCategoryDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createBarChart(
                "Afluencia de clientes",
                "Día de la semana",
                "Número de clientes",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setBackgroundPaint(Color.WHITE);

        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color barColor = new Color(30, 144, 255); // Color Azul
        renderer.setSeriesPaint(0, barColor);

        ChartPanel barChartPanel = new ChartPanel(chart);
        panelBar.removeAll();
        panelBar.add(barChartPanel, BorderLayout.CENTER);
        panelBar.validate();
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.setValue(76, "Clientes", "Lunes");
        dataset.setValue(65, "Clientes", "Martes");
        dataset.setValue(61, "Clientes", "Miércoles");
        dataset.setValue(58, "Clientes", "Jueves");
        dataset.setValue(92, "Clientes", "Viernes");
        dataset.setValue(126, "Clientes", "Sábado");
        dataset.setValue(261, "Clientes", "Domingo");

        return dataset;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollGraficas = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelHistogram = new javax.swing.JPanel();
        panelBar = new javax.swing.JPanel();
        panelLineChart = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pieChart1 = new View.Swing.PieChart();
        jLabel3 = new javax.swing.JLabel();
        pieChart2 = new View.Swing.PieChart();

        setBackground(new java.awt.Color(244, 244, 244));

        jLabel1.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Metricas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelHistogram.setLayout(new java.awt.BorderLayout());

        panelBar.setLayout(new java.awt.BorderLayout());

        panelLineChart.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Platos más Vendidos");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bebidas más Vendidos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBar, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pieChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelHistogram, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHistogram, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pieChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jScrollGraficas.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollGraficas)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollGraficas)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollGraficas;
    private javax.swing.JPanel panelBar;
    private javax.swing.JPanel panelHistogram;
    private javax.swing.JPanel panelLineChart;
    private View.Swing.PieChart pieChart1;
    private View.Swing.PieChart pieChart2;
    // End of variables declaration//GEN-END:variables
}
