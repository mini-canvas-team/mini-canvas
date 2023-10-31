package canvas.model;

public class Element implements Component {
    private Point position;
    private int width;
    private int height;
    private Color color;

    public Element(Point p1, Point p2, Color color) {
        this.position = Point.topLeft(p1, p2);
        this.width = Point.getWidth(p1, p2);
        this.height = Point.getHeight(p1, p2);
        this.color = color;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
