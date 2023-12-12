package canvas.view;

import canvas.controller.Listener;

public interface ViewFactory {
    public View createView(Listener listener);
}
