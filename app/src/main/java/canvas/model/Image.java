package canvas.model;

public class Image extends Element {
    private String path;

    public Image(Point p1, Point p2, Color color, String path) {
        super(p1, p2, color);
        this.path = path;
    }

    @Override
    public void setText(String text) {
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
