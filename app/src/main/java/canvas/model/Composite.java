package canvas.model;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    private Composite(List<Component> components) {
        this.components = components;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
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
}
