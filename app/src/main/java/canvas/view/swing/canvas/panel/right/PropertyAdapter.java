package canvas.view.swing.canvas.panel.right;

import java.util.function.Function;

import canvas.controller.ElementDto;
import canvas.view.Adapter;

public class PropertyAdapter implements Adapter {
    private PropertyPanel panel;

    protected PropertyAdapter(PropertyPanel panel) {
        this.panel = panel;
    }

    @Override
    public void drawResources(Function<Adapter, Void> resourcesDrawEach) {

    }

    @Override
    public void drawSelections(Function<Adapter, Void> selectionsDrawEach) {
        panel.clearSelections();
        selectionsDrawEach.apply(this);
        panel.showProperties();
    }

    @Override
    public void drawLine(ElementDto element) {
        panel.addSelection(element);
    }

    @Override
    public void drawRectangle(ElementDto element) {
        panel.addSelection(element);
    }

    @Override
    public void drawEllipse(ElementDto element) {
        panel.addSelection(element);
    }

    @Override
    public void drawText(ElementDto element) {
        panel.addSelection(element);
    }

    @Override
    public void drawImage(ElementDto element) {
        panel.addSelection(element);
    }

    @Override
    public void listenText() {

    }

    @Override
    public void listenPath() {

    }
}
