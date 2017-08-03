import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColorSwapDemo extends BaseForm{
    private JPanel panelMain;
    private JPanel panelCtrl;
    private JTable tblMain;
    private JButton btnNew;
    private JButton btnStep;
    private Color[] colors;
    //private Color[][] data;
    private final int ROWS = 9;
    private final int COLS = 9;
    private int[][] marked;

    public ColorSwapDemo(){
        super();
        colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.MAGENTA};
        btnStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createBoard();
            }
        });
    }

    public void init() {
        JFrame frame = new JFrame("ColorSwapDemo");
        frame.setContentPane(new ColorSwapDemo().panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createBoard(){
        int rows = tblMain.getRowCount();
        int cols = tblMain.getColumnCount();
        //int rows = data.length;
        //int cols = data[0].length;
        Random rand = new Random();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Color c = colors[rand.nextInt(colors.length)];
                tblMain.setValueAt(c, i, j);
            }
        }
        //tblMain.setModel(new DefaultTableModel(data,null));
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        tblMain = new JTable(ROWS, COLS){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                Object value = getModel().getValueAt(row, col);
                if (value instanceof Color) {
                    comp.setBackground((Color)value);
                    comp.setForeground((Color)value);
                }
                return comp;
            }
        };
        tblMain.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tblMain.setColumnSelectionAllowed(false);
        tblMain.setRowSelectionAllowed(false);
        tblMain.setSelectionBackground(Color.cyan);
        tblMain.setTableHeader(null);
        //tblMain.setDefaultRenderer(Color.class, new CellRenderer());
        marked = new int[ROWS][COLS];
        createBoard();
    }

}
