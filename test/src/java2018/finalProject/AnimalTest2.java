package java2018.finalProject;
import java.util.ArrayList;

public class AnimalTest2 {
	public static void main(String[] args) {
		ArrayList<Animal> animal = new ArrayList<Animal>();
		animal.add(new Pig());
		animal.get(0).moving();
	}
}
