
package View.Swing;

import ModelView.MenuSelected;
import Modelo.interfaz.Model_Menu;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;


public class ListMenu<E extends Object> extends JList<E>{

    private final DefaultListModel model;
    private int selectedIdenx = -1;
    private int overIdenx = -1;
    private MenuSelected event;
    
    public void addEventMenuSelected(MenuSelected event){
        this.event = event;
    }
    
    public ListMenu() {
        model = new DefaultListModel();
        setModel(model);
        //Selecionar un item del menu lateral
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    int index = locationToIndex(e.getPoint());
                    Object o = model.getElementAt(index);
                    if(o instanceof Model_Menu){
                        Model_Menu menu = (Model_Menu)o;
                        if(menu.getType()==Model_Menu.MenuType.MENU){
                            selectedIdenx = index;
                            if(event!=null){
                                event.selected(index);
                            }
                        }
                    }else {
                        selectedIdenx = index;
                    }
                    repaint();
                }
            }
            //Quita la seleccion de los items del menu lateral
            @Override
            public void mouseExited(MouseEvent e) {
                overIdenx = -1;
                repaint();
            }   
        });
        //Hace una previsualizacion de el item del menu que tiene el mouse encima
        addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = locationToIndex(e.getPoint());
                if(index!=overIdenx){
                    Object o = model.getElementAt(index);
                    if(o instanceof Model_Menu){
                        Model_Menu menu = (Model_Menu)o;
                        if(menu.getType()==Model_Menu.MenuType.MENU){
                            overIdenx = index;
                            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        }else{
                            overIdenx = -1;
                            setCursor(Cursor.getDefaultCursor());
                        }
                        repaint();
                    }
                }
            }
            
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Model_Menu data;
                if(value instanceof Model_Menu){
                    data = (Model_Menu)value;
                }else{
                    data = new Model_Menu("", value + "",Model_Menu.MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);
                item.setSeleccion(selectedIdenx==index);
                item.setOver(overIdenx==index);
                return item;
            }
        };
    }
    
    public void addItem(Model_Menu data){
        model.addElement(data);
    }
    
}
