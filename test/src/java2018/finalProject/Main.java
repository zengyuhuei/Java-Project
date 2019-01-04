package java2018.finalProject;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Objects;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	private String enterName = new String("");
	private boolean gameStart = false;
	
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
		//System.out.println(warehouse.getObject());
		this.dudeScreen = new DudeScreen(this, this.warehouse);
		this.farmScreen = new FarmScreen(this, this.warehouse);
	}
	
	public void changeToMainScreen() {
		gameStart = true;
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
		JPanel pondScreen = new PondScreen(this, this.warehouse);
		this.setTitle("魚池");
		this.setContentPane(pondScreen);
	}
	
	public void changeToFarmScreen() {
		bgClip.loop(Clip.LOOP_CONTINUOUSLY);
		gameClip.stop();
		this.setTitle("農場");
		this.setContentPane(farmScreen);
	}
	
	public void changeToFarmGameScreen() {
		bgClip.stop();
		gameClip.loop(Clip.LOOP_CONTINUOUSLY);
		this.setTitle("除蟲遊戲");
		JPanel FarmGameScreen = new FarmGameScreen(this, this.warehouse);
		this.setContentPane(FarmGameScreen);
	}
	
	public void saveFile() {
		while (Objects.equals(enterName, new String("")))
			enterName = JOptionPane.showInputDialog(this, "請輸入儲存的檔案名稱", "存檔", JOptionPane.YES_OPTION);
		
		PrintWriter writer;
		try {
			writer = new PrintWriter("file\\" + enterName + ".txt", "UTF-8");
			Map<String, Integer> warehouseData = this.warehouse.getObject();
			for (String key : warehouseData.keySet()) {
				writer.println(key);
				writer.println(warehouseData.get(key));
			}
			writer.println("牧場資料");
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean getGameStart() {
		return this.gameStart;
	}
	
	public void setEnterName(String name) {
		this.enterName = name;
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
					
					mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
					    @Override
					    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					    	if (mainFrame.getGameStart()) {
						        if (JOptionPane.showConfirmDialog(mainFrame, 
						            "是否要存檔並關閉視窗?", "關閉視窗", 
						            JOptionPane.YES_NO_OPTION,
						            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
						        	mainFrame.saveFile();
						        }
					    	}
				            System.exit(0);
					    }
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
