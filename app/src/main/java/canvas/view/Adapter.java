package canvas.view;

import java.util.function.Function;

import canvas.controller.ElementDto;

public interface Adapter {
    public void drawResources(Function<Adapter, Void> resourcesDrawEach);

    public void drawSelections(Function<Adapter, Void> selectionsDrawEach);

    void drawLine(ElementDto element);

    void drawRectangle(ElementDto element);

    void drawEllipse(ElementDto element);

    void drawText(ElementDto element);

    void drawImage(ElementDto element);

}
