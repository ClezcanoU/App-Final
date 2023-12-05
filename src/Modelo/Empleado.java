
package Modelo;


public class Empleado {
    private int id;
    private String nombre;
    private String cargo;
    private Boolean estado;

    public Empleado(int id, String nombre, String cargo, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.estado = estado;
    }
    
    //codigo sql SELECT * FROM empleados;

    //INSERT INTO empleados(`ID`, `NOMBRE`, `CONTRASENA`, `CARGO`, `ESTADO`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]')
    
    //DELETE FROM empleados WHERE id
    
    //UPDATE empleados SET `ID`='[value-1]',`NOMBRE`='[value-2]',`CONTRASENA`='[value-3]',`CARGO`='[value-4]',`ESTADO`='[value-5]' WHERE id
}
