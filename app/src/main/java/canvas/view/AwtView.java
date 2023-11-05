package canvas.view;

import canvas.controller.Listener;

public class AwtView implements View {
    private Listener listener;
    private Adapter adapter;

    protected AwtView() {
        this.adapter = new AwtAdapter(this);
    }

    @Override
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public Adapter getAdapter() {
        return getAdapter();
    }

}
