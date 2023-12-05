
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Menu {

    private List<Producto> productos;

//    public Menu(String Categoria, List<Producto> productos) {
//        this.Categoria = Categoria;
//        this.productos = productos;
//    }

    
    public Menu() {
        this.productos = new ArrayList<>();
    }

    // CREATE: Agregar un nuevo producto al menú
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    // READ: Obtener todos los productos del menú
    public List<Producto> obtenerProductos() {
        return new ArrayList<>(productos); // Devuelve una copia para evitar cambios externos
    }
    
    // Otros métodos útiles, según tus necesidades
}
