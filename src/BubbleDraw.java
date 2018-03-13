import javax.swing.JFrame;

public class BubbleDraw extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Atul's Bubble Draw App");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().add(new BubblePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
