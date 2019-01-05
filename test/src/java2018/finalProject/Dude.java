package java2018.finalProject;
import java.util.ArrayList;

public class Dude {
	 WareHouse house;
	 ArrayList<Animal> pondLand = new ArrayList<Animal>(10);
	 private int num=0;
	 private int num2;
	 public Dude(WareHouse house) {   
		 this.house=house;
     }
	 public ArrayList< Animal> getPondLand() //�^��PondLand���
     {
		return  pondLand;
     	
     }
	 public boolean capturing(int number)
	 {
		 if(pondLand.get(number).getGrowingRate()==100)
		 {
			 house.addAnimal(pondLand.get(number));
			 pondLand.set(number, null);
			 num--;
			 return true;
		 }
			 
		 else 
			 return false;
	 }
	 public void startNull(int number)
	 {
		 pondLand.add(new Pig());
		 pondLand.set(number, null);
	 }
	 public void startPig(Animal animal)
	 {
		 
		 if(animal.getName()=="豬")
		 {
			pondLand.add(animal);
			num++;
		 }
		 else
		 {
			 System.out.printf("他不是豬啦!!\n");
		 }
	 }
	 public void startChicken(Animal animal)
	 {
		 
		 if(animal.getName()=="雞")
		 {
			pondLand.add(animal);
			num++;
		 }
		 else
		 {
			 System.out.printf("他不是雞啦!!\n");
		 }
	 }
	 public void startCow(Animal animal)
	 {
		 
		 if(animal.getName()=="牛")
		 {
			pondLand.add(animal);
			num++;
		 }
		 else
		 {
			 System.out.printf("他不是牛啦!!\n");
		 }
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
				System.out.println("養了一隻豬");
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
				System.out.println("養了一隻雞");
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
				System.out.println("養了一隻牛");
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
	public int getAnimalNum(ArrayList<Animal> list,String name)
	{
		int num = 0;
		for(Animal i: list)
		{
			if(i==null)
				continue;
			if(i.getName() == name)
				num++;
		}
		return num;
	}
	public int getCowNumber() 
	{
		return getAnimalNum(pondLand,"牛");
	}
	//get the number of pig
	public int getPigNumber() 
	{
		return getAnimalNum(pondLand,"豬");
	}
	//get the number of chicken
	public int getChickenNumber() 
	{
		return getAnimalNum(pondLand,"雞");
	}
	public boolean getNullNum(Animal animal, WareHouse warehouse)
	{
		for(int i=0; i<pondLand.size(); i++)
		{
			if(pondLand.get(i)==null)
			{
				pondLand.set(i, animal);
				warehouse.removeYoungAnimal(animal.getName());
				num++;
				num2=i;
				return true;
			}
		}
		num2=pondLand.size();
		return false;
	}
	public int getButtonNum()
	{
		return num2;
	}

}
