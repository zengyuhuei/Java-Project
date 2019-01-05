package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class EnterGameScreen extends JPanel {
	
	Main mainFrame;
	
	public void buttonSound()
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
	 public void cleanButtom(JButton button)
	    {
	    	button.setOpaque(false);
			button.setContentAreaFilled(false);
			button.setFocusPainted(false);
			button.setBorder(null);
	    }
	public ImageIcon resizeImage(int width, int height, ImageIcon img)
	{
		Image i = img.getImage();
		Image new_img = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return  new ImageIcon(new_img);
		
	}
 
	public EnterGameScreen(Main mainFrame) {
		this.mainFrame = mainFrame;
		this.setSize(1200, 703);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		JButton btnEnter = new JButton();
		cleanButtom(btnEnter);
		btnEnter.setBounds(90, 31, 374, 174);
		btnEnter.setIcon(new ImageIcon("../picture/new_game.png"));
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String name = JOptionPane.showInputDialog(mainFrame, "請輸入遊戲名稱", "開始遊戲", JOptionPane.QUESTION_MESSAGE);
				if (name == null) {
					return;
				}
				while (name.equals(new String(""))) {
					name = JOptionPane.showInputDialog(mainFrame, "請輸入遊戲名稱", "開始遊戲", JOptionPane.QUESTION_MESSAGE);
					if (name == null) {
						return;
					}
				}
				mainFrame.setEnterName(name);
				mainFrame.setWarehouse(createWareHouse());
				
				mainFrame.changeToMainScreen();
			}
			@Override
            public void mouseEntered(MouseEvent arg0) {
				 buttonSound();
				 setCursor(new Cursor(Cursor.HAND_CURSOR));
				 btnEnter.setIcon(resizeImage(btnEnter.getIcon().getIconWidth()+10,btnEnter.getIcon().getIconHeight()+10,(ImageIcon)btnEnter.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	btnEnter.setIcon(new ImageIcon("../picture/new_game.png"));
            	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            } 
		});
		this.add(btnEnter);
		
		JButton btnLoad = new JButton();
		cleanButtom(btnLoad);
		btnLoad.setBounds(100, 218, 364, 157);
		btnLoad.setIcon(new ImageIcon("../picture/load_game.png"));
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = JOptionPane.showInputDialog(mainFrame, "請輸入遊戲名稱", "載入遊戲", JOptionPane.QUESTION_MESSAGE);
				mainFrame.setEnterName(name);
				FileReader fr;
				try {
					fr = new FileReader("file\\" + name + ".txt");
					BufferedReader br = new BufferedReader(fr);
					Map<String, Integer> warehouseData = new HashMap<String, Integer>();
					String temp;
					while (!Objects.equals(temp = br.readLine(),"牧場資料")) {
						int temp1 = Integer.parseInt(br.readLine());
						warehouseData.put(temp, temp1);
					}
					String [][] dudeScreenData = new String[10][3];
					for (int i = 0; i < 10; i++) {
						for(int j = 0; j < 3; j++) {
							dudeScreenData[i][j] = br.readLine();
						}
					}
					String test = br.readLine();
					String [][] farmScreenData = new String[13][3];
					farmScreenData[12][0] = br.readLine();
					for (int i = 0; i < Integer.parseInt(farmScreenData[12][0]); i++) {
						for (int j = 0; j < 3; j++) {
							farmScreenData[i][j] = br.readLine();
						}
					}
					mainFrame.setWarehouse(new WareHouse(warehouseData));
					mainFrame.setFarmScreen(farmScreenData);
					System.out.println("農場完成");
					mainFrame.setDudeScreen(dudeScreenData);
					System.out.println("牧場完成");
					mainFrame.changeToMainScreen();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(mainFrame, "找不到此遊戲名稱", "檔案錯誤", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(mainFrame, "找不到此遊戲名稱", "檔案錯誤", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}
			}
			@Override
            public void mouseEntered(MouseEvent arg0) {
				 buttonSound();
				 setCursor(new Cursor(Cursor.HAND_CURSOR));
				 btnLoad.setIcon(resizeImage(btnLoad.getIcon().getIconWidth()+10,btnLoad.getIcon().getIconHeight()+10,(ImageIcon)btnLoad.getIcon()));
            } 
            @Override
            public void mouseExited(MouseEvent arg0) {
            	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            	btnLoad.setIcon(new ImageIcon("../picture/load_game.png"));
            } 
		});
		this.add(btnLoad);
		
		JLabel background = new JLabel();
		background.setSize(1200,703);
		
		background.setIcon(resizeImage(1200,703,new ImageIcon("../picture/enter.jpg")));
		
		this.add(background);
	}
	
	private WareHouse createWareHouse() {
		WareHouse wareHouse = new WareHouse();
		Animal a = new Cow();
		Animal b = new Chicken();
		Animal c = new Cow();
		Animal e = new Chicken();
		Animal pig = new Pig();
		
		
		Feed f = new SimpleFeed();
		Feed j = new GeneralFeed();
		Feed g = new SimpleFeed();
		Feed h = new AdvancedFeed();
		Feed i = new SimpleFeed();
		
		Crop k = new Corn();
		Crop m = new Corn();
		Crop n = new Wheat();
		Crop o = new Cabbage();
		Crop corn = new Corn();
		
		a.setGrowingRate100();
		c.setGrowingRate100();
		b.setGrowingRate100();
		e.setGrowingRate100();
		pig.setGrowingRate100();
		
		
		wareHouse.addAnimal(a);
		wareHouse.addAnimal(c);
		wareHouse.addAnimal(b);
		wareHouse.addAnimal(e);
		wareHouse.addAnimal(pig);
		
		wareHouse.addFeed(f);
		wareHouse.addFeed(g);
		wareHouse.addFeed(h);
		wareHouse.addFeed(i);
		wareHouse.addFeed(j);
		
		
		n.setGrowingRate100();
		o.setGrowingRate100();
		k.setGrowingRate100();		
		m.setGrowingRate100();
		
		wareHouse.addCrop(k); //corn
		wareHouse.addCrop(m); //corn
		wareHouse.addCrop(n); //wheat
		wareHouse.addCrop(o); //cabbage
		wareHouse.addSeed(corn);
		wareHouse.removeSeed("玉米");
		return wareHouse;
	}
}
