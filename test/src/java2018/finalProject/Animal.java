package java2018.finalProject;


public abstract class Animal extends Object {
    private int growingRate;
    //Private Date lastFeedDate;
	private int test=5;
	private int coordinateX, coordinateY, coordinateZ=0;
	private int count=0; //step count 3-7
	private int derection=0; //left1 down2 right3 up4
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
  		growingRate = 100;
  	}
  	



   	public boolean equals(Object obj) { 
   	    if (obj == null) return false;
   	    if (obj == this) return true;
   	    if (!(obj instanceof Animal)) return false;
   	    Animal o = (Animal) obj;
   	    return o.getName() == this.name;
   	}
   	
    public boolean feeding(Feed feed)
    {
    	if(growingRate<100)
    	{
    		growingRate+=feed.getNutrition();
    		if(growingRate>100)setGrowingRate();
    		return true;
    	}
    	else return false;
    	
    }

    public boolean moving()
    {
		coordinateX = (int)(Math.random()*50+1); //X座標
		coordinateY = (int)(Math.random()*50+1); //Y座標
		print(coordinateX, coordinateY, coordinateZ);
		derection = (int)(Math.random()*4+1);
		count = (int)(Math.random()*5+3);
		while(test>0){

			//上
			if(derection==4){
				for(int i=0;i<count;i++){
					coordinateY += 1;
					if(coordinateY==50)
					{
						coordinateY--;
						break;
					}
					print(coordinateX, coordinateY, coordinateZ);
				}
			}
			//下
			if(derection==2){
				for(int i=0;i<count;i++){
					coordinateY -= 1;
					if(coordinateY==0)
					{
						coordinateY++;
						break;
					}
					print(coordinateX, coordinateY, coordinateZ);
				}
			}
			//右
			if(derection==3){
				for(int i=0;i<count;i++){
					coordinateX += 1;
					if(coordinateX==50)
					{
						coordinateX--;
						break;
					}
					print(coordinateX, coordinateY, coordinateZ);
				}
			}
			//左
			if(derection==1){
				for(int i=0;i<count;i++){
					coordinateX -= 1;
					if(coordinateX==0)
					{
						coordinateX++;
						break;
					}
					print(coordinateX, coordinateY, coordinateZ);
				}
			}
			derection = (int)(Math.random()*4+1);
			count = (int)(Math.random()*5+3);
			System.out.printf("test=%d\n", test);
			test--;
		}	
    	return true;
    }
    
	public static void print(int x, int y, int z)
	{
		System.out.printf("位置: ");	
		System.out.printf("x:%d y:%d z:%d", x, y, z);  
		System.out.printf("\n");	
	}
    //step count time need to set (2sec/step)
}