package java2018.finalProject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//from ww  w.j a  v  a  2s. c  o  m
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FishScreen {

	public static void main(String[] args) {
		
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(new Fish());
	    frame.pack();
	    frame.setVisible(true);
	}

}
