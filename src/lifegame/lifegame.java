package lifegame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class lifegame {
    // GUI���
    JFrame jf;    // ���ϸ��״̬
    boolean[][] st1;
    // ��ʾϸ��״̬
    JPanel[][] jp;
   
    public lifegame(int m, int n) {
        // GUI�����ʼ��
        jf = new JFrame("Life Game");
        st1 = new boolean[m][n];
        jp = new JPanel[m][n];
        jf.setLayout(new GridLayout(m, n, 2, 2));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                jp[i][j] = new JPanel();
                jp[i][j].setBackground(Color.WHITE);
                jf.add(jp[i][j]);
            }
        }
        jf.setSize(500, 600);
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        randomized();
        updata();
        jf.setVisible(true);
    }
   
    
	public void randomized() {
        for (int i = 1; i < st1.length - 1; i++) {
            for (int j = 1; j < st1[i].length - 1; j++) {
                if (Math.random() > 0.5) {
                    st1[i][j] = true;
                } else {
                    st1[i][j] = false;
                }
            }
        }
    }
   
    public void generation() {
        for (int i = 1; i < st1.length - 1; i++) {
            for (int j = 1; j < st1[i].length - 1; j++) {
                int counter = 0;
                if (jp[i - 1][j - 1].getBackground() == Color.green) {
                    counter++;
                }
                if (jp[i - 1][j].getBackground() == Color.green) {
                    counter++;
                }
                if (jp[i - 1][j + 1].getBackground() == Color.green) {
                    counter++;
                }
                if (jp[i][j - 1].getBackground() == Color.green) {
                    counter++;
                }
                if (jp[i][j + 1].getBackground() == Color.green) {
                    counter++;
                }
                if (jp[i + 1][j - 1].getBackground() == Color.green) {
                    counter++;
                }
                if (jp[i + 1][j].getBackground() == Color.green) {
                    counter++;
                }
                if (jp[i + 1][j + 1].getBackground() == Color.green) {
                    counter++;
                }
                if (jp[i][j].getBackground() == Color.green) {
                    if (counter <= 1) {
                        st1[i][j] = false;
                    } else if (counter > 3) {
                        st1[i][j] = false;
                    }
                } else {
                    if (counter == 3) {
                        st1[i][j] = true;
                    }
                }
            }
        }
    }
   
    public void updata() {
        for (int i = 1; i < st1.length - 1; i++) {
            for (int j = 1; j < st1[i].length - 1; j++) {
                if (st1[i][j]) {
                    jp[i][j].setBackground(Color.green);
                } else {
                    jp[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }
    public static void main(String[] args) {
        // ������Ϸ����
    	lifegame lg = new lifegame(60,60);
        // ���г�ʼ��
        lg.randomized();
        // ������ʾ
        lg.updata();
        while (true) {
            // ȡ����һ��
            lg.generation();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // ������ʾ
            lg.updata();
        }
        
 }


}
