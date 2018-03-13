import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BubblePanel extends JPanel {
	
	private ArrayList<Bubble> bubbleList;
	private Timer timer;
	private final int DELAY = 33; // ms of delay for 30 fps
	
	public BubblePanel() {
		bubbleList = new ArrayList<Bubble>();
		
		addMouseListener(new BubbleListner());
		addMouseMotionListener(new BubbleListner());
		
		timer = new Timer(DELAY, new BubbleListner());
		
		setBackground(Color.BLACK);
		
		setPreferredSize(new Dimension(600,400));
		timer.start();
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		//draw bubbles
		for (Bubble bubble:bubbleList) {
			page.setColor(bubble.color);
			page.fillOval(bubble.x - bubble.size/2,bubble.y - bubble.size/2, bubble.size, bubble.size);
		}
		page.setColor(Color.GREEN);
		page.drawString("Count: " + bubbleList.size(),5,15);
	}
	
	private class BubbleListner implements MouseListener,
										   MouseMotionListener,
										   MouseWheelListener,
										   ActionListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			timer.stop();
			// TODO Auto-generated method stub
			bubbleList.add(new Bubble(e.getX(),e.getY(), 30));
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			timer.start();
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			bubbleList.add(new Bubble(e.getX(),e.getY(), 30));
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// update location of each bubble for animation
			for (Bubble bubble:bubbleList) {
				bubble.update();
			}
			// repaint the screen
			repaint();
			
		}
		
		
	}
	
	private class Bubble {
		public int x;
		public int y;
		public int size;
		public Color color;
		public int xspeed;
		public int yspeed;
		private final int MAX_SPEED=5;
		private final int MIN_SPEED = 1;
		public Bubble(int newx, int newy, int newsize) {
			this.x = newx;
			this.y = newy;
			this.size = newsize;
			this.color = new Color((float)Math.random(),
									(float)Math.random(),
									(float)Math.random());
			xspeed  = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
			yspeed  = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
			if (Math.abs(xspeed) < MIN_SPEED) {
				xspeed = MIN_SPEED;
			}
			if (Math.abs(yspeed) < MIN_SPEED) { 
				yspeed = MIN_SPEED;
			}
		}
		
		public void update() {
			x += xspeed;
			y+= yspeed;
			
			if (x < 0 || x > getWidth()) {
				xspeed  =  -1 * xspeed;
			}
			if (y < 0 || y > getHeight()) {
				yspeed = -yspeed;
			}
			 
		}
	}
}
