package canvas.model;

import canvas.view.Adapter;

public interface Component {
    void setWidth(int width);

    void setHeight(int height);

    void setColor(Color color);

    void setText(String text);

    void setPath(String path);

    Integer getWidth();

    Integer getHeight();

    Color getColor();

    boolean contains(Point p1, Point p2);

    void draw(Adapter adapter);

    void drawSelection(Adapter adapter);
}
