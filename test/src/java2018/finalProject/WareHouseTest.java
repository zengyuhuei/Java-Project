package java2018.finalProject;

import java.awt.EventQueue;

public class WareHouseTest {

	public static void main(String[] args) {
		WareHouse wareHouse = new WareHouse();
		Animal a = new Cow();
		Animal b = new Chicken();
		Animal c = new Cow();
		Animal e = new Chicken();
		Animal pig = new Pig();
		
		/*
		Feed f = new SimpleSeed();
		Feed j = new GeneralSeed();
		Feed g = new SimpleSeed();
		Feed h = new AdvancedSeed();
		Feed i = new SimpleSeed();
		*/
		Crop k = new Corn();
		Crop m = new Corn();
		Crop n = new Wheat();
		Crop o = new Cabbage();
		a.setGrowingRate();
		c.setGrowingRate();
		b.setGrowingRate();
		e.setGrowingRate();
		pig.setGrowingRate();
		
		wareHouse.addAnimal(a);
		wareHouse.addAnimal(c);
		wareHouse.addAnimal(b);
		wareHouse.addAnimal(e);
		wareHouse.addAnimal(pig);
		/*
		wareHouse.addFeed(f);
		wareHouse.addFeed(g);
		wareHouse.addFeed(h);
		wareHouse.addFeed(i);
		wareHouse.addFeed(j);
		*/
		n.setGrowingRate();
		o.setGrowingRate();
		k.setGrowingRate();		
		m.setGrowingRate();
		
		wareHouse.addCrop(k); //corn
		wareHouse.addCrop(m); //corn
		wareHouse.addCrop(n); //wheat
		wareHouse.addCrop(o); //cabbage
		
		//  chicken*2 pig *1  cow*2  wheat*1 corn *2  cabbage *1 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopScreen frame = new ShopScreen(wareHouse);
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println(wareHouse.getChickenNumber());
		System.out.println(wareHouse.getPigNumber());
		System.out.println(wareHouse.getCowNumber());
		System.out.println(wareHouse.getWheatNumber());
		System.out.println(wareHouse.getCornNumber());
		System.out.println(wareHouse.getCabbageNumber());
		//System.out.println(wareHouse.getGeneralFeedNumber());
		//System.out.println(wareHouse.getSimpleFeedNumber());
		//System.out.println(wareHouse.getSimpleFeedNumber());
		//System.out.println(wareHouse.getCornSeedNumber());
		//System.out.println(wareHouse.getCabbageNumber());
		//System.out.println(wareHouse.getCornNumber());
		//System.out.println(wareHouse.getWheatNumber());
	}

}
