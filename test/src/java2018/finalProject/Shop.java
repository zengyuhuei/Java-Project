package java2018.finalProject;




public class Shop {

	
	private WareHouse warehouse ;
	public Shop(WareHouse warehouse) {
		this.warehouse = warehouse;
		
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
			System.out.printf("倉庫增加了%d顆%s\n",num,cp.getName());
			return true;
		}
		catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
	}
	public Animal newCow()
	{
		return new Cow();
	}
	public Animal newPig()
	{
		return new Pig();
	}
	public Animal newChicken()
	{
		return new Chicken();
	}
	public Feed newSimpleFeed()
	{
		return new SimpleFeed();
	}
	public Feed newGeneralFeed()
	{
		return new GeneralFeed();
	}
	public Feed newAdvancedFeed()
	{
		return new AdvancedFeed();
	}
	public Crop newWheat()
	{
		return new Wheat();
	}
	public Crop newCorn()
	{
		return new Corn();
	}
	public Crop newCabbage()
	{
		return new Cabbage();
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
			System.out.printf("倉庫增加了%d隻%s\n",num,an.getName());
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
			System.out.printf("倉庫增加了%d顆%s\n",num,fd.getName());
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
		}
		System.out.printf("倉庫增加了%d顆肥料\n",num);
		return true;
	}
	//remove animals from warehouse
	public boolean removeAnimal(String name, int num)
	{
		try
		{
			int i;
			for(i = 0;i < num; i++)
			{
				warehouse.removeAnimal(name);	
				
			}
			System.out.printf("倉庫減少了%d隻%s\n",num,name);
			return true;
		}
		catch(Exception e)
	    {
			System.out.println(e.getMessage());
		    return false;
	    }
		
	}
	
	
	//remove crops from warehouse
	public boolean removeCrop(String name, int num)
	{
		try
		{
			int i;
			for(i = 0;i < num; i++)
			{
				warehouse.removeCrop(name);				
			}
			System.out.printf("倉庫減少了%d株%s\n",num,name);
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
			System.out.printf("花了多少錢%d\n",num);
			return true;
		}
		catch(Exception e)
	    {
			System.out.println(e.getMessage());
		    return false;
	    }
	}
	
	public int getHoldMoney()
	{
		return warehouse.getHoldMoney();
	}
}
