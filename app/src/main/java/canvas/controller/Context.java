package canvas.controller;

import canvas.controller.state.ToolDrawEnum;
import canvas.controller.state.ToolSelectState;
import canvas.controller.state.ToolState;
import canvas.model.Color;
import canvas.model.Point;

public class Context {
    private ToolState tool;
    private Color color;

        this.tool = new ToolSelectState();
        this.color = new Color(0, 0, 0);
    }

    public void setTool(int id) {
        this.tool = id == 0 ? new ToolSelectState() : ToolDrawEnum.getById(id);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Point p1, Point p2) {
        this.tool.drag(this, p1, p2);
    }

    public void click(Point p) {
        this.tool.click(this, p);
    }
}
