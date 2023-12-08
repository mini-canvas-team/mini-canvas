package canvas.controller;

import canvas.model.Color;
import canvas.model.Point;

public class Listener {
    private Controller controller;

    protected Listener(Controller controller) {
        this.controller = controller;
    }

    // left panel event
    public void setTool(int type) {
        this.controller.setTool(type);
    }

    // down panel event
    public void setColor(Color color) {
        this.controller.setColor(color);
    }

    // right panel event
    public void changeWidth(Integer width) {
        this.controller.changeWidth(width);
    }

    public void changeHeight(Integer height) {
        this.controller.changeHeight(height);
    }

    public void changeColor(Color color) {
        this.controller.changeColor(color);
    }

    public void changeText(String text) {
        this.controller.changeText(text);
    }

    public void changePath(String path) {
        this.controller.changePath(path);
    }

    public void changeIndexFront() {
        this.controller.changeIndexFront();
    }

    public void changeIndexBack() {
        this.controller.changeIndexBack();
    }

    // canvas event
    public void click(Point p) {
        this.controller.click(p);
    }

    public void drag(Point p1, Point p2) {
        this.controller.drag(p1, p2);
    }
}
