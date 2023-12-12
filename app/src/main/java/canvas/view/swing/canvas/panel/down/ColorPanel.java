package canvas.view.swing.canvas.panel.down;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

import canvas.controller.Listener;
import canvas.view.Adapter;
import canvas.view.swing.SwingConverter;
import canvas.view.swing.canvas.Panel;

public class ColorPanel extends JPanel implements Panel, ChangeListener {
    Listener listener;
    Adapter adapter;
    ColorChooser chooser;

    public ColorPanel(Listener listener) {
        super();

        this.listener = listener;
        this.adapter = new ColorAdapter();

        this.chooser = new ColorChooser();
        chooser.getSelectionModel().addChangeListener(this);
        add(chooser);
    }

    @Override
    public void stateChanged(javax.swing.event.ChangeEvent e) {
        listener.setColor(SwingConverter.convertColor(chooser.getColor()));
        System.out.println(chooser.getColor());
    }

    @Override
    public Adapter getAdapter() {
        return this.adapter;
    }

    @Override
    public void addTo(JFrame frame, String layout) {
        frame.add(this, layout);
    }
}
