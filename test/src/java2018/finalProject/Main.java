package java2018.finalProject;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel dudeScreen;
	private JPanel farmScreen;
	private JPanel mainScreen;
	private WareHouse warehouse;
	private Clip bgClip;
	private Clip gameClip;
	
	public Main() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 703);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.mainScreen = new MainScreen(this);
		
		backgroundSound();
		gameSound();
		this.changeToEnterGameScreen();
	}
	
	public void changeToEnterGameScreen() {
		bgClip.loop(Clip.LOOP_CONTINUOUSLY);
		gameClip.stop();
		this.setTitle("登入畫面");
		this.setContentPane(new EnterGameScreen(this));
	}
	
	public void setWarehouse(WareHouse warehouse) {
		this.warehouse = warehouse;
		this.dudeScreen = new DudeScreen(this, this.warehouse);
		this.farmScreen = new FarmScreen(this, this.warehouse);
	}
	
	public void changeToMainScreen() {
		bgClip.loop(Clip.LOOP_CONTINUOUSLY);
		gameClip.stop();
		this.setTitle("主畫面");
		this.setContentPane(mainScreen);
	}
	
	public void changeToShopScreen() {
		bgClip.loop(Clip.LOOP_CONTINUOUSLY);
		gameClip.stop();
		JPanel shopScreen = new ShopScreen(this, this.warehouse);
		this.setTitle("商店");
		this.setContentPane(shopScreen);
	}
	
	public void changeToDudeScreen() {
		bgClip.loop(Clip.LOOP_CONTINUOUSLY);
		gameClip.stop();
		this.setTitle("牧場");
		this.setContentPane(dudeScreen);
	}
	
	public void changeToDudeGameScreen() {
		bgClip.stop();
		gameClip.loop(Clip.LOOP_CONTINUOUSLY);
		JPanel dudeGameScreen = new DudeGameScreen(this, this.warehouse);
		this.setTitle("牧場遊戲");
		this.setContentPane(dudeGameScreen);
	}
	
	public void changeToWareHouseScreen() {
		bgClip.loop(Clip.LOOP_CONTINUOUSLY);
		gameClip.stop();
		JPanel wareHouseScreen = new WareHouseScreen(this, this.warehouse);
		this.setTitle("倉庫");
		this.setContentPane(wareHouseScreen);
	}
	
	public void changeToPondScreen() {
		bgClip.stop();
		gameClip.loop(Clip.LOOP_CONTINUOUSLY);
		JPanel pondScreen = new PondScreen(this);
		this.setTitle("魚池");
		this.setContentPane(pondScreen);
	}
	
	public void changeToFarmScreen() {
		bgClip.loop(Clip.LOOP_CONTINUOUSLY);
		gameClip.stop();
		this.setTitle("農場");
		this.setContentPane(farmScreen);
	}

    private void backgroundSound()
    {
   	 	try {
			File soundFile = new File("..\\sound\\bg.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			bgClip = AudioSystem.getClip();
			bgClip.open(audioIn);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void gameSound()
    {
   	 	try {
			File soundFile = new File("..\\sound\\game.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			gameClip = AudioSystem.getClip();
			gameClip.open(audioIn);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		
		//  chicken*2 pig *1  cow*2  wheat*1 corn *2  cabbage *1 
		//simple *3 general*1  advanced*1
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main mainFrame = new Main();
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
