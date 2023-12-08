package canvas.model;

import canvas.controller.ElementDto;
import canvas.view.Adapter;

public class Text extends Element {
    private String text;

    public Text(Point p1, Point p2, Color color) {
        super(p1, p2, color);
        /* TODO: will be removed after implementing text input */
        this.setText("Temp Text");
    }

    @Override
    public void setText(String text) {
        this.text = text != null ? text : this.text;
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

    @Override
    public void drawSelection(Adapter adapter) {
        adapter.addSelection(new ElementDto(this));
    }
}
