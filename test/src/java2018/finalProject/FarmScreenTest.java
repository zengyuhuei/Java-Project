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

import java.util.Timer;
import java.util.TimerTask;

public class FarmScreenTest extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	ArrayList<Crop> crop = new ArrayList<Crop>(12);
	int[] storeCropArray = new int[12];
	int count = 0;
	JButton btn = new JButton();   //測試用button 不會出現

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
	
	public FarmScreenTest() {
		for(int i = 0; i < 12; i++)
			storeCropArray[i] = -1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton waterButton = new JButton("澆水");
		waterButton.setBounds(589, 69, 111, 31);
		waterButton.setVisible(false);
		contentPane.add(waterButton);
		
		JButton fertilizeButton = new JButton("施肥");
		fertilizeButton.setBounds(589, 120, 111, 31);
		fertilizeButton.setVisible(false);
		contentPane.add(fertilizeButton);
		
		JButton sowingButton = new JButton("播種");
		sowingButton.setBounds(589, 171, 111, 31);
		sowingButton.setVisible(false);
		contentPane.add(sowingButton);
		
		JButton harvestButton = new JButton("收割");
		harvestButton.setBounds(589, 18, 111, 31);
		harvestButton.setVisible(false);
		contentPane.add(harvestButton);
		
		JButton cornButton = new JButton("玉米");
		cornButton.setBounds(529, 171, 46, 31);
		cornButton.setVisible(false);
		contentPane.add(cornButton);
		
		JButton wheatButton = new JButton("小麥");
		wheatButton.setBounds(469, 171, 46, 31);
		wheatButton.setVisible(false);
		contentPane.add(wheatButton);
		
		JButton cabbageButton = new JButton("高麗菜");
		cabbageButton.setBounds(409, 171, 46, 36);
		cabbageButton.setVisible(false);
		contentPane.add(cabbageButton);
		
		
		JButton btnNewButton = new JButton("Land11");
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn = (JButton) e.getSource();
				
				//施肥button
				fertilizeButton.setVisible(true);
				if(storeCropArray[0] == -1)
					fertilizeButton.setEnabled(false);
				else
				{
					fertilizeButton.setEnabled(true);
					fertilizeButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(btn == btnNewButton)
							{
								crop.get(storeCropArray[0]).fertilize();
								System.out.println("GrowingRate1 = "+crop.get(storeCropArray[0]).getGrowingRate());
						
							}
						}
					});
				}
				
				//澆水button
				waterButton.setVisible(true);
				
				
				if(storeCropArray[0] == -1)
					waterButton.setEnabled(false);
				else
				{
					waterButton.setEnabled(true);
					waterButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(btn == btnNewButton)
							{
								crop.get(storeCropArray[0]).water();
								System.out.println("GrowingRate1 = "+crop.get(storeCropArray[0]).getGrowingRate());
							}
						}
					});
				}
				
				
				//播種button
				sowingButton.setVisible(true);
				if(storeCropArray[0] != -1)
					sowingButton.setEnabled(false);
				else 
				{
					sowingButton.setEnabled(true);
					sowingButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cornButton.setVisible(true);
						wheatButton.setVisible(true);
						cabbageButton.setVisible(true);
						cornButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	if(storeCropArray[0] == -1)
					        	{
						        	storeCropArray[0] = count;
					    			crop.add(count,new Corn());
					    			String cropName;
					    			cropName = crop.get(count).pickSeed();
					    			System.out.println(count+"你按了"+cropName+"ouo|");
					    			crop.get(count).setGrowingRate();
					    			count++;
					    			cornButton.setVisible(false);
									wheatButton.setVisible(false);
									cabbageButton.setVisible(false);
									sowingButton.setEnabled(false);
									fertilizeButton.setEnabled(true);
									waterButton.setEnabled(true);
									
					        	}
					        }
					    });
						
						
						wheatButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	if(storeCropArray[0] == -1)
					        	{
					        		storeCropArray[0] = count;
					    			crop.add(count,new Wheat());
					    			String cropName;
					    			cropName = crop.get(count).pickSeed();
					    			System.out.println(count+"你按了"+cropName+"ouo||");
					    			crop.get(count).setGrowingRate();
					    			count++;
					    			cornButton.setVisible(false);
									wheatButton.setVisible(false);
									cabbageButton.setVisible(false);
									sowingButton.setEnabled(false);
									fertilizeButton.setEnabled(true);
									waterButton.setEnabled(true);
					        	}
					        	
					        }
					    });
						
						
						cabbageButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	if(storeCropArray[0] == -1)
					        	{
						        	storeCropArray[0] = count;
					    			crop.add(count,new Cabbage());
					    			String cropName;
					    			cropName = crop.get(count).pickSeed();
					    			System.out.println(count+"你按了"+cropName+"ouo|||");
					    			crop.get(count).setGrowingRate();
					    			count++;
					    			cornButton.setVisible(false);
									wheatButton.setVisible(false);
									cabbageButton.setVisible(false);
									sowingButton.setEnabled(false);
									fertilizeButton.setEnabled(true);
									waterButton.setEnabled(true);
					        	}
					        	
					        }
					    });
						
					}
				});
				}
				
				
				//收割button
				harvestButton.setVisible(true);
				if(storeCropArray[0] == -1)
					harvestButton.setEnabled(false);
				else
				{
					harvestButton.setEnabled(true);
					harvestButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
						}
					});
				}
				
				
			}
		});
		btnNewButton.setBounds(15, 15, 111, 36);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Land21");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn = (JButton) e.getSource();
				
				//施肥button
				fertilizeButton.setVisible(true);
				if(storeCropArray[4] == -1)
					fertilizeButton.setEnabled(false);
				else
				{
					fertilizeButton.setEnabled(true);
					fertilizeButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(btn == button)
							{
								crop.get(storeCropArray[4]).fertilize();
								System.out.println("GrowingRate2 = "+crop.get(storeCropArray[4]).getGrowingRate());
							}
						}
					});
				}
				
				//澆水button
				waterButton.setVisible(true);
				if(storeCropArray[4] == -1)
					waterButton.setEnabled(false);
				else
				{
					waterButton.setEnabled(true);
					waterButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(btn == button)
							{
								crop.get(storeCropArray[4]).water();
								System.out.println("GrowingRate2 = "+crop.get(storeCropArray[4]).getGrowingRate());
							
							}
						}
					});
				}
				
				
				//播種button
				sowingButton.setVisible(true);
				if(storeCropArray[4] != -1)
					sowingButton.setEnabled(false);
				else 
				{
					sowingButton.setEnabled(true);
					sowingButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cornButton.setVisible(true);
						wheatButton.setVisible(true);
						cabbageButton.setVisible(true);
						cornButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	if(storeCropArray[4] == -1)
					        	{
						        	storeCropArray[4] = count;
					    			crop.add(count,new Corn());
					    			String cropName;
					    			cropName = crop.get(count).pickSeed();
					    			System.out.println(count+"你按了"+cropName+"ouq|");
					    			crop.get(count).setGrowingRate();
					    			count++;
					    			cornButton.setVisible(false);
									wheatButton.setVisible(false);
									cabbageButton.setVisible(false);
									sowingButton.setEnabled(false);
									fertilizeButton.setEnabled(true);
									waterButton.setEnabled(true);
					        	}
					        }
					    });
						
						
						wheatButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	if(storeCropArray[4] == -1)
					        	{
						        	storeCropArray[4] = count;
					    			crop.add(count,new Wheat());
					    			String cropName;
					    			cropName = crop.get(count).pickSeed();
					    			System.out.println(count+"你按了"+cropName+"ouq||");
					    			crop.get(count).setGrowingRate();
					    			count++;
					    			cornButton.setVisible(false);
									wheatButton.setVisible(false);
									cabbageButton.setVisible(false);
									sowingButton.setEnabled(false);
									fertilizeButton.setEnabled(true);
									waterButton.setEnabled(true);
					        	}
					        }
					    });
						
						
						cabbageButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	if(storeCropArray[4] == -1)
					        	{
						        	storeCropArray[4] = count;
					    			crop.add(count,new Cabbage());
					    			String cropName;
					    			cropName = crop.get(count).pickSeed();
					    			System.out.println(count+"你按了"+cropName+"ouq|||");
					    			crop.get(count).setGrowingRate();
					    			count++;
					    			cornButton.setVisible(false);
									wheatButton.setVisible(false);
									cabbageButton.setVisible(false);
									sowingButton.setEnabled(false);
									fertilizeButton.setEnabled(true);
									waterButton.setEnabled(true);
					        	}
					        }
					    });
						
					}
				});
				}
				
				
				//收割button
				harvestButton.setVisible(true);
				if(storeCropArray[4] == -1)
					harvestButton.setEnabled(false);
				else
				{
					harvestButton.setEnabled(true);
					harvestButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
						}
					});
				}
				
				
			}
		});
		button.setAction(action);
		button.setBounds(15, 66, 111, 36);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Land31");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn = (JButton) e.getSource();
				
				//施肥button
				fertilizeButton.setVisible(true);
				if(storeCropArray[8] == -1)
					fertilizeButton.setEnabled(false);
				else
				{
					fertilizeButton.setEnabled(true);
					fertilizeButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(btn == button_1)
							{
								crop.get(storeCropArray[8]).fertilize();
								System.out.println("GrowingRate3 = "+crop.get(storeCropArray[8]).getGrowingRate());
							}
							
						}
					});
				}
				
				//澆水button
				waterButton.setVisible(true);
				if(storeCropArray[8] == -1)
					waterButton.setEnabled(false);
				else
				{
					waterButton.setEnabled(true);
					waterButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(btn == button_1)
							{
								crop.get(storeCropArray[8]).water();
								System.out.println("GrowingRate3 = "+crop.get(storeCropArray[8]).getGrowingRate());
							}
						}
					});
				}
				
				
				//播種button
				sowingButton.setVisible(true);
				if(storeCropArray[8] != -1)
					sowingButton.setEnabled(false);
				else 
				{
					sowingButton.setEnabled(true);
					sowingButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cornButton.setVisible(true);
						wheatButton.setVisible(true);
						cabbageButton.setVisible(true);
						cornButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	if(storeCropArray[8] == -1)
					        	{
						        	storeCropArray[8] = count;
					    			crop.add(count,new Corn());
					    			String cropName;
					    			cropName = crop.get(count).pickSeed();
					    			System.out.println(count+"你按了"+cropName+"quq|");
					    			crop.get(count).setGrowingRate();
					    			count++;
					    			cornButton.setVisible(false);
									wheatButton.setVisible(false);
									cabbageButton.setVisible(false);
									sowingButton.setEnabled(false);
									fertilizeButton.setEnabled(true);
									waterButton.setEnabled(true);
					        	}
					        	
					        }
					    });
						
						
						wheatButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	if(storeCropArray[8] == -1)
					        	{
						        	storeCropArray[8] = count;
					    			crop.add(count,new Wheat());
					    			String cropName;
					    			cropName = crop.get(count).pickSeed();
					    			System.out.println(count+"你按了"+cropName+"quq||");
					    			crop.get(count).setGrowingRate();
					    			count++;
					    			cornButton.setVisible(false);
									wheatButton.setVisible(false);
									cabbageButton.setVisible(false);
									sowingButton.setEnabled(false);
									fertilizeButton.setEnabled(true);
									waterButton.setEnabled(true);
					        	}
					        }
					    });
						
						
						cabbageButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	if(storeCropArray[8] == -1)
					        	{
						        	storeCropArray[8] = count;
					    			crop.add(count,new Cabbage());
					    			String cropName;
					    			cropName = crop.get(count).pickSeed();
					    			System.out.println(count+"你按了"+cropName+"quq|||");
					    			crop.get(count).setGrowingRate();
					    			count++;
					    			cornButton.setVisible(false);
									wheatButton.setVisible(false);
									cabbageButton.setVisible(false);
									sowingButton.setEnabled(false);
									fertilizeButton.setEnabled(true);
									waterButton.setEnabled(true);
					        	}
					        }
					        
					    });
						
					}
				});
				}
				
				
				//收割button
				harvestButton.setVisible(true);
				if(storeCropArray[8] == -1)
					harvestButton.setEnabled(false);
				else
				{
					harvestButton.setEnabled(true);
					harvestButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
						}
					});
				}
				
				
			}
		});
		button_1.setAction(action);
		button_1.setBounds(15, 117, 111, 36);
		contentPane.add(button_1);
		
		/*JButton button_2 = new JButton("Land41");
		button_2.addActionListener(new Listener(1));
		button_2.setAction(action);
		button_2.setBounds(15, 168, 111, 36);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Land12");
		button_3.addActionListener(new Listener(5));
		button_3.setAction(action);
		button_3.setBounds(141, 18, 111, 36);
		contentPane.add(button_3);
		
		
		JButton button_4 = new JButton("Land22");
		button_4.addActionListener(new Listener(9));
		button_4.setAction(action);
		button_4.setBounds(141, 69, 111, 36);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Land32");
		button_5.addActionListener(new Listener(2));
		button_5.setAction(action);
		button_5.setBounds(141, 120, 111, 36);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("Land42");
		button_6.addActionListener(new Listener(6));
		button_6.setAction(action);
		button_6.setBounds(141, 171, 111, 36);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("Land13");
		button_7.addActionListener(new Listener(10));
		button_7.setAction(action);
		button_7.setBounds(267, 18, 111, 36);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("Land23");
		button_8.addActionListener(new Listener(3));
		button_8.setAction(action);
		button_8.setBounds(267, 69, 111, 36);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("Land33");
		button_9.addActionListener(new Listener(7));
		button_9.setAction(action);
		button_9.setBounds(267, 120, 111, 36);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("Land43");
		button_10.addActionListener(new Listener(11));
		button_10.setAction(action);
		button_10.setBounds(267, 171, 111, 36);
		contentPane.add(button_10);*/
		
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
