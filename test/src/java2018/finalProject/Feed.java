package java2018.finalProject;

public abstract class Feed {
	private int nutrition; 
	private String name; //store the type of the feed
	
	public Feed(int nutrition, String name)
	{
		this.nutrition = nutrition;
		this.name = name;
	}
	//get the name
	public String getName()  
	{
		return name;
	}
	//get the nutrition
	public int getNutrition()  
	{
		return nutrition;
	}
	
	//check which feed is equal to the member of the list
   	public boolean equals(Object obj) { 
   	    if (obj == null) return false;
   	    if (obj == this) return true;
   	    if (!(obj instanceof Animal)) return false;
   	    Animal o = (Animal) obj;
   	    return o.getName() == this.name;
   	}


}
