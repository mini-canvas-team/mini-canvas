package canvas.controller;

import canvas.model.Basic;
import canvas.model.Color;
import canvas.model.Image;
import canvas.model.Point;
import canvas.model.Text;

public class ElementDto {
    private Point position;
    private int width;
    private int height;
    private Color color;
    private String text;
    private String path;

    public ElementDto(Basic basic) {
        this.position = basic.getPosition();
        this.width = basic.getWidth();
        this.height = basic.getHeight();
        this.color = basic.getColor();
    }

    public ElementDto(Text text) {
        this.position = text.getPosition();
        this.width = text.getWidth();
        this.height = text.getHeight();
        this.color = text.getColor();
        this.text = text.getText();
    }

    public ElementDto(Image image) {
        this.position = image.getPosition();
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.color = image.getColor();
        this.path = image.getPath();
    }

    public Point getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    public String getPath() {
        return path;
    }
}
