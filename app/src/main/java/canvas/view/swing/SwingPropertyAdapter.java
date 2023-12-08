package canvas.view.swing;

import java.util.function.Function;

import canvas.controller.ElementDto;
import canvas.view.Adapter;
import canvas.view.swing.frame.right.PropertyPanel;

public class SwingPropertyAdapter implements Adapter {
    private PropertyPanel view;

    public SwingPropertyAdapter(PropertyPanel view) {
        this.view = view;
    }

    @Override
    public void drawResources(Function<Adapter, Void> resourcesDrawEach) {

    }

    @Override
    public void drawSelections(Function<Adapter, Void> selectionsDrawEach) {
        view.clearSelections();
        selectionsDrawEach.apply(this);
        view.showProperties();
    }

    @Override
    public void drawLine(ElementDto element) {
        view.addSelection(element);
    }

    @Override
    public void drawRectangle(ElementDto element) {
        view.addSelection(element);
    }

    @Override
    public void drawEllipse(ElementDto element) {
        view.addSelection(element);
    }

    @Override
    public void drawText(ElementDto element) {
        view.addSelection(element);
    }

    @Override
    public void drawImage(ElementDto element) {
        view.addSelection(element);
    }
}
