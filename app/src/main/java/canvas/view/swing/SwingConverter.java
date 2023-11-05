package canvas.view.swing;

import canvas.model.Color;
import canvas.model.Point;

public class SwingConverter {
    public Color convertColor(java.awt.Color color) {
        if (color == null)
            return new Color(0, 0, 0);
        return new Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    public java.awt.Color convertColor(Color color) {
        if (color == null)
            return new java.awt.Color(0, 0, 0);
        return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    public Point convertPoint(java.awt.Point point) {
        return new Point(point.x, point.y);
    }

    public java.awt.Point convertPoint(Point point) {
        return new java.awt.Point(point.getX(), point.getY());
    }
}
