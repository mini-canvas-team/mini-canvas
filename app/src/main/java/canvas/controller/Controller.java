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
    private Context context;

    private Controller() {
        listener = new Listener(this);
        context = new Context(this);
        container = new ComponentContainer();
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
            adapter.clear();
            this.container.draw(adapter);
            adapter.paint();
        });
    }

    protected void drawSelections() {
        Integer width = container.getWidth();
        Integer height = container.getHeight();
        Color color = container.getColor();

        this.adapters.forEach(adapter -> adapter.showProperties(width, height, color));
    }
}
