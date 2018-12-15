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
	private JButton shopBtn;
	private JButton dudeBtn;
	private JButton wareHouseBtn;
	private JButton pondBtn;
	private JButton farmBtn;
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
		
		dudeBtn = new JButton("牧場");
		dudeBtn.addMouseListener(this);
		dudeBtn.setBounds(182, 177, 144, 141);
		this.add(dudeBtn);
				
		wareHouseBtn = new JButton("倉庫");
		wareHouseBtn.addMouseListener(this);
		wareHouseBtn.setBounds(24, 177, 137, 141);
		this.add(wareHouseBtn);
		
		pondBtn = new JButton("魚池");
		pondBtn.addMouseListener(this);
		pondBtn.setBounds(345, 18, 137, 141);
		this.add(pondBtn);
		
		farmBtn = new JButton("農場");
		farmBtn.addMouseListener(this);
		farmBtn.setBounds(172, 18, 144, 141);
		this.add(farmBtn);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == shopBtn) {
			this.mainFrame.changeToShopScreen();
		}
		else if (e.getSource() == dudeBtn) {
			this.mainFrame.changeToDudeScreen();
		}
		else if (e.getSource() == wareHouseBtn) {
			this.mainFrame.changeToWareHouseScreen();
		}
		else if(e.getSource() == pondBtn) {
			this.mainFrame.changeToPondScreen();
		}
		else if(e.getSource() == farmBtn) {
			this.mainFrame.changeToFarmScreen();
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
