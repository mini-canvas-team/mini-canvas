package canvas.controller;

import canvas.model.Color;
import canvas.model.Element;
import canvas.model.Point;

public class Listener {
    private Controller controller;

    public Listener(Controller controller) {
        this.controller = controller;
    }

    private ViewState getViewState() {
        return this.controller.getViewState();
    }

    private ComponentContainer getContainer() {
        return this.controller.getContainer();
    }

    // left panel event
    public void setSelectedType(int type) {
        getViewState().setType(type);
    }

    // down panel event
    public void setSelectedColor(Color color) {
        getViewState().setColor(color);
    }

    // right panel event
    public void changeWidth(Integer width) {
        getContainer().setWidth(width);
        controller.draw();
        controller.showProperties();
    }

    public void changeHeight(Integer height) {
        getContainer().setHeight(height);
        controller.draw();
        controller.showProperties();
    }

    public void changeColor(Color color) {
        getContainer().setColor(color);
        controller.draw();
        controller.showProperties();
    }

    public void changeText(String text) {
        getContainer().setText(text);
        controller.draw();
    }

    public void changePath(String path) {
        getContainer().setPath(path);
        controller.draw();
    }

    public void changeIndexFront() {
        getContainer().setFront();
        controller.draw();
    }

    public void changeIndexBack() {
        getContainer().setBack();
        controller.draw();
    }

    // canvas event
    public void click(Point p) {
        if (getViewState().getType() == null) {
            selectObject(p);
            controller.showProperties();
        }
    }

    public void selectObject(Point p) {
        getContainer().selectOne(p);
    }

    private void selectObjects(Point p1, Point p2) {
        getContainer().select(p1, p2);
        controller.showProperties();
    }

    private void addObject(Point p1, Point p2) {
        ElementType type = getViewState().getType();
        Color color = getViewState().getColor();

        if (type != null) {
            Element element = controller.getFactory().create(type, p1, p2, color);
            controller.getContainer().add(element);
            controller.draw();
            controller.showProperties();
        }
    }

    public void drag(Point p1, Point p2) {
        if (getViewState().getType() == null) {
            this.selectObjects(p1, p2);
        } else {
            this.addObject(p1, p2);
        }
    }
}
