import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class GameWindow extends Window {
	private static GameWindow instance = null;
	private static Hangman hangman = Hangman.getInstance();

	private KeyStroke keyStroke;

	private int FrameBorderSize = 30;
	
	private int GameFrameWidth = 650;
	private int GameFrameHeight = 612 + FrameBorderSize;
	
	private int FramePadding = 10;
	
	private char[] alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();

	private JPanel mainPanel = new JPanel();
	private JPanel HangmanDisplay = new JPanel();
	private JPanel Keyboard = new JPanel();
	private JPanel Statistics = new JPanel();
	private JPanel options = new JPanel();

	private JButton GiveUp = new JButton("Give Up");
	private JButton Restart = new JButton("Restart");

	private JLabel DifficultyChosen = new JLabel();
	private JLabel GuessFieldCounter = new JLabel();
	private JLabel RemainingBlankLetters = new JLabel();
	
	private JButton[] letterButtons = new JButton[26];

	Graphics2D head;
	/**
	 * 0 - Head 1 - Torso 2 - Left Arm 3 - Right Arm 4 - Left Leg 5 - Right Leg
	 */
	Graphics2D[] bodyparts;

	public static GameWindow getInstance() {
		if (instance == null) {
			instance = new GameWindow();
		}
		return instance;
	}

	private GameWindow() {
		setTitle("Hangman");
		setBounds(0, 0, GameFrameWidth, GameFrameHeight);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void StartGame() {
		MainPanelSetUp();
		OptionPanelSetUp();
		HangmanDisplaySetUp();
		KeyboardSetUp();
		StatisticsPanelSetuP();
		setWindowVisible(true);
	}
	

	private void MainPanelSetUp() {
		add(mainPanel);
		mainPanel.setOpaque(true);
		mainPanel.setBounds(0, 0, GameFrameWidth, GameFrameHeight);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.RED);
		mainPanel.setVisible(true);

		mainPanel.add(options);
		mainPanel.add(HangmanDisplay);
		mainPanel.add(Keyboard);
		mainPanel.add(Statistics);
	}

	/**
	 * Set Up Option Panel
	 */
	private void OptionPanelSetUp() {
		options.add(Restart);
		options.add(GiveUp);

		int PanelWidth = 100;
		int PanelHeight = 155;
		options.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		options.setBackground(Color.WHITE);
		options.setLayout(new GridLayout(2, 1, 5, 5));
		options.setLocation(this.getWidth() - (PanelWidth + 25), this.getHeight() - (PanelHeight + 50));
		options.setSize(PanelWidth, PanelHeight);

		Restart.setBounds(0, 0, 100, 80);
		GiveUp.setBounds(0, 0, 100, 80);

		Restart.addActionListener(this);
		GiveUp.addActionListener(this);

		options.setVisible(true);
	}

	private void HangmanDisplaySetUp() {

		int PanelWidth = 505;
		int PanelHeight = 420;
		
		HangmanDisplay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		HangmanDisplay.setBounds(FramePadding, FramePadding, PanelWidth, PanelHeight);
		HangmanDisplay.setBackground(Color.WHITE);
		HangmanDisplay.setLayout(null);
		HangmanDisplay.setVisible(true);
	}

	/**
	 * 
	 */
	private void KeyboardSetUp() {

		int PanelWidth = 505;
		int PanelHeight = 155;
		
		createKeyboard();
		Keyboard.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		Keyboard.setBounds(FramePadding, this.getHeight() - (PanelHeight + 50), PanelWidth, PanelHeight);
		Keyboard.setBackground((Color.WHITE));
		Keyboard.setLayout(null);
		Keyboard.setVisible(true);

	}

	/**
	 * 
	 */
	private void StatisticsPanelSetuP() {

		int PanelWidth = 100;
		int PanelHeight = 420;
		
		Statistics.add(DifficultyChosen);
		Statistics.add(GuessFieldCounter);
		Statistics.add(RemainingBlankLetters);

		DifficultyChosen.setText(String.format("<html>Difficulty:<br> %s</html>", hangman.getDifficulty()));
		GuessFieldCounter.setText(String.format("<html>guesses:<br>%s</html>", hangman.getCurrentFailGuess()));
		RemainingBlankLetters.setText(String.format("<html>remaining blanks:<br>%s</html>", hangman.getRemainingblanks()));
		
		DifficultyChosen.setBounds(10, 10, 100, 30);
		GuessFieldCounter.setBounds(10, 50, 100, 30);
		RemainingBlankLetters.setBounds(10, 90, 100, 50);
		
		Statistics.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		Statistics.setBounds(this.getHeight() - (PanelWidth + FramePadding + 7) , FramePadding, PanelWidth, PanelHeight);
		Statistics.setBackground((Color.WHITE));
		Statistics.setLayout(null);
		Statistics.setVisible(true);
	}


	/**
	 * Create the keyboard buttons
	 */
	public void createKeyboard(){
		for(int i = 0; i <alphabet.length; i++) {
			
			JButton button = new JButton(Character.toString(alphabet[i]));
			button.addActionListener(this);
			button.setFont(new Font("Ariel",Font.PLAIN,12));
			Keyboard.add(button);
			letterButtons[i] = button;
		}
		setKeyboardLayout();
	}
	
	private void setKeyboardLayout(){
		for(int i = 0; i < 26; i++){
			if(i < 10) {
				letterButtons[i].setBounds(5 + (50 * i) , 5, 45, 45);
			}
			else if (i < 19){
				letterButtons[i].setBounds(30 + (50 * (i- 10)) , 55, 45, 45);
			}
			else {
				letterButtons[i].setBounds(80 + (50 * (i - 19)) , 105, 45, 45);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Restart":
				System.out.println("Restart");
				break;
			case "Give Up":
				System.out.println("I Give up");
				break;
			default:
				System.out.println();
				break;
		}
	}

}
