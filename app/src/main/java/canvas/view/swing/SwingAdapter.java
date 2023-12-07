package canvas.view.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.util.function.Function;

import javax.swing.ImageIcon;

import canvas.controller.ElementDto;
import canvas.model.Color;
import canvas.model.Point;
import canvas.view.Adapter;

public class SwingAdapter implements Adapter {
    private SwingView view;

    public SwingAdapter(SwingView view) {
        this.view = view;
    }

    @Override
    public void clear() {
        this.view.clearInstructions();
    }

    @Override
    public void paint() {
        this.view.paint();
    }

    @Override
    public void drawLine(ElementDto element) {
        Function<Graphics, Void> instruction = g -> {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(SwingConverter.convertColor(element.getColor()));

            Point p1 = element.getPoint1();
            Point p2 = element.getPoint2();
            g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());

            return null;
        };

        this.view.addInstruction(instruction);
    }

    @Override
    public void drawRectangle(ElementDto element) {
        Function<Graphics, Void> instruction = g -> {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(SwingConverter.convertColor(element.getColor()));

            Point position = element.getPosition();
            g2d.drawRect(position.getX(), position.getY(), element.getWidth(), element.getHeight());

            return null;
        };

        this.view.addInstruction(instruction);
    }

    @Override
    public void drawEllipse(ElementDto element) {
        Function<Graphics, Void> instruction = g -> {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(SwingConverter.convertColor(element.getColor()));

            Point position = element.getPosition();
            g2d.draw(new Ellipse2D.Double(position.getX(), position.getY(), element.getWidth(), element.getHeight()));

            return null;
        };

        this.view.addInstruction(instruction);
    }

    @Override
    public void drawText(ElementDto element) {
        Function<Graphics, Void> instruction = g -> {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(SwingConverter.convertColor(element.getColor()));

            Point position = element.getPosition();
            g2d.drawString(element.getText(), position.getX(), position.getY());

            return null;
        };

        this.view.addInstruction(instruction);
    }

    @Override
    public void drawImage(ElementDto element) {
        Function<Graphics, Void> instruction = g -> {
            Graphics2D g2d = (Graphics2D) g;

            ImageIcon icon = new ImageIcon(element.getPath());
            Image image = icon.getImage();

            Point position = element.getPosition();
            g2d.drawImage(image, position.getX(), position.getY(), element.getWidth(), element.getHeight(), null);

            return null;
        };

        this.view.addInstruction(instruction);
    }

    @Override
    public void clearSelections() {
        view.clearSelections();
    }

    @Override
    public void addSelection(ElementDto element) {
        view.addProperty(element);
    }

    @Override
    public void drawSelections() {
        view.drawSelections();
    }

}
