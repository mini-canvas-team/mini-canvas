package canvas.model;

import canvas.controller.ElementDto;
import canvas.view.Adapter;

public class Line extends Basic {
    public Line(Point p1, Point p2, Color color) {
        super(p1, p2, color);
    }

    @Override
    public void draw(Adapter adapter) {
        adapter.drawLine(new ElementDto(this));
    }
}
