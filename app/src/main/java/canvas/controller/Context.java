package canvas.controller;

import canvas.controller.state.ToolSelectState;
import canvas.controller.state.ToolState;
import canvas.model.Color;
import canvas.model.Element;
import canvas.model.Point;

public class Context {
    private Controller controller;

    private ToolState tool;
    private Color color;

    protected Context(Controller controller) {
        this.controller = controller;
        this.tool = new ToolSelectState();
        this.color = new Color(0, 0, 0);
    }

    protected void setTool(ToolState tool) {
        this.tool = tool;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void listenText() {
        this.controller.listenText();
    }

    public void listenPath() {
        this.controller.listenPath();
    }

    protected void drag(Point p1, Point p2) {
        this.tool.drag(this, p1, p2);
    }

    protected void click(Point p) {
        this.tool.click(this, p);
    }

    public void addElement(Element element) {
        this.controller.addElement(element);
    }

    public void selectElement(Point p) {
        this.controller.selectElement(p);
    }

    public void selectElements(Point p1, Point p2) {
        this.controller.selectElements(p1, p2);
    }
}
