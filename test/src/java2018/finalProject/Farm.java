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
	
	//決定何時呼叫randomCheck()
	public boolean decideCallRandomCheck()
	{
		Random random = new Random();
		Crop crop;
		if(random.nextInt(1) == 1)
			return crop.randomCheck();
		return false;
		//ex. 
		//     if( main的時間 - 上次澆水時間 == 20s)
		//         call randomCheck()
	}
}
