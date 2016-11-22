package APP;

import java.awt.*;
import javax.swing.*;

public class ChessBoard extends JFrame {
	public Graphics g;
	
	public ChessBoard() {
		init();
	}
	
	void init() {
		this.setTitle("五子棋");  
        this.setSize(new Dimension(670, 690));  
        this.setResizable(false);  
        this.setDefaultCloseOperation(3);  
        this.setLocationRelativeTo(null);  
        this.setLayout(null); 
        /* 
         * 添加一块棋盘 
         */  
        this.setLayout(null);  
        JPanel jp = new JPanel() {   
            public void paint(Graphics g) {  
                g.setColor(Color.BLACK);  
                super.paint(g);  
                // 画15行  
                for (int i = 0; i < Size.ROW; i++) {  
                    g.drawLine(20, 20 + i * Size.DISTANCE, 20  
                            + (Size.COLUMN - 1) * Size.DISTANCE,  
                            20 + i * Size.DISTANCE);  
                }  
                // 画15列  
                for (int i = 0; i < Size.COLUMN; i++) {  
                    g.drawLine(20 + i * Size.DISTANCE, 20, 20 + i  
                            * Size.DISTANCE, 20  
                            + (Size.COLUMN - 1) * Size.DISTANCE);  
                }  
                g.setColor(Color.BLACK);  
                g.fillOval(173, 173, 16, 16);  
                g.fillOval(173, 453, 16, 16); 
                g.fillOval(453, 453, 16, 16);
                g.fillOval(453, 173, 16, 16);
                // 重绘棋子  
                for (int i = 0; i < Size.ROW; i++) {  
                    for (int j = 0; j < Size.COLUMN; j++) {  
                        if (Listener.chessBoard[i][j] == 1) {  
                            g.setColor(Color.BLACK);  
                            g.fillOval(i*40, j*40, Size.CHESS_SIZE,  
                                    Size.CHESS_SIZE);  
                        } else if (Listener.chessBoard[i][j] == -1) {  
                            g.setColor(Color.WHITE);  
                            g.fillOval(i*40, j*40, Size.CHESS_SIZE,  
                                    Size. CHESS_SIZE);  
                        }  
                    }  
                } 
            }  
        };  
        jp.setBackground(new Color(209, 167, 78));  
        jp.setBounds(11, 11, 640, 640);  
        this.add(jp);  
  
        this.setVisible(true);  
        g = jp.getGraphics();  
 
        Listener listener = new Listener(g);  
        jp.addMouseListener(listener);  
	}
	public static void main(String[] args) {
		ChessBoard cb = new ChessBoard();
	}
}
