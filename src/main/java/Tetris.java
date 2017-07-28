import javax.swing.*;

public class Tetris extends BaseForm{
    private JPanel panelInst;
    private JPanel panelRender;
    private JPanel panelMain;

    public void init(){
        frame = new JFrame("Tetris");
        frame.setContentPane(new Tetris().panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        centerFrame();
    }
}
