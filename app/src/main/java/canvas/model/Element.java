package canvas.model;

import canvas.view.Adapter;

public abstract class Element implements Component {
    private Point p1;
    private Point p2;
    private Color color;

    public Element(Point p1, Point p2, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    @Override
    public void setWidth(int width) {
        if (p1.getX() > p2.getX()) {
            this.p1 = new Point(p2.getX() + width, p1.getY());
        } else {
            this.p2 = new Point(p1.getX() + width, p2.getY());
        }
    }

    @Override
    public void setHeight(int height) {
        if (p1.getY() > p2.getY()) {
            this.p1 = new Point(p1.getX(), p2.getY() + height);
        } else {
            this.p2 = new Point(p2.getX(), p1.getY() + height);
        }
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public abstract void setText(String text);

    @Override
    public abstract void setPath(String path);

    @Override
    public Integer getWidth() {
        return Point.getWidth(p1, p2);
    }

    @Override
    public Integer getHeight() {
        return Point.getHeight(p1, p2);
    }

    public Color getColor() {
        return color;
    }

    public Point getPosition() {
        return Point.topLeft(p1, p2);
    }

    public Point getPoint1() {
        return p1;
    }

    public Point getPoint2() {
        return p2;
    }

    @Override
    public boolean contains(Point p1, Point p2) {
        Point clt = Point.topLeft(this.p1, this.p2);
        Point crb = Point.bottomRight(this.p1, this.p2);

        Point plt = Point.topLeft(p1, p2);
        Point prb = Point.bottomRight(p1, p2);

        boolean overlappingX = clt.getX() <= prb.getX() && crb.getX() >= plt.getX();
        boolean overlappingY = clt.getY() <= prb.getY() && crb.getY() >= plt.getY();
        return overlappingX && overlappingY;
    }

    @Override
    public abstract void draw(Adapter adapter);

    @Override
    public abstract void drawSelection(Adapter adapter);
}
