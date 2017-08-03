
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class JRenderPanel extends JPanel {

    public BufferedImage bi;
    Dimension oldSize;

    public JRenderPanel() {
        super();
        bi = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bi,0,0,null);
        repaint();
    }

    public void resizeImg(int width, int height){
        if(bi.getWidth() < width || bi.getHeight() < height){
            BufferedImage newBi = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics g = newBi.createGraphics();
            g.drawImage(bi, 0, 0, null);
            g.dispose();
            bi = newBi;
        }
    }

    public void drawBlock(int x, int y, int width, int height, Color color){
        resizeImg(width, height);
        Graphics g = bi.createGraphics();
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.dispose();
    }

}
