package APP;

import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.List;
import java.awt.Point;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import java.util.Random;  
  
import javax.swing.JPanel;  
  
public class Listener extends MouseAdapter {  
    /* 
     * 设置黑白棋标识 true表示黑子执子，false表示白子 
     */  
    public static boolean state = true;  
    public Graphics g;  
    public int x, y;   
    public static int[][] chessBoard = new int[Size.ROW][Size.COLUMN];   
    public static int count_max;  
    public static int count_where = 0;  
    public JPanel panel;  
    public static Result result;  
    public static List list;  
    public static int val;  
  
    /* 
     * 重载他·的构造方法 
     */  
    public Listener(Graphics g) {  
        this.g = g;  
        // this.panel = panel;  
    }  
  
    /* 
     * 鼠标释放执行的方法 
     */  
    public void mouseReleased(MouseEvent e) {  
        x = correctXY(e.getX());  
        y = correctXY(e.getY());  
        System.out.println("x:"+e.getX() +"   y:"+e.getY());
        System.out.println("x:"+x+"   y:"+y);  
        /* 
         * 判定为人人对战 
         */  
       
            if (x < 640 && x >= 0 && y < 640 && y >= 0) {  
                if (state && chessBoard[getLocation(y)][getLocation(x)] == 0) {  
                    g.setColor(Color.BLACK);  
                    g.fillOval(x, y, Size.CHESS_SIZE,  
                            Size.CHESS_SIZE);    
  
                    chessBoard[getLocation(y)][getLocation(x)] = 1;  
                    state = false;  
  
                } else if (chessBoard[getLocation(y)][getLocation(x)] == 0) {  
                    g.setColor(Color.WHITE);  
                    g.fillOval(x, y, Size.CHESS_SIZE,  
                            Size.CHESS_SIZE);  
  
                    chessBoard[getLocation(y)][getLocation(x)] = -1;  
                    state = true;  
                }  
                
                //判断胜负
                if (Win(getLocation(y), getLocation(x)) == 1) {  //如果服务器返回胜利
                    result = new Result(1);  
                    result.initUI();  
                } else if (Win(getLocation(y), getLocation(x)) == -1) {  //如果服务器返回失败
                    result = new Result(-1);  
                    result.initUI();  
                }  
                
            }  
  
        }  
  
       
    /* 
     * 下棋位置坐标修正的方法 
     */  
    public int correctXY(int x) {  
        x = x / 40;  
  
        return x * 40;  
    }  
  
    public int getLocation(int x) {  
        x = x / 40;  
        return x;  
    }  
    /* 
     * 判赢方法 
     */  
  
    /* 
     * 判定横向五个相连 
     */  
    public boolean winRow(int row, int column) {  
        int count = 1;  
        for (int i = column + 1; i < Size.COLUMN; i++) {// 向右查找  
            if (chessBoard[row][column] == chessBoard[row][i]) {  
                count++;  
            } else  
                break;  
        }  
        for (int i = column - 1; i >= 0; i--) {// 向左查找  
            if (chessBoard[row][column] == chessBoard[row][i]) {  
                count++;  
            } else  
                break;  
        }  
  
        if (count >= 5) {  
            return true;  
        } else  
            return false;  
    }  
  
    /* 
     * 判定竖向五个相连 
     */  
    public boolean winColumn(int row, int column) {  
        int count = 1;  
        for (int i = row + 1; i < Size.ROW; i++) {// 向右查找  
            if (chessBoard[row][column] == chessBoard[i][column]) {  
                count++;  
            } else  
                break;  
        }  
        for (int i = row - 1; i >= 0; i--) {// 向左查找  
            if (chessBoard[row][column] == chessBoard[i][column]) {  
                count++;  
            } else  
                break;  
        }  
        if (count >= 5) {  
            return true;  
        } else  
            return false;  
    }  
  
    /* 
     * 判定斜向右下五个相连 
     */  
    public boolean winRightDown(int row, int column) {  
        int count = 1;  
        for (int i = column + 1, j = row + 1; i < Size.COLUMN && j < Size.ROW; i++, j++) {// 向右查找  
            if (chessBoard[row][column] == chessBoard[j][i]) {  
                count++;  
            } else  
                break;  
        }  
        for (int i = column - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {// 向左查找  
            if (chessBoard[row][column] == chessBoard[j][i]) {  
                count++;  
            } else  
                break;  
        }  
        if (count >= 5) {  
            return true;  
        } else  
            return false;  
    }  
  
    /* 
     * 判定斜向左下五个相连 
     */  
    public boolean winLeftDown(int row, int column) {  
        int count = 1;  
        for (int i = column - 1, j = row + 1; i >= 0 && j < Size.ROW; i--, j++) {// 向右查找  
            if (chessBoard[row][column] == chessBoard[j][i]) {  
                count++;  
            } else  
                break;  
        }  
        for (int i = column + 1, j = row - 1; i < Size.COLUMN && j >= 0; i++, j--) {// 向左查找  
            if (chessBoard[row][column] == chessBoard[j][i]) {  
                count++;  
            } else  
                break;  
        }  
        if (count >= 5) {  
            return true;  
        } else  
            return false;  
    }  
  
    public int Win(int row, int column) {  
        if (winRow(row, column) || winColumn(row, column)  
                || winRightDown(row, column) || winLeftDown(row, column)) {  
            if (chessBoard[row][column] == 1)  
                return 1;  
            else if (chessBoard[row][column] == -1)  
                return -1;  
        }  
        return 0;  
    }  
  
}  
