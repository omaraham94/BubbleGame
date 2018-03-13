import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BubblePanel extends JPanel {
	
	private ArrayList<Bubble> bubbleList;
	
	public BubblePanel() {
		bubbleList = new ArrayList<Bubble>();
		
		addMouseListener(new BubbleListner());
		addMouseMotionListener(new BubbleListner());
		
		setBackground(Color.BLACK);
		
		setPreferredSize(new Dimension(600,400));
		
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
										   MouseMotionListener{

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
			// TODO Auto-generated method stub
			bubbleList.add(new Bubble(e.getX(),e.getY(), 30));
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
		
	}
	
	private class Bubble {
		public int x;
		public int y;
		public int size;
		public Color color;
		public Bubble(int newx, int newy, int newsize) {
			this.x = newx;
			this.y = newy;
			this.size = newsize;
			this.color = new Color((float)Math.random(),
									(float)Math.random(),
									(float)Math.random());
		}
	}
}
