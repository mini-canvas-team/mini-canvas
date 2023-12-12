package canvas.view.swing.canvas.panel.right;

import java.awt.BorderLayout;

import canvas.controller.Listener;
import canvas.view.swing.canvas.Panel;
import canvas.view.swing.canvas.PanelFactory;

public class PropertyFactory implements PanelFactory {
    @Override
    public Panel createView(Listener listener) {
        return new PropertyPanel(listener);
    }

    @Override
    public String getLayout() {
        return BorderLayout.EAST;
    }
}
