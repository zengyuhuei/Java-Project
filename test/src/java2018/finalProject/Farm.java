// Farm.java
// 提供農場相關功能，並儲存農作物資料。
package java2018.finalProject;

import java.util.ArrayList;
import java.util.Random;

// 提供農場相關功能
public class Farm
{

	// 用來儲存農地的農作物資料，上限12個
	ArrayList<Crop> farmLand = new ArrayList<Crop>(); 
	
	// 回傳farmLand資料
	public ArrayList<Crop> getFarmLand()
	{
		return farmLand;
	}
	
	// 收成作物，判斷作物是否成熟，若成熟便把他加入到Warehouse中並從農地中移除。成功回傳1，失敗回傳0
	public Boolean harvest(ArrayList<Crop> farmLand)
	{
		return true;
	}
	
	// 種植作物，把他從Warehouse中拿出。成功回傳1，失敗回傳0
	public boolean sowing(ArrayList<Crop> farmLand)
	{
		/*WareHouse wareHouse = new WareHouse();
		Crop crop;
		if(crop.pickSeed() == "小麥")
		{
			wareHouse.removeSeed();
		}
		
		 */
		return true;
	}
	
	//檢查澆水、施肥
	public boolean randomCheck()
	{
		Random random = new Random();
		int randomProbablilty = random.nextInt(1);
		if(randomProbablilty == 0)
			return false;
		else
			return true;
	}
}
