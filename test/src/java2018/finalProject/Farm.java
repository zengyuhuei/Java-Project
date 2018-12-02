// Farm.java
// 提供農場相關功能，並儲存農作物資料。
package java2018.finalProject;

import java.util.ArrayList;
import java.util.Random;

// 提供農場相關功能
public class Farm
{

	// 用來儲存農地的農作物資料，上限12個
	ArrayList<Crop> farmLand = new ArrayList<Crop>(12); 
	private int[] storeCropArray = new int[12];
	WareHouse house;
	int count = 0;
	
	public Farm(WareHouse house) {   
		 this.house=house;
    }
	
	// 回傳farmLand資料
	public ArrayList<Crop> getFarmLand()
	{
		return farmLand;
	}
	
	// 設定farmLand資料
	public ArrayList<Crop> setFarmLand(int index, Crop crop)
	{
		return farmLand;
	}
	
	// 收成作物，判斷作物是否成熟，若成熟便把他加入到Warehouse中並從農地中移除。成功回傳1，失敗回傳0
	public Boolean harvest(int index)
	{
		System.out.println("該收割囉!!!");
		System.out.println("目標收割土地landNum="+index);
		// 把收割的作物加到倉庫
		house.addCrop(farmLand.get(storeCropArray[index]));
		// 拔作物
		farmLand.remove(storeCropArray[index]);
		// 移動storeCArray的index
		for(int i = 0; i < count; i++){
			if(storeCropArray[i] > index)
			{
				storeCropArray[i] -= 1;
			}
		}
		count--;
		return true;
	}
	
	// 種植玉米，把他從Warehouse中拿出。成功回傳1，失敗回傳0
	public boolean sowingCorn(int num)
	{
		storeCropArray[num] = count;
		farmLand.add(count,new Corn());
		System.out.println(count+"你按了"+farmLand.get(count).pickSeed()+"ouo|");
		farmLand.get(count).setGrowingRate();
		count++;
		house.removeSeed("玉米");
		return true;
	}
	
	// 種植小麥，把他從Warehouse中拿出。成功回傳1，失敗回傳0
	public boolean sowingWheat(int num)
	{
		storeCropArray[num] = count;
		farmLand.add(count,new Wheat());
		System.out.println(count+"你按了"+farmLand.get(count).pickSeed()+"ouo|");
		farmLand.get(count).setGrowingRate();
		count++;
		house.removeSeed("小麥");
		return true;
	}
		
	// 種植高麗菜，把他從Warehouse中拿出。成功回傳1，失敗回傳0
	public boolean sowingCabbage(int num)
	{
		storeCropArray[num] = count;
		farmLand.add(count,new Cabbage());
		System.out.println(count+"你按了"+farmLand.get(count).pickSeed()+"ouo|");
		farmLand.get(count).setGrowingRate();
		count++;
		house.removeSeed("高麗菜");
		return true;
	}
	
	//決定何時呼叫randomCheck()
	public boolean decideCallRandomCheck()
	{
		Random random = new Random();
		Crop crop;
		if(random.nextInt(1) == 1)
			return true;//crop.randomCheck();
		return false;
		//ex. 
		//     if( main的時間 - 上次澆水時間 == 20s)
		//         call randomCheck()
	}
	public int getLandNum()
	 {
		 return count;
	 }
	
	public void setStoreCropNum()
	 {
		for(int i = 0; i < 12; i++)
			storeCropArray[i] = -1;
	 }


	public int getStoreCropNum(int index)
	 {
		 return storeCropArray[index];
	 }
}
