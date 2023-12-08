package canvas.view.swing.frame.right;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import canvas.controller.Listener;
import canvas.view.swing.SwingConverter;

public class PropertyColor extends JPanel {
    Listener listener;
    private PropertyArea redArea, greenArea, blueArea;
    private JButton enterBtn;

    public PropertyColor(Listener listener) {
        super();
        this.listener = listener;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        redArea = new PropertyArea("Red");
        greenArea = new PropertyArea("Green");
        blueArea = new PropertyArea("Blue");
        enterBtn = new JButton("Enter");
        enterBtn.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeColor();
            }
        }));

        add(redArea);
        add(greenArea);
        add(blueArea);
        add(enterBtn);
    }

    public void initInput() {
        redArea.initInput();
        greenArea.initInput();
        blueArea.initInput();
    }

    private void changeColor() {
        try {
            Integer red = Integer.parseInt(redArea.getText());
            Integer green = Integer.parseInt(greenArea.getText());
            Integer blue = Integer.parseInt(blueArea.getText());
            listener.changeColor(SwingConverter.convertColor(new Color(red, green, blue)));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        this.initInput();

    }

    public void showColor(Color c) {

        if (c == null) {
            redArea.setText("null");
            greenArea.setText("null");
            blueArea.setText("null");
            return;
        }

        redArea.setText(String.valueOf(c.getRed()));
        greenArea.setText(String.valueOf(c.getGreen()));
        blueArea.setText(String.valueOf(c.getBlue()));
    }
}
