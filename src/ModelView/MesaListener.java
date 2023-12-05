
package ModelView;

import Modelo.Producto;
import java.util.List;


public interface MesaListener {
    void limpiarMesa(String mesa);
    void ocuparMesa(String mesa, Boolean enviarPedido, List<Producto> listaProductos);
    void actualizarFactura(String mesa, String nuevaFactura);
    void actualizarProductos(String mesa, String nuevosProductos,List<Producto> listaProductos);
    void actualizarNotas(String mesa, String nuevasNotas);
    void mensajeNotificacion();
}
