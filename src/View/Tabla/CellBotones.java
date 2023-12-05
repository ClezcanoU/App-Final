
package View.Tabla;

import Modelo.InsumoDAO;
import Modelo.SQLConeccion;
import Modelo.interfaz.ModelCelda;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.sql.SQLException;

public class CellBotones extends TableCustomCell {

    SQLConeccion sqlConeccion = new SQLConeccion();
    
    public CellBotones() {
        initComponents();
    }

    private void addEvent(TableCustom table, TableRowData data, int row) {
        jbEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (data.isEditing()) {
                    table.cancelEditRowAt(row);
                    jbEditar.setIcon(new ImageIcon(getClass().getResource("/View/Icon/edit.png")));
                } else {
                    table.editRowAt(row);
                    jbEditar.setIcon(new ImageIcon(getClass().getResource("/View/Icon/cancel.png")));
                }
            }
        });
        jbEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int ID = ((ModelCelda) data).getId();
                if (ID != 0) {
                    new InsumoDAO(sqlConeccion).eliminarInsumo(ID);
                    table.deleteRowAt(getRow(), true);
                } else {
                    table.deleteRowAt(getRow(), true);
                }
            }
        });
    }

    private void checkIcon(TableRowData data) {
        if (data.isEditing()) {
            jbEditar.setIcon(new ImageIcon(getClass().getResource("/View/Icon/cancel.png")));
        } else {
            jbEditar.setIcon(new ImageIcon(getClass().getResource("/View/Icon/edit.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbEditar = new View.Tabla.BotonCell();
        jbEliminar = new View.Tabla.BotonCell();

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/edit.png"))); // NOI18N

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/delete.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents

     @Override
    public void setData(Object o) {

    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellBotones cell = new CellBotones();
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }

    @Override
    public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {
        return null;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int column) {
        CellBotones cell = new CellBotones();
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Tabla.BotonCell jbEditar;
    private View.Tabla.BotonCell jbEliminar;
    // End of variables declaration//GEN-END:variables
}
