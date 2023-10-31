package canvas.model;

public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    protected int getRed() {
        return red;
    }

    protected int getBlue() {
        return blue;
    }

    protected int getGreen() {
        return green;
    }
}
