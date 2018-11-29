package java2018.finalProject;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		

			
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
		
		//  chicken*2 pig *1  cow*2  wheat*1 corn *2  cabbage *1 
		//simple *3 general*1  advanced*1
		
		

		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen mainscreen = new MainScreen(wareHouse);
					mainscreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
