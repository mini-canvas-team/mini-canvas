package canvas.controller.state;

import canvas.controller.Context;
import canvas.model.Point;

public interface ToolState {
    public void drag(Context ctx, Point p1, Point p2);

    public void click(Context ctx, Point p);
}
