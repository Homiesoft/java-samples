import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rot13 extends BaseForm{
    private JPanel panelMain;
    private JPanel panelLblIn;
    private JPanel panelLblOut;
    private JTextArea txtIn;
    private JTextArea txtOut;
    private JButton btnChiper;

    public Rot13() {
        btnChiper.addActionListener(e -> {
            txtOut.setText("");
            String text = txtIn.getText();
            for(int i = 0; i < text.length(); i++){
                char cChar = text.charAt(i);
                if((cChar >= 'A' && cChar <= 'M') || (cChar >= 'a' && cChar <= 'm'))
                    cChar += 13;
                else if((cChar > 'M' && cChar <= 'Z') || (cChar > 'm' && cChar <= 'z'))
                    cChar -= 13;
                txtOut.append(String.valueOf(cChar));
            }
        });
    }

    public void init() {
        frame = new JFrame("Rot 13 Cipher");
        frame.setContentPane(new Rot13().panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        centerFrame();
    }
}
