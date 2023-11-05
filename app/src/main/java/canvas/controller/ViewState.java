package canvas.controller;

import canvas.model.Color;

public class ViewState {
    private ElementType type;
    private Color color;

    public ViewState() {
        this.type = null;
        this.color = new Color(255, 255, 255);
    }

    public ElementType getType() {
        return this.type;
    }

    public void setType(int typeId) {
        this.type = ElementType.getById(typeId);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
