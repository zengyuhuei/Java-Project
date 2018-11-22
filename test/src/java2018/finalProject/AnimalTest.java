package java2018.finalProject;

import java.util.ArrayList;

public class AnimalTest {
	public static void main(String[] args) {
		ArrayList<Animal> animal = new ArrayList<Animal>();
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
		
		//System.out.println(a);
	}
}
