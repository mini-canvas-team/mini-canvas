package canvas.controller;

import canvas.model.Color;

public class ViewState {
    private int type;
    private Color color;

    public ViewState() {
        type = 0;
        color = new Color(255, 255, 255);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
