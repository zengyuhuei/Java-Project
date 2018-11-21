package java2018.finalProject;

import java.util.ArrayList;



public class WareHouse {
	private ArrayList<Crop> cropSeedList; //�ܮw�ثe�������~�@��
	private ArrayList<Animal> youngAnimalList; //�ܮw�ثe�������~�ʪ�
	private ArrayList<Crop> cropList; //�ܮw�ثe���ݰ�X�@��
	private ArrayList<Animal> AnimalList; //�ܮw�ثe���ݰ�X�ʪ�

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
		cropList.add(crop);
	}
	public boolean removeCrob (Crop crop) //(�ө��I�s)�q�ܮw�R�������@���A���\�^��True�B���Ѧ^��False
	{
		
	}
	public boolean addSeed(Crop crop) //(�ө��I�s)�ʶR�ؤl��ܮw
	{
		cropSeedList.add(crop);
	}
	
	public boolean removeSeed(Crop crop) //(�A���I�s)�ϥκؤl
	{
		
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
		feedList.add(fd);
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
		youngAnimalList.add(animal);
	}
	public boolean removeYoungAnimal (Animal animal) //(�A��)�q�ܮw�R�����ʪ��A���\�^��True�B���Ѧ^��False
	{
		
	}
	public boolean addAnimal (Animal animal) //(����)�[�J�����ʪ��ܭܮw�A���\�^��True�B���Ѧ^��False
	{
		AnimalList.add(animal);
	}
	public boolean removeAnimal (Animal animal) //(�ө�)�q�ܮw�R�������ʪ��A���\�^��True�B���Ѧ^��False
	{
		
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
	public int getChikendNumber() //���o�������ƶq
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
