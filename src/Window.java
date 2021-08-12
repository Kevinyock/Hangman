import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Window extends JPanel{

	/**
	 * hangman game itself
	 */
	Hangman hangman = new Hangman();

	/**
	 * Difficulty Frame
	 */
	private JFrame Difficulty = new JFrame("Difficulty");
	private int DifficultyFrameWidth = 275;
	private int DifficultyFrameHeight = 320;
	
	/**
	 * The main frame of the game
	 */
	private JFrame Game = new JFrame("Hangman");
	private int GameFrameWidth = 500;
	private int GameFrameHeight = 500;
	
	
	public Window()
	{
		// Difficulty Window
		Difficulty.setTitle("Difficulty");
		Difficulty.setBounds(0,0,DifficultyFrameWidth,DifficultyFrameHeight);
		Difficulty.setResizable(false);
		Difficulty.setLocationRelativeTo(this);
		Difficulty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Difficulty.setContentPane(new DifficultyPanel());
		Difficulty.setVisible(true);
		
		//
		
		//Game Window
		Game.setTitle("Hangman");
		Game.setBounds(0,0,GameFrameWidth,GameFrameHeight);
		Game.setResizable(false);
		Game.setLocationRelativeTo(this);
		Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game.setVisible(false);
		//
		
	}
	
	public void startGameWindow()
	{
		Game.setVisible(true);
		Difficulty.setVisible(false);
	}
	
	public class DifficultyPanel extends JPanel implements ActionListener
	{

		int buttonWidth = 250;
		int buttonHeight = 50;
		//Difficulty buttons
		private JButton VeryEasy = new JButton("Very Easy");
		private JButton Easy = new JButton("Easy");
		private JButton Normal = new JButton ("Normal");
		private JButton Hard = new JButton("Hard");
		private JButton VeryHard = new JButton("Very Hard");
		
		public DifficultyPanel()
		{	
			setLayout(null);
			
			this.add(VeryEasy);
			this.add(Easy);
			this.add(Normal);
			this.add(Hard);
			this.add(VeryHard);
			
			VeryEasy.setBounds(5, 5, buttonWidth, buttonHeight);
			Easy.setBounds(5,60, buttonWidth, buttonHeight);
			Normal.setBounds(5, 115, buttonWidth, buttonHeight);
			Hard.setBounds(5, 170, buttonWidth, buttonHeight);
			VeryHard.setBounds(5, 225, buttonWidth, buttonHeight);
			
			VeryEasy.addActionListener(this);
			Easy.addActionListener(this);
			Normal.addActionListener(this);
			Hard.addActionListener(this);
			VeryHard.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//Hold off until the game window is ready
			if(e.getSource() == VeryEasy )
			{
				//hangman.setDifficulty(1);
				startGameWindow();
			}
			else if(e.getSource() == Easy)
			{
				//hangman.setDifficulty(2);
				startGameWindow();
			}
			else if(e.getSource() == Normal)
			{
				//hangman.setDifficulty(3);
				startGameWindow();
			}
			else if(e.getSource() == Hard)
			{
				//hangman.setDifficulty(4);
				startGameWindow();
			}
			else
			{
				//hangman.setDifficulty(5);
				startGameWindow();
			}
		}
		
	}
	
	public class GamePanel extends JPanel implements ActionListener
	{
		
		private JPanel HangmanImage = new JPanel();
		private JPanel Statistics = new JPanel();
		
		public GamePanel()
		{
			setLayout(null);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
