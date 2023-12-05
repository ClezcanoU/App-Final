
package View.pages;

import ModelView.PedidoListener;
import Modelo.Pedido;
import Modelo.Pedido.Estado;
import Modelo.Pedido.TIPO;
import View.Component.CardPedido;
import View.Swing.ScrollBarCustom2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Page_Pedidos extends javax.swing.JPanel implements PedidoListener{
    
    Map<String, CardPedido> mapDomicilios = new HashMap<>();
    Map<String, CardPedido> mapMesasPedidos = new HashMap<>();
    
    private JPanel listDomiciliosPanel;
    private JPanel listMesasPanel;
    
    private Form_Pedidos formPedidos = new Form_Pedidos();

    public Page_Pedidos() {
        initComponents();

        init();

        //Item listener para el comboBox de domicilios
        ItemListener estadoDomiciliosListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int index = cbDomicilios.getSelectedIndex();
                    if(index == -1){
                        limpiarForm(2);
                        for(CardPedido pedido:mapDomicilios.values()){
                            if(pedido.getEstado() == Pedido.Estado.PENDIENTE){
                                agregarDomicilio(pedido);
                            }
                        }
                    }
                    else if(index == 0){
                        limpiarForm(2);
                        for(CardPedido pedido:mapDomicilios.values()){
                            if(pedido.getEstado() == Pedido.Estado.REALIZADO){
                                agregarDomicilio(pedido);
                            }
                        }
                    } else if(index == 1){
                        limpiarForm(2);
                        for(CardPedido pedido:mapDomicilios.values()){
                            if(pedido.getEstado() == Pedido.Estado.PENDIENTE){
                                agregarDomicilio(pedido);
                            }
                        }
                    } else if(index == 2){
                        limpiarForm(2);
                        for(CardPedido pedido:mapDomicilios.values()){
                            if(pedido.getEstado() == Pedido.Estado.ENPROCESO){
                                agregarDomicilio(pedido);
                            }
                        }
                    }
                }
            }
        };
        
        //Item listener para el comboBox de mesas
        ItemListener estadoMesasListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int index = cbMesas.getSelectedIndex();
                    if(index == -1){
                        limpiarForm(1);
                        for(CardPedido pedido:mapMesasPedidos.values()){
                            if(pedido.getEstado() == Pedido.Estado.PENDIENTE){
                                agregarMesa(pedido);
                            }
                        }
                    }
                    else if(index == 0){
                        limpiarForm(1);
                        for(CardPedido pedido:mapMesasPedidos.values()){
                            if(pedido.getEstado() == Pedido.Estado.REALIZADO){
                                agregarMesa(pedido);
                            }
                        }
                    } else if(index == 1){
                        limpiarForm(1);
                        for(CardPedido pedido:mapMesasPedidos.values()){
                            if(pedido.getEstado() == Pedido.Estado.PENDIENTE){
                                agregarMesa(pedido);
                            }
                        }
                    } else if(index == 2){
                        limpiarForm(1);
                        for(CardPedido pedido:mapMesasPedidos.values()){
                            if(pedido.getEstado() == Pedido.Estado.ENPROCESO){
                                agregarMesa(pedido);
                            }
                        }
                    }
                }
            }
        };
        cbDomicilios.addItemListener(estadoDomiciliosListener);
        cbMesas.addItemListener(estadoMesasListener);
    }
    
    final public void init(){
        
        listDomiciliosPanel = new JPanel(new GridLayoutWithGap(50, 1, 0, 4));
        JScrollPane scrollDomicilios = new JScrollPane(listDomiciliosPanel);
        
        scrollDomicilios.setBorder(null);
        scrollDomicilios.getViewport().setBackground(Color.WHITE);
        scrollDomicilios.setVerticalScrollBar(new ScrollBarCustom2());
        scrollDomicilios.getVerticalScrollBar().setBackground(Color.WHITE);
        panelDPendientes.add(scrollDomicilios, BorderLayout.CENTER);
        
        listMesasPanel = new JPanel(new GridLayoutWithGap(50, 1, 0, 4));
        JScrollPane scrollMesas = new JScrollPane(listMesasPanel);
        
        scrollMesas.setBorder(null);
        scrollMesas.getViewport().setBackground(Color.WHITE);
        scrollMesas.setVerticalScrollBar(new ScrollBarCustom2());
        scrollMesas.getVerticalScrollBar().setBackground(Color.WHITE);
        panelMPendientes.add(scrollMesas, BorderLayout.CENTER);
        
        //Designacion de los items de los comboBox
        
        cbDomicilios.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Realizado", "Pendiente", "En Proceso"}));
        cbDomicilios.setSelectedIndex(-1);
        cbDomicilios.setLabeText("Estado");
        
        cbMesas.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Realizado", "Pendiente", "En Proceso"}));
        cbMesas.setSelectedIndex(-1);
        cbMesas.setLabeText("Estado");

        CardPedido newPedido1 = new CardPedido();
        newPedido1.setDatos(new Pedido("#0001p1","Mesa #1",TIPO.LOCAL,Estado.PENDIENTE,""));
        mapMesasPedidos.put(newPedido1.getCliente(), newPedido1);

        CardPedido newPedido2 = new CardPedido();
        newPedido2.setDatos(new Pedido("#0002","David",TIPO.ENVIO,Estado.PENDIENTE,""));
        mapDomicilios.put(newPedido2.getCliente(), newPedido2);
        CardPedido newPedido3 = new CardPedido();
        newPedido3.setDatos(new Pedido("#0003","Luis",TIPO.ENVIO,Estado.ENPROCESO,""));
        mapDomicilios.put(newPedido3.getCliente(), newPedido3);
        CardPedido newPedido4 = new CardPedido();
        newPedido4.setDatos(new Pedido("#0004","Miguel",TIPO.LOCAL,Estado.REALIZADO,""));
        mapDomicilios.put(newPedido4.getCliente(), newPedido4);
        
        int indexDomicilios = cbDomicilios.getSelectedIndex();
        if(indexDomicilios == -1){
            for(CardPedido pedido:mapDomicilios.values()){
                if(pedido.getEstado() == Pedido.Estado.PENDIENTE){
                    agregarDomicilio(pedido);
                }
            }
        }
        
        int indexMesas = cbMesas.getSelectedIndex();
        if(indexMesas == -1){
            for(CardPedido pedido:mapMesasPedidos.values()){
                if(pedido.getEstado() == Pedido.Estado.PENDIENTE){
                    agregarMesa(pedido);
                }
            }
        }
    }

    @Override
    public void actualizarEstado(String cliente, Pedido.Estado estado, int clase) {
        repaint();
        if(clase == 1){
            CardPedido cardPedido = mapDomicilios.get(cliente);
            cardPedido.setEstado(estado);
            listMesasPanel.removeAll();
            cbMesas.setSelectedIndex(-1);
            listMesasPanel.remove(cardPedido);
            listMesasPanel.revalidate();
            listMesasPanel.repaint();
        } else if(clase == 2){
            CardPedido cardPedido = mapMesasPedidos.get(cliente);
            cardPedido.setEstado(estado);
            listDomiciliosPanel.revalidate();
            listDomiciliosPanel.remove(cardPedido);
            listDomiciliosPanel.repaint();
        }
    }
    
    //Clase para personalizar el GridLayout con gap vertical 
    public static class GridLayoutWithGap extends GridLayout {
        private int verticalgap;

        public GridLayoutWithGap(int rows, int cols, int horizontalgap, int verticalgap) {
            super(rows, cols, horizontalgap, verticalgap);
            this.verticalgap = verticalgap;
        }

        @Override
        public int getVgap() {
            return verticalgap;
        }
    }
    
    public void agregarDomicilio(CardPedido cardPedido){
        cardPedido.setButtonListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                listDomiciliosPanel.remove(cardPedido);
                repaint();
                mapDomicilios.remove(cardPedido.getCliente());
            }
        });
        cardPedido.addMouseListener(crearMouseListener(cardPedido,1));
        listDomiciliosPanel.add(cardPedido);
        listDomiciliosPanel.revalidate();
        listDomiciliosPanel.repaint();
    }
    
    public void agregarMesa(CardPedido cardPedido){
        cardPedido.setButtonListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                listMesasPanel.remove(cardPedido);
                repaint();
                mapMesasPedidos.remove(cardPedido.getCliente());
            }
        });
        cardPedido.addMouseListener(crearMouseListener(cardPedido,2));
        listMesasPanel.add(cardPedido);
        listMesasPanel.revalidate();
        listMesasPanel.repaint();
    }
    
    private MouseListener crearMouseListener(CardPedido cardPedido, int clase) {
        return new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formPedidos.setCodigo(cardPedido.getCodigo());
                formPedidos.setCliente(cardPedido.getCliente());
                formPedidos.setEstado(cardPedido.getEstado());
                formPedidos.setNotas(cardPedido.getNotas());
                formPedidos.setListaProductos(cardPedido.getListaProductos());
                formPedidos.setPedido(cardPedido.getPedido());
                formPedidos.setClase(clase);
                formPedidos.setPedidoListener(Page_Pedidos.this);
                formPedidos.setVisible(true);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (evt.getSource() instanceof CardPedido) {
                    CardPedido pedido = (CardPedido) evt.getSource();
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    pedido.setBorderColor(Color.RED);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (evt.getSource() instanceof CardPedido) {
                    CardPedido pedido = (CardPedido) evt.getSource();
                    pedido.setBorderColor(Color.WHITE);
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        };
    }

    public void limpiarForm(int clase){
        if(clase == 1){
            cbDomicilios.setSelectedIndex(-1);
            listMesasPanel.removeAll();
            listMesasPanel.revalidate();
            listMesasPanel.repaint();
        } else if(clase == 2){
            cbMesas.setSelectedIndex(-1);
            listDomiciliosPanel.removeAll();
            listDomiciliosPanel.revalidate();
            listDomiciliosPanel.repaint(); 
        }
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new View.Swing.PanelBorder();
        panelDomicilios = new View.Swing.PanelRedondeado();
        panelDPendientes = new View.Swing.PanelBorder();
        jlDomicilios = new javax.swing.JLabel();
        cbDomicilios = new View.Swing.ComboBoxCustom();
        panelMesas = new View.Swing.PanelRedondeado();
        panelMPendientes = new View.Swing.PanelBorder();
        jlMesas = new javax.swing.JLabel();
        cbMesas = new View.Swing.ComboBoxCustom();

        panelDPendientes.setLayout(new java.awt.BorderLayout());

        jlDomicilios.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jlDomicilios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDomicilios.setText("Domicilios");

        cbDomicilios.setBackground(new java.awt.Color(246, 246, 246));

        javax.swing.GroupLayout panelDomiciliosLayout = new javax.swing.GroupLayout(panelDomicilios);
        panelDomicilios.setLayout(panelDomiciliosLayout);
        panelDomiciliosLayout.setHorizontalGroup(
            panelDomiciliosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDomiciliosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDomiciliosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlDomicilios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDomiciliosLayout.createSequentialGroup()
                        .addComponent(cbDomicilios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 236, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDomiciliosLayout.setVerticalGroup(
            panelDomiciliosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDomiciliosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlDomicilios, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cbDomicilios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelDPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMPendientes.setLayout(new java.awt.BorderLayout());

        jlMesas.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jlMesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMesas.setText("Mesas");

        cbMesas.setBackground(new java.awt.Color(246, 246, 246));

        javax.swing.GroupLayout panelMesasLayout = new javax.swing.GroupLayout(panelMesas);
        panelMesas.setLayout(panelMesasLayout);
        panelMesasLayout.setHorizontalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMesasLayout.createSequentialGroup()
                        .addComponent(cbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 238, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelMesasLayout.setVerticalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelMPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDomicilios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDomicilios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Swing.ComboBoxCustom cbDomicilios;
    private View.Swing.ComboBoxCustom cbMesas;
    private javax.swing.JLabel jlDomicilios;
    private javax.swing.JLabel jlMesas;
    private View.Swing.PanelBorder panelDPendientes;
    private View.Swing.PanelRedondeado panelDomicilios;
    private View.Swing.PanelBorder panelMPendientes;
    private View.Swing.PanelRedondeado panelMesas;
    private View.Swing.PanelBorder panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
