package canvas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import canvas.view.Adapter;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    public void addFront(Component component) {
        components.add(0, component);
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
        return components.stream().filter(predicate).collect(Collectors.toList());
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
    public void setText(String text) {
        components.forEach(component -> component.setText(text));
    }

    @Override
    public void setPath(String path) {
        components.forEach(component -> component.setPath(path));
    }

    @Override
    public boolean contains(Point p1, Point p2) {
        return components.stream().anyMatch(component -> component.contains(p1, p2));
    }

    @Override
    public void draw(Adapter adapter) {
        components.forEach(component -> component.draw(adapter));
    }

    @Override
    public Integer getWidth() {
        return components.stream().mapToInt(Component::getWidth).distinct().count() == 1
                ? components.stream().mapToInt(Component::getWidth).findFirst().getAsInt()
                : null;
    }

    @Override
    public Integer getHeight() {
        return components.stream().mapToInt(Component::getHeight).distinct().count() == 1
                ? components.stream().mapToInt(Component::getHeight).findFirst().getAsInt()
                : null;
    }

    @Override
    public Color getColor() {
        return components.stream().map(Component::getColor).distinct().count() == 1
                ? components.stream().map(Component::getColor).findFirst().get()
                : null;
    }

    @Override
    public void drawSelection(Adapter adapter) {
        components.forEach(component -> component.drawSelection(adapter));
    }
}
