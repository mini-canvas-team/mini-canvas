package canvas.view.swing.canvas.panel.left;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.BoxLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import canvas.controller.Listener;
import canvas.view.Adapter;
import canvas.view.swing.canvas.Panel;

public class TypePanel extends JPanel implements Panel {
    Listener listener;
    Adapter adapter;

    public TypePanel(Listener listener, int count) {
        super();

        this.listener = listener;
        this.adapter = new TypeAdapter();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (int i = 0; i < count; ++i) {
            JButton btn = new SelectBtn(i);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    listener.setTool(((SelectBtn) e.getSource()).getIndex());
                }
            });

            add(btn);
        }
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
