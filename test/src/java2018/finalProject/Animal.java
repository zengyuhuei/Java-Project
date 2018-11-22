package java2018.finalProject;


public abstract class Animal extends Object {
    private int growingRate;
    //Private Date lastFeedDate;
    private String name;
    public Animal(String name) {
      this.name=name;
      growingRate=0;
    }
    public String getName()
    {
      return name;
    }
    public int getGrowingRate()
    {
      return growingRate;
    }
    
    public boolean feeding(Feed feed)
    {
      //if()
    	growingRate+=feed.getNutrition();
    	return true;
    }
    //public abstract int getEarnings();
}