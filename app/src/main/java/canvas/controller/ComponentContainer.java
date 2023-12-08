package canvas.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import canvas.model.Color;
import canvas.model.Component;
import canvas.model.Composite;
import canvas.model.Point;
import canvas.view.Adapter;

public class ComponentContainer {
    private Composite resources;
    private Composite selections;

    public ComponentContainer() {
        resources = new Composite();
        selections = new Composite();
    }

    public void add(Component component) {
        resources.add(component);

        selections.ofList(Collections.singletonList(component));
    }

    public void select(Point p1, Point p2) {
        selections.ofList(resources.filter(component -> component.contains(p1, p2)));
    }

    public void selectOne(Point p1) {
        selections.ofList(resources.filter(component -> component.contains(p1, p1)).stream().limit(1)
                .collect(Collectors.toList()));
    }

    public void setColor(Color color) {
        selections.setColor(color);
    }

    public void setHeight(Integer height) {
        selections.setHeight(height);
    }

    public void setWidth(Integer width) {
        selections.setWidth(width);
    }

    public void setText(String text) {
        selections.setText(text);
    }

    public void setPath(String path) {
        selections.setPath(path);
    }

    public Color getColor() {
        return selections.getColor();
    }

    public Integer getHeight() {
        return selections.getHeight();
    }

    public Integer getWidth() {
        return selections.getWidth();
    }

    public void setFront() {
        selections.get().forEach(component -> resources.remove(component));

        List<Component> l = selections.get();
        Collections.reverse(l);
        l.forEach(component -> resources.addFront(component));
    }

    public void setBack() {
        selections.get().forEach(component -> resources.remove(component));
        selections.get().forEach(component -> resources.add(component));
    }

    public Void drawResources(Adapter adapter) {
        resources.draw(adapter);
        return null;
    }

    public Void drawSelections(Adapter adapter) {
        selections.draw(adapter);
        return null;
    }
}
