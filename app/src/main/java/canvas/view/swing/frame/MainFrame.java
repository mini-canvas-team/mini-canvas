package canvas.view.swing.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import canvas.controller.Listener;
import canvas.view.swing.SwingView;
import canvas.view.swing.frame.down.ColorPanel;
import canvas.view.swing.frame.left.TypePanel;
import canvas.view.swing.frame.right.PropertyPanel;

public class MainFrame extends JFrame {
    private PropertyPanel propertyPanel;
    private SwingCanvas canvas;

    public MainFrame(Listener listener, SwingView view) {
        super("miniFrame");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        setLayout(new BorderLayout());
        setSize(screenSize.width, screenSize.height * 3 / 4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new SwingCanvas(listener, view);
        add(canvas, BorderLayout.CENTER);
        add(new ColorPanel(listener), BorderLayout.SOUTH);
        propertyPanel = new PropertyPanel(listener);
        add(propertyPanel, BorderLayout.EAST);
        add(new TypePanel(listener, 6), BorderLayout.WEST);
        setVisible(true);
    }

    public PropertyPanel getPropertyPanel() {
        return propertyPanel;
    }

    public SwingCanvas getCanvas() {
        return canvas;
    }
}