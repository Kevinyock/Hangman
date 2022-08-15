import java.awt.Graphics;

import javax.swing.JPanel;

public class HangmanDisplay extends JPanel{
	
	private Hangman hangman = Hangman.getInstance();
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawHangmanStand(g);
		//drawHead(g);
	}

	private void drawHead(Graphics g) {
		g.drawOval(getWidth(), 40, 100, 100);
	}
	
	private void drawTorso(Graphics g, int x, int y,int width,int height) {
		
	}
	
	private void drawHangmanStand(Graphics g) {
		g.drawLine(getWidth()/2, 10, (int) (getWidth() * 0.7), 10);
		g.drawLine(getWidth()/2, 10, getWidth()/2, 40);
		g.drawLine( (int) (getWidth() * 0.7), 10, (int) (getWidth() * 0.7), (int) (getHeight() * 0.9));
		g.drawLine( (int) (getWidth() * 0.5), (int) (getHeight() * 0.9), (int) (getWidth() * 0.9), (int) (getHeight() * 0.9));
	}
}
