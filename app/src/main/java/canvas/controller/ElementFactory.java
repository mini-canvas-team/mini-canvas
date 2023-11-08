package canvas.controller;

import canvas.model.Color;
import canvas.model.Element;
import canvas.model.Point;

public class ElementFactory {
    public Element create(ElementType type, Point p1, Point p2, Color selectedColor) {
        return type.getConstructor().apply(p1, p2, selectedColor);
    }
}
