package java2018.finalProject;

public class testHitManyMouse extends Thread
{

	String [][] gameMap = new String[3][3];
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new testHitManyMouse().start();
	}
	
	public void initMap()
	{
		for (int i = 0; i < gameMap.length; i++) {
			for (int j = 0; j < gameMap[0].length; j++) {
				gameMap[i][j] = new String();
				gameMap[i][j] = "O" ; //洞，表示没有老鼠出来
			}
		}
	}
	
	public void printMap()
	{
		for (int i = 0; i < gameMap.length; i++) {
			for (int j = 0; j < gameMap[0].length; j++) {
				System.out.print(gameMap[i][j]);
			}
			System.out.println();
		}
	}
	
	public void run()
	{
		int temp = 0 ;
		while(true)
		{
			initMap();
			for (int i = 0; i < gameMap.length; i++) {
				for (int j = 0; j < gameMap[0].length; j++) {
						temp = (int)(100 * Math.random());
						if(temp<=20) //可以调整，让老鼠出现的概率降低一些
							gameMap[i][j] = "@"; //有老鼠出现
				}
			}
			printMap();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
		}
	}
}