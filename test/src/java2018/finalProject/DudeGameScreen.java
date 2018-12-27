package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java2018.finalProject.DudeScreen.RunningButton;
import java2018.finalProject.GuessTimer.Listener;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.awt.event.ActionEvent;

public class DudeGameScreen extends JPanel {

	private Main mainFrame;
	private WareHouse warehouse;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	ImageIcon chickenleft = new ImageIcon("../picture/chickenleft.gif");
	ImageIcon chickenright = new ImageIcon("../picture/chickenright.gif");
	ImageIcon pigleft = new ImageIcon("../picture/pigleft.gif");
	ImageIcon pigright = new ImageIcon("../picture/pigright.gif");
	ImageIcon cowleft = new ImageIcon("../picture/cowleft.gif");
	ImageIcon cowright = new ImageIcon("../picture/cowright.gif");
	ImageIcon cowhead = resizeImage (50,50,new ImageIcon("../picture/cow.png"));
	ImageIcon pighead = resizeImage (50,50,new ImageIcon("../picture/pig2.png"));
	ImageIcon chickenhead = resizeImage (50,50,new ImageIcon("../picture/chicken.png"));
	JLabel dudeAnimalNum = new JLabel("需捕捉數量:");
	JLabel dudeCowNum = new JLabel(cowhead, JLabel.LEFT);
	JLabel dudePigNum = new JLabel(pighead, JLabel.LEFT);
	JLabel dudeChickenNum = new JLabel(chickenhead, JLabel.LEFT);
	ImageIcon dudeNumback = new ImageIcon("../picture/dudeNumBack.PNG");
	JLabel dudeNumBack = new JLabel(dudeNumback, JLabel.CENTER);
	JButton backToDudeBtn = new JButton();
	JLabel successlbl = new JLabel();
	JLabel faultlbl = new JLabel();
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
	JLabel lblSec = new JLabel("SEC");
	JLabel word = new JLabel(": 00");
	JLabel lblSecback = new JLabel("secback");
	int cowNum = (int)(Math.random()*6+6);
	int pigNum = (int)(Math.random()*5+5);
	int chickenNum = (int)(Math.random()*4+4);
	int period = 50;
	int sum = cowNum + pigNum + chickenNum;
	GuessTimer gt = new GuessTimer();
	
	public DudeGameScreen(Main mainFrame, WareHouse warehouse) {
		this.mainFrame = mainFrame;
		this.warehouse = warehouse;
		this.setSize(1200, 675);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);	
		gt.setJLabel(lblSec);

		 //傾聽計時器timeout事件(可選的事件，不實作也可以使用timer
		 gt.addListener(new GuessTimer.Listener() {
		 @Override
		 public void timeOut() {
		 //處理TimeOut事件
		 }
		 @Override
		 public void onChange(long sec) {

			 System.out.println("sec=>" + sec);
			 
		 }

		 });
		 gt.startTimer(31);


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
		lblSec.setForeground(Color.RED);
		
		lblSec.setBounds(963, 34, 58, 65);
		this.add(lblSec);
		lblSec.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		lblSec.setVisible(true);
		word.setForeground(Color.RED);
		
		word.setBounds(1005, 34, 69, 65);
		this.add(word);
		word.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		word.setVisible(true);
		
		
		lblSecback.setBounds(947, 41, 131, 58);
		ImageIcon secback = resizeImage(lblSecback.getWidth(), lblSecback.getHeight(), new ImageIcon("../picture/secBack.PNG"));
		lblSecback.setIcon(secback);	
		add(lblSecback);
		lblSecback.setVisible(true);
		
		dudeAnimalNum.setBounds(207, 47, 181, 43);
		this.add(dudeAnimalNum);
		dudeAnimalNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudeAnimalNum.setVisible(true);
		
		dudeCowNum.setBounds(419, 47, 131, 43);
		this.add(dudeCowNum);
		dudeCowNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudeCowNum.setText(" X "+(int)cowNum);
		dudeCowNum.setVisible(true);
		
		dudePigNum.setBounds(551, 45, 131, 43);
		this.add(dudePigNum);
		dudePigNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudePigNum.setText(" X "+(int)pigNum);
		dudePigNum.setVisible(true);
		
		dudeChickenNum.setBounds(683, 44, 131, 43);
		this.add(dudeChickenNum);
		dudeChickenNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudeChickenNum.setText(" X "+(int)chickenNum);
		dudeChickenNum.setVisible(true);
		
		dudeNumBack.setBounds(135, 22, 701, 99);
		this.add(dudeNumBack);
		dudeNumBack.setVisible(true);
		
		successlbl.setBounds(274, 159, 600, 400);
		ImageIcon success = resizeImage(successlbl.getWidth(), successlbl.getHeight(), new ImageIcon("../picture/success.PNG"));
		
		faultlbl.setBounds(274, 159, 600, 400);
		ImageIcon fault = resizeImage(faultlbl.getWidth(), faultlbl.getHeight(), new ImageIcon("../picture/fault.PNG"));
		
		backToDudeBtn.setBounds(505, 369, 137, 55);
		ImageIcon backTodude = resizeImage(118, 37, new ImageIcon("../picture/backToDude.PNG"));
		backToDudeBtn.setIcon(backTodude);	
		add(backToDudeBtn);
		backToDudeBtn.setVisible(false);
		backToDudeBtn.setOpaque(false);
		backToDudeBtn.setContentAreaFilled(false);
		backToDudeBtn.setFocusPainted(false);
		backToDudeBtn.setBorder(null);
		
		backToDudeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.changeToDudeScreen();
			}
            public void mouseEntered(MouseEvent arg0) {
            	backToDudeBtn.setIcon(resizeImage(backToDudeBtn.getIcon().getIconWidth()+10,backToDudeBtn.getIcon().getIconHeight()+10,(ImageIcon)backToDudeBtn.getIcon()));
				buttonSound();
			}
            @Override
            public void mouseExited(MouseEvent arg0) {
            	backToDudeBtn.setIcon(resizeImage (118, 37,new ImageIcon("../picture/backToDude.png")));
            } 
		});

		successlbl.setIcon(success);	
		add(successlbl);
		successlbl.setVisible(false);
		
		faultlbl.setIcon(fault);	
		add(faultlbl);
		faultlbl.setVisible(false);
		
		animal1.setFont(new java.awt.Font("Dialog", 1, 20));
		animal1.setBounds(456, 231, 100, 100);
		this.add(animal1);
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
		timer9.schedule(run9, 1000, period);
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
		this.add(animal2);
			
		animal3.setFont(new Font("Dialog", Font.BOLD, 20));
		animal3.setBounds(214, 312, 100, 100);
		this.add(animal3);
		
		animal4.setFont(new Font("Dialog", Font.BOLD, 20));
		animal4.setBounds(656, 318, 100, 100);
		this.add(animal4);
		
		animal5.setFont(new Font("Dialog", Font.BOLD, 20));
		animal5.setBounds(207, 183, 100, 100);
		this.add(animal5);
		
		animal6.setFont(new Font("Dialog", Font.BOLD, 20));
		animal6.setBounds(274, 403, 100, 100);
		this.add(animal6);
		
		animal7.setFont(new Font("Dialog", Font.BOLD, 20));
		animal7.setBounds(336, 217, 100, 100);
		this.add(animal7);
		
		animal8.setFont(new Font("Dialog", Font.BOLD, 20));
		animal8.setBounds(585, 394, 100, 100);
		this.add(animal8);
		
		animal9.setFont(new Font("Dialog", Font.BOLD, 20));
		animal9.setBounds(620, 150, 100, 100);
		this.add(animal9);
		
		animal10.setFont(new Font("Dialog", Font.BOLD, 20));
		animal10.setBounds(582, 255, 100, 100);
		this.add(animal10);

		animal11.setFont(new Font("Dialog", Font.BOLD, 20));
		animal11.setBounds(469, 353, 100, 100);
		this.add(animal11);
		
		animal12.setFont(new Font("Dialog", Font.BOLD, 20));
		animal12.setBounds(708, 330, 100, 100);
		this.add(animal12);
		
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
		this.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 1200, 675);
		add(btnNewButton);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(gt.timeStop()) {
					fault();
				}
			}
            public void mouseEntered(MouseEvent arg0) {
        		if(gt.timeStop()) {
        			fault();
        		}
			}
		});
		
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
		if(gt.getSec()>0) {
			if(sum>0) {
				System.out.println(sum);
				for(int i=0;i<12;i++) {
					run.get(i).setVXVY();
				}
			}
			if(sum==0) {
				this.warehouse.editHoldMoney(100);
				System.out.println("遊戲結束!!任務達成，恭喜你獲得金幣!!");
				gt.stopoTimer();
				/*int input = JOptionPane.showConfirmDialog(null, "遊戲結束!!任務達成，恭喜你獲得金幣!", null, JOptionPane.DEFAULT_OPTION);
				if(input==JOptionPane.YES_OPTION) {
					mainFrame.changeToDudeScreen();
				}*/
				successlbl.setVisible(true);
				for(int i=0; i<button.size(); i++)
				{
					button.get(i).setVisible(false);
					run.get(i).cancel();
				}
				backToDudeBtn.setVisible(true);
			}
		}
		if(gt.timeStop()) {
			fault();
		}
	}
	public void fault() { // bug: 不點button不會動   result: 弄個大button隱藏後面，mouse havor事件 timer==null跳框框
		if(sum>0) {
			faultlbl.setVisible(true);
			for(int i=0; i<button.size(); i++)
			{
				button.get(i).setVisible(false);
				run.get(i).cancel();
			}
			backToDudeBtn.setVisible(true);
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
	        public void setVXVY() {
	        	vx = 1.1*vx;
	        	vy = 1.1*vy;
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
	  public ImageIcon resizeImage(int width, int height, ImageIcon img)
	  {
		  Image i = img.getImage();
		  Image new_img = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		  return  new ImageIcon(new_img);
	  }
	  public void buttonSound()
		{
	    	 try {           
		            File soundFile = new File("..\\sound\\button.wav");
		            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
		            Clip clip = AudioSystem.getClip();
		            clip.open(audioIn);
		            clip.start();
		    
		        } catch (UnsupportedAudioFileException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (LineUnavailableException e) {
		            e.printStackTrace();
		        }
		}
}
