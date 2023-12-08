package canvas.model;

import canvas.controller.ElementDto;
import canvas.view.Adapter;

public class Image extends Element {
    public Image(Point p1, Point p2, Color color) {
        super(p1, p2, color);
        System.out.println(getClass().getClassLoader().getResource("temp.png").toString());
        /* TODO: will be removed after implementing image input */
        this.setPath(getClass().getClassLoader().getResource("temp.png").getPath());
    }

    private String path;

    @Override
    public void setText(String text) {
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void draw(Adapter adapter) {
        adapter.drawImage(new ElementDto(this));
    }

    @Override
    public void drawSelection(Adapter adapter) {
        adapter.addSelection(new ElementDto(this));
    }

}
