package canvas.view.swing.input;

import canvas.controller.Listener;
import canvas.view.View;
import canvas.view.ViewFactory;

public class InputViewFactory implements ViewFactory {
    @Override
    public View createView(Listener listener) {
        return new InputView(listener);
    }
}
