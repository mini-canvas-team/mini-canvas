package canvas.view.swing.canvas;

import javax.swing.JFrame;

import canvas.view.Adapter;

public interface Panel {
    void addTo(JFrame frame, String layout);

    Adapter getAdapter();
}
