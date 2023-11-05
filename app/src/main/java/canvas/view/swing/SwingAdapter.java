package canvas.view.swing;

import canvas.model.Component;
import canvas.view.Adapter;

public class SwingAdapter implements Adapter {
    private SwingView view;

    public SwingAdapter(SwingView view) {
        this.view = view;
    }

    @Override
    public void draw(Component component) {
        // TODO
    }
}
