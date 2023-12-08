package canvas.view.swing;

import canvas.controller.Controller;
import canvas.controller.Listener;
import canvas.view.View;
import canvas.view.ViewFactory;

public class SwingViewFactory implements ViewFactory {
    private Listener listener;

    public SwingViewFactory() {
        this.listener = Controller.getInstance().getListner();
    }

    public View createView() {
        SwingView view = new SwingView();

        view.setListener(listener);
        Controller.getInstance().addAdapter(view.getAdapter());
        Controller.getInstance().addAdapter(view.getPropertyPanel().getAdapter());
        view.show();
        return view;
    }
}
