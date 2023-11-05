package canvas.view.swing.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import canvas.controller.Listener;
import canvas.view.swing.frame.down.ColorPanel;
import canvas.view.swing.frame.left.TypePanel;
import canvas.view.swing.frame.right.PropertyPanel;

public class MainFrame extends JFrame {
    public MainFrame(Listener listener) {
        super("miniFrame");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        setLayout(new BorderLayout());
        setSize(screenSize.width, screenSize.height * 3 / 4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new SwingCanvas(listener), BorderLayout.CENTER);
        add(new ColorPanel(listener), BorderLayout.SOUTH);
        add(new PropertyPanel(listener), BorderLayout.EAST);
        add(new TypePanel(listener, 6), BorderLayout.WEST);
        setVisible(true);
    }
}