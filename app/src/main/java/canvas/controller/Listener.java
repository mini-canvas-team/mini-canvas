package canvas.controller;

import canvas.model.Color;
import canvas.model.Point;

public class Listener {
    private Controller controller;

    public Listener(Controller controller) {
        this.controller = controller;
    }

    private Context getContext() {
        return this.controller.getContext();
    }

    private ComponentContainer getContainer() {
        return this.controller.getContainer();
    }

    // left panel event
    public void setTool(int type) {
        this.getContext().setTool(type);
    }

    // down panel event
    public void setColor(Color color) {
        this.getContext().setColor(color);
    }

    // right panel event
    public void changeWidth(Integer width) {
        getContainer().setWidth(width);
        controller.drawResources();
        controller.drawSelections();
    }

    public void changeHeight(Integer height) {
        getContainer().setHeight(height);
        controller.drawResources();
        controller.drawSelections();
    }

    public void changeColor(Color color) {
        getContainer().setColor(color);
        controller.drawResources();
        controller.drawSelections();
    }

    public void changeText(String text) {
        getContainer().setText(text);
        controller.drawResources();
    }

    public void changePath(String path) {
        getContainer().setPath(path);
        controller.drawResources();
    }

    public void changeIndexFront() {
        getContainer().setFront();
        controller.drawResources();
    }

    public void changeIndexBack() {
        getContainer().setBack();
        controller.drawResources();
    }

    // canvas event
    public void click(Point p) {
        this.getContext().click(p);
    }

    public void drag(Point p1, Point p2) {
        this.getContext().draw(p1, p2);
    }
}
