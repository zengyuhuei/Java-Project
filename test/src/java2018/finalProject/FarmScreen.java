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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import java.util.Timer;
import java.util.TimerTask;

public class FarmScreen extends JPanel implements ActionListener {

	//private final Action action = new SwingAction();
	private Main mainFrame;
	private JButton returnButton = new JButton("");
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
	JButton button_0 = new JButton("");
	JButton button_3 = new JButton("");
	JButton button_6 = new JButton("");
	JButton button_9 = new JButton("");
	JButton button_1 = new JButton("");
	JButton button_4 = new JButton("");
	JButton button_7 = new JButton("");
	JButton button_10 = new JButton("");
	JButton button_2 = new JButton("");
	JButton button_5 = new JButton("");
	JButton button_8 = new JButton("");
	JButton button_11 = new JButton("");
	ImageIcon cornSeed = resizeImage (90,80,new ImageIcon("../picture/corn.png"));
	ImageIcon cabbageSeed = resizeImage (90,80,new ImageIcon("../picture/cabbage.png"));
	ImageIcon wheatSeed = resizeImage (90,80,new ImageIcon("../picture/wheat.png"));
	ImageIcon water = resizeImage (90,80,new ImageIcon("../picture/water.png"));
	ImageIcon harvest = resizeImage (100,80,new ImageIcon("../picture/harvest.png"));
	ImageIcon fertilize = resizeImage (90,80,new ImageIcon("../picture/fertilizer.png"));
	ImageIcon sowing = resizeImage (90,80,new ImageIcon("../picture/addCrop.png"));
	ImageIcon killBug = resizeImage (80,85,new ImageIcon("../picture/killBug.png"));
	ImageIcon seedBackground = new ImageIcon("../picture/feedBackground.PNG");
	ImageIcon rateBackground = resizeImage (220,180,new ImageIcon("../picture/board.PNG"));
	JLabel rateBackGround = new JLabel(rateBackground);
	JLabel seedBackGround = new JLabel(seedBackground);
	JLabel cornSeedNum = new JLabel();
	JLabel wheatSeedNum = new JLabel();
	JLabel cabbageSeedNum = new JLabel();
	JLabel cropRate = new JLabel();
	ImageIcon littleCorn = resizeImage (50,40,new ImageIcon("../picture/littleCorn.PNG"));
	ImageIcon littleWheat = resizeImage (50,40,new ImageIcon("../picture/littleWheat.PNG"));
	ImageIcon littleCabbage = resizeImage (50,40,new ImageIcon("../picture/littleCabbage.PNG"));
	ImageIcon midCorn = resizeImage (90,80,new ImageIcon("../picture/midCorn.PNG"));
	ImageIcon midWheat = resizeImage (90,80,new ImageIcon("../picture/midWheat.PNG"));
	ImageIcon midCabbage = resizeImage (90,80,new ImageIcon("../picture/midCabbage.PNG"));
	ImageIcon bigCorn = resizeImage (105,90,new ImageIcon("../picture/bigCorn.PNG"));
	ImageIcon bigWheat = resizeImage (105,90,new ImageIcon("../picture/bigWheat.PNG"));
	ImageIcon bigCabbage = resizeImage (105,90,new ImageIcon("../picture/bigCabbage.PNG"));
	ImageIcon nothingLand = resizeImage (1,1,new ImageIcon("../picture/bigCabbage.PNG"));
	
	public void reload()
	{
		fertilizeButton.setVisible(false);
		harvestButton.setVisible(false);
		sowingButton.setVisible(false);
		waterButton.setVisible(false);
		pesticideButton.setVisible(false);
		cornButton.setVisible(false);
		wheatButton.setVisible(false);
		cabbageButton.setVisible(false);
		cornSeedNum.setVisible(false);
		wheatSeedNum.setVisible(false);
		cabbageSeedNum.setVisible(false);
		rateBackGround.setVisible(false);
		seedBackGround.setVisible(false);
		cropRate.setVisible(false);
		
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
    public void checkCropImage(Farm farm, int growingRate)
    {
    	if(growingRate >= 100)
    	{
    		if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).pickSeed() == "玉米")
				checkButton().setIcon(bigCorn);
			else if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).pickSeed() == "小麥")
				checkButton().setIcon(bigWheat);
			else 
				checkButton().setIcon(bigCabbage);
    	}
    	else if(growingRate > 50)
    	{
    		if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).pickSeed() == "玉米")
				checkButton().setIcon(midCorn);
			else if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).pickSeed() == "小麥")
				checkButton().setIcon(midWheat);
			else 
				checkButton().setIcon(midCabbage);
    	}
    }
    public JButton checkButton()
    {
    	if(landNum == 0) return button_0;
    	else if(landNum == 1) return button_1;
    	else if(landNum == 2) return button_2;
    	else if(landNum == 3) return button_3;
    	else if(landNum == 4) return button_4;
    	else if(landNum == 5) return button_5;
    	else if(landNum == 6) return button_6;
    	else if(landNum == 7) return button_7;
    	else if(landNum == 8) return button_8;
    	else if(landNum == 9) return button_9;
    	else if(landNum == 10) return button_10;
    	else return button_11;
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

			seedBackGround.setVisible(false);
			rateBackGround.setVisible(false);
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
			
			seedBackGround.setVisible(false);
			rateBackGround.setVisible(true);
			cropRate.setVisible(true);
			cropRate.setText("成長值:100");
			checkCropImage(farm, 100);
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

			rateBackGround.setVisible(true);
			cropRate.setVisible(true);
			cropRate.setText("成長值: "+ farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
			checkCropImage(farm, farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
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
		harvestButton.setBounds(1075, 66, 130, 98);
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
					checkButton().setIcon(nothingLand);
					reload();
				}
			}
		});
		harvestButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				harvestButton.setIcon(resizeImage(harvestButton.getIcon().getIconWidth()+10,harvestButton.getIcon().getIconHeight()+10,(ImageIcon)harvestButton.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	harvestButton.setIcon(resizeImage (100,80,new ImageIcon("../picture/harvest.png")));
            } 
		});
		
		//澆水button
		waterButton.setBounds(1075, 159, 130, 98);
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
				checkCropImage(farm, farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
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
		waterButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				waterButton.setIcon(resizeImage(waterButton.getIcon().getIconWidth()+10,waterButton.getIcon().getIconHeight()+10,(ImageIcon)waterButton.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	waterButton.setIcon(resizeImage (90,80,new ImageIcon("../picture/water.png")));
            } 
		});

		//施肥button
		fertilizeButton.setBounds(1075, 252, 129, 98);
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
				checkCropImage(farm, farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
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
		fertilizeButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				fertilizeButton.setIcon(resizeImage(fertilizeButton.getIcon().getIconWidth()+10,fertilizeButton.getIcon().getIconHeight()+10,(ImageIcon)fertilizeButton.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	fertilizeButton.setIcon(resizeImage (90,80,new ImageIcon("../picture/fertilizer.png")));
            } 
		});

		//播種button
		sowingButton.setBounds(1075, 346, 130, 98);
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

				cornSeedNum.setText(" X "+ wareHouse.getCornSeedNumber());
				wheatSeedNum.setText(" X "+ wareHouse.getWheatSeedNumber());
				cabbageSeedNum.setText(" X "+ wareHouse.getCabbageSeedNumber());
				
				cornButton.setVisible(true);
				wheatButton.setVisible(true);
				cabbageButton.setVisible(true);
				seedBackGround.setVisible(true);
				cornSeedNum.setVisible(true);
				wheatSeedNum.setVisible(true);
				cabbageSeedNum.setVisible(true);
				if(wareHouse.getCornSeedNumber() == 0)
					cornButton.setEnabled(false);
				else cornButton.setEnabled(true);
				if(wareHouse.getWheatSeedNumber() == 0)
					wheatButton.setEnabled(false);
				else wheatButton.setEnabled(true);
				if(wareHouse.getCabbageSeedNumber() == 0)
					cabbageButton.setEnabled(false);
				else cabbageButton.setEnabled(true);
				
				
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
							seedBackGround.setVisible(false);
							cornSeedNum.setVisible(false);
							wheatSeedNum.setVisible(false);
							cabbageSeedNum.setVisible(false);
							if(wareHouse.getFertilizer() == 0)
								fertilizeButton.setEnabled(false);
							else
								fertilizeButton.setEnabled(true);
							checkButton().setIcon(littleCorn);
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
							seedBackGround.setVisible(false);
							cornSeedNum.setVisible(false);
							wheatSeedNum.setVisible(false);
							cabbageSeedNum.setVisible(false);
							if(wareHouse.getFertilizer() == 0)
								fertilizeButton.setEnabled(false);
							else
								fertilizeButton.setEnabled(true);
							checkButton().setIcon(littleWheat);
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
							seedBackGround.setVisible(false);
							cornSeedNum.setVisible(false);
							wheatSeedNum.setVisible(false);
							cabbageSeedNum.setVisible(false);
							if(wareHouse.getFertilizer() == 0)
								fertilizeButton.setEnabled(false);
							else
								fertilizeButton.setEnabled(true);
							checkButton().setIcon(littleCabbage);
							reload();
			        	}
			        	
			        }
			    });
			
			}
		});
		sowingButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				sowingButton.setIcon(resizeImage(sowingButton.getIcon().getIconWidth()+10,sowingButton.getIcon().getIconHeight()+10,(ImageIcon)sowingButton.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	sowingButton.setIcon(resizeImage (90,80,new ImageIcon("../picture/addCrop.png")));
            } 
		});
		cornButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				cornButton.setIcon(resizeImage(cornButton.getIcon().getIconWidth()+10,cornButton.getIcon().getIconHeight()+10,(ImageIcon)cornButton.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	cornButton.setIcon(resizeImage (90,80,new ImageIcon("../picture/corn.png")));
            } 
		});
		wheatButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				wheatButton.setIcon(resizeImage(wheatButton.getIcon().getIconWidth()+10,wheatButton.getIcon().getIconHeight()+10,(ImageIcon)wheatButton.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	wheatButton.setIcon(resizeImage (90,80,new ImageIcon("../picture/wheat.png")));
            } 
		});
		cabbageButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				cabbageButton.setIcon(resizeImage(cabbageButton.getIcon().getIconWidth()+10,cabbageButton.getIcon().getIconHeight()+10,(ImageIcon)cabbageButton.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	cabbageButton.setIcon(resizeImage (90,80,new ImageIcon("../picture/cabbage.png")));
            } 
		});
		
		//除蟲除草button
		pesticideButton.setBounds(1075, 442, 130, 92);
		pesticideButton.setVisible(false);
		this.add(pesticideButton);
		buttonOFF(pesticideButton);
		pesticideButton.setIcon(killBug);
		harvestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//farm.xxx;
			}
		});
		pesticideButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				pesticideButton.setIcon(resizeImage(pesticideButton.getIcon().getIconWidth()+10,pesticideButton.getIcon().getIconHeight()+10,(ImageIcon)pesticideButton.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	pesticideButton.setIcon(resizeImage (90,80,new ImageIcon("../picture/killBug.png")));
            } 
		});
		
		//HOME鍵返回
		returnButton.setFont(new Font("Dialog", Font.BOLD, 20));	
		buttonOFF(returnButton);
		returnButton.setIcon(new ImageIcon("..\\picture\\HOME.png"));
		returnButton.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		returnButton.setBounds(1060, 529, 145, 110);
		returnButton.addActionListener(this);
		returnButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				returnButton.setIcon(resizeImage(returnButton.getIcon().getIconWidth()+10,returnButton.getIcon().getIconHeight()+10,(ImageIcon)returnButton.getIcon()));
				buttonSound();
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	returnButton.setIcon(new ImageIcon("..\\picture\\HOME.png"));
            } 
			
		});
		this.add(returnButton);
		
		cornButton.setBounds(955, 357, 86, 87);
		cornButton.setVisible(false);
		this.add(cornButton);
		buttonOFF(cornButton);
		cornButton.setFont(new java.awt.Font("Dialog", 1, 20));
		cornButton.setIcon(cornSeed);
		
		cornSeedNum.setBounds(1026, 379, 131, 43);
		cornSeedNum.setVisible(false);
		this.add(cornSeedNum);
		cornSeedNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		
		wheatButton.setBounds(822, 357, 86, 87);
		wheatButton.setVisible(false);
		this.add(wheatButton);
		buttonOFF(wheatButton);
		wheatButton.setFont(new java.awt.Font("Dialog", 1, 20));
		wheatButton.setIcon(wheatSeed);
		
		wheatSeedNum.setBounds(894, 379, 131, 43);
		wheatSeedNum.setVisible(false);
		this.add(wheatSeedNum);
		wheatSeedNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		
		cabbageButton.setBounds(676, 357, 86, 87);
		cabbageButton.setVisible(false);
		this.add(cabbageButton);
		buttonOFF(cabbageButton);
		cabbageButton.setFont(new java.awt.Font("Dialog", 1, 20));
		cabbageButton.setIcon(cabbageSeed);
		
		cabbageSeedNum.setBounds(756, 379, 131, 43);
		cabbageSeedNum.setVisible(false);
		this.add(cabbageSeedNum);
		cabbageSeedNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 30));
		
		//種子工具列背景
		seedBackGround.setBounds(689, 365, 400, 69);
		seedBackGround.setVisible(false);
		this.add(seedBackGround);
		seedBackGround.setIcon(seedBackground);
		
		//成長值背景
		cropRate.setBounds(59, 525, 167, 43);
		cropRate.setVisible(false);
		this.add(cropRate);
		cropRate.setFont(new Font("微軟正黑體 Light", Font.BOLD, 25));
		rateBackGround.setBounds(15, 475, 224, 220);
		rateBackGround.setVisible(false);
		this.add(rateBackGround);
		rateBackGround.setIcon(rateBackground);
		
		//Land0
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
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
				reload();
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
				reload();
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
				reload();
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
				reload();
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
				reload();
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
				reload();
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
				reload();
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
				reload();
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
				reload();
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
				reload();
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
				reload();
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
			reload();
			this.mainFrame.changeToMainScreen();
		}
	}
}
