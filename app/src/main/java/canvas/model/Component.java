package canvas.model;

public interface Component {
    void setWidth(int width);

    void setHeight(int height);

    void setColor(Color color);

    boolean isOverlapping(Point p1, Point p2);
}
