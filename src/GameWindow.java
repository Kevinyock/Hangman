import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class GameWindow extends Window
{
	private static GameWindow instance = null;

	private KeyStroke keyStroke;
	
	private int GameFrameWidth = 512;
	private int GameFrameHeight = 512;

	private JPanel mainPanel = new JPanel();
	private JPanel HangmanImage = new JPanel();
	private JPanel GuessedWord = new JPanel();
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
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainPanelSetUp();
		OptionPanelSetUp();
		HangmanImageSetUp();
		
	}

	public void MainPanelSetUp()
	{
		add(mainPanel);
		mainPanel.setOpaque(true);
		mainPanel.setBounds(0, 0, GameFrameWidth, GameFrameHeight);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.RED);
		mainPanel.setVisible(true);

		mainPanel.add(options);
		mainPanel.add(HangmanImage);
		mainPanel.add(GuessedWord);
		//mainPanel.add(Statistics);
	}
	
	/**
	 * Set Up Option Panel
	 */
	public void OptionPanelSetUp()
	{
		options.add(Restart);
		options.add(GiveUp);
		
		options.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		options.setBackground(Color.WHITE);
		options.setLayout(new GridLayout(2,1,5,5));
		options.setSize(100,100);
		options.setBounds(385, 385, 100, 100);
		
		Restart.setBounds(0, 0, 100, 80);
		GiveUp.setBounds(0,0,100,80);
		
		Restart.addActionListener(this);
		GiveUp.addActionListener(this);

		options.setVisible(true);
	}
	
	public void HangmanImageSetUp()
	{
		HangmanImage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		HangmanImage.setBounds(10,10,360,360);
		HangmanImage.setBackground(Color.WHITE);
		HangmanImage.setLayout(null);

		HangmanImage.setVisible(true);
		
	}
	/**
	 * 
	 */
	public void GussedWordPanelSetUp()
	{
		
	}
	
	private void StatisticsPanelSetuP()
	{
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Restart)
		{
			System.out.println("Restart");
		}
		else if(e.getSource() == GiveUp)
		{
			System.out.println("I Give up");
		}
	}
	
	
}
