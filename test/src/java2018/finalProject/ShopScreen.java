package java2018.finalProject;


import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.JOptionPane;



import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;


public class ShopScreen extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnOk;

	private JButton btnAddchicken;
	private JButton btnAddpig;
	private JButton btnAddcow;
	private JButton btnAddwheat;
	private JButton btnAddcorn;
	private JButton btnAddcabbage;
	private JButton btnReturn;
	private JTable buyTable;
	private Shop shop;
    private JLabel lblHoldmoney;
    private JLabel background;
    private Main mainFrame;
    private int isClicked = 0;
    
    public void buttonSound()
    {
    	 try {
	            
	            File soundFile = new File("..\\sound\\button.wav");
	            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioIn);
	            clip.start();
	            
	        } catch (UnsupportedAudioFileException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (LineUnavailableException e) {
	            e.printStackTrace();
	        }
    }
    
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
	

	public ShopScreen(Main mainFrame, WareHouse warehouse) {
		this.mainFrame = mainFrame;
		shop = new Shop(warehouse);
		this.setSize(1200, 675);

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
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
		ImageIcon simple =resizeImage (50,50,new ImageIcon("../picture/lowfeed.png"));
		ImageIcon general =resizeImage (50,50,new ImageIcon("../picture/midfeed.png"));
		ImageIcon advanced =resizeImage (50,50,new ImageIcon("../picture/highfeed.png"));
		ImageIcon total =resizeImage (50,50,new ImageIcon("../picture/total.png"));
		ImageIcon unSellScreen = new ImageIcon("../picture/unsellScreen.png");
		ImageIcon unBuyScreen = new ImageIcon("../picture/unbuyScreen.png");
		JButton btnSell = new JButton();
		btnSell.setIcon(new ImageIcon("..\\picture\\unsellScreen.png"));
		cleanButtom(btnSell);
		btnSell.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 21));
		btnSell.setBounds(78, 158, 132, 74);
		this.add(btnSell);
		
		JButton btnBuy = new JButton();
		btnBuy.setIcon(new ImageIcon("..\\picture\\buyScreen.png"));
		cleanButtom(btnBuy);
		btnBuy.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		btnBuy.setBounds(78, 87, 132, 58);
		this.add(btnBuy);
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
		
		JPanel askSell = new JPanel();
		askSell.setOpaque(false);
		askSell.setVisible(false);
		askSell.setBounds(350, 200, 466, 243);
		add(askSell);
		askSell.setBackground(Color.YELLOW);
		askSell.setLayout(null);
		
		JPanel noMoney = new JPanel();
		noMoney.setOpaque(false);
		noMoney.setVisible(false);
		noMoney.setBounds(350, 200, 466, 243);
		add(noMoney);
		noMoney.setLayout(null);
		
		
		
		JButton no = new JButton();
		no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				noMoney.setVisible(false);
			}
		});
		no.setIcon(new ImageIcon("..\\picture\\nobtn.png"));
		no.setBounds(319, 167, 68, 44);
		no.setVisible(true);
		
		JButton ok= new JButton();
		ok.setVisible(true);
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				noMoney.setVisible(false);
			}
		});
		ok.setIcon(new ImageIcon("..\\picture\\yesbtn.png"));
		ok.setBounds(220, 167, 68, 44);
		noMoney.add(ok);
		noMoney.add(no);
		
		
		JLabel noMoneyLabel = new JLabel();
		noMoneyLabel.setBounds(0,0, 466, 243);
		noMoneyLabel.setIcon(resizeImage(noMoneyLabel.getWidth(),noMoneyLabel.getHeight(),new ImageIcon("..\\picture\\noMoney.png")));
		noMoney.add(noMoneyLabel);
		
		JButton noToSell = new JButton();
		noToSell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//cleanTable(table);
				askSell.setVisible(false);
			}
		});
		noToSell.setIcon(new ImageIcon("..\\picture\\nobtn.png"));
		noToSell.setBounds(319, 167, 68, 44);
		noToSell.setVisible(true);
		
		JButton okToSell = new JButton();
		okToSell.setVisible(true);
		okToSell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				delItem();
				lblHoldmoney.setText(": "+String.valueOf(shop.getHoldMoney()));
				cleanTable(table);
				askSell.setVisible(false);
			}
		});
		okToSell.setIcon(new ImageIcon("..\\picture\\yesbtn.png"));
		okToSell.setBounds(220, 167, 68, 44);
		askSell.add(okToSell);
		askSell.add(noToSell);
		
		
		JLabel askSellLabel = new JLabel();
		askSellLabel.setBounds(0,0, 466, 243);
		askSellLabel.setIcon(resizeImage(askSellLabel.getWidth(),askSellLabel.getHeight(),new ImageIcon("..\\picture\\askSell.png")));
		askSell.add(askSellLabel);
		
		
		JPanel askBuy = new JPanel();
		askBuy.setOpaque(false);
		askBuy.setVisible(false);
		askBuy.setBounds(350, 200, 466, 243);
		add(askBuy);
		askBuy.setLayout(null);
		
		
		
		JButton noToBuy = new JButton();
		noToBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//cleanTable(table);
				askBuy.setVisible(false);
			}
		});
		noToBuy.setIcon(new ImageIcon("..\\picture\\nobtn.png"));
		noToBuy.setBounds(319, 167, 68, 44);
		noToBuy.setVisible(true);
		
		JButton okToBuy= new JButton();
		okToBuy.setVisible(true);
		okToBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(isLegal(buyTable))//金錢足夠
				{
					addItem();
					lblHoldmoney.setText(" : "+String.valueOf(shop.getHoldMoney()));
					cleanTable(buyTable);
				}
				else
				{
					String message = String.format("現有金錢為:%d元，金額不足",shop.getHoldMoney() );
					noMoney.setVisible(true);
				}
				
				askBuy.setVisible(false);
			}
		});
		okToBuy.setIcon(new ImageIcon("..\\picture\\yesbtn.png"));
		okToBuy.setBounds(220, 167, 68, 44);
		askBuy.add(okToBuy);
		askBuy.add(noToBuy);
		
		
		JLabel askBuyLabel = new JLabel();
		askBuyLabel.setBounds(0,0, 466, 243);
		askBuyLabel.setIcon(resizeImage(askBuyLabel.getWidth(),askBuyLabel.getHeight(),new ImageIcon("..\\picture\\askBuy.png")));
		askBuy.add(askBuyLabel);
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(268, 13, 882, 615);
		this.add(panel);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddchicken.setIcon(resizeImage(btnAddchicken.getIcon().getIconWidth()+5,btnAddchicken.getIcon().getIconHeight()+5,(ImageIcon)btnAddchicken.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddchicken.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddchicken.setBounds(480, 35, 40, 40);
		
		btnAddpig = new JButton();
		cleanButtom(btnAddpig);
		btnAddpig.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddpig.setFont(new Font("微軟正黑體 Light", Font.PLAIN,17));
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddpig.setIcon(resizeImage(btnAddpig.getIcon().getIconWidth()+5,btnAddpig.getIcon().getIconHeight()+5,(ImageIcon)btnAddpig.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddpig.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddpig.setBounds(480, 120, 40, 40);
		
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddcow.setIcon(resizeImage(btnAddcow.getIcon().getIconWidth()+5,btnAddcow.getIcon().getIconHeight()+5,(ImageIcon)btnAddcow.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddcow.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddcow.setBounds(480, 205, 40, 40);
		
		
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddwheat.setIcon(resizeImage(btnAddwheat.getIcon().getIconWidth()+5,btnAddwheat.getIcon().getIconHeight()+5,(ImageIcon)btnAddwheat.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddwheat.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddwheat.setBounds(480, 290, 40, 40);
		
		
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddcorn.setIcon(resizeImage(btnAddcorn.getIcon().getIconWidth()+5,btnAddcorn.getIcon().getIconHeight()+5,(ImageIcon)btnAddcorn.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddcorn.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddcorn.setBounds(480, 375, 40, 40);
		
		
		
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddcabbage.setIcon(resizeImage(btnAddcabbage.getIcon().getIconWidth()+5,btnAddcabbage.getIcon().getIconHeight()+5,(ImageIcon)btnAddcabbage.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddcabbage.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddcabbage.setBounds(480, 460, 40, 40);
		
		btnOk = new JButton();
		btnOk.setIcon(new ImageIcon("..\\picture\\oksell.png"));
		cleanButtom(btnOk);
		btnOk.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 21));
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				askSell.setVisible(true);
				
				
				
			}     
            @Override
            public void mouseEntered(MouseEvent arg0) {
            	buttonSound();
            	setCursor(new Cursor(Cursor.HAND_CURSOR));
            	btnOk.setIcon(resizeImage(btnOk.getIcon().getIconWidth()+10,btnOk.getIcon().getIconHeight()+10,(ImageIcon)btnOk.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnOk.setIcon(new ImageIcon("..\\picture\\oksell.png"));
            }  
		});
		btnOk.setBounds(618, 531, 218, 84);
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
				@Override
	            public void mouseEntered(MouseEvent arg0) {
					buttonSound();
					btnDelchicken.setIcon(resizeImage(btnDelchicken.getIcon().getIconWidth()+5,btnDelchicken.getIcon().getIconHeight()+5,(ImageIcon)btnDelchicken.getIcon()));
	            } 
	            @Override
	            public void mouseExited(MouseEvent arg0) {
	            	btnDelchicken.setIcon(new ImageIcon("..\\picture\\del.png"));
	            } 
			});
			btnDelchicken.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnDelchicken.setBounds(530, 35, 40, 40);
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
				@Override
	            public void mouseEntered(MouseEvent arg0) {
					buttonSound();
					btnDelpig.setIcon(resizeImage(btnDelpig.getIcon().getIconWidth()+5,btnDelpig.getIcon().getIconHeight()+5,(ImageIcon)btnDelpig.getIcon()));
	            } 
	            @Override
	            public void mouseExited(MouseEvent arg0) {
	            	btnDelpig.setIcon(new ImageIcon("..\\picture\\del.png"));
	            } 
			});
			btnDelpig.setBounds(530, 120, 40, 40);
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
				@Override
	            public void mouseEntered(MouseEvent arg0) {
					buttonSound();
					btnDelcow.setIcon(resizeImage(btnDelcow.getIcon().getIconWidth()+5,btnDelcow.getIcon().getIconHeight()+5,(ImageIcon)btnDelcow.getIcon()));
	            } 
	            @Override
	            public void mouseExited(MouseEvent arg0) {
	            	btnDelcow.setIcon(new ImageIcon("..\\picture\\del.png"));
	            } 
			});
			btnDelcow.setBounds(530, 205, 40, 40);
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
				@Override
	            public void mouseEntered(MouseEvent arg0) {
					buttonSound();
					btnDelwheat.setIcon(resizeImage(btnDelwheat.getIcon().getIconWidth()+5,btnDelwheat.getIcon().getIconHeight()+5,(ImageIcon)btnDelwheat.getIcon()));
	            } 
	            @Override
	            public void mouseExited(MouseEvent arg0) {
	            	btnDelwheat.setIcon(new ImageIcon("..\\picture\\del.png"));
	            } 
			});
			btnDelwheat.setBounds(530, 290, 40, 40);
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
				@Override
	            public void mouseEntered(MouseEvent arg0) {
					buttonSound();
					btnDelcorn.setIcon(resizeImage(btnDelcorn.getIcon().getIconWidth()+5,btnDelcorn.getIcon().getIconHeight()+5,(ImageIcon)btnDelcorn.getIcon()));
	            } 
	            @Override
	            public void mouseExited(MouseEvent arg0) {
	            	btnDelcorn.setIcon(new ImageIcon("..\\picture\\del.png"));
	            } 
			});
			btnDelcorn.setBounds(530, 375, 40, 40);
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
				@Override
	            public void mouseEntered(MouseEvent arg0) {
					buttonSound();
					btnDelcabbage.setIcon(resizeImage(btnDelcabbage.getIcon().getIconWidth()+5,btnDelcabbage.getIcon().getIconHeight()+5,(ImageIcon)btnDelcabbage.getIcon()));
	            } 
	            @Override
	            public void mouseExited(MouseEvent arg0) {
	            	btnDelcabbage.setIcon(new ImageIcon("..\\picture\\del.png"));
	            } 
			});
			btnDelcabbage.setBounds(530, 460, 40, 40);
			panel.add(btnDelcabbage);
		
		JPanel buyPanel = new JPanel();
		buyPanel.setBounds(254, 13, 915, 628);
		buyPanel.setOpaque(false);
		this.add(buyPanel);
		buyPanel.setLayout(null);
		buyPanel.setVisible(true);
		
		JButton btnAddSimple = new JButton();
		cleanButtom(btnAddSimple);
		btnAddSimple.setIcon(new ImageIcon("..\\picture\\add.png"));
		btnAddSimple.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 17));
		
		btnAddSimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(buyTable,0, 2,1);
				
			}
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddSimple.setIcon(resizeImage(btnAddSimple.getIcon().getIconWidth()+5,btnAddSimple.getIcon().getIconHeight()+5,(ImageIcon)btnAddSimple.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddSimple.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddSimple.setBounds(634, 13, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddGeneral.setIcon(resizeImage(btnAddGeneral.getIcon().getIconWidth()+5,btnAddGeneral.getIcon().getIconHeight()+5,(ImageIcon)btnAddGeneral.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddGeneral.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddGeneral.setBounds(634, 69, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddAdvanced.setIcon(resizeImage(btnAddAdvanced.getIcon().getIconWidth()+5,btnAddAdvanced.getIcon().getIconHeight()+5,(ImageIcon)btnAddAdvanced.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddAdvanced.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddAdvanced.setBounds(634, 125, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddYoungChicken.setIcon(resizeImage(btnAddYoungChicken.getIcon().getIconWidth()+5,btnAddYoungChicken.getIcon().getIconHeight()+5,(ImageIcon)btnAddYoungChicken.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddYoungChicken.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddYoungChicken.setBounds(634, 181, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddYoungPig.setIcon(resizeImage(btnAddYoungPig.getIcon().getIconWidth()+5,btnAddYoungPig.getIcon().getIconHeight()+5,(ImageIcon)btnAddYoungPig.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddYoungPig.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddYoungPig.setBounds(634, 237, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddYoungCow.setIcon(resizeImage(btnAddYoungCow.getIcon().getIconWidth()+5,btnAddYoungCow.getIcon().getIconHeight()+5,(ImageIcon)btnAddYoungCow.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddYoungCow.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddYoungCow.setBounds(634, 293, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddwheatseed.setIcon(resizeImage(btnAddwheatseed.getIcon().getIconWidth()+5,btnAddwheatseed.getIcon().getIconHeight()+5,(ImageIcon)btnAddwheatseed.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddwheatseed.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddwheatseed.setBounds(634, 349, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddCornSeed.setIcon(resizeImage(btnAddCornSeed.getIcon().getIconWidth()+5,btnAddCornSeed.getIcon().getIconHeight()+5,(ImageIcon)btnAddCornSeed.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddCornSeed.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddCornSeed.setBounds(634, 405, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddCabbageSeed.setIcon(resizeImage(btnAddCabbageSeed.getIcon().getIconWidth()+5,btnAddCabbageSeed.getIcon().getIconHeight()+5,(ImageIcon)btnAddCabbageSeed.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddCabbageSeed.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddCabbageSeed.setBounds(634, 461, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnAddFertilizer.setIcon(resizeImage(btnAddFertilizer.getIcon().getIconWidth()+5,btnAddFertilizer.getIcon().getIconHeight()+5,(ImageIcon)btnAddFertilizer.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnAddFertilizer.setIcon(new ImageIcon("..\\picture\\add.png"));
            } 
		});
		btnAddFertilizer.setBounds(634, 517, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnDelSimple.setIcon(resizeImage(btnDelSimple.getIcon().getIconWidth()+5,btnDelSimple.getIcon().getIconHeight()+5,(ImageIcon)btnDelSimple.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnDelSimple.setIcon(new ImageIcon("..\\picture\\del.png"));
            } 
		});
		btnDelSimple.setBounds(680, 13, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnDelgeneral.setIcon(resizeImage(btnDelgeneral.getIcon().getIconWidth()+5,btnDelgeneral.getIcon().getIconHeight()+5,(ImageIcon)btnDelgeneral.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnDelgeneral.setIcon(new ImageIcon("..\\picture\\del.png"));
            } 
		});
		btnDelgeneral.setBounds(680, 69, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnDeladvanced.setIcon(resizeImage(btnDeladvanced.getIcon().getIconWidth()+5,btnDeladvanced.getIcon().getIconHeight()+5,(ImageIcon)btnDeladvanced.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnDeladvanced.setIcon(new ImageIcon("..\\picture\\del.png"));
            } 
		});
		btnDeladvanced.setBounds(680, 125, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnDelYoungChicken.setIcon(resizeImage(btnDelYoungChicken.getIcon().getIconWidth()+5,btnDelYoungChicken.getIcon().getIconHeight()+5,(ImageIcon)btnDelYoungChicken.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnDelYoungChicken.setIcon(new ImageIcon("..\\picture\\del.png"));
            } 
		});
		btnDelYoungChicken.setBounds(680, 181, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnDelYoungPig.setIcon(resizeImage(btnDelYoungPig.getIcon().getIconWidth()+5,btnDelYoungPig.getIcon().getIconHeight()+5,(ImageIcon)btnDelYoungPig.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnDelYoungPig.setIcon(new ImageIcon("..\\picture\\del.png"));
            } 
		});
		btnDelYoungPig.setBounds(680, 236, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnDelYoungCow.setIcon(resizeImage(btnDelYoungCow.getIcon().getIconWidth()+5,btnDelYoungCow.getIcon().getIconHeight()+5,(ImageIcon)btnDelYoungCow.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnDelYoungCow.setIcon(new ImageIcon("..\\picture\\del.png"));
            } 
		});
		btnDelYoungCow.setBounds(680, 292, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnDelwheatseed.setIcon(resizeImage(btnDelwheatseed.getIcon().getIconWidth()+5,btnDelwheatseed.getIcon().getIconHeight()+5,(ImageIcon)btnDelwheatseed.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnDelwheatseed.setIcon(new ImageIcon("..\\picture\\del.png"));
            } 
		});
		btnDelwheatseed.setBounds(680, 348, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnDelcornseed.setIcon(resizeImage(btnDelcornseed.getIcon().getIconWidth()+5,btnDelcornseed.getIcon().getIconHeight()+5,(ImageIcon)btnDelcornseed.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnDelcornseed.setIcon(new ImageIcon("..\\picture\\del.png"));
            } 
		});
		btnDelcornseed.setBounds(680, 404, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnDelcabbageseed.setIcon(resizeImage(btnDelcabbageseed.getIcon().getIconWidth()+5,btnDelcabbageseed.getIcon().getIconHeight()+5,(ImageIcon)btnDelcabbageseed.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnDelcabbageseed.setIcon(new ImageIcon("..\\picture\\del.png"));
            } 
		});
		btnDelcabbageseed.setBounds(680, 460, 35, 30);
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
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				btnDelfertilizer.setIcon(resizeImage(btnDelfertilizer.getIcon().getIconWidth()+5,btnDelfertilizer.getIcon().getIconHeight()+5,(ImageIcon)btnDelfertilizer.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnDelfertilizer.setIcon(new ImageIcon("..\\picture\\del.png"));
            } 
		});
		
		JButton btnBuyOk = new JButton("ok");
		btnBuyOk.setBounds(688, 560, 204, 55);
		buyPanel.add(btnBuyOk);
		btnBuyOk.setIcon(new ImageIcon("..\\picture\\okbuy.png"));
		cleanButtom(btnBuyOk);
		btnBuyOk.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 21));
		btnBuyOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				askBuy.setVisible(true);
				
			}
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnBuyOk.setIcon(resizeImage(btnBuyOk.getIcon().getIconWidth()+10,btnBuyOk.getIcon().getIconHeight()+10,(ImageIcon)btnBuyOk.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnBuyOk.setIcon(new ImageIcon("..\\picture\\okbuy.png"));
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
			btnDelfertilizer.setBounds(680, 516, 35, 30);
			buyPanel.add(btnDelfertilizer);
		
		btnReturn = new JButton();
		cleanButtom(btnReturn);
		btnReturn.setIcon(new ImageIcon("..\\picture\\HOME.png"));
		
		btnReturn.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 21));
		btnReturn.setBounds(75, 245, 135, 102);
		this.add(btnReturn);
		btnReturn.addActionListener(this);
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnReturn.setIcon(resizeImage(btnReturn.getIcon().getIconWidth()+10,btnReturn.getIcon().getIconHeight()+10,(ImageIcon)btnReturn.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnReturn.setIcon(new ImageIcon("..\\picture\\HOME.png"));
            } 
		});
		
		String holdMoney = String.format(":  %d", shop.getHoldMoney() );
		
		JPanel setMoney = new JPanel();
		setMoney.setBounds(12, 497, 227, 102);
		setMoney.setOpaque(false);
		this.add(setMoney);
		
		JLabel money = new JLabel();
		setMoney.add(money);
		money.setIcon(new ImageIcon("..\\picture\\money.png"));
		lblHoldmoney = new JLabel(holdMoney);
		setMoney.add(lblHoldmoney);
		lblHoldmoney.setFont(new Font("微軟正黑體 Light", Font.BOLD, 28));
		
		
		
		
		
		background = new JLabel("background");
		background.setBounds(0, -13, 1200, 675);
		background.setBackground(new Color(204 ,135 ,125,50));
		this.add(background);
		background.setIcon(new ImageIcon(new_img));
		
		
		
		btnBuy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				buyPanel.setVisible(true);
				cleanTable(table);
				System.out.println(shop.getHoldMoney());
				isClicked =0;
				btnSell.setIcon(new ImageIcon("..\\picture\\unsellScreen.png"));
				btnBuy.setIcon(new ImageIcon("..\\picture\\buyScreen.png"));
			}
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnBuy.setIcon(resizeImage(btnBuy.getIcon().getIconWidth()+10,btnBuy.getIcon().getIconHeight()+10,(ImageIcon)btnBuy.getIcon()));
				
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	if(isClicked==0)btnBuy.setIcon(new ImageIcon("..\\picture\\buyScreen.png"));
            	else btnBuy.setIcon(resizeImage(unBuyScreen.getIconWidth()+10,unBuyScreen.getIconHeight()+10,unBuyScreen));
            } 
		});
		
		btnSell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				isClicked =1;
				panel.setVisible(true);
				btnBuy.setIcon(new ImageIcon("..\\picture\\unbuyScreen.png"));
				btnSell.setIcon(new ImageIcon("..\\picture\\sellScreen.png"));
				buyPanel.setVisible(false);
				cleanTable(buyTable);
				System.out.printf("Item %s num %d\n","雞",shop.getChickenNumber());
				System.out.printf("Item %s num %d\n","豬",shop.getPigNumber());
				System.out.printf("Item %s num %d\n","牛",shop.getCowNumber());
				System.out.printf("Item %s num %d\n","小麥",shop.getWheatNumber());
				System.out.printf("Item %s num %d\n","玉米",shop.getCornNumber());
				System.out.printf("Item %s num %d\n","高麗菜",shop.getCabbageNumber());
			}
			@Override
            public void mouseEntered(MouseEvent arg0) {
				buttonSound();
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnSell.setIcon(resizeImage(btnSell.getIcon().getIconWidth()+10,btnSell.getIcon().getIconHeight()+10,(ImageIcon)btnSell.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	if(isClicked ==1)btnSell.setIcon(new ImageIcon("..\\picture\\sellScreen.png"));
            	else btnSell.setIcon(resizeImage(unSellScreen.getIconWidth()+10,unSellScreen.getIconHeight()+10,unSellScreen));
            } 
			
		});
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnReturn) {
			this.mainFrame.changeToMainScreen();
		}
	}
}
