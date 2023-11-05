package canvas.view.swing.frame.right;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

import canvas.controller.Listener;
import canvas.view.swing.SwingConverter;

public class PropertyPanel extends JPanel {
    private Listener listener;
    private SwingConverter converter;
    Color color;
    PropertyArea areaWidth, areaHeight, areaRed, areaGreen, areaBlue;

    public PropertyPanel(Listener listener) {
        super();
        this.listener = listener;
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
        areaWidth.addActionLisenter(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listener.changeHeight(Integer.parseInt(areaWidth.getText()));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        areaRed = new PropertyArea("Red");
        areaWidth.addActionLisenter(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer red = Integer.parseInt(areaWidth.getText());
                    listener.changeColor(converter.convertColor(new Color(red, color.getGreen(),
                            color.getBlue())));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        areaGreen = new PropertyArea("Green");
        areaWidth.addActionLisenter(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    Integer green = Integer.parseInt(areaWidth.getText());
                    listener.changeColor(
                            converter.convertColor(new Color(color.getRed(), green, color.getBlue())));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        areaBlue = new PropertyArea("Blue");
        areaWidth.addActionLisenter(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer blue = Integer.parseInt(areaWidth.getText());
                    listener.changeColor(
                            converter.convertColor(new Color(color.getRed(), color.getGreen(), blue)));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        add(areaWidth);
        add(areaHeight);
        add(areaRed);
        add(areaGreen);
        add(areaBlue);
    }

    public void showProperties(Integer width, Integer height, Color color) {
        this.color = color;

        areaWidth.setText(width.toString());
        areaHeight.setText(height.toString());
        areaRed.setText(Integer.toString(color.getRed()));
        areaGreen.setText(Integer.toString(color.getGreen()));
        areaBlue.setText(Integer.toString(color.getBlue()));

    }
}