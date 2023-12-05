
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConeccion {
    private Connection SQLConexion;
    
    public SQLConeccion(){
        
        String host = "localhost";
        String puerto = "3306";
        String nameDB ="cabritobasedatos";
        
        String usuario = "root";
        String pass = "";
        
        String databaseURL = "jdbc:mysql://"+host+":"+puerto+"/"+nameDB+"?useSSL=false";
        
        try{
            SQLConexion = DriverManager.getConnection(databaseURL,usuario,pass);
            System.out.println("Coneccion Exitosa");
        }catch(Exception ex){
            System.out.println("Coneccion fallida");
            ex.printStackTrace();
        }
    }
    
    public Connection getConectarDB(){
        return SQLConexion;
    }
    
    public void cerrarConexion() {
        try {
            if (SQLConexion != null && !SQLConexion.isClosed()) {
                SQLConexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
