package canvas.view.swing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import canvas.controller.ElementDto;
import canvas.controller.Listener;
import canvas.view.Adapter;
import canvas.view.View;
import canvas.view.swing.frame.MainFrame;
import canvas.view.swing.frame.SwingCanvas;
import canvas.view.swing.frame.right.PropertyPanel;

public class SwingView implements View {
    private Listener listener;
    private SwingAdapter adapter;
    private PropertyPanel propertyPanel;
    private SwingCanvas canvas;
    private List<Function<Graphics, Void>> instructions = new ArrayList<>();
    private List<ElementDto> selections = new ArrayList<>();

    protected SwingView() {
        this.adapter = new SwingAdapter(this);
    }

    @Override
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public Adapter getAdapter() {
        return adapter;
    }

    public void show() {
        MainFrame mainFrame = new MainFrame(listener, this);
        canvas = mainFrame.getCanvas();
        propertyPanel = mainFrame.getPropertyPanel();
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

    public void addProperty(ElementDto element) {
        this.selections.add(element);
    }

    public void clearSelections() {
        this.selections.clear();
    }

    public void drawSelections() {
        Integer width = selections.stream().mapToInt(ElementDto::getWidth).distinct().count() == 1
                ? selections.stream().mapToInt(ElementDto::getWidth).findFirst().getAsInt()
                : null;

        Integer height = selections.stream().mapToInt(ElementDto::getHeight).distinct().count() == 1
                ? selections.stream().mapToInt(ElementDto::getHeight).findFirst().getAsInt()
                : null;

        java.awt.Color color = selections.stream().map(ElementDto::getColor).distinct().count() == 1
                ? selections.stream().map(ElementDto::getColor).findFirst().map(SwingConverter::convertColor).get()
                : null;

        propertyPanel.showProperties(width, height, color);
    }
}
