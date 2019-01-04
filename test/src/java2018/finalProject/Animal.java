package java2018.finalProject;

public abstract class Animal extends Object {
    private int growingRate;
    //Private Date lastFeedDate;

    private String name;
    public Animal(String name) {
      this.name=name;
      growingRate=0;
    }
    public void setName(String name)
    {
    	this.name = name;
    }
    public String getName()
    {
      return name;
    }
    public int getGrowingRate()
    {
      return growingRate;
    }

  	public void setGrowingRate(int growingRate)
  	{
  		this.growingRate = growingRate;
  	}
  	
  	public void setGrowingRate100()
  	{
  		growingRate = 100;
  	}
  	public boolean feeding(Feed feed)
    {
  		System.out.print("a");
    	if(growingRate<100)
    	{
    		growingRate+=feed.getNutrition();
    		if(growingRate>100)setGrowingRate100();
    		return true;
    	}
    	
		return false;
    	
    }


   	public boolean equals(Object obj) { 
   	    if (obj == null) return false;
   	    if (obj == this) return true;
   	    if (!(obj instanceof Animal)) return false;
   	    Animal o = (Animal) obj;
   	    return o.getName() == this.name;
   	}
}