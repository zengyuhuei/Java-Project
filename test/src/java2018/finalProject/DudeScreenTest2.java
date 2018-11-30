package java2018.finalProject;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
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

public class DudeScreenTest2 {
	  JFrame f;


	  public static void main(String argv[]) 
	  {
	    new DudeScreenTest2();  
	  }
	  
	  public DudeScreenTest2() 
	  {
		    JFrame.setDefaultLookAndFeelDecorated(true);
		    JDialog.setDefaultLookAndFeelDecorated(true);
		    f=new JFrame("JButton1");
		    f.setBounds(0,0,450,800); 
		    f.setVisible(true); 
		    Container cp=f.getContentPane();
		    cp.setLayout(null);  //取消預設之 BorderLayout
		    
		    //倉庫
		    WareHouse wareHouse = new WareHouse();
		    Animal pig = new Pig();
		    Animal chicken = new Chicken();
		    Animal cow = new Cow();
		    wareHouse.addYoungAnimal(pig);
		    wareHouse.addYoungAnimal(chicken);
		    wareHouse.addYoungAnimal(cow);
		    Dude dude = new Dude(wareHouse);
		    
		    //按鈕
		    JButton b1 = new JButton("養殖");
		    JButton b2 = new JButton("牛");
		    JButton b3 = new JButton("豬");
		    JButton b4 = new JButton("雞");
		    JButton b11 = new JButton("動物");
		    
		    //移動
		    int [] arr = new int[2];
		    double coordinateX, coordinateY, vx, vy;
	        coordinateX = (int) (Math.random()*200+50);
	        coordinateY = (int) (Math.random()*200+150);
	        vx = Math.sin(1) * 5;
	        vy = Math.cos(1) * 5;
	        
		    //b2.setEnabled(false);
		    b2.setVisible(false);
		    //b3.setEnabled(false);
		    b3.setVisible(false);
		    //b4.setEnabled(false);
		    b4.setVisible(false);
		    //b11.setEnabled(false);
		    b11.setVisible(false);
		    
		    b1.setBounds(20,20,60,25);  //自行決定元件位置與大小   (x, y, 橫, 直)
		    cp.add(b1);
		    b1.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(wareHouse.getYoungCowNumber()==0) {
		        		//b2.setEnabled(false);
		        		b2.setVisible(false);
		        	}
		        	if(wareHouse.getYoungCowNumber()>0) {
		        		//b2.setEnabled(true);
		        		b2.setVisible(true);
		        	}
		        	if(wareHouse.getYoungPigNumber()==0) {
		        		//b3.setEnabled(false);
		        		b3.setVisible(false);
		        	}
		        	if(wareHouse.getYoungPigNumber()>0) {
		        		//b3.setEnabled(true);
		        		b3.setVisible(true);
		        	}
		        	if(wareHouse.getYoungChickenNumber()==0) {
		        		//b4.setEnabled(false);
		        		b4.setVisible(false);
		        	}
		        	if(wareHouse.getYoungChickenNumber()>0) {
		        		//b4.setEnabled(true);
		        		b4.setVisible(true);
		        	}
		        	System.out.println("想養東西ouo");
		      	    if(dude.getNum()==1)
		      	    {
		    		    //b2.setEnabled(false);
		    		    //b3.setEnabled(false);
		    		    //b4.setEnabled(false);
		    		    b2.setVisible(false);
		    		    b3.setVisible(false);
		    		    b4.setVisible(false);
		    		    System.out.println("牧場已經塞不下動物了!!");
		      	    }

		        }
		    });
		    
		    b2.setBounds(20,50,60,25);  //自行決定元件位置與大小
		    cp.add(b2);
		    b2.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	dude.startFeedCow(cow);
		        	//System.out.println(dude.getNum());
		        	if(wareHouse.getYoungCowNumber()==0) {
		        		//b2.setEnabled(false);
		        		b2.setVisible(false);
		        	}
		      	    if(dude.getNum()<1)
		      	    {
		      	    	//b11.setEnabled(false);
		      	    	b11.setVisible(false);
		      	    }
		      	    if(dude.getNum()==1)
		      	    {
		      	    	System.out.println("你可以養這隻牛ouo");
		      	    	//b11.setEnabled(true);
		      	    	b11.setVisible(true);
		      	    	b11.setText("牛");
		      	    	//b2.setEnabled(false);
		      	    	//b3.setEnabled(false);
		      	    	//b4.setEnabled(false);
		      	    	b2.setVisible(false);
		      	    	b3.setVisible(false);
		      	    	b4.setVisible(false);
		      	    	
		      	    	//int test = 15;
		      	    	//int count, sum, derection;
			    		b11.setBounds((int) coordinateX,(int) coordinateY, 60, 25);
			    		
		      	    }
		        }    
		    });
		    
		    //b11.setBounds(250,20,60,25);  //自行決定元件位置與大小  
		    cp.add(b11);
		    b11.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	System.out.println("這隻動物是" + b11.getText());
		        	
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

