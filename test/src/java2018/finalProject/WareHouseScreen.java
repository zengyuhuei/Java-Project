package java2018.finalProject;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Image;

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
		this.setSize(1200, 675);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//resize the image
		ImageIcon img = new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png");
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		img = new ImageIcon(new_img);
		
		JButton btnisMaturedItem = new JButton("熟成品");
		btnisMaturedItem.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		btnisMaturedItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMaturedItem();
				unMaturedItemTable.setVisible(false);
				holdingItemTable.setVisible(false);
				isMaturedItemTable.setVisible(true);
				
			}
		});
		btnisMaturedItem.setBounds(188, 26, 101, 50);
		contentPane.add(btnisMaturedItem);
		
		JButton btnReadyToFeed = new JButton("待成長");
		btnReadyToFeed.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		btnReadyToFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateunMaturedItem();
				isMaturedItemTable.setVisible(false);
				holdingItemTable.setVisible(false);
				unMaturedItemTable.setVisible(true);
			}
		});
		btnReadyToFeed.setBounds(302, 26, 106, 50);
		contentPane.add(btnReadyToFeed);
		
		JButton btnHoldItem = new JButton("持有物");
		btnHoldItem.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		btnHoldItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateHoldItem();
				unMaturedItemTable.setVisible(false);
				isMaturedItemTable.setVisible(false);
				holdingItemTable.setVisible(true);
				
			}
		});
		btnHoldItem.setBounds(431, 26, 101, 50);
		contentPane.add(btnHoldItem);
		
		JPanel panel = new JPanel();
		panel.setBounds(101, 85, 667, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		isMaturedItemTable = new JTable();
		isMaturedItemTable.setFont(new Font("新細明體", Font.PLAIN, 21));
		isMaturedItemTable.setRowHeight(75);
		//isMaturedItemTable.setPreferredSize((int)75);
		isMaturedItemTable.setBounds(26, 34, 525, 450);
		Object[][] data = {
			{img , 0},
			{img, 0},
			{img, 0},
			{img, 0},
			{img, 0},
			{img, 0},
		};
	    String[] label = {"物品", "數量"};
		isMaturedItemTable.setModel(new DefaultTableModel(data,label) {
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		});
			
		isMaturedItemTable.getColumnModel().getColumn(0).setResizable(false);
		isMaturedItemTable.getColumnModel().getColumn(0).setMinWidth(75);
		isMaturedItemTable.getColumnModel().getColumn(0).setMaxWidth(75);

		isMaturedItemTable.getColumnModel().getColumn(1).setResizable(false);
		isMaturedItemTable.getColumnModel().getColumn(1).setMinWidth(75);
		isMaturedItemTable.getColumnModel().getColumn(1).setMaxWidth(75);
		isMaturedItemTable.setPreferredScrollableViewportSize(isMaturedItemTable.getPreferredSize());

        
        panel.add( isMaturedItemTable );
	
		
			
		
		
		unMaturedItemTable = new JTable();
		unMaturedItemTable.setFont(new Font("新細明體", Font.PLAIN, 21));
		unMaturedItemTable.setRowHeight(30);
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
		unMaturedItemTable.setBounds(26, 34, 335, 180);
		panel.add(unMaturedItemTable);
		
		holdingItemTable = new JTable();
		holdingItemTable.setFont(new Font("新細明體", Font.PLAIN, 21));
		holdingItemTable.setRowHeight(30);
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
		holdingItemTable.setBounds(26, 34, 331, 120);
		panel.add(holdingItemTable);
		
		unMaturedItemTable.setVisible(false);
		holdingItemTable.setVisible(false);
		isMaturedItemTable.setVisible(false);
	}
	
	
}
