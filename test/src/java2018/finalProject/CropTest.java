package java2018.finalProject;

import java.util.ArrayList;

public class CropTest 
{
	public static void main(String[] args) 
	{
		ArrayList<Crop> crop = new ArrayList<Crop>();
		crop.add(new Corn());
		crop.get(0).setGrowingRate();
		crop.add(new Wheat());
		crop.get(1).setGrowingRate();
		crop.add(new Corn());
		crop.get(2).setGrowingRate();
		crop.add(new Cabbage());
		crop.get(3).setGrowingRate();
		//WareHouse house;
		//Dude dude(house);
		crop.get(0).water();
		crop.get(1).fertilize();
		crop.get(1).water();
		crop.get(2).water();
		crop.get(3).water();
		crop.get(1).fertilize();
		crop.get(1).fertilize();
		
		for(Crop i: crop)
		{
			System.out.println(i.getName());
			System.out.println("GrowingRate = "+i.getGrowingRate());
		}
		
	}

}
