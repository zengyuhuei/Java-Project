package java2018.finalProject;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


class Fish extends JPanel {
	  int x = 0, y = 100, radius = 20, xDelta = 2;

	  public Fish() {
		JLabel myText = new JLabel("position: " + x, SwingConstants.CENTER);
		this.add(myText);
	    Timer timer = new Timer(40, new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        x += xDelta;
	        if (x + (radius * 2) > getWidth()) {
	          x = getWidth() - (radius * 2);
	          xDelta *= -1;
	        } else if (x < 0) {
	          x = 0;
	          xDelta *= -1;
	        }
	        System.out.println(x);
	        myText.setText(String.valueOf(x));
	        repaint();
	      }
	    });
	    timer.start();
	  }

	  @Override
	  public Dimension getPreferredSize() {
	    return new Dimension(200, 200);
	  }

	  @Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.RED);
	    g.fillOval(x, y - radius, radius * 2, radius * 2);
	  }
	}