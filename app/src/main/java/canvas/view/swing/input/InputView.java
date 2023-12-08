package canvas.view.swing.input;

import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import canvas.controller.Listener;
import canvas.view.Adapter;
import canvas.view.View;

public class InputView implements View {
    private Listener listener;
    private InputAdapter adapter;

    public InputView(Listener listener) {
        this.listener = listener;
        this.adapter = new InputAdapter(this);
    }

    protected void listenText() {
        String text = JOptionPane.showInputDialog("Enter a text");
        this.listener.changeText(text);
    }

    protected void listenPath() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
        jfc.setAcceptAllFileFilterUsed(false);
        int returnVal = jfc.showOpenDialog(null); // Use null instead of getParent()

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String path = jfc.getSelectedFile().getPath();
            this.listener.changePath(path);
        }
    }

    @Override
    public Set<Adapter> getAdapters() {
        return Set.of(this.adapter);
    }
}
