
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    
    private SQLConeccion sqlConexion; 
    
    public ProductoDAO(SQLConeccion sqlConexion) {
        this.sqlConexion = sqlConexion; 
    }
    
    public List<Producto> obtenerProductosPorCategoria(String categoria) {
        // Implementa la lógica para listar insumos desde la base de datos
        List<Producto> productos = new ArrayList<>();
        String consulta = "SELECT CODIGO, NOMBRE, CANTIDAD, PRECIO FROM productos WHERE CATEGORIA = ?";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta)){
            statement.setString(1, categoria);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String codigo = resultSet.getString("CODIGO");
                    String nombre = resultSet.getString("NOMBRE");
                    int cantidad = resultSet.getInt("CANTIDAD");
                    double precio = resultSet.getDouble("PRECIO");


                    Producto producto = new Producto(nombre, codigo, categoria, cantidad, precio);
                    productos.add(producto);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }
}
