
package View.pages;

import ModelView.BarraUpdate;
import ModelView.MesaListener;
import Modelo.Mesa;
import Modelo.Pedido;
import Modelo.Producto;
import View.Component.CardMesa;
import View.Component.CardPedido;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;

public class Mesas_Piso1 extends javax.swing.JPanel implements MesaListener {

    private Form_Mesas formMesas;
    private Page_Pedidos pagePedidos;
    private Color color;
    
    private Map<String, CardMesa> mapMesas = new HashMap<>();
    
    private ImageIcon Icon = new ImageIcon(getClass().getResource("/View/Icon/Tenedor.png"));
    
    private int contador = 0;
    
    //Instancia para actualizar las progress bar
    
    private BarraUpdate barraUpdate;

    public void setBarraUpdate(BarraUpdate barraUpdate) {
        this.barraUpdate = barraUpdate;
    }

    public Mesas_Piso1(Page_Pedidos pagePedidos) {
        initComponents();
        this.pagePedidos = pagePedidos;
        init();
        mapMesas.put(cardMesa1.getNumero(), cardMesa1);
        mapMesas.put(cardMesa2.getNumero(), cardMesa2);
        mapMesas.put(cardMesa3.getNumero(), cardMesa3);
        mapMesas.put(cardMesa4.getNumero(), cardMesa4);
        mapMesas.put(cardMesa5.getNumero(), cardMesa5);
        mapMesas.put(cardMesa6.getNumero(), cardMesa6);
        mapMesas.put(cardMesa7.getNumero(), cardMesa7);
        mapMesas.put(cardMesa8.getNumero(), cardMesa8);
        mapMesas.put(cardMesa9.getNumero(), cardMesa9);
    }
    
    private void init(){
        cardMesa1.setDatos(new Mesa("Mesa #1","#1",Mesa.Estado.MANTENIMIENTO,Icon,"","",""));
        cardMesa2.setDatos(new Mesa("Mesa #2","#2",Mesa.Estado.MANTENIMIENTO,Icon,"","",""));
        cardMesa3.setDatos(new Mesa("Mesa #3","#3",Mesa.Estado.LIBRE,Icon,"","",""));
        cardMesa4.setDatos(new Mesa("Mesa #4","#4",Mesa.Estado.MANTENIMIENTO,Icon,"","",""));
        cardMesa5.setDatos(new Mesa("Mesa #5","#5",Mesa.Estado.MANTENIMIENTO,Icon,"","",""));
        cardMesa6.setDatos(new Mesa("Mesa #6","#6",Mesa.Estado.LIBRE,Icon,"","",""));
        cardMesa7.setDatos(new Mesa("Mesa #7","#7",Mesa.Estado.LIBRE,Icon,"","",""));
        cardMesa8.setDatos(new Mesa("Mesa #8","#8",Mesa.Estado.MANTENIMIENTO,Icon,"","",""));
        cardMesa9.setDatos(new Mesa("Mesa #9","#9",Mesa.Estado.LIBRE,Icon,"","",""));
        agregarMouseListenerACardMesas();
        formMesas = new Form_Mesas();
    }
    
    //Agrega un listener para cada card
    
    private void agregarMouseListenerACardMesas() {
        cardMesa1.addMouseListener(crearMouseListener("Mesa #1"));
        cardMesa2.addMouseListener(crearMouseListener("Mesa #2"));
        cardMesa3.addMouseListener(crearMouseListener("Mesa #3"));
        cardMesa4.addMouseListener(crearMouseListener("Mesa #4"));
        cardMesa5.addMouseListener(crearMouseListener("Mesa #5"));
        cardMesa6.addMouseListener(crearMouseListener("Mesa #6"));
        cardMesa7.addMouseListener(crearMouseListener("Mesa #7"));
        cardMesa8.addMouseListener(crearMouseListener("Mesa #8"));
        cardMesa9.addMouseListener(crearMouseListener("Mesa #9"));
    }

    //MouseListener para cada card
    
    private MouseListener crearMouseListener(String nombreMesa) {
        return new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MostrarDatosMesa(nombreMesa);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (evt.getSource() instanceof CardMesa) {
                    CardMesa mesa = (CardMesa) evt.getSource();
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    mesa.setBorderColor(Color.RED);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (evt.getSource() instanceof CardMesa) {
                    CardMesa mesa = (CardMesa) evt.getSource();
                    mesa.setBorderColor(Color.WHITE);
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        };
    }
    
    //Muestra los datos de cada card
    
    private void MostrarDatosMesa(String nombreMesa) {
        
        String mesa = nombreMesa.split(" ").length > 1 ? nombreMesa.split(" ")[1] : nombreMesa;
        formMesas.setTitulo(mesa);
        CardMesa cardMesa = mapMesas.get(mesa);
        color = cardMesa.getColorForState(cardMesa.getEstado());
        
        if (cardMesa != null) {
            formMesas.setProductos(cardMesa.getPedido());
            formMesas.setFactura(cardMesa.getFactura());
            formMesas.setNotas(cardMesa.getNota());
        } else {
            System.out.println("La mesa " + mesa + " no existe");
        }
        
        formMesas.cambiarColor(color);
        formMesas.setMesaListener(this);
        formMesas.setVisible(true);
        formMesas.setLocationRelativeTo(null);
    }
    
    //Reinicia las progress bar
    
    public void reiniciarBarras(){
        actualizarBarras();
    }
    
    // Cuenta la cantidad de mesas por cada estado
    
    public void actualizarBarras(){
        int totalMesas = mapMesas.size();
        int mesasLibres = 0;
        int mesasOcupadas = 0;
        int mesasMantenimiento = 0;
        for (CardMesa mesa : mapMesas.values()) {
            switch (mesa.getEstado()) {
                case LIBRE:
                    mesasLibres++;
                    break;
                case OCUPADO:
                    mesasOcupadas++;
                    break;
                case MANTENIMIENTO:
                    mesasMantenimiento++;
                    break;
            }
        }
        barraUpdate.cantidadPorEstado(totalMesas, mesasLibres, mesasOcupadas, mesasMantenimiento);
    }
    
    //Genera un codigo unico para identificar el pedido
    
    public String generarCodigo() {
        contador++;
        // Formatea el contador como una cadena con ceros a la izquierda y lo concatena con "#"
        return String.format("#%04d", contador)+"p1";
    }
    
    //Limpia la mesa cambiando el estado
    
    @Override
    public void limpiarMesa(String mesa) {
        CardMesa cardMesa = mapMesas.get(mesa);

        if (cardMesa != null) {
            cardMesa.setEstado(Mesa.Estado.LIBRE);
            formMesas.cambiarColor(color);
            actualizarBarras();
        } else {
            System.out.println("La mesa " + mesa + " no existe");
        }
    }
    
    //Cambia el estado de la mesa por ocupado y envia el pedido si se confirma
    
    @Override
    public void ocuparMesa(String mesa, Boolean enviarPedido,List<Producto> listaProducts) {
        CardMesa cardMesa = mapMesas.get(mesa);
        
        if (cardMesa != null) {
            cardMesa.setEstado(Mesa.Estado.OCUPADO);
            formMesas.cambiarColor(color);
            actualizarBarras();
        } else {
            System.out.println("La mesa " + mesa + " no existe");
        }
        
        if (enviarPedido == true){
            String codigo;
            codigo = generarCodigo();
            CardPedido cardPedido = new CardPedido();
            Pedido pedido = new Pedido(codigo, cardMesa.getNombre(),Pedido.TIPO.LOCAL,Pedido.Estado.PENDIENTE,cardMesa.getNota());
            pedido.setPedido(cardMesa.getPedido());
            pedido.setListaProductos(listaProducts);
            cardPedido.setDatos(pedido);
            pagePedidos.mapMesasPedidos.put(cardMesa.getNombre(), cardPedido);
            pagePedidos.limpiarForm(1);
        } else if(enviarPedido == false){
            
        }
    }
    
    //Mostrar mensaje segun el tipo
    @Override
    public void mensajeNotificacion(){
        barraUpdate.mensajeNotificacion();
    }
    
    //Actualizadores de cada textArea (factura,pedido,notas)
    
    @Override
    public void actualizarFactura(String mesa, String nuevaFactura) {
        CardMesa cardMesa = mapMesas.get(mesa);
        
        if (cardMesa != null) {
            cardMesa.setFactura(nuevaFactura);
        } else {
            System.out.println("La mesa " + mesa + " no existe");
        }
    }
    
    @Override
    public void actualizarProductos(String mesa, String nuevosProductos, List<Producto> listaProductos) {
      CardMesa cardMesa = mapMesas.get(mesa);
        
        if (cardMesa != null) {
            cardMesa.setPedido(nuevosProductos);
            cardMesa.setListaProductos(listaProductos);
        } else {
            System.out.println("La mesa " + mesa + " no existe");
        }
    }
    
    @Override
    public void actualizarNotas(String mesa, String nuevasNotas) {
      CardMesa cardMesa = mapMesas.get(mesa);
        
        if (cardMesa != null) {
            cardMesa.setNota(nuevasNotas);
        } else {
            System.out.println("La mesa " + mesa + " no existe");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMesa = new View.Swing.PanelBorder();
        cardMesa1 = new View.Component.CardMesa();
        cardMesa2 = new View.Component.CardMesa();
        cardMesa3 = new View.Component.CardMesa();
        cardMesa4 = new View.Component.CardMesa();
        cardMesa5 = new View.Component.CardMesa();
        cardMesa6 = new View.Component.CardMesa();
        cardMesa7 = new View.Component.CardMesa();
        cardMesa8 = new View.Component.CardMesa();
        cardMesa9 = new View.Component.CardMesa();

        panelMesa.setBackground(new java.awt.Color(242, 242, 242));
        panelMesa.setLayout(new java.awt.GridLayout(3, 3, 20, 50));
        panelMesa.add(cardMesa1);
        panelMesa.add(cardMesa2);
        panelMesa.add(cardMesa3);
        panelMesa.add(cardMesa4);
        panelMesa.add(cardMesa5);
        panelMesa.add(cardMesa6);
        panelMesa.add(cardMesa7);
        panelMesa.add(cardMesa8);
        panelMesa.add(cardMesa9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Component.CardMesa cardMesa1;
    private View.Component.CardMesa cardMesa2;
    private View.Component.CardMesa cardMesa3;
    private View.Component.CardMesa cardMesa4;
    private View.Component.CardMesa cardMesa5;
    private View.Component.CardMesa cardMesa6;
    private View.Component.CardMesa cardMesa7;
    private View.Component.CardMesa cardMesa8;
    private View.Component.CardMesa cardMesa9;
    private View.Swing.PanelBorder panelMesa;
    // End of variables declaration//GEN-END:variables
}
