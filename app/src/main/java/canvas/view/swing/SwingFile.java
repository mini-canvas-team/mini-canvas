package canvas.view.swing;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import canvas.view.PropertyInput;

public class SwingFile implements PropertyInput {

    @Override
    public String getText() {
        return JOptionPane.showInputDialog("Enter a text");
    }

    @Override
    public String getPath() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
        jfc.setAcceptAllFileFilterUsed(false);
        int returnVal = jfc.showOpenDialog(null); // Use null instead of getParent()

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return jfc.getSelectedFile().getPath();
        }
        return null;
    }
}
