package canvas.model;

import canvas.controller.ElementDto;
import canvas.view.Adapter;

public class Text extends Element {
    private String text;

    public Text(Point p1, Point p2, Color color) {
        super(p1, p2, color);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setPath(String path) {
    }

    public String getText() {
        return text;
    }

    @Override
    public void draw(Adapter adapter) {
        adapter.drawText(new ElementDto(this));
    }
}
