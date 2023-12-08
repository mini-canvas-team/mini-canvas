package canvas.view.swing.canvas.panel.left;

import java.awt.BorderLayout;

import canvas.controller.Listener;
import canvas.view.swing.canvas.Panel;
import canvas.view.swing.canvas.PanelFactory;

public class TypeFactory implements PanelFactory {
    @Override
    public Panel createView(Listener listener) {
        return new TypePanel(listener, 6);
    }

    @Override
    public String getLayout() {
        return BorderLayout.WEST;
    }
}
