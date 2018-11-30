package java2018.finalProject;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Timer;
import java.util.TimerTask;

public class DudeButtonTest extends JFrame {
    public JButton btn;
    public final int btnSideLen = 60;
    public double coordinateX, coordinateY, vx, vy;
    public int crashTimes;

    public DudeButtonTest() {
        this.setTitle("A6");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLayout(null);

        coordinateX = (int) (Math.random()*400+50);
        coordinateY = (int) (Math.random()*400+50);
        vx = Math.sin(1) * 5;
        vy = Math.cos(1) * 5;
        
        btn = new JButton("動物");
        btn.setBounds((int) coordinateX, (int) coordinateY, btnSideLen, btnSideLen);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double theta = Math.random() * 2 * Math.PI;
                vx = Math.sin(theta) * 5;
                vy = Math.cos(theta) * 5;
            	System.out.println("這是一隻動物");
            }
        });

        this.add(btn);
        this.setVisible(true);
        Timer timer = new Timer();
        randomStatus(timer);
        try {
        	Thread.sleep(3000);
        }
        catch(InterruptedException e) {
        	
        }
        timer.cancel();
  
        
    }
    
    public void randomStatus(Timer timer) {
		timer.schedule(new RunningButton(), 1000, 120);
    }

    class RunningButton2 extends TimerTask {
    	public void run() {
    		btn.setBounds((int) coordinateX, (int) coordinateY, btnSideLen, btnSideLen);
    	}
    }
    class RunningButton extends TimerTask {
    	//int derection = (int)(Math.random()*4+1);
        public void run() {
            //boolean crash = false;
            if (coordinateX + vx < 0) {
                vx = -vx;
            }
            if (coordinateX + vx + btnSideLen >= getWidth()) {
                vx = -vx;
            }
            if (coordinateY + vy < 0) {
                vy = -vy;
            }
            if (coordinateY + vy + btnSideLen >= getHeight()) {
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
