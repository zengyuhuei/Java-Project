package java2018.finalProject;

import java.util.*;

public class Shop {

	private Dictionary<String, Integer> soldList = new Hashtable<String, Integer>();
	private Dictionary<String, Integer> boughtList = new Hashtable<String, Integer>();
	private WareHouse warehouse = new WareHouse();
	public Shop() {
		boughtList.put("低級種子", 5);
		boughtList.put("中級種子",  8);
		boughtList.put("高級種子", 15);
		boughtList.put("豬", 30);
		boughtList.put("牛", 50);
		boughtList.put("雞", 20);
		boughtList.put("小麥", 5);
		boughtList.put("玉米", 10);
		boughtList.put("高麗菜", 15);
		boughtList.put("肥料", 20);
		soldList.put("小麥", 10);
		soldList.put("玉米", 30);
		soldList.put("高麗菜", 50);
		soldList.put("牛", 230);
		soldList.put("豬", 210);
		soldList.put("雞", 200);
	}
	
	public Dictionary<String, Integer> getSoldList()
	{
		return soldList;
	}
	
	public Dictionary<String, Integer> getBoughtList()
	{
		return boughtList;
	}
	//new seed and add it into warehouse
	public boolean addSeed(Crop cp, int num)
	{
		try
		{
			int i;
			for(i = 0;i < num; i++)
			{
				warehouse.addSeed(cp);
			}
			return true;
		}
		catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
	}
	
	//new young animals and add them into warehouse
	public boolean addYoungAnimal(Animal an, int num)
	{
		try
		{
			int i;
			for(i = 0;i < num; i++)
			{
				warehouse.addYoungAnimal(an);				
			}
			return true;
		}
		catch(Exception e)
	    {
			System.out.println(e.getMessage());
		    return false;
	    }
		
	}
	
	
	
	//new feed and add them into warehouse
	public boolean addFeed(Feed fd, int num)
	{
		try
		{
			int i;
			for(i = 0;i < num; i++)
			{
				warehouse.addFeed(fd);				
			}
			return true;
		}
		catch(Exception e)
	    {
			System.out.println(e.getMessage());
		    return false;
	    }
		
	}
	
	//add the number of fertilize
	public boolean addFertilizer(int num)
	{
		if(num <= 0) return false;
		else {
			warehouse.editFertilizer(num);
			return true;
		}
	}
	//remove animals from warehouse
	public boolean removeAnimal(Animal an, int num)
	{
		try
		{
			int i;
			for(i = 0;i < num; i++)
			{
				warehouse.removeAnimal(an);				
			}
			return true;
		}
		catch(Exception e)
	    {
			System.out.println(e.getMessage());
		    return false;
	    }
		
	}
	
	
	//remove crops from warehouse
	public boolean removeCrop(Crop cp, int num)
	{
		try
		{
			int i;
			for(i = 0;i < num; i++)
			{
				warehouse.removeCrop(cp);				
			}
			return true;
		}
		catch(Exception e)
	    {
			System.out.println(e.getMessage());
		    return false;
	    }
	}
	
   //the following six functions is the limitation that can be sold out  
	public int getCabbageNumber()
	{
		return warehouse.getCabbageNumber();
	}
	
	public int getCornNumber()
	{
		return warehouse.getCornNumber();
	}
	public int getWheatNumber()
	{
		return warehouse.getWheatNumber();
	}
	public int getPigNumber()
	{
		return warehouse.getPigNumber();
	}
	public int getCowNumber()
	{
		return warehouse.getCowNumber();
	}
	public int getChickenNumber()
	{
		return warehouse.getChickenNumber();
	}
	
	//if this action is shopping, the number must be negative
	//or it must be positive
	//function in warehouse just directly add the number 
	public boolean editHoldingMoney(int num)
	{
		try
		{
			warehouse.editHoldMoney(num);
			return true;
		}
		catch(Exception e)
	    {
			System.out.println(e.getMessage());
		    return false;
	    }
	}
}
