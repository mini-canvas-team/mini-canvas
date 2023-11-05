package canvas.model;

import canvas.controller.ElementDto;
import canvas.view.Adapter;

public class Ellipse extends Basic {
    public Ellipse(Point p1, Point p2, Color color) {
        super(p1, p2, color);
    }

    @Override
    public void draw(Adapter adapter) {
        adapter.drawEllipse(new ElementDto(this));
    }
}
