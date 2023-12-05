
package View.pages;

import ModelView.PedidoListener;
import Modelo.Pedido;
import Modelo.Producto;
import View.Swing.ScrollBarCustom2;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;


public class Form_Pedidos extends javax.swing.JFrame {

    private String codigo;
    private String pedido;
    private String cliente;
    private Pedido.Estado estado;
    private List<Producto> listaProductos = new ArrayList<>();
    private String notas;
    private int clase;
    
    private int index=1;
    
    private PedidoListener pedidoListener;

    public void setPedidoListener(PedidoListener pedidoListener) {
        this.pedidoListener = pedidoListener;
    }

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
        jlCliente.setText(cliente);
    }

    public Pedido.Estado getEstado() {
        return estado;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
        mostrarPedido(pedido);
    }
    
    

    public void setEstado(Pedido.Estado estado) {
        this.estado = estado;
        if(estado == Pedido.Estado.REALIZADO){
            cbEstado.setSelectedIndex(0);
        } else if(estado == Pedido.Estado.PENDIENTE){
            cbEstado.setSelectedIndex(1);
        }else if(estado == Pedido.Estado.ENPROCESO){
            cbEstado.setSelectedIndex(2);
        }
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
        jtNotas.setText(notas);
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }
    
    public Form_Pedidos() {
        initComponents();
        headerMoving.initMoving(Form_Pedidos.this);//LLamado para poder mover el frame
        headerMoving.setColor(new Color(150,24,24));
        jbCambiar.setBackgroundColor(new Color(0,126,196));
        
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Realizado", "Pendiente", "En Proceso"}));
        cbEstado.setSelectedIndex(-1);
        cbEstado.setLabeText("Estado");
        
        jScrollPedido.getViewport().setBackground(Color.WHITE);
        jScrollPedido.setVerticalScrollBar(new ScrollBarCustom2());
        jScrollPedido.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPedido.setHorizontalScrollBar(new ScrollBarCustom2());
        jScrollPedido.getHorizontalScrollBar().setBackground(Color.WHITE);
        
    }
    
    public void mostrarPedido(String pedido){
        jtPedido.setText("╔═══════════════  El  Cabrito  ═══════════════╗\n"
                +"╠ ═════════════════════════════════════ ╣\n"
                +"║        Nombre Item:                                            "+"`Cantidad                  ║\n"
                +"║ ═════════════════════════════════════ ║"
        );
        jtPedido.setText(pedido);
        for (Producto producto : listaProductos) {
            String textPedido = "║   " + index+". "+producto.getNombre()+"\t\t"+producto.getCantidad();
            jtPedido.setText(jtPedido.getText()+"\n"+textPedido);
            index++;
        }
        index=1;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new View.Swing.PanelBorder();
        headerMoving = new View.Component.HeaderMoving();
        jScrollPedido = new javax.swing.JScrollPane();
        jtPedido = new javax.swing.JTextArea();
        jlCliente = new javax.swing.JLabel();
        jbCerrar = new View.Swing.ModernButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtNotas = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbEstado = new View.Swing.ComboBoxCustom();
        jLabel3 = new javax.swing.JLabel();
        jbCambiar = new View.Swing.ModernButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

        headerMoving.setBackground(new java.awt.Color(150, 24, 24));

        jtPedido.setEditable(false);
        jtPedido.setColumns(20);
        jtPedido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtPedido.setRows(5);
        jScrollPedido.setViewportView(jtPedido);

        jlCliente.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jlCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCliente.setText("Cliente");

        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        jtNotas.setEditable(false);
        jtNotas.setColumns(20);
        jtNotas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtNotas.setLineWrap(true);
        jtNotas.setRows(5);
        jScrollPane2.setViewportView(jtNotas);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("---------- PEDIDO ----------");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("-------------- NOTAS --------------");

        cbEstado.setBackground(new java.awt.Color(246, 246, 246));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("Cambiar Estado:");

        jbCambiar.setBackground(new java.awt.Color(0, 126, 196));
        jbCambiar.setText("---->");
        jbCambiar.setFont(new java.awt.Font("Impact", 1, 14)); // NOI18N
        jbCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(jlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPedido)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(headerMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(headerMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jbCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void jbCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCambiarActionPerformed
        int index = cbEstado.getSelectedIndex();
        if(index == 0){
            pedidoListener.actualizarEstado(cliente, Pedido.Estado.REALIZADO, clase);
        } else if(index == 1){
            pedidoListener.actualizarEstado(cliente, Pedido.Estado.PENDIENTE, clase);
        } else if(index == 2){
            pedidoListener.actualizarEstado(cliente, Pedido.Estado.ENPROCESO, clase);
        }
    }//GEN-LAST:event_jbCambiarActionPerformed


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
            java.util.logging.Logger.getLogger(Form_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Swing.ComboBoxCustom cbEstado;
    private View.Component.HeaderMoving headerMoving;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPedido;
    private View.Swing.ModernButton jbCambiar;
    private View.Swing.ModernButton jbCerrar;
    private javax.swing.JLabel jlCliente;
    private javax.swing.JTextArea jtNotas;
    private javax.swing.JTextArea jtPedido;
    private View.Swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
