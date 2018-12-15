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
import java.awt.event.MouseListener;

public class MainScreen extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WareHouse warehouse;
	private WareHouseScreen whscreen;
	private ShopScreen spscreen; 
	private DudeScreen dudescreen;
	private FarmScreen farmscreen;
	private JButton shopBtn;
	private Main mainFrame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainScreen(Main mainFrame) {
		this.warehouse = warehouse;
		this.mainFrame = mainFrame;
		this.setSize(1200, 675);
		
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		shopBtn = new JButton("商店");
		shopBtn.addMouseListener(this);
		shopBtn.setBounds(14, 13, 144, 151);
		this.add(shopBtn);
		
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
		this.add(btnNewWareHouse);
		
		JButton btnFarm = new JButton("農場");
		btnFarm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							farmscreen = new FarmScreen(warehouse);
							farmscreen.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnFarm.setBounds(172, 18, 144, 141);
		this.add(btnFarm);
		
		JButton btnDude = new JButton("牧場");
		btnDude.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							//把它設成private variable
							//WareHouseScreen frame = new WareHouseScreen(warehouse);
							dudescreen = new DudeScreen(warehouse);
							dudescreen.setVisible(true);
							//frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnDude.setBounds(182, 177, 144, 141);
		this.add(btnDude);
		
		JButton btnNewButton = new JButton("魚池");
		btnNewButton.setBounds(345, 18, 137, 141);
		this.add(btnNewButton);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == shopBtn) {
			this.mainFrame.changeToShopScreen();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
