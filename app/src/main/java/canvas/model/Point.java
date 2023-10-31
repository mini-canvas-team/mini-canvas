package canvas.model;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }
}
