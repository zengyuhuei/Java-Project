package java2018.finalProject;

public abstract class Feed {
	private int nutrition; //�����ᴣ�Ѫ���i��
	private String type; //�}�ƪ�����
	
	public Feed(int nutrition, String type)
	{
		this.nutrition = nutrition;
		this.type = type;
	}
	
	public String getType()  //�o����@�ع}��
	{
		return type;
	}
	
	public int getNutrition()  //�o��}����i��
	{
		return nutrition;
	}


}
