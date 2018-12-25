package java2018.finalProject;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSliderUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;

public class PondScreen extends JPanel implements ActionListener {
	private JSlider slider;
	private int sliderValue = 0;
	private int sliderAdd = 1;
	private Timer t;
	private TimerTask tk;
	private boolean stop = false;
	
	private Main mainFrame;
	private JButton returnBtn;
	private JButton startBtn;
	
	public PondScreen(Main mainFrame) {
		this.mainFrame = mainFrame;
		this.setSize(1200, 675);
		this.setVisible(true);

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		startBtn = new JButton("遊戲開始");
		startBtn.setFont(new Font("微軟正黑體 Light", Font.BOLD, 28));
		startBtn.setBounds(500, 300, 200, 50);
		this.add(startBtn);
		
		returnBtn = new JButton();
		returnBtn.setIcon(new ImageIcon("..\\picture\\HOME.png"));
		returnBtn.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		returnBtn.setBounds(20, 20, 176, 114);
		returnBtn.setContentAreaFilled(false);
		returnBtn.setBorder(null);
		returnBtn.setEnabled(false);
		returnBtn.addActionListener(this);
		returnBtn.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				returnBtn.setIcon(imageResize(returnBtn.getIcon().getIconWidth()+10,returnBtn.getIcon().getIconHeight()+10,(ImageIcon)returnBtn.getIcon()));
				if (returnBtn.isEnabled()) {
					buttonSound();
				}
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	returnBtn.setIcon(new ImageIcon("..\\picture\\HOME.png"));
            } 
			
		});
		this.add(returnBtn);
	}
	
	private ImageIcon imageResize(int width, int height, ImageIcon imgIcon)
	{
		Image img = imgIcon.getImage();
		Image imgR = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return  new ImageIcon(imgR);
	}
    
    private void buttonSound()
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == returnBtn) {
			this.mainFrame.changeToMainScreen();
		}
	}
}

class GameSlider extends BasicSliderUI {    
	private static float[] fracs = {0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f};
	private LinearGradientPaint p;
	public GameSlider(JSlider slider) {
		super(slider);
	}
	@Override
	public void paintTrack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;    
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.setColor(Color.BLACK);
        g2d.fillRoundRect(0, 6, 200, 8, 10, 10);
        
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(30, 6, 20, 8);
        
        g2d.setColor(Color.WHITE);
        g2d.drawRoundRect(0, 6, 200, 8, 10, 10);
        //System.out.println(trackRect.width);
        /*Rectangle t = trackRect;
        Point2D start = new Point2D.Float(t.x + 10, t.y - 10);
        Point2D end = new Point2D.Float(t.width, t.height);
        Color[] colors = {Color.magenta, Color.blue, Color.cyan,
            Color.green, Color.yellow, Color.red};
        p = new LinearGradientPaint(start, end, fracs, colors);
        g2d.setPaint(p);
        g2d.fillRect(t.x, t.y, t.width, t.height);*/
	}
}