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
    private JButton btnRestart;
    private JButton btnStep;
    private JButton btnExit;
    private JPanel panelDraw;
    private Color[] colors;
    //private Color[][] data;
    private final int ROWS = 9;
    private final int COLS = 9;
    private int phase;
    //private int[][] data;
    private int[][] marked;

    public ColorSwapDemo(){
        super();
        colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.MAGENTA};
        btnStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                step();
            }
        });
        btnRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createBoard();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getDefaultCloseOperation();
            }
        });
    }

    private void createBoard(){
        int rows = tblMain.getRowCount();
        int cols = tblMain.getColumnCount();
        //int rows = data.length;
        //int cols = data[0].length;
        Random rand = new Random();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                tblMain.setValueAt(rand.nextInt(colors.length), i, j);
                marked[i][j] = -1;
            }
        }
        //tblMain.setModel(new DefaultTableModel(data,null));
    }
    private void step(){

    }

    public void init() {
        JFrame frame = new JFrame("Color Swap");
        frame.setContentPane(new ColorSwapDemo().panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        centerFrame();
        phase = 0;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //data = new int[ROWS][COLS];
        marked = new int[ROWS][COLS];
        tblMain = new JTable(ROWS, COLS){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                Object value = getModel().getValueAt(row, col);
                int num = (int)value;
                if(num > -1 && num < colors.length){
                    comp.setBackground(colors[num]);
                    comp.setForeground(colors[num]);
                }
                return comp;
            }
        };
        tblMain.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tblMain.setColumnSelectionAllowed(false);
        tblMain.setRowSelectionAllowed(false);
        tblMain.setSelectionBackground(Color.cyan);
        tblMain.setTableHeader(null);
        createBoard();
    }

}
