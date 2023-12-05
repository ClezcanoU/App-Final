
package Modelo;

import javax.swing.Icon;

public class Producto extends ElementoRestaurante{
    
    private int cantidad;
    private double precio;
    private String codigo;
    private String categoria;
    
    //Constructores

    public Producto(int cantidad, double precio, int id, String codigo, String nombre, Icon imagen) {
        super(id, nombre, imagen);
        this.cantidad = cantidad;
        this.precio = precio;
    }   

    public Producto(String nombre, String codigo, String categoria, int cantidad, double precio) {
        super(nombre);
        this.codigo = codigo;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    //Getters and Setters

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    @Override
    public String toString() {
        return "Producto{" + "cantidad=" + cantidad + ", precio=" + precio + ", codigo=" + codigo + ", categoria=" + categoria + '}';
    }

    
}
