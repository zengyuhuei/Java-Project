package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java2018.finalProject.DudeScreenTest.RunningButton;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.io.File;
 
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class DudeScreen extends JFrame {

	private JPanel contentPane;

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
	/*String path="C:/Users/趙芷婷/Desktop/Java-Project/picture/cow.jpg";
	Icon cow=new ImageIcon(path);*/
	JLabel dudeAnimalNum = new JLabel("牧場動物:");
	JLabel dudeCowNum = new JLabel();
	JLabel dudePigNum = new JLabel();
	JLabel dudeChickenNum = new JLabel();
	JLabel animalRate = new JLabel();
	JButton startFeed = new JButton("養殖");	
	JButton feedChicken = new JButton("雞"); 
	JButton feedPig = new JButton("豬");
	JButton feedCow = new JButton("牛");
	JButton feedAnimal = new JButton("餵食");
	JButton lowFeed = new JButton("低級飼料");
	JButton midFeed = new JButton("中級飼料");
	JButton highFeed = new JButton("高級飼料");
	JButton catchAnimal = new JButton("捕捉");
	JButton home = new JButton("回首頁");
	JButton animal1 = new JButton("動物1");
	JButton animal2 = new JButton("動物2");
	JButton animal3 = new JButton("動物3");
	JButton animal4 = new JButton("動物4");
	JButton animal5 = new JButton("動物5");
	JButton animal6 = new JButton("動物6");
	JButton animal7 = new JButton("動物7");
	JButton animal8 = new JButton("動物8");
	JButton animal9 = new JButton("動物9");
	JButton animal10 = new JButton("動物10");
	ArrayList<JButton> button = new ArrayList<JButton>(10);
	private int num;
	
	public DudeScreen(WareHouse warehouse) {
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
		
		Dude dude = new Dude(warehouse);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dudeAnimalNum.setBounds(94, 567, 145, 43);
		contentPane.add(dudeAnimalNum);
		dudeAnimalNum.setFont(new java.awt.Font("Dialog", 1, 30));
		
		
		startFeed.setBounds(1049, 97, 76, 65);
		contentPane.add(startFeed);
		startFeed.setFont(new java.awt.Font("Dialog", 1, 20));
		
		//圖片上亮倉庫數量
		feedChicken.setFont(new Font("Dialog", Font.BOLD, 20));
		feedChicken.setBounds(963, 97, 76, 65);
		contentPane.add(feedChicken);
		feedChicken.setVisible(false);
		
		feedPig.setFont(new Font("Dialog", Font.BOLD, 20));
		feedPig.setBounds(877, 97, 76, 65);
		contentPane.add(feedPig);
		feedPig.setVisible(false);
		
		feedCow.setFont(new Font("Dialog", Font.BOLD, 20));
		feedCow.setBounds(791, 97, 76, 65);
		contentPane.add(feedCow);
		feedCow.setVisible(false);
		
		feedAnimal.setBounds(1049, 226, 76, 65);
		contentPane.add(feedAnimal);
		feedAnimal.setFont(new java.awt.Font("Dialog", 1, 20));
		feedAnimal.setEnabled(false);
		
		lowFeed.setFont(new Font("Dialog", Font.BOLD, 16));
		lowFeed.setBounds(902, 226, 137, 65);
		contentPane.add(lowFeed);
		lowFeed.setVisible(false);
		
		midFeed.setFont(new Font("Dialog", Font.BOLD, 16));
		midFeed.setBounds(755, 227, 137, 65);
		contentPane.add(midFeed);
		midFeed.setVisible(false);
		
		highFeed.setFont(new Font("Dialog", Font.BOLD, 16));
		highFeed.setBounds(608, 227, 137, 65);
		contentPane.add(highFeed);
		highFeed.setVisible(false);
		
		catchAnimal.setBounds(1049, 350, 76, 65);
		contentPane.add(catchAnimal);
		catchAnimal.setFont(new java.awt.Font("Dialog", 1, 20));
		catchAnimal.setEnabled(false);
		
		dudeCowNum.setBounds(274, 567, 104, 34);
		contentPane.add(dudeCowNum);
		dudeCowNum.setFont(new java.awt.Font("Dialog", 1, 30));
		dudeCowNum.setText("牛 "+dude.getCowNumber()+" 隻");
		
		dudePigNum.setBounds(411, 567, 104, 34);
		contentPane.add(dudePigNum);
		dudePigNum.setFont(new java.awt.Font("Dialog", 1, 30));
		dudePigNum.setText("豬 "+dude.getPigNumber()+" 隻");
		
		dudeChickenNum.setBounds(555, 567, 104, 34);
		contentPane.add(dudeChickenNum);
		dudeChickenNum.setFont(new java.awt.Font("Dialog", 1, 30));
		dudeChickenNum.setText("雞 "+dude.getChickenNumber()+" 隻");
		
		home.setFont(new Font("Dialog", Font.BOLD, 20));
		home.setBounds(1008, 526, 117, 65);
		contentPane.add(home);
		 
		//成長值
		animalRate.setBounds(50, 30, 189, 55);
		contentPane.add(animalRate);
		animalRate.setFont(new java.awt.Font("Dialog", 1, 30));
		
		animal1.setBounds(456, 231, 87, 55);
		contentPane.add(animal1);
		animal1.setFont(new java.awt.Font("Dialog", 1, 20));
		Timer timer1 = new Timer();
		RunningButton run1 = new RunningButton(animal1, 456, 231);
		timer1.schedule(run1, 1000, 180);
		animal1.setVisible(false);
		
		animal2.setFont(new Font("Dialog", Font.BOLD, 20));
		animal2.setBounds(231, 208, 87, 55);
		contentPane.add(animal2);
		Timer timer2 = new Timer();
		RunningButton run2 = new RunningButton(animal2, 231, 208);
		timer2.schedule(run2, 1000, 180);
		animal2.setVisible(false);
		
		animal3.setFont(new Font("Dialog", Font.BOLD, 20));
		animal3.setBounds(214, 312, 87, 55);
		contentPane.add(animal3);
		Timer timer3 = new Timer();
		RunningButton run3 = new RunningButton(animal3, 214, 312);
		timer3.schedule(run3, 1000, 180);
		animal3.setVisible(false);
		
		animal4.setFont(new Font("Dialog", Font.BOLD, 20));
		animal4.setBounds(336, 350, 87, 55);
		contentPane.add(animal4);
		Timer timer4 = new Timer();
		RunningButton run4 = new RunningButton(animal4, 336, 350);
		timer4.schedule(run4, 1000, 180);
		animal4.setVisible(false);
		
		animal5.setFont(new Font("Dialog", Font.BOLD, 20));
		animal5.setBounds(185, 102, 87, 55);
		contentPane.add(animal5);
		Timer timer5 = new Timer();
		RunningButton run5 = new RunningButton(animal5, 185, 102);
		timer5.schedule(run5, 1000, 180);
		animal5.setVisible(false);
		
		animal6.setFont(new Font("Dialog", Font.BOLD, 20));
		animal6.setBounds(84, 247, 87, 55);
		contentPane.add(animal6);
		Timer timer6 = new Timer();
		RunningButton run6 = new RunningButton(animal6, 84, 247);
		timer6.schedule(run6, 1000, 180);
		animal6.setVisible(false);
		
		animal7.setFont(new Font("Dialog", Font.BOLD, 20));
		animal7.setBounds(397, 118, 87, 55);
		contentPane.add(animal7);
		Timer timer7 = new Timer();
		RunningButton run7 = new RunningButton(animal7, 397, 118);
		timer7.schedule(run7, 1000, 180);
		animal7.setVisible(false);
		
		animal8.setFont(new Font("Dialog", Font.BOLD, 20));
		animal8.setBounds(555, 330, 87, 55);
		contentPane.add(animal8);
		Timer timer8 = new Timer();
		RunningButton run8 = new RunningButton(animal8, 555, 330);
		timer8.schedule(run8, 1000, 180);
		animal8.setVisible(false);
		
		animal9.setFont(new Font("Dialog", Font.BOLD, 20));
		animal9.setBounds(620, 150, 87, 55);
		contentPane.add(animal9);
		Timer timer9 = new Timer();
		RunningButton run9 = new RunningButton(animal9, 620, 150);
		timer9.schedule(run9, 1000, 180);
		animal9.setVisible(false);
		
		animal10.setFont(new Font("Dialog", Font.BOLD, 20));
		animal10.setBounds(708, 330, 87, 55);
		contentPane.add(animal10);
		Timer timer10 = new Timer();
		RunningButton run10 = new RunningButton(animal10, 708, 330);
		timer10.schedule(run10, 1000, 180);
		animal10.setVisible(false);
		
		startFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printHouseAnimalNum(warehouse);
				returnHouseAnimal(warehouse);
				closeFeed();
				feedChicken.setVisible(true);
				feedPig.setVisible(true);
				feedCow.setVisible(true);
				feedAnimal.setEnabled(false);
				printdudeAnimalNum(dude, dudeChickenNum, dudePigNum, dudeCowNum);
			}
		});
		feedChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dude.getNullNum(new Chicken(),warehouse)==false)
				{
					dude.startFeedChicken(new Chicken());
				}
				showButton(dude);
				printHouseAnimalNum(warehouse);
				returnHouseAnimal(warehouse);
				printdudeAnimalNum(dude, dudeChickenNum, dudePigNum, dudeCowNum);
			}
		});
		feedPig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(dude.getNullNum(new Pig(),warehouse)==false)
				{
					dude.startFeedPig(new Pig());
				}
				showButton(dude);
				printHouseAnimalNum(warehouse);
				returnHouseAnimal(warehouse);
				printdudeAnimalNum(dude, dudeChickenNum, dudePigNum, dudeCowNum);
			}
		});
		feedCow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(dude.getNullNum(new Cow(),warehouse)==false)
				{
					dude.startFeedCow(new Cow());
				}
				showButton(dude);
				printHouseAnimalNum(warehouse);
				returnHouseAnimal(warehouse);
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
			}
		});
		lowFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dude.getPondLand().get(num).feeding(new SimpleFeed());
				warehouse.removeFeed(new SimpleFeed().getName());
				printHouseFeedNum(warehouse);
				returnHouseFeed(warehouse);
				printAnimalRate(dude, num);
				returnAnimalEat(dude, num);
			}
		});
		midFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dude.getPondLand().get(num).feeding(new GeneralFeed());
				warehouse.removeFeed(new GeneralFeed().getName());
				printHouseFeedNum(warehouse);
				returnHouseFeed(warehouse);
				printAnimalRate(dude, num);
				returnAnimalEat(dude, num);
			}
		});
		highFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dude.getPondLand().get(num).feeding(new AdvancedFeed());
				warehouse.removeFeed(new AdvancedFeed().getName());
				printHouseFeedNum(warehouse);
				returnHouseFeed(warehouse);
				printAnimalRate(dude, num);
				returnAnimalEat(dude, num);
				
			}
		});
		catchAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				dude.capturing(num);
				printdudeAnimalNum(dude, dudeChickenNum, dudePigNum, dudeCowNum);
				showButton(dude);
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
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				
			}
		});
	}
	public void buttonAction(Dude dude, int num) { //動物按鈕
		closeFeed();
		closeStart();
		if(dude.getPondLand().get(num).getGrowingRate()>=100)catchAnimal.setEnabled(true);
		else catchAnimal.setEnabled(false);
		printAnimalRate(dude, num);
		returnAnimalEat(dude, num);
	}
	public void closeFeed() { //隱身三飼料按鈕
		lowFeed.setVisible(false);
		midFeed.setVisible(false);
		highFeed.setVisible(false);
	}
	public void closeStart() { //隱身三動物按鈕
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
		animalRate.setText("成長值: "+dude.getPondLand().get(i).getGrowingRate());
	}
	public void printHouseAnimalNum(WareHouse warehouse) { //印待成長動物數量
		feedChicken.setText("雞 "+warehouse.getYoungChickenNumber());
		feedPig.setText("豬 "+warehouse.getYoungPigNumber());
		feedCow.setText("牛 "+warehouse.getYoungCowNumber());
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
		lowFeed.setText("低級飼料 "+warehouse.getSimpleFeedNumber());
		midFeed.setText("中級飼料 "+warehouse.getGeneralFeedNumber());
		highFeed.setText("高級飼料 "+warehouse.getAdvencedFeedNumber());
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
		dudeChickenNum.setText("雞 "+dude.getChickenNumber()+" 隻");
		dudePigNum.setText("豬 "+dude.getPigNumber()+" 隻");
		dudeCowNum.setText("牛 "+dude.getCowNumber()+" 隻");
	}
    class RunningButton extends TimerTask {
    	private JButton btn;
    	private double coordinateX, coordinateY;
    	private double vx = Math.sin(1) * 5;
    	private double vy = Math.cos(1) * 5; 
    	public RunningButton(JButton btn, double coordinateX, double coordinateY) {
        	this.btn = btn;
        	this.coordinateX = coordinateX;
        	this.coordinateY = coordinateY;
    	}
        public void run() {
            if (coordinateX + vx < 50) {
                vx = -vx;
            }
            if (coordinateX + vx + 60 > 950) {
                vx = -vx;
            }
            if (coordinateY + vy < 90) {
                vy = -vy;
            }
            if (coordinateY + vy + 25 > 500) {
                vy = -vy;
            }
            coordinateX += vx;
            coordinateY += vy;
            btn.setBounds((int) coordinateX, (int) coordinateY, 87, 55);
    		
        }
        
    }
    public void showButton(Dude dude) {
    	for(int i=0; i<dude.getPondLand().size(); i++)
		{
    		if(dude.getPondLand().get(i)==null)
    		{
    			System.out.printf("%d是null啦!!!\n", i);
    			button.get(i).setVisible(false);
    		}
    		else
    		{
    			System.out.printf("%s\n", dude.getPondLand().get(i).getName());
    			button.get(i).setText(dude.getPondLand().get(i).getName());
    			button.get(i).setVisible(true);
    		}
			
		}
    }
}
