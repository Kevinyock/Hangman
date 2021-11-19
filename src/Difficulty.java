import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Difficulty extends Window
{

	private GameWindow gameWindow = GameWindow.getInstance();
	
	private static Difficulty instance = null;
	
	private static Hangman hangman = Hangman.getInstance();
	
	private int DifficultyFrameWidth = 275;
	private int DifficultyFrameHeight = 320;
	
	private JPanel DifficultyPanel = new JPanel();
	
	//Difficulty buttons
	private JButton VeryEasy = new JButton("Very Easy");
	private JButton Easy = new JButton("Easy");
	private JButton Normal = new JButton ("Normal");
	private JButton Hard = new JButton("Hard");
	private JButton VeryHard = new JButton("Very Hard");
	
	public static Difficulty getInstance()
	{
		if(instance == null)
		{
			instance = new Difficulty();
		}
		return instance;
	}
	
	public Difficulty()
	{
		setTitle("Difficulty");
		setBounds(0,0,DifficultyFrameWidth,DifficultyFrameHeight);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(DifficultyPanel);
		
		DifficultyPanel.setBackground(Color.RED);
		DifficultyPanel.add(VeryEasy);
		DifficultyPanel.add(Easy);
		DifficultyPanel.add(Normal);
		DifficultyPanel.add(Hard);
		DifficultyPanel.add(VeryHard);
		
		DifficultyPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		DifficultyPanel.setLayout(new GridLayout(5,1,0,5));
		
		VeryEasy.addActionListener(this);
		Easy.addActionListener(this);
		Normal.addActionListener(this);
		Hard.addActionListener(this);
		VeryHard.addActionListener(this);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Hold off until the game window is ready
		if(e.getSource() == VeryEasy )
		{
			hangman.setDifficulty(1);
			setWindowVisible(false);
			gameWindow.setWindowVisible(true);
		}
		else if(e.getSource() == Easy)
		{
			hangman.setDifficulty(2);
			setWindowVisible(false);
			gameWindow.setWindowVisible(true);
		}
		else if(e.getSource() == Normal)
		{
			hangman.setDifficulty(3);
			setWindowVisible(false);
			gameWindow.setWindowVisible(true);
		}
		else if(e.getSource() == Hard)
		{
			hangman.setDifficulty(4);
			setWindowVisible(false);
			gameWindow.setWindowVisible(true);
		}
		else
		{
			hangman.setDifficulty(5);
			setWindowVisible(false);
			gameWindow.setWindowVisible(true);
		}
	}
	
}
