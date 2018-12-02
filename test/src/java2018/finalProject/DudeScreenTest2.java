package java2018.finalProject;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class DudeScreenTest2 {
	  JFrame f;
	  public double [] arrCoordinateX = new double[10];
	  public double [] arrCoordinateY = new double[10];
	  public int count = 0;
	  public static void main(String argv[]) 
	  {
	    new DudeScreenTest2();  
	  }
	  
	  public DudeScreenTest2() 
	  {
		    JFrame.setDefaultLookAndFeelDecorated(true);
		    JDialog.setDefaultLookAndFeelDecorated(true);
		    f=new JFrame("JButton1");
		    f.setBounds(0,0,500,600); 
		    f.setVisible(true); 
		    Container cp=f.getContentPane();
		    cp.setLayout(null);  //取消預設之 BorderLayout
		    
		    
		    //倉庫
		    /*WareHouse wareHouse = new WareHouse();
		    Animal pig = new Pig();
		    Animal chicken = new Chicken();
		    Animal cow = new Cow();
		    wareHouse.addYoungAnimal(pig);
		    wareHouse.addYoungAnimal(chicken);
		    wareHouse.addYoungAnimal(cow);
		    Dude dude = new Dude(wareHouse);*/
		    
		    //按鈕
		    JButton b1 = new JButton("養殖");
		    JButton b2 = new JButton("牛");
		    JButton b11 = new JButton("動物");
		    JButton b12 = new JButton("動物");
		    b2.setVisible(false);
		    b11.setVisible(false);
		    b12.setVisible(false);
		  		    
		    b1.setBounds(20,20,60,25);  //自行決定元件位置與大小   (x, y, 橫, 直)
		    cp.add(b1);
		    b1.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	b2.setVisible(true);
		        	System.out.println("開始養殖");
		        }
		    });
		    
		    b2.setBounds(20,50,60,25);  //自行決定元件位置與大小
		    cp.add(b2);
		    b2.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(count==0) {
		        		randomFirstlocation(0, arrCoordinateX, arrCoordinateY);
		        		b11.setBounds((int)arrCoordinateX[0], (int)arrCoordinateY[0],60,25);
		        		b11.setVisible(true);
			        	System.out.println("來養牛啦");
			        	b11.setText("牛");			        	
			        	Timer timer = new Timer();
			        	RunningButton r0 = new RunningButton(b11, arrCoordinateX[0], arrCoordinateY[0]);
			        	timer.schedule(r0, 1000, 180);
			            count++;
			            System.out.println(count);
		        	}
		        	if(count==1) {
		        		randomFirstlocation(1, arrCoordinateX, arrCoordinateY);
		        		b12.setBounds((int)arrCoordinateX[1], (int)arrCoordinateY[1],60,25);
		        		b12.setVisible(true);
			        	System.out.println("來養牛啦");
			        	b12.setText("牛牛");			        	
			        	Timer timer = new Timer();
			        	RunningButton r1 = new RunningButton(b12, arrCoordinateX[1], arrCoordinateY[1]);
			        	timer.schedule(r1, 1000, 180);
			            count++;
			            System.out.println(count);
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
		    
		    b12.setBounds((int)arrCoordinateX[1], (int)arrCoordinateY[1],60,25);
		    cp.add(b12);
		    b12.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	System.out.println("這隻動物是" + b12.getText());
		        	
		        }
		    }); 
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
	            if (coordinateY + vy < 100) {
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

