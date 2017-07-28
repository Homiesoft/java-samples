import javax.swing.*;

public class FizzBuzz extends BaseForm{
    private JPanel panel1;
    private JTextArea txtOut;
    private JTextField txtRange;
    private JPanel panelRange;
    private JButton btnStart;


    public FizzBuzz() {
        btnStart.addActionListener(e -> {
            try{
                int val = Integer.parseInt(txtRange.getText());
                txtOut.setText("");
                if(val < 1){
                    txtOut.append("Pick a number greater than 0");
                }
                else{
                    for(int i = 1; i <= val; i++){
                        String out = (i % 3 == 0 ? "Fizz" : "") + (i % 5 == 0 ? "Buzz" : "") + (i % 3 != 0 && i % 5 != 0 ? "" + i : "" );
                        txtOut.append(out + "\n");
                    }
                }
            }
            catch(NumberFormatException ex){

            }
        });
    }

    public void init(){
        frame = new JFrame("FizzBuzz");
        frame.setContentPane(new FizzBuzz().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        centerFrame();
    }
}
