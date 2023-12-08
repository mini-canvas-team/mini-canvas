package canvas.view.swing.canvas.panel.left;

import javax.swing.JButton;

public class SelectBtn extends JButton {
    private int index;

    public SelectBtn(int i) {
        super("" + i);

        index = i;
    }

    public int getIndex() {
        return index;
    }
}
