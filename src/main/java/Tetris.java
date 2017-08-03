import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tetris extends BaseForm{
    private JPanel panelInst;
    private JRenderPanel panelRender;
    private JPanel panelMain;
    private JPanel panelGame;
    private final int ROWS = 22;
    private final int COLS = 10;
    private int[][] tGrid;
    private int[][] currentPiece;

    public Tetris(){
        tGrid = new int[ROWS][COLS];
        panelMain.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){

                }
            }
        });
        JRenderPanel panelDraw = new JRenderPanel();
        //panelRender.add(panelDraw);
    }

    public void init(){
        frame = new JFrame("Blockfall");
        frame.setContentPane(new Tetris().panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        System.out.println(panelGame.getSize());
        centerFrame();
    }

    private void createUIComponents() {
        panelGame = new JPanel();
        panelRender = new JRenderPanel();
        panelRender.setBackground(Color.GREEN);
        panelGame.setLayout(new BorderLayout());
        panelGame.add(panelRender);
        //panelRender.setSize(panelRender.getParent().getSize());
        //panelDraw.setSize(panelRender.getSize());
        //
        panelRender.drawBlock(200, 200, 50, 50, Color.RED);
    }

    private int getRenderPanelWidth(){
        return panelGame.getWidth();

    }
    private int getRenderPanelHeight(){
        return panelRender.getHeight();
    }

    private void emptyGrid(){
        for(int i = 0; i < tGrid.length; i++){
            for(int j = 0; j < tGrid[0].length; j++){
                tGrid[i][j] = -1;
            }
        }
    }

    private int getFilledRow(){
        return 0;
    }

    private int[][] rotateLeft(int[][] piece){
        return null;
    }
    private int[][] rotateRight(int[][] piece){
        return null;
    }
    private void movePieceLeft(){

    }
    private void movePieceRight(){

    }

}
