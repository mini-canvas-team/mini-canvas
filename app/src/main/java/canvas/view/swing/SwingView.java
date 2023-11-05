package canvas.view.swing;

import canvas.controller.Listener;
import canvas.view.Adapter;
import canvas.view.View;
import canvas.view.swing.frame.MainFrame;

public class SwingView implements View {
    private Listener listener;
    private Adapter adapter;

    protected SwingView() {
        this.adapter = new SwingAdapter(this);
        new MainFrame(listener);
    }

    @Override
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public Adapter getAdapter() {
        return adapter;
    }

}
