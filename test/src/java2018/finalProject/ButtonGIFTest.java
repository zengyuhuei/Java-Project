package java2018.finalProject;
import java.awt.*;          
import java.awt.event.*;
import javax.swing.*;

public class ButtonGIFTest extends JFrame
{
  public ButtonGIFTest()
  {
    Container c = getContentPane();
    c.setLayout(new GridLayout(4,1));
                                           // only text on the button

    JButton btn1 = new JButton("Sparrow Bird");	
    c.add(btn1);
                                          // only image on the button
    ImageIcon ic2 = new ImageIcon("../picture/chicken.gif");
    JButton btn2 = new JButton(ic2);	
    c.add(btn2);
                       // by default label is right and image is left
    ImageIcon ic3 = new ImageIcon("../picture/pig.gif");
    JButton btn3 = new JButton(ic3);	
    c.add(btn3);
                                  // label is left and image is right
    ImageIcon ic4 = new ImageIcon("../picture/cow.gif");
    JButton btn4 = new JButton(ic4);	
    btn4.setHorizontalTextPosition(SwingConstants.LEFT);
    c.add(btn4);
		
    setTitle("Using JButton");
    setSize(300,300);
    setVisible(true);
  }
  public static void main(String args[])
  {
    new ButtonGIFTest();
  }
}
