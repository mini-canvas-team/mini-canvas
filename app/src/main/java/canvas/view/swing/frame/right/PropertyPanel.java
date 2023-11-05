package canvas.view.swing.frame.right;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import canvas.controller.Listener;
import canvas.view.swing.SwingConverter;

public class PropertyPanel extends JPanel {
    private SwingConverter converter;
    Color color;
    PropertyArea areaWidth, areaHeight, areaRed, areaGreen, areaBlue;
    JButton buttonFront, buttonBack;

    public PropertyPanel(Listener listener) {
        super();
        this.converter = new SwingConverter();
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
        areaRed = new PropertyArea("Red");
        areaRed.addActionLisenter(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer red = Integer.parseInt(areaRed.getText());
                    listener.changeColor(converter.convertColor(new Color(red, color.getGreen(),
                            color.getBlue())));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        areaGreen = new PropertyArea("Green");
        areaGreen.addActionLisenter(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    Integer green = Integer.parseInt(areaGreen.getText());
                    listener.changeColor(
                            converter.convertColor(new Color(color.getRed(), green, color.getBlue())));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        areaBlue = new PropertyArea("Blue");
        areaBlue.addActionLisenter(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer blue = Integer.parseInt(areaBlue.getText());
                    listener.changeColor(
                            converter.convertColor(new Color(color.getRed(), color.getGreen(), blue)));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

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
        add(areaRed);
        add(areaGreen);
        add(areaBlue);
        add(buttonFront);
        add(buttonBack);

    }

    public void showProperties(Integer width, Integer height, Color color) {
        this.color = color;

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

        if (color == null) {
            areaRed.setText("null");
            areaGreen.setText("null");
            areaBlue.setText("null");
        } else {
            areaRed.setText(Integer.toString(color.getRed()));
            areaGreen.setText(Integer.toString(color.getGreen()));
            areaBlue.setText(Integer.toString(color.getBlue()));
        }
    }
}