import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Difficulty extends Window implements ActionListener{

	public static Difficulty instance = null;
	
	private int DifficultyFrameWidth = 275;
	private int DifficultyFrameHeight = 320;
	
	private int buttonWidth = 250;
	private int buttonHeight = 50;
	
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
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(null);
		
		add(VeryEasy);
		add(Easy);
		add(Normal);
		add(Hard);
		add(VeryHard);
		
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
			setWindowVisible(false);
		}
		else if(e.getSource() == Easy)
		{
			//hangman.setDifficulty(2);
			setWindowVisible(false);
		}
		else if(e.getSource() == Normal)
		{
			//hangman.setDifficulty(3);
			setWindowVisible(false);
		}
		else if(e.getSource() == Hard)
		{
			//hangman.setDifficulty(4);
			setWindowVisible(false);
		}
		else
		{
			//hangman.setDifficulty(5);
			setWindowVisible(false);
		}
	}
	
}
