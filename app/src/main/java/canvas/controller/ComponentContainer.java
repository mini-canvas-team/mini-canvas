package canvas.controller;

import java.util.Collections;
import java.util.List;

import canvas.model.Component;
import canvas.model.Composite;
import canvas.model.Point;

public class ComponentContainer {
    private Composite resources;
    private Composite selections;

    public ComponentContainer() {
        resources = new Composite();
        selections = new Composite();
    }

    public void select(Point p1, Point p2) {
        selections.ofList(resources.filter(component -> component.contains(p1, p2)));
    }

    public void selectOne(Point p1) {
        selections.ofList(resources.filter(component -> component.contains(p1, p1)).stream().limit(1).toList());
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
}
