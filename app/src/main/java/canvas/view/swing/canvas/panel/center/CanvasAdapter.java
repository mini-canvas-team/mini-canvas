package canvas.view.swing.canvas.panel.center;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.util.function.Function;

import javax.swing.ImageIcon;

import canvas.controller.ElementDto;
import canvas.model.Point;
import canvas.view.Adapter;
import canvas.view.swing.SwingConverter;

public class CanvasAdapter implements Adapter {
    private CanvasPanel panel;

    public CanvasAdapter(CanvasPanel panel) {
        this.panel = panel;
    }

    @Override
    public void drawResources(Function<Adapter, Void> resourcesDrawEach) {
        this.panel.clearInstructions();
        resourcesDrawEach.apply(this);
        this.panel.paint();
    }

    @Override
    public void drawSelections(Function<Adapter, Void> selectionsDrawEach) {

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

        this.panel.addInstruction(instruction);
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

        this.panel.addInstruction(instruction);
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

        this.panel.addInstruction(instruction);
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

        this.panel.addInstruction(instruction);
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

        this.panel.addInstruction(instruction);
    }

    @Override
    public void listenText() {

    }

    @Override
    public void listenPath() {

    }
}
