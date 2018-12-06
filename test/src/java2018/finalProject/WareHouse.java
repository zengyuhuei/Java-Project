package java2018.finalProject;

import java.util.ArrayList;



public class WareHouse {
	private ArrayList<Crop> cropSeedList = new ArrayList<Crop>(); 
	private ArrayList<Animal> youngAnimalList = new ArrayList<Animal>();  
	private ArrayList<Crop> cropList = new ArrayList<Crop>();
	private ArrayList<Animal> AnimalList = new ArrayList<Animal>(); 
	public static final int isMatured = 100; 
	public static final int unMatured = -1; 

	private ArrayList<Feed> feedList = new ArrayList<Feed>();
	private int fertilizerNumber;
	private int holdMoney; 
	
	
	
	public WareHouse()
	{
		this.holdMoney = 1000;
		this.fertilizerNumber = 0;
		
		
	}
	//return the number of the wheat, corns or cabbages
	public int getCropNum(ArrayList<Crop> list,String name)
	{
		int num = 0;
		for(Crop i: list)
		{
			if(i.getName() == name)
				num++;
		}
		return num;
	}
	//return the number of the cows, pigs or chickens
	public int getAnimalNum(ArrayList<Animal> list,String name)
	{
		int num = 0;
		for(Animal i: list)
		{
			if(i.getName() == name)
				num++;
		}
		return num;
	}
	
	public int getSeedNum(String name)
	{
		int num = 0;
		for(Feed i: feedList)
		{
			if(i.getName() == name)
				num++;
		}
		return num;
	}
	
	
	
	//get the number of the fertilizer
	public int getFertilizer ()  
	{
		return fertilizerNumber;
	}
	
	//edit the number of the fertilizer.
	// The parameter will be Positive or negative.
	public boolean editFertilizer (int num) 
	{
		fertilizerNumber += num;
		return true;
	}
	
	//(call by farm) add the crop to list.If success, return true, or return false
	public boolean addCrop (Crop crop) 
	{ 
		try
	    {
			if(crop.getGrowingRate() == isMatured)
			{
				cropList.add(crop);
				
			}
			return true;
	    }
		catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	
	//(call by shop) remove the crop from the list.If success, return true, or return false
	public boolean removeCrop (String name) 
	{
		
		for(Crop cp :cropList)
		{
			if(cp.getName() == name)
			{
				cropList.remove(cp);
				return true;

			}
			
		}
		
		return false;
		
	}
	
	//(call by shop) add the seed to the list.If success, return true, or return false
	public boolean addSeed(Crop crop) 
	{	
		try
	    {
			cropSeedList.add(crop);
			return true;
	    }catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	//(call by farm) remove the seed from the list.If success, return true, or return false
	public boolean removeSeed(String name) 
	{
			for(Crop cp :cropSeedList)
			{
				if(cp.getName() == name)
				{
					
					cropSeedList.remove(cp);
					return true;
				}
			}
		return false;
	}
	
	
	
	 //calculate the number of the wheat seed
	public int getWheatSeedNumber()
	{
		return getCropNum(cropSeedList, "小麥");
		
	}
	//calculate the number of the corn seed
	public int getCornSeedNumber() 
	{
		return getCropNum(cropSeedList, "玉米");
	}
	////calculate the number of the cabbage seed
	public int getCabbageSeedNumber()
	{
		return getCropNum(cropSeedList, "高麗菜");
	}
	//calculate the number of the wheat 
	public int getWheatNumber() 
	{
		return getCropNum(cropList, "小麥");
	}
	//calculate the number of the corn
	public int getCornNumber() 
	{
		return getCropNum(cropList, "玉米");
	}
	//calculate the number of the cabbage
	public int getCabbageNumber() 
	{
		return getCropNum(cropList, "高麗菜");
	}
	
	// add feed to the list. If success, return true, or return false
	public boolean addFeed (Feed fd)
	{
		try
	    {
			feedList.add(fd);
			return true;
	    }
		catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	
	//(call by pond) remove feed to the list. If success, return true, or return false
	public boolean removeFeed (String name)
	{
		
		for(Feed feed :feedList)
		{
			if(feed.getName() == name)
			{
				feedList.remove(feed);
				return true;
			}
		}
		
		return false;
	}
	//get the number of simple feed
	public int getSimpleFeedNumber() 
	{
		return getSeedNum("低級飼料");
	}
	//get the number of general feed
	public int getGeneralFeedNumber() 
	{
		return getSeedNum("中級飼料");
	}
	//get the number of advanced feed
	public int getAdvencedFeedNumber() 
	{
		return getSeedNum("高級飼料");
	}
	
	
	//(call by shop) add young animal to the list. If success, return true, or return false
	public boolean addYoungAnimal (Animal animal) 
	{
		try
	    {
			youngAnimalList.add(animal);
			return true;
	    }catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	
	//(call by Dude) remove young animal to the list. If success, return true, or return false
	public boolean removeYoungAnimal (String name) 
	 {
	  
	   for(Animal an :youngAnimalList)
	   {
	    
	    if(an.getName() == name)
	    {
	     youngAnimalList.remove(an);
	     return true;

	    }
	   }
	  
	  return false;
	 }
	
	//(call by pond) add animal to the list. If success, return true, or return false
	public boolean addAnimal (Animal animal) 
	{
		
		try
	    {
			if(animal.getGrowingRate() == isMatured)
			{
				AnimalList.add(animal);
			}
			return true;
	    }catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	
	//(call by shop) remove animal to the list. If success, return true, or return false
	public boolean removeAnimal (String name) 
	{
		
			
		for(Animal an :AnimalList)
		{
			
			if(an.getName() == name)
			{
				AnimalList.remove(an);
				return true;

			}
		}
		
		return false;
	}
	//get the number of young cow
	public int getYoungCowNumber() 
	{
		return getAnimalNum(youngAnimalList,"牛");
	}
	
	//get the number of young pig
	public int getYoungPigNumber() 
	{
		return getAnimalNum(youngAnimalList,"豬");
	}
	
	//get the number of young chicken
	public int getYoungChickenNumber()
	{
		return getAnimalNum(youngAnimalList,"雞");
	}
	//get the number of cow
	public int getCowNumber() 
	{
		return getAnimalNum(AnimalList,"牛");
	}
	//get the number of pig
	public int getPigNumber() 
	{
		return getAnimalNum(AnimalList,"豬");
	}
	//get the number of chicken
	public int getChickenNumber() 
	{
		return getAnimalNum(AnimalList,"雞");
	}
	
	//get the holding money
	public int getHoldMoney() 
	{
		return holdMoney;
	}
	//edit the holding money.If success, return true, or return false
	public Boolean editHoldMoney(int cost) 
	{
		holdMoney += cost;
		return true;
	}





}
