package java2018.finalProject;
import java.util.concurrent.TimeUnit;

public abstract class Animal extends Object {
    private int growingRate;
    //Private Date lastFeedDate;

	private int coordinateX, coordinateY;
    private String name;
    public Animal(String name) {
      this.name=name;
      growingRate=-1;
    }
    public String getName()
    {
      return name;
    }
    public int getGrowingRate()
    {
      return growingRate;
    }

  	public void setGrowingRate()
  	{
  		growingRate = 0;
  	}
  	//借我之後再刪
  	public void setGrowingRate100()
  	{
  		growingRate = 100;
  	}
  	public boolean feeding(Feed feed)
    {
    	if(growingRate<100)
    	{
    		growingRate+=feed.getNutrition();

    		if(growingRate>100)setGrowingRate();
    		return true;
    	}
    	else if(growingRate==100) return false;
		return false;
    	
    }


   	public boolean equals(Object obj) { 
   	    if (obj == null) return false;
   	    if (obj == this) return true;
   	    if (!(obj instanceof Animal)) return false;
   	    Animal o = (Animal) obj;
   	    return o.getName() == this.name;
   	}


    public int[] moving(int[] arr, int count, int derection)
    {
		//coordinateX = (int)(Math.random()*50+1); //X座標
		//coordinateY = (int)(Math.random()*50+1); //Y座標
		
    	coordinateX = arr[0];
    	coordinateY = arr[1];
    	//print(coordinateX, coordinateY, coordinateZ);

			//上
			if(derection==4){
				for(int i=0;i<count;i++){
					coordinateY += 1;
					if(coordinateY==300)
					{
						coordinateY -= 5;
						break;
					}
					//print(coordinateX, coordinateY, coordinateZ);
					//makeDelay();
				}
			}
			//下
			if(derection==2){
				for(int i=0;i<count;i++){
					coordinateY -= 1;
					if(coordinateY==150)
					{
						coordinateY += 5;
						break;
					}
					//print(coordinateX, coordinateY, coordinateZ);
					//makeDelay();
				}
			}
			//右
			if(derection==3){
				for(int i=0;i<count;i++){
					coordinateX += 1;
					if(coordinateX==320)
					{
						coordinateX -= 5;
						break;
					}
					//print(coordinateX, coordinateY, coordinateZ);
					//makeDelay();
				}
			}
			//左
			if(derection==1){
				for(int i=0;i<count;i++){
					coordinateX -= 1;
					if(coordinateX==20)
					{
						coordinateX += 5;
						break;
					}
					//print(coordinateX, coordinateY, coordinateZ);
					//makeDelay();
				}
			}
			arr[0] = coordinateX;
			arr[1] = coordinateY;
			//derection = (int)(Math.random()*4+1);
			//count = (int)(Math.random()*5+5);
			//System.out.printf("test=%d\n", test);
			
			return arr;
    }
    
	public boolean print(int[] arr)
	{
		System.out.printf("位置: ");	
		System.out.printf("x:%d y:%d", arr[0], arr[1]);  
		System.out.printf("\n");
		return true;
	}
	public boolean makeDelay()
	{
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}