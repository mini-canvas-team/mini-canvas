package canvas.model;

import canvas.controller.DrawAdapter;

public interface Component {
    void setWidth(int width);

    void setHeight(int height);

    void setColor(Color color);

    boolean contains(Point p1, Point p2);

    void draw(DrawAdapter adapter);
}
