package canvas.view.swing.frame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;

import canvas.controller.Listener;
import canvas.view.swing.SwingConverter;

public class SwingCanvas extends Canvas implements MouseListener {
    Listener listener;
    Point point;
    SwingConverter converter;

    public SwingCanvas(Listener listener) {
        super();
        addMouseListener(this);
        this.listener = listener;
        this.converter = new SwingConverter();
        setBackground(Color.WHITE);
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
    }
}
