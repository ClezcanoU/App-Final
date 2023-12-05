
package View.pages;

import ModelView.InfoUpdate;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.SQLConeccion;
import View.Component.CardProducto;
import View.Component.Notificacion;
import View.Swing.ScrollBarCustom2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class Form_TomarOrden extends javax.swing.JFrame {

    private JPanel cardsPanel;
    private List<CardProducto> listaCards = new ArrayList<>();
    private List<Producto> listaProductos = new ArrayList<>();
    private Form_Mesas mesas;

    private int index=1;
    SQLConeccion sqlConeccion = new SQLConeccion();
    
    //Variables para obtener la fecha y hora
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss a");
    DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("EEEE dd-MM-yyyy");

    //Establece e formato de la fecha y hora
    String horaActual = now.format(formatterHora);
    String fechaActual = now.format(formatterFecha).substring(0, 1).toUpperCase() + now.format(formatterFecha).substring(1);
    
    private InfoUpdate infoUpdate;

    public void setInfoUpdate(InfoUpdate infoUpdate) {
        this.infoUpdate = infoUpdate;
    }
   
    public Form_TomarOrden() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        headerMoving.initMoving(Form_TomarOrden.this);//LLamado para poder mover el frame
        headerMoving.setColor(new Color(0,153,153));
        setLocationRelativeTo(null);
        
        init();
        
        //Item listener para el comboBox de categoria
        ItemListener categoriaListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cbAnexos.setSelectedIndex(-1);
                    int index = cbCategoria.getSelectedIndex();
                    
                    //Seleccion y agregacion de los productos por categoria
                    if (index == 0){
                        List<Producto> productos = new ProductoDAO(sqlConeccion).obtenerProductosPorCategoria("Entradas");
                        for (int i = 0; i < productos.size(); i++) {
                            CardProducto newProduct = new CardProducto();
                            Producto producto = productos.get(i);

                            // Configurar la CardProducto con los datos del producto
                            newProduct.setDatos(producto);

                            // Agregar la CardProducto a la lista
                            listaCards.add(newProduct);
                        }
                        agregarCard(listaCards); 
                    } else if(index == 1){
                        List<Producto> productos = new ProductoDAO(sqlConeccion).obtenerProductosPorCategoria("Especiales");
                        for (int i = 0; i < productos.size(); i++) {
                            CardProducto newProduct = new CardProducto();
                            Producto producto = productos.get(i);

                            // Configurar la CardProducto con los datos del producto
                            newProduct.setDatos(producto);

                            // Agregar la CardProducto a la lista
                            listaCards.add(newProduct);
                        }
                        agregarCard(listaCards);   
                    } else if(index == 2){
                        List<Producto> productos = new ProductoDAO(sqlConeccion).obtenerProductosPorCategoria("Sopas");
                        for (int i = 0; i < productos.size(); i++) {
                            CardProducto newProduct = new CardProducto();
                            Producto producto = productos.get(i);

                            // Configurar la CardProducto con los datos del producto
                            newProduct.setDatos(producto);

                            // Agregar la CardProducto a la lista
                            listaCards.add(newProduct);
                        }
                        agregarCard(listaCards); 
                    } else if(index == 3){
                        List<Producto> productos = new ProductoDAO(sqlConeccion).obtenerProductosPorCategoria("Bebidas");
                        for (int i = 0; i < productos.size(); i++) {
                            CardProducto newProduct = new CardProducto();
                            Producto producto = productos.get(i);

                            // Configurar la CardProducto con los datos del producto
                            newProduct.setDatos(producto);

                            // Agregar la CardProducto a la lista
                            listaCards.add(newProduct);
                        }
                        agregarCard(listaCards);   
                    } else if(index == 4){
                        List<Producto> productos = new ProductoDAO(sqlConeccion).obtenerProductosPorCategoria("Postres");
                        for (int i = 0; i < productos.size(); i++) {
                            CardProducto newProduct = new CardProducto();
                            Producto producto = productos.get(i);

                            // Configurar la CardProducto con los datos del producto
                            newProduct.setDatos(producto);

                            // Agregar la CardProducto a la lista
                            listaCards.add(newProduct);
                        }
                        agregarCard(listaCards); 
                    }
                }
            }
        };
        
        //Item listener para el comboBox de anexos
        ItemListener anexosListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cbCategoria.setSelectedIndex(-1);
                    int index = cbAnexos.getSelectedIndex();
                    CardProducto newProduct = new CardProducto();
                    
                    //Seleccion y agregacion de los productos por categoria
                    if (index == 0){
                        List<Producto> productos = new ProductoDAO(sqlConeccion).obtenerProductosPorCategoria("Salsas");
                        for (int i = 0; i < productos.size(); i++) {
                            CardProducto newProduct2 = new CardProducto();
                            Producto producto = productos.get(i);

                            // Configurar la CardProducto con los datos del producto
                            newProduct2.setDatos(producto);

                            // Agregar la CardProducto a la lista
                            listaCards.add(newProduct2);
                        }
                        agregarCard(listaCards); 
                    } else if(index == 1){
                        List<Producto> productos = new ProductoDAO(sqlConeccion).obtenerProductosPorCategoria("Porciones");
                        for (int i = 0; i < productos.size(); i++) {
                            CardProducto newProduct2 = new CardProducto();
                            Producto producto = productos.get(i);

                            // Configurar la CardProducto con los datos del producto
                            newProduct2.setDatos(producto);

                            // Agregar la CardProducto a la lista
                            listaCards.add(newProduct2);
                        }
                        agregarCard(listaCards);  
                    } else if(index == 2){
                        List<Producto> productos = new ProductoDAO(sqlConeccion).obtenerProductosPorCategoria("Acompañantes");
                        for (int i = 0; i < productos.size(); i++) {
                            CardProducto newProduct2 = new CardProducto();
                            Producto producto = productos.get(i);

                            // Configurar la CardProducto con los datos del producto
                            newProduct2.setDatos(producto);

                            // Agregar la CardProducto a la lista
                            listaCards.add(newProduct2);
                        }
                        agregarCard(listaCards); 
                    }
                }
            }
        };
        cbCategoria.addItemListener(categoriaListener);
        cbAnexos.addItemListener(anexosListener);
    }
    
    private void init(){
        
        cardsPanel = new JPanel(new GridLayoutWithGap(20, 1, 0, 4));
        JScrollPane scrollProductos = new JScrollPane(cardsPanel);
        
        //Configuracion a los srolls agrego el personalizado
        
        scrollProductos.setBorder(null);
        scrollProductos.getViewport().setBackground(Color.WHITE);
        scrollProductos.setVerticalScrollBar(new ScrollBarCustom2());
        scrollProductos.getVerticalScrollBar().setBackground(Color.WHITE);
        
        jsPedido.getViewport().setBackground(Color.WHITE);
        jsPedido.setVerticalScrollBar(new ScrollBarCustom2());
        jsPedido.getVerticalScrollBar().setBackground(Color.WHITE);
        jsPedido.setHorizontalScrollBar(new ScrollBarCustom2());
        jsPedido.getHorizontalScrollBar().setBackground(Color.WHITE);
        
        panelProductos.add(scrollProductos, BorderLayout.CENTER);
        
        //Designacion de los items de los comboBox
        
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Entradas", "Especiales", "Sopas", "Bebidas", "Postres"}));
        cbCategoria.setSelectedIndex(-1);
        cbCategoria.setLabeText("Categoria");
        
        cbAnexos.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Salsas", "Porciones", "Acompañantes"}));
        cbAnexos.setSelectedIndex(-1);
        cbAnexos.setLabeText("Anexos");
        
        limpiarForm();
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
    
    //Agrega las cards de los productos
    public void agregarCard(List<CardProducto> cards) {
        cardsPanel.removeAll();
        for (CardProducto card : cards) {
            card.setButtonListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    //Verifica que la cantidad sea mayor a 0 para agregar a la orden
                    if(card.getCantidad()>0){
                        actualizarOrden(card);
                    }else{
                        Notificacion panel = new Notificacion(Form_TomarOrden.this, Notificacion.Type.WARNING, Notificacion.Location.CENTER, "La cantidad tiene que ser mayor a 0");
                        panel.showNotification();
                    }
                }
            });
            cardsPanel.add(card);
        }
        cardsPanel.revalidate();
        cardsPanel.repaint();
        listaCards.clear();
    }
    
    //Limpia todo el frame
    public void limpiarForm(){
        index=1;
        listaCards.clear();
        listaProductos.clear();
        cardsPanel.removeAll();
        cbCategoria.setSelectedIndex(-1);
        cbAnexos.setSelectedIndex(-1);
        jtPedido.setText("╔═════════════  El Cabrito  ════════════╗\n"
                + "║  Hora: " + horaActual + "       `Dia: " + fechaActual + "      ║\n"
                +"╠════════════════════════════════ ╣\n"
                +"║        Nombre Item:                   "+"`Precio($)                           ║\n"
                +"║════════════════════════════════ ║"
        );
        repaint();
    }

    //Envia los datos de la orden a las cards de las mesas
    public void actualizarOrden(CardProducto card){
        Producto agregarProducto = new Producto(card.getNombre(),card.getCodigo(),card.getCategoria(),card.getCantidad(),card.getPrecio());
        listaProductos.add(agregarProducto);
        String textoLinea = index+". "+card.getNombre()+" x"+card.getCantidad()+"\t"+(int)card.getPrecio();
        textoLinea = "║   " + textoLinea.trim();
        jtPedido.setText(jtPedido.getText()+"\n"+textoLinea);
        index++;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRedondeado1 = new View.Swing.PanelRedondeado();
        jbCerrar = new View.Swing.ModernButton();
        headerMoving = new View.Component.HeaderMoving();
        jlTitulo = new javax.swing.JLabel();
        jsPedido = new javax.swing.JScrollPane();
        jtPedido = new javax.swing.JTextArea();
        jbConfirmar = new View.Swing.ModernButton();
        jLabel1 = new javax.swing.JLabel();
        cbCategoria = new View.Swing.ComboBoxCustom();
        cbAnexos = new View.Swing.ComboBoxCustom();
        panelProductos = new View.Swing.PanelBorder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        headerMoving.setBackground(new java.awt.Color(0, 153, 153));

        jlTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Tomar Orden");

        jtPedido.setColumns(20);
        jtPedido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtPedido.setRows(5);
        jsPedido.setViewportView(jtPedido);

        jbConfirmar.setText("Confirmar");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("--------- ORDEN ---------");

        cbCategoria.setBackground(new java.awt.Color(246, 246, 246));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        cbAnexos.setBackground(new java.awt.Color(246, 246, 246));
        cbAnexos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAnexosActionPerformed(evt);
            }
        });

        panelProductos.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelRedondeado1Layout = new javax.swing.GroupLayout(panelRedondeado1);
        panelRedondeado1.setLayout(panelRedondeado1Layout);
        panelRedondeado1Layout.setHorizontalGroup(
            panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondeado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondeado1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(panelRedondeado1Layout.createSequentialGroup()
                        .addGroup(panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRedondeado1Layout.createSequentialGroup()
                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(cbAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRedondeado1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                    .addComponent(jsPedido))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondeado1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87))))))
            .addComponent(headerMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRedondeado1Layout.setVerticalGroup(
            panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondeado1Layout.createSequentialGroup()
                .addComponent(headerMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondeado1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnexos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondeado1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(panelRedondeado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRedondeado1Layout.createSequentialGroup()
                        .addComponent(jsPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRedondeado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRedondeado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        //Cierra el frame y lo limpia
        dispose();
        limpiarForm();  
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed

    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void cbAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnexosActionPerformed
        
    }//GEN-LAST:event_cbAnexosActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        //Confirma el envio de los datos y verifica que se hallan agregado productos
        if(listaProductos.isEmpty()){
            Notificacion panel = new Notificacion(Form_TomarOrden.this, Notificacion.Type.WARNING, Notificacion.Location.TOP_CENTER, "Debe agregar productos para confirmar");
            panel.showNotification();
        }else {
            infoUpdate.actualizarInfo(listaProductos);
            dispose();
            limpiarForm();
        }
        
    }//GEN-LAST:event_jbConfirmarActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_TomarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_TomarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_TomarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_TomarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_TomarOrden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Swing.ComboBoxCustom cbAnexos;
    private View.Swing.ComboBoxCustom cbCategoria;
    private View.Component.HeaderMoving headerMoving;
    private javax.swing.JLabel jLabel1;
    private View.Swing.ModernButton jbCerrar;
    private View.Swing.ModernButton jbConfirmar;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JScrollPane jsPedido;
    private javax.swing.JTextArea jtPedido;
    private View.Swing.PanelBorder panelProductos;
    private View.Swing.PanelRedondeado panelRedondeado1;
    // End of variables declaration//GEN-END:variables
}
