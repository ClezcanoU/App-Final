
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    private SQLConeccion sqlConexion; 

    public ClienteDAO(SQLConeccion sqlConexion) {
        this.sqlConexion = sqlConexion; 
    }
    
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String consulta = "SELECT * FROM clientes";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("ID"));
                cliente.setNombre(resultSet.getString("NOMBRE"));
                cliente.setDireccion(resultSet.getString("DIRECCION"));
                cliente.setTel1(resultSet.getString("TEL1"));
                cliente.setTel2(resultSet.getString("TEL2"));
                cliente.setEmail(resultSet.getString("EMAIL"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
    
    public void agregarCliente(Cliente cliente) {
        String consulta = "INSERT INTO clientes (NOMBRE, DIRECCION, TEL1, TEL2, EMAIL) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDireccion());
            statement.setString(3, cliente.getTel1());
            statement.setString(4, cliente.getTel2());
            statement.setString(5, cliente.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarCliente(int id) {
        String consulta = "DELETE FROM clientes WHERE ID = ?";

        try (PreparedStatement statement = sqlConexion.getConectarDB().prepareStatement(consulta)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
