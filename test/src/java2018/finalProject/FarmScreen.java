package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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

	private final Action action = new SwingAction();
	private Main mainFrame;
	private JButton returnButton = new JButton("return");
	//private ArrayList<Crop> crop = new ArrayList<Crop>(12);
	//private int[] storeCropArray = new int[12];
	private int count = 0;
	private int landNum = -1;
	
	JButton btn = new JButton();   //測試用button 不會出現
	JButton waterButton = new JButton("澆水");
	JButton fertilizeButton = new JButton("施肥");
	JButton sowingButton = new JButton("播種");
	JButton harvestButton = new JButton("收割");
	JButton pesticideButton = new JButton("除蟲除草");
	JButton cornButton = new JButton("玉米");
	//ImageIcon iconCorn = new ImageIcon("C:\\Users\\user\\Desktop\\Java-Project\\picture\\cornImage.jpg");
	JButton wheatButton = new JButton("小麥");
	JButton cabbageButton = new JButton("高麗菜");
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
	
	
	public void reload()
	{
		fertilizeButton.setVisible(false);
		harvestButton.setVisible(false);
		sowingButton.setVisible(false);
		waterButton.setVisible(false);
		pesticideButton.setVisible(false);
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
		
		/*Crop corn1 = new Corn();
		Crop corn2 = new Corn();
		Crop corn3 = new Corn();
		Crop corn4 = new Corn();
		Crop corn5 = new Corn();
		Crop wheat1 = new Wheat();
		Crop wheat2 = new Wheat();
		Crop cabbage1 = new Cabbage();
		Crop cabbage2 = new Cabbage();
		Crop cabbage3 = new Cabbage();
		wareHouse.addSeed(corn1);
		wareHouse.addSeed(corn2);
		wareHouse.addSeed(corn3);
		wareHouse.addSeed(corn4);
		wareHouse.addSeed(corn5);
		wareHouse.addSeed(wheat1);
		wareHouse.addSeed(wheat2);
		wareHouse.addSeed(cabbage1);
		wareHouse.addSeed(cabbage2);
		wareHouse.addSeed(cabbage3);
		*/
		//wareHouse.editFertilizer(10);
		this.mainFrame = mainFrame;
		Farm farm = new Farm(wareHouse);
		farm.setStoreCropNum();
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setLayout(null);
		this.setSize(1200, 675);
		
		//收割button
		harvestButton.setBounds(589, 18, 111, 31);
		harvestButton.setVisible(false);
		this.add(harvestButton);
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
		waterButton.setBounds(589, 69, 111, 31);
		waterButton.setVisible(false);
		//waterButton.setIcon(iconCorn);
		this.add(waterButton);
		//waterButton.setSize(200,200);
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
		fertilizeButton.setBounds(589, 120, 111, 31);
		fertilizeButton.setVisible(false);
		this.add(fertilizeButton);
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
		sowingButton.setBounds(589, 171, 111, 31);
		sowingButton.setVisible(false);
		this.add(sowingButton);
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
		pesticideButton.setBounds(589, 220, 111, 31);
		pesticideButton.setVisible(false);
		this.add(pesticideButton);
		harvestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//farm.xxx;
			}
		});
		
		returnButton.setBounds(589, 269, 111, 31);
		this.add(returnButton);
		returnButton.addActionListener(this);
		
		cornButton.setBounds(529, 171, 70, 31);
		cornButton.setVisible(false);
		this.add(cornButton);
		
		
		wheatButton.setBounds(469, 171, 70, 31);
		wheatButton.setVisible(false);
		this.add(wheatButton);
		
		
		cabbageButton.setBounds(409, 171, 70, 31);
		cabbageButton.setVisible(false);
		this.add(cabbageButton);
		
		//Land0
		button_0.setAction(action);
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 0;
				LandButton(farm, wareHouse);
			}
		});
		button_0.setBounds(15, 15, 111, 36);
		this.add(button_0);
		
		//Land3
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 3;
				LandButton(farm, wareHouse);
			}
		});
		button_3.setAction(action);
		button_3.setBounds(15, 66, 111, 36);
		this.add(button_3);
		
		//Land6
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 6;
				LandButton(farm, wareHouse);
			}
		});
		button_6.setAction(action);
		button_6.setBounds(15, 117, 111, 36);
		this.add(button_6);
		
		//Land9
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 9;
				LandButton(farm, wareHouse);
			}
		});
		button_9.setAction(action);
		button_9.setBounds(15, 168, 111, 36);
		this.add(button_9);
		
		//Land1
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 1;
				LandButton(farm, wareHouse);
			}
		});
		button_1.setAction(action);
		button_1.setBounds(141, 18, 111, 36);
		this.add(button_1);
		
		//Land4
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 4;
				LandButton(farm, wareHouse);
			}
		});
		button_4.setAction(action);
		button_4.setBounds(141, 69, 111, 36);
		this.add(button_4);
		
		//Land7
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 7;
				LandButton(farm, wareHouse);
			}
		});
		button_7.setAction(action);
		button_7.setBounds(141, 120, 111, 36);
		this.add(button_7);
		
		//Land10
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 10;
				LandButton(farm, wareHouse);
			}
		});
		button_10.setAction(action);
		button_10.setBounds(141, 171, 111, 36);
		this.add(button_10);
		
		//Land2
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 2;
				LandButton(farm, wareHouse);
			}
		});
		button_2.setAction(action);
		button_2.setBounds(267, 18, 111, 36);
		this.add(button_2);
		
		//Land5
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 5;
				LandButton(farm, wareHouse);
			}
		});
		button_5.setAction(action);
		button_5.setBounds(267, 69, 111, 36);
		this.add(button_5);
		
		//Land8
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 8;
				LandButton(farm, wareHouse);
			}
		});
		button_8.setAction(action);
		button_8.setBounds(267, 120, 111, 36);
		this.add(button_8);
		
		//Land11
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 11;
				LandButton(farm, wareHouse);
			}
		});
		button_11.setAction(action);
		button_11.setBounds(267, 171, 111, 36);
		this.add(button_11);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Land");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == returnButton) {
			this.mainFrame.changeToMainScreen();
		}
	}
}
