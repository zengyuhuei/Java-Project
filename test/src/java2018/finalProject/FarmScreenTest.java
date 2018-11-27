package java2018.finalProject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class FarmScreenTest extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmScreenTest frame = new FarmScreenTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			JFrame f = new JFrame("tool");
			f.setSize(400,400);
		    f.setVisible(true); 
		    Container cp=f.getContentPane();
		    cp.setLayout(null);  //取消預設之 BorderLayout
		    
		    JButton toolbutton = new JButton("澆水");
			toolbutton.setBounds(15, 66, 111, 36);
			cp.add(toolbutton);
			
			JButton toolbutton_1 = new JButton("施肥");
			toolbutton_1.setBounds(15, 117, 111, 36);
			cp.add(toolbutton_1);
			
			JButton toolbutton_2 = new JButton("播種");
			toolbutton_2.setBounds(15, 168, 111, 36);
			toolbutton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame jf = new JFrame("seed");
					jf.setSize(300,300);
				    jf.setVisible(true); 
				    Container cp2=jf.getContentPane();
				    cp2.setLayout(null);  //取消預設之 BorderLayout
				    
				    JButton seedbutton = new JButton("corn");
					seedbutton.setBounds(15, 15, 111, 36);
					cp2.add(seedbutton);
					seedbutton.addActionListener(new ActionListener() {
				        public void actionPerformed(ActionEvent e) {
				        	ArrayList<Crop> crop = new ArrayList<Crop>();
			    			crop.add(new Corn());
			    			String cropName;
			    			cropName = crop.get(0).pickSeed();
			    			System.out.println("你按了"+cropName+"ouo");
				        }
				    });
					
					JButton seedbutton_1 = new JButton("wheat");
					seedbutton_1.setBounds(15, 66, 111, 36);
					cp2.add(seedbutton_1);
					seedbutton_1.addActionListener(new ActionListener() {
				        public void actionPerformed(ActionEvent e) {
				        	ArrayList<Crop> crop = new ArrayList<Crop>();
			    			crop.add(new Wheat());
			    			String cropName;
			    			cropName = crop.get(0).pickSeed();
			    			System.out.println("你按了"+cropName+"ouo");
				        }
				    });
					
					JButton seedbutton_2 = new JButton("cabbage");
					seedbutton_2.setBounds(15, 117, 111, 36);
					cp2.add(seedbutton_2);
					seedbutton_2.addActionListener(new ActionListener() {
				        public void actionPerformed(ActionEvent e) {
				        	ArrayList<Crop> crop = new ArrayList<Crop>();
			    			crop.add(new Cabbage());
			    			String cropName;
			    			cropName = crop.get(0).pickSeed();
			    			System.out.println("你按了"+cropName+"ouo");
				        }
				    });
					
				}
			});
			cp.add(toolbutton_2);
			
			JButton toolbutton_3 = new JButton("收割");
			toolbutton_3.setBounds(15, 15, 111, 36);
			cp.add(toolbutton_3);
		    
		}
	}
	public FarmScreenTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Land11");
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new Listener());
		btnNewButton.setBounds(15, 15, 111, 36);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Land21");
		button.addActionListener(new Listener());
		button.setAction(action);
		button.setBounds(15, 66, 111, 36);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Land31");
		button_1.addActionListener(new Listener());
		button_1.setAction(action);
		button_1.setBounds(15, 117, 111, 36);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Land41");
		button_2.addActionListener(new Listener());
		button_2.setAction(action);
		button_2.setBounds(15, 168, 111, 36);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Land12");
		button_3.addActionListener(new Listener());
		button_3.setAction(action);
		button_3.setBounds(141, 18, 111, 36);
		contentPane.add(button_3);
		
		
		JButton button_4 = new JButton("Land22");
		button_4.addActionListener(new Listener());
		button_4.setAction(action);
		button_4.setBounds(141, 69, 111, 36);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Land32");
		button_5.addActionListener(new Listener());
		button_5.setAction(action);
		button_5.setBounds(141, 120, 111, 36);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("Land42");
		button_6.addActionListener(new Listener());
		button_6.setAction(action);
		button_6.setBounds(141, 171, 111, 36);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("Land13");
		button_7.addActionListener(new Listener());
		button_7.setAction(action);
		button_7.setBounds(267, 18, 111, 36);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("Land23");
		button_8.addActionListener(new Listener());
		button_8.setAction(action);
		button_8.setBounds(267, 69, 111, 36);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("Land33");
		button_9.addActionListener(new Listener());
		button_9.setAction(action);
		button_9.setBounds(267, 120, 111, 36);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("Land43");
		button_10.addActionListener(new Listener());
		button_10.setAction(action);
		button_10.setBounds(267, 171, 111, 36);
		contentPane.add(button_10);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Land");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
