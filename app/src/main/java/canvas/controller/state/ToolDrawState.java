package canvas.controller.state;

import canvas.controller.Context;
import canvas.model.Color;
import canvas.model.Element;
import canvas.model.Point;

public interface ToolDrawState extends ToolState {
    public Element create(Point p1, Point p2, Color color);

    @Override
    public default void drag(Context ctx, Point p1, Point p2) {
        Color color = ctx.getColor();

        Element element = this.create(p1, p2, color);
        ctx.addElement(element);
    }

    @Override
    public default void click(Context ctx, Point p) {

    }
}
