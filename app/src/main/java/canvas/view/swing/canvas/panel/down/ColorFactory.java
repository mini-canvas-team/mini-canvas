package canvas.view.swing.canvas.panel.down;

import java.awt.BorderLayout;

import canvas.controller.Listener;
import canvas.view.swing.canvas.Panel;
import canvas.view.swing.canvas.PanelFactory;

public class ColorFactory implements PanelFactory {
    @Override
    public Panel createView(Listener listener) {
        return new ColorPanel(listener);
    }

    @Override
    public String getLayout() {
        return BorderLayout.SOUTH;
    }
}
