package canvas.view.swing;

import canvas.controller.ElementDto;
import canvas.view.Adapter;
import canvas.view.swing.frame.right.PropertyPanel;

public class SwingPropertyAdapter implements Adapter {
    private PropertyPanel view;

    public SwingPropertyAdapter(PropertyPanel view) {
        this.view = view;
    }

    @Override
    public void clear() {
    }

    @Override
    public void paint() {
    }

    @Override
    public void drawLine(ElementDto element) {
        addSelection(element);
    }

    @Override
    public void drawRectangle(ElementDto element) {
        addSelection(element);
    }

    @Override
    public void drawEllipse(ElementDto element) {
        addSelection(element);
    }

    @Override
    public void drawText(ElementDto element) {
        addSelection(element);
    }

    @Override
    public void drawImage(ElementDto element) {
        addSelection(element);
    }

    @Override
    public void clearSelections() {
        view.clearSelections();
    }

    @Override
    public void addSelection(ElementDto element) {
        view.addSelection(element);
    }

    @Override
    public void drawSelections() {
        view.showProperties();
    }
}
