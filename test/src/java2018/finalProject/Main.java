package java2018.finalProject;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	public Main(WareHouse warehouse) {
		this.warehouse = warehouse;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 675);
		this.setLocationRelativeTo(null);
		
		this.dudeScreen = new DudeScreen(this, this.warehouse);
		this.farmScreen = new FarmScreen(this, this.warehouse);
		this.mainScreen = new MainScreen(this);
		
		this.changeToMainScreen();
	}
	
	public void changeToMainScreen() {
		this.setTitle("主畫面");
		this.setContentPane(mainScreen);
	}
	
	public void changeToShopScreen() {
		JPanel shopScreen = new ShopScreen(this, this.warehouse);
		this.setTitle("商店");
		this.setContentPane(shopScreen);
	}
	
	public void changeToDudeScreen() {
		this.setTitle("牧場");
		this.setContentPane(dudeScreen);
	}
	
	public void changeToWareHouseScreen() {
		JPanel wareHouseScreen = new WareHouseScreen(this, this.warehouse);
		this.setTitle("倉庫");
		this.setContentPane(wareHouseScreen);
	}
	
	public void changeToPondScreen() {
		JPanel pondScreen = new PondScreen(this);
		this.setTitle("魚池");
		this.setContentPane(pondScreen);
	}
	
	public void changeToFarmScreen() {
		this.setTitle("農場");
		this.setContentPane(farmScreen);
	}
	
	
	public static void main(String[] args) {
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
		//  chicken*2 pig *1  cow*2  wheat*1 corn *2  cabbage *1 
		//simple *3 general*1  advanced*1
		
		

		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main mainFrame = new Main(wareHouse);
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
