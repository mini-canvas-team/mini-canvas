package canvas.controller;

import java.util.Arrays;

import canvas.model.*;

public enum ElementType {
    LINE(1, Line.class),
    RECTANGLE(2, Rectangle.class),
    ELLIPSE(3, Ellipse.class),
    TEXT(4, Text.class),
    IMAGE(5, Image.class);

    private final int id;
    private final Class<? extends Element> elementClass;

    ElementType(int id, Class<? extends Element> elementClass) {
        this.id = id;
        this.elementClass = elementClass;
    }

    public static ElementType getById(int typeId) {
        return Arrays.stream(ElementType.values())
                .filter(elementType -> elementType.id == typeId)
                .findFirst()
                .orElse(null);
    }

    protected Class<? extends Element> getElementClass() {
        return elementClass;
    }
}
