package canvas;

import java.util.Set;

import canvas.controller.Controller;
import canvas.controller.Listener;
import canvas.view.Adapter;
import canvas.view.View;
import canvas.view.swing.canvas.CanvasViewFactory;
import canvas.view.swing.input.InputViewFactory;

public class App {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        Listener listener = controller.getListener();

        Set
                .of(new CanvasViewFactory(), new InputViewFactory())
                .forEach(factory -> {
                    View view = factory.createView(listener);
                    Set<Adapter> adapters = view.getAdapters();
                    adapters.forEach(adapter -> {
                        controller.addAdapter(adapter);
                    });
                });
    }
}
