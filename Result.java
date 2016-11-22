package APP;

import java.awt.BorderLayout;  
import java.awt.Dimension;  
import java.awt.FlowLayout;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
  
import javax.swing.AbstractButton;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
  
  
public class Result extends JFrame{  
    int i;  
    JPanel panel;  
    public Result(int i){  
        this.i = i;  
    }  
      
    /* 
     * 定义一个生成界面的方法 
     */  
    public void initUI(){  
        this.setTitle("结果");  
        this.setSize(new Dimension(400,200));  
        this.setLocationRelativeTo(null);  
        this.setResizable(false);  
        this.setLayout(new BorderLayout());  
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);  
          
        panel = new JPanel();  
        panel.setLayout(new FlowLayout());  
        this.add(panel,BorderLayout.CENTER);  
        if(i == 1){  
            JLabel lab = new JLabel("黑子五连，黑子胜！");  
            panel.add(lab,BorderLayout.CENTER);  
              
        }  
        else if(i == -1){  
                JLabel lab = new JLabel("白子五连，白子胜！");  
                panel.add(lab);  
        }  
          
        JPanel pal = new JPanel();  
        JButton btn_restart = new JButton("重新开始");  
        JButton btn_exit = new JButton("退出游戏");  
        btn_restart.setActionCommand("restart");  
        btn_exit.setActionCommand("exit");  
          

          
        pal.setLayout(new FlowLayout());  
        this.add(pal,BorderLayout.SOUTH);  
        pal.add(btn_restart);  
        pal.add(btn_exit);  
          
          
        this.setVisible(true);  
  
    }  
  
  
}
