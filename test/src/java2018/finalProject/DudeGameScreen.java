package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java2018.finalProject.DudeScreen.RunningButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DudeGameScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DudeGameScreen frame = new DudeGameScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	ImageIcon chickenleft = new ImageIcon("../picture/chickenleft.gif");
	ImageIcon chickenright = new ImageIcon("../picture/chickenright.gif");
	ImageIcon pigleft = new ImageIcon("../picture/pigleft.gif");
	ImageIcon pigright = new ImageIcon("../picture/pigright.gif");
	ImageIcon cowleft = new ImageIcon("../picture/cowleft.gif");
	ImageIcon cowright = new ImageIcon("../picture/cowright.gif");
	ImageIcon cowhead = new ImageIcon("../picture/cowhead.PNG");
	ImageIcon pighead = new ImageIcon("../picture/pighead.png");
	ImageIcon chickenhead = new ImageIcon("../picture/chickenhead.png");
	JLabel dudeAnimalNum = new JLabel("需捕捉數量:");
	JLabel dudeCowNum = new JLabel(cowhead, JLabel.LEFT);
	JLabel dudePigNum = new JLabel(pighead, JLabel.LEFT);
	JLabel dudeChickenNum = new JLabel(chickenhead, JLabel.LEFT);
	ImageIcon dudeNumback = new ImageIcon("../picture/dudeNumBack.PNG");
	JLabel dudeNumBack = new JLabel(dudeNumback, JLabel.CENTER);
	JButton home = new JButton("回首頁");
	JButton animal1 = new JButton("牛");
	JButton animal2 = new JButton("豬");
	JButton animal3 = new JButton("雞");
	JButton animal4 = new JButton("牛");
	JButton animal5 = new JButton("豬");
	JButton animal6 = new JButton("雞");
	JButton animal7 = new JButton("牛");
	JButton animal8 = new JButton("豬");
	JButton animal9 = new JButton("雞");
	JButton animal10 = new JButton("豬");
	JButton animal11 = new JButton("雞");
	JButton animal12 = new JButton("雞");
	ArrayList<JButton> button = new ArrayList<JButton>(10);

	
	public DudeGameScreen() {
		WareHouse warehouse = new WareHouse();
		Dude dude = new Dude(warehouse);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int cowNum = (int)(Math.random()*4);
		int pigNum = (int)(Math.random()*5);
		int chickenNum = (int)(Math.random()*6);
		int period = 220;
		button.add(animal1);
		button.add(animal2);
		button.add(animal3);
		button.add(animal4);
		button.add(animal5);
		button.add(animal6);
		button.add(animal7);
		button.add(animal8);
		button.add(animal9);
		button.add(animal10);
		button.add(animal11);
		button.add(animal12);
		
		dudeAnimalNum.setBounds(207, 47, 181, 43);
		contentPane.add(dudeAnimalNum);
		dudeAnimalNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudeAnimalNum.setVisible(true);
		
		dudeCowNum.setBounds(419, 47, 131, 43);
		contentPane.add(dudeCowNum);
		dudeCowNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudeCowNum.setText(" X "+(int)cowNum);
		dudeCowNum.setVisible(true);
		
		dudePigNum.setBounds(551, 45, 131, 43);
		contentPane.add(dudePigNum);
		dudePigNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudePigNum.setText(" X "+(int)pigNum);
		dudePigNum.setVisible(true);
		
		dudeChickenNum.setBounds(683, 44, 131, 43);
		contentPane.add(dudeChickenNum);
		dudeChickenNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudeChickenNum.setText(" X "+(int)chickenNum);
		dudeChickenNum.setVisible(true);
		
		dudeNumBack.setBounds(135, 22, 701, 99);
		contentPane.add(dudeNumBack);
		dudeNumBack.setVisible(true);
		
		home.setFont(new Font("Dialog", Font.BOLD, 20));
		home.setBounds(1008, 526, 117, 65);
		contentPane.add(home);
		
		animal1.setFont(new java.awt.Font("Dialog", 1, 20));
		animal1.setBounds(456, 231, 100, 100);
		contentPane.add(animal1);
		Timer timer1 = new Timer();
		RunningButton run1 = new RunningButton(animal1, 456, 231);
		timer1.schedule(run1, 1000, period);
		
		animal2.setFont(new Font("Dialog", Font.BOLD, 20));
		animal2.setBounds(384, 415, 100, 100);
		contentPane.add(animal2);
		Timer timer2 = new Timer();
		RunningButton run2 = new RunningButton(animal2, 384, 415);
		timer2.schedule(run2, 1000, period);
		
		animal3.setFont(new Font("Dialog", Font.BOLD, 20));
		animal3.setBounds(214, 312, 100, 100);
		contentPane.add(animal3);
		Timer timer3 = new Timer();
		RunningButton run3 = new RunningButton(animal3, 214, 312);
		timer3.schedule(run3, 1000, period);
		
		animal4.setFont(new Font("Dialog", Font.BOLD, 20));
		animal4.setBounds(656, 318, 100, 100);
		contentPane.add(animal4);
		Timer timer4 = new Timer();
		RunningButton run4 = new RunningButton(animal4, 658, 318);
		timer4.schedule(run4, 1000, period);
		
		animal5.setFont(new Font("Dialog", Font.BOLD, 20));
		animal5.setBounds(207, 183, 100, 100);
		contentPane.add(animal5);
		Timer timer5 = new Timer();
		RunningButton run5 = new RunningButton(animal5, 207, 183);
		timer5.schedule(run5, 1000, period);
		
		animal6.setFont(new Font("Dialog", Font.BOLD, 20));
		animal6.setBounds(274, 403, 100, 100);
		contentPane.add(animal6);
		Timer timer6 = new Timer();
		RunningButton run6 = new RunningButton(animal6, 260, 403);
		timer6.schedule(run6, 1000, period);
		
		animal7.setFont(new Font("Dialog", Font.BOLD, 20));
		animal7.setBounds(336, 217, 100, 100);
		contentPane.add(animal7);
		Timer timer7 = new Timer();
		RunningButton run7 = new RunningButton(animal7, 336, 217);
		timer7.schedule(run7, 1000, period);
		
		animal8.setFont(new Font("Dialog", Font.BOLD, 20));
		animal8.setBounds(585, 394, 100, 100);
		contentPane.add(animal8);
		Timer timer8 = new Timer();
		RunningButton run8 = new RunningButton(animal8, 585, 394);
		timer8.schedule(run8, 1000, period);
		
		animal9.setFont(new Font("Dialog", Font.BOLD, 20));
		animal9.setBounds(620, 150, 100, 100);
		contentPane.add(animal9);
		Timer timer9 = new Timer();
		RunningButton run9 = new RunningButton(animal9, 620, 150);
		timer9.schedule(run9, 1000, 220);
		
		animal10.setFont(new Font("Dialog", Font.BOLD, 20));
		animal10.setBounds(582, 255, 100, 100);
		contentPane.add(animal10);
		Timer timer10 = new Timer();
		RunningButton run10 = new RunningButton(animal10, 582, 255);
		timer10.schedule(run10, 1000, period);

		animal11.setFont(new Font("Dialog", Font.BOLD, 20));
		animal11.setBounds(469, 353, 100, 100);
		contentPane.add(animal11);
		Timer timer11 = new Timer();
		RunningButton run11 = new RunningButton(animal11, 469, 353);
		timer10.schedule(run11, 1000, period);
		
		animal12.setFont(new Font("Dialog", Font.BOLD, 20));
		animal12.setBounds(708, 330, 100, 100);
		contentPane.add(animal12);
		Timer timer12 = new Timer();
		RunningButton run12 = new RunningButton(animal12, 708, 330);
		timer12.schedule(run12, 1000, period);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setLocation(66, 10);
		ImageIcon img = new ImageIcon("../picture/dude.jpg");
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(new_img));
		lblNewLabel.setSize(1200, 675);
		contentPane.add(lblNewLabel);
	}
	public void returnLR(JButton btn) {
		
	}
	
	  class RunningButton extends TimerTask {
	    	private JButton btn;
	    	private double coordinateX, coordinateY;
	    	private double vx, vy;
	    	private int random = (int)(Math.random()*4);
	    	public RunningButton(JButton btn, double coordinateX, double coordinateY) {
	        	this.btn = btn;
	        	this.coordinateX = coordinateX;
	        	this.coordinateY = coordinateY;
	        	if(random==0) {
	        		vx = Math.sin(1) * 5;
	            	vy = Math.cos(1) * 5;
	            	showButtonRight();
	        	}
	        	if(random==1) {
	        		vx = -Math.sin(1) * 5;
	            	vy = Math.cos(1) * 5;
	            	showButtonLeft();
	        	}
	        	if(random==2) {
	        		vx = Math.sin(1) * 5;
	            	vy = -Math.cos(1) * 5;
	            	showButtonRight();
	        	}
	        	else {
	        		vx = -Math.sin(1) * 5;
	            	vy = -Math.cos(1) * 5;
	            	showButtonLeft();
	        	}
	    	}
	        public void run() {
	            if (coordinateX + vx < 50) {
	                vx = -vx;
	                showButtonRight();
	            }
	            if (coordinateX + vx + 60 > 880) {
	                vx = -vx;
	                showButtonLeft();
	            }
	            if (coordinateY + vy < 100) {
	                vy = -vy;
	            }
	            if (coordinateY + vy + 25 > 450) {
	                vy = -vy;
	            }
	            coordinateX += vx;
	            coordinateY += vy;
	            btn.setBounds((int) coordinateX, (int) coordinateY, 150, 150);
	    		
	        }
	        public void showButtonLeft() {
	        	buttonGIF();
	        	if(btn.getText()=="雞")
    			{
    				btn.setIcon(chickenleft);
    			}
    			if(btn.getText()=="豬")
    			{
    				btn.setIcon(pigleft);
    			}
    			if(btn.getText()=="牛")
    			{
    				btn.setIcon(cowleft);
    			}
    			btn.setVisible(true);
			
	        }
	        public void showButtonRight() {
	        	buttonGIF();
	        	if(btn.getText()=="雞")
				{
					btn.setIcon(chickenright);
				}
				if(btn.getText()=="豬")
				{
					btn.setIcon(pigright);
				}
				if(btn.getText()=="牛")
				{
					btn.setIcon(cowright);
				}
				btn.setVisible(true);
	        	

	        }
	        public void buttonGIF()
	        {
	        	for(int i=0; i<button.size(); i++)
	        	{
	        		button.get(i).setOpaque(false);
	        		button.get(i).setContentAreaFilled(false);
	        		button.get(i).setFocusPainted(false);
	        		button.get(i).setBorder(null);
	        	}
	        }
	        public int getVX() {
	        	if(vx>0) {
	        		return 1;
	        	}
	        	else {
	        		return -1;
	        	}
	        }
	    }

}
