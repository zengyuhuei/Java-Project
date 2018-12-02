package java2018.finalProject;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class DudeScreenTest {
	JFrame f;
	int num;
	JButton b1 = new JButton("養殖");
	JButton b2 = new JButton("牛");
	JButton b3 = new JButton("豬");
	JButton b4 = new JButton("雞");
	JButton b5 = new JButton("餵食");
	JButton b6 = new JButton("高級飼料");
	JButton b7 = new JButton("中級飼料");
	JButton b8 = new JButton("低級飼料");
	JButton b9 = new JButton("捕捉");
	JButton b11 = new JButton("動物");
	JButton b12 = new JButton("動物");
	JButton b13 = new JButton("動物");
	JButton b14 = new JButton("動物");
	JButton b15 = new JButton("動物");
	JButton b16 = new JButton("動物");
	JButton b17 = new JButton("動物");
	JButton b18 = new JButton("動物");
	JButton b19 = new JButton("動物");
	JButton b20 = new JButton("動物");
	ArrayList<JButton> button = new ArrayList<JButton>(10);
	public static void main(String argv[]) 
	{
		new DudeScreenTest();  
	    
	}
	  
	public DudeScreenTest() 
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
		f.setBounds(0,0,450,800); 
		f.setVisible(true); 
		Container cp=f.getContentPane();
		cp.setLayout(null);  //取消預設之 BorderLayout
		WareHouse wareHouse = new WareHouse();
		Animal pig1 = new Pig();
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
		wareHouse.addYoungAnimal(chicken1);
		wareHouse.addYoungAnimal(chicken2);
		wareHouse.addYoungAnimal(chicken3);
		wareHouse.addYoungAnimal(cow1);
		wareHouse.addYoungAnimal(cow2);
		wareHouse.addYoungAnimal(cow3);
		wareHouse.addYoungAnimal(cow4);
		Dude dude = new Dude(wareHouse);
			
			
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
	    	if(wareHouse.getYoungCowNumber()==0) {
	    		b2.setVisible(false);
		    }
		   	if(wareHouse.getYoungCowNumber()>0) {
		   		b2.setVisible(true);
		   	}
		   	if(wareHouse.getYoungPigNumber()==0) {
	    		b3.setVisible(false);
	    	}
		   	if(wareHouse.getYoungPigNumber()>0) {
		    	b3.setVisible(true);
		   	}
		   	if(wareHouse.getYoungChickenNumber()==0) {
		   		b4.setVisible(false);
	    	}
	    	if(wareHouse.getYoungChickenNumber()>0) {
		    	b4.setVisible(true);
		    }
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
		        	if(wareHouse.getYoungCowNumber()==0) {
		        		b2.setVisible(false);
		        	}
		      	    if(dude.getNum()==1)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	b11.setVisible(true);
		      	    	b11.setText("牛");
		      	    }
		      	    if(dude.getNum()==2)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	b12.setVisible(true);
		      	    	b12.setText("牛");
		      	    }
		      	    if(dude.getNum()==3)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	b13.setVisible(true);
		      	    	b13.setText("牛");
		      	    }
		      	    if(dude.getNum()==4)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	b14.setVisible(true);
		      	    	b14.setText("牛");
		      	    }
		      	    if(dude.getNum()==5)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	b15.setVisible(true);
		      	    	b15.setText("牛");
		      	    }
		      	    if(dude.getNum()==6)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	b16.setVisible(true);
		      	    	b16.setText("牛");
		      	    }
			      	if(dude.getNum()==7)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	b17.setVisible(true);
		      	    	b17.setText("牛");
		      	    }
			      	if(dude.getNum()==8)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	b18.setVisible(true);
		      	    	b18.setText("牛");
		      	    }
			      	if(dude.getNum()==9)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	b19.setVisible(true);
		      	    	b19.setText("牛");
		      	    }
			      	if(dude.getNum()==10)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	b20.setVisible(true);
		      	    	b20.setText("牛");
		      	    	
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
		        	if(wareHouse.getYoungPigNumber()==0) {
		      	    	b3.setVisible(false);
		        	}
		      	    if(dude.getNum()==1)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	b11.setVisible(true);
		      	    	b11.setText("豬");
		      	    }
		      	    if(dude.getNum()==2)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	b12.setVisible(true);
		      	    	b12.setText("豬");
		      	    }
		      	    if(dude.getNum()==3)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	b13.setVisible(true);
		      	    	b13.setText("豬");
		      	    }
		      	    if(dude.getNum()==4)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	b14.setVisible(true);
		      	    	b14.setText("豬");
		      	    }
		      	    if(dude.getNum()==5)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	b15.setVisible(true);
		      	    	b15.setText("豬");
		      	    }
		      	  if(dude.getNum()==6)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	b16.setVisible(true);
		      	    	b16.setText("豬");
		      	    }
		      	    if(dude.getNum()==7)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	b17.setVisible(true);
		      	    	b17.setText("豬");
		      	    }
		      	    if(dude.getNum()==8)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	b18.setVisible(true);
		      	    	b18.setText("豬");
		      	    }
		      	    if(dude.getNum()==9)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	b19.setVisible(true);
		      	    	b19.setText("豬");
		      	    }
		      	    if(dude.getNum()==10)
		      	    {
		      	    	System.out.println("你可以養這隻豬ouo");
		      	    	b20.setVisible(true);
		      	    	b20.setText("豬");
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
		        	if(wareHouse.getYoungChickenNumber()==0) {
		      	    	b4.setVisible(false);
		        	}
		      	    if(dude.getNum()==1)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	b11.setVisible(true);
		      	    	b11.setText("雞");
		      	    }
		      	    if(dude.getNum()==2)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	b12.setVisible(true);
		      	    	b12.setText("雞");
		      	    }
		      	    if(dude.getNum()==3)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	b13.setVisible(true);
		      	    	b13.setText("雞");
		      	    }
		      	    if(dude.getNum()==4)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	b14.setVisible(true);
		      	    	b14.setText("雞");
		      	    }
		      	    if(dude.getNum()==5)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	b15.setVisible(true);
		      	    	b15.setText("雞");
		      	    }
		      	    if(dude.getNum()==6)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	b16.setVisible(true);
		      	    	b16.setText("雞");
		      	    }
		      	    if(dude.getNum()==7)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	b17.setVisible(true);
		      	    	b17.setText("雞");
		      	    }
		      	    if(dude.getNum()==8)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	b18.setVisible(true);
		      	    	b18.setText("雞");
		      	    }
		      	    if(dude.getNum()==9)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	b19.setVisible(true);
		      	    	b19.setText("雞");
		      	    }
		      	    if(dude.getNum()==10)
		      	    {
		      	    	System.out.println("你可以養這隻雞ouo");
		      	    	b20.setVisible(true);
		      	    	b20.setText("雞");
		      	    	
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
		        	}
		      	    
		        }
		    });
		    
		    
		    b11.setBounds(250,20,60,25);  //自行決定元件位置與大小   1
		    cp.add(b11);
		    b12.setBounds(250,50,60,25);  //自行決定元件位置與大小   1
		    cp.add(b12);
		    b13.setBounds(250,80,60,25);  //自行決定元件位置與大小   1
		    cp.add(b13);
		    b14.setBounds(250,110,60,25);  //自行決定元件位置與大小   1
		    cp.add(b14);
		    b15.setBounds(250,140,60,25);  //自行決定元件位置與大小   1
		    cp.add(b15);
		    b16.setBounds(330,20,60,25);  //自行決定元件位置與大小
		    cp.add(b16);
		    b17.setBounds(330,50,60,25);  //自行決定元件位置與大小
		    cp.add(b17);
		    b18.setBounds(330,80,60,25);  //自行決定元件位置與大小
		    cp.add(b18);
		    b19.setBounds(330,110,60,25);  //自行決定元件位置與大小
		    cp.add(b19); 
		    b20.setBounds(330,140,60,25);  //自行決定元件位置與大小
		    cp.add(b20);
		    b9.setBounds(170,20,60,25);  //自行決定元件位置與大小
		    cp.add(b9);
		    
		    b9.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	System.out.println("抓他阿笨蛋");
		        	System.out.println(num);
		        	dude.capturing(num);
		        	Capture(num, dude);
		        	System.out.printf("豬=%d\n",wareHouse.getPigNumber());
		        	System.out.printf("雞=%d\n",wareHouse.getChickenNumber());
		        	System.out.printf("牛=%d\n",wareHouse.getCowNumber());
		        	
		        	
		        }
		    });


		    b5.setBounds(90,20,60,25);  //自行決定元件位置與大小
		    cp.add(b5);
		    b5.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(wareHouse.getSimpleFeedNumber()>0)
		        		b6.setVisible(true);
		        	if(wareHouse.getGeneralFeedNumber()>0)
		        		b7.setVisible(true);
		        	if(wareHouse.getAdvencedFeedNumber()>0)
		        		b8.setVisible(true);
		        }
		    });
		    
		    b6.setBounds(90,50,60,25);  //自行決定元件位置與大小
		    cp.add(b6);
		    b6.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	
		        	Feed(num, dude, feed3);
		        	wareHouse.removeFeed("高級飼料");
		        	System.out.printf("%d\n", wareHouse.getAdvencedFeedNumber());
		        	System.out.println("高級飼料+20 ouo");
		        	if(wareHouse.getAdvencedFeedNumber()==0)
		        		b6.setVisible(false);
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
		        	Feed(num, dude, feed2);
		        	wareHouse.removeFeed("中級飼料");
		        	System.out.printf("%d\n", wareHouse.getGeneralFeedNumber());
		        	System.out.println("中級飼料+10 ouo");
		        	if(wareHouse.getGeneralFeedNumber()==0)
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
		        	Feed(num, dude, feed1);
		        	wareHouse.removeFeed("低級飼料");
		        	System.out.printf("%d\n", wareHouse.getSimpleFeedNumber());
		        	System.out.println("低級飼料+5 ouo");
		        	if(wareHouse.getSimpleFeedNumber()==0)
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
}
