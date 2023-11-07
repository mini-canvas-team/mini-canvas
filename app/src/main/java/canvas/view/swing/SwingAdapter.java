package canvas.view.swing;

import canvas.controller.ElementDto;
import canvas.model.Color;
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
        this.view.addInstruction(null);
    }

    @Override
    public void drawRectangle(ElementDto element) {
        this.view.addInstruction(null);
    }

    @Override
    public void drawEllipse(ElementDto element) {
        this.view.addInstruction(null);
    }

    @Override
    public void drawText(ElementDto element) {
        this.view.addInstruction(null);
    }

    @Override
    public void drawImage(ElementDto element) {
        this.view.addInstruction(null);
    }

    @Override
    public void showProperties(Integer width, Integer height, Color color) {
        view.getPropertyPanel().showProperties(width, height, new SwingConverter().convertColor(color));
    }

}
