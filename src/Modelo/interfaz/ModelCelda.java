
package Modelo.interfaz;

import com.raven.table.model.TableRowData;

public class ModelCelda extends TableRowData {

    private int id;
    private String codigo;
    private String nombreProducto;
    private int cantidad;
    private String ubicacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ModelCelda() {
    }

    public ModelCelda(int id, String codigo, String nombreProducto, int cantidad, String ubicacion) {
        this.id = id;
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }
    
    
    @Override
    public Object[] toTableRow() {
        return new Object[]{codigo, nombreProducto, cantidad, ubicacion};
    }
}
