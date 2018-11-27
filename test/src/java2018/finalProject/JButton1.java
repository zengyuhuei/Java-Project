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
    f.setBounds(0,0,400,300); 
    f.setVisible(true); 
    Container cp=f.getContentPane();
    cp.setLayout(null);  //取消預設之 BorderLayout

    JButton b1 = new JButton("corn");
    b1.setBounds(20,20,100,40);  //自行決定元件位置與大小
    cp.add(b1);
    b1.addActionListener(new ActionListener() {
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

    JButton b2 = new JButton("wheat");
    b2.setBounds(20,70,100,40);  //自行決定元件位置與大小
    cp.add(b2);
    b2.addActionListener(new ActionListener() {
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

    JButton b3 = new JButton("cabbage");
    b3.setBounds(20,120,100,40);  //自行決定元件位置與大小
    cp.add(b3);
    b3.addActionListener(new ActionListener() {
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
