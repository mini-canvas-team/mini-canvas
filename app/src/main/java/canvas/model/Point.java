package canvas.model;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Point topLeft(Point p1, Point p2) {
        int minX = Math.min(p1.getX(), p2.getX());
        int minY = Math.min(p1.getY(), p2.getY());

        return new Point(minX, minY);
    }

    public static Point bottomRight(Point p1, Point p2) {
        int maxX = Math.max(p1.getX(), p2.getX());
        int maxY = Math.max(p1.getY(), p2.getY());

        return new Point(maxX, maxY);
    }

    public static int getWidth(Point p1, Point p2) {
        return bottomRight(p1, p2).getX() - topLeft(p1, p2).getX();
    }

    public static int getHeight(Point p1, Point p2) {
        return bottomRight(p1, p2).getY() - topLeft(p1, p2).getY();
    }
}
