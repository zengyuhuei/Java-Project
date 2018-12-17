package java2018.finalProject;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class PondScreen extends JPanel implements KeyListener {
	private JSlider slider;
	private int sliderValue = 0;
	private int sliderAdd = 1;
	private Timer t;
	private TimerTask tk;
	private boolean stop = false;
	private Main mainFrame;
	public PondScreen(Main mainFrame) {
		this.mainFrame = mainFrame;
		this.setSize(1200, 675);
		this.setVisible(true);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
		this.addKeyListener(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0};
		this.setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		this.add(panel_1, gbc_panel_1);
		
		slider = new JSlider();
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.gridwidth = 3;
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 0;
		this.add(slider, gbc_slider);
		slider.setMaximum(100);
		slider.setMinimum(0);
		slider.setValue(sliderValue);
		slider.setMinorTickSpacing(1);
		slider.setUI(new GameSlider(slider));
		MouseListener[] mls = slider.getMouseListeners();
		for (int i = 0; i < mls.length; ++i) {
			slider.removeMouseListener(mls[i]);;
		}
		slider.setVisible(false);
		slider.setVisible(true);
		
		
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 5;
		gbc_panel.gridheight = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.add(panel, gbc_panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.BLACK);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		t = new Timer();
		tk = new TimerTask() {
			public void run() {
				if(sliderValue + sliderAdd < 100 && sliderValue + sliderAdd >= 0) {
					sliderValue += sliderAdd;
					slider.setValue(sliderValue);
				}
				else {
					System.out.println(121321);
					sliderAdd *= -1;
					sliderValue += sliderAdd;
					slider.setValue(sliderValue);
				}
			}
		};
		t.schedule(tk , 10, 10);
	}
	
	public void stop() {
		t.cancel();
	}
	
	public static void main(String[] args) {
		new PondScreen();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(123112);
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			t.cancel();
			System.out.println(123112);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class GameSlider extends BasicSliderUI {    
	private static float[] fracs = {0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f};
	private LinearGradientPaint p;
	public GameSlider(JSlider slider) {
		super(slider);
	}
	@Override
	public void paintTrack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;    
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.setColor(Color.BLACK);
        g2d.fillRoundRect(0, 6, 200, 8, 10, 10);
        
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(30, 6, 20, 8);
        
        g2d.setColor(Color.WHITE);
        g2d.drawRoundRect(0, 6, 200, 8, 10, 10);
        //System.out.println(trackRect.width);
        /*Rectangle t = trackRect;
        Point2D start = new Point2D.Float(t.x + 10, t.y - 10);
        Point2D end = new Point2D.Float(t.width, t.height);
        Color[] colors = {Color.magenta, Color.blue, Color.cyan,
            Color.green, Color.yellow, Color.red};
        p = new LinearGradientPaint(start, end, fracs, colors);
        g2d.setPaint(p);
        g2d.fillRect(t.x, t.y, t.width, t.height);*/
	}
}