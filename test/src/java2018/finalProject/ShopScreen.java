package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;


public class ShopScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnOk;

	private JButton btnAddchicken;
	private JButton btnAddpig;
	private JButton btnAddcow;
	private JButton btnAddwheat;
	private JButton btnAddcorn;
	private JButton btnAddcabbage;
	private JTable buyTable;
	private Shop shop;
    private JLabel lblHoldmoney;

	public void delItem()
	{ 
		shop.removeAnimal("雞", (int)table.getValueAt(0,2));
		shop.removeAnimal("豬", (int)table.getValueAt(1,2));
		shop.removeAnimal("牛", (int)table.getValueAt(2,2));
		shop.removeCrop("小麥",  (int)table.getValueAt(3,2));
		shop.removeCrop("玉米",  (int)table.getValueAt(4,2));
		shop.removeCrop("高麗菜",  (int)table.getValueAt(5,2));
		shop.editHoldingMoney((int)table.getValueAt(6,2));

	}


	
	public void addItem()
	{ 
		shop.addFeed(shop.newSimpleFeed(), (int)buyTable.getValueAt(0,2));
		shop.addFeed(shop.newGeneralFeed(), (int)buyTable.getValueAt(1,2));
		shop.addFeed(shop.newAdvancedFeed(), (int)buyTable.getValueAt(2,2));
		shop.addYoungAnimal(shop.newChicken(), (int)buyTable.getValueAt(3,2));
		shop.addYoungAnimal(shop.newPig(), (int)buyTable.getValueAt(4,2));
		shop.addYoungAnimal(shop.newCow(), (int)buyTable.getValueAt(5,2));
		shop.addSeed(shop.newWheat(), (int)buyTable.getValueAt(6,2));
		shop.addSeed(shop.newCorn(), (int)buyTable.getValueAt(7,2));
		shop.addSeed(shop.newCabbage(), (int)buyTable.getValueAt(8,2));
		shop.addFertilizer((int)buyTable.getValueAt(9,2));
		shop.editHoldingMoney(-(int)buyTable.getValueAt(10,2));
		
	}
	/*  
	 * */
	
	public void countTotalMoney(JTable table,int price, int num)
	{
	    int totalColumn = table.getColumnCount()-2;
	    int totalRow =  table.getRowCount()-1;
	    System.out.println(totalColumn);
	    System.out.println(totalRow);
		table.setValueAt((int) table.getValueAt(totalRow,totalColumn)+price*num, totalRow, totalColumn);
			
		System.out.printf("總價格%d\n",table.getValueAt(totalRow,totalColumn));
		
	}
	
	public void editNumber(JTable table, int row, int column, int change)
	{
		
		int num = (int) table.getValueAt(row, column);
		if((num == 0 && change > 0) || num > 0)
		{
			num+=change;
			table.setValueAt(num, row, column);
	        System.out.printf("物品名稱 %s 數量%d\n",table.getValueAt(row, 0),table.getValueAt(row, column));
	        countTotalMoney(table,(int)table.getValueAt(row,1), change);
		}
		
	}
	
	public void cleanTable(JTable table)
	{
		int i;
		int totalRow =  table.getRowCount();
	    for (i = 0; i < totalRow; i++)
	    {
	    	table.setValueAt(0, i, 2);
	    }
	}
	
	public boolean isLegal(JTable table)
	{
		int totalColumn = table.getColumnCount()-2;
	    int totalRow =  table.getRowCount()-1;
	    if((int)table.getValueAt(totalRow,totalColumn) <= shop.getHoldMoney())
	    	return true;
	    return false;
	}
	
	

	public ShopScreen(WareHouse warehouse) {
		
		shop = new Shop(warehouse);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1094, 962);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnSell = new JButton("Sell");
		btnSell.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnSell.setBounds(170, 0, 118, 35);
		contentPane.add(btnSell);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnBuy.setBounds(0, 0, 127, 35);
		contentPane.add(btnBuy);
		
		JPanel buyPanel = new JPanel();
		buyPanel.setBounds(10, 49, 1036, 488);
		contentPane.add(buyPanel);
		buyPanel.setLayout(null);
		buyPanel.setVisible(false);
		buyTable = new JTable();
		buyTable.setRowHeight(30);
		buyTable.setFont(new Font("新細明體", Font.PLAIN, 17));
		buyTable.setBounds(14, 13, 489, 330);
		buyTable.setModel(new DefaultTableModel(
				
			new Object[][] {
				{"低級飼料", 5, 0, "動物成長率增加5%"},
				{"中級飼料", 8, 0, "動物成長率增加10%"},
				{"高級飼料",15, 0, "動物成長率增加20%"},
				{"雞", 20, 0, "小雞"},
				{"豬", 30, 0,"小豬"},
				{"牛", 50, 0, "小牛"},
				{"小麥",5, 0, "小麥種子"},
				{"玉米",10, 0, "玉米種子"},
				{"高麗菜", 15, 0, "高麗菜種子"},
				{"肥料", 20, 0, "植物成長率增加10%"},
				{"Total", null, 0, null},
			},
			new String[] {
					"物品", "價格", "數量", "備註"
				}
			
		));
		buyTable.getColumnModel().getColumn(0).setPreferredWidth(108);
		buyTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		buyTable.getColumnModel().getColumn(2).setPreferredWidth(50);
		buyTable.getColumnModel().getColumn(3).setPreferredWidth(175);
		buyTable.setVisible(true);
		buyPanel.add(buyTable,BorderLayout.CENTER);
		
		JButton btnAddSimple = new JButton("addSimpleSeed");
		btnAddSimple.setFont(new Font("新細明體", Font.PLAIN, 17));
		
		btnAddSimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,0, 2,1);
				
			}
		});
		btnAddSimple.setBounds(554, 11, 169, 32);
		buyPanel.add(btnAddSimple);
		
		JButton btnAddGeneral = new JButton("addGeneralSeed");
		btnAddGeneral.setFont(new Font("新細明體", Font.PLAIN, 17));
		
		btnAddGeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,1, 2,1);
				
			}
		});
		btnAddGeneral.setBounds(554, 56, 169, 31);
		buyPanel.add(btnAddGeneral);
		
		JButton btnAddAdvanced = new JButton("addAdvanced");
		btnAddAdvanced.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnAddAdvanced.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,2, 2,1);
				
			}
		});
		btnAddAdvanced.setBounds(554, 100, 169, 40);
		buyPanel.add(btnAddAdvanced);
		
		JButton btnAddYoungChicken = new JButton("addChicken");
		btnAddYoungChicken.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnAddYoungChicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,3, 2,1);
				
			}
		});
		btnAddYoungChicken.setBounds(554, 153, 169, 32);
		buyPanel.add(btnAddYoungChicken);
		
		JButton btnAddYoungPig = new JButton("addPig");
		btnAddYoungPig.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnAddYoungPig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,4, 2,1);
				
			}
		});
		btnAddYoungPig.setBounds(547, 198, 176, 31);
		buyPanel.add(btnAddYoungPig);
		
		JButton btnAddYoungCow = new JButton("addCow");
		btnAddYoungCow.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnAddYoungCow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,5, 2,1);
				
			}
		});
		btnAddYoungCow.setBounds(554, 242, 178, 31);
		buyPanel.add(btnAddYoungCow);
		
		JButton btnAddwheatseed = new JButton("addWheatSeed");
		btnAddwheatseed.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnAddwheatseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,6, 2,1);
				
			}
		});
		btnAddwheatseed.setBounds(547, 292, 176, 40);
		buyPanel.add(btnAddwheatseed);
		
		JButton btnAddCornSeed = new JButton("addCornSeed");
		btnAddCornSeed.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnAddCornSeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,7, 2,1);
				
			}
		});
		btnAddCornSeed.setBounds(554, 345, 176, 31);
		buyPanel.add(btnAddCornSeed);
		
		JButton btnAddCabbageSeed = new JButton("addCabbageSeed");
		btnAddCabbageSeed.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnAddCabbageSeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,8, 2,1);
				
			}
		});
		btnAddCabbageSeed.setBounds(546, 389, 177, 40);
		buyPanel.add(btnAddCabbageSeed);
		
		JButton btnAddFertilizer = new JButton("addFertilizer");
		btnAddFertilizer.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnAddFertilizer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,9, 2,1);
				
			}
		});
		btnAddFertilizer.setBounds(547, 442, 176, 31);
		buyPanel.add(btnAddFertilizer);
		
		JButton btnBuyOk = new JButton("ok");
		btnBuyOk.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnBuyOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(isLegal(buyTable))//金錢足夠
				{
					int input = JOptionPane.showOptionDialog(null, "你確定要購買?", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if(input == 0) //ok
					{
						addItem();
						lblHoldmoney.setText("擁有金額: "+String.valueOf(shop.getHoldMoney()));
						
					}
					
				}
				else
				{
					
					String message = String.format("現有金錢為:%d元，金額不足",shop.getHoldMoney() );
					JOptionPane.showMessageDialog(null,message);
				}
				cleanTable(buyTable);
				
			}
		});
		btnBuyOk.setBounds(241, 386, 130, 45);
		buyPanel.add(btnBuyOk);
		
		JButton btnDelsimple = new JButton("delSimple");
		btnDelsimple.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnDelsimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,0, 2,-1);
				
			}
		});
		btnDelsimple.setBounds(806, 15, 130, 28);
		buyPanel.add(btnDelsimple);
		
		JButton btnDelgeneral = new JButton("delGeneral");
		btnDelgeneral.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnDelgeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,1, 2,-1);
				
			}
		});
		btnDelgeneral.setBounds(806, 57, 160, 28);
		buyPanel.add(btnDelgeneral);
		
		JButton btnDeladvanced = new JButton("delAdvanced");
		btnDeladvanced.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnDeladvanced.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,2, 2,-1);
				
			}
		});
		btnDeladvanced.setBounds(816, 104, 148, 32);
		buyPanel.add(btnDeladvanced);
		
		JButton btnDelYoungChicken = new JButton("delChicken");
		btnDelYoungChicken.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnDelYoungChicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,3, 2,-1);
				
			}
		});
		btnDelYoungChicken.setBounds(806, 150, 169, 39);
		buyPanel.add(btnDelYoungChicken);
		
		JButton btnDelYoungPig = new JButton("delPig");
		btnDelYoungPig.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnDelYoungPig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,4, 2,-1);
				
			}
		});
		btnDelYoungPig.setBounds(806, 197, 160, 32);
		buyPanel.add(btnDelYoungPig);
		
		JButton btnDelYoungCow = new JButton("delCow");
		btnDelYoungCow.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnDelYoungCow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,5, 2,-1);
				
			}
		});
		btnDelYoungCow.setBounds(806, 250, 169, 35);
		buyPanel.add(btnDelYoungCow);
		
		JButton btnDelwheatseed = new JButton("delWheatSeed");
		btnDelwheatseed.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnDelwheatseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,6, 2,-1);
				
			}
		});
		btnDelwheatseed.setBounds(806, 293, 160, 39);
		buyPanel.add(btnDelwheatseed);
		
		JButton btnDelcornseed = new JButton("delCornSeed");
		btnDelcornseed.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnDelcornseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,7, 2,-1);
				
			}
		});
		btnDelcornseed.setBounds(806, 344, 162, 32);
		buyPanel.add(btnDelcornseed);
		
		JButton btnDelcabbageseed = new JButton("delCabbageSeed");
		btnDelcabbageseed.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnDelcabbageseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,8, 2,-1);
				
			}
		});
		btnDelcabbageseed.setBounds(806, 390, 169, 38);
		buyPanel.add(btnDelcabbageseed);
		
		JButton btnDelfertilizer = new JButton("delFertilizer");
		btnDelfertilizer.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnDelfertilizer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,9, 2,-1);
				
			}
		});
		btnDelfertilizer.setBounds(761, 443, 169, 28);
		buyPanel.add(btnDelfertilizer);
		
		JButton btnReturn = new JButton("return");
		
		btnReturn.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnReturn.setBounds(332, 0, 135, 35);
		contentPane.add(btnReturn);
		
		String holdMoney = String.format("擁有金額:%d", shop.getHoldMoney() );
		lblHoldmoney = new JLabel(holdMoney);
		lblHoldmoney.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblHoldmoney.setBounds(571, 4, 176, 50);
		contentPane.add(lblHoldmoney);
		
		Panel panel = new Panel();
		panel.setBounds(0, 554, 1009, 268);
		contentPane.add(panel);
		panel.setVisible(false);
		
		
		btnAddchicken = new JButton("addChicken");
		btnAddchicken.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnAddchicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(0, 2) < shop.getChickenNumber())
					editNumber(table,0, 2,1);
			}
		});
		btnAddchicken.setBounds(561, 13, 127, 40);
		
		btnAddpig = new JButton("addPig");
		btnAddpig.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnAddpig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddpig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(1, 2) < shop.getPigNumber())
					editNumber(table,1, 2,1);
			}
		});
		btnAddpig.setBounds(561, 52, 127, 35);
		
		btnAddcow = new JButton("addCow");
		btnAddcow.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnAddcow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(2, 2) < shop.getCowNumber())
					editNumber(table,2, 2,1);
			}
		});
		btnAddcow.setBounds(561, 86, 127, 40);
		
		
		btnAddwheat = new JButton("addWheat");
		btnAddwheat.setFont(new Font("新細明體", Font.PLAIN, 21));
		
		btnAddwheat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(3, 2) < shop.getWheatNumber())
					editNumber(table,3, 2,1);
			
			}
		});
		btnAddwheat.setBounds(561, 130, 127, 40);
		
		
		btnAddcorn = new JButton("addCorn");
		btnAddcorn.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnAddcorn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(4, 2) < shop.getCornNumber())
					editNumber(table,4, 2,1);
			}
		});
		btnAddcorn.setBounds(561, 171, 135, 40);
		
		
		
		btnAddcabbage = new JButton("addCabbage");
		btnAddcabbage.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnAddcabbage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(5, 2) < shop.getCabbageNumber())
					editNumber(table,5, 2,1);
				
			}
		});
		btnAddcabbage.setBounds(561, 209, 135, 46);
		
		btnOk = new JButton("ok");
		btnOk.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int input = JOptionPane.showOptionDialog(null, "你確定要賣出?", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(input == 0) //ok
				{
					delItem();
					lblHoldmoney.setText("擁有金額: "+String.valueOf(shop.getHoldMoney()));
				}
				cleanTable(table);
				
				
					
				
				
			}
		});
		btnOk.setBounds(481, 201, 64, 40);
		btnOk.setHorizontalAlignment(SwingConstants.TRAILING);
		
		
		
		table = new JTable();
		table.setFont(new Font("新細明體", Font.PLAIN, 21));
		table.setRowHeight(30);
		table.setBounds(14, 11, 418, 210);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"雞", 200, 0,null},
				{"豬", 210, 0,null},
				{"牛", 230, 0,null},
				{"小麥", 10, 0,null},
				{"玉米",30, 0,null},
				{"高麗菜", 50, 0,null},
				{"總價錢", null, 0,null},
			},
			new String[] {
				"物品", "價格", "數量","備註"
			}
		));
		
		
		
		panel.setLayout(null);
		panel.add(btnAddchicken);
		panel.add(btnAddpig);
		panel.add(btnAddcow);
		panel.add(btnAddcorn);
		panel.add(btnOk);
		panel.add(btnAddcabbage);
		panel.add(table);
		panel.add(btnAddwheat);
		
		JButton btnDelchicken = new JButton("delChicken");
		btnDelchicken.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnDelchicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,0, 2,-1);
				
			}
		});
		btnDelchicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDelchicken.setBounds(727, 13, 135, 40);
		panel.add(btnDelchicken);
		
		JButton btnDelpig = new JButton("delPig");
		btnDelpig.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnDelpig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,1, 2,-1);
				
			}
		});
		btnDelpig.setBounds(727, 56, 112, 31);
		panel.add(btnDelpig);
		
		JButton btnDelcow = new JButton("delCow");
		btnDelcow.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnDelcow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,2, 2,-1);
				
			}
		});
		btnDelcow.setBounds(727, 93, 112, 33);
		panel.add(btnDelcow);
		
		JButton btnDelwheat = new JButton("delWheat");
		btnDelwheat.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnDelwheat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,3, 2,-1);
				
			}
		});
		btnDelwheat.setBounds(727, 130, 112, 35);
		panel.add(btnDelwheat);
		
		JButton btnDelcorn = new JButton("delCorn");
		btnDelcorn.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnDelcorn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,4, 2,-1);
				
			}
		});
		btnDelcorn.setBounds(727, 165, 112, 39);
		panel.add(btnDelcorn);
		
		JButton btnDelcabbage = new JButton("delCabbage");
		btnDelcabbage.setFont(new Font("新細明體", Font.PLAIN, 21));
		btnDelcabbage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,5, 2,-1);
				
			}
		});
		btnDelcabbage.setBounds(727, 209, 150, 32);
		panel.add(btnDelcabbage);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				buyPanel.setVisible(true);
				cleanTable(table);
				System.out.println(shop.getHoldMoney());

			}
		});
		
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				buyPanel.setVisible(false);
				cleanTable(buyTable);
				System.out.printf("Item %s num %d\n","雞",shop.getChickenNumber());
				System.out.printf("Item %s num %d\n","豬",shop.getPigNumber());
				System.out.printf("Item %s num %d\n","牛",shop.getCowNumber());
				System.out.printf("Item %s num %d\n","小麥",shop.getWheatNumber());
				System.out.printf("Item %s num %d\n","玉米",shop.getCornNumber());
				System.out.printf("Item %s num %d\n","高麗菜",shop.getCabbageNumber());
			}
		});
		
		
		
		
	}
}
