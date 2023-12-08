package canvas.view.swing.canvas.panel.center;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.swing.JFrame;

import canvas.controller.Listener;
import canvas.view.Adapter;
import canvas.view.swing.canvas.Panel;
import canvas.view.swing.canvas.panel.right.PropertyPanel;

public class CanvasPanel implements Panel {
    private CanvasAdapter adapter;
    private PropertyPanel propertyPanel;
    private CanvasArea canvas;
    private List<Function<Graphics, Void>> instructions = new ArrayList<>();

    protected CanvasPanel(Listener listener) {
        this.canvas = new CanvasArea(listener, this);
        this.adapter = new CanvasAdapter(this);
    }

    protected void addInstruction(Function<Graphics, Void> instruction) {
        this.instructions.add(instruction);
    }

    public void clearInstructions() {
        this.instructions.clear();
    }

    public List<Function<Graphics, Void>> getInstructions() {
        return this.instructions;
    }

    public void paint() {
        this.canvas.repaint();
    }

    public PropertyPanel getPropertyPanel() {
        return propertyPanel;
    }

    @Override
    public Adapter getAdapter() {
        return adapter;
    }

    @Override
    public void addTo(JFrame frame, String layout) {
        frame.add(this.canvas, layout);
    }

}
