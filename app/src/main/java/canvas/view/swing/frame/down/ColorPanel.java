package canvas.view.swing.frame.down;

import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

import canvas.controller.Listener;
import canvas.view.swing.SwingConverter;

public class ColorPanel extends JPanel implements ChangeListener {
    ColorChooser chooser;
    Listener listener;
    SwingConverter converter;

    public ColorPanel(Listener listener) {
        super();
        this.chooser = new ColorChooser();
        this.listener = listener;
        this.converter = new SwingConverter();
        chooser.getSelectionModel().addChangeListener(this);
        add(chooser);
    }

    @Override
    public void stateChanged(javax.swing.event.ChangeEvent e) {
        listener.setSelectedColor(converter.convertColor(chooser.getColor()));
        System.out.println(chooser.getColor());
    }
}