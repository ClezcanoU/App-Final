
package View.pages;

import Modelo.EmpleadoDAO;
import Modelo.InsumoDAO;
import Modelo.SQLConeccion;
import Modelo.interfaz.ModelCelda;
import Modelo.interfaz.ModelCelda2;
import Modelo.interfaz.ModelName;
import Modelo.interfaz.ModelPieChart;
import Modelo.interfaz.Model_Card;
import View.Swing.PieChart;
import View.Swing.ScrollBarCustom2;
import View.Tabla.CellBotones;
import View.Tabla.CellEstado;
import View.Tabla.CellLugar;
import View.Tabla.CellName;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


public class Page_Home extends javax.swing.JPanel {

    SQLConeccion sqlConeccion = new SQLConeccion();
    
    public Page_Home() {
        initComponents();
        tabla1.addTableStyle(jScrollEmpleados);
        initDataTable();
        
        //Anexion de los datos de las cards
        card1.setData(new Model_Card("Mesas",new ImageIcon(getClass().getResource("/View/Icon/4.png")),"Disponibles","14",
                new ImageIcon(getClass().getResource("/View/Icon/box2.png")),"Ocupadas","6"));
        card2.setData(new Model_Card("Pedidos",new ImageIcon(getClass().getResource("/View/Icon/3.png")),"Entregados","18",
                new ImageIcon(getClass().getResource("/View/Icon/truck.png")),"Pendientes","4"));
        card3.setData(new Model_Card("Ventas",new ImageIcon(getClass().getResource("/View/Icon/inboxes.png")),"Platos Vendidos","40",
                new ImageIcon(getClass().getResource("/View/Icon/cash.png")),"Valor","$$$$$$"));
        
        
        double[] gastosArray = {1500.0, 1200.0, 1800.0, 1300.0};
        double[] ingresosArray = {3000.0, 3500.0, 4000.0, 3800.0};

        // Convierte los arrays de primitivos a arrays de objetos
        Double[] gastos = Arrays.stream(gastosArray).boxed().toArray(Double[]::new);
        Double[] ingresos = Arrays.stream(ingresosArray).boxed().toArray(Double[]::new);

        List<Double> beneficios = calcularBeneficios(Arrays.asList(gastos), Arrays.asList(ingresos));
        showGastosIngresosBeneficiosBarChart(Arrays.asList(gastos), Arrays.asList(ingresos), beneficios);
        
    }

    private void initDataTable() {
        tabla1.addTableCell(new CellName(), 0);
        tabla1.addTableCell(new CellLugar(), 1);
        tabla1.addTableCell(new CellEstado(), 2);
        tabla1.addTableCell(new CellBotones(), 3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (ModelCelda2 empleados : new EmpleadoDAO(sqlConeccion).listarEmpleados()) {
                    tabla1.addRow(empleados, false);
                }
            }
        }).start();
//        tabla1.addRow(new ModelCelda2(new ModelName("Luis", new ImageIcon(getClass().getResource("/View/Icon/pollo.png")), ""), "Cocina", "Activo"), false);  //  ture is animate row
//        tabla1.addRow(new ModelCelda2(new ModelName("Juan", new ImageIcon(getClass().getResource("/View/Icon/ensalada.png")), ""), "Salon 1", "NoActivo"), false);  //  ture is animate row
//        tabla1.addRow(new ModelCelda2(new ModelName("Santiago", new ImageIcon(getClass().getResource("/View/Icon/coctel.png")), ""), "Terraza", "Descanso"), false);  //  ture is animate row
//        tabla1.addRow(new ModelCelda2(new ModelName("Maria", new ImageIcon(getClass().getResource("/View/Icon/flan.png")), ""), "Salon 3", "Activo"), false);  //  ture is animate row

    }
    
    private static List<Double> calcularBeneficios(List<Double> gastos, List<Double> ingresos) {
        // Asumiendo que beneficio = ingreso - gasto para cada mes
        if (gastos.size() != ingresos.size()) {
            throw new IllegalArgumentException("Las listas de gastos e ingresos deben tener la misma longitud.");
        }

        List<Double> beneficios = new ArrayList<>();
        for (int i = 0; i < gastos.size(); i++) {
            double beneficio = ingresos.get(i) - gastos.get(i);
            beneficios.add(beneficio);
        }

        return beneficios;
    }
    
    
    public void showGastosIngresosBeneficiosBarChart(List<Double> gastos, List<Double> ingresos, List<Double> beneficios) {

        // Llama al método para mostrar la gráfica de barras con los datos de prueba
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int startMonth = Math.max(0, gastos.size() - 4); // Últimos 4 meses o menos si no hay suficientes datos

        for (int i = startMonth; i < gastos.size(); i++) {
            dataset.setValue(gastos.get(i), "Gastos", "Mes " + (i + 1));
            dataset.setValue(ingresos.get(i), "Ingresos", "Mes " + (i + 1));
            dataset.setValue(beneficios.get(i), "Beneficios", "Mes " + (i + 1));
        }

        JFreeChart chart = ChartFactory.createBarChart("Gastos/Ingresos", "Meses", "Cantidad",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setBackgroundPaint(Color.WHITE);

        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        renderer.setSeriesPaint(0, Color.RED); // Gastos en rojo
        renderer.setSeriesPaint(1, Color.GREEN); // Ingresos en verde
        renderer.setSeriesPaint(2, Color.BLUE); // Beneficios en azul

        ChartPanel chartPanel = new ChartPanel(chart);
        panelBarOp2.removeAll();
        panelBarOp2.add(chartPanel, BorderLayout.CENTER);
        panelBarOp2.validate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new View.Component.CardResumen();
        card2 = new View.Component.CardResumen();
        card3 = new View.Component.CardResumen();
        panelRedondeado1 = new View.Swing.PanelRedondeado();
        jScrollEmpleados = new javax.swing.JScrollPane();
        tabla1 = new View.Tabla.Tabla();
        panelBarOp2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(242, 242, 242));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(56, 40, 203));
        card1.setColor2(new java.awt.Color(34, 165, 201));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(255, 44, 40));
        card2.setColor2(new java.awt.Color(249, 145, 18));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(0, 191, 143));
        card3.setColor2(new java.awt.Color(0, 88, 26));
        panel.add(card3);

        panelRedondeado1.setBackground(new java.awt.Color(60, 60, 60));
        panelRedondeado1.setOpaque(true);

        jScrollEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        tabla1.setBackground(new java.awt.Color(60, 60, 60));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Lugar", "Estado", "Botones"
            }
        ));
        jScrollEmpleados.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        javax.swing.GroupLayout panelRedondeado1Layout = new javax.swing.GroupLayout(panelRedondeado1);
        panelRedondeado1.setLayout(panelRedondeado1Layout);
        panelRedondeado1Layout.setHorizontalGroup(
            panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondeado1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jScrollEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRedondeado1Layout.setVerticalGroup(
            panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        panelBarOp2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBarOp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRedondeado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRedondeado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBarOp2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Component.CardResumen card1;
    private View.Component.CardResumen card2;
    private View.Component.CardResumen card3;
    private javax.swing.JScrollPane jScrollEmpleados;
    private javax.swing.JLayeredPane panel;
    private javax.swing.JPanel panelBarOp2;
    private View.Swing.PanelRedondeado panelRedondeado1;
    private View.Tabla.Tabla tabla1;
    // End of variables declaration//GEN-END:variables
}
