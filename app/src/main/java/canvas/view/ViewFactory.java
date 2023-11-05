package canvas.view;

import canvas.controller.Listener;

public class ViewFactory {
    private Listener listener;

    ViewFactory(Listener listener) {
        this.listener = listener;
    }

    public AwtView createAwtView() {
        AwtView view = new AwtView();
        view.setListener(listener);

        return view;
    }
}
