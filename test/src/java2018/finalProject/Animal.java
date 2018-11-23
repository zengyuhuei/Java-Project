package java2018.finalProject;


public abstract class Animal extends Object {
    private int growingRate;
    //Private Date lastFeedDate;
    private String name;
    public Animal(String name) {
      this.name=name;
      growingRate=-1;
    }
    public String getName()
    {
      return name;
    }
    public int getGrowingRate()
    {
      return growingRate;
    }
    

  	public void setGrowingRate()
  	{
  		growingRate = 100;
  	}
  	

    //check which Animal is equal to the member of the list

   	public boolean equals(Object obj) { 
   	    if (obj == null) return false;
   	    if (obj == this) return true;
   	    if (!(obj instanceof Animal)) return false;
   	    Animal o = (Animal) obj;
   	    return o.getName() == this.name;
   	}
   	
    public boolean feeding(Feed feed)
    {
    	if(growingRate<100)
    	{
    		growingRate+=feed.getNutrition();
    		if(growingRate>100)setGrowingRate();
    		return true;
    	}
    	else return false;
    	
    }
    public void moving()
    {
    	
    }
    //public abstract int getEarnings();
}