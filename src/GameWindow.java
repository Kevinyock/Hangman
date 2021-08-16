import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends Window
{
	private static GameWindow instance = null;

	private KeyStroke keyStroke;
	
	private int GameFrameWidth = 500;
	private int GameFrameHeight = 500;

	private JPanel HangmanImage = new JPanel();
	private JPanel Statistics = new JPanel();
	private JPanel options = new JPanel();
	
	private JButton GiveUp = new JButton("Give Up");
	private JButton Restart = new JButton("Restart");
	

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
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(options);
		optionSetUp();
		

		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	/**
	 * setting up option
	 */
	public void optionSetUp()
	{

		options.setBounds(100,100, 100, 100);
		options.setLayout(null);
		options.add(Restart);
		options.add(GiveUp);

		options.setVisible(true);
		
		Restart.addActionListener(this);
		GiveUp.addActionListener(this);
	}

	@Override
	public void paint(Graphics g)
	{
		head = (Graphics2D) g;
	}

	/**
	 * Draw the Head
	 */
	public void drawHead()
	{
		head.drawOval(0, 0, 100, 100);
	}
}
