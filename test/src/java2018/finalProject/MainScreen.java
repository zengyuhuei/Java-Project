package java2018.finalProject;

import java.awt.Color;
import java.awt.Cursor;
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
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class MainScreen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WareHouse warehouse;
	private Main mainFrame;
	private Polygon dudePoly;
	private Polygon wareHousePoly;
	private Polygon shopPoly;
	private Polygon farmPoly;
	private Polygon pondPoly;

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
		
		dudePoly = new Polygon();
		dudePoly.addPoint(0, 0);
		dudePoly.addPoint(540, 0);
		dudePoly.addPoint(404, 124);
		dudePoly.addPoint(416, 148);
		dudePoly.addPoint(325, 261);
		dudePoly.addPoint(0, 261);
		
		wareHousePoly = new Polygon();
		wareHousePoly.addPoint(570, 0);
		wareHousePoly.addPoint(874, 0);
		wareHousePoly.addPoint(805, 64);
		wareHousePoly.addPoint(805, 195);
		wareHousePoly.addPoint(733, 258);
		wareHousePoly.addPoint(443, 260);
		wareHousePoly.addPoint(442, 120);
		wareHousePoly.addPoint(413, 140);
		wareHousePoly.addPoint(406, 127);

		shopPoly = new Polygon();
		shopPoly.addPoint(875, 0);
		shopPoly.addPoint(1200, 0);
		shopPoly.addPoint(1200, 254);
		shopPoly.addPoint(807, 258);
		shopPoly.addPoint(810, 60);
		
		farmPoly = new Polygon();
		farmPoly.addPoint(0, 316);
		farmPoly.addPoint(680, 326);
		farmPoly.addPoint(386, 675);
		farmPoly.addPoint(0, 675);
		
		pondPoly = new Polygon();
		pondPoly.addPoint(822, 328);
		pondPoly.addPoint(1200, 325);
		pondPoly.addPoint(1200, 675);
		pondPoly.addPoint(509, 675);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (dudePoly.contains(e.getPoint())) {
					mainFrame.changeToDudeScreen();
				}
				else if (wareHousePoly.contains(e.getPoint())) {
					mainFrame.changeToWareHouseScreen();
				}
				else if (shopPoly.contains(e.getPoint())) {
					mainFrame.changeToShopScreen();
				}
				else if (farmPoly.contains(e.getPoint())) {
					mainFrame.changeToFarmScreen();
				}
				else if (pondPoly.contains(e.getPoint())) {
					mainFrame.changeToPondScreen();
				}
			}
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (dudePoly.contains(e.getPoint())) {
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				else if (wareHousePoly.contains(e.getPoint())) {
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				else if (shopPoly.contains(e.getPoint())) {
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				else if (farmPoly.contains(e.getPoint())) {
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				else if (pondPoly.contains(e.getPoint())) {
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				else {
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
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
}
