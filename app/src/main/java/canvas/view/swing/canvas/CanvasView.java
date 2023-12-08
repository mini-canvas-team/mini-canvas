package canvas.view.swing.canvas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import canvas.controller.Listener;
import canvas.view.Adapter;
import canvas.view.View;
import canvas.view.swing.canvas.panel.center.CanvasFactory;
import canvas.view.swing.canvas.panel.down.ColorFactory;
import canvas.view.swing.canvas.panel.left.TypeFactory;
import canvas.view.swing.canvas.panel.right.PropertyFactory;

public class CanvasView extends JFrame implements View {
    private Set<Adapter> adapters;

    Set<PanelFactory> panelFactories = Set.of(
            new ColorFactory(),
            new TypeFactory(),
            new PropertyFactory(),
            new CanvasFactory());

    public CanvasView(Listener listener) {
        super("miniFrame");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        setLayout(new BorderLayout());
        setSize(screenSize.width, screenSize.height * 3 / 4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.adapters = panelFactories.stream().map(factory -> {
            Panel panel = factory.createView(listener);
            panel.addTo(this, factory.getLayout());

            return panel.getAdapter();
        }).collect(Collectors.toSet());

        setVisible(true);
    }

    @Override
    public Set<Adapter> getAdapters() {
        return this.adapters;
    }
}
