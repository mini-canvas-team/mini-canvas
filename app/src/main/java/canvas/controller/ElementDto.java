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
    private Point point1;
    private Point point2;
    private Color color;
    private String text;
    private String path;

    public ElementDto(Basic basic) {
        this.position = basic.getPosition();
        this.width = basic.getWidth();
        this.height = basic.getHeight();
        this.point1 = basic.getPoint1();
        this.point2 = basic.getPoint2();
        this.color = basic.getColor();
    }

    public ElementDto(Text text) {
        this.position = text.getPosition();
        this.width = text.getWidth();
        this.height = text.getHeight();
        this.point1 = text.getPoint1();
        this.point2 = text.getPoint2();
        this.color = text.getColor();
        this.text = text.getText();
    }

    public ElementDto(Image image) {
        this.position = image.getPosition();
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.color = image.getColor();
        this.point1 = image.getPoint1();
        this.point2 = image.getPoint2();
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

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
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
