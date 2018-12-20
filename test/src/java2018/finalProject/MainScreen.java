package java2018.finalProject;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JPanel implements ActionListener {

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
		shopBtn.addActionListener(this);
		shopBtn.setBounds(950, 175, 100, 50);
		this.add(shopBtn);
		
		dudeBtn = new JButton("牧場");
		dudeBtn.addActionListener(this);
		dudeBtn.setBounds(150, 175, 100, 50);
		this.add(dudeBtn);
				
		wareHouseBtn = new JButton("倉庫");
		wareHouseBtn.addActionListener(this);
		wareHouseBtn.setBounds(550, 175, 100, 50);
		this.add(wareHouseBtn);
		
		pondBtn = new JButton("魚池");
		pondBtn.addActionListener(this);
		pondBtn.setBounds(922, 360, 100, 50);
		this.add(pondBtn);
		
		farmBtn = new JButton("農場");
		farmBtn.addActionListener(this);
		farmBtn.setBounds(170, 360, 100, 50);
		this.add(farmBtn);

		ImageIcon img = new ImageIcon("../picture/main.jpg");
		Image i = img.getImage();
		i = i.getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(i));
		background.setSize(1200, 675);
		this.add(background);
		
		MyButton testBtn = new MyButton("test");
		testBtn.setLocation(150, 150);
		testBtn.setOpaque(false);
		testBtn.repaint();
		this.add(testBtn);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.printf("%d %d", e.getX(), e.getY());
			}
		});
	}

	private class MyButton extends JButton {
		public MyButton(String title) {
			super(title);
			this.setBorderPainted(false);
		}
		
		@Override
		public void paintBorder(Graphics g) {
			Polygon p = new Polygon();
		    for (int i = 0; i < 5; i++) {
			    p.addPoint((int) 
			    (100 + 50 * Math.cos(i * 2 * Math.PI / 5)),
			    (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));
		    }
		    g.setColor(Color.BLACK);
		    g.drawPolygon(p);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
}
