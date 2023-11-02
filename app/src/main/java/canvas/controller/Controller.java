package canvas.controller;

import canvas.model.Color;
import canvas.model.Point;

public class Controller {
    private static Controller instance = new Controller();
    private int selectedObject;
    private Color selectedColor;

    private Controller() {
        selectedObject = 0;
        selectedColor = new Color(255, 255, 255);
    }

    public static Controller getInstance() {
        return instance;
    };

    // down panel event
    public void setSelectedColor(Color color) {
        selectedColor = color;
    };

    // canvas event
    public void click(Point p) {
        showProperties();
    };

    public void drag(Point p1, Point p2) {
        if (selectedObject == 0)
            selectObjects(p1, p2);
        else
            addObject(p1, p2);
    };

    private void selectObjects(Point p1, Point p2) {
        showProperties();
    };

    private void addObject(Point p1, Point p2) {
        redraw();
    };

    private void redraw() {

    };

    // right panel event
    public void changeWidth(int width) {

    };

    public void changeHeight(int height) {

    };

    public void changeColor(Color color) {

    };

    public void changeIndexFront() {

    };

    public void changeIndexBack() {

    };

    // right panel function
    private void showProperties() {
        showObjectWidth();
        showObjectHeight();
        showObjectColor();
    };

    private void showObjectWidth() {

    };

    private void showObjectHeight() {

    };

    private void showObjectColor() {

    };

}
