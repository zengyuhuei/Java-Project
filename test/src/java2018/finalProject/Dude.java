package java2018.finalProject;
import java.util.ArrayList;

public class Dude {
	 WareHouse house;
	 ArrayList<Animal> pondLand = new ArrayList<Animal>(10);
	 private int num=0;
	 public Dude(WareHouse house) {   
		 this.house=house;
     }
	 public ArrayList< Animal> getPondLand() //�^��PondLand���
     {
		return  pondLand;
     	
     }
	 public boolean capturing(int number)
	 {
		 if(pondLand.get(number-1).getGrowingRate()==100)
		 {
			 house.addAnimal(pondLand.get(number-1));
			 pondLand.remove(number-1);
			 num--;
			 return true;
		 }
			 
		 else 
			 return false;
	 }
	 public boolean startFeedPig(Animal animal)
	 {
		 
		 if(num==10) {
			 return false;
		 }
		 if(animal.getName()=="豬")
		 {
			if(house.getYoungPigNumber()>0)
			{
				pondLand.add(animal);
				num++;
				house.removeYoungAnimal (animal.getName());
				return true;
			}
			else
			{
				System.out.println("倉庫沒有豬啦!!!!!");
				return false;
			}
			
		 }
		 return false;
	 }
	 public boolean startFeedChicken(Animal animal)
	 {
		 
		 if(num==10) {
			 return false;
		 }
		 if(animal.getName()=="雞")
		 {
			if(house.getYoungChickenNumber()>0)
			{
				pondLand.add(animal);
				num++;
				house.removeYoungAnimal (animal.getName());
				return true;
			}
			else
			{
				System.out.println("倉庫沒有雞啦!!!!!");
				return false;
			}
			
		 }
		 return false;
	 }
	 public boolean startFeedCow(Animal animal)
	 {
		 
		 if(num==10) {
			 return false;
		 }
		 if(animal.getName()=="牛")
		 {
			if(house.getYoungCowNumber()>0)
			{
				pondLand.add(animal);
				num++;
				house.removeYoungAnimal (animal.getName());
				return true;
			}
			else
			{
				System.out.println("倉庫沒有牛啦!!!!!");
				return false;
			}
			
		 }
		 return false;
	 }
	 public int getNum()
	 {
		 return num;
	 }

}
