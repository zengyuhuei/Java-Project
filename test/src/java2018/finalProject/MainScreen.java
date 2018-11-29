package java2018.finalProject;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private WareHouse warehouse;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainScreen(WareHouse warehouse) {
		this.warehouse = warehouse;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShop = new JButton("商店");
		btnShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							ShopScreen frame = new ShopScreen(warehouse);
						
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnShop.setBounds(5, 319, 144, 151);
		contentPane.add(btnShop);
		
		JButton btnNewWareHouse = new JButton("倉庫");
		btnNewWareHouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							WareHouseScreen frame = new WareHouseScreen(warehouse);
						
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnNewWareHouse.setBounds(345, 80, 137, 141);
		contentPane.add(btnNewWareHouse);
		
		JButton btnFarm = new JButton("農場");
		btnFarm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							//WareHouseScreen frame = new WareHouseScreen(warehouse);
						
							//frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnFarm.setBounds(146, 110, 144, 141);
		contentPane.add(btnFarm);
		
		JButton btnDude = new JButton("牧場");
		btnDude.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							//WareHouseScreen frame = new WareHouseScreen(warehouse);
						
							//frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnDude.setBounds(228, 298, 160, 141);
		contentPane.add(btnDude);
	}
}
