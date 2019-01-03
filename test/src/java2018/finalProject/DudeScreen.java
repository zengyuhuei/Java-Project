package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
public class DudeScreen extends JPanel implements ActionListener {

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				try {
					WareHouse warehouse = new WareHouse();
					DudeScreen frame = new DudeScreen(warehouse);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			//}
		//});
	}*/

	/**
	 * Create the frame.
	 */
	private Main mainFrame;
	JLabel animalRate = new JLabel();
	JButton startFeed = new JButton();	
	JButton feedChicken = new JButton("雞"); 
	JButton feedPig = new JButton("豬");
	JButton feedCow = new JButton();
	JButton feedAnimal = new JButton();
	JButton lowFeed = new JButton();
	JButton midFeed = new JButton();
	JButton highFeed = new JButton();
	JButton catchAnimal = new JButton();
	JButton home = new JButton();
	JButton dudeGameStart = new JButton();
	JLabel dudeRule = new JLabel();
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
	ArrayList<JButton> button = new ArrayList<JButton>(10);
	ArrayList<RunningButton> runbutton = new ArrayList<RunningButton>(10);
	private int num=-1;
	private int buttonNum;
	ImageIcon big_chickenleft = new ImageIcon("../picture/big_chickenleft.gif");
	ImageIcon chickenleft = new ImageIcon("../picture/chickenleft.gif");
	ImageIcon big_chickenright = new ImageIcon("../picture/big_chickenright.gif");
	ImageIcon chickenright = new ImageIcon("../picture/chickenright.gif");
	ImageIcon big_pigleft = new ImageIcon("../picture/big_pigleft.gif");
	ImageIcon pigleft = new ImageIcon("../picture/pigleft.gif");
	ImageIcon big_pigright =  new ImageIcon("../picture/big_pigright.gif");
	ImageIcon pigright = new ImageIcon("../picture/pigright.gif");
	ImageIcon cowleft = new ImageIcon("../picture/cowleft.gif");
	ImageIcon big_cowleft = new ImageIcon("../picture/big_cowleft.gif");
	ImageIcon cowright = new ImageIcon("../picture/cowright.gif");
	ImageIcon big_cowright = new ImageIcon("../picture/big_cowright.gif");
	ImageIcon cowhead = resizeImage (50,50,new ImageIcon("../picture/cow.png"));
	ImageIcon pighead = resizeImage (50,50,new ImageIcon("../picture/pig2.png"));
	ImageIcon chickenhead = resizeImage (50,50,new ImageIcon("../picture/chicken.png"));
	ImageIcon rateBackground = new ImageIcon("../picture/rateBackground.PNG");
	JLabel rateBackGround = new JLabel(rateBackground);
	ImageIcon addAnimal =resizeImage (90,65,new ImageIcon("../picture/addAnimal.png"));
	ImageIcon feed =resizeImage (80,65,new ImageIcon("../picture/feed.png"));
	ImageIcon lowfeed =resizeImage (80,65,new ImageIcon("../picture/lowfeed.png"));
	ImageIcon highfeed =resizeImage (80,65,new ImageIcon("../picture/highfeed.png"));
	ImageIcon midfeed =resizeImage (80,65,new ImageIcon("../picture/midfeed.png"));
	ImageIcon catchanimal =resizeImage (80,65,new ImageIcon("../picture/catch.png"));	
	JLabel dudeAnimalNum = new JLabel("牧場動物(上限10隻):");
	JLabel dudeCowNum = new JLabel(cowhead, JLabel.LEFT);
	JLabel dudePigNum = new JLabel(pighead, JLabel.LEFT);
	JLabel dudeChickenNum = new JLabel(chickenhead, JLabel.LEFT);
	JLabel feedbackGround = new JLabel();
	JLabel feedbackGround2 = new JLabel();
	ImageIcon dudeNumback = new ImageIcon("../picture/dudeNumBack.PNG");
	JLabel dudeNumBack = new JLabel(dudeNumback, JLabel.CENTER);
	ImageIcon toolback = new ImageIcon("../picture/toolBack.PNG");
	JLabel lblToolback = new JLabel(toolback);
	
	public DudeScreen(Main mainFrame, WareHouse warehouse) {
		this.mainFrame = mainFrame;
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
		//ImageIcon chicken =resizeImage (75,75,new ImageIcon("../picture/chicken.gif"));
		Dude dude = new Dude(warehouse);
		this.setSize(1200, 675);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		//----------------手指游標-------------------------
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		
		dudeAnimalNum.setBounds(268, 38, 301, 43);
		this.add(dudeAnimalNum);
		dudeAnimalNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		
		
		startFeed.setBounds(1051, 172, 76, 65);
		this.add(startFeed);
		startFeed.setFont(new java.awt.Font("Dialog", 1, 20));
		startFeed.setIcon(addAnimal);
		
		//圖片上亮倉庫數量
		feedChicken.setFont(new Font("Dialog", Font.BOLD, 20));
		feedChicken.setBounds(902, 172, 124, 65);
		this.add(feedChicken);
		feedChicken.setVisible(false);
		
		feedPig.setFont(new Font("Dialog", Font.BOLD, 20));
		feedPig.setBounds(774, 172, 124, 65);
		this.add(feedPig);
		feedPig.setVisible(false);
		
		feedCow.setFont(new Font("Dialog", Font.BOLD, 20));
		feedCow.setBounds(651, 172, 124, 65);
		this.add(feedCow);
		feedCow.setVisible(false);
		
		feedbackGround.setBounds(641, 172, 394, 65);	
		ImageIcon feedBackground = resizeImage(feedbackGround.getWidth(), feedbackGround.getHeight(),new ImageIcon("../picture/feedBackground.PNG"));
		feedbackGround.setIcon(feedBackground);	
		
		this.add(feedbackGround);
		feedbackGround.setVisible(false);
		
		feedAnimal.setBounds(1049, 291, 76, 65);
		this.add(feedAnimal);
		feedAnimal.setFont(new java.awt.Font("Dialog", 1, 20));
		feedAnimal.setEnabled(false);
		feedAnimal.setIcon(feed);
		
		lowFeed.setFont(new Font("Dialog", Font.BOLD, 16));
		lowFeed.setBounds(891, 291, 137, 65);
		this.add(lowFeed);
		lowFeed.setVisible(false);
		
		midFeed.setFont(new Font("Dialog", Font.BOLD, 16));
		midFeed.setBounds(755, 291, 137, 65);
		this.add(midFeed);
		midFeed.setVisible(false);
		
		highFeed.setFont(new Font("Dialog", Font.BOLD, 16));
		highFeed.setBounds(619, 291, 137, 65);
		this.add(highFeed);
		highFeed.setVisible(false);
		
		feedbackGround2.setBounds(609, 291, 426, 65);	
		ImageIcon feedBackground2 = resizeImage(feedbackGround2.getWidth(), feedbackGround2.getHeight(),new ImageIcon("../picture/feedBackground.PNG"));
		feedbackGround2.setIcon(feedBackground2);	
		
		this.add(feedbackGround2);
		feedbackGround2.setVisible(false);
		
		catchAnimal.setBounds(1049, 402, 76, 65);
		this.add(catchAnimal);
		catchAnimal.setFont(new java.awt.Font("Dialog", 1, 20));
		catchAnimal.setEnabled(false);
		catchAnimal.setIcon(catchanimal);
		
		lblToolback.setBounds(1036, 135, 100, 368);
		this.add(lblToolback);
		lblToolback.setVisible(true);
		
		dudeCowNum.setBounds(561, 35, 131, 43);
		this.add(dudeCowNum);
		dudeCowNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudeCowNum.setText(" X "+dude.getCowNumber());
		
		dudePigNum.setBounds(693, 35, 131, 43);
		this.add(dudePigNum);
		dudePigNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudePigNum.setText(" X "+dude.getPigNumber());
		
		dudeChickenNum.setBounds(825, 32, 131, 43);
		this.add(dudeChickenNum);
		dudeChickenNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		dudeChickenNum.setText(" X "+dude.getChickenNumber());
		
		dudeNumBack.setBounds(194, 10, 780, 99);
		this.add(dudeNumBack);
		
		dudeRule.setBounds(274, 91, 600, 468);
		ImageIcon duderule = resizeImage(dudeRule.getWidth(), dudeRule.getHeight(), new ImageIcon("../picture/dudeRule.PNG"));
		
		dudeGameStart.setBounds(505, 369, 137, 55);
		ImageIcon dudeGamestart = resizeImage(118, 37, new ImageIcon("../picture/dudeRuleButton.PNG"));
		dudeGameStart.setIcon(dudeGamestart);	
		add(dudeGameStart);
		dudeGameStart.setVisible(false);
		dudeGameStart.setOpaque(false);
		dudeGameStart.setContentAreaFilled(false);
		dudeGameStart.setFocusPainted(false);
		dudeGameStart.setBorder(null);
		
		dudeGameStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.changeToDudeGameScreen();
				dudeGameStart.setVisible(false);
				dudeRule.setVisible(false);
			}
			@Override
            public void mouseEntered(MouseEvent arg0) {
				dudeGameStart.setIcon(resizeImage(dudeGameStart.getIcon().getIconWidth()+10,dudeGameStart.getIcon().getIconHeight()+10,(ImageIcon)dudeGameStart.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	dudeGameStart.setIcon(resizeImage (118, 37,new ImageIcon("../picture/dudeRuleButton.png")));
            }   
		});
		dudeRule.setIcon(duderule);	
		this.add(dudeRule);
		dudeRule.setVisible(false);
		
		home.setFont(new Font("Dialog", Font.BOLD, 20));	
		buttonOFF(home);
		home.setIcon(new ImageIcon("..\\picture\\HOME.png"));
		home.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		home.setBounds(1008, 526, 176, 114);
		home.addActionListener(this);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				feedAnimal.setEnabled(false);
				catchAnimal.setEnabled(false);
				closeAnimalRate(dude);
				dudeGameStart.setVisible(false);
				dudeRule.setVisible(false);
				num = 10;
			}
		});
		home.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				home.setIcon(resizeImage(home.getIcon().getIconWidth()+10,home.getIcon().getIconHeight()+10,(ImageIcon)home.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	home.setIcon(new ImageIcon("..\\picture\\HOME.png"));
            } 
			
		});
		this.add(home);
		//成長值
		animalRate.setBounds(52, 40, 189, 55);
		this.add(animalRate);
		animalRate.setFont(new Font("微軟正黑體 Light", Font.BOLD, 25));
		animalRate.setForeground(new Color(128, 0, 0));
		
		rateBackGround.setBounds(-11,  10,  258,  111);
		this.add(rateBackGround);
		rateBackGround.setVisible(false);
		
		animal1.setBounds(456, 231, 100, 100);
		this.add(animal1);
		animal1.setFont(new java.awt.Font("Dialog", 1, 20));
		Timer timer1 = new Timer();
		RunningButton run1 = new RunningButton(animal1, 456, 231, dude, 0);
		timer1.schedule(run1, 1000, 220);
		animal1.setVisible(false);
		
		animal2.setFont(new Font("Dialog", Font.BOLD, 20));
		animal2.setBounds(384, 415, 100, 100);
		this.add(animal2);
		Timer timer2 = new Timer();
		RunningButton run2 = new RunningButton(animal2, 384, 415, dude, 1);
		timer2.schedule(run2, 1000, 220);
		animal2.setVisible(false);
		
		animal3.setFont(new Font("Dialog", Font.BOLD, 20));
		animal3.setBounds(214, 312, 100, 100);
		this.add(animal3);
		Timer timer3 = new Timer();
		RunningButton run3 = new RunningButton(animal3, 214, 312, dude, 2);
		timer3.schedule(run3, 1000, 220);
		animal3.setVisible(false);
		
		animal4.setFont(new Font("Dialog", Font.BOLD, 20));
		animal4.setBounds(656, 318, 100, 100);
		this.add(animal4);
		Timer timer4 = new Timer();
		RunningButton run4 = new RunningButton(animal4, 658, 318, dude, 3);
		timer4.schedule(run4, 1000, 220);
		animal4.setVisible(false);
		
		animal5.setFont(new Font("Dialog", Font.BOLD, 20));
		animal5.setBounds(207, 183, 100, 100);
		this.add(animal5);
		Timer timer5 = new Timer();
		RunningButton run5 = new RunningButton(animal5, 207, 183, dude, 4);
		timer5.schedule(run5, 1000, 220);
		animal5.setVisible(false);
		
		animal6.setFont(new Font("Dialog", Font.BOLD, 20));
		animal6.setBounds(274, 403, 100, 100);
		this.add(animal6);
		Timer timer6 = new Timer();
		RunningButton run6 = new RunningButton(animal6, 260, 403, dude, 5);
		timer6.schedule(run6, 1000, 220);
		animal6.setVisible(false);
		
		animal7.setFont(new Font("Dialog", Font.BOLD, 20));
		animal7.setBounds(336, 217, 100, 100);
		this.add(animal7);
		Timer timer7 = new Timer();
		RunningButton run7 = new RunningButton(animal7, 336, 217, dude, 6);
		timer7.schedule(run7, 1000, 220);
		animal7.setVisible(false);
		
		animal8.setFont(new Font("Dialog", Font.BOLD, 20));
		animal8.setBounds(585, 394, 100, 100);
		this.add(animal8);
		Timer timer8 = new Timer();
		RunningButton run8 = new RunningButton(animal8, 585, 394, dude, 7);
		timer8.schedule(run8, 1000, 220);
		animal8.setVisible(false);
		
		animal9.setFont(new Font("Dialog", Font.BOLD, 20));
		animal9.setBounds(620, 150, 100, 100);
		this.add(animal9);
		Timer timer9 = new Timer();
		RunningButton run9 = new RunningButton(animal9, 620, 150, dude, 8);
		timer9.schedule(run9, 1000, 220);
		animal9.setVisible(false);
		
		animal10.setFont(new Font("Dialog", Font.BOLD, 20));
		animal10.setBounds(708, 330, 100, 100);
		this.add(animal10);
		Timer timer10 = new Timer();
		RunningButton run10 = new RunningButton(animal10, 708, 330, dude, 9);
		timer10.schedule(run10, 1000, 220);
		animal10.setVisible(false);
		
		runbutton.add(run1);
		runbutton.add(run2);
		runbutton.add(run3);
		runbutton.add(run4);
		runbutton.add(run5);
		runbutton.add(run6);
		runbutton.add(run7);
		runbutton.add(run8);
		runbutton.add(run9);
		runbutton.add(run10);
		
		startFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printHouseAnimalNum(warehouse);
				returnHouseAnimal(warehouse);
				closeFeed();
				closeAnimalRate(dude);
				feedChicken.setVisible(true);
				feedPig.setVisible(true);
				feedCow.setVisible(true);
				feedbackGround.setVisible(true);
				feedAnimal.setEnabled(false);
				catchAnimal.setEnabled(false);
				printdudeAnimalNum(dude, dudeChickenNum, dudePigNum, dudeCowNum);
			}
		});

		startFeed.addMouseListener(new MouseAdapter() {  //提醒牧場數量上限
			@Override
            public void mouseEntered(MouseEvent arg0) {
				startFeed.setIcon(resizeImage(startFeed.getIcon().getIconWidth()+10,startFeed.getIcon().getIconHeight()+10,(ImageIcon)startFeed.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	startFeed.setIcon(resizeImage (90,65,new ImageIcon("../picture/addAnimal.png")));
            } 

		});		
		
		feedChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dude.getNum()==9) {
					closeStart();
					startFeed.setEnabled(false);
				}
				if(dude.getNullNum(new Chicken(),warehouse)==false)
				{
					dude.startFeedChicken(new Chicken());
				}
				animalAction(dude, warehouse);
				
			}
		});
		feedChicken.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				feedChicken.setIcon(resizeImage(feedChicken.getIcon().getIconWidth()+10,feedChicken.getIcon().getIconHeight()+10,(ImageIcon)feedChicken.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	feedChicken.setIcon(resizeImage (50,50,new ImageIcon("../picture/chicken.png")));
            } 
            
		});
		feedPig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dude.getNum()==9) {
					closeStart();
					startFeed.setEnabled(false);
				}
				if(dude.getNullNum(new Pig(),warehouse)==false)
				{
					dude.startFeedPig(new Pig());
				}
				animalAction(dude, warehouse);
			}
		});
		feedPig.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				feedPig.setIcon(resizeImage(feedPig.getIcon().getIconWidth()+10,feedPig.getIcon().getIconHeight()+10,(ImageIcon)feedPig.getIcon()));
				buttonSound();  
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	feedPig.setIcon(resizeImage (50,50,new ImageIcon("../picture/pig2.png")));
            } 
			
		});
		feedCow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dude.getNum()==9) {
					closeStart();
					startFeed.setEnabled(false);
				}
				if(dude.getNullNum(new Cow(),warehouse)==false)
				{
					dude.startFeedCow(new Cow());
				}
				animalAction(dude, warehouse);
			}
		});
		feedCow.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				feedCow.setIcon(resizeImage(feedCow.getIcon().getIconWidth()+10,feedCow.getIcon().getIconHeight()+10,(ImageIcon)feedCow.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	feedCow.setIcon(resizeImage (50,50,new ImageIcon("../picture/cow.png")));
            } 
			
		});
		feedAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeStart();
				printHouseFeedNum(warehouse);
				returnHouseFeed(warehouse);
				lowFeed.setVisible(true);
				midFeed.setVisible(true);
				highFeed.setVisible(true);
				feedbackGround2.setVisible(true);
			}
		});
		feedAnimal.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				feedAnimal.setIcon(resizeImage(feedAnimal.getIcon().getIconWidth()+10,feedAnimal.getIcon().getIconHeight()+10,(ImageIcon)feedAnimal.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	feedAnimal.setIcon(resizeImage (80,65,new ImageIcon("../picture/feed.png")));
            } 
			
		});
		
		buttonOFF(lowFeed);
		lowFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dude.getPondLand().get(num).feeding(new SimpleFeed());
				warehouse.removeFeed(new SimpleFeed().getName());
				feedAction(dude,warehouse);
			}
		});
		lowFeed.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				lowFeed.setIcon(resizeImage(lowFeed.getIcon().getIconWidth()+10,lowFeed.getIcon().getIconHeight()+10,(ImageIcon)lowFeed.getIcon()));
				buttonSound();  
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	lowFeed.setIcon(resizeImage (80,65,new ImageIcon("../picture/lowfeed.png")));
            } 
			
		});
		buttonOFF(midFeed);
		midFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dude.getPondLand().get(num).feeding(new GeneralFeed());
				warehouse.removeFeed(new GeneralFeed().getName());
				feedAction(dude,warehouse);
			}
		});
		midFeed.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				midFeed.setIcon(resizeImage(midFeed.getIcon().getIconWidth()+10,midFeed.getIcon().getIconHeight()+10,(ImageIcon)midFeed.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	midFeed.setIcon(resizeImage (80,65,new ImageIcon("../picture/midfeed.png")));
            } 
			
		});
		buttonOFF(highFeed);
		highFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dude.getPondLand().get(num).feeding(new AdvancedFeed());
				warehouse.removeFeed(new AdvancedFeed().getName());
				feedAction(dude,warehouse);
			}
		});
		highFeed.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				highFeed.setIcon(resizeImage(highFeed.getIcon().getIconWidth()+10,highFeed.getIcon().getIconHeight()+10,(ImageIcon)highFeed.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	highFeed.setIcon(resizeImage (80,65,new ImageIcon("../picture/highfeed.png")));
            } 
			
		});
		catchAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startFeed.setEnabled(true);
				closeFeed();
				closeStart();
				dude.capturing(num);
				printdudeAnimalNum(dude, dudeChickenNum, dudePigNum, dudeCowNum);
				closeButton(dude);
				closeAnimalRate(dude);
				//catchAnimal.setEnabled(false);
			}
		});
		catchAnimal.addMouseListener(new MouseAdapter() { //跳轉遊戲畫面
			@Override
			public void mouseClicked(MouseEvent e) {
				int random = (int)(Math.random()*1);
				System.out.println(catchAnimal.isEnabled());
				if(catchAnimal.isEnabled()==false) {
				}
				else {
					if(random==0) {
						dudeGameStart.setVisible(true);
						dudeRule.setVisible(true);
						String name = "countdown";
						animalSound(name);
					}			
				}
				catchAnimal.setEnabled(false);
			}
			@Override
            public void mouseEntered(MouseEvent arg0) {
				catchAnimal.setIcon(resizeImage(catchAnimal.getIcon().getIconWidth()+10,catchAnimal.getIcon().getIconHeight()+10,(ImageIcon)catchAnimal.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	catchAnimal.setIcon(resizeImage (80,65,new ImageIcon("../picture/catch.png")));
            } 
		});
		animal1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=0;
				buttonAction(dude, num);
			}
		});

		animal2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=1;
				buttonAction(dude, num);
			}
		});
		animal3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=2;
				buttonAction(dude, num);
			}
		});
		animal4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=3;
				buttonAction(dude, num);
			}
		});
		animal5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=4;
				buttonAction(dude, num);
			}
		});
		animal6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=5;
				buttonAction(dude, num);
			}
		});
		animal7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=6;
				buttonAction(dude, num);
			}
		});
		animal8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=7;
				buttonAction(dude, num);
			}
		});
		animal9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=8;
				buttonAction(dude, num);
			}
		});
		animal10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num=9;
				buttonAction(dude, num);
			}
		});
		buttonOFF(startFeed);
		buttonOFF(feedAnimal);
		buttonOFF(catchAnimal);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setLocation(0, 0);
		ImageIcon img = new ImageIcon("../picture/dude.jpg");
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(new_img));
		lblNewLabel.setSize(1200, 675);
			this.add(lblNewLabel);
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(0, 0, 900, 675);
			this.add(btnNewButton);
			buttonOFF(btnNewButton);
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					closeStart();
					closeFeed();
					feedAnimal.setEnabled(false);
					closeAnimalRate(dude);
					num = 10;
					catchAnimal.setEnabled(false);
					
				}
            public void mouseEntered(MouseEvent arg0) {
            	closeStart();
            	closeFeed();
				}
			});
		
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
	public void animalSound(String name)
	{
    	 try {           
	            File soundFile = new File("..\\sound\\"+name+"Sound.wav");
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

	public void animalAction(Dude dude, WareHouse warehouse) { //養殖動物統一動作
		catchAnimal.setEnabled(false);
		showButton(dude);
		printHouseAnimalNum(warehouse);
		returnHouseAnimal(warehouse);
		printdudeAnimalNum(dude, dudeChickenNum, dudePigNum, dudeCowNum);
	}
	public void feedAction(Dude dude, WareHouse warehouse) { //飼料統一動作
		printHouseFeedNum(warehouse);
		returnHouseFeed(warehouse);
		printAnimalRate(dude, num);
		returnAnimalEat(dude, num);
		if(warehouse.getGeneralFeedNumber()==0&&warehouse.getSimpleFeedNumber()==0&&warehouse.getAdvencedFeedNumber()==0) {
			feedAnimal.setEnabled(false);
			closeFeed();
		}
	}
	public void buttonAction(Dude dude, int num) { //場上動物統一動作
		String name;
		closeFeed();
		closeStart();
		if(dude.getPondLand().get(num).getGrowingRate()>=100)catchAnimal.setEnabled(true);
		else catchAnimal.setEnabled(false);
		printAnimalRate(dude, num);
		returnAnimalEat(dude, num);
		if(dude.getPondLand().get(num).getName()=="牛") {
			name="cow";
			animalSound(name);
		}
		if(dude.getPondLand().get(num).getName()=="豬") {
			name="pig";
			animalSound(name);
		}
		if(dude.getPondLand().get(num).getName()=="雞") {
			name="chicken";
			animalSound(name);
		}
	}
	public void closeFeed() { //隱身三飼料按鈕
		feedbackGround2.setVisible(false);
		lowFeed.setVisible(false);
		midFeed.setVisible(false);
		highFeed.setVisible(false);
	}
	public void closeStart() { //隱身三動物按鈕
		feedbackGround.setVisible(false);
		feedChicken.setVisible(false);
		feedPig.setVisible(false);
		feedCow.setVisible(false);
	}
	public void returnAnimalEat(Dude dude, int i) { //判斷該動物可否進食
		if(dude.getPondLand().get(i).getGrowingRate()<100) {
			feedAnimal.setEnabled(true);
			printAnimalRate(dude, i);
		}
		else {
			feedAnimal.setEnabled(false);
			closeFeed();
			catchAnimal.setEnabled(true);
		}
	}
	public void printAnimalRate(Dude dude, int i) { //印該動物成長值
		rateBackGround.setVisible(true);
		animalRate.setVisible(true);
		animalRate.setText("成長值: "+dude.getPondLand().get(i).getGrowingRate());
	}
	public void closeAnimalRate(Dude dude) { //關閉動物成長值
		rateBackGround.setVisible(false);
		animalRate.setVisible(false);;
	}
	public void printHouseAnimalNum(WareHouse warehouse) { //印待成長動物數量
		buttonOFF(feedChicken);
		buttonOFF(feedPig);
		buttonOFF(feedCow);
		feedChicken.setIcon(chickenhead);
		feedChicken.setText("X "+warehouse.getYoungChickenNumber());
		feedPig.setIcon(pighead);
		feedPig.setText("X "+warehouse.getYoungPigNumber());
		feedCow.setIcon(cowhead);
		feedCow.setText("X "+warehouse.getYoungCowNumber());
	}
	public void returnHouseAnimal(WareHouse warehouse) { //判斷倉庫待成長動物數量
		if(warehouse.getYoungChickenNumber()==0) {
			feedChicken.setEnabled(false);
		}
		if(warehouse.getYoungChickenNumber()!=0) {
			feedChicken.setEnabled(true);
		}
		if(warehouse.getYoungPigNumber()==0) {
			feedPig.setEnabled(false);
		}
		if(warehouse.getYoungPigNumber()!=0) {
			feedPig.setEnabled(true);
		}
		if(warehouse.getYoungCowNumber()==0) {
			feedCow.setEnabled(false);
		}
		if(warehouse.getYoungCowNumber()!=0) {
			feedCow.setEnabled(true);
		}
	}
	public void printHouseFeedNum(WareHouse warehouse) { //印飼料數量
		buttonOFF(lowFeed);
		buttonOFF(midFeed);
		buttonOFF(highFeed);
		lowFeed.setIcon(lowfeed);
		lowFeed.setText("X "+warehouse.getSimpleFeedNumber());
		midFeed.setIcon(midfeed);
		midFeed.setText("X "+warehouse.getGeneralFeedNumber());
		highFeed.setIcon(highfeed);
		highFeed.setText("X "+warehouse.getAdvencedFeedNumber());
	}
	public void returnHouseFeed(WareHouse warehouse) { //判斷倉庫飼料數量
		if(warehouse.getSimpleFeedNumber()==0) {
			lowFeed.setEnabled(false);
		}
		if(warehouse.getSimpleFeedNumber()!=0) {
			lowFeed.setEnabled(true);
		}
		if(warehouse.getGeneralFeedNumber()==0) {
			midFeed.setEnabled(false);
		}
		if(warehouse.getGeneralFeedNumber()!=0) {
			midFeed.setEnabled(true);
		}
		if(warehouse.getAdvencedFeedNumber()==0) {
			highFeed.setEnabled(false);
		}
		if(warehouse.getAdvencedFeedNumber()!=0) {
			highFeed.setEnabled(true);
		}
	}
	public void printdudeAnimalNum(Dude dude, JLabel dudeChickenNum, JLabel dudePigNum, JLabel dudeCowNum) { //印牧場動物數量
		dudeChickenNum.setText(" X "+dude.getChickenNumber());
		dudePigNum.setText(" X "+dude.getPigNumber());
		dudeCowNum.setText(" X "+dude.getCowNumber());
	}
    class RunningButton extends TimerTask {
    	private JButton btn;
    	private double coordinateX, coordinateY;
    	private double vx, vy;
    	private int random = (int)(Math.random()*4);
    	private Dude dude;
    	private int i;
    	private int coor;
    	public RunningButton(JButton btn, double coordinateX, double coordinateY, Dude dude, int i) {
        	this.btn = btn;
        	this.coordinateX = coordinateX;
        	this.coordinateY = coordinateY;
        	this.dude = dude;
        	this.i = i;
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
        	coor = (int)(Math.random()*20);
        	if(coor==0) {
        		if(vx<0) {
        			vx = -vx;
                    //showButtonRight(dude, i);
        		}
        		else {
        			vx = -vx;
                   // showButtonLeft(dude, i);
        		}
        		
        	}
            if (coordinateX + vx < 50) {
                vx = -vx;
                //showButtonRight(dude, i);
            }
            if (coordinateX + vx + 60 > 880) {
                vx = -vx;
                //showButtonLeft(dude, i);
            }
            if (coordinateY + vy < 100) {
                vy = -vy;
            }
            if (coordinateY + vy + 25 > 450) {
                vy = -vy;
            }
            showButtonchange(dude, i, vx);
            coordinateX += vx;
            coordinateY += vy;
            btn.setBounds((int) coordinateX, (int) coordinateY, 150, 150);
    		
        }
        public void showButtonchange(Dude dude, int i, double vx) {
        	buttonGIF();
        	if(i<dude.getPondLand().size()&&dude.getPondLand().get(i)!=null)
        	{
    			if(dude.getPondLand().get(i).getName()=="豬"&&i==num&&vx<0)
    			{
    				btn.setIcon(big_pigleft);
    			}
    			if(dude.getPondLand().get(i).getName()=="豬"&&i==num&&vx>0)
    			{
    				btn.setIcon(big_pigright);
    			}
    			if(dude.getPondLand().get(i).getName()=="雞"&&i==num&&vx<0)
    			{
    				btn.setIcon(big_chickenleft);
    			}
    			if(dude.getPondLand().get(i).getName()=="雞"&&i==num&&vx>0)
    			{
    				btn.setIcon(big_chickenright);
    			}
    			if(dude.getPondLand().get(i).getName()=="牛"&&i==num&&vx<0)
    			{
    				btn.setIcon(big_cowleft);
    			}
    			if(dude.getPondLand().get(i).getName()=="牛"&&i==num&&vx>0)
    			{
    				btn.setIcon(big_cowright);
    			}
    			
    			if(dude.getPondLand().get(i).getName()=="豬"&&i!=num&&vx<0)
    			{
    				btn.setIcon(pigleft);
    			}
    			if(dude.getPondLand().get(i).getName()=="豬"&&i!=num&&vx>0)
    			{
    				btn.setIcon(pigright);
    			}
    			if(dude.getPondLand().get(i).getName()=="雞"&&i!=num&&vx<0)
    			{
    				btn.setIcon(chickenleft);
    			}
    			if(dude.getPondLand().get(i).getName()=="雞"&&i!=num&&vx>0)
    			{
    				btn.setIcon(chickenright);
    			}
    			if(dude.getPondLand().get(i).getName()=="牛"&&i!=num&&vx<0)
    			{
    				btn.setIcon(cowleft);
    			}
    			if(dude.getPondLand().get(i).getName()=="牛"&&i!=num&&vx>0)
    			{
    				btn.setIcon(cowright);
    			}
    			btn.setVisible(true);
        	}
		
        }
        public void buttonGIF()
        {
    		btn.setOpaque(false);
    		btn.setContentAreaFilled(false);
    		btn.setFocusPainted(false);
    		btn.setBorder(null);
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
    public void closeButton(Dude dude) {
    	buttonGIF();
    	buttonNum = dude.getButtonNum();
    	for(int i=0; i<dude.getPondLand().size();i++) {
    		if(dude.getPondLand().get(i)==null) {
    			button.get(i).setVisible(false);
    		}
    	}
    }
    public void showButton(Dude dude) {
    	buttonGIF();
    	buttonNum = dude.getButtonNum();
		if(dude.getPondLand().get(buttonNum).getName()=="雞")
		{	
			if(runbutton.get(buttonNum).getVX()<0)
				button.get(buttonNum).setIcon(chickenleft);
			else
				button.get(buttonNum).setIcon(chickenright);
			button.get(buttonNum).setVisible(true);
		}
		if(dude.getPondLand().get(buttonNum).getName()=="豬")
		{
			if(runbutton.get(buttonNum).getVX()<0)
				button.get(buttonNum).setIcon(pigleft);
			else
				button.get(buttonNum).setIcon(pigright);
			button.get(buttonNum).setVisible(true);
		}
		if(dude.getPondLand().get(buttonNum).getName()=="牛")
		{
			if(runbutton.get(buttonNum).getVX()<0)
				button.get(buttonNum).setIcon(cowleft);
			else
				button.get(buttonNum).setIcon(cowright);
			button.get(buttonNum).setVisible(true);
		}
		
		System.out.println(runbutton.get(buttonNum).getVX());
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
    public void buttonOFF(JButton btn) {
    	btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setBorder(null);
    }
    public ImageIcon resizeImage(int width, int height, ImageIcon img)
	{
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return  new ImageIcon(new_img);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == home) {
			this.mainFrame.changeToMainScreen();
		}
	}
}







