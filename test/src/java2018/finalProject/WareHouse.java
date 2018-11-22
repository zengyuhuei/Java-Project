package java2018.finalProject;

import java.util.ArrayList;



public class WareHouse {
	private ArrayList<Crop> cropSeedList; //
	private ArrayList<Animal> youngAnimalList; //�ܮw�ثe�������~�ʪ�
	private ArrayList<Crop> cropList; //�ܮw�ثe���ݰ�X�@��
	private ArrayList<Animal> AnimalList; //�ܮw�ثe���ݰ�X�ʪ�
	public static final int isMatured = 100; 
	public static final int unMatured = -1; 

	private ArrayList<Feed> feedList; //�ܮw�ثe���}��
	private int fertilizerNumber; //�ήƼƶq
	private int holdMoney; //�ϥΥثe������
	
	
	
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
	
	
	

	public int getFertilizer ()  //���o�ήƼƶq
	{
		return fertilizerNumber;
	}
	
	public boolean addFertilizer (int num) //�W�[�ήƼƶq
	{
		fertilizerNumber += num;
		return true;
	}
	
	
	public boolean addCrob (Crop crop) //(�A���I�s)�[�J�����@���ܭܮw�A���\�^��True�B���Ѧ^��False
	{ 
		try
	    {
			cropList.add(crop);
			return true;
	    }catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	public boolean removeCrob (Crop crop) //(�ө��I�s)�q�ܮw�R�������@���A���\�^��True�B���Ѧ^��False
	{
		if(crop.getGrowingRate() == isMatured)
		{
			for(Crop cp :cropList)
			{
				if(cp.equals(crop))
				{
					cropList.remove(cp);
	
				}
			}
		}
		return false;
		
	}
	public boolean addSeed(Crop crop) //(�ө��I�s)�ʶR�ؤl��ܮw
	{	
		try
	    {
			cropSeedList.add(crop);
			return true;
	    }catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	
	public boolean removeSeed(Crop crop) //(�A���I�s)�ϥκؤl
	{
		if(crop.getGrowingRate() == unMatured)
		{
			for(Crop cp :cropSeedList)
			{
				if(cp.equals(crop))
				{
					cropSeedList.remove(cp);
	
				}
			}
		}
		return false;
	}
	
	
	
	
	public int getWheatSeedNumber() //���o�p���ؤl�ƶq
	{
		return getCropNum(cropSeedList, "�p��");
		
	}
	public int getCornSeedNumber() //���o�ɦ̺ؤl�ƶq
	{
		return getCropNum(cropSeedList, "�ɦ�");
	}
	public int getCabbageSeedNumber() //���o���R��ؤl�ƶq
	{
		return getCropNum(cropSeedList, "���R��");
	}
	public int getWheatNumber() //���o�����p���ƶq
	{
		return getCropNum(cropList, "�p��");
	}
	public int getCornNumber() //���o�����ɦ̼ƶq
	{
		return getCropNum(cropList, "�ɦ�");
	}
	public int getCabbageNumber() //���o�������R��ƶq
	{
		return getCropNum(cropList, "���R��");
	}
	
	
	public boolean addFeed (Feed fd) //�[�J�}�Ʀܭܮw�A���\�^��True�B���Ѧ^��False
	{
		try
	    {
			feedList.add(fd);
			return true;
	    }
		catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	public boolean removeFeed (Feed fd) //�q�ܮw�R���}�ơA���\�^��True�B���Ѧ^��False
	{
		return true;
	}
	
	public int getSimpleFeedNumber() //���o�C�Ź}�Ƽƶq
	{
		return getSeedNum("�C�Ź}��");
	}
	public int getGeneralFeedNumber() //���o���Ź}�Ƽƶq
	{
		return getSeedNum("���Ź}��");
	}
	public int getAdvencedFeedNumber() //���o���Ź}�Ƽƶq
	{
		return getSeedNum("���Ź}��");
	}
	
	
	
	public boolean addYoungAnimal (Animal animal) //(�ө�)�[�J���ʪ��ܭܮw�A���\�^��True�B���Ѧ^��False
	{
		try
	    {
			youngAnimalList.add(animal);
			return true;
	    }catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	public boolean removeYoungAnimal (Animal animal) //(�A��)�q�ܮw�R�����ʪ��A���\�^��True�B���Ѧ^��False
	{
		if(animal.getGrowingRate() == unMatured)
		{
			for(Animal an :youngAnimalList)
			{
				if(an.equals(animal))
				{
					youngAnimalList.remove(an);
	
				}
			}
		}
		return false;
	}
	public boolean addAnimal (Animal animal) //(����)�[�J�����ʪ��ܭܮw�A���\�^��True�B���Ѧ^��False
	{
		try
	    {
			AnimalList.add(animal);
			return true;
	    }catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	public boolean removeAnimal (Animal animal) //(�ө�)�q�ܮw�R�������ʪ��A���\�^��True�B���Ѧ^��False
	{
		if(animal.getGrowingRate() == isMatured)
		{
			for(Animal an :AnimalList)
			{
				if(an.equals(animal))
				{
					AnimalList.remove(an);
	
				}
			}
		}
		return false;
	}
	
	public int getYoungCowNumber() //���o�����ƶq
	{
		return getAnimalNum(youngAnimalList,"��");
	}
	public int getYoungPigNumber() //���o���޼ƶq
	{
		return getAnimalNum(youngAnimalList,"��");
	}
	public int getYoungChikendNumber() //���o�����ƶq
	{
		return getAnimalNum(youngAnimalList,"��");
	}
	
	public int getCowNumber() //���o�������ƶq
	{
		return getAnimalNum(AnimalList,"��");
	}
	public int getPigNumber() //���o�����޼ƶq
	{
		return getAnimalNum(AnimalList,"��");
	}
	public int getChickenNumber() //���o�������ƶq
	{
		return getAnimalNum(AnimalList,"��");
	}
	
	public int getHoldMoney() //���o�ϥΪ̪����ƽ��ƶq
	{
		return holdMoney;
	}
	public Boolean editHoldMoney(int cost) //���ϥΪ̪����ƶq�A�ǤJ����ƫh�W�[�A�ǤJ�t��ƫh��֡A���\�^��True�B���Ѧ^��False
	{
		holdMoney += cost;
		return true;
	}





}
