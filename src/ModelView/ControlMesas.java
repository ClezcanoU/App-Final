
package ModelView;

import Modelo.Producto;
import java.util.List;

public class ControlMesas {
    
    //Calcula los porcentajes de cada barra de las mesas
    static public int calcularPorcentaje(int cantidadEstado, int mesas){
        double porcentaje = (cantidadEstado * 100)/mesas;
        return (int) porcentaje;
    }
    
    //Calcula el valor de la factura de los productos que le ingresan
    static public double calcularFactura(List<Producto> productos){
        double totalPagar = 0;
        for (Producto producto : productos) {
            if(producto.getCantidad()>1){
                totalPagar += (producto.getPrecio()*producto.getCantidad());
            }else{
                totalPagar += producto.getPrecio(); 
            }
        }
        return totalPagar;
    }
}
