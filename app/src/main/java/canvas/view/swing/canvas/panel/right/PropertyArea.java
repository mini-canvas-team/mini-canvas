package canvas.view.swing.canvas.panel.right;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;

public class PropertyArea extends JPanel {
    private PropertyShow show;
    private PropertyInput input;
    private String name;

    public PropertyArea(String name) {
        super();
        this.name = name;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        show = new PropertyShow();
        show.setText(name);
        add(show);

        input = new PropertyInput();
        add(input);
    }

    public void initInput() {
        input.setText("");
    }

    public void setText(String text) {
        show.setText(name + " : " + text);
    }

    public String getText() {
        return input.getText();
    }

    public void addActionListener(ActionListener listener) {
        input.addActionListener(listener);
    }
}
