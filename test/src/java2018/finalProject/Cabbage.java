// Cabbage.java

package java2018.finalProject;

//繼承Crop 高麗菜
public class Cabbage extends Crop
{

	public Cabbage()
	{
		super("高麗菜");
	}
	
	@Override
	public String pickSeed()
	{
		return "高麗菜";
	}


}