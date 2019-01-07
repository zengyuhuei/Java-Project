// Farm.java
// 提供農場相關功能，並儲存農作物資料。
package java2018.finalProject;

import java.util.ArrayList;

import java.util.Random;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import java.text.SimpleDateFormat;


// 提供農場相關功能
public class Farm
{

	// 用來儲存農地的農作物資料，上限12個
	ArrayList<Crop> farmLand = new ArrayList<Crop>(12); 
	private int[] storeCropArray = new int[12];
	private Date lastKillBug; //上次殺蟲時間
	private Boolean killBugButtonClick = true;   //判斷殺蟲按鈕是否應該持續亮著
	WareHouse house;
	private int count = 0;
	
	public Farm(WareHouse house) {   
		 this.house=house;
    }
	// 回傳farmLand資料
	public ArrayList<Crop> getFarmLand()
	{
		return farmLand;
	}
	// 收成作物，判斷作物是否成熟，若成熟便把他加入到Warehouse中並從農地中移除。成功回傳1，失敗回傳0
	public Boolean harvest(int index)
	{
		System.out.println("該收割囉!!!");
		System.out.println("目標收割土地landNum="+index);
		/*for(Crop i: farmLand)
			System.out.println("ArrayList:"+i.getName());
		for(int i = 0; i < 12; i++)
			System.out.println("i:"+i+"  storeArray[i]:"+storeCropArray[i]);
		*/
		// 把收割的作物加到倉庫
		house.addCrop(farmLand.get(storeCropArray[index]));
		// 拔作物
		farmLand.remove(storeCropArray[index]);
		// 移動storeCArray的index
		for(int i = 0; i < 12; i++){
			if(storeCropArray[i] > storeCropArray[index])
			{
				storeCropArray[i] -= 1;
			}
		}
		
		storeCropArray[index] = -1;
		count--;
		for(Crop i: farmLand)
			System.out.println("ArrayList:"+i.getName());
		for(int i = 0; i < 12; i++)
			System.out.println("i:"+i+"  storeArray[i]:"+storeCropArray[i]);
		return true;
	}
	
	// 種植玉米，把他從Warehouse中拿出。成功回傳1，失敗回傳0
	public boolean sowingCorn(int num)
	{
		Date date = new Date();
		storeCropArray[num] = count;
		farmLand.add(count,new Corn());
		System.out.println(count+"你按了"+farmLand.get(count).pickSeed()+"ouo|");
		if(count == 0) setLastKillBugDate(date);
		farmLand.get(count).setGrowingRate();
		farmLand.get(count).setLastWaterDate(getOneHOurToNowDate());
		count++;
		System.out.println(house.removeSeed("玉米"));
		
		return true;
	}
	
	// 種植小麥，把他從Warehouse中拿出。成功回傳1，失敗回傳0
	public boolean sowingWheat(int num)
	{
		Date date = new Date();
		storeCropArray[num] = count;
		farmLand.add(count,new Wheat());
		System.out.println(count+"你按了"+farmLand.get(count).pickSeed()+"ouo|");
		if(count == 0) setLastKillBugDate(date);
		farmLand.get(count).setGrowingRate();
		farmLand.get(count).setLastWaterDate(getOneHOurToNowDate());
		count++;
		house.removeSeed("小麥");
		return true;
	}
		
	// 種植高麗菜，把他從Warehouse中拿出。成功回傳1，失敗回傳0
	public boolean sowingCabbage(int num)
	{
		Date date = new Date();
		storeCropArray[num] = count;
		farmLand.add(count,new Cabbage());
		System.out.println(count+"你按了"+farmLand.get(count).pickSeed()+"ouo|");
		if(count == 0) setLastKillBugDate(date);
		farmLand.get(count).setGrowingRate();
		farmLand.get(count).setLastWaterDate(getOneHOurToNowDate());
		count++;
	    house.removeSeed("高麗菜");
		return true;
	}
	public Date getDateTime()
	{
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		System.out.println(strDate);
		return date;
	}
	//判斷農場中土地有無作物
	public Boolean checkLand()  
	{
		for(int i = 0; i < 12; i++)
			if(storeCropArray[i] != -1) return true;
		return false;
	}
	//決定何時呼叫randomCheck()
	public boolean decideCallRandomCheck(Crop crop)
	{
		Date mainDate = new Date();
		long diff = mainDate.getTime() - crop.getLastWaterDate().getTime();
		diff = diff / 1000;
		System.out.println("diff = "+diff);
		if(diff >= 5)   //20秒重新亮起澆水
		{
			if(crop.randomCheck())
				return true;
			else
				crop.setLastWaterDate(mainDate);
				
			//return true;
		}
		return false;	
	}
	//決定何時呼叫randomCheck()
	public boolean decideCallRandomCheck()
	{
		Date mainDate = new Date();
		long diff = mainDate.getTime() - lastKillBug.getTime();
		diff = diff / 1000;
		System.out.println("KillBugDiff = "+diff);
		if(diff >= 10)   //10秒判斷是否除蟲
		{
			if(randomCheck())
				return true;
			else
				setLastKillBugDate(mainDate);
				
			//return true;
		}
		return false;
			
	}
	public int getLandNum()
	 {
		 return count;
	 }
	public void setLandNum(int count)
	{
		this.count = count;
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
	
	public Date getOneHOurToNowDate()
	{
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)-1); 
		//SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		// 1 hour before
		//String oneHourBeforeTime = sdFormat.format(calendar.getTime());
		//System.out.println(oneHourBeforeTime);
		return calendar.getTime();
	}
	//檢查除蟲除草
	public boolean randomCheck()
	{
		Random random = new Random();
		int randomProbablilty = random.nextInt(2);
		//System.out.println("random = "+randomProbablilty);
		if(!killBugButtonClick)
		{
			System.out.println("KillBugButtonClick is false!");
			if(randomProbablilty == 0)
				return false;
		}
		killBugButtonClick = true;
		return true;
	}
	public void setLastKillBugDate(Date lastKillBug)
	{
		this.lastKillBug = lastKillBug;
	}
	public Date getLastKillBugDate()
	{
		return lastKillBug;
	}
}
