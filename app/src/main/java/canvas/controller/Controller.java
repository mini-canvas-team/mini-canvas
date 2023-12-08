package canvas.controller;

import java.util.Set;
import java.util.HashSet;

import canvas.view.Adapter;

public class Controller {
    private static Controller instance = new Controller();
    private Set<Adapter> adapters = new HashSet<Adapter>();

    private Listener listener;
    private ComponentContainer container;
    private ElementFactory factory;
    private ViewState viewState;

    private Controller() {
        listener = new Listener(this);
        container = new ComponentContainer();
        factory = new ElementFactory();
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

    protected ElementFactory getFactory() {
        return this.factory;
    }

    protected ViewState getViewState() {
        return this.viewState;
    }

    protected void drawResources() {
        this.adapters.forEach(adapter -> {
            adapter.clear();
            this.container.draw(adapter);
            adapter.paint();
        });
    }

    protected void drawSelections() {
        this.adapters.forEach(adapter -> {
            adapter.clearSelections();
            this.container.drawSelection(adapter);
            adapter.drawSelections();
        });

    }
}
