
package Modelo;

public class Insumo extends ElementoRestaurante{
    
    private int id;
    private String codigo;
    private int cantidad;
    private double precio;
    private String ubicacion;

    //Constructores
    
    public Insumo(String codigo, int cantidad, double precio, String ubicacion, int id, String nombre) {
        super(id, nombre);
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.ubicacion = ubicacion;
    }

    public Insumo(String codigo, int cantidad, double precio, String ubicacion, String nombre) {
        super(nombre);
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.ubicacion = ubicacion;
    }

    public Insumo(String codigo, int cantidad, String ubicacion, String nombre) {
        super(nombre);
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }
    
    public Insumo() {
    }
    
    //Getters and Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}
