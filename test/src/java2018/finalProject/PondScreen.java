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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;

public class PondScreen extends JPanel implements ActionListener {
	private enum ImageCondition {FISHING, GOT, WRONG};
	private JSlider slider;
	private int sliderValue = 0;
	private int sliderAdd = 1;
	private Timer t;
	private TimerTask tk;
	private boolean stop = false;
	
	private Main mainFrame;
	private JButton returnBtn;
	private JButton startBtn;
	private Timer timer;
	private JLabel timeLabel;
	private int time;
	private Timer imageTimer;
	private Timer replay;
	private int imageCount = 0;
	private ImageCondition imageCondition;
	
	private ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>();
	private JLabel bgLabel;
	private JSlider gameBar;
	
	public PondScreen(Main mainFrame) {
		this.mainFrame = mainFrame;
		this.mainFrame.setSize(1000, 800);
		this.setSize(1000, 800);
		this.setVisible(true);

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		loadBackgroundIcon();
		
		timeLabel = new JLabel("", JLabel.CENTER);
		timeLabel.setFont(new Font("微軟正黑體 Light", Font.BOLD, 48));
		timeLabel.setForeground(Color.RED);
		timeLabel.setBounds(700, 65, 250, 45);
		this.add(timeLabel);
		
		startBtn = new JButton("遊戲開始");
		startBtn.setFont(new Font("微軟正黑體 Light", Font.BOLD, 48));
		startBtn.setBounds(375, 300, 250, 70);
		startBtn.addActionListener(this);
		this.add(startBtn);
		
		returnBtn = new JButton();
		returnBtn.setIcon(new ImageIcon("..\\picture\\HOME.png"));
		returnBtn.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		returnBtn.setBounds(50, 20, 176, 114);
		returnBtn.setContentAreaFilled(false);
		returnBtn.setBorder(null);
		returnBtn.setFocusPainted(false);
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
		
		bgLabel = new JLabel();
		bgLabel.setSize(1000, 800);
		bgLabel.setIcon(iconList.get(0));
		this.add(bgLabel);
		
		this.setFocusable(true);
		
		gameBar = new JSlider();
		gameBar.setBounds(360, 65, 280, 50);
		gameBar.setUI(new GameSlider(gameBar));
		gameBar.setMaximum(270);
		gameBar.setMinimum(0);
		gameBar.setValue(135);
		System.out.println(gameBar.getValue());
		this.add(gameBar);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == 'a') {
					imageCondition = ImageCondition.FISHING;
				}
				else if (e.getKeyChar() == 's') {
					imageCondition = ImageCondition.GOT;
				}
				else if (e.getKeyChar() == 'd') {
					imageCondition = ImageCondition.WRONG;
				}
			}
		});
	}
	
	private void timerStart() {
		time = 10;
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				timeLabel.setText("倒數" + Integer.toString(time) + "秒");
				if (time == 0) {
					timer.cancel();
					returnBtn.setEnabled(true);
					startBtn.setText("再玩一次");
					startBtn.setVisible(true);
					imageTimer.cancel();
					replay.cancel();
				}
				time--;
			}
		}, 0, 1000);
		imageStart();
	}
	
	private void imageStart() {
		imageCondition = ImageCondition.FISHING;
		imageCount = 0;
		imageTimer = new Timer();
		imageTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				bgLabel.setIcon(iconList.get(imageCount));
				imageCount++;
				
				if (imageCondition == ImageCondition.FISHING) {
					if (imageCount == 20) {
						imageCount = 0;
					}
				}
				else if (imageCondition == ImageCondition.GOT) {
					if (imageCount == 54) {
						imageCount = 0;
						imageTimer.cancel();
						replay = new Timer();
						replay.schedule(new TimerTask() {
							@Override
							public void run() {
								imageStart();
							}
						}, 500);
					}
				}
				else if (imageCondition == ImageCondition.WRONG) {
					if (imageCount == 71) {
						imageCount = 0;
						imageTimer.cancel();
						Timer replay = new Timer();
						replay.schedule(new TimerTask() {
							@Override
							public void run() {
								imageStart();
							}
						}, 500);
					}
				}
			}
		}, 0, 30);
	}
	
	private ImageIcon imageResize(int width, int height, ImageIcon imgIcon)
	{
		Image img = imgIcon.getImage();
		Image imgR = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(imgR);
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
    
    private void loadBackgroundIcon() {
    	for (int i = 1; i <= 85; ++i) {
        	iconList.add(imageResize(1000, 800, new ImageIcon("../picture/fishing/fishing-" + Integer.toString(i) + ".png")));
    	}
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == returnBtn) {
			this.mainFrame.setSize(1200, 675);
			this.mainFrame.changeToMainScreen();
		}
		else if (e.getSource() == startBtn) {
			startBtn.setVisible(false);
			returnBtn.setEnabled(false);
			timerStart();
		}
	}
	
	private class GameSlider extends BasicSliderUI {
		private int shift = 5;
		public GameSlider (JSlider slider) {
			super(slider);
		}
		@Override
		public void paintTrack(Graphics g) {
			super.paintTrack(g);
			g.setColor(Color.WHITE);
			g.fillRoundRect(this.trackRect.x, this.trackRect.y, this.trackRect.width, this.trackRect.height, 15, 15);

			g.setColor(Color.BLACK);
			g.drawRoundRect(this.trackRect.x, this.trackRect.y, this.trackRect.width, this.trackRect.height, 15, 15);
		}
		@Override
		public void paintThumb(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillRect(this.thumbRect.x + shift, this.thumbRect.y, 1, this.thumbRect.height);
		}
	}
}