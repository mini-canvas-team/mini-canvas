package canvas.view.swing.frame.down;

import java.awt.Color;
import java.util.stream.Stream;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ColorChooser extends JColorChooser {
    public ColorChooser() {
        setPreviewPanel(new JPanel());
        setColor(Color.BLACK);
        AbstractColorChooserPanel[] panels = getChooserPanels();

        Stream.of(panels).skip(1).forEach(panel -> {
            removeChooserPanel(panel);
        });
    }
}