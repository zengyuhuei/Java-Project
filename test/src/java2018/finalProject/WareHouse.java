package java2018.finalProject;

import java.util.ArrayList;



public class WareHouse {
	private ArrayList<Crop> cropSeedList; //倉庫目前的熟成品作物
	private ArrayList<Animal> youngAnimalList; //倉庫目前的熟成品動物
	private ArrayList<Crop> cropList; //倉庫目前的待售出作物
	private ArrayList<Animal> AnimalList; //倉庫目前的待售出動物

	private ArrayList<Feed> feedList; //倉庫目前的飼料
	private int fertilizerNumber; //肥料數量
	private int holdMoney; //使用目前的金錢
	
	public WareHouse()
	{
		this.holdMoney = 1000;
		this.fertilizerNumber = 0;
	}
	
	public int getCropNum(ArrayList<Crop> list,String name)
	{
		int num = 0;
		for(Crop i: list)
		{
			if(i.getName() == name)
				num++;
		}
		return num;
	}
	
	public int getAnimalNum(ArrayList<Animal> list,String name)
	{
		int num = 0;
		for(Animal i: list)
		{
			if(i.getName() == name)
				num++;
		}
		return num;
	}
	
	public int getSeedNum(String name)
	{
		int num = 0;
		for(Feed i: feedList)
		{
			if(i.getName() == name)
				num++;
		}
		return num;
	}
	
	
	

	public int getFertilizer ()  //取得肥料數量
	{
		return fertilizerNumber;
	}
	
	public boolean addFertilizer (int num) //增加肥料數量
	{
		fertilizerNumber += num;
		return true;
	}
	
	
	public boolean addCrob (Crop crop) //(農場呼叫)加入成熟作物至倉庫，成功回傳True、失敗回傳False
	{
		cropList.add(crop);
	}
	public boolean removeCrob (Crop crop) //(商店呼叫)從倉庫刪除成熟作物，成功回傳True、失敗回傳False
	{
		
	}
	public boolean addSeed(Crop crop) //(商店呼叫)購買種子到倉庫
	{
		cropSeedList.add(crop);
	}
	
	public boolean removeSeed(Crop crop) //(農場呼叫)使用種子
	{
		
	}
	
	
	
	
	public int getWheatSeedNumber() //取得小麥種子數量
	{
		return getCropNum(cropSeedList, "小麥");
		
	}
	public int getCornSeedNumber() //取得玉米種子數量
	{
		return getCropNum(cropSeedList, "玉米");
	}
	public int getCabbageSeedNumber() //取得高麗菜種子數量
	{
		return getCropNum(cropSeedList, "高麗菜");
	}
	public int getWheatNumber() //取得成熟小麥數量
	{
		return getCropNum(cropList, "小麥");
	}
	public int getCornNumber() //取得成熟玉米數量
	{
		return getCropNum(cropList, "玉米");
	}
	public int getCabbageNumber() //取得成熟高麗菜數量
	{
		return getCropNum(cropList, "高麗菜");
	}
	
	
	public boolean addFeed (Feed fd) //加入飼料至倉庫，成功回傳True、失敗回傳False
	{
		feedList.add(fd);
	}
	public boolean removeFeed (Feed fd) //從倉庫刪除飼料，成功回傳True、失敗回傳False
	{
		return true;
	}
	
	public int getSimpleFeedNumber() //取得低級飼料數量
	{
		return getSeedNum("低級飼料");
	}
	public int getGeneralFeedNumber() //取得中級飼料數量
	{
		return getSeedNum("中級飼料");
	}
	public int getAdvencedFeedNumber() //取得高級飼料數量
	{
		return getSeedNum("高級飼料");
	}
	
	
	
	public boolean addYoungAnimal (Animal animal) //(商店)加入幼動物至倉庫，成功回傳True、失敗回傳False
	{
		youngAnimalList.add(animal);
	}
	public boolean removeYoungAnimal (Animal animal) //(農場)從倉庫刪除幼動物，成功回傳True、失敗回傳False
	{
		
	}
	public boolean addAnimal (Animal animal) //(牧場)加入成熟動物至倉庫，成功回傳True、失敗回傳False
	{
		AnimalList.add(animal);
	}
	public boolean removeAnimal (Animal animal) //(商店)從倉庫刪除成熟動物，成功回傳True、失敗回傳False
	{
		
	}
	
	public int getYoungCowNumber() //取得幼牛數量
	{
		return getAnimalNum(youngAnimalList,"牛");
	}
	public int getYoungPigNumber() //取得幼豬數量
	{
		return getAnimalNum(youngAnimalList,"豬");
	}
	public int getYoungChikendNumber() //取得幼雞數量
	{
		return getAnimalNum(youngAnimalList,"雞");
	}
	
	public int getCowNumber() //取得成熟牛數量
	{
		return getAnimalNum(AnimalList,"牛");
	}
	public int getPigNumber() //取得成熟豬數量
	{
		return getAnimalNum(AnimalList,"豬");
	}
	public int getChikendNumber() //取得成熟雞數量
	{
		return getAnimalNum(AnimalList,"雞");
	}
	
	public int getHoldMoney() //取得使用者金錢數輛數量
	{
		return holdMoney;
	}
	public Boolean editHoldMoney(int cost) //更改使用者金錢數量，傳入正整數則增加，傳入負整數則減少，成功回傳True、失敗回傳False
	{
		holdMoney += cost;
		return true;
	}





}
