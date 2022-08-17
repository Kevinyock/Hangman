import java.awt.Graphics;

import javax.swing.JPanel;

public class HangmanDisplay extends JPanel {

	private Hangman hangman = Hangman.getInstance();

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawHangmanStand(g);

		if (hangman.getCurrentFailGuess() > 0) {
			switch (hangman.getDifficultyInput()) {
			case 1:
				drawFigure(3,g);
				break;
			case 2:
				drawFigure(2,g);
				break;
			default:
				drawFigure(1,g);
				break;
			}
		}

	}
	
	private void drawFigure(int permittedTries, Graphics g) {
		switch (hangman.getCurrentFailGuess() / permittedTries) {
		case 1:
			drawHead(g);
			break;
		case 2:
			drawHead(g);
			drawTorso(g);
			break;
		case 3:
			drawHead(g);
			drawTorso(g);
			drawLeftArm(g);
			break;
		case 4:
			drawHead(g);
			drawTorso(g);
			drawLeftArm(g);
			drawRightArm(g);
			break;
		case 5:
			drawHead(g);
			drawTorso(g);
			drawLeftArm(g);
			drawRightArm(g);
			drawLeftLeg(g);
			break;
		case 6:
			drawHead(g);
			drawTorso(g);
			drawLeftArm(g);
			drawRightArm(g);
			drawLeftLeg(g);
			drawRightLeg(g);
			break;
		default:
			break;
		}
	}

	private void drawHead(Graphics g) {
		g.drawOval((int) (getWidth() / 2.27), 40, 60, 60);
	}

	private void drawTorso(Graphics g) {
		g.drawLine(getWidth() / 2, 100, getWidth() / 2, 180);
	}

	private void drawLeftArm(Graphics g) {
		g.drawLine(getWidth() / 2, 100, (getWidth() / 2) + 50, 180);
	}

	private void drawRightArm(Graphics g) {
		g.drawLine(getWidth() / 2, 100, (getWidth() / 2) - 50, 180);
	}

	private void drawLeftLeg(Graphics g) {
		g.drawLine(getWidth() / 2, 180, (getWidth() / 2) + 50, 260);
	}

	private void drawRightLeg(Graphics g) {
		g.drawLine(getWidth() / 2, 180, (getWidth() / 2) - 50, 260);
	}

	private void drawHangmanStand(Graphics g) {
		g.drawLine(getWidth() / 2, 10, (int) (getWidth() * 0.7), 10);
		g.drawLine(getWidth() / 2, 10, getWidth() / 2, 40);
		g.drawLine((int) (getWidth() * 0.7), 10, (int) (getWidth() * 0.7), (int) (getHeight() * 0.9));
		g.drawLine((int) (getWidth() * 0.5), (int) (getHeight() * 0.9), (int) (getWidth() * 0.9),
				(int) (getHeight() * 0.9));
	}
}
