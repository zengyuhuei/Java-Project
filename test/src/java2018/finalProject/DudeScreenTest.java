package java2018.finalProject;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class DudeScreenTest {
	  JFrame f;


	  public static void main(String argv[]) 
	  {
	    new DudeScreenTest();  
	  }
	  
	  public DudeScreenTest() 
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
}
