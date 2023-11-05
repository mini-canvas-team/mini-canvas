package canvas.view.swing;

import canvas.controller.ElementDto;
import canvas.model.Color;
import canvas.model.Component;
import canvas.view.Adapter;

public class SwingAdapter implements Adapter {
    private SwingView view;

    public SwingAdapter(SwingView view) {
        this.view = view;
    }

    @Override
    public void drawLine(ElementDto element) {
    }

    @Override
    public void drawRectangle(ElementDto element) {
    }

    @Override
    public void drawEllipse(ElementDto element) {
    }

    @Override
    public void drawText(ElementDto element) {
    }

    @Override
    public void drawImage(ElementDto element) {
    }

    @Override
    public void showProperties(Integer width, Integer height, Color color) {
    }

}
