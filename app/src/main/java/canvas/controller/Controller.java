package canvas.controller;

import canvas.model.Color;
import canvas.model.Point;

public class Controller {
    private static Controller instance = new Controller();
    private ComponentContainer componentContainer;
    private ObjectFactory objectFactory;
    private int selectedObject;
    private Color selectedColor;

    private Controller() {
        componentContainer = new ComponentContainer();
        objectFactory = new ObjectFactory();
        selectedObject = 0;
        selectedColor = new Color(255, 255, 255);
    }

    public static Controller getInstance() {
        return instance;
    }

    // left panel event
    public void setSelectedObject(int type) {
        selectedObject = type;
    }

    // down panel event
    public void setSelectedColor(Color color) {
        selectedColor = color;
    }

    // canvas event
    public void click(Point p) {
        if (selectedObject == 0) {
            selectObject(p);
            showProperties();
        }
    }

    public void selectObject(Point p) {
        componentContainer.selectOne(p);
    }

    public void drag(Point p1, Point p2) {
        if (selectedObject == 0) {
            selectObjects(p1, p2);
        } else {
            addObject(p1, p2);
            redraw();
        }
        showProperties();
    }

    private void selectObjects(Point p1, Point p2) {
        componentContainer.select(p1, p2);
        showProperties();
    }

    private void addObject(Point p1, Point p2) {
        componentContainer.add(objectFactory.create(selectedObject, p1, p2, selectedColor));
        redraw();
    }

    private void redraw() {

    }

    // right panel event
    public void changeWidth(Integer width) {
        componentContainer.setWidth(width);
        redraw();
    }

    public void changeHeight(Integer height) {
        componentContainer.setHeight(height);
        redraw();
    }

    public void changeColor(Color color) {
        componentContainer.setColor(color);
        redraw();
    }

    public void changeIndexFront() {
        componentContainer.setFront();
        redraw();
    }

    public void changeIndexBack() {
        componentContainer.setBack();
        redraw();
    }

    // right panel function
    private void showProperties() {
        showObjectWidth();
        showObjectHeight();
        showObjectColor();
    }

    private void showObjectWidth() {
        Integer width = componentContainer.getWidth();
    }

    private void showObjectHeight() {
        Integer height = componentContainer.getHeight();
    }

    private void showObjectColor() {
        Color color = componentContainer.getColor();
    }
}
