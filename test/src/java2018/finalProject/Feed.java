package java2018.finalProject;

public abstract class Feed {
	private int nutrition; //餵食後提供的營養值
	private String type; //飼料的種類
	
	public Feed(int nutrition, String type)
	{
		this.nutrition = nutrition;
		this.type = type;
	}
	
	public String getType()  //得到哪一種飼料
	{
		return type;
	}
	
	public int getNutrition()  //得到飼料營養值
	{
		return nutrition;
	}


}
