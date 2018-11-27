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

public class ShopScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnOk;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnAddchicken;
	private JButton btnAddpig;
	private JButton btnAddcow;
	private JButton btnAddwheat;
	private JButton btnAddcorn;
	private JButton btnAddcabbage;
	
	
	

	/**
	 * Launch the application.
	 */
	public void editNumber(int row, int column, int change)
	{
		System.out.println(row);
		System.out.println(column);
		int num = (int) table.getValueAt(row, column);
		num+=change;
		table.setValueAt(num, row, column);
        System.out.println(num);
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
		panel.setBounds(0, 38, 405, 267);
		contentPane.add(panel);
		
		btnOk = new JButton("ok");
		panel.add(btnOk);
		
		
		btnAddchicken = new JButton("addChicken");
		panel.add(btnAddchicken);
		
		btnAddpig = new JButton("addPig");
		panel.add(btnAddpig);
		
		btnAddcow = new JButton("addCow");
		panel.add(btnAddcow);
		
		btnAddcorn = new JButton("addCorn");
		panel.add(btnAddcorn);
		
		btnAddcabbage = new JButton("addCabbage");
		panel.add(btnAddcabbage);
		
		table = new JTable();
		panel.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Chicken", "200", 0},
				{"Pig", "210", 0},
				{"Cow", "230", 0},
				{"Wheat", "10", 0},
				{"Corn", "30", 0},
				{"Cabbage", "50", 0},
				{"Total", null, 0},
			},
			new String[] {
				"Item", "Price", "Number"
			}
		));
		
		btnAddwheat = new JButton("addWheat");
		panel.add(btnAddwheat);
		btnAddwheat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(3,2,1);
			}
		});
		
		JButton btnSell = new JButton("Sell");
		btnSell.setBounds(63, 0, 55, 27);
		contentPane.add(btnSell);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(0, 0, 55, 27);
		contentPane.add(btnBuy);
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(!panel.isVisible());
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		btnAddcabbage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(5,2,1);
			}
		});
		btnAddcorn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(4,2,1);
			}
		});
		btnAddcow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(2,2,1);
			}
		});
		btnAddpig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(1,2,1);
			}
		});
		btnAddchicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editNumber(0,2,1);
			}
		});
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		
		
		
	}
}
