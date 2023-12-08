package canvas.view.swing.canvas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Set;

import javax.swing.JFrame;

import canvas.controller.Controller;
import canvas.view.swing.canvas.panel.center.CanvasFactory;
import canvas.view.swing.canvas.panel.down.ColorFactory;
import canvas.view.swing.canvas.panel.left.TypeFactory;
import canvas.view.swing.canvas.panel.right.PropertyFactory;

public class CanvasView extends JFrame {
    Set<PanelFactory> panelFactories = Set.of(
            new ColorFactory(),
            new TypeFactory(),
            new PropertyFactory(),
            new CanvasFactory());

    public CanvasView() {
        super("miniFrame");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        setLayout(new BorderLayout());
        setSize(screenSize.width, screenSize.height * 3 / 4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Controller controller = Controller.getInstance();

        panelFactories.forEach(factory -> {
            Panel panel = factory.createView(controller.getListner());
            controller.addAdapter(panel.getAdapter());

            panel.addTo(this, factory.getLayout());
        });

        setVisible(true);
    }
}
