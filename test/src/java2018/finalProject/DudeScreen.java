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
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class DudeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	JButton startFeed = new JButton("養殖");	
	JButton feedChicken = new JButton(); 
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
	
	public DudeScreen(WareHouse warehouse) {
		
		Dude dude = new Dude(warehouse);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dudeAnimalNum = new JLabel("牧場動物:");
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
		
		JLabel dudeCowNum = new JLabel();
		dudeCowNum.setBounds(274, 567, 104, 34);
		contentPane.add(dudeCowNum);
		dudeCowNum.setFont(new java.awt.Font("Dialog", 1, 30));
		dudeCowNum.setText("牛 "+dude.getCowNumber()+" 隻");
		
		JLabel dudePigNum = new JLabel();
		dudePigNum.setBounds(411, 567, 104, 34);
		contentPane.add(dudePigNum);
		dudePigNum.setFont(new java.awt.Font("Dialog", 1, 30));
		dudePigNum.setText("豬 "+dude.getPigNumber()+" 隻");
		
		JLabel dudeChickenNum = new JLabel();
		dudeChickenNum.setBounds(555, 567, 104, 34);
		contentPane.add(dudeChickenNum);
		dudeChickenNum.setFont(new java.awt.Font("Dialog", 1, 30));
		dudeChickenNum.setText("雞 "+dude.getChickenNumber()+" 隻");
		
		home.setFont(new Font("Dialog", Font.BOLD, 20));
		home.setBounds(1008, 526, 117, 65);
		contentPane.add(home);
		
		JLabel animalRate = new JLabel(); //成長值
		animalRate.setBounds(50, 30, 189, 55);
		contentPane.add(animalRate);
		animalRate.setFont(new java.awt.Font("Dialog", 1, 30));
		
		animal1.setBounds(411, 236, 87, 55);
		contentPane.add(animal1);
		animal1.setFont(new java.awt.Font("Dialog", 1, 20));
		Timer timer1 = new Timer();
		RunningButton run1 = new RunningButton(animal1, 411, 236);
		timer1.schedule(run1, 1000, 180);
		
		animal2.setFont(new Font("Dialog", Font.BOLD, 20));
		animal2.setBounds(287, 150, 87, 55);
		contentPane.add(animal2);
		Timer timer2 = new Timer();
		RunningButton run2 = new RunningButton(animal2, 287, 150);
		timer2.schedule(run2, 1000, 180);
		animal2.setVisible(false);
		
		animal3.setFont(new Font("Dialog", Font.BOLD, 20));
		animal3.setBounds(185, 274, 87, 55);
		contentPane.add(animal3);
		Timer timer3 = new Timer();
		RunningButton run3 = new RunningButton(animal3, 287, 150);
		timer3.schedule(run3, 1000, 180);
		animal3.setVisible(false);
		
		animal4.setFont(new Font("Dialog", Font.BOLD, 20));
		animal4.setBounds(336, 350, 87, 55);
		contentPane.add(animal4);
		Timer timer4 = new Timer();
		RunningButton run4 = new RunningButton(animal4, 287, 150);
		timer4.schedule(run4, 1000, 180);
		animal4.setVisible(false);
		
		animal5.setFont(new Font("Dialog", Font.BOLD, 20));
		animal5.setBounds(136, 107, 87, 55);
		contentPane.add(animal5);
		Timer timer5 = new Timer();
		RunningButton run5 = new RunningButton(animal5, 287, 150);
		timer5.schedule(run5, 1000, 180);
		animal5.setVisible(false);
		
		animal6.setFont(new Font("Dialog", Font.BOLD, 20));
		animal6.setBounds(105, 373, 87, 55);
		contentPane.add(animal6);
		Timer timer6 = new Timer();
		RunningButton run6 = new RunningButton(animal6, 105, 373);
		timer6.schedule(run6, 1000, 180);
		animal6.setVisible(false);
		
		animal7.setFont(new Font("Dialog", Font.BOLD, 20));
		animal7.setBounds(428, 97, 87, 55);
		contentPane.add(animal7);
		Timer timer7 = new Timer();
		RunningButton run7 = new RunningButton(animal7, 428, 97);
		timer7.schedule(run7, 1000, 180);
		animal7.setVisible(false);
		
		animal8.setFont(new Font("Dialog", Font.BOLD, 20));
		animal8.setBounds(491, 312, 87, 55);
		contentPane.add(animal8);
		Timer timer8 = new Timer();
		RunningButton run8 = new RunningButton(animal8, 491, 312);
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
			}
		});
		feedChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printHouseAnimalNum(warehouse);
				returnHouseAnimal(warehouse);
			}
		});
		feedPig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printHouseAnimalNum(warehouse);
				returnHouseAnimal(warehouse);
			}
		});
		feedCow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				printHouseFeedNum(warehouse);
				returnHouseFeed(warehouse);
			}
		});
		midFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printHouseFeedNum(warehouse);
				returnHouseFeed(warehouse);
			}
		});
		highFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printHouseFeedNum(warehouse);
				returnHouseFeed(warehouse);
				printAnimalRate(animalRate, dude, 0);
			}
		});
		catchAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
			}
		});
		animal1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedAnimal.setEnabled(true);
				closeFeed();
				closeStart();
				printAnimalRate(animalRate, dude, 0);
				returnAnimalEat(dude, 0);
			}
		});
		animal2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				printAnimalRate(animalRate, dude, 1);
				returnAnimalEat(dude, 1);
			}
		});
		animal3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				printAnimalRate(animalRate, dude, 2);
				returnAnimalEat(dude, 2);
			}
		});
		animal4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				printAnimalRate(animalRate, dude, 3);
				returnAnimalEat(dude, 3);
			}
		});
		animal5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				printAnimalRate(animalRate, dude, 4);
				returnAnimalEat(dude, 4);
			}
		});
		animal6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				printAnimalRate(animalRate, dude, 5);
				returnAnimalEat(dude, 5);
			}
		});
		animal7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				printAnimalRate(animalRate, dude, 6);
				returnAnimalEat(dude, 6);
			}
		});
		animal8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				printAnimalRate(animalRate, dude, 7);
				returnAnimalEat(dude, 7);
			}
		});
		animal9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				printAnimalRate(animalRate, dude, 8);
				returnAnimalEat(dude, 8);
			}
		});
		animal10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				printAnimalRate(animalRate, dude, 9);
				returnAnimalEat(dude, 9);
			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFeed();
				closeStart();
				
			}
		});
	}
	public void closeFeed() {
		lowFeed.setVisible(false);
		midFeed.setVisible(false);
		highFeed.setVisible(false);
	}
	public void closeStart() {
		feedChicken.setVisible(false);
		feedPig.setVisible(false);
		feedCow.setVisible(false);
	}
	public void returnAnimalEat(Dude dude, int i) {
		if(dude.getPondLand().get(i).getGrowingRate()<100)
			feedAnimal.setEnabled(true);
		else
			feedAnimal.setEnabled(true);
			catchAnimal.setEnabled(true);
	}
	public void printAnimalRate(JLabel animalRate, Dude dude, int i) {
		animalRate.setText("成長值: "+dude.getPondLand().get(i).getGrowingRate());
	}
	public void printHouseAnimalNum(WareHouse warehouse) {
		feedChicken.setText("雞 "+warehouse.getYoungChickenNumber());
		feedPig.setText("豬 "+warehouse.getYoungPigNumber());
		feedCow.setText("牛 "+warehouse.getYoungCowNumber());
	}
	public void returnHouseAnimal(WareHouse warehouse) {
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
	public void printHouseFeedNum(WareHouse warehouse) {
		lowFeed.setText("低級飼料 "+warehouse.getSimpleFeedNumber());
		midFeed.setText("中級飼料 "+warehouse.getGeneralFeedNumber());
		highFeed.setText("高級飼料 "+warehouse.getAdvencedFeedNumber());
	}
	public void returnHouseFeed(WareHouse warehouse) {
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
}
