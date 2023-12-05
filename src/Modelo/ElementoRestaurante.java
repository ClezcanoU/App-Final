
package Modelo;

import javax.swing.Icon;


public class ElementoRestaurante {
    private int id;
    private String nombre;
    private Icon imagen;

    //Constructores
    
    public ElementoRestaurante(int id, String nombre, Icon imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public ElementoRestaurante(Icon imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public ElementoRestaurante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ElementoRestaurante(String nombre) {
        this.nombre = nombre;
    }

    public ElementoRestaurante(int id) {
        this.id = id;
    }

    public ElementoRestaurante() {
    }
    
    //Getters and Setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }
    
}
