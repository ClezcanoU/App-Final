
package View.Component;

import View.Swing.PictureBox;
import javax.swing.Icon;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class CardMenu extends javax.swing.JPanel {

    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;
    private String descripcion;

    public CardMenu() {
        initComponents();
    }
    
    public void setDatos(String nombre,double precio,String categoria,String descripcion){
        this.nombre = nombre;
        jlNombre.setText(nombre);
        this.precio = precio;
        jlPrecio.setText(String.valueOf(precio));
        this.descripcion = descripcion;
        jtDesripcion.setText("");
        jtDesripcion.setText("Descripcion: "+descripcion);
        this.categoria = categoria;
        // Obtener el borde actual del componente
        Border border = getBorder();

        // Verificar si el borde es un TitledBorder
        if (border instanceof TitledBorder) {
            // Castear el borde a TitledBorder
            TitledBorder titledBorder = (TitledBorder) border;

            // Cambiar el texto del título
            titledBorder.setTitle(categoria);

            // Repintar el componente para reflejar el cambio
            repaint();
        }
    }

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
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    public void setImage(Icon imagen) {
        pictureBox1.setImage(imagen);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureBox1 = new View.Swing.PictureBox();
        jlNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDesripcion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jlPrecio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/tarta.png"))); // NOI18N

        jlNombre.setText("Nombre");

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jtDesripcion.setColumns(20);
        jtDesripcion.setLineWrap(true);
        jtDesripcion.setRows(5);
        jtDesripcion.setText("Descripcion aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        jtDesripcion.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jtDesripcion);

        jLabel2.setText("Precio: ");

        jlPrecio.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jlPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlPrecio;
    private javax.swing.JTextArea jtDesripcion;
    private View.Swing.PictureBox pictureBox1;
    // End of variables declaration//GEN-END:variables
}
