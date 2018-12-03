package java2018.finalProject;
import java.util.ArrayList;

public class AnimalTest2 {
	public static void main(String[] args) {
		ArrayList<Animal> animal = new ArrayList<Animal>();
		int [] arr = new int[2];
		int test=5;
		animal.add(new Pig());
		arr[0] = (int) (Math.random()*50+1);
		arr[1] = (int) (Math.random()*50+1);
		int count, sum;
		int derection; //left1 down2 right3 up4
		//animal.get(0).print(arr);
		while(test>0)
		{
			derection = (int)(Math.random()*4+1);
			sum = (int) (Math.random()*5+1);
			count = 5;
			for(int i=1;i<sum;i++)
			{
				/*animal.get(0).moving(arr, count, derection);
				animal.get(0).print(arr);
				animal.get(0).makeDelay();*/
			}
			test--;
		}
		
	}
}
