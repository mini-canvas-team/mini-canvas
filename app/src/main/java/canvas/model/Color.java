package canvas.model;

import java.util.Arrays;

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Color) {
            Color color = (Color) obj;
            return red == color.red && green == color.green && blue == color.blue;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.asList(red, green, blue).hashCode();
    };
}
