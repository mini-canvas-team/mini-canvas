package canvas.view.swing.canvas.panel.center;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.function.Function;
import java.awt.Graphics;

import canvas.controller.Listener;
import canvas.view.swing.SwingConverter;

public class CanvasArea extends Canvas implements MouseListener {
    private Listener listener;
    private Point point;
    private CanvasPanel view;

    public CanvasArea(Listener listener, CanvasPanel view) {
        super();

        addMouseListener(this);
        setBackground(Color.WHITE);

        this.view = view;
        this.listener = listener;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        point = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point ePoint = e.getPoint();

        if (point.equals(ePoint))
            listener.click(SwingConverter.convertPoint(ePoint));
        else
            listener.drag(SwingConverter.convertPoint(point), SwingConverter.convertPoint(ePoint));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void paint(Graphics g) {
        List<Function<Graphics, Void>> instructions = this.view.getInstructions();
        instructions.forEach(instruction -> instruction.apply(g));
    }
}
