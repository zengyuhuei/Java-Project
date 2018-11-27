package java2018.finalProject;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class JButton1 
{
  JFrame f;


  public static void main(String argv[]) 
  {
    new JButton1();  
  }

  public JButton1() 
  {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
    f=new JFrame("JButton1");
    f.setBounds(0,0,500,500); 
    f.setVisible(true); 
    Container cp=f.getContentPane();
    cp.setLayout(null);  //取消預設之 BorderLayout

    JButton b11 = new JButton("Land11");
    b11.setBounds(20,20,100,40);  //自行決定元件位置與大小
    cp.add(b11);
    b11.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	ArrayList<Crop> crop = new ArrayList<Crop>();
    		//if(num == 1)
    		//{
    			//Corn crop = new Crop();
    			crop.add(new Corn());
    			String cropName;
    			cropName = crop.get(0).pickSeed();
    			System.out.println("你按了"+cropName+"ouo");
    		//}
        }
    });
    
    JButton b12 = new JButton("Land12");
    b12.setBounds(120,20,100,40);  //自行決定元件位置與大小
    cp.add(b12);
    b12.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	ArrayList<Crop> crop = new ArrayList<Crop>();
    		//if(num == 1)
    		//{
    			//Corn crop = new Crop();
    			crop.add(new Corn());
    			String cropName;
    			cropName = crop.get(0).pickSeed();
    			System.out.println("你按了"+cropName+"ouo");
    		//}
        }
    });
    
    JButton b13 = new JButton("Land13");
    b13.setBounds(220,20,100,40);  //自行決定元件位置與大小
    cp.add(b13);
    b13.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	ArrayList<Crop> crop = new ArrayList<Crop>();
    		//if(num == 1)
    		//{
    			//Corn crop = new Crop();
    			crop.add(new Corn());
    			String cropName;
    			cropName = crop.get(0).pickSeed();
    			System.out.println("你按了"+cropName+"ouo");
    		//}
        }
    });

    JButton b21 = new JButton("Land21");
    b21.setBounds(20,70,100,40);  //自行決定元件位置與大小
    cp.add(b21);
    b21.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	ArrayList<Crop> crop = new ArrayList<Crop>();
			//Corn crop = new Crop();
			crop.add(new Wheat());
			String cropName;
			cropName = crop.get(0).pickSeed();
			System.out.println("你按了"+cropName+"ouo");
        }
    });
    
    JButton b22 = new JButton("Land22");
    b22.setBounds(120,70,100,40);  //自行決定元件位置與大小
    cp.add(b22);
    b22.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	ArrayList<Crop> crop = new ArrayList<Crop>();
			//Corn crop = new Crop();
			crop.add(new Wheat());
			String cropName;
			cropName = crop.get(0).pickSeed();
			System.out.println("你按了"+cropName+"ouo");
        }
    });
    
    JButton b23 = new JButton("Land23");
    b23.setBounds(220,70,100,40);  //自行決定元件位置與大小
    cp.add(b23);
    b23.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	ArrayList<Crop> crop = new ArrayList<Crop>();
			//Corn crop = new Crop();
			crop.add(new Wheat());
			String cropName;
			cropName = crop.get(0).pickSeed();
			System.out.println("你按了"+cropName+"ouo");
        }
    });

    JButton b31 = new JButton("Land31");
    b31.setBounds(20,120,100,40);  //自行決定元件位置與大小
    cp.add(b31);
    b31.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	ArrayList<Crop> crop = new ArrayList<Crop>();
			crop.add(new Cabbage());
			String cropName;
			cropName = crop.get(0).pickSeed();
			System.out.println("你按了"+cropName+"ouo");
        }
    });
    
    JButton b32 = new JButton("Land32");
    b32.setBounds(120,120,100,40);  //自行決定元件位置與大小
    cp.add(b32);
    b32.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	ArrayList<Crop> crop = new ArrayList<Crop>();
			crop.add(new Cabbage());
			String cropName;
			cropName = crop.get(0).pickSeed();
			System.out.println("你按了"+cropName+"ouo");
        }
    });
    
    JButton b33 = new JButton("Land33");
    b33.setBounds(220,120,100,40);  //自行決定元件位置與大小
    cp.add(b33);
    b33.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	ArrayList<Crop> crop = new ArrayList<Crop>();
			crop.add(new Cabbage());
			String cropName;
			cropName = crop.get(0).pickSeed();
			System.out.println("你按了"+cropName+"ouo");
        }
    });
    //System.out.println("ouo??");
    
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
