package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class EnterGame extends JFrame {

	private JPanel contentPane;

	public ImageIcon resizeImage(int width, int height, ImageIcon img)
	{
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return  new ImageIcon(new_img);
		
	}
 
	public EnterGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(197, 115, 142, 68);
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
			}
			@Override
            public void mouseEntered(MouseEvent arg0) {
				
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	
            } 
		});
		contentPane.add(btnEnter);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(206, 230, 133, 68);
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
            public void mouseEntered(MouseEvent arg0) {
				
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	
            } 
		});
		contentPane.add(btnLoad);
		
		JLabel background = new JLabel();
		background.setBounds(5, 5, 1172, 618);
		background.setIcon(resizeImage(1200,675,new ImageIcon("../picture/enter.jpg")));
		
		getContentPane().add(background);
	}
}
