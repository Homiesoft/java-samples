import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TempConverter extends BaseForm{
    private JPanel mainForm;
    private JTextField finalValue;
    private JButton btnClear;
    private JButton btnConvert;
    private JTextField iniValue;
    private JComboBox cBoxUnits;

    public TempConverter() {
        String cToF = "C° -> F°";
        String fToC = "F° -> C°";
        btnConvert.addActionListener(e -> {
            try{
                float val = Float.parseFloat(iniValue.getText());
                float newValue = 0f;
                String convFormula = cBoxUnits.getSelectedItem().toString();
                if (convFormula.equals(cToF)) {
                    newValue = val * 1.8f + 32;
                }
                else if (convFormula.equals(fToC)){
                    newValue = (val - 32) / 1.8f;
                }
                finalValue.setText(String.format("%,.1f°", newValue));
            }
            catch(NumberFormatException ex){

            }
            catch(NullPointerException ex){

            }

        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniValue.setText("");
                finalValue.setText("");
            }
        });
        iniValue.setText("0.0");
        cBoxUnits.addItem(cToF);
        cBoxUnits.addItem(fToC);
    }

    public void init() {
        frame = new JFrame("Temperature Converter");
        frame.setContentPane(new TempConverter().mainForm);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        centerFrame();
    }

}
