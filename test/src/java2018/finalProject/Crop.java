// <absract>Crop.java
// 定義基本的作物功能(資料、函式)
package java2018.finalProject;

// 定義農作物基本功能
public abstract class Crop
{
	
	//作物生長度(-1~100)，-1為種子狀態，0~99為成長中，100為成熟
	private int growingRate; 
	private Boolean thirsty; //植物是否乾旱
	private Date lastFertilizeDate; //上一次施肥的時間
	private Date lastWaterDate; //上一次澆水的時間
	private String name; //作物的名稱
	private int buyPrice; //購入種子的價格
	private int sellPrice; //賣出作物的價格

	//替植物澆水，將植物的growingRate增加3，更新lastWaterDate。若成功return 1失敗return 0
	public boolean water()
	{

	}

	// 替植物施肥，將植物的growingRate增加10，更新lastFertilizeDate。若成功return1失敗return0
	public boolean fertilize()
	{

	}

	public int getName()
	{

	}

	// 判斷這個時間要不要呼叫randomCheck()
	public int decideCallRandomCheck()
	{
		//ex. 
		//     if( main的時間 - 上一次澆水時間 == 20s)
		//         call randomCheck()
	}

	// 工具列按鈕對此作物目前是否可用之判斷
	public Boolean isButtonAvailable()
	{

	}
}