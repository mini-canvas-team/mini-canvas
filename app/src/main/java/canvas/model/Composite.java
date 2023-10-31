package canvas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import canvas.controller.DrawAdapter;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    private Composite(List<Component> components) {
        this.components = components;
    }

    private Stream<Component> getOverlappingStream(Point p1, Point p2) {
        return components.stream().filter(components -> components.isOverlapping(p1, p2));
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public Composite select(Point p1, Point p2) {
        List<Component> selected = getOverlappingStream(p1, p2).toList();
        return new Composite(selected);
    }

    public Composite selectOne(Point p1) {
        Optional<Component> selected = getOverlappingStream(p1, p1).findFirst();
        return new Composite(selected.stream().toList());
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
    public boolean isOverlapping(Point p1, Point p2) {
        return components.stream().anyMatch(component -> component.isOverlapping(p1, p2));
    }

    @Override
    public void draw(DrawAdapter adapter) {
        components.forEach(component -> component.draw(adapter));
    }
}
