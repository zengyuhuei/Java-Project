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
import java.sql.Time;
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
	JButton animal1 = new JButton();
	JButton animal2 = new JButton();
	JButton animal3 = new JButton();
	JButton animal4 = new JButton();
	JButton animal5 = new JButton();
	JButton animal6 = new JButton();
	JButton animal7 = new JButton();
	JButton animal8 = new JButton();
	JButton animal9 = new JButton();
	JButton animal10 = new JButton();
	JButton animal11 = new JButton();
	JButton animal12 = new JButton();
	ArrayList<JButton> button = new ArrayList<JButton>(12);
	ArrayList<RunningButton> run = new ArrayList<RunningButton>(12);
	ArrayList<Timer> time = new ArrayList<Timer>(12);
	
	int cowNum = (int)(Math.random()*6+3);
	int pigNum = (int)(Math.random()*5+3);
	int chickenNum = (int)(Math.random()*4+2);
	int period = 50;
	int sum = cowNum + pigNum + chickenNum;
	
	public DudeGameScreen() {
		WareHouse warehouse = new WareHouse();
		Dude dude = new Dude(warehouse);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		Timer timer2 = new Timer();
		RunningButton run2 = new RunningButton(animal2, 384, 415);
		timer2.schedule(run2, 1000, period);
		Timer timer3 = new Timer();
		RunningButton run3 = new RunningButton(animal3, 214, 312);
		timer3.schedule(run3, 1000, period);
		Timer timer4 = new Timer();
		RunningButton run4 = new RunningButton(animal4, 658, 318);
		timer4.schedule(run4, 1000, period);
		Timer timer5 = new Timer();
		RunningButton run5 = new RunningButton(animal5, 207, 183);
		timer5.schedule(run5, 1000, period);
		Timer timer6 = new Timer();
		RunningButton run6 = new RunningButton(animal6, 260, 403);
		timer6.schedule(run6, 1000, period);
		Timer timer7 = new Timer();
		RunningButton run7 = new RunningButton(animal7, 336, 217);
		timer7.schedule(run7, 1000, period);
		Timer timer8 = new Timer();
		RunningButton run8 = new RunningButton(animal8, 585, 394);
		timer8.schedule(run8, 1000, period);
		Timer timer9 = new Timer();
		RunningButton run9 = new RunningButton(animal9, 620, 150);
		timer9.schedule(run9, 1000, 220);
		Timer timer10 = new Timer();
		RunningButton run10 = new RunningButton(animal10, 582, 255);
		timer10.schedule(run10, 1000, period);
		Timer timer11 = new Timer();
		RunningButton run11 = new RunningButton(animal11, 469, 353);
		timer10.schedule(run11, 1000, period);
		Timer timer12 = new Timer();
		RunningButton run12 = new RunningButton(animal12, 708, 330);
		timer12.schedule(run12, 1000, period);
		
		animal2.setFont(new Font("Dialog", Font.BOLD, 20));
		animal2.setBounds(384, 415, 100, 100);
		contentPane.add(animal2);
			
		animal3.setFont(new Font("Dialog", Font.BOLD, 20));
		animal3.setBounds(214, 312, 100, 100);
		contentPane.add(animal3);
		
		animal4.setFont(new Font("Dialog", Font.BOLD, 20));
		animal4.setBounds(656, 318, 100, 100);
		contentPane.add(animal4);
		
		animal5.setFont(new Font("Dialog", Font.BOLD, 20));
		animal5.setBounds(207, 183, 100, 100);
		contentPane.add(animal5);
		
		animal6.setFont(new Font("Dialog", Font.BOLD, 20));
		animal6.setBounds(274, 403, 100, 100);
		contentPane.add(animal6);
		
		animal7.setFont(new Font("Dialog", Font.BOLD, 20));
		animal7.setBounds(336, 217, 100, 100);
		contentPane.add(animal7);
		
		animal8.setFont(new Font("Dialog", Font.BOLD, 20));
		animal8.setBounds(585, 394, 100, 100);
		contentPane.add(animal8);
		
		animal9.setFont(new Font("Dialog", Font.BOLD, 20));
		animal9.setBounds(620, 150, 100, 100);
		contentPane.add(animal9);
		
		animal10.setFont(new Font("Dialog", Font.BOLD, 20));
		animal10.setBounds(582, 255, 100, 100);
		contentPane.add(animal10);

		animal11.setFont(new Font("Dialog", Font.BOLD, 20));
		animal11.setBounds(469, 353, 100, 100);
		contentPane.add(animal11);
		
		animal12.setFont(new Font("Dialog", Font.BOLD, 20));
		animal12.setBounds(708, 330, 100, 100);
		contentPane.add(animal12);
		
		run.add(run1);
		run.add(run2);
		run.add(run3);
		run.add(run4);
		run.add(run5);
		run.add(run6);
		run.add(run7);
		run.add(run8);
		run.add(run9);
		run.add(run10);
		run.add(run11);
		run.add(run12);
		
		time.add(timer1);
		time.add(timer2);
		time.add(timer3);
		time.add(timer4);
		time.add(timer5);
		time.add(timer6);
		time.add(timer7);
		time.add(timer8);
		time.add(timer9);
		time.add(timer10);
		time.add(timer11);
		time.add(timer12);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setLocation(0, 0);
		ImageIcon img = new ImageIcon("../picture/dude.jpg");
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(new_img));
		lblNewLabel.setSize(1200, 675);
		contentPane.add(lblNewLabel);
		
		showAnimal();
		
		animal1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chickenNum>0) {
					animal1.setVisible(false);
					chickenNum--;
					animalAction();
				}
			}
		});
		animal2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chickenNum>0) {
					animal2.setVisible(false);
					chickenNum--;
					animalAction();
				}
			}
		});
		animal3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chickenNum>0) {
					animal3.setVisible(false);
					chickenNum--;
					animalAction();
				}
			}
		});
		animal4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pigNum>0) {
					animal4.setVisible(false);
					pigNum--;
					animalAction();
				}
			}
		});
		animal5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pigNum>0) {
					animal5.setVisible(false);
					pigNum--;
					animalAction();
				}

			}
		});
		animal6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pigNum>0) {
					animal6.setVisible(false);
					pigNum--;
					animalAction();
				}

			}
		});
		animal7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pigNum>0) {
					animal7.setVisible(false);
					pigNum--;
					animalAction();
				}

			}
		});
		animal8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cowNum>0) {
					animal8.setVisible(false);
					cowNum--;
					animalAction();
				}
			}
		});
		animal9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cowNum>0) {
					animal9.setVisible(false);
					cowNum--;
					animalAction();
				}

			}
		});

		animal10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cowNum>0) {
					animal10.setVisible(false);
					cowNum--;
					animalAction();
				}
			}
		});
		animal11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cowNum>0) {
					animal11.setVisible(false);
					cowNum--;
					animalAction();
				}
			}
		});
		animal12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cowNum>0) {
					animal12.setVisible(false);
					cowNum--;
					animalAction();
				}
			}
		});
		
	}
	public void animalAction() {
		dudeCowNum.setText(" X "+(int)cowNum);
		dudePigNum.setText(" X "+(int)pigNum);
		dudeChickenNum.setText(" X "+(int)chickenNum);
		sum--;
		if(sum>0) {
			System.out.println(sum);
			period -= 30;
		}
		if(sum==0) {
			System.out.println("遊戲結束!!任務達成，恭喜你獲得金幣!!");
		}
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
	        	}
	        	if(random==1) {
	        		vx = -Math.sin(1) * 5;
	            	vy = Math.cos(1) * 5;
	        	}
	        	if(random==2) {
	        		vx = Math.sin(1) * 5;
	            	vy = -Math.cos(1) * 5;
	        	}
	        	else {
	        		vx = -Math.sin(1) * 5;
	            	vy = -Math.cos(1) * 5;
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
	        	if(btn.getIcon()==chickenright)
    			{
    				btn.setIcon(chickenleft);
    			}
    			if(btn.getIcon()==pigright)
    			{
    				btn.setIcon(pigleft);
    			}
    			if(btn.getIcon()==cowright)
    			{
    				btn.setIcon(cowleft);
    			}
    			btn.setVisible(true);
			
	        }
	        public void showButtonRight() {
	        	buttonGIF();
	        	if(btn.getIcon()==chickenleft)
				{
					btn.setIcon(chickenright);
				}
				if(btn.getIcon()==pigleft)
				{
					btn.setIcon(pigright);
				}
				if(btn.getIcon()==cowleft)
				{
					btn.setIcon(cowright);
				}
				btn.setVisible(true);
	        	

	        }
	        public void buttonGIF()
	        {
        		btn.setOpaque(false);
        		btn.setContentAreaFilled(false);
        		btn.setFocusPainted(false);
        		btn.setBorder(null);
	        }
	        public double getVX() {
	        	return vx;
	        }
	    }
	  public void showAnimal() {
		  buttonGIF();
		  for(int i=0;i<12;i++) {
			  if(i<3) {
				  if(run.get(i).getVX()>0)
					  button.get(i).setIcon(chickenright);
				  else
					  button.get(i).setIcon(chickenleft);
			  }
			  if(i>=3&&i<7) {
				  if(run.get(i).getVX()>0)
					  button.get(i).setIcon(pigright);
				  else
					  button.get(i).setIcon(pigleft);
			  }
			  if(i>=7) {

				  if(run.get(i).getVX()>0)
					  button.get(i).setIcon(cowright);
				  else
					  button.get(i).setIcon(cowleft);
			  }
		  }
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

}
