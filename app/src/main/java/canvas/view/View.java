package canvas.view;

import canvas.controller.Listener;

public interface View {
    void setListener(Listener listener);

    Adapter getAdapter();
}
