import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Random;

public class ColorSwapDemo extends BaseForm{
    private JPanel panelMain;
    private JPanel panelCtrl;
    private JTable tblMain;
    private JButton btnRestart;
    private JButton btnStep;
    private JButton btnExit;

    private Color[] colors;
    private final int ROWS = 9;
    private final int COLS = 9;
    private boolean clearFlag;
    //private int[][] data;
    private int[][] marked;
    private String[] colorNames;

    ColorSwapDemo(){
        super();
        colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.MAGENTA};
        colorNames = new String[]{"red","green","blue","yellow","orange","magenta"};
        btnStep.addActionListener(e -> step());
        btnRestart.addActionListener(e -> createBoard());
        btnExit.addActionListener(e -> frame.dispose());
        clearFlag = false;
    }

    private void createBoard(){
        int rows = tblMain.getRowCount();
        int cols = tblMain.getColumnCount();
        Random rand = new Random();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                tblMain.setValueAt(rand.nextInt(colors.length), i, j);
                marked[i][j] = -1;
            }
        }
        clearFlag = false;
    }

    private void clearMarked(){
        for(int i = 0; i < marked.length; i++){
            for(int j = 0; j < marked[0].length; j++){
                marked[i][j] = -1;
            }
        }
    }

    private void fillMarked(){
        int count, k;
        for(int i = 0; i < marked.length; i++){
            for(int j = 0; j < marked[i].length; j++){
                int color = (int)tblMain.getValueAt(i, j);
                // horizontal
                count = 0;
                k = j;
                while(k < marked[0].length && color == (int)tblMain.getValueAt(i, k)){
                    marked[i][k] = marked[i][k] > 0 ? marked[i][k] : 0;
                    count++;
                    k++;
                }
                if(count > 2){
                    for(int l = j; l < Math.min(j + count, marked[0].length); l++){
                        marked[i][l] = 1;
                    }
                }
                // vertical
                count = 0;
                k = i;
                while(k < marked.length && color == (int)tblMain.getValueAt(k, j)){
                    marked[k][j] = marked[k][j] > 0 ? marked[k][j] : 0;
                    count++;
                    k++;
                }
                if(count > 2){
                    for(int l = i; l < Math.min(i + count, marked.length); l++){
                        marked[l][j] = 1;
                    }
                }
            }
        }
    }

    private void selectMarked(){
        boolean foundMatch = false;
        if(clearFlag){
            Random rand = new Random();
            for(int i = marked.length - 1; i > -1; i--){
                for(int j = 0; j < marked[0].length; j++){
                    int value = (int)tblMain.getModel().getValueAt(i, j);
                    if(value == 99){
                        int nextColor = rand.nextInt(colors.length);
                        for(int track = i; track > -1; track--){
                            int color = (int)tblMain.getModel().getValueAt(track, j);
                            if(color != 99){
                                nextColor = color;
                                tblMain.getModel().setValueAt(99, track, j);
                                break;
                            }
                        }
                        tblMain.getModel().setValueAt(nextColor, i, j);
                    }
                }
            }
            clearFlag = false;
        }
        else{
            for(int i = 0; i < marked.length; i++){
                for(int j = 0; j < marked[i].length; j++){
                    if(marked[i][j] > 0 && marked[i][j] != 99){
                        //System.out.println("(" + i + " , " + j + ") = " + colorNames[(int)tblMain.getModel().getValueAt(i, j)]);
                        tblMain.getModel().setValueAt(99, i, j);
                        foundMatch = true;
                    }
                }
            }
            clearFlag = foundMatch;
        }

    }
    private void step(){
        fillMarked();
        selectMarked();
        clearMarked();
    }

    public void init() {
        frame = new JFrame("Color Swap");
        frame.setContentPane(new ColorSwapDemo().panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        centerFrame();
    }

    private void createUIComponents() {
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
                else{
                    comp.setBackground(Color.BLACK);
                    comp.setForeground(Color.BLACK);
                }
                return comp;
            }
        };
        tblMain.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //tblMain.setColumnSelectionAllowed(false);
        //tblMain.setRowSelectionAllowed(false);
        tblMain.setCellSelectionEnabled(true);
        tblMain.setDragEnabled(true);
        tblMain.setSelectionBackground(Color.black);
        tblMain.setTableHeader(null);
        createBoard();
    }

}
