package java2018.finalProject;

import java.util.*;

public class Shop {

	private Dictionary<String, Integer> soldList = new Hashtable<String, Integer>();
	private Dictionary<String, Integer> boughtList = new Hashtable<String, Integer>();

	public Shop() {
		
		//growing rate -1為未成熟  100 成熟
		boughtList.put("低級飼料", 5);
		boughtList.put("中級飼料",  8);
		boughtList.put("高級飼料", 15);
		boughtList.put("豬", 30);
		boughtList.put("牛", 50);
		boughtList.put("雞", 20);
		boughtList.put("小麥", 5);
		boughtList.put("玉米", 10);
		boughtList.put("高麗菜", 15);
		boughtList.put("肥料", 20);
		soldList.put("小麥", 10);
		soldList.put("玉米", 30);
		soldList.put("高麗菜", 50);
		soldList.put("牛", 230);
		soldList.put("豬", 210);
		soldList.put("雞", 200);
	}


}
