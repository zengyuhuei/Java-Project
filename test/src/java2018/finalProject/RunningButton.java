package java2018.finalProject;

import java.util.TimerTask;

import javax.swing.JButton;

class RunningButton extends TimerTask {
	
    public JButton btn;
    public final int btnSideLen = 60;
    public double coordinateX; 
    public double coordinateY;
    public double vx = Math.sin(1) * 5;
    public double vy = Math.cos(1) * 5;
    public int crashTimes;
    public final int getWidth = 250;
    public final int getHeigth = 350;
    
	public RunningButton() {
		
	}
	//int derection = (int)(Math.random()*4+1);
    public void run() {
        //boolean crash = false;
        if (coordinateX + vx < 0) {
            vx = -vx;
        }
        if (coordinateX + vx + btnSideLen >= getWidth ) {
            vx = -vx;
        }
        if (coordinateY + vy < 0) {
            vy = -vy;
        }
        if (coordinateY + vy + btnSideLen >= getHeigth) {
            vy = -vy;
        }
        coordinateX += vx;
        coordinateY += vy;
		btn.setBounds((int) coordinateX, (int) coordinateY, btnSideLen, btnSideLen);
    }
}