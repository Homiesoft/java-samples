import javax.swing.*;
import java.awt.*;

public abstract class BaseForm {
    public JFrame frame;

    public boolean isOpen(){
        return frame != null && frame.isActive();
    }
    public void centerFrame(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dim.getWidth() - frame.getWidth()) / 2;
        int y = (int) (dim.getHeight() - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }
}
