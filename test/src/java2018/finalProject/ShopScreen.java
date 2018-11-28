package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;

public class ShopScreen extends JFrame {

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

	
	

	/**
	 * Launch the application.
	 */
	public void countTotalMoney(JTable table,int price, int num)
	{
		
	    int totalColumn = table.getColumnCount()-1;
	    int totalRow =  table.getRowCount()-1;
		
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
		
		Panel panel = new Panel();
		panel.setBounds(76, 347, 482, 317);
		panel.setVisible(false);
		contentPane.add(panel);
		
		
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
		btnOk.setBounds(98, 152, 64, 40);
		btnOk.setHorizontalAlignment(SwingConstants.TRAILING);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		table = new JTable();
		table.setBounds(14, 11, 236, 112);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Chicken", 200, 0},
				{"Pig", 210, 0},
				{"Cow", 230, 0},
				{"Wheat", 10, 0},
				{"Corn",30, 0},
				{"Cabbage", 50, 0},
				{"Total", null, 0},
			},
			new String[] {
				"Item", "Price", "Number"
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
		
		
		JButton btnSell = new JButton("Sell");
		btnSell.setBounds(63, 0, 55, 27);
		contentPane.add(btnSell);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(0, 0, 55, 27);
		contentPane.add(btnBuy);
		
		JPanel buyPanel = new JPanel();
		buyPanel.setBounds(135, 24, 605, 317);
		contentPane.add(buyPanel);
		buyPanel.setLayout(null);
		buyPanel.setVisible(false);
		buyTable = new JTable();
		buyTable.setBounds(14, 13, 260, 176);
		buyTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"SimpleFeed",5, 0},
				{"GeneralFeed",8, 0},
				{"AdvancedFeed",15, 0},
				{"Chicken", 20,0},
				{"Pig",30,0},
				{"Cow", 50,0},
				{"WheatSeed",5,0},
				{"CornSeed", 10, 0},
				{"CabbageSeed", 15, 0},
				{"Fertilizer",20,0},
				{"Total", null,0},
			},
			new String[] {
				"Item", "Price", "Number"
			}
		));
		buyPanel.add(buyTable);
		
		JButton btnAddSimple = new JButton("addSimpleSeed");
		btnAddSimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,0, 2,1);
				
			}
		});
		btnAddSimple.setBounds(303, 14, 99, 27);
		buyPanel.add(btnAddSimple);
		
		JButton btnAddGeneral = new JButton("addGeneralSeed");
		btnAddGeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,1, 2,1);
				
			}
		});
		btnAddGeneral.setBounds(303, 43, 99, 27);
		buyPanel.add(btnAddGeneral);
		
		JButton btnAddAdvanced = new JButton("addAdvanced");
		btnAddAdvanced.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,2, 2,1);
				
			}
		});
		btnAddAdvanced.setBounds(303, 73, 123, 27);
		buyPanel.add(btnAddAdvanced);
		
		JButton btnAddYoungChicken = new JButton("addChicken");
		btnAddYoungChicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,3, 2,1);
				
			}
		});
		btnAddYoungChicken.setBounds(303, 99, 115, 27);
		buyPanel.add(btnAddYoungChicken);
		
		JButton btnAddYoungPig = new JButton("addPig");
		btnAddYoungPig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,4, 2,1);
				
			}
		});
		btnAddYoungPig.setBounds(303, 132, 115, 27);
		buyPanel.add(btnAddYoungPig);
		
		JButton btnAddYoungCow = new JButton("addCow");
		btnAddYoungCow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,5, 2,1);
				
			}
		});
		btnAddYoungCow.setBounds(303, 162, 99, 27);
		buyPanel.add(btnAddYoungCow);
		
		JButton btnAddwheatseed = new JButton("addWheatSeed");
		btnAddwheatseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,6, 2,1);
				
			}
		});
		btnAddwheatseed.setBounds(302, 190, 123, 27);
		buyPanel.add(btnAddwheatseed);
		
		JButton btnAddCornSeed = new JButton("addCornSeed");
		btnAddCornSeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,7, 2,1);
				
			}
		});
		btnAddCornSeed.setBounds(304, 215, 122, 27);
		buyPanel.add(btnAddCornSeed);
		
		JButton btnAddCabbageSeed = new JButton("addCabbageSeed");
		btnAddCabbageSeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,8, 2,1);
				
			}
		});
		btnAddCabbageSeed.setBounds(303, 242, 123, 27);
		buyPanel.add(btnAddCabbageSeed);
		
		JButton btnAddFertilizer = new JButton("addFertilizer");
		btnAddFertilizer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,9, 2,1);
				
			}
		});
		btnAddFertilizer.setBounds(303, 277, 115, 27);
		buyPanel.add(btnAddFertilizer);
		
		JButton btnBuyOk = new JButton("ok");
		btnBuyOk.setBounds(97, 215, 99, 27);
		buyPanel.add(btnBuyOk);
		
		JButton btnDelsimple = new JButton("delSimple");
		btnDelsimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,0, 2,-1);
				
			}
		});
		btnDelsimple.setBounds(446, 14, 99, 27);
		buyPanel.add(btnDelsimple);
		
		JButton btnDelgeneral = new JButton("delGeneral");
		btnDelgeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,1, 2,-1);
				
			}
		});
		btnDelgeneral.setBounds(446, 43, 99, 27);
		buyPanel.add(btnDelgeneral);
		
		JButton btnDeladvanced = new JButton("delAdvanced");
		btnDeladvanced.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,2, 2,-1);
				
			}
		});
		btnDeladvanced.setBounds(446, 73, 99, 27);
		buyPanel.add(btnDeladvanced);
		
		JButton btnDelYoungChicken = new JButton("delChicken");
		btnDelYoungChicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,3, 2,-1);
				
			}
		});
		btnDelYoungChicken.setBounds(446, 99, 99, 27);
		buyPanel.add(btnDelYoungChicken);
		
		JButton btnDelYoungPig = new JButton("delPig");
		btnDelYoungPig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,4, 2,-1);
				
			}
		});
		btnDelYoungPig.setBounds(446, 132, 99, 27);
		buyPanel.add(btnDelYoungPig);
		
		JButton btnDelYoungCow = new JButton("delCow");
		btnDelYoungCow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,5, 2,-1);
				
			}
		});
		btnDelYoungCow.setBounds(446, 162, 99, 27);
		buyPanel.add(btnDelYoungCow);
		
		JButton btnDelwheatseed = new JButton("delWheatSeed");
		btnDelwheatseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,6, 2,-1);
				
			}
		});
		btnDelwheatseed.setBounds(446, 190, 123, 27);
		buyPanel.add(btnDelwheatseed);
		
		JButton btnDelcornseed = new JButton("delCornSeed");
		btnDelcornseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,7, 2,-1);
				
			}
		});
		btnDelcornseed.setBounds(446, 215, 123, 27);
		buyPanel.add(btnDelcornseed);
		
		JButton btnDelcabbageseed = new JButton("delCabbageSeed");
		btnDelcabbageseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,8, 2,-1);
				
			}
		});
		btnDelcabbageseed.setBounds(446, 242, 123, 27);
		buyPanel.add(btnDelcabbageseed);
		
		JButton btnDelfertilizer = new JButton("delFertilizer");
		btnDelfertilizer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,9, 2,-1);
				
			}
		});
		btnDelfertilizer.setBounds(446, 277, 123, 27);
		buyPanel.add(btnDelfertilizer);
		
		JButton btnReturn = new JButton("return");
		btnReturn.setBounds(19, 45, 99, 27);
		contentPane.add(btnReturn);
		
		
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
				System.out.printf("Item %s num %d\n","chicken",shop.getChickenNumber());
				System.out.printf("Item %s num %d\n","pig",shop.getPigNumber());
				System.out.printf("Item %s num %d\n","cow",shop.getCowNumber());
				System.out.printf("Item %s num %d\n","wheat",shop.getWheatNumber());
				System.out.printf("Item %s num %d\n","corn",shop.getCornNumber());
				System.out.printf("Item %s num %d\n","cabbage",shop.getCabbageNumber());
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		
		
		
	}
}
