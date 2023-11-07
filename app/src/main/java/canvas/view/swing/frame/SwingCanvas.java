package canvas.view.swing.frame;

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
import canvas.view.swing.SwingView;

public class SwingCanvas extends Canvas implements MouseListener {
    private Listener listener;
    private Point point;
    private SwingConverter converter;
    private SwingView view;

    public SwingCanvas(Listener listener, SwingView view) {
        super();
        addMouseListener(this);
        setBackground(Color.WHITE);

        this.view = view;
        this.listener = listener;
        this.converter = new SwingConverter();
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
            listener.click(converter.convertPoint(ePoint));
        else
            listener.drag(converter.convertPoint(point), converter.convertPoint(ePoint));
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
