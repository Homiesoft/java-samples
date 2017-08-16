import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by homefriend on 2017-07-09.
 */
public class DemoMenu extends BaseForm {

    private JPanel panel1;
    private JButton btnTempConv;
    private JButton btnRot13;
    private JButton btnExit;
    private JButton btnFizzBuzz;
    private JButton btnTetris;
    private JButton btnColorSwap;

    public DemoMenu() {
        TempConverter tc = new TempConverter();
        Rot13 rot13 = new Rot13();
        FizzBuzz fib = new FizzBuzz();
        Tetris bf = new Tetris();
        ColorSwapDemo cswap = new ColorSwapDemo();
        btnExit.addActionListener(e -> {
            System.exit(0);
            frame.dispose();
        });
        btnTempConv.addActionListener(e -> {
            if(!tc.isOpen()){
                tc.init();
            }
        });
        btnRot13.addActionListener(e -> {
            if(!rot13.isOpen()){
                rot13.init();
            }
        });
        btnFizzBuzz.addActionListener(e -> {
            if(!fib.isOpen()){
                fib.init();
            }
        });
        btnTetris.addActionListener(e -> {
            if(!bf.isOpen()){
                bf.init();
            }
        });
        btnColorSwap.addActionListener(e -> {
            if(!cswap.isOpen()){
                cswap.init();
            }

        });
    }

    public void init() {
        frame = new JFrame("Java Samples");
        frame.setContentPane(new DemoMenu().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        centerFrame();
    }
}
