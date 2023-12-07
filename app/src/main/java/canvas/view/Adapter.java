package canvas.view;

import canvas.controller.ElementDto;
import canvas.model.Color;

public interface Adapter {
    void clear();

    void paint();

    void drawLine(ElementDto element);

    void drawRectangle(ElementDto element);

    void drawEllipse(ElementDto element);

    void drawText(ElementDto element);

    void drawImage(ElementDto element);

    void clearSelections();

    void addSelection(ElementDto element);

    void drawSelections();
}
