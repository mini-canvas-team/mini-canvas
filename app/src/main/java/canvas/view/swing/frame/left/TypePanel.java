package canvas.view.swing.frame.left;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import canvas.controller.Listener;

public class TypePanel extends JPanel {
    Listener listener;

    public TypePanel(Listener listener, int count) {
        super();

        this.listener = listener;

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
}
