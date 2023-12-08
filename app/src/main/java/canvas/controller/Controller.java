package canvas.controller;

import java.util.Set;
import java.util.HashSet;

import canvas.controller.state.ToolDrawEnum;
import canvas.controller.state.ToolSelectState;
import canvas.controller.state.ToolState;
import canvas.model.Color;
import canvas.model.Element;
import canvas.model.Point;
import canvas.view.Adapter;
import canvas.view.PropertyInput;
import canvas.view.swing.SwingPropertyInput;

public class Controller {
    private static Controller instance = new Controller();
    private Set<Adapter> adapters = new HashSet<Adapter>();

    private Listener listener;
    private ComponentContainer container;
    private Context context;
    private PropertyInput pInput;

    private Controller() {
        this.listener = new Listener(this);
        this.context = new Context(this);
        this.container = new ComponentContainer();
        // Replace it to Factory
        this.pInput = new SwingPropertyInput();
    }

    public void addAdapter(Adapter adapter) {
        this.adapters.add(adapter);
    }

    public static Controller getInstance() {
        return instance;
    }

    public Listener getListner() {
        return this.listener;
    }

    protected ComponentContainer getContainer() {
        return this.container;
    }

    protected Context getContext() {
        return this.context;
    }

    protected void drawResources() {
        this.adapters.forEach(adapter -> {
            adapter.drawResources(this.container::drawResources);
        });
    }

    protected void drawSelections() {
        this.adapters.forEach(adapter -> {
            adapter.drawSelections(this.container::drawSelections);
        });
    }

    protected void setTool(int id) {
        ToolState tool = id == 0 ? new ToolSelectState() : ToolDrawEnum.getById(id);
        this.context.setTool(tool);
    }

    protected void setColor(Color color) {
        this.context.setColor(color);
    }

    protected String getText() {
        return pInput.getText();
    }

    protected String getPath() {
        return pInput.getPath();
    }

    protected void drag(Point p1, Point p2) {
        this.context.drag(p1, p2);
    }

    protected void click(Point p) {
        this.context.click(p);
    }

    protected void addElement(Element element) {
        this.getContainer().add(element);
        this.drawResources();
        this.drawSelections();
    }

    protected void selectElement(Point p) {
        this.getContainer().selectOne(p);
        this.drawSelections();
    }

    protected void selectElements(Point p1, Point p2) {
        this.getContainer().select(p1, p2);
        this.drawSelections();
    }

    protected void changeWidth(Integer width) {
        this.getContainer().setWidth(width);
        this.drawResources();
        this.drawSelections();
    }

    protected void changeHeight(Integer height) {
        this.getContainer().setHeight(height);
        this.drawResources();
        this.drawSelections();
    }

    protected void changeColor(Color color) {
        this.getContainer().setColor(color);
        this.drawResources();
        this.drawSelections();
    }

    protected void changeText(String text) {
        this.getContainer().setText(text);
        this.drawResources();
    }

    protected void changePath(String path) {
        this.getContainer().setPath(path);
        this.drawResources();
    }

    protected void changeIndexFront() {
        this.getContainer().setFront();
        this.drawResources();
    }

    protected void changeIndexBack() {
        this.getContainer().setBack();
        this.drawResources();
    }
}
