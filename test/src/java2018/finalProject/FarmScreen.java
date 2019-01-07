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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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
	
	private Main mainFrame;
	private Farm farm;
	private JButton returnButton = new JButton("");
	private int landNum = -1;
	private Boolean [] clickCheck = new Boolean [12];
	private Boolean clickAddCrop = false;
	
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
	ImageIcon rateBackground = resizeImage (250,200,new ImageIcon("../picture/board.PNG"));
	ImageIcon toolBackground = resizeImage (130,500,new ImageIcon("../picture/toolBarBG.PNG"));
	JLabel rateBackGround = new JLabel(rateBackground);
	JLabel seedBackGround = new JLabel(seedBackground);
	JLabel toolBackGround = new JLabel(toolBackground);
	JLabel cornSeedNum = new JLabel();
	JLabel wheatSeedNum = new JLabel();
	JLabel cabbageSeedNum = new JLabel();
	JLabel cropRate = new JLabel();
	JLabel fertilizerNum = new JLabel();
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
		toolBackGround.setVisible(false);
		fertilizerNum.setVisible(false);
		cropRate.setVisible(false);
		for(int i = 0; i < 12; i++)
			clickCheck[i] = false;
		clickAddCrop = false;
		
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
    public void checkCropImage(int landNum, int growingRate)
    {
    	if(growingRate >= 100)
    	{
    		if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getName() == "玉米")
				checkButton(landNum).setIcon(bigCorn);
			else if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getName() == "小麥")
				checkButton(landNum).setIcon(bigWheat);
			else 
				checkButton(landNum).setIcon(bigCabbage);
    	}
    	else if(growingRate > 50)
    	{
    		if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getName() == "玉米")
				checkButton(landNum).setIcon(midCorn);
			else if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getName() == "小麥")
				checkButton(landNum).setIcon(midWheat);
			else 
				checkButton(landNum).setIcon(midCabbage);
    	}
    	else
    	{
    		if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getName() == "玉米")
				checkButton(landNum).setIcon(littleCorn);
			else if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getName() == "小麥")
				checkButton(landNum).setIcon(littleWheat);
			else 
				checkButton(landNum).setIcon(littleCabbage);
    	}
    }
    public JButton checkButton(int landNum)
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
		fertilizerNum.setText("X"+wareHouse.getFertilizer());
		fertilizerNum.setVisible(true);
		harvestButton.setVisible(true);
		sowingButton.setVisible(true);
		waterButton.setVisible(true);
		pesticideButton.setVisible(true);
		toolBackGround.setVisible(true);
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
			growingRate(farm);
			checkCropImage(landNum, 100);
		}
		else
		{
			System.out.println("這裡種"+farm.getFarmLand().get(farm.getStoreCropNum(landNum)).pickSeed());
			System.out.println("GrowingRate = "+farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
			if(wareHouse.getFertilizer() == 0)
				fertilizeButton.setEnabled(false);
			else
			{
				fertilizeButton.setEnabled(true);
				fertilizerNum.setText("X"+wareHouse.getFertilizer());
				fertilizerNum.setVisible(true);
			}

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
			growingRate(farm);
			checkCropImage(landNum, farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
		}
		if(farm.checkLand()) 
		{
			//System.out.println("!!!");
			if(farm.decideCallRandomCheck())
			{
				//System.out.println("???");
				pesticideButton.setEnabled(true);
				fertilizeButton.setEnabled(false);
				harvestButton.setEnabled(false);
				sowingButton.setEnabled(false);
				waterButton.setEnabled(false);
			}
		}
	}
	public void growingRate(Farm farm)
	{
		if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).pickSeed() == "玉米")
		{
			rateBackGround.setVisible(true);
			cropRate.setVisible(true);
			cropRate.setText("玉米's 成長值: "+ farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
		}
		else if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).pickSeed() == "小麥")
		{
			rateBackGround.setVisible(true);
			cropRate.setVisible(true);
			cropRate.setText("小麥's 成長值: "+ farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
		}
		else 
		{
			rateBackGround.setVisible(true);
			cropRate.setVisible(true);
			cropRate.setText("高麗菜's 成長值: "+ farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
		}
	}
	public String[][] getfarmObject() //存檔Farm中的所有資料 (存檔用)
	{
		int count = farm.getLandNum();
		String [][] farmStore = new String [13][4];
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss", Locale.ENGLISH);
		if(count >= 1)
			for(int i = 0; i < count; i++)
				for(int j = 0; j < 12; j++)
					if(farm.getStoreCropNum(j) == i)
					{
						farmStore[i][0] = farm.getFarmLand().get(i).getName(); //作物名稱
						farmStore[i][1] = Integer.toString(farm.getFarmLand().get(i).getGrowingRate()); //作物成長值
						farmStore[i][2] = sdFormat.format(farm.getFarmLand().get(i).getLastWaterDate()); //作物上次澆水時間
						farmStore[i][3] = Integer.toString(j);  //作物的位置
						break;
					}
		farmStore[12][0] = Integer.toString(count);
		farmStore[12][1] = sdFormat.format(farm.getLastKillBugDate());
		/*for(int i = 0; i < count; i++)
		{
			System.out.println("crop:"+farmStore[i][0]);
			System.out.println("growingRate:"+farmStore[i][1]);
			System.out.println("lastWater:"+farmStore[i][2]);
			System.out.println("station:"+farmStore[i][3]);
		}*/
		return farmStore;
	}
	public void setfarmObject(String [][] farmStore) throws ParseException //讀取Farm中的所有資料 (讀檔用)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
		int cropNum = 0;
		int count = Integer.parseInt(farmStore[12][0]);
		farm.setLastKillBugDate(sdf.parse(farmStore[12][1]));
		sdf.setLenient(false);
		farm.setStoreCropNum();
		while(cropNum < count)
		{
			for(int i = 0; i < count; i++)
			{
				int landNumber = Integer.parseInt(farmStore[i][3]);
				if(farmStore[i][0].equals(new String("玉米")))
				{
					farm.sowingCorn(landNumber);
					farm.getFarmLand().get(farm.getStoreCropNum(landNumber)).setGrowingRate(Integer.parseInt(farmStore[i][1]));
					farm.getFarmLand().get(farm.getStoreCropNum(landNumber)).setLastWaterDate(sdf.parse(farmStore[i][2]));
					checkCropImage(landNumber,Integer.parseInt(farmStore[i][1]));
					cropNum++;
				}
				else if(farmStore[i][0].equals(new String("小麥")))
				{
					farm.sowingWheat(landNumber);
					farm.getFarmLand().get(farm.getStoreCropNum(landNumber)).setGrowingRate(Integer.parseInt(farmStore[i][1]));
					farm.getFarmLand().get(farm.getStoreCropNum(landNumber)).setLastWaterDate(sdf.parse(farmStore[i][2]));
					checkCropImage(landNumber,Integer.parseInt(farmStore[i][1]));
					cropNum++;
				}
				else if(farmStore[i][0].equals(new String("高麗菜")))
				{
					farm.sowingCabbage(landNumber);
					farm.getFarmLand().get(farm.getStoreCropNum(landNumber)).setGrowingRate(Integer.parseInt(farmStore[i][1]));
					farm.getFarmLand().get(farm.getStoreCropNum(landNumber)).setLastWaterDate(sdf.parse(farmStore[i][2]));
					checkCropImage(landNumber,Integer.parseInt(farmStore[i][1]));
					cropNum++;
				}
			}
		}
	}
	public FarmScreen(Main mainFrame, WareHouse wareHouse) {
		
		this.mainFrame = mainFrame;
		farm = new Farm(wareHouse);
		farm.setStoreCropNum();
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setSize(1200, 675);
		
		for(int i = 0; i < 12; i++)
			clickCheck[i] = false;
		
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
					checkButton(landNum).setIcon(nothingLand);
					//reload();
				}
				cropRate.setVisible(false);
				rateBackGround.setVisible(false);
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
		//farm.getFarmLand().get(farm.getStoreCropNum(landNum)).waterCheck(false); //澆水按鈕未被使用
		waterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farm.getOneHOurToNowDate();
				farm.getFarmLand().get(farm.getStoreCropNum(landNum)).waterCheck(true); //澆水按鈕已經被使用
				farm.getFarmLand().get(farm.getStoreCropNum(landNum)).water();
				System.out.println("澆水後GrowingRate = "+farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
				checkCropImage(landNum, farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
				if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate() >= 100)
				{
					fertilizeButton.setEnabled(false);
					harvestButton.setEnabled(true);
					sowingButton.setEnabled(false);
					waterButton.setEnabled(false);
					pesticideButton.setEnabled(false);
				}
				waterButton.setEnabled(false);
				farm.getFarmLand().get(farm.getStoreCropNum(landNum)).waterCheck(false); //澆水按鈕未被使用
				growingRate(farm);
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

		//肥料數量
		fertilizerNum.setBounds(1156, 317, 103, 43);
		fertilizerNum.setVisible(false);
		this.add(fertilizerNum);
		fertilizerNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		
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
		{
			fertilizeButton.setEnabled(true);
			fertilizerNum.setText("X"+wareHouse.getFertilizer());
			fertilizerNum.setVisible(true);
		}
		fertilizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farm.getFarmLand().get(farm.getStoreCropNum(landNum)).fertilize();
				System.out.println("施肥後GrowingRate = "+farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
				checkCropImage(landNum, farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
				wareHouse.editFertilizer(-1);
				
				if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate() >= 100)
				{
					fertilizeButton.setEnabled(false);
					harvestButton.setEnabled(true);
					sowingButton.setEnabled(false);
					waterButton.setEnabled(false);
					pesticideButton.setEnabled(false);
				}

				else if(wareHouse.getFertilizer() > 0) 
				{
					fertilizeButton.setEnabled(true);
					fertilizerNum.setText("X"+wareHouse.getFertilizer());
					fertilizerNum.setVisible(true);
				}
				else fertilizeButton.setEnabled(false);
				growingRate(farm);
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
				if(clickAddCrop)
				{
					cornButton.setVisible(false);
					wheatButton.setVisible(false);
					cabbageButton.setVisible(false);
					seedBackGround.setVisible(false);
					cornSeedNum.setVisible(false);
					wheatSeedNum.setVisible(false);
					cabbageSeedNum.setVisible(false);
					clickAddCrop = false;
				}
				else
				{
					clickAddCrop = true;
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
								{
									fertilizeButton.setEnabled(true);
									fertilizerNum.setText("X"+wareHouse.getFertilizer());
									fertilizerNum.setVisible(true);
								}
								checkButton(landNum).setIcon(littleCorn);
	
								growingRate(farm);
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
								{
									fertilizeButton.setEnabled(true);
									fertilizerNum.setText("X"+wareHouse.getFertilizer());
									fertilizerNum.setVisible(true);
								}
									
								checkButton(landNum).setIcon(littleWheat);
								growingRate(farm);
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
								{
									fertilizeButton.setEnabled(true);
									fertilizerNum.setText("X"+wareHouse.getFertilizer());
									fertilizerNum.setVisible(true);
								}
								checkButton(landNum).setIcon(littleCabbage);
								growingRate(farm);
				        	}
				        	
				        }
				    });
				
				}
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
		//toGame
		pesticideButton.setBounds(1075, 442, 130, 92);
		pesticideButton.setVisible(true);
		pesticideButton.addActionListener(this);
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
		
		//工具列背景
		toolBackGround.setBounds(1075, 72, 130, 477);
		toolBackGround.setVisible(false);
		this.add(toolBackGround);
		toolBackGround.setIcon(toolBackground);
		
		//成長值背景
		cropRate.setBounds(26, 520, 260, 43);
		cropRate.setVisible(false);
		this.add(cropRate);
		cropRate.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		rateBackGround.setBounds(-32, 442, 307, 292);
		rateBackGround.setVisible(false);
		this.add(rateBackGround);
		rateBackGround.setIcon(rateBackground);
		
		//Land0
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[0])
				{
					reload();
					clickCheck[0] = false;
				}
				else
				{
					reload();
					landNum = 0;
					LandButton(farm, wareHouse);
					clickCheck[0] = true;
				}
			}
		});
		button_0.setBounds(59, 172, 193, 102);
		this.add(button_0);
		buttonOFF(button_0);
		
		//Land3
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[3])
				{
					reload();
					clickCheck[3] = false;
				}
				else
				{
					reload();
					landNum = 3;
					LandButton(farm, wareHouse);
					clickCheck[3] = true;
				}
	            /*String [][] farmStore = getfarmObject();
				try {
					setfarmObject(farmStore);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		button_3.setBounds(203, 305, 193, 98);
		this.add(button_3);
		buttonOFF(button_3);
		
		//Land6
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[6])
				{
					reload();
					clickCheck[6] = false;
				}
				else
				{
					reload();
					landNum = 6;
					LandButton(farm, wareHouse);
					clickCheck[6] = true;
				}
			}
		});
		button_6.setBounds(350, 428, 193, 87);
		this.add(button_6);
		buttonOFF(button_6);
		
		//Land9
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[9])
				{
					reload();
					clickCheck[9] = false;
				}
				else
				{
					reload();
					landNum = 9;
					LandButton(farm, wareHouse);
					clickCheck[9] = true;
				}
			}
		});
		button_9.setBounds(480, 537, 185, 92);
		this.add(button_9);
		buttonOFF(button_9);
		
		//Land1
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[1])
				{
					reload();
					clickCheck[1] = false;
				}
				else
				{
					reload();
					landNum = 1;
					LandButton(farm, wareHouse);
					clickCheck[1] = true;
				}
			}
		});
		button_1.setBounds(293, 94, 185, 98);
		this.add(button_1);
		buttonOFF(button_1);
		
		//Land4
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[4])
				{
					reload();
					clickCheck[4] = false;
				}
				else
				{
					reload();
					landNum = 4;
					LandButton(farm, wareHouse);
					clickCheck[4] = true;
				}
			}
		});
		button_4.setBounds(447, 223, 176, 98);
		this.add(button_4);
		buttonOFF(button_4);
		
		//Land7
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[7])
				{
					reload();
					clickCheck[7] = false;
				}
				else
				{
					reload();
					landNum = 7;
					LandButton(farm, wareHouse);
					clickCheck[7] = true;
				}
			}
		});
		button_7.setBounds(577, 346, 167, 86);
		this.add(button_7);
		buttonOFF(button_7);
		
		//Land10
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[10])
				{
					reload();
					clickCheck[10] = false;
				}
				else
				{
					reload();
					landNum = 10;
					LandButton(farm, wareHouse);
					clickCheck[10] = true;
				}
			}
		});
		button_10.setBounds(711, 447, 176, 102);
		this.add(button_10);
		buttonOFF(button_10);
		
		//Land2
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[2])
				{
					reload();
					clickCheck[2] = false;
				}
				else
				{
					reload();
					landNum = 2;
					LandButton(farm, wareHouse);
					clickCheck[2] = true;
				}
			}
		});
		button_2.setBounds(535, 37, 176, 87);
		this.add(button_2);
		buttonOFF(button_2);
		
		//Land5
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[5])
				{
					reload();
					clickCheck[5] = false;
				}
				else
				{
					reload();
					landNum = 5;
					LandButton(farm, wareHouse);
					clickCheck[5] = true;
				}
			}
		});
		button_5.setBounds(669, 159, 167, 87);
		this.add(button_5);
		buttonOFF(button_5);
		
		//Land8
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[8])
				{
					reload();
					clickCheck[8] = false;
				}
				else
				{
					reload();
					landNum = 8;
					LandButton(farm, wareHouse);
					clickCheck[8] = true;
				}
			}
		});
		button_8.setBounds(801, 272, 167, 92);
		this.add(button_8);
		buttonOFF(button_8);
		
		//Land11
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickCheck[11])
				{
					reload();
					clickCheck[11] = false;
				}
				else
				{
					reload();
					landNum = 11;
					LandButton(farm, wareHouse);
					clickCheck[11] = true;
				}
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
		else if (e.getSource() == pesticideButton) {
			this.mainFrame.changeToFarmGameScreen();
		}
	}
}
