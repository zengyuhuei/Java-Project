package java2018.finalProject;



public class AnimalTest {
	public static void main(String[] args) {
		WareHouse wareHouse = new WareHouse();
		/*ArrayList<Animal> animal = new ArrayList<Animal>();
		
		animal.add(new Pig());
		animal.add(new Chicken());
		animal.add(new Pig());
		animal.add(new Cow());
		//WareHouse house;
		//Dude dude(house);
		Feed feed1=new SimpleSeed();
		Feed feed2=new GeneralSeed();
		Feed feed3=new AdvancedSeed();
		animal.get(1).feeding(feed1);
		animal.get(2).feeding(feed2);		
		animal.get(1).feeding(feed3);
		animal.get(1).feeding(feed3);
		animal.get(1).feeding(feed3);
		animal.get(1).feeding(feed3);
		animal.get(1).feeding(feed3);
		animal.get(1).feeding(feed3);
		animal.get(1).feeding(feed3);
		for(Animal an: animal)
		{
			System.out.println(an.getName());
			System.out.println(an.getGrowingRate());
		}
		
		//System.out.println(a);*/
		Feed feed1=new SimpleSeed();
		Feed feed2=new GeneralSeed();
		Feed feed3=new AdvancedSeed();
		Animal cow = new Cow();
		Animal pig = new Pig();
		Animal chicken = new Chicken();
		
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
		wareHouse.addYoungAnimal(chicken);
		
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
		Dude dude = new Dude(wareHouse);
		dude.startFeedChicken(chicken);
		//dude.startFeedPig(pig);
		wareHouse.addCrop(o); //cabbage
		chicken.feeding(feed3);
		chicken.feeding(feed3);
		chicken.feeding(feed3);
		chicken.feeding(feed3);
		chicken.feeding(feed3);
		chicken.feeding(feed3);
		chicken.feeding(feed3);
		//dude.getPondLand();
		System.out.printf("%d\n", dude.getNum());
		dude.capturing(chicken);
		System.out.printf("%d\n", dude.getNum());
		System.out.println("ouo");
	}
}
