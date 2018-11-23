//Wheat.java

package java2018.finalProject;

//繼承Crop 小麥
public class Wheat extends Crop
{
	
	public Wheat()
	{
		super("小麥");
	}

	@Override
	public String pickSeed()
	{
		return "小麥";
	}
	
}