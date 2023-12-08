package canvas.view.swing.canvas;

import canvas.controller.Listener;
import canvas.view.View;
import canvas.view.ViewFactory;

public class CanvasViewFactory implements ViewFactory {
    @Override
    public View createView(Listener listener) {
        return new CanvasView(listener);
    }
}
