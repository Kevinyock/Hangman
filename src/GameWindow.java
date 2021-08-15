import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameWindow extends Window implements ActionListener{

	private static GameWindow instance = null;

	private int GameFrameWidth = 500;
	private int GameFrameHeight = 500;

	private JPanel HangmanImage = new JPanel();
	private JPanel Statistics = new JPanel();
	

	Graphics2D head;
	/**
	 * 0 - Head
	 * 1 - Torso
	 * 2 - Left Arm
	 * 3 - Right Arm
	 * 4 - Left Leg
	 * 5 - Right Leg
	 */
	Graphics2D[] bodyparts;
	
	public static GameWindow getInstance()
	{
		if(instance == null)
		{
			instance = new GameWindow();
		}
		return instance;
	}
	
	public GameWindow()
	{
		setTitle("Hangman");
		setBounds(0,0,GameFrameWidth,GameFrameHeight);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		
		setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	

	@Override
	public void paint(Graphics g)
	{
		head = (Graphics2D) g;
		drawHead();
	}

	/**
	 * Draw the Head
	 */
	public void drawHead()
	{
		head.drawOval(0, 0, 100, 100);
	}
}
