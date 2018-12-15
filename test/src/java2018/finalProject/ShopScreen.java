package java2018.finalProject;


import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.JOptionPane;



import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;


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
    private JLabel background;
    
    public void setTableColumnWidth(JTable table)
	{
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 1	; i < table.getColumnCount();i++)
        	table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        
        table.setEnabled(false);
        
	}
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
    public void cleanButtom(JButton button)
    {
    	button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setBorder(null);
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
	
	public ImageIcon resizeImage(int width, int height, ImageIcon img)
	{
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return  new ImageIcon(new_img);
		
	}
	

	public ShopScreen(WareHouse warehouse) {
		
		shop = new Shop(warehouse);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon img = new ImageIcon("../picture/shop.png");
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		
		//resize the image
		ImageIcon chicken =resizeImage (50,50,new ImageIcon("../picture/chicken.png"));
		ImageIcon pig =resizeImage (50,50,new ImageIcon("../picture/pig2.png"));
		ImageIcon cow =resizeImage (50,50,new ImageIcon("../picture/cow.png"));
		ImageIcon wheat =resizeImage (50,50,new ImageIcon("../picture/wheat.png"));
		ImageIcon corn =resizeImage (50,50,new ImageIcon("../picture/corn.png"));
		ImageIcon cabbage =resizeImage (50,50,new ImageIcon("../picture/cabbage.png"));
		ImageIcon fertilizer =resizeImage (50,50,new ImageIcon("../picture/fertilizer.png"));
		ImageIcon simple =resizeImage (50,50,new ImageIcon("../picture/pig2.png"));
		ImageIcon general =resizeImage (50,50,new ImageIcon("../picture/pig2.png"));
		ImageIcon advanced =resizeImage (50,50,new ImageIcon("../picture/pig2.png"));
		ImageIcon total =resizeImage (50,50,new ImageIcon("../picture/total.png"));
				
		JButton btnSell = new JButton();
		btnSell.setIcon(new ImageIcon("..\\picture\\sellScreen.png"));
		cleanButtom(btnSell);
		btnSell.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 21));
		btnSell.setBounds(78, 158, 132, 74);
		contentPane.add(btnSell);
		
		JButton btnBuy = new JButton();
		btnBuy.setIcon(new ImageIcon("..\\picture\\buyScreen.png"));
		cleanButtom(btnBuy);
		btnBuy.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnBuy.setBounds(78, 87, 132, 58);
		contentPane.add(btnBuy);
		Object[][] organism = {
				{chicken, 200, 0,"長大的雞"},
				{pig, 210, 0,"長大的豬"},
				{cow, 230, 0,"長大的牛"},
				{wheat, 10, 0,"成熟的小麥"},
				{corn,30, 0,"成熟的玉米"},
				{cabbage, 50, 0,"成熟的高麗菜"},
				{total, null, 0,null},
			};
		String[] label = {"物品", "價格", "數量","備註"};
		
		JPanel buyPanel = new JPanel();
		buyPanel.setBounds(253, 0, 915, 628);
		buyPanel.setOpaque(false);
		contentPane.add(buyPanel);
		buyPanel.setLayout(null);
		buyPanel.setVisible(false);
		
		JButton btnAddSimple = new JButton();
		cleanButtom(btnAddSimple);
		btnAddSimple.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddSimple.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		
		btnAddSimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,0, 2,1);
				
			}
		});
		btnAddSimple.setBounds(634, 13, 35, 31);
		buyPanel.add(btnAddSimple);
		
		JButton btnAddGeneral = new JButton();
		cleanButtom(btnAddGeneral);
		btnAddGeneral.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddGeneral.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		
		btnAddGeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,1, 2,1);
				
			}
		});
		btnAddGeneral.setBounds(634, 72, 35, 31);
		buyPanel.add(btnAddGeneral);
		
		JButton btnAddAdvanced = new JButton("");
		cleanButtom(btnAddAdvanced);
		btnAddAdvanced.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddAdvanced.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddAdvanced.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,2, 2,1);
				
			}
		});
		btnAddAdvanced.setBounds(634, 122, 35, 31);
		buyPanel.add(btnAddAdvanced);
		
		JButton btnAddYoungChicken = new JButton();
		cleanButtom(btnAddYoungChicken);
		btnAddYoungChicken.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddYoungChicken.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddYoungChicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,3, 2,1);
				
			}
		});
		btnAddYoungChicken.setBounds(634, 184, 40, 32);
		buyPanel.add(btnAddYoungChicken);
		
		JButton btnAddYoungPig = new JButton();
		cleanButtom(btnAddYoungPig);
		btnAddYoungPig.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddYoungPig.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddYoungPig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,4, 2,1);
				
			}
		});
		btnAddYoungPig.setBounds(634, 240, 40, 31);
		buyPanel.add(btnAddYoungPig);
		
		JButton btnAddYoungCow = new JButton();
		cleanButtom(btnAddYoungCow);
		btnAddYoungCow.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddYoungCow.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddYoungCow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,5, 2,1);
				
			}
		});
		btnAddYoungCow.setBounds(634, 297, 35, 31);
		buyPanel.add(btnAddYoungCow);
		
		JButton btnAddwheatseed = new JButton();
		cleanButtom(btnAddwheatseed);
		btnAddwheatseed.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddwheatseed.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddwheatseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,6, 2,1);
				
			}
		});
		btnAddwheatseed.setBounds(634, 356, 35, 31);
		buyPanel.add(btnAddwheatseed);
		
		JButton btnAddCornSeed = new JButton();
		cleanButtom(btnAddCornSeed);
		btnAddCornSeed.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddCornSeed.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddCornSeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,7, 2,1);
				
			}
		});
		btnAddCornSeed.setBounds(634, 409, 40, 31);
		buyPanel.add(btnAddCornSeed);
		
		JButton btnAddCabbageSeed = new JButton();
		cleanButtom(btnAddCabbageSeed);
		btnAddCabbageSeed.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddCabbageSeed.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddCabbageSeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,8, 2,1);
				
			}
		});
		btnAddCabbageSeed.setBounds(634, 463, 40, 31);
		buyPanel.add(btnAddCabbageSeed);
		
		JButton btnAddFertilizer = new JButton();
		cleanButtom(btnAddFertilizer);
		btnAddFertilizer.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddFertilizer.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddFertilizer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,9, 2,1);
				
			}
		});
		btnAddFertilizer.setBounds(634, 516, 35, 31);
		buyPanel.add(btnAddFertilizer);
		
		JButton btnDelSimple = new JButton();
		cleanButtom(btnDelSimple);
		btnDelSimple.setIcon(new ImageIcon("..\\picture\\del.png"));
		btnDelSimple.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnDelSimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,0, 2,-1);
				
			}
		});
		btnDelSimple.setBounds(681, 13, 35, 31);
		buyPanel.add(btnDelSimple);
		
		JButton btnDelgeneral = new JButton();
		cleanButtom(btnDelgeneral);
		btnDelgeneral.setIcon(new ImageIcon("..\\picture\\del.png"));
		btnDelgeneral.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnDelgeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,1, 2,-1);
				
			}
		});
		btnDelgeneral.setBounds(683, 72, 40, 28);
		buyPanel.add(btnDelgeneral);
		
		JButton btnDeladvanced = new JButton();
		cleanButtom(btnDeladvanced);
		btnDeladvanced.setIcon(new ImageIcon("..\\picture\\del.png"));
		btnDeladvanced.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnDeladvanced.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,2, 2,-1);
				
			}
		});
		btnDeladvanced.setBounds(683, 121, 40, 32);
		buyPanel.add(btnDeladvanced);
		
		JButton btnDelYoungChicken = new JButton();
		cleanButtom(btnDelYoungChicken);
		btnDelYoungChicken.setIcon(new ImageIcon("..\\picture\\del.png"));
		btnDelYoungChicken.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnDelYoungChicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,3, 2,-1);
				
			}
		});
		btnDelYoungChicken.setBounds(688, 185, 35, 31);
		buyPanel.add(btnDelYoungChicken);
		
		JButton btnDelYoungPig = new JButton();
		cleanButtom(btnDelYoungPig);
		btnDelYoungPig.setIcon(new ImageIcon("..\\picture\\del.png"));
		btnDelYoungPig.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnDelYoungPig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,4, 2,-1);
				
			}
		});
		btnDelYoungPig.setBounds(688, 239, 35, 32);
		buyPanel.add(btnDelYoungPig);
		
		JButton btnDelYoungCow = new JButton();
		cleanButtom(btnDelYoungCow);
		btnDelYoungCow.setIcon(new ImageIcon("..\\picture\\del.png"));
		btnDelYoungCow.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnDelYoungCow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,5, 2,-1);
				
			}
		});
		btnDelYoungCow.setBounds(683, 297, 35, 35);
		buyPanel.add(btnDelYoungCow);
		
		JButton btnDelwheatseed = new JButton();
		cleanButtom(btnDelwheatseed);
		btnDelwheatseed.setIcon(new ImageIcon("..\\picture\\del.png"));
		btnDelwheatseed.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnDelwheatseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,6, 2,-1);
				
			}
		});
		btnDelwheatseed.setBounds(683, 356, 29, 31);
		buyPanel.add(btnDelwheatseed);
		
		JButton btnDelcornseed = new JButton();
		cleanButtom(btnDelcornseed);
		btnDelcornseed.setIcon(new ImageIcon("..\\picture\\del.png"));
		btnDelcornseed.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnDelcornseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,7, 2,-1);
				
			}
		});
		btnDelcornseed.setBounds(688, 409, 35, 32);
		buyPanel.add(btnDelcornseed);
		
		JButton btnDelcabbageseed = new JButton();
		cleanButtom(btnDelcabbageseed);
		btnDelcabbageseed.setIcon(new ImageIcon("..\\picture\\del.png"));
		btnDelcabbageseed.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnDelcabbageseed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,8, 2,-1);
				
			}
		});
		btnDelcabbageseed.setBounds(688, 465, 35, 29);
		buyPanel.add(btnDelcabbageseed);
		
		JButton btnDelfertilizer = new JButton();
		cleanButtom(btnDelfertilizer);
		btnDelfertilizer.setIcon(new ImageIcon("..\\picture\\del.png"));
		btnDelfertilizer.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnDelfertilizer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,9, 2,-1);
				
			}
		});
		
		JButton btnBuyOk = new JButton("ok");
		btnBuyOk.setBounds(695, 550, 197, 65);
		buyPanel.add(btnBuyOk);
		btnBuyOk.setIcon(new ImageIcon("..\\picture\\okbuy.png"));
		cleanButtom(btnBuyOk);
		btnBuyOk.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 21));
		btnBuyOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(isLegal(buyTable))//金錢足夠
				{
					int input = JOptionPane.showOptionDialog(null, "你確定要購買?", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if(input == 0) //ok
					{
						addItem();
						lblHoldmoney.setText(" : "+String.valueOf(shop.getHoldMoney()));
						
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
		
			buyTable = new JTable();
			buyTable.setBounds(0, 0, 618, 615);
			buyPanel.add(buyTable);
			buyTable.setRowHeight(56);
			buyTable.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
			buyTable.setBackground(new Color(255 ,224 ,252));
			buyTable.setModel(new DefaultTableModel(
				new Object[][] {
					{simple, 5, 0, "動物成長率增加5%"},
					{general, 8, 0, "動物成長率增加10%"},
					{advanced,15, 0, "動物成長率增加20%"},
					{chicken, 20, 0, "小雞"},
					{pig, 30, 0,"小豬"},
					{cow, 50, 0, "小牛"},
					{wheat,5, 0, "小麥種子"},
					{corn,10, 0, "玉米種子"},
					{cabbage, 15, 0, "高麗菜種子"},
					{fertilizer, 20, 0, "植物成長率增加10%"},
					{total, null, 0, null},
				},label){
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
			
			buyTable.setVisible(true);
			setTableColumnWidth(buyTable);
			btnDelfertilizer.setBounds(688, 516, 35, 31);
			buyPanel.add(btnDelfertilizer);
		
		JPanel panel = new JPanel();
		panel.setBounds(268, 13, 882, 615);
		contentPane.add(panel);
		panel.setOpaque(false);
		
		panel.setVisible(false);
		
		
		btnAddchicken = new JButton();
		cleanButtom(btnAddchicken);
		btnAddchicken.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddchicken.setFont(new Font("微軟正黑體 Light", Font.PLAIN,17));
		btnAddchicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(0, 2) < shop.getChickenNumber())
					editNumber(table,0, 2,1);
			}
		});
		btnAddchicken.setBounds(481, 34, 38, 40);
		
		btnAddpig = new JButton();
		cleanButtom(btnAddpig);
		btnAddpig.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddchicken.setFont(new Font("微軟正黑體 Light", Font.PLAIN,17));
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
		btnAddpig.setBounds(481, 130, 38, 35);
		
		btnAddcow = new JButton();
		cleanButtom(btnAddcow);
		btnAddcow.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddcow.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddcow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(2, 2) < shop.getCowNumber())
					editNumber(table,2, 2,1);
			}
		});
		btnAddcow.setBounds(481, 201, 38, 40);
		
		
		btnAddwheat = new JButton();
		cleanButtom(btnAddwheat);
		btnAddwheat.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddwheat.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		
		btnAddwheat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(3, 2) < shop.getWheatNumber())
					editNumber(table,3, 2,1);
			
			}
		});
		btnAddwheat.setBounds(481, 290, 38, 40);
		
		
		btnAddcorn = new JButton();
		cleanButtom(btnAddcorn);
		btnAddcorn.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddcorn.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddcorn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(4, 2) < shop.getCornNumber())
					editNumber(table,4, 2,1);
			}
		});
		btnAddcorn.setBounds(481, 375, 38, 40);
		
		
		
		btnAddcabbage = new JButton();
		cleanButtom(btnAddcabbage);
		btnAddcabbage.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddcabbage.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnAddcabbage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((int)table.getValueAt(5, 2) < shop.getCabbageNumber())
					editNumber(table,5, 2,1);
				
			}
		});
		btnAddcabbage.setBounds(481, 468, 44, 46);
		
		btnOk = new JButton();
		btnOk.setIcon(new ImageIcon("..\\picture\\oksell.png"));
		cleanButtom(btnOk);
		btnOk.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 21));
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int input = JOptionPane.showOptionDialog(null, "你確定要賣出?", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(input == 0) //ok
				{
					delItem();
					lblHoldmoney.setText(": "+String.valueOf(shop.getHoldMoney()));
				}
				cleanTable(table);
				
				
					
				
				
			}
		});
		btnOk.setBounds(640, 531, 196, 58);
		btnOk.setHorizontalAlignment(SwingConstants.TRAILING);
		
		
		
		panel.setLayout(null);
		
		
		
		table = new JTable();
		table.setBounds(0, 0, 467, 589);
		panel.add(table);
		table.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		table.setRowHeight(85);
		table.setBackground(new Color(255 ,224 ,252));
		
			table.setModel(new DefaultTableModel(organism,label){
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
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			setTableColumnWidth(table);
			panel.add(btnAddchicken);
			panel.add(btnAddpig);
			panel.add(btnAddcow);
			panel.add(btnAddcorn);
			panel.add(btnOk);
			panel.add(btnAddcabbage);
			panel.add(btnAddwheat);
			
			JButton btnDelchicken = new JButton();
			cleanButtom(btnDelchicken);
			btnDelchicken.setIcon(new ImageIcon("..\\picture\\del.png"));
			btnDelchicken.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
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
			btnDelchicken.setBounds(533, 34, 38, 40);
			panel.add(btnDelchicken);
			
			JButton btnDelpig = new JButton();
			cleanButtom(btnDelpig);
			btnDelpig.setIcon(new ImageIcon("..\\picture\\del.png"));
			btnDelpig.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
			btnDelpig.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					editNumber(table,1, 2,-1);
					
				}
			});
			btnDelpig.setBounds(533, 125, 38, 40);
			panel.add(btnDelpig);
			
			JButton btnDelcow = new JButton();
			cleanButtom(btnDelcow);
			btnDelcow.setIcon(new ImageIcon("..\\picture\\del.png"));
			btnDelcow.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
			btnDelcow.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					editNumber(table,2, 2,-1);
					
				}
			});
			btnDelcow.setBounds(533, 201, 44, 40);
			panel.add(btnDelcow);
			
			JButton btnDelwheat = new JButton();
			cleanButtom(btnDelwheat);
			btnDelwheat.setIcon(new ImageIcon("..\\picture\\del.png"));
			btnDelwheat.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
			btnDelwheat.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					editNumber(table,3, 2,-1);
					
				}
			});
			btnDelwheat.setBounds(533, 295, 38, 35);
			panel.add(btnDelwheat);
			
			JButton btnDelcorn = new JButton();
			cleanButtom(btnDelcorn);
			btnDelcorn.setIcon(new ImageIcon("..\\picture\\del.png"));
			btnDelcorn.setFont(new Font("微軟正黑體 Light", Font.PLAIN,17));
			btnDelcorn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					editNumber(table,4, 2,-1);
					
				}
			});
			btnDelcorn.setBounds(533, 376, 40, 39);
			panel.add(btnDelcorn);
			
			JButton btnDelcabbage = new JButton();
			cleanButtom(btnDelcabbage);
			btnDelcabbage.setIcon(new ImageIcon("..\\picture\\del.png"));
			btnDelcabbage.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
			btnDelcabbage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					editNumber(table,5, 2,-1);
					
				}
			});
			btnDelcabbage.setBounds(533, 468, 38, 40);
			panel.add(btnDelcabbage);
		
		JButton btnReturn = new JButton("return");
		
		
		btnReturn.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 21));
		btnReturn.setBounds(75, 259, 135, 35);
		contentPane.add(btnReturn);
		
		String holdMoney = String.format(":  %d", shop.getHoldMoney() );
		
		JPanel setMoney = new JPanel();
		setMoney.setBounds(12, 497, 227, 102);
		setMoney.setOpaque(false);
		contentPane.add(setMoney);
		
		JLabel money = new JLabel();
		setMoney.add(money);
		money.setIcon(new ImageIcon("..\\picture\\money.png"));
		lblHoldmoney = new JLabel(holdMoney);
		setMoney.add(lblHoldmoney);
		lblHoldmoney.setFont(new Font("微軟正黑體 Light", Font.BOLD, 28));
		
		
		
		
		
		background = new JLabel("background");
		background.setBounds(0, 0, 1200, 675);
		background.setBackground(new Color(204 ,135 ,125,50));
		contentPane.add(background);
		background.setIcon(new ImageIcon(new_img));
		
		
		
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
