package java2018.finalProject;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java2018.finalProject.DudeScreenTest2.RunningButton;

public class DudeScreen {
	//WareHouse wareHouse = new WareHouse();
	JFrame f;
	private int num;
	private JButton b1 = new JButton("養殖");
	private JButton b2 = new JButton("牛");
	private JButton b3 = new JButton("豬");
	private JButton b4 = new JButton("雞");
	private JButton b5 = new JButton("餵食");
	private JButton b6 = new JButton("高級飼料");
	private JButton b7 = new JButton("中級飼料");
	private JButton b8 = new JButton("低級飼料");
	private JButton b9 = new JButton("捕捉");
	private JButton b11 = new JButton("動物");
	private JButton b12 = new JButton("動物");
	private JButton b13 = new JButton("動物");
	private JButton b14 = new JButton("動物");
	private JButton b15 = new JButton("動物");
	private JButton b16 = new JButton("動物");
	private JButton b17 = new JButton("動物");
	private JButton b18 = new JButton("動物");
	private JButton b19 = new JButton("動物");
	private JButton b20 = new JButton("動物");
	private ArrayList<JButton> button = new ArrayList<JButton>(10);
	public double [] arrCoordinateX = new double[10];
	public double [] arrCoordinateY = new double[10];
	/*public static void main(String argv[]) 
	{
		new DudeScreen(warehouse);  
	    
	}*/
	  
	public DudeScreen(WareHouse warehouse) 
	{
		
		button.add(b11);
		button.add(b12);
		button.add(b13);
		button.add(b14);
		button.add(b15);
		button.add(b16);
		button.add(b17);
		button.add(b18);
		button.add(b19);
		button.add(b20);
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		f=new JFrame("Dude");
		f.setBounds(0,0,520,620); 
		f.setVisible(true); 
		Container cp=f.getContentPane();
		cp.setLayout(null);  //取消預設之 BorderLayout
		
		
		/*Animal pig1 = new Pig();
		Animal pig2 = new Pig();
		Animal pig3 = new Pig();
		Animal pig4 = new Pig();
		Animal chicken1 = new Chicken();
		Animal chicken2 = new Chicken();
		Animal chicken3 = new Chicken();
		Animal chicken4 = new Chicken();
		Animal cow1 = new Cow();
		Animal cow2 = new Cow();
		Animal cow3 = new Cow();
		Animal cow4 = new Cow();
		Feed feed1=new SimpleFeed();
		Feed feed2=new GeneralFeed();
		Feed feed3=new AdvancedFeed();
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed1);
		wareHouse.addFeed(feed2);
		wareHouse.addFeed(feed2);
		wareHouse.addFeed(feed2);
		wareHouse.addFeed(feed2);
		wareHouse.addFeed(feed2);
		wareHouse.addFeed(feed2);
		wareHouse.addFeed(feed2);
		wareHouse.addFeed(feed2);
		wareHouse.addFeed(feed2);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addFeed(feed3);
		wareHouse.addYoungAnimal(pig1);
		wareHouse.addYoungAnimal(pig2);
		wareHouse.addYoungAnimal(pig3);
		wareHouse.addYoungAnimal(pig4);
		wareHouse.addYoungAnimal(chicken1);
		wareHouse.addYoungAnimal(chicken2);
		wareHouse.addYoungAnimal(chicken3);
		wareHouse.addYoungAnimal(chicken4);
		wareHouse.addYoungAnimal(cow1);
		wareHouse.addYoungAnimal(cow2);
		wareHouse.addYoungAnimal(cow3);
		wareHouse.addYoungAnimal(cow4);*/
		Dude dude = new Dude(warehouse);
			
			
		b2.setVisible(false);
		b3.setVisible(false);
		b4.setVisible(false);
		b5.setVisible(false);
		b6.setVisible(false);
		b7.setVisible(false);
		b8.setVisible(false);
		b9.setVisible(false);
		b11.setVisible(false);
		b12.setVisible(false);
		b13.setVisible(false);
		b14.setVisible(false);
		b15.setVisible(false);
		b16.setVisible(false);
		b17.setVisible(false);
		b18.setVisible(false);
		b19.setVisible(false);
		b20.setVisible(false);
			
		b1.setBounds(20,20,60,25);  //自行決定元件位置與大小   (x, y, 橫, 直)
		cp.add(b1);
		b1.addActionListener(new ActionListener() {
		@Override
	    public void actionPerformed(ActionEvent e) {
	    	if(warehouse.getYoungCowNumber()==0) {
	    		b2.setVisible(false);
		    }
		   	if(warehouse.getYoungCowNumber()>0) {
		   		b2.setVisible(true);
		   	}
		   	if(warehouse.getYoungPigNumber()==0) {
	    		b3.setVisible(false);
	    	}
		   	if(warehouse.getYoungPigNumber()>0) {
		    	b3.setVisible(true);
		   	}
		   	if(warehouse.getYoungChickenNumber()==0) {
		   		b4.setVisible(false);
	    	}
	    	if(warehouse.getYoungChickenNumber()>0) {
		    	b4.setVisible(true);
		    }
	    	System.out.printf("%d\n",warehouse.getYoungPigNumber());
	    	System.out.printf("%d\n",warehouse.getYoungCowNumber());
	    	System.out.printf("%d\n",warehouse.getYoungChickenNumber());
		   	System.out.println("想養東西ouo");
		    if(dude.getNum()==10)
		    {
			    b2.setVisible(false);
			    b3.setVisible(false);
			    b4.setVisible(false);
				System.out.println("牧場已經塞不下動物了!!");
		  	}
		    b5.setVisible(false);
		  	b6.setVisible(false);
		  	b7.setVisible(false);
		    b8.setVisible(false);

		}
	});
		    
		    b2.setBounds(20,50,60,25);  //自行決定元件位置與大小
		    cp.add(b2);
		    b2.addActionListener(new ActionListener() {
		    	@Override
		        public void actionPerformed(ActionEvent e) {
		        	dude.startFeedCow(new Cow());
		        	if(warehouse.getYoungCowNumber()==0) {
		        		b2.setVisible(false);
		        	}
		      	    if(dude.getNum()==1)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	randomFirstlocation(0, arrCoordinateX, arrCoordinateY);
		      	    	b11.setBounds((int)arrCoordinateX[0], (int)arrCoordinateY[0],60,25);
		      	    	b11.setVisible(true);
		      	    	b11.setText("牛");
		      	    	Timer timer = new Timer();
			        	RunningButton r0 = new RunningButton(b11, arrCoordinateX[0], arrCoordinateY[0]);
			        	timer.schedule(r0, 1000, 180);
		      	    }
		      	    if(dude.getNum()==2)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	randomFirstlocation(1, arrCoordinateX, arrCoordinateY);
		      	    	b12.setBounds((int)arrCoordinateX[1], (int)arrCoordinateY[1],60,25);
		      	    	b12.setVisible(true);
		      	    	b12.setText("牛");
		      	    	Timer timer = new Timer();
			        	RunningButton r1 = new RunningButton(b12, arrCoordinateX[1], arrCoordinateY[1]);
			        	timer.schedule(r1, 1000, 180);
		      	    }
		      	    if(dude.getNum()==3)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	randomFirstlocation(2, arrCoordinateX, arrCoordinateY);
		      	    	b13.setBounds((int)arrCoordinateX[2], (int)arrCoordinateY[2],60,25);
		      	    	b13.setVisible(true);
		      	    	b13.setText("牛");
		      	    	Timer timer = new Timer();
			        	RunningButton r2 = new RunningButton(b13, arrCoordinateX[2], arrCoordinateY[2]);
			        	timer.schedule(r2, 1000, 180);
		      	    }
		      	    if(dude.getNum()==4)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	randomFirstlocation(3, arrCoordinateX, arrCoordinateY);
		      	    	b14.setBounds((int)arrCoordinateX[3], (int)arrCoordinateY[3],60,25);
		      	    	b14.setVisible(true);
		      	    	b14.setText("牛");
		      	    	Timer timer = new Timer();
			        	RunningButton r3 = new RunningButton(b14, arrCoordinateX[3], arrCoordinateY[3]);
			        	timer.schedule(r3, 1000, 180);
		      	    }
		      	    if(dude.getNum()==5)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	randomFirstlocation(4, arrCoordinateX, arrCoordinateY);
		      	    	b15.setBounds((int)arrCoordinateX[4], (int)arrCoordinateY[4],60,25);
		      	    	b15.setVisible(true);
		      	    	b15.setText("牛");
		      	    	Timer timer = new Timer();
			        	RunningButton r4 = new RunningButton(b15, arrCoordinateX[4], arrCoordinateY[4]);
			        	timer.schedule(r4, 1000, 180);
		      	    }
		      	    if(dude.getNum()==6)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	randomFirstlocation(5, arrCoordinateX, arrCoordinateY);
		      	    	b16.setBounds((int)arrCoordinateX[5], (int)arrCoordinateY[5],60,25);
		      	    	b16.setVisible(true);
		      	    	b16.setText("牛");
		      	    	Timer timer = new Timer();
			        	RunningButton r5 = new RunningButton(b16, arrCoordinateX[5], arrCoordinateY[5]);
			        	timer.schedule(r5, 1000, 180);
		      	    }
			      	if(dude.getNum()==7)
		      	    {
			      		System.out.println("你可以養這隻牛ouo");
		      	    	randomFirstlocation(6, arrCoordinateX, arrCoordinateY);
		      	    	b17.setBounds((int)arrCoordinateX[6], (int)arrCoordinateY[6],60,25);
		      	    	b17.setVisible(true);
		      	    	b17.setText("牛");
		      	    	Timer timer = new Timer();
			        	RunningButton r6 = new RunningButton(b17, arrCoordinateX[6], arrCoordinateY[6]);
			        	timer.schedule(r6, 1000, 180);
		      	    }
			      	if(dude.getNum()==8)
		      	    {
			      		System.out.println("你可以養這隻牛ouo");
		      	    	randomFirstlocation(7, arrCoordinateX, arrCoordinateY);
		      	    	b18.setBounds((int)arrCoordinateX[7], (int)arrCoordinateY[7],60,25);
		      	    	b18.setVisible(true);
		      	    	b18.setText("牛");
		      	    	Timer timer = new Timer();
			        	RunningButton r7 = new RunningButton(b18, arrCoordinateX[7], arrCoordinateY[7]);
			        	timer.schedule(r7, 1000, 180);
		      	    }
			      	if(dude.getNum()==9)
		      	    {
			      		System.out.println("你可以養這隻牛ouo");
		      	    	randomFirstlocation(8, arrCoordinateX, arrCoordinateY);
		      	    	b19.setBounds((int)arrCoordinateX[8], (int)arrCoordinateY[8],60,25);
		      	    	b19.setVisible(true);
		      	    	b19.setText("牛");
		      	    	Timer timer = new Timer();
			        	RunningButton r8 = new RunningButton(b19, arrCoordinateX[8], arrCoordinateY[8]);
			        	timer.schedule(r8, 1000, 180);;
		      	    }
			      	if(dude.getNum()==10)
		      	    {
			      		System.out.println("你可以養這隻牛ouo");
		      	    	randomFirstlocation(9, arrCoordinateX, arrCoordinateY);
		      	    	b20.setBounds((int)arrCoordinateX[9], (int)arrCoordinateY[9],60,25);
		      	    	b20.setVisible(true);
		      	    	b20.setText("牛");
		      	    	Timer timer = new Timer();
			        	RunningButton r9 = new RunningButton(b20, arrCoordinateX[9], arrCoordinateY[9]);
			        	timer.schedule(r9, 1000, 180);
		      	    }
			      	b2.setVisible(false);
	      	    	b3.setVisible(false);
	      	    	b4.setVisible(false);
	    	 	}    
		    });
		    
		    b3.setBounds(20,80,60,25);  //自行決定元件位置與大小
		    cp.add(b3);
		    b3.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	dude.startFeedPig(new Pig());
		        	if(warehouse.getYoungPigNumber()==0) {
		      	    	b3.setVisible(false);
		        	}
		      	    if(dude.getNum()==1)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	randomFirstlocation(0, arrCoordinateX, arrCoordinateY);
		      	    	b11.setBounds((int)arrCoordinateX[0], (int)arrCoordinateY[0],60,25);
		      	    	b11.setVisible(true);
		      	    	b11.setText("豬");
		      	    	Timer timer = new Timer();
			        	RunningButton r0 = new RunningButton(b11, arrCoordinateX[0], arrCoordinateY[0]);
			        	timer.schedule(r0, 1000, 180);
		      	    }
		      	    if(dude.getNum()==2)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	randomFirstlocation(1, arrCoordinateX, arrCoordinateY);
		      	    	b12.setBounds((int)arrCoordinateX[1], (int)arrCoordinateY[1],60,25);
		      	    	b12.setVisible(true);
		      	    	b12.setText("豬");
		      	    	Timer timer = new Timer();
			        	RunningButton r1 = new RunningButton(b12, arrCoordinateX[1], arrCoordinateY[1]);
			        	timer.schedule(r1, 1000, 180);
		      	    }
		      	    if(dude.getNum()==3)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	randomFirstlocation(2, arrCoordinateX, arrCoordinateY);
		      	    	b13.setBounds((int)arrCoordinateX[2], (int)arrCoordinateY[2],60,25);
		      	    	b13.setVisible(true);
		      	    	b13.setText("豬");
		      	    	Timer timer = new Timer();
			        	RunningButton r2 = new RunningButton(b13, arrCoordinateX[2], arrCoordinateY[2]);
			        	timer.schedule(r2, 1000, 180);
		      	    }
		      	    if(dude.getNum()==4)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	randomFirstlocation(3, arrCoordinateX, arrCoordinateY);
		      	    	b14.setBounds((int)arrCoordinateX[3], (int)arrCoordinateY[3],60,25);
		      	    	b14.setVisible(true);
		      	    	b14.setText("豬");
		      	    	Timer timer = new Timer();
			        	RunningButton r3 = new RunningButton(b14, arrCoordinateX[3], arrCoordinateY[3]);
			        	timer.schedule(r3, 1000, 180);
		      	    }
		      	    if(dude.getNum()==5)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	randomFirstlocation(4, arrCoordinateX, arrCoordinateY);
		      	    	b15.setBounds((int)arrCoordinateX[4], (int)arrCoordinateY[4],60,25);
		      	    	b15.setVisible(true);
		      	    	b15.setText("豬");
		      	    	Timer timer = new Timer();
			        	RunningButton r4 = new RunningButton(b15, arrCoordinateX[4], arrCoordinateY[4]);
			        	timer.schedule(r4, 1000, 180);
		      	    }
		      	  if(dude.getNum()==6)
		      	    {
			      		System.out.println("你可以養這隻豬ouo");
		      	    	randomFirstlocation(5, arrCoordinateX, arrCoordinateY);
		      	    	b16.setBounds((int)arrCoordinateX[5], (int)arrCoordinateY[5],60,25);
		      	    	b16.setVisible(true);
		      	    	b16.setText("豬");
		      	    	Timer timer = new Timer();
			        	RunningButton r5 = new RunningButton(b16, arrCoordinateX[5], arrCoordinateY[5]);
			        	timer.schedule(r5, 1000, 180);
		      	    }
		      	    if(dude.getNum()==7)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	randomFirstlocation(6, arrCoordinateX, arrCoordinateY);
		      	    	b17.setBounds((int)arrCoordinateX[6], (int)arrCoordinateY[6],60,25);
		      	    	b17.setVisible(true);
		      	    	b17.setText("豬");
		      	    	Timer timer = new Timer();
			        	RunningButton r6 = new RunningButton(b17, arrCoordinateX[6], arrCoordinateY[6]);
			        	timer.schedule(r6, 1000, 180);
		      	    }
		      	    if(dude.getNum()==8)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	randomFirstlocation(7, arrCoordinateX, arrCoordinateY);
		      	    	b18.setBounds((int)arrCoordinateX[7], (int)arrCoordinateY[7],60,25);
		      	    	b18.setVisible(true);
		      	    	b18.setText("豬");
		      	    	Timer timer = new Timer();
			        	RunningButton r7 = new RunningButton(b18, arrCoordinateX[7], arrCoordinateY[7]);
			        	timer.schedule(r7, 1000, 180);
		      	    }
		      	    if(dude.getNum()==9)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	randomFirstlocation(8, arrCoordinateX, arrCoordinateY);
		      	    	b19.setBounds((int)arrCoordinateX[8], (int)arrCoordinateY[8],60,25);
		      	    	b19.setVisible(true);
		      	    	b19.setText("豬");
		      	    	Timer timer = new Timer();
			        	RunningButton r8 = new RunningButton(b19, arrCoordinateX[8], arrCoordinateY[8]);
			        	timer.schedule(r8, 1000, 180);
		      	    }
		      	    if(dude.getNum()==10)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	randomFirstlocation(9, arrCoordinateX, arrCoordinateY);
		      	    	b20.setBounds((int)arrCoordinateX[9], (int)arrCoordinateY[9],60,25);
		      	    	b20.setVisible(true);
		      	    	b20.setText("豬");
		      	    	Timer timer = new Timer();
			        	RunningButton r9 = new RunningButton(b20, arrCoordinateX[9], arrCoordinateY[9]);
			        	timer.schedule(r9, 1000, 180);
		      	    }
		      	    b2.setVisible(false);
	      	    	b3.setVisible(false);
	      	    	b4.setVisible(false);
		        }
		    });
		    
		    b4.setBounds(20,110,60,25);  //自行決定元件位置與大小
		    cp.add(b4);
		    b4.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	dude.startFeedChicken(new Chicken());
		        	if(warehouse.getYoungChickenNumber()==0) {
		      	    	b4.setVisible(false);
		        	}
		      	    if(dude.getNum()==1)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	randomFirstlocation(0, arrCoordinateX, arrCoordinateY);
		      	    	b11.setBounds((int)arrCoordinateX[0], (int)arrCoordinateY[0],60,25);
		      	    	b11.setVisible(true);
		      	    	b11.setText("雞");
		      	    	b11.setVisible(true);
		      	    	b11.setText("雞");
		      	    	Timer timer = new Timer();
			        	RunningButton r0 = new RunningButton(b11, arrCoordinateX[0], arrCoordinateY[0]);
			        	timer.schedule(r0, 1000, 180);
		      	    }
		      	    if(dude.getNum()==2)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	randomFirstlocation(1, arrCoordinateX, arrCoordinateY);
		      	    	b12.setBounds((int)arrCoordinateX[1], (int)arrCoordinateY[1],60,25);
		      	    	b12.setVisible(true);
		      	    	b12.setText("雞");
		      	    	b12.setVisible(true);
		      	    	b12.setText("雞");
		      	    	Timer timer = new Timer();
			        	RunningButton r1 = new RunningButton(b12, arrCoordinateX[1], arrCoordinateY[1]);
			        	timer.schedule(r1, 1000, 180);
		      	    }
		      	    if(dude.getNum()==3)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	randomFirstlocation(2, arrCoordinateX, arrCoordinateY);
		      	    	b13.setBounds((int)arrCoordinateX[2], (int)arrCoordinateY[2],60,25);
		      	    	b13.setVisible(true);
		      	    	b13.setText("雞");
		      	    	b13.setVisible(true);
		      	    	b13.setText("雞");
		      	    	Timer timer = new Timer();
			        	RunningButton r2 = new RunningButton(b13, arrCoordinateX[2], arrCoordinateY[2]);
			        	timer.schedule(r2, 1000, 180);
		      	    }
		      	    if(dude.getNum()==4)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	randomFirstlocation(3, arrCoordinateX, arrCoordinateY);
		      	    	b14.setBounds((int)arrCoordinateX[3], (int)arrCoordinateY[3],60,25);
		      	    	b14.setVisible(true);
		      	    	b14.setText("雞");
		      	    	b14.setVisible(true);
		      	    	b14.setText("雞");
		      	    	Timer timer = new Timer();
			        	RunningButton r3 = new RunningButton(b14, arrCoordinateX[3], arrCoordinateY[3]);
			        	timer.schedule(r3, 1000, 180);
		      	    }
		      	    if(dude.getNum()==5)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	randomFirstlocation(4, arrCoordinateX, arrCoordinateY);
		      	    	b15.setBounds((int)arrCoordinateX[4], (int)arrCoordinateY[4],60,25);
		      	    	b15.setVisible(true);
		      	    	b15.setText("雞");
		      	    	b15.setVisible(true);
		      	    	b15.setText("雞");
		      	    	Timer timer = new Timer();
			        	RunningButton r4 = new RunningButton(b15, arrCoordinateX[4], arrCoordinateY[4]);
			        	timer.schedule(r4, 1000, 180);
		      	    }
		      	    if(dude.getNum()==6)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	randomFirstlocation(5, arrCoordinateX, arrCoordinateY);
		      	    	b16.setBounds((int)arrCoordinateX[5], (int)arrCoordinateY[5],60,25);
		      	    	b16.setVisible(true);
		      	    	b16.setText("雞");
		      	    	b16.setVisible(true);
		      	    	b16.setText("雞");
		      	    	Timer timer = new Timer();
			        	RunningButton r5 = new RunningButton(b16, arrCoordinateX[5], arrCoordinateY[5]);
			        	timer.schedule(r5, 1000, 180);
		      	    }
		      	    if(dude.getNum()==7)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	randomFirstlocation(6, arrCoordinateX, arrCoordinateY);
		      	    	b17.setBounds((int)arrCoordinateX[6], (int)arrCoordinateY[6],60,25);
		      	    	b17.setVisible(true);
		      	    	b17.setText("雞");
		      	    	b17.setVisible(true);
		      	    	b17.setText("雞");
		      	    	Timer timer = new Timer();
			        	RunningButton r6 = new RunningButton(b17, arrCoordinateX[6], arrCoordinateY[6]);
			        	timer.schedule(r6, 1000, 180);
		      	    }
		      	    if(dude.getNum()==8)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	randomFirstlocation(7, arrCoordinateX, arrCoordinateY);
		      	    	b18.setBounds((int)arrCoordinateX[7], (int)arrCoordinateY[7],60,25);
		      	    	b18.setVisible(true);
		      	    	b18.setText("雞");
		      	    	b18.setVisible(true);
		      	    	b18.setText("雞");
		      	    	Timer timer = new Timer();
			        	RunningButton r7 = new RunningButton(b18, arrCoordinateX[7], arrCoordinateY[7]);
			        	timer.schedule(r7, 1000, 180);
		      	    }
		      	    if(dude.getNum()==9)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	randomFirstlocation(8, arrCoordinateX, arrCoordinateY);
		      	    	b19.setBounds((int)arrCoordinateX[8], (int)arrCoordinateY[8],60,25);
		      	    	b19.setVisible(true);
		      	    	b19.setText("雞");
		      	    	b19.setVisible(true);
		      	    	b19.setText("雞");
		      	    	Timer timer = new Timer();
			        	RunningButton r8 = new RunningButton(b19, arrCoordinateX[8], arrCoordinateY[8]);
			        	timer.schedule(r8, 1000, 180);
		      	    }
		      	    if(dude.getNum()==10)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	randomFirstlocation(9, arrCoordinateX, arrCoordinateY);
		      	    	b20.setBounds((int)arrCoordinateX[9], (int)arrCoordinateY[9],60,25);
		      	    	b20.setVisible(true);
		      	    	b20.setText("雞");
		      	    	b20.setVisible(true);
		      	    	b20.setText("雞");
		      	    	Timer timer = new Timer();
			        	RunningButton r9 = new RunningButton(b20, arrCoordinateX[9], arrCoordinateY[9]);
			        	timer.schedule(r9, 1000, 180);	
		      	    }
		      	    b2.setVisible(false);
	      	    	b3.setVisible(false);
	      	    	b4.setVisible(false);
		        }
		    });
		    
		    
		    b11.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	num=1;
		        	System.out.printf("這是一隻%s\n", dude.getPondLand().get(0).getName());
		        	if(dude.getPondLand().get(0).getGrowingRate()<100)
		        	{
		        		
		        		System.out.printf("成長值=%d\n",dude.getPondLand().get(0).getGrowingRate());
		        		b5.setVisible(true);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(false);
		        	}
		        	else
		        	{
		        		System.out.printf("他不能再吃了!!!\n");
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(true);
		        		
		        	}
		        }
		    });
		    
		    b12.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	num=2;
		        	System.out.printf("這是一隻%s\n", dude.getPondLand().get(1).getName());
		        	if(dude.getPondLand().get(1).getGrowingRate()<100)
		        	{
		        		
		        		System.out.printf("成長值=%d\n",dude.getPondLand().get(1).getGrowingRate());
		        		b5.setVisible(true);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(false);
		        	}
		        	else
		        	{
		        		System.out.printf("他不能再吃了!!!\n");
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(true);
		        	}
		        }
		    });
		    b13.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	num=3;
		        	System.out.printf("這是一隻%s\n", dude.getPondLand().get(2).getName());
		        	if(dude.getPondLand().get(2).getGrowingRate()<100)
		        	{
		        		
		        		System.out.printf("成長值=%d\n",dude.getPondLand().get(2).getGrowingRate());
		        		b5.setVisible(true);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(false);
		        	}
		        	else
		        	{
		        		System.out.printf("他不能再吃了!!!\n");
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(true);
		        	}
		      	    
		        }
		    });
		    b14.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	num=4;
		        	System.out.printf("這是一隻%s\n", dude.getPondLand().get(3).getName());
		        	if(dude.getPondLand().get(3).getGrowingRate()<100)
		        	{
		        		
		        		System.out.printf("成長值=%d\n",dude.getPondLand().get(3).getGrowingRate());
		        		b5.setVisible(true);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(false);
		        	}
		        	else
		        	{
		        		System.out.printf("他不能再吃了!!!\n");
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(true);
		        	}
		      	    
		        }
		    });
		    b15.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	num=5;
		        	System.out.printf("這是一隻%s\n", dude.getPondLand().get(4).getName());
		        	if(dude.getPondLand().get(4).getGrowingRate()<100)
		        	{
		        		
		        		System.out.printf("成長值=%d\n",dude.getPondLand().get(4).getGrowingRate());
		        		b5.setVisible(true);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(false);
		        	}
		        	else
		        	{
		        		System.out.printf("他不能再吃了!!!\n");
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(true);
		        	}
		      	    
		        }
		    });
		    b16.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	num=6;
		        	System.out.printf("這是一隻%s\n", dude.getPondLand().get(5).getName());
		        	if(dude.getPondLand().get(5).getGrowingRate()<100)
		        	{
		        		
		        		System.out.printf("成長值=%d\n",dude.getPondLand().get(5).getGrowingRate());
		        		b5.setVisible(true);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(false);
		        	}
		        	else
		        	{
		        		System.out.printf("他不能再吃了!!!\n");
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(true);
		        	}
		      	    
		        }
		    });
		    b17.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	num=7;
		        	System.out.printf("這是一隻%s\n", dude.getPondLand().get(6).getName());
		        	if(dude.getPondLand().get(6).getGrowingRate()<100)
		        	{
		        		
		        		System.out.printf("成長值=%d\n",dude.getPondLand().get(6).getGrowingRate());
		        		b5.setVisible(true);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(false);
		        	}
		        	else
		        	{
		        		System.out.printf("他不能再吃了!!!\n");
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(true);
		        	}
		      	    
		        }
		    });
		    b18.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	num=8;
		        	System.out.printf("這是一隻%s\n", dude.getPondLand().get(7).getName());
		        	if(dude.getPondLand().get(7).getGrowingRate()<100)
		        	{
		        		
		        		System.out.printf("成長值=%d\n",dude.getPondLand().get(7).getGrowingRate());
		        		b5.setVisible(true);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(false);
		        		
		        	}
		        	else
		        	{
		        		System.out.printf("他不能再吃了!!!\n");
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(true);
		        	}
		      	    
		        }
		    });
		    b19.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	num=9;
		        	System.out.printf("這是一隻%s\n", dude.getPondLand().get(8).getName());
		        	if(dude.getPondLand().get(8).getGrowingRate()<100)
		        	{
		        		
		        		System.out.printf("成長值=%d\n",dude.getPondLand().get(8).getGrowingRate());
		        		b5.setVisible(true);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(false);
		        	}
		        	else
		        	{
		        		System.out.printf("他不能再吃了!!!\n");
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(true);
		        	}
		      	    
		        }
		    });
		    b20.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	num=10;
		        	System.out.printf("這是一隻%s\n", dude.getPondLand().get(9).getName());
		        	if(dude.getPondLand().get(9).getGrowingRate()<100)
		        	{
		        		
		        		System.out.printf("成長值=%d\n",dude.getPondLand().get(9).getGrowingRate());
		        		b5.setVisible(true);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(false);
		        	}
		        	else
		        	{
		        		System.out.printf("他不能再吃了!!!\n");
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        		b9.setVisible(true);
		        	}
		      	    
		        }
		    });
		    
		    
		    //b11.setBounds(250,20,60,25);  //自行決定元件位置與大小   
		    cp.add(b11);
		    //b12.setBounds(250,50,60,25);  //自行決定元件位置與大小   
		    cp.add(b12);
		    //b13.setBounds(250,80,60,25);  //自行決定元件位置與大小   
		    cp.add(b13);
		    //b14.setBounds(250,110,60,25);  //自行決定元件位置與大小   
		    cp.add(b14);
		    //b15.setBounds(250,140,60,25);  //自行決定元件位置與大小   
		    cp.add(b15);
		    //b16.setBounds(330,20,60,25);  //自行決定元件位置與大小
		    cp.add(b16);
		    //b17.setBounds(330,50,60,25);  //自行決定元件位置與大小
		    cp.add(b17);
		   // b18.setBounds(330,80,60,25);  //自行決定元件位置與大小
		    cp.add(b18);
		    //b19.setBounds(330,110,60,25);  //自行決定元件位置與大小
		    cp.add(b19); 
		    //b20.setBounds(330,140,60,25);  //自行決定元件位置與大小
		    cp.add(b20);
		    b9.setBounds(170,20,60,25);  //自行決定元件位置與大小
		    cp.add(b9);
		    
		    
		    //timer要close
		    
		    
		    b9.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	System.out.println("抓他阿笨蛋");
		        	System.out.println(num);
		        	dude.capturing(num);
		        	Capture(num, dude);
		        	System.out.printf("豬=%d\n",warehouse.getPigNumber());
		        	System.out.printf("雞=%d\n",warehouse.getChickenNumber());
		        	System.out.printf("牛=%d\n",warehouse.getCowNumber());
		        	
		        	
		        }
		    });


		    b5.setBounds(90,20,60,25);  //自行決定元件位置與大小
		    cp.add(b5);
		    b5.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(warehouse.getSimpleFeedNumber()>0)
		        		b6.setVisible(true);
		        	if(warehouse.getGeneralFeedNumber()>0)
		        		b7.setVisible(true);
		        	if(warehouse.getAdvencedFeedNumber()>0)
		        		b8.setVisible(true);
		        	System.out.printf("高%d\n",warehouse.getAdvencedFeedNumber());
		        	System.out.printf("中%d\n",warehouse.getGeneralFeedNumber());
		        	System.out.printf("低%d\n",warehouse.getSimpleFeedNumber());
		        }
		    });
		    
		    b6.setBounds(90,50,60,25);  //自行決定元件位置與大小
		    cp.add(b6);
		    b6.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	
		        	Feed(num, dude, new AdvancedFeed());
		        	warehouse.removeFeed("高級飼料");
		        	System.out.printf("%d\n", warehouse.getAdvencedFeedNumber());
		        	System.out.println("高級飼料+20 ouo");
		        	if(warehouse.getAdvencedFeedNumber()==0)
		        		b6.setVisible(false);
		        	else
		        		b6.setVisible(true);
		        	if(dude.getPondLand().get(num-1).getGrowingRate()==100)
		        	{
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        	}
		        	
		        }
		    });
		    
		    b7.setBounds(90,80,60,25);  //自行決定元件位置與大小
		    cp.add(b7);
		    b7.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	Feed(num, dude, new GeneralFeed());
		        	warehouse.removeFeed("中級飼料");
		        	System.out.printf("%d\n", warehouse.getGeneralFeedNumber());
		        	System.out.println("中級飼料+10 ouo");
		        	if(warehouse.getGeneralFeedNumber()==0)
		        		b7.setVisible(false);
		        	if(dude.getPondLand().get(num-1).getGrowingRate()==100)
		        	{
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        	}
		        }
		    });
		    
		    b8.setBounds(90,110,60,25);  //自行決定元件位置與大小
		    cp.add(b8);
		    b8.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	Feed(num, dude, new SimpleFeed());
		        	warehouse.removeFeed("低級飼料");
		        	System.out.printf("%d\n", warehouse.getSimpleFeedNumber());
		        	System.out.println("低級飼料+5 ouo");
		        	if(warehouse.getSimpleFeedNumber()==0)
		        		b8.setVisible(false);
		        	if(dude.getPondLand().get(num-1).getGrowingRate()==100)
		        	{
		        		b5.setVisible(false);
		        		b6.setVisible(false);
		        		b7.setVisible(false);
		        		b8.setVisible(false);
		        	}
		        }
		    });
		    
		    f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		    f.addWindowListener(new WindowAdapter()
		    {
		      public void windowClosing(WindowEvent e) 
		      {
		        int result=JOptionPane.showConfirmDialog(f,
		                   "確定要結束程式嗎?",
		                   "確認訊息",
		                   JOptionPane.YES_NO_OPTION,
		                   JOptionPane.WARNING_MESSAGE);
		        if (result==JOptionPane.YES_OPTION) 
		        {
		          System.exit(0);
		        }
		      }    
		    });
	  }
	  public void Feed(int num, Dude dude, Feed feed)
	  {
		  System.out.printf("num=%d\n", num);
		  dude.getPondLand().get(num-1).feeding(feed);
	  }
	  public void Capture(int num, Dude dude)
	  {
	  		for(int i=num; i<=dude.getNum(); i++)
	  		{
	  			button.get(i-1).setText(dude.getPondLand().get(i-1).getName());
	  		}
	  		button.get(dude.getNum()).setVisible(false);
	  }
	  
	  public void randomFirstlocation(int i, double arrCoordinateX[], double arrCoordinateY[]) {
		  arrCoordinateX[i] = (int) (Math.random()*450+20);
	      arrCoordinateY[i] = (int) (Math.random()*450+100);
	  }
	  
	    class RunningButton extends TimerTask {
	    	private JButton btn;
	    	private double coordinateX, coordinateY;
	    	private double vx = Math.sin(1) * 5;
	    	private double vy = Math.cos(1) * 5; 
	    	public RunningButton(JButton btn, double coordinateX, double coordinateY) {
	        	this.btn = btn;
	        	this.coordinateX = coordinateX;
	        	this.coordinateY = coordinateY;
	  	}
	        public void run() {
	            if (coordinateX + vx < 0) {
	                vx = -vx;
	            }
	            if (coordinateX + vx + 60 > 500) {
	                vx = -vx;
	            }
	            if (coordinateY + vy < 150) {
	                vy = -vy;
	            }
	            if (coordinateY + vy + 25 > 580) {
	                vy = -vy;
	            }
	            coordinateX += vx;
	            coordinateY += vy;
	            btn.setBounds((int) coordinateX, (int) coordinateY, 60, 25);
	    		
	        }
	    }
}
