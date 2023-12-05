
package Modelo;

import Modelo.interfaz.ModelCelda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;

public class InsumoDAO {

    private SQLConeccion sqlConexion; 

    public InsumoDAO(SQLConeccion sqlConexion) {
        this.sqlConexion = sqlConexion; 
    }


    public List<ModelCelda> listarInsumos() {
        // Implementa la lógica para listar insumos desde la base de datos
        List<ModelCelda> insumos = new ArrayList<>();
        String consulta = "SELECT * FROM insumos";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id =resultSet.getInt("ID");
                String codigo=resultSet.getString("CODIGO");
                String nombre =resultSet.getString("NOMBRE");
                int cantidad =resultSet.getInt("CANTIDAD");
                String ubicacion=resultSet.getString("UBICACION");
                insumos.add(new ModelCelda(id,codigo,nombre,cantidad,ubicacion));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return insumos;
    }


    public Insumo obtenerInsumoPorId(int id) {
        Insumo insumo = null;
        String consulta = "SELECT * FROM insumos WHERE ID = ?";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    insumo = new Insumo();
                    insumo.setId(resultSet.getInt("ID"));
                    insumo.setCodigo(resultSet.getString("CODIGO"));
                    insumo.setNombre(resultSet.getString("NOMBRE"));
                    insumo.setCantidad(resultSet.getInt("CANTIDAD"));
                    insumo.setUbicacion(resultSet.getString("UBICACION"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return insumo;
    }


    public void agregarInsumo(ModelCelda data) {
        String consulta = "INSERT INTO insumos (CODIGO, NOMBRE, CANTIDAD, UBICACION) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta)) {
            statement.setString(1, data.getCodigo());
            statement.setString(2, data.getNombreProducto());
            statement.setInt(3, data.getCantidad());
            statement.setString(4, data.getUbicacion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void actualizarInsumo(ModelCelda data) {
        String consulta = "UPDATE insumos SET CODIGO = ?, NOMBRE = ?, CANTIDAD = ?, UBICACION = ? WHERE ID = ?";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta)) {
            statement.setString(1, data.getCodigo());
            statement.setString(2, data.getNombreProducto());
            statement.setInt(3, data.getCantidad());
            statement.setString(4, data.getUbicacion());
            statement.setInt(5, data.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void eliminarInsumo(int id) {
        String consulta = "DELETE FROM insumos WHERE ID = ?";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
