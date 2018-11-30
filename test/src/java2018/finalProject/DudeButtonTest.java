package java2018.finalProject;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.event.ActionEvent;

import java.util.Timer;
import java.util.TimerTask;

public class DudeButtonTest{
    public JButton btn;
    public final int btnSideLen = 60;
    public double coordinateX, coordinateY, vx, vy;
    public int crashTimes;

    public DudeButtonTest() {
    	
    	JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);
	    JFrame f = new JFrame("JButton1");
	    f.setBounds(0,0,500,500); 
	    f.setVisible(true); 
	    Container cp=f.getContentPane();
	    cp.setLayout(null);  //取消預設之 BorderLayout
	    
        coordinateX = (int) (Math.random()*400+50);
        coordinateY = (int) (Math.random()*400+50);
        vx = Math.sin(1) * 5;
        vy = Math.cos(1) * 5;
        
        btn = new JButton("動物");
        btn.setBounds((int) coordinateX, (int) coordinateY, btnSideLen, btnSideLen);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               /* double theta = Math.random() * 2 * Math.PI;
            	vx = Math.sin(theta) * 5;
                vy = Math.cos(theta) * 5;*/
            	System.out.println("這是一隻動物");
            }
        });

        cp.add(btn);
        cp.setVisible(true);
        Timer timer = new Timer();
        randomStatus(timer);
    }
    
    public void randomStatus(Timer timer) {
		timer.schedule(new RunningButton(), 1000, 180);
    }

    class RunningButton extends TimerTask {
        public void run() {
            if (coordinateX + vx < 0) {
                vx = -vx;
            }
            if (coordinateX + vx + btnSideLen >= 500) {
                vx = -vx;
            }
            if (coordinateY + vy < 0) {
                vy = -vy;
            }
            if (coordinateY + vy + btnSideLen >= 500) {
                vy = -vy;
            }
            coordinateX += vx;
            coordinateY += vy;
    		btn.setBounds((int) coordinateX, (int) coordinateY, btnSideLen, btnSideLen);
        }
    }

    public static void main(String[] args) {
        new DudeButtonTest();
    }
}
