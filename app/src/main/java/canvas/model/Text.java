package canvas.model;

public class Text extends Element {
    private String text;

    public Text(Point p1, Point p2, Color color, String text) {
        super(p1, p2, color);
        this.text = text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setPath(String path) {
    }

}
