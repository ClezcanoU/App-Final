
package Modelo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends ElementoRestaurante{
    
    private Timestamp fecha;
    private String codigo;
    private String pedido;
    private String cliente;
    private TIPO tipo;
    private Estado estado;
    private List<Producto> listaProductos = new ArrayList<>();
    private String Notas;
    
    
    public static enum TIPO {
        LOCAL, ENVIO
    }
    
    public static enum Estado {
        REALIZADO, PENDIENTE, ENPROCESO
    }

    //Constructores
    
    public Pedido(Timestamp fecha, String cliente, TIPO tipo, int id) {
        super(id);
        this.fecha = fecha;
        this.cliente = cliente;
        this.tipo = tipo;
    }

    public Pedido(String codigo, String cliente, TIPO tipo, Estado estado) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Pedido(String codigo, String cliente, TIPO tipo, Estado estado, String Notas) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.tipo = tipo;
        this.estado = estado;
        this.Notas = Notas;
    }
    
    
    
    //Getters and Setters

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
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
    }

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getNotas() {
        return Notas;
    }

    public void setNotas(String Notas) {
        this.Notas = Notas;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
    
    

}
