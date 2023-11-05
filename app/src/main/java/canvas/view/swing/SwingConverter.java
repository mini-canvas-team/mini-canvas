package canvas.view.swing;

import canvas.model.Color;
import canvas.model.Point;

public class SwingConverter {
    public Color convertColor(java.awt.Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    public Point convertPoint(java.awt.Point point) {
        return new Point(point.x, point.y);
    }
}
