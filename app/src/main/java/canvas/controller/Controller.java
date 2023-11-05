package canvas.controller;

import java.util.Set;
import java.util.HashSet;

import canvas.model.Color;
import canvas.view.Adapter;

public class Controller {
    private static Controller instance = new Controller();
    private Set<Adapter> adapters = new HashSet<Adapter>();

    private Listener listener;
    private ComponentContainer container;
    private ObjectFactory factory;
    private ViewState viewState;

    private Controller() {
        listener = new Listener(this);
        container = new ComponentContainer();
        factory = new ObjectFactory();
        viewState = new ViewState();
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

    protected ObjectFactory getFactory() {
        return this.factory;
    }

    protected ViewState getViewState() {
        return this.viewState;
    }

    protected void draw() {
        // TODO
    }

    protected void showProperties() {
        Integer width = container.getWidth();
        Integer height = container.getHeight();
        Color color = container.getColor();

        // TODO
    }
}
