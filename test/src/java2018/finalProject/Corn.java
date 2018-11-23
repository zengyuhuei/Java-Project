// Corn.java

package java2018.finalProject;

//繼承Crop 玉米
public class Corn extends Crop
{

	
	public Corn()
	{
		super("玉米");
	}

	@Override
	public String pickSeed()
	{
		return "玉米";
	}
}	