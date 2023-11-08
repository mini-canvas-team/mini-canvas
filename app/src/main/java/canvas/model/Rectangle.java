package canvas.model;

import canvas.controller.ElementDto;
import canvas.view.Adapter;

public class Rectangle extends Basic {
    public Rectangle(Point p1, Point p2, Color color) {
        super(p1, p2, color);
    }

    @Override
    public void draw(Adapter adapter) {
        adapter.drawRectangle(new ElementDto(this));
    }
}
