
package Modelo.interfaz;

import javax.swing.Icon;

public class Model_Card {
    
    private String Titulo;
    private Icon icon1;
    private String Descripcion1;
    private String Valor1;
    private Icon icon2;
    private String Descripcion2;
    private String Valor2;
    
    public Model_Card(String Titulo, Icon icon1, String Descripcion1, String Valor1, Icon icon2, String Descripcion2, String Valor2) {
        this.Titulo = Titulo;
        this.icon1 = icon1;
        this.Descripcion1 = Descripcion1;
        this.Valor1 = Valor1;
        this.icon2 = icon2;
        this.Descripcion2 = Descripcion2;
        this.Valor2 = Valor2;
    }

    public Model_Card(String Titulo, Icon icon1) {
        this.Titulo = Titulo;
        this.icon1 = icon1;
    }
    
    public Model_Card() {
    }
     
    public Icon getIcon1() {
        return icon1;
    }

    public void setIcon1(Icon icon1) {
        this.icon1 = icon1;
    }

    public Icon getIcon2() {
        return icon2;
    }

    public void setIcon2(Icon icon2) {
        this.icon2 = icon2;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion1() {
        return Descripcion1;
    }

    public void setDescripcion1(String Descripcion1) {
        this.Descripcion1 = Descripcion1;
    }

    public String getValor1() {
        return Valor1;
    }

    public void setValor1(String Valor1) {
        this.Valor1 = Valor1;
    }

    public String getDescripcion2() {
        return Descripcion2;
    }

    public void setDescripcion2(String Descripcion2) {
        this.Descripcion2 = Descripcion2;
    }

    public String getValor2() {
        return Valor2;
    }

    public void setValor2(String Valor2) {
        this.Valor2 = Valor2;
    }
}