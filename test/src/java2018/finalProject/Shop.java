package java2018.finalProject;

import java.util.*;

public class Shop {

	private Dictionary<String, Integer> soldList = new Hashtable<String, Integer>();
	private Dictionary<String, Integer> boughtList = new Hashtable<String, Integer>();

	public Shop() {
		
		//growing rate -1��������  100 ����
		boughtList.put("�C�Ź}��", 5);
		boughtList.put("���Ź}��",  8);
		boughtList.put("���Ź}��", 15);
		boughtList.put("��", 30);
		boughtList.put("��", 50);
		boughtList.put("��", 20);
		boughtList.put("�p��", 5);
		boughtList.put("�ɦ�", 10);
		boughtList.put("���R��", 15);
		boughtList.put("�ή�", 20);
		soldList.put("�p��", 10);
		soldList.put("�ɦ�", 30);
		soldList.put("���R��", 50);
		soldList.put("��", 230);
		soldList.put("��", 210);
		soldList.put("��", 200);
	}


}
