
package View.pages;

import ModelView.ControlMesas;
import ModelView.InfoUpdate;
import ModelView.MesaListener;
import Modelo.Producto;
import View.Component.Notificacion;
import View.Swing.ScrollBarCustom2;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Form_Mesas extends javax.swing.JFrame implements InfoUpdate{

    private String titulo;
    private String factura;
    private String productos;
    private String notas;
    
    private List<Producto> listaProductos = new ArrayList<>();
    
    private int index=1;
    
    //Variables para obtener la fecha y hora
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss a");
    DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("EEEE dd-MM-yyyy");

    //Establece e formato de la fecha y hora
    String horaActual = now.format(formatterHora);
    String fechaActual = now.format(formatterFecha).substring(0, 1).toUpperCase() + now.format(formatterFecha).substring(1);
    
    private Form_TomarOrden tomarOrden;

    //Getters and Setters
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        Titulo.setText(titulo);
    }

    public void setFactura(String factura) {
        jtFactura.setText(factura);
    }

    public void setProductos(String productos) {
        jtProductos.setText(productos);
    }

    public void setNotas(String notas) {
        jtNotas.setText(notas);
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    private MesaListener mesaListener;
    
    public void setMesaListener(MesaListener listener) {
        this.mesaListener = listener;
    }
   
    //Constructor
    public Form_Mesas() {
        initComponents();
        headerMoving.initMoving(Form_Mesas.this);//LLamado para poder mover el frame
        tomarOrden = new Form_TomarOrden();
        tomarOrden.setInfoUpdate(this);
        
        //Configuracion a los srolls agrego el personalizado
        
        jScrollFactura.getViewport().setBackground(Color.WHITE);
        jScrollFactura.setVerticalScrollBar(new ScrollBarCustom2());
        jScrollFactura.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollFactura.setHorizontalScrollBar(new ScrollBarCustom2());
        jScrollFactura.getHorizontalScrollBar().setBackground(Color.WHITE);
        
        jScrollProductos.getViewport().setBackground(Color.WHITE);
        jScrollProductos.setVerticalScrollBar(new ScrollBarCustom2());
        jScrollProductos.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollProductos.setHorizontalScrollBar(new ScrollBarCustom2());
        jScrollProductos.getHorizontalScrollBar().setBackground(Color.WHITE);
        
        
        jScrollNotas.getViewport().setBackground(Color.WHITE);
        jScrollNotas.setVerticalScrollBar(new ScrollBarCustom2());
        jScrollNotas.getVerticalScrollBar().setBackground(Color.WHITE);
    }
    
    //Metodo para cambiar el color del header
    
    public void cambiarColor(Color color){
        headerMoving.setColor(color);
        headerMoving.setBackground(headerMoving.getColor());
        repaint();
    }
    
    //Metodo para actualizar los textarea
    public void actualizarCard(List<Producto> listaP){
        listaProductos =listaP;
        mesaListener.ocuparMesa(Titulo.getText(),true,listaProductos);
        jtFactura.setText("╔═════════════  El Cabrito  ════════════╗\n"
                + "║  Hora: " + horaActual + "       `Dia: " + fechaActual + "      ║\n"
                +"╠════════════════════════════════ ╣\n"
                +"║        Nombre Item:                     "+"`Precio($)                         ║\n"
                +"║════════════════════════════════ ║"
        );
        jtProductos.setText("╔═══════════════  El  Cabrito  ═══════════════╗\n"
                +"╠ ═════════════════════════════════════ ╣\n"
                +"║        Nombre Item:                                            "+"`Cantidad                  ║\n"
                +"║ ═════════════════════════════════════ ║"
        );
        jtNotas.setText("╔══════════════════   El  Cabrito   ════════════════╗\n");
        
        //Agrega los productos al pedido y la factura
        setListaProductos(listaProductos);
        for (Producto producto : listaProductos) {
            String textFactura = "║   " + index+". "+producto.getNombre()+" x"+producto.getCantidad()+"\t"+(int)producto.getPrecio();
            String textPedido = "║   " + index+". "+producto.getNombre()+"\t\t"+producto.getCantidad();
            jtFactura.setText(jtFactura.getText()+"\n"+textFactura);
            jtProductos.setText(jtProductos.getText()+"\n"+textPedido);
            index++;
        }
        index=1;
        
        //Agrega el total a pagar a la factura
        
        jtProductos.setText(jtProductos.getText()+"\n║\n╚ ═════════════════════════════════════ ╝");
        double totalFactura = ControlMesas.calcularFactura(listaProductos);
        jtFactura.setText(jtFactura.getText()+"\n╠════════════════════════════════╣");
        jtFactura.setText(jtFactura.getText()+"\n"+"║"+"\n"+"║   Total a Pagar:"+"                      "+"\t"+(int)totalFactura);
        jtFactura.setText(jtFactura.getText()+"\n╚════════════════════════════════╝");
        repaint();
    }
    
    //Actualiza la informacion de la lista de productos
    
    @Override
    public void actualizarInfo(List<Producto> listaP) {
        actualizarCard(listaP);
        Notificacion panel = new Notificacion(Form_Mesas.this, Notificacion.Type.SUCCESS, Notificacion.Location.TOP_CENTER, "Orden seleccionada, confirme antes de cerrar");
        panel.showNotification();
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new View.Swing.PanelBorder();
        headerMoving = new View.Component.HeaderMoving();
        Titulo = new javax.swing.JLabel();
        jScrollFactura = new javax.swing.JScrollPane();
        jtFactura = new javax.swing.JTextArea();
        jScrollNotas = new javax.swing.JScrollPane();
        jtNotas = new javax.swing.JTextArea();
        jScrollProductos = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTextArea();
        jbConfirmar = new View.Swing.ModernButton();
        jbCerrar = new View.Swing.ModernButton();
        jbLimpiar = new View.Swing.ModernButton();
        jbTomarPedido = new View.Swing.ModernButton();
        jbImprimir = new View.Swing.ModernButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

        Titulo.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("#1");

        jtFactura.setColumns(20);
        jtFactura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtFactura.setRows(5);
        jScrollFactura.setViewportView(jtFactura);

        jtNotas.setColumns(20);
        jtNotas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtNotas.setLineWrap(true);
        jtNotas.setRows(5);
        jScrollNotas.setViewportView(jtNotas);

        jtProductos.setColumns(20);
        jtProductos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtProductos.setRows(5);
        jScrollProductos.setViewportView(jtProductos);

        jbConfirmar.setText("Confirmar Orden");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbTomarPedido.setText("Tomar Pedido");
        jbTomarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTomarPedidoActionPerformed(evt);
            }
        });

        jbImprimir.setText("Imprimir");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("---------- NOTAS ---------");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("---- FACTURA ----");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("-------- PEDIDO --------");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(172, 172, 172)
                                        .addComponent(jbConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                                                    .addComponent(jScrollNotas))
                                                .addGap(49, 49, 49)))))
                                .addGap(0, 31, Short.MAX_VALUE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(98, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbTomarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170))))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(headerMoving, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Titulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jScrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbTomarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        //Limpiar todo el panel
        if (mesaListener != null) {
            mesaListener.limpiarMesa(Titulo.getText());
            jtFactura.setText("");
            jtNotas.setText("");
            jtProductos.setText("");
            //AQUI TOCA ES ENVIARLO A UNA FUNCION QUE LO GUARDE EN LA BASE DE DATOS
            mesaListener.actualizarNotas(Titulo.getText(), jtNotas.getText());
            mesaListener.actualizarProductos(Titulo.getText(), jtProductos.getText(),listaProductos);
            mesaListener.actualizarFactura(Titulo.getText(), jtFactura.getText());
        }
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbTomarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTomarPedidoActionPerformed
        //Abre el form para tomar el pedido
        if (mesaListener != null) {
            mesaListener.ocuparMesa(Titulo.getText(),false,getListaProductos());
            tomarOrden.setVisible(true);
        }
    }//GEN-LAST:event_jbTomarPedidoActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        //Confirma la orden y la envia
        if (mesaListener != null) {
            mesaListener.actualizarNotas(Titulo.getText(), jtNotas.getText());
            mesaListener.actualizarProductos(Titulo.getText(), jtProductos.getText(),listaProductos);
            mesaListener.actualizarFactura(Titulo.getText(), jtFactura.getText());
            mesaListener.ocuparMesa(Titulo.getText(),true,listaProductos);
            mesaListener.mensajeNotificacion();
            dispose();
        }
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        try {
            //Sale el mensaje para imprimir
            generarFacturaPDF("MiFactura.pdf", jtFactura.getText());
            Notificacion panel = new Notificacion(Form_Mesas.this, Notificacion.Type.SUCCESS, Notificacion.Location.BOTTOM_LEFT, "Factura Generada Correctamente");
            panel.showNotification();
        } catch (IOException ex) {
            Logger.getLogger(Form_Mesas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbImprimirActionPerformed

    public static void generarFacturaPDF(String nombreArchivo, String contenido) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(nombreArchivo)) {
            // Encabezado PDF
            outputStream.write("%PDF-1.4\n".getBytes());
            outputStream.write("1 0 obj\n".getBytes());
            outputStream.write("<< /Title (Factura) /Creator (GeneradorPDF) >>\n".getBytes());
            outputStream.write("endobj\n".getBytes());

            // Página PDF
            outputStream.write("2 0 obj\n".getBytes());
            outputStream.write("<< /Type /Page /Parent 1 0 R /Resources << /Font << /F1 3 0 R >> >> /Contents 4 0 R >>\n".getBytes());
            outputStream.write("endobj\n".getBytes());

            // Fuente PDF
            outputStream.write("3 0 obj\n".getBytes());
            outputStream.write("<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica >>\n".getBytes());
            outputStream.write("endobj\n".getBytes());

            // Contenido de la página PDF
            outputStream.write("4 0 obj\n".getBytes());
            outputStream.write("<< /Length 55 >>\n".getBytes());
            outputStream.write("stream\n".getBytes());
            outputStream.write("BT\n/F1 12 Tf\n72 720 Td\n".getBytes());
            outputStream.write("(".getBytes());
            outputStream.write(contenido.getBytes());
            outputStream.write(") Tj\nET\nendstream\n".getBytes());
            outputStream.write("endobj\n".getBytes());

            // Catálogo PDF
            outputStream.write("1 0 obj\n".getBytes());
            outputStream.write("<< /Type /Catalog /Pages 2 0 R >>\n".getBytes());
            outputStream.write("endobj\n".getBytes());

            // Fin del archivo PDF
            outputStream.write("xref\n".getBytes());
            outputStream.write("0 5\n".getBytes());
            outputStream.write("0000000000 65535 f \n".getBytes());
            outputStream.write("0000000015 00000 n \n".getBytes());
            outputStream.write("0000000074 00000 n \n".getBytes());
            outputStream.write("0000000176 00000 n \n".getBytes());
            outputStream.write("0000000457 00000 n \n".getBytes());
            outputStream.write("trailer\n".getBytes());
            outputStream.write("<< /Root 1 0 R /Size 5 >>\n".getBytes());
            outputStream.write("startxref\n".getBytes());
            outputStream.write("516\n".getBytes());
            outputStream.write("%%EOF\n".getBytes());
        }
    }
    
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
            java.util.logging.Logger.getLogger(Form_Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Mesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private View.Component.HeaderMoving headerMoving;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollFactura;
    private javax.swing.JScrollPane jScrollNotas;
    private javax.swing.JScrollPane jScrollProductos;
    private View.Swing.ModernButton jbCerrar;
    private View.Swing.ModernButton jbConfirmar;
    private View.Swing.ModernButton jbImprimir;
    private View.Swing.ModernButton jbLimpiar;
    private View.Swing.ModernButton jbTomarPedido;
    private javax.swing.JTextArea jtFactura;
    private javax.swing.JTextArea jtNotas;
    private javax.swing.JTextArea jtProductos;
    private View.Swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
