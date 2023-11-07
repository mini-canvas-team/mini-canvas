package canvas.view.swing;

import canvas.controller.Listener;
import canvas.view.Adapter;
import canvas.view.View;
import canvas.view.swing.frame.MainFrame;
import canvas.view.swing.frame.SwingCanvas;
import canvas.view.swing.frame.right.PropertyPanel;

public class SwingView implements View {
    private Listener listener;
    private Adapter adapter;
    private MainFrame mainFrame;
    private PropertyPanel propertyPanel;
    private SwingCanvas canvas;

    protected SwingView() {
        this.adapter = new SwingAdapter(this);
    }

    @Override
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public Adapter getAdapter() {
        return adapter;
    }

    public void show() {
        mainFrame = new MainFrame(listener);
        canvas = mainFrame.getCanvas();
        propertyPanel = mainFrame.getPropertyPanel();
    }

    public PropertyPanel getPropertyPanel() {
        return propertyPanel;
    }
}
