package canvas.view.swing.canvas.panel.center;

import java.awt.BorderLayout;

import canvas.controller.Listener;
import canvas.view.swing.canvas.Panel;
import canvas.view.swing.canvas.PanelFactory;

public class CanvasFactory implements PanelFactory {
    @Override
    public Panel createView(Listener listener) {
        return new CanvasPanel(listener);
    }

    @Override
    public String getLayout() {
        return BorderLayout.CENTER;
    }
}
