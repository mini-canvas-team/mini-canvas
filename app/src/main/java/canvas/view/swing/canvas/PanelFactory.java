package canvas.view.swing.canvas;

import canvas.controller.Listener;

public interface PanelFactory {
    Panel createView(Listener listener);

    String getLayout();
}
