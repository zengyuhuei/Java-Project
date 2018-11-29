package java2018.finalProject;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WareHouseScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable isMaturedItemTable;
	private JTable unMaturedItemTable;
	private JTable holdingItemTable;
	private WareHouse warehouse;

	/**
	 * Launch the application.
	 */
	
	
	public void updateMaturedItem()
	{
		isMaturedItemTable.setValueAt(warehouse.getChickenNumber(), 0, 1);
		isMaturedItemTable.setValueAt(warehouse.getPigNumber(), 1, 1);
		isMaturedItemTable.setValueAt(warehouse.getCowNumber(), 2, 1);
		isMaturedItemTable.setValueAt(warehouse.getWheatNumber(), 3, 1);
		isMaturedItemTable.setValueAt(warehouse.getCornNumber(), 4, 1);
		isMaturedItemTable.setValueAt(warehouse.getCabbageNumber(), 5, 1);
	}
	public void updateunMaturedItem()
	{
		unMaturedItemTable.setValueAt(warehouse.getYoungChickenNumber(), 0, 1);
		unMaturedItemTable.setValueAt(warehouse.getYoungPigNumber(), 1, 1);
		unMaturedItemTable.setValueAt(warehouse.getYoungCowNumber(), 2, 1);
		unMaturedItemTable.setValueAt(warehouse.getWheatSeedNumber(), 3, 1);
		unMaturedItemTable.setValueAt(warehouse.getCornSeedNumber(), 4, 1);
		unMaturedItemTable.setValueAt(warehouse.getCabbageSeedNumber(), 5, 1);
	}
	public void updateHoldItem()
	{
		holdingItemTable.setValueAt(warehouse.getSimpleFeedNumber(), 0, 1);
		holdingItemTable.setValueAt(warehouse.getGeneralFeedNumber(), 1, 1);
		holdingItemTable.setValueAt(warehouse.getAdvencedFeedNumber(), 2, 1);
		holdingItemTable.setValueAt(warehouse.getFertilizer(), 3, 1);
	}
	public WareHouseScreen(WareHouse warehouse) {
		this.warehouse = warehouse;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 668);
		contentPane = new JPanel();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen.width * 7 / 8, screen.height * 7 / 8);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnisMaturedItem = new JButton("熟成品");
		btnisMaturedItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMaturedItem();
			}
		});
		btnisMaturedItem.setBounds(14, 13, 120, 68);
		contentPane.add(btnisMaturedItem);
		
		JButton btnReadyToFeed = new JButton("待成長");
		btnReadyToFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateunMaturedItem();
			}
		});
		btnReadyToFeed.setBounds(158, 13, 120, 68);
		contentPane.add(btnReadyToFeed);
		
		JButton btnHoldItem = new JButton("持有物");
		btnHoldItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateHoldItem();
			}
		});
		btnHoldItem.setBounds(304, 13, 120, 68);
		contentPane.add(btnHoldItem);
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 126, 507, 308);
		contentPane.add(panel);
		panel.setLayout(null);
		
		isMaturedItemTable = new JTable();
		isMaturedItemTable.setBounds(38, 24, 207, 96);
		isMaturedItemTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"雞", 0},
				{"豬", 0},
				{"牛", 0},
				{"小麥", 0},
				{"玉米", 0},
				{"高麗菜", 0},
			},
			new String[] {
				"物品", "數量"
			}
		));
			
			
		panel.add(isMaturedItemTable);
		
		unMaturedItemTable = new JTable();
		unMaturedItemTable.setModel(new DefaultTableModel(
				new Object[][] {
					{"雞", 0},
					{"豬", 0},
					{"牛", 0},
					{"小麥", 0},
					{"玉米", 0},
					{"高麗菜", 0},
				},
				new String[] {
					"物品", "數量"
				}
			));
		unMaturedItemTable.setBounds(281, 24, 212, 96);
		panel.add(unMaturedItemTable);
		
		holdingItemTable = new JTable();
		holdingItemTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"低級飼料", 0},
				{"中級飼料",0},
				{"高級飼料",0},
				{"肥料", 0},
			},
			new String[] {
				"物品", "數量"
			}
		) );
		holdingItemTable.setBounds(100, 182, 250, 64);
		panel.add(holdingItemTable);
	}
	
	
}
