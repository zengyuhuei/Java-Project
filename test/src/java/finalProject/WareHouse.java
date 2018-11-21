package java.finalProject;

import java.util.ArrayList;
import java.util.Collections;

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
	

	public int getFertilizer ()  //取得肥料數量
	{
		return fertilizerNumber;
	}
	
	public boolean addFertilizer (int num) //增加肥料數量
	{
		fertilizerNumber += num;
		return true;
	}
	
	/*
	public ArrayList<Crob> getCrobList() //取得倉庫作物列表
	{
		return crobList;
	}
	*/
	
	public boolean addCrob (crob) //(農場呼叫)加入成熟作物至倉庫，成功回傳True、失敗回傳False
	{
		crobList.add(crob);
	}
	public boolean removeCrob (crob) //(商店呼叫)從倉庫刪除成熟作物，成功回傳True、失敗回傳False
	{
		
	}
	public boolean addSeed(crob) //(商店呼叫)購買種子到倉庫
	{
		crobSeedList.add(crob);
	}
	
	public boolean removeSeed(crob) //(農場呼叫)使用種子
	{
		
	}
	
	public int getWheatSeedNumber() //取得小麥種子數量
	{
		int num;
		
		return  
	}
	public int getCornSeedNumber() //取得玉米種子數量
	{
		
	}
	public int getCabbageSeedNumber() //取得高麗菜種子數量
	public int getWheatNumber() //取得成熟小麥數量
	public int getCornNumber() //取得成熟玉米數量
	public int getCabbageNumber() //取得成熟高麗菜數量
	
	public ArrayList<Feed> getFeedList() //取得倉庫飼料列表
	public boolean addFeed (Feed) //加入飼料至倉庫，成功回傳True、失敗回傳False
	public boolean removeFeed (Feed) //從倉庫刪除飼料，成功回傳True、失敗回傳False
	
	public int getSimpleFeedNumber() //取得低級飼料數量
	public int getGeneralFeedNumber() //取得中級飼料數量
	public int getAdvencedFeedNumber() //取得高級飼料數量
	
	
	public ArrayList<Crob> getAnimalList() //取得倉庫動物列表
	public boolean addAnimal (Animal) //加入動物至倉庫，成功回傳True、失敗回傳False
	public boolean removeAnimal (Animal) //從倉庫刪除動物，成功回傳True、失敗回傳False
	
	public int getYoungCowNumber() //取得幼牛數量
	public int getYoungPigNumber() //取得幼豬數量
	public int getYoungChikendNumber() //取得幼雞數量
	
	public int getCowNumber() //取得成熟牛數量
	public int getPigNumber() //取得成熟豬數量
	public int getChikendNumber() //取得成熟雞數量
	
	public int getHoldMoney() //取得使用者金錢數輛數量
	public Boolean editHoldMoney(int) //更改使用者金錢數量，傳入正整數則增加，傳入負整數則減少，成功回傳True、失敗回傳False





}
