package java2018.finalProject;



import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

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
	private JPanel panel;
	private JLabel label_1;
    
	/**
	 * Launch the application.
	 */
	public ImageIcon resizeImage(ImageIcon img)
	{
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		return  new ImageIcon(new_img);
		
	}
	public void setTableColumnWidth(JTable table)
	{
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMinWidth(table.getWidth()/2);
		table.getColumnModel().getColumn(0).setMaxWidth(table.getWidth()/2);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setMinWidth(table.getWidth()/2);
		table.getColumnModel().getColumn(1).setMaxWidth(table.getWidth()/2);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		
		table.setRowHeight(table.getHeight()/table.getRowCount());
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

      
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		
	}
	
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
		ImageIcon chicken =resizeImage (new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png"));
		ImageIcon pig =resizeImage (new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png"));
		ImageIcon cow =resizeImage (new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png"));
		ImageIcon wheat =resizeImage (new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png"));
		ImageIcon corn =resizeImage (new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png"));
		ImageIcon cabbage =resizeImage (new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png"));
		ImageIcon fertilizer =resizeImage (new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png"));
		ImageIcon simple =resizeImage (new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png"));
		ImageIcon general =resizeImage (new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png"));
		ImageIcon advanced =resizeImage (new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/pig.png"));
		
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
		btnisMaturedItem.setBounds(363, 0, 159, 74);
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
		btnReadyToFeed.setBounds(521, 0, 159, 74);
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
		btnHoldItem.setBounds(680, 0, 159, 74);
		contentPane.add(btnHoldItem);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(363, 74, 476, 554);
		contentPane.add(panel);
		panel.setLayout(null);
		
		isMaturedItemTable = new JTable();
		isMaturedItemTable.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		isMaturedItemTable.setForeground(new Color(0, 0, 0));
		isMaturedItemTable.setBackground(SystemColor.info);
		isMaturedItemTable.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		

		isMaturedItemTable.setBounds(0, 66, 476, 488);
		Object[][] organism = {
				
			{chicken , 0},
			{pig, 0},
			{cow, 0},
			{wheat, 0},
			{corn, 0},
			{cabbage, 0},
		};
		
		Object[][] holding = {
				{simple , 0},
				{general, 0},
				{advanced, 0},
				{fertilizer, 0},
				
			};
	    String[] label = {"物品", "數量"};
		isMaturedItemTable.setModel(new DefaultTableModel(organism,label) {
			private static final long serialVersionUID = 1L;

			public Class<? extends Object> getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		});
			
		setTableColumnWidth(isMaturedItemTable);
        panel.add(isMaturedItemTable);
		
			
				
			
			
			unMaturedItemTable = new JTable();
			unMaturedItemTable.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
			unMaturedItemTable.setBounds(0, 66, 476, 488);
			panel.add(unMaturedItemTable);
			unMaturedItemTable.setBackground(SystemColor.info);
			unMaturedItemTable.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
			
			unMaturedItemTable.setModel(new DefaultTableModel(organism, label){
				private static final long serialVersionUID = 1L;

				public Class<? extends Object> getColumnClass(int column)
	            {
	                return getValueAt(0, column).getClass();
	            }
				@Override
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			});
			setTableColumnWidth(unMaturedItemTable);
			
			unMaturedItemTable.setVisible(false);
		
		
		
		
		holdingItemTable = new JTable();
		holdingItemTable.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		holdingItemTable.setBackground(SystemColor.info);
		holdingItemTable.setBounds(0, 66, 476, 488);
		holdingItemTable.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));

		holdingItemTable.setModel(new DefaultTableModel(holding,label){
			private static final long serialVersionUID = 1L;

			public Class<? extends Object> getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		});
		setTableColumnWidth(holdingItemTable);
		panel.add(holdingItemTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-2, 567, 478, -565);
		panel.add(scrollPane);
		
		label_1 = new JLabel("物品");
		label_1.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 21));
		label_1.setBounds(97, 0, 56, 64);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("數量");
		label_2.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 21));
		label_2.setBounds(333, 13, 76, 40);
		panel.add(label_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		ImageIcon img = new ImageIcon("C:/Users/asus/Desktop/java/Java-Project/picture/warehouse.png");
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(  new ImageIcon(new_img));
		lblNewLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(lblNewLabel);

		isMaturedItemTable.setVisible(false);
		holdingItemTable.setVisible(false);
		unMaturedItemTable.setVisible(false);
	}
}
