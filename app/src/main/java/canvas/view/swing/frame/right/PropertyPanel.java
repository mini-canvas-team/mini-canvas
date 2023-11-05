package canvas.view.swing.frame.right;

import javax.swing.JPanel;

import canvas.controller.Listener;

public class PropertyPanel extends JPanel {
    Listener listener;

    public PropertyPanel(Listener listener) {
        super();
        this.listener = listener;
    }
}