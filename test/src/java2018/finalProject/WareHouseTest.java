package java2018.finalProject;

public class WareHouseTest {

	public static void main(String[] args) {
		WareHouse wareHouse = new WareHouse();
		Animal a = new Cow();
		Animal b = new Pig();
		Animal c = new Pig();
		Animal e = new Chicken();
		a.setGrowingRate();
		c.setGrowingRate();
		wareHouse.addAnimal(a);
		wareHouse.addAnimal(a);
		wareHouse.addYoungAnimal(b);
		wareHouse.addYoungAnimal(e);
		System.out.println(wareHouse.getYoungCowNumber());
		System.out.println(wareHouse.getChickenNumber());
	}

}
