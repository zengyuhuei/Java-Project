package java.finalProject;

import java.util.ArrayList;
import java.util.Collections;

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
	

	public int getFertilizer ()  //���o�ήƼƶq
	{
		return fertilizerNumber;
	}
	
	public boolean addFertilizer (int num) //�W�[�ήƼƶq
	{
		fertilizerNumber += num;
		return true;
	}
	
	/*
	public ArrayList<Crob> getCrobList() //���o�ܮw�@���C��
	{
		return crobList;
	}
	*/
	
	public boolean addCrob (crob) //(�A���I�s)�[�J�����@���ܭܮw�A���\�^��True�B���Ѧ^��False
	{
		crobList.add(crob);
	}
	public boolean removeCrob (crob) //(�ө��I�s)�q�ܮw�R�������@���A���\�^��True�B���Ѧ^��False
	{
		
	}
	public boolean addSeed(crob) //(�ө��I�s)�ʶR�ؤl��ܮw
	{
		crobSeedList.add(crob);
	}
	
	public boolean removeSeed(crob) //(�A���I�s)�ϥκؤl
	{
		
	}
	
	public int getWheatSeedNumber() //���o�p���ؤl�ƶq
	{
		int num;
		
		return  
	}
	public int getCornSeedNumber() //���o�ɦ̺ؤl�ƶq
	{
		
	}
	public int getCabbageSeedNumber() //���o���R��ؤl�ƶq
	public int getWheatNumber() //���o�����p���ƶq
	public int getCornNumber() //���o�����ɦ̼ƶq
	public int getCabbageNumber() //���o�������R��ƶq
	
	public ArrayList<Feed> getFeedList() //���o�ܮw�}�ƦC��
	public boolean addFeed (Feed) //�[�J�}�Ʀܭܮw�A���\�^��True�B���Ѧ^��False
	public boolean removeFeed (Feed) //�q�ܮw�R���}�ơA���\�^��True�B���Ѧ^��False
	
	public int getSimpleFeedNumber() //���o�C�Ź}�Ƽƶq
	public int getGeneralFeedNumber() //���o���Ź}�Ƽƶq
	public int getAdvencedFeedNumber() //���o���Ź}�Ƽƶq
	
	
	public ArrayList<Crob> getAnimalList() //���o�ܮw�ʪ��C��
	public boolean addAnimal (Animal) //�[�J�ʪ��ܭܮw�A���\�^��True�B���Ѧ^��False
	public boolean removeAnimal (Animal) //�q�ܮw�R���ʪ��A���\�^��True�B���Ѧ^��False
	
	public int getYoungCowNumber() //���o�����ƶq
	public int getYoungPigNumber() //���o���޼ƶq
	public int getYoungChikendNumber() //���o�����ƶq
	
	public int getCowNumber() //���o�������ƶq
	public int getPigNumber() //���o�����޼ƶq
	public int getChikendNumber() //���o�������ƶq
	
	public int getHoldMoney() //���o�ϥΪ̪����ƽ��ƶq
	public Boolean editHoldMoney(int) //���ϥΪ̪����ƶq�A�ǤJ����ƫh�W�[�A�ǤJ�t��ƫh��֡A���\�^��True�B���Ѧ^��False





}
