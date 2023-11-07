package canvas.view.swing.frame.right;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import canvas.controller.Listener;

public class PropertyPanel extends JPanel {
    private PropertyArea areaWidth, areaHeight;
    private PropertyColor areaColor;
    private JButton buttonFront, buttonBack;

    public PropertyPanel(Listener listener) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        areaWidth = new PropertyArea("Width");
        areaWidth.addActionLisenter(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listener.changeWidth(Integer.parseInt(areaWidth.getText()));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        areaHeight = new PropertyArea("Height");
        areaHeight.addActionLisenter(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listener.changeHeight(Integer.parseInt(areaHeight.getText()));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        areaColor = new PropertyColor(listener);

        buttonFront = new JButton("Front");
        buttonFront.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.changeIndexFront();
            }
        });

        buttonBack = new JButton("Back");
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listener.changeIndexBack();
            }
        });

        add(areaWidth);
        add(areaHeight);
        add(areaColor);
        add(buttonFront);
        add(buttonBack);

        showProperties(null, null, null);
    }

    public void showProperties(Integer width, Integer height, Color color) {
        try {
            areaWidth.setText(width.toString());

        } catch (Exception e) {
            areaWidth.setText("null");
        }

        try {
            areaHeight.setText(height.toString());
        } catch (Exception e) {
            areaHeight.setText("null");
        }

        areaColor.showColor(color);
    }
}