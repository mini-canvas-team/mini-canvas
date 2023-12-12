package canvas.view.swing.input;

import java.util.function.Function;

import canvas.controller.ElementDto;
import canvas.view.Adapter;

public class InputAdapter implements Adapter {
    private InputView view;

    protected InputAdapter(InputView view) {
        this.view = view;
    }

    @Override
    public void drawResources(Function<Adapter, Void> resourcesDrawEach) {

    }

    @Override
    public void drawSelections(Function<Adapter, Void> selectionsDrawEach) {

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
    public void listenText() {
        this.view.listenText();
    }

    @Override
    public void listenPath() {
        this.view.listenPath();
    }
}
