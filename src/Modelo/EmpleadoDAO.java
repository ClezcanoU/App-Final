
package Modelo;

import Modelo.interfaz.ModelCelda2;
import Modelo.interfaz.ModelName;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EmpleadoDAO {
    
    private SQLConeccion sqlConexion; 

    public EmpleadoDAO(SQLConeccion sqlConexion) {
        this.sqlConexion = sqlConexion; 
    }
    
    public List<ModelCelda2> listarEmpleados() {
        // Implementa la lógica para listar insumos desde la base de datos
        List<ModelCelda2> empleados = new ArrayList<>();
        String consulta = "SELECT * FROM empleados";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id =resultSet.getInt("ID");
                String nombre =resultSet.getString("NOMBRE");
                String lugar =resultSet.getString("LUGAR");
                String estado=resultSet.getString("ESTADO");
                empleados.add(new ModelCelda2(id,new ModelName(nombre,null),lugar,estado));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleados;
    }
    
    public void agregarEmpleado(ModelCelda2 data) {
        String consulta = "INSERT INTO empleados (NOMBRE, LUGAR, ESTADO) VALUES (?, ?, ?)";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta)) {
            statement.setString(1, data.getName().getFirstName());
            statement.setString(2, data.getLugar());
            statement.setString(3, data.getEstado());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void actualizarEmpleado(ModelCelda2 data) {
        String consulta = "UPDATE empleados SET NOMBRE = ?, LUGAR = ?, ESTADO = ? WHERE ID = ?";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta)) {
            statement.setString(1, data.getName().getFirstName());
            statement.setString(2, data.getLugar());
            statement.setString(3, data.getEstado());
            statement.setInt(4, data.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void eliminarEmpleado(int id) {
        String consulta = "DELETE FROM emplados WHERE ID = ?";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
