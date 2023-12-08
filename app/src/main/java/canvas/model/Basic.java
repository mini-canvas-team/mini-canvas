package canvas.model;

import canvas.controller.ElementDto;
import canvas.view.Adapter;

public abstract class Basic extends Element {
    public Basic(Point p1, Point p2, Color color) {
        super(p1, p2, color);
    }

    @Override
    public void setText(String text) {
    }

    @Override
    public void setPath(String path) {
    }

    @Override
    public void drawSelection(Adapter adapter) {
        adapter.addSelection(new ElementDto(this));
    }
}
