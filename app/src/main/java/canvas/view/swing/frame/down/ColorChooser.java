package canvas.view.swing.frame.down;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ColorChooser extends JColorChooser {
    public ColorChooser() {
        setPreviewPanel(new JPanel());
        setColor(Color.BLACK);
        AbstractColorChooserPanel[] panels = getChooserPanels();
        for (int i = 0; i < panels.length; i++) {
            if (!panels[i].getDisplayName().equals("Swatches")) {
                removeChooserPanel(panels[i]);
            } else {
                JPanel panel = panels[i];
                System.out.println(panel.getComponentCount()); // 1
                System.out.println(panel.getPreferredSize()); // width=424,height=112
                System.out.println(panel.getLayout()); // FlowLayout[hgap=5,vgap=5,align=center]
            }
        }
    }
}