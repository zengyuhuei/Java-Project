// <absract>Crop.java
// 摰儔�������(鞈��撘�)
package java2018.finalProject;

import java.util.Date;

// 摰儔颲脖�����
public abstract class Crop
{
	
	//雿��摨�(-1~100)嚗�-1�蝔桀������0~99���銝哨��100�����
	private int growingRate; 
	private Boolean thirsty; //璊��銋暹
	private Date lastFertilizeDate; //銝�甈⊥������
	private Date lastWaterDate; //銝�甈⊥�偌�����
	private String name; //雿���迂
	private int buyPrice; //鞈澆蝔桀���
	private int sellPrice; //鞈��雿���

	//�璊瞉偌嚗����rowingRate憓��3嚗�lastWaterDate����eturn 1憭望�eturn 0
	public boolean water()
	{
		return true;
	}

	// �璊��嚗����rowingRate憓��10嚗�lastFertilizeDate����eturn1憭望�eturn0
	public boolean fertilize()
	{
		return true;
	}

	public String getName()
	{
		return "aaa";
	}

	// ����������randomCheck()
	public int decideCallRandomCheck()
	{
		//ex. 
		//     if( main����� - 銝�甈⊥�偌���� == 20s)
		//         call randomCheck()
		return 0;
	}

	// 撌亙�����迨雿������銋�
	public Boolean isButtonAvailable()
	{
		return true;
	}
}