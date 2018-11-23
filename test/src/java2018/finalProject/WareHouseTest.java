package java2018.finalProject;

public class WareHouseTest {

	public static void main(String[] args) {
		WareHouse wareHouse = new WareHouse();
		Animal a = new Cow();
		Animal b = new Chicken();
		Animal c = new Cow();
		Animal e = new Chicken();
		
		Feed f = new SimpleSeed();
		Feed j = new GeneralSeed();
		Feed g = new SimpleSeed();
		Feed h = new AdvancedSeed();
		Feed i = new SimpleSeed();
		
		Crop k = new Corn();
		Crop m = new Corn();
		Crop n = new Wheat();
		Crop o = new Cabbage();
		a.setGrowingRate();
		c.setGrowingRate();
		wareHouse.addAnimal(a);
		wareHouse.addAnimal(c);
		wareHouse.addYoungAnimal(b);
		wareHouse.addYoungAnimal(e);
		
		wareHouse.addFeed(f);
		wareHouse.addFeed(g);
		wareHouse.addFeed(h);
		wareHouse.addFeed(i);
		wareHouse.addFeed(j);
		
		n.setGrowingRate();
		o.setGrowingRate();
		wareHouse.addSeed(k); //corn
		wareHouse.addSeed(m); //corn
		wareHouse.addCrop(n); //wheat
		wareHouse.addCrop(o); //cabbage
		
		wareHouse.removeCrop(o);
		
		
		wareHouse.removeYoungAnimal(e);
		System.out.println(wareHouse.getCowNumber());
		System.out.println(wareHouse.getYoungChickenNumber());
		System.out.println(wareHouse.getYoungCowNumber());
		System.out.println(wareHouse.getAdvencedFeedNumber());
		System.out.println(wareHouse.getGeneralFeedNumber());
		System.out.println(wareHouse.getSimpleFeedNumber());
		System.out.println(wareHouse.getSimpleFeedNumber());
		System.out.println(wareHouse.getCornSeedNumber());
		System.out.println(wareHouse.getCabbageNumber());
		System.out.println(wareHouse.getCornNumber());
		System.out.println(wareHouse.getWheatNumber());
	}

}
