package java2018.finalProject;



import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
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
	private JTable holdingItemTable;
	private JTable unMaturedItemTable;
	private JTable isMaturedItemTable;
	private JScrollPane unMaturedScrollPane;
	private JScrollPane isMaturedScrollPane;
	private JScrollPane holdingScrollPane;
	private WareHouse warehouse;
	private boolean isMatured = false;
	private boolean unMatured = false;
	private boolean holding = false;
	
    
	/**
	 * Launch the application.
	 */
	public ImageIcon resizeImage(int width, int height, ImageIcon img)
	{
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return  new ImageIcon(new_img);
		
	}
	
	
	public void setTableColumnWidth(JTable table,JScrollPane scrollPane)
	{
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMinWidth(scrollPane.getWidth()/2);
		table.getColumnModel().getColumn(0).setMaxWidth(scrollPane.getWidth()/2);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setMinWidth(scrollPane.getWidth()/2);
		table.getColumnModel().getColumn(1).setMaxWidth(scrollPane.getWidth()/2);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		
		table.setRowHeight((scrollPane.getHeight())/table.getRowCount());
		
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
	
	
	@SuppressWarnings("deprecation")
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
		ImageIcon chicken =resizeImage (75,75,new ImageIcon("../picture/chickenhead.png"));
		ImageIcon pig =resizeImage (75,75,new ImageIcon("../picture/pighead.png"));
		ImageIcon cow =resizeImage (75,75,new ImageIcon("../picture/cowhead.png"));
		ImageIcon wheat =resizeImage (75,75,new ImageIcon("../picture/pig.png"));
		ImageIcon corn =resizeImage (75,75,new ImageIcon("../picture/pig.png"));
		ImageIcon cabbage =resizeImage (75,75,new ImageIcon("../picture/pig.png"));
		ImageIcon fertilizer =resizeImage (75,75,new ImageIcon("../picture/pig.png"));
		ImageIcon simple =resizeImage (75,75,new ImageIcon("../picture/pig.png"));
		ImageIcon general =resizeImage (75,75,new ImageIcon("../picture/pig.png"));
		ImageIcon advanced =resizeImage (75,75,new ImageIcon("../picture/pig.png"));
		
		JButton btnisMaturedItem = new JButton("熟成品");
		btnisMaturedItem.setIcon(resizeImage(200,70,new ImageIcon("..\\picture\\btnIsMatured.png")));
		
		btnisMaturedItem.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		btnisMaturedItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isMatured == false)
				{
					updateMaturedItem();
					unMaturedScrollPane.setVisible(false);
					holdingScrollPane.setVisible(false);
					isMaturedScrollPane.setVisible(true);
					isMatured = true;
					unMatured = false;
					holding = false;
				}
				
				
			}
		});
		btnisMaturedItem.setBounds(123, 46, 176, 68);
		contentPane.add(btnisMaturedItem);
		
		JButton btnReadyToFeed = new JButton("待成長");
		btnReadyToFeed.setIcon(resizeImage(200,70,new ImageIcon("..\\picture\\btnUnMatured.png")));
	
		btnReadyToFeed.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		btnReadyToFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unMatured == false)
				{
					updateunMaturedItem();
					isMaturedScrollPane.setVisible(false);
					holdingScrollPane.setVisible(false);
					unMaturedScrollPane.setVisible(true);
					isMatured = false;
					unMatured = true;
					holding = false;
				}
			}
		});
		btnReadyToFeed.setBounds(123, 127, 176, 58);
		contentPane.add(btnReadyToFeed);
		
		JButton btnHoldItem = new JButton("持有物");
		btnHoldItem.setIcon(resizeImage(200,70,new ImageIcon("..\\picture\\btnHolding.png")));
		
	
		btnHoldItem.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		btnHoldItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(holding == false)
				{
					updateHoldItem();
					
					unMaturedScrollPane.setVisible(false);
					isMaturedScrollPane.setVisible(false);
					holdingScrollPane.setVisible(true);
					
					isMatured = false;
					holding = true;
					unMatured = false;
				}
				
			}
		});
		
		btnHoldItem.setBounds(123, 198, 176, 58);
		contentPane.add(btnHoldItem);
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
		
		
		
		holdingScrollPane = new JScrollPane();
		holdingScrollPane.setBounds(330, 46, 522, 556);
		holdingScrollPane.setBackground(new Color(204 ,135 ,125,50));
		holdingScrollPane.getVerticalScrollBar().setEnabled(false);
		holdingScrollPane.setEnabled(false);
		holdingScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		contentPane.add(holdingScrollPane);
		
		holdingItemTable = new JTable();
		holdingItemTable.setEnabled(false);
		holdingItemTable.getTableHeader().setEnabled(false);
		holdingItemTable.setBackground(new Color(204, 135, 125,50));
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
		setTableColumnWidth(holdingItemTable,holdingScrollPane);
		holdingScrollPane.setViewportView(holdingItemTable);
		
		
		unMaturedScrollPane = new JScrollPane();
		unMaturedScrollPane.setBounds(330, 46, 522, 556);
		unMaturedScrollPane.setBackground(new Color(189, 216 ,97,50));
		unMaturedScrollPane.setEnabled(false);
		unMaturedScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		contentPane.add(unMaturedScrollPane);
		
		unMaturedItemTable = new JTable();
		unMaturedItemTable.setEnabled(false);
		unMaturedItemTable.getTableHeader().setEnabled(false);
		unMaturedItemTable.setBackground(new Color(189, 216 ,97,50));
		unMaturedItemTable.setModel(new DefaultTableModel(organism,label){
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
		setTableColumnWidth(unMaturedItemTable,unMaturedScrollPane);
		unMaturedScrollPane.setViewportView(unMaturedItemTable);
		
		isMaturedScrollPane = new JScrollPane();
		isMaturedScrollPane.disable();
		
		isMaturedScrollPane.setBackground(new Color(181, 169, 154,50));
		isMaturedScrollPane.setBounds(330, 46, 522, 556);
		isMaturedScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		contentPane.add(isMaturedScrollPane);
		isMaturedItemTable = new JTable();
		isMaturedItemTable.setEnabled(false);
		isMaturedItemTable.getTableHeader().setEnabled(false);
		isMaturedItemTable.setBackground(new Color(181, 169, 154,50));
		isMaturedItemTable.setModel(new DefaultTableModel(organism,label){
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
		setTableColumnWidth(isMaturedItemTable,isMaturedScrollPane);
		isMaturedScrollPane.setViewportView(isMaturedItemTable);
		
		unMaturedScrollPane.setVisible(false);
		isMaturedScrollPane.setVisible(false);
		holdingScrollPane.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		
		
		ImageIcon img = new ImageIcon("../picture/warehouse.jpg");
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(new_img));
		lblNewLabel.setSize(1200, 675);
		contentPane.add(lblNewLabel);
	}
}
