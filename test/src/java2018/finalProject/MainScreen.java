package java2018.finalProject;



import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

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
	private WareHouseScreen whscreen;
	private ShopScreen spscreen; 

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainScreen(WareHouse warehouse) {
		this.warehouse = warehouse;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen.width * 7 / 8, screen.height * 7 / 8);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShop = new JButton("商店");
		btnShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							spscreen= new ShopScreen(warehouse);
						
							spscreen.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnShop.setBounds(14, 13, 144, 151);
		contentPane.add(btnShop);
		
		JButton btnNewWareHouse = new JButton("倉庫");
		btnNewWareHouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							whscreen = new WareHouseScreen(warehouse);
						
							whscreen.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnNewWareHouse.setBounds(24, 177, 137, 141);
		contentPane.add(btnNewWareHouse);
		
		JButton btnFarm = new JButton("農場");
		btnFarm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//把它設成private variable
							//WareHouseScreen frame = new WareHouseScreen(warehouse);
						
							//frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnFarm.setBounds(172, 18, 144, 141);
		contentPane.add(btnFarm);
		
		JButton btnDude = new JButton("牧場");
		btnDude.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							//把它設成private variable
							//WareHouseScreen frame = new WareHouseScreen(warehouse);
						
							//frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnDude.setBounds(182, 177, 144, 141);
		contentPane.add(btnDude);
		
		JButton btnNewButton = new JButton("魚池");
		btnNewButton.setBounds(345, 18, 137, 141);
		contentPane.add(btnNewButton);
	}
}
