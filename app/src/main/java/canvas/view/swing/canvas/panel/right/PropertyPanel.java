package canvas.view.swing.canvas.panel.right;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.List;

import canvas.controller.ElementDto;
import canvas.controller.Listener;
import canvas.view.Adapter;
import canvas.view.swing.SwingConverter;
import canvas.view.swing.canvas.Panel;

public class PropertyPanel extends JPanel implements Panel {
    private PropertyArea areaWidth;
    private PropertyArea areaHeight;
    private PropertyColor areaColor;
    private JButton buttonFront;
    private JButton buttonBack;
    private Adapter adapter;
    private List<ElementDto> selections = new ArrayList<>();

    public PropertyPanel(Listener listener) {
        super();

        this.adapter = new PropertyAdapter(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        areaWidth = new PropertyArea("Width");
        areaWidth.addActionListener(e -> {
            try {
                listener.changeWidth(Integer.parseInt(areaWidth.getText()));
            } catch (Exception ex) {
                System.out.println(ex);
            }

            areaWidth.initInput();

        });

        areaHeight = new PropertyArea("Height");
        areaHeight.addActionListener(e -> {
            try {
                listener.changeHeight(Integer.parseInt(areaHeight.getText()));
            } catch (Exception ex) {
                System.out.println(ex);
            }

            areaHeight.initInput();

        });

        areaColor = new PropertyColor(listener);

        buttonFront = new JButton("Front");
        buttonFront.addActionListener(e -> listener.changeIndexFront());

        buttonBack = new JButton("Back");
        buttonBack.addActionListener(e -> listener.changeIndexBack());

        add(areaWidth);
        add(areaHeight);
        add(areaColor);
        add(buttonFront);
        add(buttonBack);

        showProperties();
    }

    public void addSelection(ElementDto element) {
        this.selections.add(element);
    }

    public void clearSelections() {
        this.selections.clear();
    }

    public void showProperties() {
        Integer width = selections.stream().mapToInt(ElementDto::getWidth).distinct().count() == 1
                ? selections.stream().mapToInt(ElementDto::getWidth).findFirst().getAsInt()
                : null;

        Integer height = selections.stream().mapToInt(ElementDto::getHeight).distinct().count() == 1
                ? selections.stream().mapToInt(ElementDto::getHeight).findFirst().getAsInt()
                : null;

        java.awt.Color color = selections.stream().map(ElementDto::getColor).distinct().count() == 1
                ? selections.stream().map(ElementDto::getColor).findFirst().map(SwingConverter::convertColor).get()
                : null;

        areaWidth.setText(width != null ? width.toString() : "null");

        areaHeight.setText(height != null ? height.toString() : "null");

        areaColor.showColor(color);
    }

    public Adapter getAdapter() {
        return adapter;
    }

    @Override
    public void addTo(JFrame frame, String layout) {
        frame.add(this, layout);
    }
}