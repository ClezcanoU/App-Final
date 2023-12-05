
package View.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ModernButton extends JButton {

    private Color backgroundColor;
    private Color hoverColor;
    private Color pressedColor;

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }

    public void setPressedColor(Color pressedColor) {
        this.pressedColor = pressedColor;
    }
    
    

    public ModernButton() {
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

        backgroundColor = new Color(55, 71, 79); // Gris oscuro
        hoverColor = new Color(38, 50, 56); // Gris más oscuro al pasar el ratón
        pressedColor = new Color(33, 43, 49); // Gris aún más oscuro al hacer clic
        
        setBackground(backgroundColor);

        // Establecer el diseño del botón
        setPreferredSize(new Dimension(150, 40));
        setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        setForeground(Color.white);

        // Agregar oyentes de eventos para gestionar cambios de color
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(hoverColor);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(backgroundColor);
                setCursor(Cursor.getDefaultCursor());
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                setBackground(pressedColor);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                setBackground(hoverColor);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Dibujar el fondo redondeado
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

        // Dibujar el texto centrado
        FontMetrics fm = g2d.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
        g2d.setColor(getForeground());
        g2d.drawString(getText(), x, y);

        g2d.dispose();
    }

    // Otros métodos, según sea necesario
}
