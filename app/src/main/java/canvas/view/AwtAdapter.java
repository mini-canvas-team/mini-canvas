package canvas.view;

import canvas.model.Component;

public class AwtAdapter implements Adapter {
    private AwtView view;

    public AwtAdapter(AwtView view) {
        this.view = view;
    }

    @Override
    public void draw(Component component) {
        // TODO
    }
}
