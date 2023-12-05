
package ModelView;

import Modelo.Pedido;


public interface PedidoListener {
    void actualizarEstado(String cliente, Pedido.Estado estado, int clase);
}
