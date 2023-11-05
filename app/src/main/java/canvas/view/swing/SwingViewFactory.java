package canvas.view.swing;

import canvas.controller.Listener;
import canvas.view.View;
import canvas.view.ViewFactory;

public class SwingViewFactory implements ViewFactory {
    private Listener listener;

    SwingViewFactory(Listener listener) {
        this.listener = listener;
    }

    public View createView() {
        View view = new SwingView();
        view.setListener(listener);

        return view;
    }
}
