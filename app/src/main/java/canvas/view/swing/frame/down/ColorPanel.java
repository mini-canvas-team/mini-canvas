package canvas.view.swing.frame.down;

import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

import canvas.controller.Listener;
import canvas.view.swing.SwingConverter;

public class ColorPanel extends JPanel implements ChangeListener {
    Listener listener;
    ColorChooser chooser;

    public ColorPanel(Listener listener) {
        super();
        this.listener = listener;
        this.chooser = new ColorChooser();
        chooser.getSelectionModel().addChangeListener(this);
        add(chooser);
    }

    @Override
    public void stateChanged(javax.swing.event.ChangeEvent e) {
        listener.setColor(SwingConverter.convertColor(chooser.getColor()));
        System.out.println(chooser.getColor());
    }
}
