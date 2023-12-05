
package View.Component;

import Modelo.interfaz.Model_Card;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class CardResumen extends javax.swing.JPanel {

    private Color color1;
    private Color color2;
    
    public CardResumen() {
        initComponents();
        setOpaque(false);
        color1=Color.BLACK;
        color2=Color.WHITE;
    }

    public void setData(Model_Card data){
        lbTitulo.setText(data.getTitulo());
        lbIcon1.setIcon(data.getIcon1());
        lbDescripcion1.setText(data.getDescripcion1());
        lbValor1.setText(data.getValor1());
        lbIcon2.setIcon(data.getIcon2());
        lbDescripcion2.setText(data.getDescripcion2());
        lbValor2.setText(data.getValor2());
    }
    
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        lbIcon1 = new javax.swing.JLabel();
        lbIcon2 = new javax.swing.JLabel();
        lbDescripcion1 = new javax.swing.JLabel();
        lbValor1 = new javax.swing.JLabel();
        lbDescripcion2 = new javax.swing.JLabel();
        lbValor2 = new javax.swing.JLabel();

        lbTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Titulo");

        lbIcon1.setText("jLabel2");

        lbIcon2.setText("jLabel2");

        lbDescripcion1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbDescripcion1.setForeground(new java.awt.Color(255, 255, 255));
        lbDescripcion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescripcion1.setText("jLabel4");

        lbValor1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbValor1.setForeground(new java.awt.Color(255, 255, 255));
        lbValor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValor1.setText("jLabel5");

        lbDescripcion2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbDescripcion2.setForeground(new java.awt.Color(255, 255, 255));
        lbDescripcion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescripcion2.setText("jLabel6");

        lbValor2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbValor2.setForeground(new java.awt.Color(255, 255, 255));
        lbValor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValor2.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValor1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(lbDescripcion2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbValor2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDescripcion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(lbTitulo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDescripcion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbValor1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDescripcion2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbValor2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gG = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(gG);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255,255,255,50));
        g2.fillOval(getWidth()-(getHeight()/2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth()-(getHeight()/2)-20, getHeight()/2+20, getHeight(), getHeight());
        super.paintComponent(g); 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbDescripcion1;
    private javax.swing.JLabel lbDescripcion2;
    private javax.swing.JLabel lbIcon1;
    private javax.swing.JLabel lbIcon2;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbValor1;
    private javax.swing.JLabel lbValor2;
    // End of variables declaration//GEN-END:variables
}
