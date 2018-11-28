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

	
	

	/**
	 * Launch the application.
	 */
	public void editNumber(int row, int column, int change )
	{
		int num = (int) table.getValueAt(row, column);
		
		
		
			num+=change;
			table.setValueAt(num, row, column);
	        System.out.println(num);
		
		
	}
	
	public void countSellTotalMoney(int price, int num)
	{
		
		System.out.println(price);
		table.setValueAt((int) table.getValueAt(6, 2)+price*num, 6, 2);
		
			
			
	     System.out.println((int) table.getValueAt(6, 2));
		
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopScreen frame = new ShopScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShopScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 456);
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
		panel.setBounds(0, 56, 482, 317);
		contentPane.add(panel);
		
		
		btnAddchicken = new JButton("addChicken");
		btnAddchicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editNumber(0, 2,1);
				countSellTotalMoney((int)table.getValueAt(0, 1),1);
			}
		});
		btnAddchicken.setBounds(256, 5, 99, 27);
		
		btnAddpig = new JButton("addPig");
		btnAddpig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(1, 2,1);
				countSellTotalMoney((int)table.getValueAt(1, 1),1);
			}
		});
		btnAddpig.setBounds(256, 38, 99, 27);
		
		btnAddcow = new JButton("addCow");
		btnAddcow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(2, 2,1);
				countSellTotalMoney((int)table.getValueAt(2, 1),1);
			}
		});
		btnAddcow.setBounds(256, 68, 99, 27);
		
		btnAddcorn = new JButton("addCorn");
		btnAddcorn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(4, 2,1);
				countSellTotalMoney((int)table.getValueAt(4, 1),1);
			}
		});
		btnAddcorn.setBounds(256, 125, 99, 27);
		
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
		btnAddwheat = new JButton("addWheat");
		
		btnAddwheat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(3, 2,1);
				countSellTotalMoney((int)table.getValueAt(3, 1),1);
			}
		});
		btnAddwheat.setBounds(256, 96, 99, 27);
		btnAddcabbage = new JButton("addCabbage");
		btnAddcabbage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(5, 2,1);
				countSellTotalMoney((int)table.getValueAt(5, 1),1);
			}
		});
		btnAddcabbage.setBounds(256, 159, 101, 27);
		
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
				editNumber(0, 2,-1);
				countSellTotalMoney((int)table.getValueAt(0, 1),-1);
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
				editNumber(1, 2,-1);
				countSellTotalMoney((int)table.getValueAt(1, 1),-1);
			}
		});
		btnDelpig.setBounds(369, 38, 99, 27);
		panel.add(btnDelpig);
		
		JButton btnDelcow = new JButton("delCow");
		btnDelcow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(2, 2,-1);
				countSellTotalMoney((int)table.getValueAt(2, 1),-1);
			}
		});
		btnDelcow.setBounds(369, 68, 99, 27);
		panel.add(btnDelcow);
		
		JButton btnDelwheat = new JButton("delWheat");
		btnDelwheat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(3, 2,-1);
				countSellTotalMoney((int)table.getValueAt(3, 1),-1);
			}
		});
		btnDelwheat.setBounds(369, 96, 99, 27);
		panel.add(btnDelwheat);
		
		JButton btnDelcorn = new JButton("delCorn");
		btnDelcorn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(4, 2,-1);
				countSellTotalMoney((int)table.getValueAt(4, 1),-1);
			}
		});
		btnDelcorn.setBounds(369, 125, 99, 27);
		panel.add(btnDelcorn);
		
		JButton btnDelcabbage = new JButton("delCabbage");
		btnDelcabbage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(5, 2,-1);
				countSellTotalMoney((int)table.getValueAt(5, 1),-1);
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
		
		
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(!panel.isVisible());
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		
		
		
	}
}
