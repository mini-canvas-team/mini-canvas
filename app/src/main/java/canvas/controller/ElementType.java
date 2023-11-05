package canvas.controller;

import java.util.Arrays;

import canvas.model.*;

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public enum ElementType {
    LINE(1, (p1, p2, color) -> new Line(p1, p2, color)),
    RECTANGLE(2, (p1, p2, color) -> new Rectangle(p1, p2, color)),
    ELLIPSE(3, (p1, p2, color) -> new Ellipse(p1, p2, color)),
    TEXT(4, (p1, p2, color) -> new Text(p1, p2, color)),
    IMAGE(5, (p1, p2, color) -> new Image(p1, p2, color));

    private final int id;
    private final TriFunction<Point, Point, Color, Element> constructor;

    private ElementType(int id, TriFunction<Point, Point, Color, Element> constructor) {
        this.id = id;
        this.constructor = constructor;
    }

    public static ElementType getById(int typeId) {
        return Arrays.stream(ElementType.values())
                .filter(elementType -> elementType.id == typeId)
                .findFirst()
                .orElse(null);
    }

    protected TriFunction<Point, Point, Color, Element> getConstructor() {
        return this.constructor;
    }
}