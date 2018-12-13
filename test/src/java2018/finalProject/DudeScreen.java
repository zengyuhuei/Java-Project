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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
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
	JLabel dudeAnimalNum = new JLabel("牧場動物(上限10隻):");
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
	private int num, buttonNum;
	ImageIcon chickenleft = new ImageIcon("../picture/chickenleft.gif");
	ImageIcon chickenright = new ImageIcon("../picture/chickenright.gif");
	ImageIcon pigleft = new ImageIcon("../picture/pigleft.gif");
	ImageIcon pigright = new ImageIcon("../picture/pigright.gif");
	ImageIcon cowleft = new ImageIcon("../picture/cowleft.gif");
	ImageIcon cowright = new ImageIcon("../picture/cowright.gif");
	
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
		//ImageIcon chicken =resizeImage (75,75,new ImageIcon("../picture/chicken.gif"));
		Dude dude = new Dude(warehouse);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dudeAnimalNum.setBounds(207, 21, 303, 43);
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
		
		dudeCowNum.setBounds(503, 25, 104, 34);
		contentPane.add(dudeCowNum);
		dudeCowNum.setFont(new java.awt.Font("Dialog", 1, 30));
		dudeCowNum.setText("牛 "+dude.getCowNumber()+" 隻");
		
		dudePigNum.setBounds(608, 25, 104, 34);
		contentPane.add(dudePigNum);
		dudePigNum.setFont(new java.awt.Font("Dialog", 1, 30));
		dudePigNum.setText("豬 "+dude.getPigNumber()+" 隻");
		
		dudeChickenNum.setBounds(722, 25, 104, 34);
		contentPane.add(dudeChickenNum);
		dudeChickenNum.setFont(new java.awt.Font("Dialog", 1, 30));
		dudeChickenNum.setText("雞 "+dude.getChickenNumber()+" 隻");
		
		home.setFont(new Font("Dialog", Font.BOLD, 20));
		home.setBounds(1008, 526, 117, 65);
		contentPane.add(home);
		 
		//成長值
		animalRate.setBounds(31, 30, 189, 55);
		contentPane.add(animalRate);
		animalRate.setFont(new java.awt.Font("Dialog", 1, 30));
		
		animal1.setBounds(456, 231, 100, 100);
		contentPane.add(animal1);
		animal1.setFont(new java.awt.Font("Dialog", 1, 20));
		Timer timer1 = new Timer();
		RunningButton run1 = new RunningButton(animal1, 456, 231, dude, 0);
		timer1.schedule(run1, 1000, 220);
		animal1.setVisible(false);
		
		animal2.setFont(new Font("Dialog", Font.BOLD, 20));
		animal2.setBounds(384, 415, 100, 100);
		contentPane.add(animal2);
		Timer timer2 = new Timer();
		RunningButton run2 = new RunningButton(animal2, 384, 415, dude, 1);
		timer2.schedule(run2, 1000, 220);
		animal2.setVisible(false);
		
		animal3.setFont(new Font("Dialog", Font.BOLD, 20));
		animal3.setBounds(214, 312, 100, 100);
		contentPane.add(animal3);
		Timer timer3 = new Timer();
		RunningButton run3 = new RunningButton(animal3, 214, 312, dude, 2);
		timer3.schedule(run3, 1000, 220);
		animal3.setVisible(false);
		
		animal4.setFont(new Font("Dialog", Font.BOLD, 20));
		animal4.setBounds(656, 318, 100, 100);
		contentPane.add(animal4);
		Timer timer4 = new Timer();
		RunningButton run4 = new RunningButton(animal4, 658, 318, dude, 3);
		timer4.schedule(run4, 1000, 220);
		animal4.setVisible(false);
		
		animal5.setFont(new Font("Dialog", Font.BOLD, 20));
		animal5.setBounds(207, 183, 100, 100);
		contentPane.add(animal5);
		Timer timer5 = new Timer();
		RunningButton run5 = new RunningButton(animal5, 207, 183, dude, 4);
		timer5.schedule(run5, 1000, 220);
		animal5.setVisible(false);
		
		animal6.setFont(new Font("Dialog", Font.BOLD, 20));
		animal6.setBounds(274, 403, 100, 100);
		contentPane.add(animal6);
		Timer timer6 = new Timer();
		RunningButton run6 = new RunningButton(animal6, 260, 403, dude, 5);
		timer6.schedule(run6, 1000, 220);
		animal6.setVisible(false);
		
		animal7.setFont(new Font("Dialog", Font.BOLD, 20));
		animal7.setBounds(336, 217, 100, 100);
		contentPane.add(animal7);
		Timer timer7 = new Timer();
		RunningButton run7 = new RunningButton(animal7, 336, 217, dude, 6);
		timer7.schedule(run7, 1000, 220);
		animal7.setVisible(false);
		
		animal8.setFont(new Font("Dialog", Font.BOLD, 20));
		animal8.setBounds(585, 394, 100, 100);
		contentPane.add(animal8);
		Timer timer8 = new Timer();
		RunningButton run8 = new RunningButton(animal8, 585, 394, dude, 7);
		timer8.schedule(run8, 1000, 220);
		animal8.setVisible(false);
		
		animal9.setFont(new Font("Dialog", Font.BOLD, 20));
		animal9.setBounds(620, 150, 100, 100);
		contentPane.add(animal9);
		Timer timer9 = new Timer();
		RunningButton run9 = new RunningButton(animal9, 620, 150, dude, 8);
		timer9.schedule(run9, 1000, 220);
		animal9.setVisible(false);
		
		animal10.setFont(new Font("Dialog", Font.BOLD, 20));
		animal10.setBounds(708, 330, 100, 100);
		contentPane.add(animal10);
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
				feedChicken.setVisible(true);
				feedPig.setVisible(true);
				feedCow.setVisible(true);
				feedAnimal.setEnabled(false);
				catchAnimal.setEnabled(false);
				printdudeAnimalNum(dude, dudeChickenNum, dudePigNum, dudeCowNum);
			}
		});
		if(dude.getNum()==9) {
			startFeed.addMouseListener(new MouseAdapter() {  //提醒牧場數量上限
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int input = JOptionPane.showOptionDialog(null, "牧場動物數量已達上限!", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				}
			});		
		}
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
				feedAction(dude,warehouse);
			}
		});
		midFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dude.getPondLand().get(num).feeding(new GeneralFeed());
				warehouse.removeFeed(new GeneralFeed().getName());
				feedAction(dude,warehouse);
			}
		});
		highFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dude.getPondLand().get(num).feeding(new AdvancedFeed());
				warehouse.removeFeed(new AdvancedFeed().getName());
				feedAction(dude,warehouse);
			}
		});
		catchAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startFeed.setEnabled(true);
				closeFeed();
				closeStart();
				dude.capturing(num);
				printdudeAnimalNum(dude, dudeChickenNum, dudePigNum, dudeCowNum);
				showButton(dude);
				catchAnimal.setEnabled(false);
			}
		});
		/*catchAnimal.addMouseListener(new MouseAdapter() { //跳轉遊戲畫面
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int input = JOptionPane.showOptionDialog(null, "捕捉隨機任務開啟，請問是否進入?(完成可獲得100金幣)", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(input == 0) //ok
				{
					
				}	
			}
		});*/
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
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setLocation(0, 0);
		ImageIcon img = new ImageIcon("../picture/dude.jpg");
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(new_img));
		lblNewLabel.setSize(1200, 675);
		contentPane.add(lblNewLabel);
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
    	private double vx, vy;
    	private int random = (int)(Math.random()*4);
    	private Dude dude;
    	private int i;
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
            if (coordinateX + vx < 50) {
                vx = -vx;
                showButtonRight(dude, i);
            }
            if (coordinateX + vx + 60 > 880) {
                vx = -vx;
                showButtonLeft(dude, i);
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
        public void showButtonLeft(Dude dude, int i) {
        	buttonGIF();
        	if(i<dude.getPondLand().size()&&dude.getPondLand().get(i)!=null)
        	{
        		if(dude.getPondLand().get(i).getName()=="雞")
    			{
    				btn.setIcon(chickenleft);
    			}
    			if(dude.getPondLand().get(i).getName()=="豬")
    			{
    				btn.setIcon(pigleft);
    			}
    			if(dude.getPondLand().get(i).getName()=="牛")
    			{
    				btn.setIcon(cowleft);
    			}
    			btn.setVisible(true);
        	}
		
        }
        public void showButtonRight(Dude dude, int i) {
        	buttonGIF();
        	if(i<dude.getPondLand().size()&&dude.getPondLand().get(i)!=null)
        	{
				if(dude.getPondLand().get(i).getName()=="雞")
				{
					btn.setIcon(chickenright);
				}
				if(dude.getPondLand().get(i).getName()=="豬")
				{
					btn.setIcon(pigright);
				}
				if(dude.getPondLand().get(i).getName()=="牛")
				{
					btn.setIcon(cowright);
				}
				btn.setVisible(true);
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
        public int getVX() {
        	if(vx>0) {
        		return 1;
        	}
        	else {
        		return -1;
        	}
        }
    }
    public void showButton(Dude dude) {
    	buttonGIF();
    	buttonNum = dude.getButtonNum();
    	for(int i=0; i<dude.getPondLand().size();i++) {
    		if(dude.getPondLand().get(i)==null) {
    			button.get(i).setVisible(false);
    		}
    	}
		if(dude.getPondLand().get(buttonNum).getName()=="雞")
		{	if(runbutton.get(buttonNum).getVX()<0)
				button.get(buttonNum).setIcon(chickenleft);
			else
				button.get(buttonNum).setIcon(chickenright);
		}
		if(dude.getPondLand().get(buttonNum).getName()=="豬")
		{
			if(runbutton.get(buttonNum).getVX()<0)
				button.get(buttonNum).setIcon(pigleft);
			else
				button.get(buttonNum).setIcon(pigright);
		}
		if(dude.getPondLand().get(buttonNum).getName()=="牛")
		{
			if(runbutton.get(buttonNum).getVX()<0)
				button.get(buttonNum).setIcon(cowleft);
			else
				button.get(buttonNum).setIcon(cowright);
		}
		button.get(buttonNum).setVisible(true);
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
}







