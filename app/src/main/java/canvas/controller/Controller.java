package canvas.controller;

import canvas.model.Color;

public class Controller {
    private static Controller instance = new Controller();

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

    public static Controller getInstance() {
        return instance;
    }

    public Listener getListner(Listener listener) {
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
