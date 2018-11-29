package java2018.finalProject;

import java.awt.BorderLayout;



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
import javax.swing.SwingConstants;


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
	
	public boolean isLegal(JTable table)
	{
		int totalColumn = table.getColumnCount()-2;
	    int totalRow =  table.getRowCount()-1;
	    if((int)table.getValueAt(totalRow,totalColumn) <= shop.getHoldMoney())
	    	return true;
	    return false;
	}
	
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopScreen frame = new ShopScreen(ware);
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    */
	/**
	 * Create the frame.
	 */
	public ShopScreen(WareHouse warehouse) {
		
		shop = new Shop(warehouse);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 757);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
		
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnSell = new JButton("Sell");
		btnSell.setBounds(63, 0, 55, 27);
		contentPane.add(btnSell);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(0, 0, 55, 27);
		contentPane.add(btnBuy);
		
		JPanel buyPanel = new JPanel();
		buyPanel.setBounds(29, 86, 714, 334);
		contentPane.add(buyPanel);
		buyPanel.setLayout(null);
		buyPanel.setVisible(false);
		buyTable = new JTable();
		buyTable.setBounds(14, 13, 374, 176);
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
		btnAddSimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,0, 2,1);
				
			}
		});
		btnAddSimple.setBounds(418, 31, 99, 27);
		buyPanel.add(btnAddSimple);
		
		JButton btnAddGeneral = new JButton("addGeneralSeed");
		btnAddGeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,1, 2,1);
				
			}
		});
		btnAddGeneral.setBounds(418, 60, 99, 27);
		buyPanel.add(btnAddGeneral);
		
		JButton btnAddAdvanced = new JButton("addAdvanced");
		btnAddAdvanced.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,2, 2,1);
				
			}
		});
		btnAddAdvanced.setBounds(418, 90, 123, 27);
		buyPanel.add(btnAddAdvanced);
		
		JButton btnAddYoungChicken = new JButton("addChicken");
		btnAddYoungChicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,3, 2,1);
				
			}
		});
		btnAddYoungChicken.setBounds(418, 116, 115, 27);
		buyPanel.add(btnAddYoungChicken);
		
		JButton btnAddYoungPig = new JButton("addPig");
		btnAddYoungPig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,4, 2,1);
				
			}
		});
		btnAddYoungPig.setBounds(418, 149, 115, 27);
		buyPanel.add(btnAddYoungPig);
		
		JButton btnAddYoungCow = new JButton("addCow");
		btnAddYoungCow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,5, 2,1);
				
			}
		});
		btnAddYoungCow.setBounds(418, 179, 99, 27);
		buyPanel.add(btnAddYoungCow);
		
		JButton btnAddwheatseed = new JButton("addWheatSeed");
		btnAddwheatseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,6, 2,1);
				
			}
		});
		btnAddwheatseed.setBounds(417, 207, 123, 27);
		buyPanel.add(btnAddwheatseed);
		
		JButton btnAddCornSeed = new JButton("addCornSeed");
		btnAddCornSeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,7, 2,1);
				
			}
		});
		btnAddCornSeed.setBounds(419, 232, 122, 27);
		buyPanel.add(btnAddCornSeed);
		
		JButton btnAddCabbageSeed = new JButton("addCabbageSeed");
		btnAddCabbageSeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,8, 2,1);
				
			}
		});
		btnAddCabbageSeed.setBounds(418, 259, 123, 27);
		buyPanel.add(btnAddCabbageSeed);
		
		JButton btnAddFertilizer = new JButton("addFertilizer");
		btnAddFertilizer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,9, 2,1);
				
			}
		});
		btnAddFertilizer.setBounds(418, 294, 115, 27);
		buyPanel.add(btnAddFertilizer);
		
		JButton btnBuyOk = new JButton("ok");
		btnBuyOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isLegal(buyTable))//金錢足夠
				{
					int input = JOptionPane.showOptionDialog(null, "你確定要購買?", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if(input == 0) //ok
					{
						addItem();
					}
					else  //取消
					{
						//清空東西
					}
					
				}
				else
				{
					
					String message = String.format("現有金錢為:%d元，金額不足",shop.getHoldMoney() );
					JOptionPane.showMessageDialog(null,message);
				}
				
			}
		});
		btnBuyOk.setBounds(97, 215, 99, 27);
		buyPanel.add(btnBuyOk);
		
		JButton btnDelsimple = new JButton("delSimple");
		btnDelsimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,0, 2,-1);
				
			}
		});
		btnDelsimple.setBounds(561, 31, 99, 27);
		buyPanel.add(btnDelsimple);
		
		JButton btnDelgeneral = new JButton("delGeneral");
		btnDelgeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,1, 2,-1);
				
			}
		});
		btnDelgeneral.setBounds(561, 60, 99, 27);
		buyPanel.add(btnDelgeneral);
		
		JButton btnDeladvanced = new JButton("delAdvanced");
		btnDeladvanced.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,2, 2,-1);
				
			}
		});
		btnDeladvanced.setBounds(561, 90, 99, 27);
		buyPanel.add(btnDeladvanced);
		
		JButton btnDelYoungChicken = new JButton("delChicken");
		btnDelYoungChicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,3, 2,-1);
				
			}
		});
		btnDelYoungChicken.setBounds(561, 116, 99, 27);
		buyPanel.add(btnDelYoungChicken);
		
		JButton btnDelYoungPig = new JButton("delPig");
		btnDelYoungPig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,4, 2,-1);
				
			}
		});
		btnDelYoungPig.setBounds(561, 149, 99, 27);
		buyPanel.add(btnDelYoungPig);
		
		JButton btnDelYoungCow = new JButton("delCow");
		btnDelYoungCow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,5, 2,-1);
				
			}
		});
		btnDelYoungCow.setBounds(561, 179, 99, 27);
		buyPanel.add(btnDelYoungCow);
		
		JButton btnDelwheatseed = new JButton("delWheatSeed");
		btnDelwheatseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,6, 2,-1);
				
			}
		});
		btnDelwheatseed.setBounds(561, 207, 123, 27);
		buyPanel.add(btnDelwheatseed);
		
		JButton btnDelcornseed = new JButton("delCornSeed");
		btnDelcornseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,7, 2,-1);
				
			}
		});
		btnDelcornseed.setBounds(561, 232, 123, 27);
		buyPanel.add(btnDelcornseed);
		
		JButton btnDelcabbageseed = new JButton("delCabbageSeed");
		btnDelcabbageseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,8, 2,-1);
				
			}
		});
		btnDelcabbageseed.setBounds(561, 259, 123, 27);
		buyPanel.add(btnDelcabbageseed);
		
		JButton btnDelfertilizer = new JButton("delFertilizer");
		btnDelfertilizer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,9, 2,-1);
				
			}
		});
		btnDelfertilizer.setBounds(561, 294, 123, 27);
		buyPanel.add(btnDelfertilizer);
		
		JButton btnReturn = new JButton("return");
		btnReturn.setBounds(19, 45, 99, 27);
		contentPane.add(btnReturn);
		
		Panel panel = new Panel();
		panel.setBounds(10, 453, 482, 204);
		contentPane.add(panel);
		panel.setVisible(false);
		
		
		btnAddchicken = new JButton("addChicken");
		btnAddchicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(0, 2) < shop.getChickenNumber())
					editNumber(table,0, 2,1);
			}
		});
		btnAddchicken.setBounds(256, 5, 99, 27);
		
		btnAddpig = new JButton("addPig");
		btnAddpig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(1, 2) < shop.getPigNumber())
					editNumber(table,1, 2,1);
			}
		});
		btnAddpig.setBounds(256, 38, 99, 27);
		
		btnAddcow = new JButton("addCow");
		btnAddcow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(2, 2) < shop.getCowNumber())
					editNumber(table,2, 2,1);
			}
		});
		btnAddcow.setBounds(256, 68, 99, 27);
		
		
		btnAddwheat = new JButton("addWheat");
		
		btnAddwheat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(3, 2) < shop.getWheatNumber())
					editNumber(table,3, 2,1);
			
			}
		});
		btnAddwheat.setBounds(256, 96, 99, 27);
		
		
		btnAddcorn = new JButton("addCorn");
		btnAddcorn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(4, 2) < shop.getCornNumber())
					editNumber(table,4, 2,1);
			}
		});
		btnAddcorn.setBounds(256, 125, 99, 27);
		
		
		
		btnAddcabbage = new JButton("addCabbage");
		btnAddcabbage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(5, 2) < shop.getCabbageNumber())
					editNumber(table,5, 2,1);
				
			}
		});
		btnAddcabbage.setBounds(256, 159, 101, 27);
		
		btnOk = new JButton("ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int input = JOptionPane.showOptionDialog(null, "你確定要賣出?", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(input == 0) //ok
				{
					delItem();
				}
				else  //取消
				{
					//清空東西
				}
					
				
				
			}
		});
		btnOk.setBounds(98, 152, 64, 40);
		btnOk.setHorizontalAlignment(SwingConstants.TRAILING);
		
		
		
		table = new JTable();
		table.setBounds(14, 11, 236, 112);
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
		btnDelchicken.setBounds(369, 5, 99, 27);
		panel.add(btnDelchicken);
		
		JButton btnDelpig = new JButton("delPig");
		btnDelpig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,1, 2,-1);
				
			}
		});
		btnDelpig.setBounds(369, 38, 99, 27);
		panel.add(btnDelpig);
		
		JButton btnDelcow = new JButton("delCow");
		btnDelcow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,2, 2,-1);
				
			}
		});
		btnDelcow.setBounds(369, 68, 99, 27);
		panel.add(btnDelcow);
		
		JButton btnDelwheat = new JButton("delWheat");
		btnDelwheat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,3, 2,-1);
				
			}
		});
		btnDelwheat.setBounds(369, 96, 99, 27);
		panel.add(btnDelwheat);
		
		JButton btnDelcorn = new JButton("delCorn");
		btnDelcorn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,4, 2,-1);
				
			}
		});
		btnDelcorn.setBounds(369, 125, 99, 27);
		panel.add(btnDelcorn);
		
		JButton btnDelcabbage = new JButton("delCabbage");
		btnDelcabbage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(table,5, 2,-1);
				
			}
		});
		btnDelcabbage.setBounds(371, 159, 99, 27);
		panel.add(btnDelcabbage);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				buyPanel.setVisible(true);
				System.out.println(shop.getHoldMoney());

			}
		});
		
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				buyPanel.setVisible(false);
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
