package canvas.model;

import canvas.controller.DrawAdapter;

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

    @Override
    public boolean contains(Point p1, Point p2) {
        Point plt = Point.topLeft(p1, p2);
        Point prb = Point.bottomRight(p1, p2);

        boolean overlappingX = position.getX() <= prb.getX() && position.getX() + width >= plt.getX();
        boolean overlappingY = position.getY() <= prb.getY() && position.getY() + height >= plt.getY();
        return overlappingX && overlappingY;
    }

    @Override
    public void draw(DrawAdapter adapter) {
        adapter.draw(this);
    }
}
