package canvas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import canvas.controller.DrawAdapter;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public void ofList(List<Component> components) {
        this.components = components;
    }

    public List<Component> get() {
        return components;
    }

    public List<Component> filter(Predicate<Component> predicate) {
        return components.stream().filter(predicate).toList();
    }

    @Override
    public void setWidth(int width) {
        components.forEach(component -> component.setWidth(width));
    }

    @Override
    public void setHeight(int height) {
        components.forEach(component -> component.setHeight(height));
    }

    @Override
    public void setColor(Color color) {
        components.forEach(component -> component.setColor(color));
    }

    @Override
    public boolean contains(Point p1, Point p2) {
        return components.stream().anyMatch(component -> component.contains(p1, p2));
    }

    @Override
    public void draw(DrawAdapter adapter) {
        components.forEach(component -> component.draw(adapter));
    }
}
