
package Modelo;

import javax.swing.Icon;

public class Mesa  extends ElementoRestaurante{
    
    private String numero;
    private Estado estado;
    private String pedido;
    private String factura;
    private String nota;
    
    public static enum Estado {
        LIBRE, OCUPADO, MANTENIMIENTO
    }

    //Constructores
    
    public Mesa(String numero, Estado estado, String pedido, String factura, String nota, int id, String codigo, String nombre, Icon imagen) {
        super(id, nombre, imagen);
        this.numero = numero;
        this.estado = estado;
        this.pedido = pedido;
        this.factura = factura;
        this.nota = nota;
    }

    public Mesa(String nombre, String numero, Estado estado ,Icon imagen, String pedido, String factura, String nota) {
        super(imagen, nombre);
        this.numero = numero;
        this.estado = estado;
        this.pedido = pedido;
        this.factura = factura;
        this.nota = nota;
    }
    
    //Getters and Setters

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    
}
