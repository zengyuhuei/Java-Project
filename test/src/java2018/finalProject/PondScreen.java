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
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PondScreen extends JPanel implements ActionListener {
	private static enum ImageCondition {FISHING, GOT, WRONG};
	private static enum fishCategories {BIG, MID, SMALL, NO};
	private fishCategories fishCate = fishCategories.NO;
	private SecureRandom rand = new SecureRandom();
	private int fishStart;
	private int fishEnd;
	
	private Main mainFrame;
	private JButton returnBtn;
	private JLabel startLabel;
	private JButton startBtn;
	private Timer timer;
	private JLabel timeLabel;
	private int time;
	private Timer imageTimer;
	private Timer replay = null;
	private Timer sliderTimer;
	private int imageCount = 0;
	private ImageCondition imageCondition;
	
	private ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>();
	private JLabel bgLabel;
	private JSlider gameBar;
	private int sliderValue;
	private int thumbValue;
	private int runTo;
	private String startBtnImg = "..\\picture\\pondGameStartBtn.png";

	private int bigFishCount = 0;
	private int littleFishCount = 0;
	private int midFishCount = 0;
	private JLabel bigFishCountLabel;
	private JLabel littleFishCountLabel;
	private JLabel midFishCountLabel;
	
	private WareHouse warehouse;
	
	private boolean gameCancel = false;
	
	public PondScreen(Main mainFrame, WareHouse warehouse) {
		this.warehouse = warehouse;
		this.mainFrame = mainFrame;
		this.mainFrame.setSize(1000, 800);
		this.setSize(1000, 800);
		this.setVisible(true);

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		loadBackgroundIcon();
		
		JLabel bigFishLabel = new JLabel("", JLabel.CENTER);
		bigFishLabel.setIcon(imageResize(170, 120, new ImageIcon("..\\picture\\bigFish.png")));
		bigFishLabel.setBounds(30, 640, 170, 120);
		this.add(bigFishLabel);
		
		JLabel x1Label = new JLabel("x", JLabel.CENTER);
		x1Label.setFont(new Font("華康小花體", Font.BOLD, 58));
		x1Label.setForeground(Color.BLACK);
		x1Label.setBounds(190, 675, 60, 60);
		this.add(x1Label);
		
		bigFishCountLabel = new JLabel("0", JLabel.CENTER);
		bigFishCountLabel.setFont(new Font("華康小花體", Font.BOLD, 58));
		bigFishCountLabel.setForeground(Color.BLACK);
		bigFishCountLabel.setBounds(240, 675, 60, 60);
		this.add(bigFishCountLabel);
		
		JLabel midFishLabel = new JLabel("", JLabel.CENTER);
		midFishLabel.setIcon(imageResize(140, 90, new ImageIcon("..\\picture\\midFish.png")));
		midFishLabel.setBounds(385, 655, 140, 90);
		this.add(midFishLabel);
		
		JLabel x2Label = new JLabel("x", JLabel.CENTER);
		x2Label.setFont(new Font("華康小花體", Font.BOLD, 58));
		x2Label.setForeground(Color.BLACK);
		x2Label.setBounds(510, 675, 60, 60);
		this.add(x2Label);
		
		midFishCountLabel = new JLabel("0", JLabel.CENTER);
		midFishCountLabel.setFont(new Font("華康小花體", Font.BOLD, 58));
		midFishCountLabel.setForeground(Color.BLACK);
		midFishCountLabel.setBounds(560, 675, 60, 60);
		this.add(midFishCountLabel);
		
		JLabel littleFishLabel = new JLabel("", JLabel.CENTER);
		littleFishLabel.setIcon(imageResize(110, 60, new ImageIcon("..\\picture\\littleFish.png")));
		littleFishLabel.setBounds(700, 680, 110, 60);
		this.add(littleFishLabel);
		
		JLabel x3Label = new JLabel("x", JLabel.CENTER);
		x3Label.setFont(new Font("華康小花體", Font.BOLD, 58));
		x3Label.setForeground(Color.BLACK);
		x3Label.setBounds(790, 675, 60, 60);
		this.add(x3Label);
		
		littleFishCountLabel = new JLabel("0", JLabel.CENTER);
		littleFishCountLabel.setFont(new Font("華康小花體", Font.BOLD, 58));
		littleFishCountLabel.setForeground(Color.BLACK);
		littleFishCountLabel.setBounds(840, 675, 60, 60);
		this.add(littleFishCountLabel);

		JLabel timeImgLabel = new JLabel("", JLabel.CENTER);
		timeImgLabel.setIcon(imageResize(90, 90, new ImageIcon("..\\picture\\time.png")));
		timeImgLabel.setBounds(700, 40, 90, 90);
		this.add(timeImgLabel);
		
		timeLabel = new JLabel("30", JLabel.CENTER);
		timeLabel.setFont(new Font("華康小花體", Font.BOLD, 68));
		timeLabel.setForeground(Color.RED);
		timeLabel.setBounds(720, 50, 250, 70);
		this.add(timeLabel);
		
		startBtn = new JButton("");
		startBtn.setIcon(imageResize(80, 40, new ImageIcon(startBtnImg)));
		startBtn.setOpaque(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setBorder(null);
		startBtn.setBounds(460, 415, 80, 40);
		startBtn.addActionListener(this);
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0) {
				startBtn.setBounds(456, 413, 88, 44);
				startBtn.setIcon(imageResize(startBtn.getIcon().getIconWidth()+8,startBtn.getIcon().getIconHeight()+4,(ImageIcon)startBtn.getIcon()));
				if (startBtn.isEnabled()) {
					buttonSound();
				}
			} 
            @Override
            public void mouseExited(MouseEvent arg0) {
        		startBtn.setBounds(460, 415, 80, 40);
				startBtn.setIcon(imageResize(80, 40, new ImageIcon(startBtnImg)));
            } 
		});
		this.add(startBtn);
		
		startLabel = new JLabel("", JLabel.CENTER);
		startLabel.setIcon(imageResize(550, 450, new ImageIcon("..\\picture\\pondGameStart.png")));
		startLabel.setBounds(225, 125, 550, 450);
		this.add(startLabel);
		
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
		gameBar.setVisible(false);
		this.add(gameBar);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == ' ') {
					sliderTimer.cancel();
					if (gameBar.getValue() >= fishStart && gameBar.getValue() <= fishEnd) {
						imageCondition = ImageCondition.GOT;
					}
					else {
						imageCondition = ImageCondition.WRONG;
					}
				}
			}
		});
	}
	
	private void timerStart() {
		gameCancel = false;
		bigFishCount = 0;
		bigFishCountLabel.setText(Integer.toString(bigFishCount));
		midFishCount = 0;
		midFishCountLabel.setText(Integer.toString(midFishCount));
		littleFishCount = 0;
		littleFishCountLabel.setText(Integer.toString(littleFishCount));
		time = 30;
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				timeLabel.setText(Integer.toString(time));
				if (time == 0) {
					timer.cancel();
					gameCancel = true;
					returnBtn.setEnabled(true);
					startBtn.setVisible(true);
					startLabel.setVisible(true);
					imageTimer.cancel();
					if (replay != null) {
						replay.cancel();
					}
					sliderTimer.cancel();
					gameBar.setVisible(true);
					String s1 = "恭喜釣到了 大魚x" + Integer.toString(bigFishCount) + " 中魚x" + Integer.toString(midFishCount) + " 小魚x" + Integer.toString(littleFishCount);
					
					int width = 35;
					int padSize = width - s1.length();
					int padStart = padSize / 2 + s1.length();
					s1 = String.format("%" + padStart + "s", s1);
					s1 = String.format("%-" + width + "s", s1);
					
					int getMoney = bigFishCount * 40 + midFishCount * 20 + littleFishCount * 10;
					String s2 = "共獲得了" + Integer.toString(getMoney) + "金錢";
					width = 35;
					padSize = width - s2.length();
					padStart = padSize / 2 + s2.length();
					s2 = String.format("%" + padStart + "s", s2);
					s2 = String.format("%-" + width + "s", s2);
					JOptionPane.showMessageDialog(mainFrame, s1 + "\n" + s2, "遊戲結束", JOptionPane.INFORMATION_MESSAGE);
					
					warehouse.editHoldMoney(getMoney);
				}
				time--;
			}
		}, 0, 1000);
		gameBar.setVisible(true);
		imageStart();
	}
	
	private void gameBarStart() {
		int randValue = rand.nextInt(12);
		int fishValue;
		if (randValue < 2) {
			fishValue = 0;
		}
		else if (randValue < 6) {
			fishValue = 1;
		}
		else {
			fishValue = 2;
		}
		fishCate = fishCategories.values()[fishValue];
		switch(fishCate) {
		case BIG:
			fishStart = rand.nextInt(270 - 40) + 10;
			break;
		case MID:
			fishStart = rand.nextInt(270 - 50) + 10;
			break;
		case SMALL:
			fishStart = rand.nextInt(270 - 65) + 10;
			break;
		}
		sliderValue = 135;
		runTo = 1;
		gameBar.setValue(sliderValue);
		sliderTimer = new Timer();
		sliderTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (gameCancel) {
					sliderTimer.cancel();
				}
				if (sliderValue >= 0 && sliderValue <= 269) {
					sliderValue = sliderValue + runTo;
				}
				else {
					runTo *= -1;
					sliderValue = sliderValue + runTo;
				}
				gameBar.setValue(sliderValue);
			}
		}, 0, 2);
	}
	
	private void imageStart() {
		imageCondition = ImageCondition.FISHING;
		imageCount = 0;
		gameBarStart();
		imageTimer = new Timer();
		imageTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				bgLabel.setIcon(iconList.get(imageCount));
				imageCount++;
				
				if (gameCancel) {
					imageTimer.cancel();
					replay.cancel();
				}
				
				if (imageCondition == ImageCondition.FISHING) {
					if (imageCount == 20) {
						imageCount = 0;
					}
				}
				else if (imageCondition == ImageCondition.GOT) {
					if (imageCount == 54 && gameCancel == false) {
						if (fishCate ==  fishCategories.BIG) {
							bigFishCount++;
							bigFishCountLabel.setText(Integer.toString(bigFishCount));
						}
						else if (fishCate ==  fishCategories.MID) {
							midFishCount++;
							midFishCountLabel.setText(Integer.toString(midFishCount));
						}
						else if (fishCate ==  fishCategories.SMALL) {
							littleFishCount++;
							littleFishCountLabel.setText(Integer.toString(littleFishCount));
						}
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
			if (this.warehouse.getHoldMoney() >= 30) {
				this.warehouse.editHoldMoney(-30);
				startBtn.setVisible(false);
				startBtnImg = "..\\picture\\pondGameAgainBtn.png";
	    		startBtn.setBounds(460, 415, 80, 40);
				startBtn.setIcon(imageResize(80, 40, new ImageIcon(startBtnImg)));
				startLabel.setVisible(false);
				returnBtn.setEnabled(false);
				timerStart();
			}
			else {
				JOptionPane.showMessageDialog(this.mainFrame, "沒有足夠的金錢!!!!", "金錢不足", JOptionPane.WARNING_MESSAGE);
			}
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
			
			switch (fishCate) {
			case NO:
				break;
			case BIG:
				int width = 20;
				g.setColor(Color.RED);
				g.fillRect(fishStart + shift, this.trackRect.y + 1, width, this.trackRect.height - 1);
				g.setColor(Color.BLACK);
				g.drawRect(fishStart + shift, this.trackRect.y, width, this.trackRect.height);
				fishEnd = fishStart + 20;
				break;
			case MID:
				int width1 = 30;
				g.setColor(Color.YELLOW);
				g.fillRect(fishStart + shift, this.trackRect.y + 1, width1, this.trackRect.height - 1);
				g.setColor(Color.BLACK);
				g.drawRect(fishStart + shift, this.trackRect.y, width1, this.trackRect.height);
				fishEnd = fishStart + 30;
				break;
			case SMALL:
				int width2 = 45;
				g.setColor(Color.CYAN);
				g.fillRect(fishStart + shift, this.trackRect.y + 1, width2, this.trackRect.height - 1);
				g.setColor(Color.BLACK);
				g.drawRect(fishStart + shift, this.trackRect.y, width2, this.trackRect.height);
				fishEnd = fishStart + 45;
				break;
			}
		}
		
		@Override
		public void paintThumb(Graphics g) {
			g.setColor(Color.BLACK);
			//g.fillRect(this.thumbRect.x + shift, this.thumbRect.y, 1, this.thumbRect.height);
			g.fillRect(this.thumbRect.x + shift, this.thumbRect.y, 1, this.thumbRect.height);
		}
	}
}