package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import java.util.Timer;
import java.util.TimerTask;

public class FarmScreen extends JPanel implements ActionListener {

	//private final Action action = new SwingAction();
	private Main mainFrame;
	private JButton returnButton = new JButton("return");
	//private ArrayList<Crop> crop = new ArrayList<Crop>(12);
	//private int[] storeCropArray = new int[12];
	private int count = 0;
	private int landNum = -1;
	
	JButton btn = new JButton();   //測試用button 不會出現
	JButton waterButton = new JButton();
	JButton fertilizeButton = new JButton();
	JButton sowingButton = new JButton();
	JButton harvestButton = new JButton();
	JButton pesticideButton = new JButton();
	JButton cornButton = new JButton();
	JButton wheatButton = new JButton();
	JButton cabbageButton = new JButton();
	JButton button_0 = new JButton("Land0");
	JButton button_3 = new JButton("Land3");
	JButton button_6 = new JButton("Land6");
	JButton button_9 = new JButton("Land9");
	JButton button_1 = new JButton("Land1");
	JButton button_4 = new JButton("Land4");
	JButton button_7 = new JButton("Land7");
	JButton button_10 = new JButton("Land10");
	JButton button_2 = new JButton("Land2");
	JButton button_5 = new JButton("Land5");
	JButton button_8 = new JButton("Land8");
	JButton button_11 = new JButton("Land11");
	ImageIcon cornSeed = resizeImage (90,80,new ImageIcon("../picture/corn.png"));
	ImageIcon cabbageSeed = resizeImage (90,80,new ImageIcon("../picture/cabbage.png"));
	ImageIcon wheatSeed = resizeImage (90,80,new ImageIcon("../picture/wheat.png"));
	ImageIcon water = resizeImage (90,80,new ImageIcon("../picture/water.png"));
	ImageIcon harvest = resizeImage (100,80,new ImageIcon("../picture/harvest.png"));
	ImageIcon fertilize = resizeImage (90,80,new ImageIcon("../picture/fertilizer.png"));
	ImageIcon sowing = resizeImage (90,80,new ImageIcon("../picture/addCrop.png"));
	ImageIcon killBug = resizeImage (80,85,new ImageIcon("../picture/killBug.png"));
	
	
	public void reload()
	{
		fertilizeButton.setVisible(false);
		harvestButton.setVisible(false);
		sowingButton.setVisible(false);
		waterButton.setVisible(false);
		pesticideButton.setVisible(false);
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
    
	public void LandButton(Farm farm, WareHouse wareHouse)
	{
		fertilizeButton.setVisible(true);
		harvestButton.setVisible(true);
		sowingButton.setVisible(true);
		waterButton.setVisible(true);
		pesticideButton.setVisible(true);
		if(farm.getStoreCropNum(landNum) == -1)
		{
			System.out.println("一無所有的土地ouq");
			fertilizeButton.setEnabled(false);
			harvestButton.setEnabled(false);
			sowingButton.setEnabled(true);
			waterButton.setEnabled(false);
			pesticideButton.setEnabled(false);
			
			cornButton.setVisible(false);
			wheatButton.setVisible(false);
			cabbageButton.setVisible(false);
		}
		else if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate() >= 100)
		{
			System.out.println("該宰了他了 =u=");
			fertilizeButton.setEnabled(false);
			harvestButton.setEnabled(true);
			sowingButton.setEnabled(false);
			waterButton.setEnabled(false);
			pesticideButton.setEnabled(false);
			
			cornButton.setVisible(false);
			wheatButton.setVisible(false);
			cabbageButton.setVisible(false);
		}
		else
		{
			System.out.println("這裡種"+farm.getFarmLand().get(farm.getStoreCropNum(landNum)).pickSeed());
			System.out.println("GrowingRate = "+farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
			if(wareHouse.getFertilizer() == 0)
				fertilizeButton.setEnabled(false);
			else
				fertilizeButton.setEnabled(true);

			if(farm.decideCallRandomCheck(farm.getFarmLand().get(farm.getStoreCropNum(landNum))))
				waterButton.setEnabled(true);
			else
				waterButton.setEnabled(false);
			
			harvestButton.setEnabled(false);
			sowingButton.setEnabled(false);
			pesticideButton.setEnabled(false);

			cornButton.setVisible(false);
			wheatButton.setVisible(false);
			cabbageButton.setVisible(false);
		}
	}
	
	public FarmScreen(Main mainFrame, WareHouse wareHouse) {
		
		this.mainFrame = mainFrame;
		Farm farm = new Farm(wareHouse);
		farm.setStoreCropNum();
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setLayout(null);
		this.setSize(1200, 675);
		
		//收割button
		harvestButton.setBounds(1065, 66, 130, 98);
		harvestButton.setVisible(false);
		buttonOFF(harvestButton);
		this.add(harvestButton);
		harvestButton.setFont(new Font("Dialog", Font.BOLD, 20));
		harvestButton.setIcon(harvest);
		harvestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate() >= 100)
				{
					farm.harvest(landNum);
					
					fertilizeButton.setEnabled(false);
					harvestButton.setEnabled(false);
					sowingButton.setEnabled(true);
					waterButton.setEnabled(false);	
					pesticideButton.setEnabled(false);
					reload();
				}
			}
		});
		
		//澆水button
		waterButton.setBounds(1065, 159, 130, 98);
		waterButton.setVisible(false);
		this.add(waterButton);
		buttonOFF(waterButton);
		waterButton.setFont(new java.awt.Font("Dialog", 1, 20));
		waterButton.setIcon(water);
		waterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farm.getOneHOurToNowDate();
				farm.getFarmLand().get(farm.getStoreCropNum(landNum)).water();
				System.out.println("澆水後GrowingRate = "+farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
				if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate() >= 100)
				{
					fertilizeButton.setEnabled(false);
					harvestButton.setEnabled(true);
					sowingButton.setEnabled(false);
					waterButton.setEnabled(false);
					pesticideButton.setEnabled(false);
				}
				reload();
			}
		});

		//施肥button
		fertilizeButton.setBounds(1065, 251, 129, 98);
		fertilizeButton.setVisible(false);
		buttonOFF(fertilizeButton);
		this.add(fertilizeButton);
		fertilizeButton.setFont(new Font("Dialog", Font.BOLD, 20));
		fertilizeButton.setIcon(fertilize);
		if(wareHouse.getFertilizer() == 0)
			fertilizeButton.setEnabled(false);
		else
			fertilizeButton.setEnabled(true);
		fertilizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farm.getFarmLand().get(farm.getStoreCropNum(landNum)).fertilize();
				System.out.println("施肥後GrowingRate = "+farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
				wareHouse.editFertilizer(-1);
				
				if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate() >= 100)
				{
					fertilizeButton.setEnabled(false);
					harvestButton.setEnabled(true);
					sowingButton.setEnabled(false);
					waterButton.setEnabled(false);
					pesticideButton.setEnabled(false);
				}
				reload();
			}
		});
		

		//播種button
		sowingButton.setBounds(1065, 345, 130, 98);
		sowingButton.setVisible(false);
		buttonOFF(sowingButton);
		this.add(sowingButton);
		sowingButton.setFont(new Font("Dialog", Font.BOLD, 20));
		sowingButton.setIcon(sowing);
		sowingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("玉米種子數量 = "+wareHouse.getCornSeedNumber());
				System.out.println("小麥種子數量 = "+wareHouse.getWheatSeedNumber());
				System.out.println("高麗菜種子數量 = "+wareHouse.getCabbageSeedNumber());
				
				cornButton.setVisible(true);
				wheatButton.setVisible(true);
				cabbageButton.setVisible(true);
				if(wareHouse.getCornSeedNumber() == 0)
					cornButton.setEnabled(false);
				if(wareHouse.getWheatSeedNumber() == 0)
					wheatButton.setEnabled(false);
				if(wareHouse.getCabbageSeedNumber() == 0)
					cabbageButton.setEnabled(false);
				cornButton.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			        	if(farm.getStoreCropNum(landNum)== -1)
			        	{
				        	farm.sowingCorn(landNum);
			    			cornButton.setVisible(false);
							wheatButton.setVisible(false);
							cabbageButton.setVisible(false);
							sowingButton.setEnabled(false);
							waterButton.setEnabled(true);
							if(wareHouse.getFertilizer() == 0)
								fertilizeButton.setEnabled(false);
							else
								fertilizeButton.setEnabled(true);
							reload();
			        	}
			        }
			    });
			
			
				wheatButton.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			        	if(farm.getStoreCropNum(landNum) == -1)
			        	{
			        		farm.sowingWheat(landNum);
			    			cornButton.setVisible(false);
							wheatButton.setVisible(false);
							cabbageButton.setVisible(false);
							sowingButton.setEnabled(false);
							waterButton.setEnabled(true);
							if(wareHouse.getFertilizer() == 0)
								fertilizeButton.setEnabled(false);
							else
								fertilizeButton.setEnabled(true);
							reload();
			        	}
			        	
			        }
			    });
			
			
				cabbageButton.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			        	if(farm.getStoreCropNum(landNum) == -1)
			        	{
				        	farm.sowingCabbage(landNum);
			    			cornButton.setVisible(false);
							wheatButton.setVisible(false);
							cabbageButton.setVisible(false);
							sowingButton.setEnabled(false);
							waterButton.setEnabled(true);
							if(wareHouse.getFertilizer() == 0)
								fertilizeButton.setEnabled(false);
							else
								fertilizeButton.setEnabled(true);
							reload();
			        	}
			        	
			        }
			    });
			
			}
		});
		
		//除蟲除草button
		pesticideButton.setBounds(1065, 439, 130, 92);
		pesticideButton.setVisible(false);
		this.add(pesticideButton);
		buttonOFF(pesticideButton);
		pesticideButton.setIcon(killBug);
		harvestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//farm.xxx;
			}
		});
		
		//HOME鍵返回
		returnButton.setFont(new Font("Dialog", Font.BOLD, 20));	
		buttonOFF(returnButton);
		returnButton.setIcon(new ImageIcon("..\\picture\\HOME.png"));
		returnButton.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		returnButton.setBounds(1065, 529, 130, 98);
		returnButton.addActionListener(this);
		returnButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				returnButton.setIcon(resizeImage(returnButton.getIcon().getIconWidth()+10,returnButton.getIcon().getIconHeight()+10,(ImageIcon)returnButton.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	returnButton.setIcon(new ImageIcon("..\\picture\\HOME.png"));
            } 
			
		});
		this.add(returnButton);
		cornButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		cornButton.setBounds(966, 363, 84, 69);
		cornButton.setVisible(false);
		this.add(cornButton);
		buttonOFF(cornButton);
		cornButton.setFont(new java.awt.Font("Dialog", 1, 20));
		cornButton.setIcon(cornSeed);
		
		
		wheatButton.setBounds(867, 363, 84, 69);
		wheatButton.setVisible(false);
		this.add(wheatButton);
		buttonOFF(wheatButton);
		wheatButton.setFont(new java.awt.Font("Dialog", 1, 20));
		wheatButton.setIcon(wheatSeed);
		cabbageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		cabbageButton.setBounds(768, 363, 84, 69);
		cabbageButton.setVisible(false);
		this.add(cabbageButton);
		buttonOFF(cabbageButton);
		cabbageButton.setFont(new java.awt.Font("Dialog", 1, 20));
		cabbageButton.setIcon(cabbageSeed);
		
		//Land0
		//button_0.setAction(action);
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 0;
				LandButton(farm, wareHouse);
			}
		});
		button_0.setBounds(59, 172, 193, 102);
		this.add(button_0);
		buttonOFF(button_0);
		
		//Land3
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 3;
				LandButton(farm, wareHouse);
			}
		});
		button_3.setBounds(203, 305, 193, 98);
		this.add(button_3);
		buttonOFF(button_3);
		
		//Land6
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 6;
				LandButton(farm, wareHouse);
			}
		});
		button_6.setBounds(350, 428, 193, 87);
		this.add(button_6);
		buttonOFF(button_6);
		
		//Land9
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 9;
				LandButton(farm, wareHouse);
			}
		});
		button_9.setBounds(480, 537, 185, 92);
		this.add(button_9);
		buttonOFF(button_9);
		
		//Land1
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 1;
				LandButton(farm, wareHouse);
			}
		});
		button_1.setBounds(293, 94, 185, 98);
		this.add(button_1);
		buttonOFF(button_1);
		
		//Land4
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 4;
				LandButton(farm, wareHouse);
			}
		});
		button_4.setBounds(447, 223, 176, 98);
		this.add(button_4);
		buttonOFF(button_4);
		
		//Land7
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 7;
				LandButton(farm, wareHouse);
			}
		});
		button_7.setBounds(577, 346, 167, 86);
		this.add(button_7);
		buttonOFF(button_7);
		
		//Land10
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 10;
				LandButton(farm, wareHouse);
			}
		});
		button_10.setBounds(711, 447, 176, 102);
		this.add(button_10);
		buttonOFF(button_10);
		
		//Land2
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 2;
				LandButton(farm, wareHouse);
			}
		});
		button_2.setBounds(535, 37, 176, 87);
		this.add(button_2);
		buttonOFF(button_2);
		
		//Land5
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 5;
				LandButton(farm, wareHouse);
			}
		});
		button_5.setBounds(669, 159, 167, 87);
		this.add(button_5);
		buttonOFF(button_5);
		
		//Land8
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 8;
				LandButton(farm, wareHouse);
			}
		});
		button_8.setBounds(801, 272, 167, 92);
		this.add(button_8);
		buttonOFF(button_8);
		
		//Land11
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 11;
				LandButton(farm, wareHouse);
			}
		});
		button_11.setBounds(923, 391, 176, 87);
		this.add(button_11);
		buttonOFF(button_11);
		
		//背景圖片設定
		JLabel lblNewLabel = new JLabel("backGround");
		lblNewLabel.setLocation(0, 0);
		ImageIcon img = new ImageIcon("../picture/farm.png");
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(new_img));
		lblNewLabel.setSize(1200, 675);
		this.add(lblNewLabel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == returnButton) {
			this.mainFrame.changeToMainScreen();
		}
	}
}
