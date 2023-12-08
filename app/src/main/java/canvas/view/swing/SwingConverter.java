package canvas.view.swing;

import canvas.model.Color;
import canvas.model.Point;

public class SwingConverter {
    private SwingConverter() {
    }

    public static Color convertColor(java.awt.Color color) {
        if (color == null)
            return null;
        return new Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    public static java.awt.Color convertColor(Color color) {
        if (color == null)
            return null;
        return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    public static Point convertPoint(java.awt.Point point) {
        return new Point(point.x, point.y);
    }

    public static java.awt.Point convertPoint(Point point) {
        return new java.awt.Point(point.getX(), point.getY());
    }
}
