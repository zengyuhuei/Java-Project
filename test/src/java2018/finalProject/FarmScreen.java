package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

import java.util.Timer;
import java.util.TimerTask;

public class FarmScreen extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	//private ArrayList<Crop> crop = new ArrayList<Crop>(12);
	//private int[] storeCropArray = new int[12];
	private int count = 0;
	private int landNum = -1;
	WareHouse wareHouse = new WareHouse();
	Farm farm = new Farm(wareHouse);
	
	
	JButton btn = new JButton();   //測試用button 不會出現
	JButton waterButton = new JButton("澆水");
	JButton fertilizeButton = new JButton("施肥");
	JButton sowingButton = new JButton("播種");
	JButton harvestButton = new JButton("收割");
	JButton cornButton = new JButton("玉米");
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
		if(farm.getStoreCropNum(landNum) == -1)
		{
			//System.out.println("一無所有的土地ouq");
			fertilizeButton.setEnabled(false);
			harvestButton.setEnabled(false);
			sowingButton.setEnabled(true);
			waterButton.setEnabled(false);

			cornButton.setVisible(false);
			wheatButton.setVisible(false);
			cabbageButton.setVisible(false);
		}
		else if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate() >= 100)
		{
			//System.out.println("該宰了他了 =u=");
			fertilizeButton.setEnabled(false);
			harvestButton.setEnabled(true);
			sowingButton.setEnabled(false);
			waterButton.setEnabled(false);
			
			cornButton.setVisible(false);
			wheatButton.setVisible(false);
			cabbageButton.setVisible(false);
		}
		else
		{
			//System.out.println("這裡種"+farm.getFarmLand().get(farm.getStoreCropNum(landNum)).pickSeed());
			//System.out.println("GrowingRate = "+farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate());
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

			cornButton.setVisible(false);
			wheatButton.setVisible(false);
			cabbageButton.setVisible(false);
		}
	}
	
	public void LandButton()
	{
		fertilizeButton.setVisible(true);
		harvestButton.setVisible(true);
		sowingButton.setVisible(true);
		waterButton.setVisible(true);
		if(farm.getStoreCropNum(landNum) == -1)
		{
			System.out.println("一無所有的土地ouq");
			fertilizeButton.setEnabled(false);
			harvestButton.setEnabled(false);
			sowingButton.setEnabled(true);
			waterButton.setEnabled(false);

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

			cornButton.setVisible(false);
			wheatButton.setVisible(false);
			cabbageButton.setVisible(false);
		}
	}
	
	public FarmScreen(WareHouse wareHouse) {
		
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
		
		farm.setStoreCropNum();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		//澆水button
		waterButton.setBounds(589, 69, 111, 31);
		waterButton.setVisible(false);
		contentPane.add(waterButton);
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
				}
				reload();
			}
		});

		//施肥button
		fertilizeButton.setBounds(589, 120, 111, 31);
		fertilizeButton.setVisible(false);
		contentPane.add(fertilizeButton);
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
				}
				reload();
			}
		});
		

		//播種button
		sowingButton.setBounds(589, 171, 111, 31);
		sowingButton.setVisible(false);
		contentPane.add(sowingButton);
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
		        	}
		        	
		        }
		    });
			
		}
	});
				
	
		//收割button
		harvestButton.setBounds(589, 18, 111, 31);
		harvestButton.setVisible(false);
		contentPane.add(harvestButton);
		harvestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(farm.getFarmLand().get(farm.getStoreCropNum(landNum)).getGrowingRate() >= 100)
				{
					farm.harvest(landNum);
					
					fertilizeButton.setEnabled(false);
					harvestButton.setEnabled(false);
					sowingButton.setEnabled(true);
					waterButton.setEnabled(false);	
				}
			}
		});
		
		
		
		cornButton.setBounds(529, 171, 46, 31);
		cornButton.setVisible(false);
		contentPane.add(cornButton);
		
		
		wheatButton.setBounds(469, 171, 46, 31);
		wheatButton.setVisible(false);
		contentPane.add(wheatButton);
		
		
		cabbageButton.setBounds(409, 171, 46, 36);
		cabbageButton.setVisible(false);
		contentPane.add(cabbageButton);
		
		//Land0
		button_0.setAction(action);
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 0;
				LandButton();
			}
		});
		button_0.setBounds(15, 15, 111, 36);
		contentPane.add(button_0);
		
		//Land3
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 3;
				LandButton();
			}
		});
		button_3.setAction(action);
		button_3.setBounds(15, 66, 111, 36);
		contentPane.add(button_3);
		
		//Land6
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 6;
				LandButton();
			}
		});
		button_6.setAction(action);
		button_6.setBounds(15, 117, 111, 36);
		contentPane.add(button_6);
		
		//Land9
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 9;
				LandButton();
			}
		});
		button_9.setAction(action);
		button_9.setBounds(15, 168, 111, 36);
		contentPane.add(button_9);
		
		//Land1
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 1;
				LandButton();
			}
		});
		button_1.setAction(action);
		button_1.setBounds(141, 18, 111, 36);
		contentPane.add(button_1);
		
		//Land4
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 4;
				LandButton();
			}
		});
		button_4.setAction(action);
		button_4.setBounds(141, 69, 111, 36);
		contentPane.add(button_4);
		
		//Land7
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 7;
				LandButton();
			}
		});
		button_7.setAction(action);
		button_7.setBounds(141, 120, 111, 36);
		contentPane.add(button_7);
		
		//Land10
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 10;
				LandButton();
			}
		});
		button_10.setAction(action);
		button_10.setBounds(141, 171, 111, 36);
		contentPane.add(button_10);
		
		//Land2
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 2;
				LandButton();
			}
		});
		button_2.setAction(action);
		button_2.setBounds(267, 18, 111, 36);
		contentPane.add(button_2);
		
		//Land5
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 5;
				LandButton();
			}
		});
		button_5.setAction(action);
		button_5.setBounds(267, 69, 111, 36);
		contentPane.add(button_5);
		
		//Land8
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 8;
				LandButton();
			}
		});
		button_8.setAction(action);
		button_8.setBounds(267, 120, 111, 36);
		contentPane.add(button_8);
		
		//Land11
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				landNum = 11;
				LandButton();
			}
		});
		button_11.setAction(action);
		button_11.setBounds(267, 171, 111, 36);
		contentPane.add(button_11);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Land");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
