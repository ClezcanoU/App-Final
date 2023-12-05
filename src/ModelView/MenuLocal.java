
package ModelView;

import Modelo.Menu;
import Modelo.Producto;
import javax.swing.ImageIcon;


public class MenuLocal {
    
    Menu menu = new Menu();
    
    public Menu MenuLocal(){
        menu.agregarProducto(new Producto("Hamburguesa Clásica","#","",20,8.000));
        menu.agregarProducto(new Producto("Churrasco de Res","#","", 15, 14.000));
        menu.agregarProducto(new Producto("Ensalada César","#","", 10, 6.000));
        menu.agregarProducto(new Producto("Pollo a la Parrilla","#","", 18, 12.000));
        menu.agregarProducto(new Producto("Papas Fritas","#","", 25, 4.000));
        menu.agregarProducto(new Producto("Tacos de Carnitas","#","", 12, 10.000));
        menu.agregarProducto(new Producto("Pizza Margarita","#","", 8, 11.000));
        menu.agregarProducto(new Producto("Sopa de Tomate","#","" , 15, 7.000));
        menu.agregarProducto(new Producto("Burrito de Pollo","#","", 10, 9.000));
        menu.agregarProducto(new Producto("Ceviche de Camarones","#","", 12, 13.000));
        menu.agregarProducto(new Producto("Costillas BBQ","#", "", 20, 16.000));
        menu.agregarProducto(new Producto("Pan con Ajo","#","" , 15, 5.000));
        menu.agregarProducto(new Producto("Tarta de Chocolate","#", "", 8, 8.000));
        menu.agregarProducto(new Producto("Sándwich Club","#","", 18, 9.000));
        menu.agregarProducto(new Producto("Arroz con Pollo","#", "", 12, 11.000));
        menu.agregarProducto(new Producto("Helado de Vainilla","#", "", 25, 3.000));
        menu.agregarProducto(new Producto("Pastel de Queso","#","", 8, 7.000));
        menu.agregarProducto(new Producto("Torta de Zanahoria","#","", 10, 8.000));
        menu.agregarProducto(new Producto("Cóctel de Frutas","#","", 15, 6.000));
        menu.agregarProducto(new Producto("Camarones a la Diabla","#","", 10, 15.000));
        menu.agregarProducto(new Producto("Quesadillas","#","", 12, 10.000));
        menu.agregarProducto(new Producto("Batido de Fresa","#","", 20, 8.000));
        menu.agregarProducto(new Producto("Flan de Vainilla","#","", 8, 6.000));
        menu.agregarProducto(new Producto("Sushi Variado","#","", 15, 18.000));
        menu.agregarProducto(new Producto("Cerveza Artesanal","#","", 30, 4.000));

        return menu;
    }
 
}
