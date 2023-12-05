package View.pages;


import ModelView.BarraUpdate;
import ModelView.ControlMesas;
import View.Component.Notificacion;
import View.Main;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Page_Mesas extends javax.swing.JPanel implements BarraUpdate{

    //Instancias de los paneles de cada piso
    
    private Mesas_Piso1 piso1;
    private Mesas_Piso2 piso2;
    private Mesas_Terraza terraza;
    
    private Main main;
    
    //Variables para las progressBar
    
    private int mesasLibre =0;
    private int mesasOcupadas=0;
    private int mesasMantenimiento=100;

    public Page_Mesas(Main mainRecibido,Page_Pedidos pagePedidos) {
        this.main = mainRecibido;
        initComponents();
        init();

        piso1 = new Mesas_Piso1(pagePedidos);
        piso1.setBarraUpdate(this);
        piso2 = new Mesas_Piso2(pagePedidos);
        piso2.setBarraUpdate(this);
        terraza = new Mesas_Terraza(pagePedidos);
        terraza.setBarraUpdate(this);
        
        //Listener del comboBox de selecion de pisos
        
        ItemListener aListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int index = comboBox.getSelectedIndex();
                    if (index == -1) {
                        panelMesas.removeAll();
                        panelMesas.add(piso1);
                        panelMesas.repaint();
                        panelMesas.revalidate();
                        piso1.actualizarBarras();
                    } else if (index == 0) {
                        panelMesas.removeAll();
                        panelMesas.add(piso1);
                        panelMesas.repaint();
                        panelMesas.revalidate();
                        piso1.actualizarBarras();
                    } else if (index == 1) {
                        panelMesas.removeAll();
                        panelMesas.add(piso2);
                        panelMesas.repaint();
                        panelMesas.revalidate();
                        piso2.actualizarBarras();
                    } else if (index == 2) {
                        panelMesas.removeAll();
                        panelMesas.add(terraza);
                        panelMesas.repaint();
                        panelMesas.revalidate();
                        terraza.actualizarBarras();
                    }
                }
            }
        };

        // Agregando ItemListener al comboBox
        comboBox.addItemListener(aListener);
        panelMesas.add(piso1);
    }
    
    // Inicializador de los items del panel
    private void init() {
        
        barProgress();
        //Datos comboBox
        comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Piso 1", "Piso 2", "Terraza"}));
        comboBox.setSelectedIndex(-1);
        comboBox.setLabeText("Piso");
    }
    
    public void barProgress(){
        //Datos de barras
        libresBar.setForeground(new Color(18, 163, 24));
        libresBar.setValue(mesasLibre);
        libresBar.setColorString(new Color(0, 0, 0));

        ocupadasBar.setForeground(new Color(206, 28, 28));
        ocupadasBar.setValue(mesasOcupadas);
        ocupadasBar.setColorString(new Color(0, 0, 0));
        
        mantenimientoBar.setForeground(new Color(241, 196, 15));
        mantenimientoBar.setValue(mesasMantenimiento);
        mantenimientoBar.setColorString(new Color(0, 0, 0));
    }
    
    //Llama a la funcion que calcula el porcentaje de las barras
    @Override
    public void cantidadPorEstado(int totalMesas, int libres, int ocupadas, int mantenimiento) {
        mesasLibre = ControlMesas.calcularPorcentaje(libres,totalMesas);
        mesasOcupadas = ControlMesas.calcularPorcentaje(ocupadas,totalMesas);
        mesasMantenimiento = ControlMesas.calcularPorcentaje(mantenimiento,totalMesas);
        barProgress();
    }
    
    //Muestra el mensaje de la orden agregada
    @Override
    public void mensajeNotificacion(){
        Notificacion panel = new Notificacion(main, Notificacion.Type.SUCCESS, Notificacion.Location.BOTTOM_RIGHT, "Nuevo Pedido Ingresado desde Mesas");
        panel.showNotification();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new View.Swing.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        libresBar = new View.Swing.ProgressBarCustom();
        ocupadasBar = new View.Swing.ProgressBarCustom();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mantenimientoBar = new View.Swing.ProgressBarCustom();
        comboBox = new View.Swing.ComboBoxCustom();
        panelMesas = new View.Swing.PanelBorder();

        setBackground(new java.awt.Color(242, 242, 242));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Mantenimiento");

        libresBar.setBackground(new java.awt.Color(242, 242, 242));

        ocupadasBar.setBackground(new java.awt.Color(242, 242, 242));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Libres");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Ocupadas");

        mantenimientoBar.setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(libresBar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ocupadasBar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(mantenimientoBar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ocupadasBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mantenimientoBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libresBar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        comboBox.setBackground(new java.awt.Color(246, 246, 246));
        comboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxItemStateChanged(evt);
            }
        });

        panelMesas.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelMesas, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxItemStateChanged

    }//GEN-LAST:event_comboBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Swing.ComboBoxCustom comboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private View.Swing.ProgressBarCustom libresBar;
    private View.Swing.ProgressBarCustom mantenimientoBar;
    private View.Swing.ProgressBarCustom ocupadasBar;
    private View.Swing.PanelBorder panelBorder1;
    private View.Swing.PanelBorder panelMesas;
    // End of variables declaration//GEN-END:variables
}
