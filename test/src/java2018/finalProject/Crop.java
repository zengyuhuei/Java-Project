// <absract>Crop.java

package java2018.finalProject;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.Random;

//定義農作物的基本功能
public abstract class Crop
{
	
	//作物生長度-1~100，-1為種子狀態，0~99為成長中，100為成熟
	private int growingRate; 
	private Boolean thirsty; //植物是否乾旱
	private Date lastFertilizeDate; //上次施肥時間
	private Date lastWaterDate; //上次澆水時間
	private String name; //作物名稱
	
	
	//建構元
	public Crop(String name)
	{
		this.name = name;
		this.growingRate = -1;
	}
	
	 //判斷物件名稱是否相同(刪除)
	public boolean equals(Object obj) { 
	    if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof Crop)) return false;
	    Crop o = (Crop) obj;
	    return o.getName() == this.name;
	}
	
	public int getGrowingRate()
	{
		return growingRate;
	}
	
	
	public void setGrowingRate()
	{
		growingRate = 0;
	}
	//借我測試 你們之後再刪
	public void setGrowingRate100()
	{
		growingRate = 100;
	}
	
	//替植物澆水，將植物的growingRate增加3，更新lastWaterDate，若成功return 1，失敗return 0
	public boolean water()
	{
		if(growingRate < 100)
		{
			growingRate += 3;
			
			//更新lastWaterDate
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			Date date = new Date();
			String strDate = sdFormat.format(date);
			setLastWaterDate(date);
			System.out.println(strDate);
			return true;
		}
		else
			return false;
		
	}

	//替植物施肥，將植物的growingRate增加10，更新lastFertilizeDate，若成功return 1，失敗return 0
	public boolean fertilize()
	{
		if(growingRate < 100)
		{
			growingRate += 10;
			//更新lastWaterDate
			return true;
		}
		else
			return false;
	}

	public String getName()
	{
		return name;
	}

	
	//檢查澆水、施肥
	public boolean randomCheck()
	{
		Random random = new Random();
		int randomProbablilty = random.nextInt(2);
		System.out.println("random = "+randomProbablilty);
		if(randomProbablilty == 0)
			return false;
		else
			return true;
	}
	// 針對該作物目前的狀態，判斷工具列的按鈕的亮暗
	public boolean isButtonAvailable()
	{
		return true;
	}
	
	public abstract String pickSeed();
	
	public Date getLastWaterDate()
	{
		return lastWaterDate;
	}
	
	public void setLastWaterDate(Date lastWaterDate)
	{
		this.lastWaterDate = lastWaterDate;
	}
}