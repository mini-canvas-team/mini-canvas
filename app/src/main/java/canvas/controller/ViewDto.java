package canvas.controller;

import canvas.model.Color;

public class ViewDto {
    private int selectedType;
    private Color selectedColor;

    public ViewDto() {
        selectedType = 0;
        selectedColor = new Color(255, 255, 255);
    }

    public int getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(int type) {
        selectedType = type;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color color) {
        selectedColor = color;
    }
}
