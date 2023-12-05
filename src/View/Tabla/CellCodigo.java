
package View.Tabla;

import Modelo.EmpleadoDAO;
import Modelo.InsumoDAO;
import Modelo.SQLConeccion;
import Modelo.interfaz.ModelCelda;
import Modelo.interfaz.ModelCelda2;
import Modelo.interfaz.ModelName;
import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CellCodigo extends TableCustomCell {

    SQLConeccion sqlConeccion = new SQLConeccion();
    
    public CellCodigo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();

        jLabel1.setForeground(new java.awt.Color(200, 200, 200));
        jLabel1.setText("Codigo");

        jbGuardar.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbGuardar)))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbGuardar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addEventSave(TableCustom tabla) {
        jbGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tabla.stopCellEditing();
                int row = getRow();
                String codigo = tabla.getValueAt(row, 0).toString();
                String nombre = tabla.getValueAt(row, 1).toString();
                int cantidad = (int) tabla.getValueAt(row, 2);
                String ubicacion = tabla.getValueAt(row, 3).toString();
                ModelCelda insumo = (ModelCelda) tabla.getModelData(row);
                ModelCelda data = new ModelCelda(insumo.getId(),codigo,nombre,cantidad,ubicacion);
                if (insumo.getId() == 0) {
                    //  Insert
                    new InsumoDAO(sqlConeccion).agregarInsumo(data);
                    tabla.updateModelData(row, data);
                } else {
                    //  Update
                    new InsumoDAO(sqlConeccion).actualizarInsumo(data);
                    tabla.updateModelData(row, data);
                }
            }
        });
    }
    
    @Override
    public void setData(Object o) {
        txt.setText(o.toString());
    }

    @Override
    public Object getData() {
        return txt.getText().trim();
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellCodigo cell = new CellCodigo();
        cell.setData(o);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}
