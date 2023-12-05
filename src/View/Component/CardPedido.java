
package View.Component;

import Modelo.Mesa;
import Modelo.Pedido;
import Modelo.Producto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ChangeListener;

public class CardPedido extends javax.swing.JPanel {

    private final int shadowSize = 5;
    
    private String codigo;
    private String cliente;
    private String pedido;
    private Pedido.TIPO tipo = Pedido.TIPO.LOCAL;
    private Pedido.Estado estado = Pedido.Estado.ENPROCESO;
    private List<Producto> listaProductos = new ArrayList<>();
    private String notas;
    
    private ActionListener buttonListener;
    
    public CardPedido() {
        initComponents();
        setBackground(Color.WHITE);
    }
    
    //Metodo para construir a cardpedido
    public void setDatos(Pedido pedido){
        this.codigo = pedido.getCodigo();
        this.cliente = pedido.getCliente();
        this.tipo = pedido.getTipo();
        this.estado = pedido.getEstado();
        this.listaProductos = pedido.getListaProductos();
        this.notas = pedido.getNotas();
        this.pedido = pedido.getPedido();
        jlCliente.setText(cliente);
    }

    //Metodo para cambiar el borde
    public void setBorderColor(Color color) {
        setBorder(new javax.swing.border.LineBorder(color, 1, true));
    }
    
    //Getters and Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Pedido.TIPO getTipo() {
        return tipo;
    }

    public void setTipo(Pedido.TIPO tipo) {
        this.tipo = tipo;
        repaint();
    }

    public Pedido.Estado getEstado() {
        return estado;
    }

    public void setEstado(Pedido.Estado estado) {
        this.estado = estado;
        repaint();
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
    
    
    
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setButtonListener(ActionListener buttonListener) {
        jbEliminar.addActionListener(buttonListener);
        this.buttonListener = buttonListener;
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlCliente = new javax.swing.JLabel();
        jbEliminar = new View.Swing.ModernButton();

        jlCliente.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jlCliente.setText("Cliente");

        jbEliminar.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getColorForState(estado));
        g2.fillRect(6, 5, 10, getHeight() - shadowSize * 2 + 1);
        g2.drawString(tipo.toString(), 20, 20);
        g2.dispose();
    }
    
    //Metodo para obtener el color para la barra lateral
    
    public Color getColorForState(Pedido.Estado estado) {
        switch (estado) {
            case REALIZADO:
                return new Color(18, 163, 24);
            case PENDIENTE:
                return new Color(206, 28, 28);
            case ENPROCESO:
                return new Color(24,93,232);
            default:
                return Color.BLACK; // Color por defecto
        }
    }

    @Override
    public String toString() {
        return "CardPedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", tipo=" + tipo + ", estado=" + estado + ", listaProductos=" + listaProductos + ", notas=" + notas + '}';
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Swing.ModernButton jbEliminar;
    private javax.swing.JLabel jlCliente;
    // End of variables declaration//GEN-END:variables
}
