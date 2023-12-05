
package View.Component;

import Modelo.Producto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CardProducto extends javax.swing.JPanel {

    private final int shadowSize = 5;
    
    private String nombre;
    private double precio;
    private int cantidad;
    private String codigo;
    private String categoria;
    
    private ActionListener buttonListener;
    private ChangeListener spinnerChangeListener;
    
    SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

    public CardProducto() {
        initComponents();
        jsCantidad.setModel(spinnerModel);
        jsCantidad.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cantidad = (int) jsCantidad.getValue();
            }
        });
    }
    
    //Metodo para construir a cardproducto
    
    public void setDatos(Producto producto){
        jlNombre.setText(producto.getNombre());
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.codigo = producto.getCodigo();
    }
    
    //Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        jsCantidad.setValue(cantidad);
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public void setButtonListener(ActionListener listener) {
        jbAgregar.addActionListener(listener);
        this.buttonListener = listener;
    }
    
    public void setSpinnerChangeListener(ChangeListener listener) {
        spinnerChangeListener = listener;
        jsCantidad.getModel().addChangeListener(listener);
    }
    
    //Metodo para cambiar el borde
    
    public void setBorderColor(Color color) {
        setBorder(new javax.swing.border.LineBorder(color, 1, true));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jsCantidad = new javax.swing.JSpinner();
        jbAgregar = new View.Swing.ModernButton();
        jlNombre = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jbAgregar.setText("Agregar");

        jlNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jlNombre.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jsCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jlNombre))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(24, 93, 163));
        g2.fillRect(6, 5, 10, getHeight() - shadowSize * 2 + 1);
        g2.dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Swing.ModernButton jbAgregar;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JSpinner jsCantidad;
    // End of variables declaration//GEN-END:variables
}
