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

public class DudeScreen {
	  JFrame f;


	  public static void main(String argv[]) 
	  {
	    new DudeScreen();  
	  }

	  public DudeScreen() 
	  {
		 
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);
	    f=new JFrame("JButton1");
	    f.setBounds(0,0,450,800); 
	    f.setVisible(true); 
	    Container cp=f.getContentPane();
	    cp.setLayout(null);  //取消預設之 BorderLayout
	    WareHouse wareHouse = new WareHouse();
	    Animal pig = new Pig();
	    Animal chicken = new Chicken();
	    Animal cow = new Cow();
	    wareHouse.addYoungAnimal(pig);
	    wareHouse.addYoungAnimal(chicken);
	    wareHouse.addYoungAnimal(cow);
	    Dude dude = new Dude(wareHouse);
	    
	    JButton b1 = new JButton("養殖");
	    JButton b2 = new JButton("牛");
	    JButton b3 = new JButton("豬");
	    JButton b4 = new JButton("雞");
	    JButton b11 = new JButton("1");
	    JButton b12 = new JButton("2");
	    JButton b13 = new JButton("3");
	    
	    b1.setBounds(20,20,60,25);  //自行決定元件位置與大小   (x, y, 橫, 直)
	    cp.add(b1);
	    b1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("我想養東西ouo");
	        }
	    });
	    
	    b2.setBounds(20,50,60,25);  //自行決定元件位置與大小
	    cp.add(b2);
	    b11.setEnabled(false);
	    b2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	dude.startFeedCow(cow);
	        	System.out.println(dude.getNum());
	    		System.out.println("你按了牛ouo");
	      	    if(dude.getNum()<1)
	      	    {
	      	    	b11.setEnabled(false);
	      	    }
	      	    else
	      	    {
	      	    	b11.setEnabled(true);
	      	    }
	        }    
	    });

	    b3.setBounds(20,80,60,25);  //自行決定元件位置與大小
	    cp.add(b3);
	    b3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	dude.startFeedPig(pig);
	        	System.out.println(dude.getNum());
	    		System.out.println("你按了豬ouo");
	        }
	    });
	    
	    b4.setBounds(20,110,60,25);  //自行決定元件位置與大小
	    cp.add(b4);
	    b4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	dude.startFeedChicken(chicken);
	        	System.out.println(dude.getNum());
	        	//dude.startFeedChicken(chicken);
	    		System.out.println("你按了雞ouo");
	        }
	    });
	    
	   /* JButton b5 = new JButton("餵食");
	    b5.setBounds(90,20,60,25);  //自行決定元件位置與大小
	    cp.add(b5);
	    b5.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		//if(num == 1)
	    		//{
	    			//Corn crop = new Crop();
	    			System.out.println("我想餵食ouo");
	    		//}
	        }
	    });
	    
	    JButton b6 = new JButton("高級飼料");
	    b6.setBounds(90,50,60,25);  //自行決定元件位置與大小
	    cp.add(b6);
	    b6.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("高級飼料+20 ouo");
	        }
	    });
	    
	    JButton b7 = new JButton("中級飼料");
	    b7.setBounds(90,80,60,25);  //自行決定元件位置與大小
	    cp.add(b7);
	    b7.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("中級飼料+10 ouo");
	        }
	    });
	    
	    JButton b8 = new JButton("低級飼料");
	    b8.setBounds(90,110,60,25);  //自行決定元件位置與大小
	    cp.add(b8);
	    b8.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("低級飼料+5 ouo");
	        }
	    });
	    
	    JButton b9 = new JButton("回首頁");
	    b9.setBounds(170,20,60,25);  //自行決定元件位置與大小
	    cp.add(b9);
	    b9.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("沒有畫面 ouo");
	        }
	    });
	    
	    JButton b10 = new JButton("牧場數量");
	    b10.setBounds(170,50,60,25);  //自行決定元件位置與大小
	    cp.add(b10);
	    b10.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("牧場目前動物數量  ouo");
	        }
	    });
	    */
	    b11.setBounds(250,20,60,25);  //自行決定元件位置與大小
	    cp.add(b11);

	    b11.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("這是一隻動物 ouo");
	        }
	    });
	    
	    b12.setBounds(250,50,60,25);  //自行決定元件位置與大小
	    cp.add(b12);
	    b12.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("這是一隻動物 ouo");
	        }
	    });
	    
	    b13.setBounds(250,80,60,25);  //自行決定元件位置與大小
	    cp.add(b13);
	    b13.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("這是一隻動物 ouo");
	        }
	    });
	    
	    /*JButton b14 = new JButton("4");
	    b14.setBounds(250,110,60,25);  //自行決定元件位置與大小
	    cp.add(b14);
	    b14.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("這是一隻動物 ouo");
	        }
	    });
	    
	    JButton b15 = new JButton("5");
	    b15.setBounds(250,140,60,25);  //自行決定元件位置與大小
	    cp.add(b15);
	    b15.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("這是一隻動物 ouo");
	        }
	    });
	    
	    JButton b16 = new JButton("6");
	    b16.setBounds(330,20,60,25);  //自行決定元件位置與大小
	    cp.add(b16);
	    b16.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("這是一隻動物 ouo");
	        }
	    });
	    
	    JButton b17 = new JButton("7");
	    b17.setBounds(330,50,60,25);  //自行決定元件位置與大小
	    cp.add(b17);
	    b17.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("這是一隻動物 ouo");
	        }
	    });
	    
	    JButton b18 = new JButton("8");
	    b18.setBounds(330,80,60,25);  //自行決定元件位置與大小
	    cp.add(b18);
	    b18.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("這是一隻動物 ouo");
	        }
	    });
	    
	    JButton b19 = new JButton("9");
	    b19.setBounds(330,110,60,25);  //自行決定元件位置與大小
	    cp.add(b19);
	    b19.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("這是一隻動物 ouo");
	        }
	    });
	    
	    JButton b20 = new JButton("10");
	    b20.setBounds(330,140,60,25);  //自行決定元件位置與大小
	    cp.add(b20);
	    if(9 > dude.getPondLand().size())
	    {
	    	b20.setEnabled(false);
	    }

	    //System.out.println(dude.getPondLand().get(9));
	    
	    
	    b20.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("這是一隻動物 ouo");
	        }
	    });
	    //System.out.println("ouo??");
	    */
	    
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
	  public static void reload(Dude dude, JButton b)
	  {
	  	    if(dude.getNum()<dude.getNum()+1)
	  	    {
	  	    	b.setEnabled(false);
	  	    }
	  	    else
	  	    {
	  	    	b.setEnabled(true);
	  	    }
      }	
}
