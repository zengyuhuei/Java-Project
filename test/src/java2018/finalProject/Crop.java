// <absract>Crop.java
// 摰儔�������(鞈��撘�)
package java2018.finalProject;

// 摰儔颲脖�����
public abstract class Crop
{
	
	//雿��摨�(-1~100)嚗�-1�蝔桀������0~99���銝哨��100�����
	private int growingRate; 
	private Boolean thirsty; //璊��銋暹
	private Date lastFertilizeDate; //銝�甈⊥������
	private Date lastWaterDate; //銝�甈⊥�偌�����
	private String name; //雿���迂
	
	//�璊瞉偌嚗����rowingRate憓��3嚗�lastWaterDate����eturn 1憭望�eturn 0
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
	
	//借我測試 你們之後再改
	public void setGrowingRate()
	{
		growingRate = 100;
	}
	
	public boolean water()
	{

	}

	// �璊��嚗����rowingRate憓��10嚗�lastFertilizeDate����eturn1憭望�eturn0
	public boolean fertilize()
	{

	}

	public String getName()
	{
		return name;
	}

	// ����������randomCheck()
	public int decideCallRandomCheck()
	{
		//ex. 
		//     if( main����� - 銝�甈⊥�偌���� == 20s)
		//         call randomCheck()
	}

	// 撌亙�����迨雿������銋�
	public Boolean isButtonAvailable()
	{

	}
	
	
}