
package Modelo;

import java.time.LocalDateTime;


public class Factura {
    private int id;
    private LocalDateTime fecha;
    private String cliente;
    private Pedido pedido;
    private double totalPagar;

    public Factura(int id, LocalDateTime fecha, String cliente, Pedido pedido, double totalPagar) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.pedido = pedido;
        this.totalPagar = totalPagar;
    }

    //obtener factura
    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", pedido=" + pedido + ", totalPagar=" + totalPagar + '}';
    }
    
    //cogido sql SELECT * FROM facturas
    
    //INSERT INTO facturas(`ID`, `FECHA`, `CLIENTE`, `TOTAL`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]')

    //DELETE FROM facturas WHERE id
    
    //UPDATE facturas SET `ID`='[value-1]',`FECHA`='[value-2]',`CLIENTE`='[value-3]',`TOTAL`='[value-4]' WHERE id
}
