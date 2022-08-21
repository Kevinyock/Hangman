import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	private static Hangman instance = null;

	private int randNum;
	private int maxFailGuess;
	private int currentFailGuess = 0;
	private int currentGuess = 0;
	private int numberOfRestarts = 0;
	private int numberofGiveUp = 0;

	private File VeryEZFile = new File("VeryEZWord.txt");
	private File EZFile = new File("EZWord.txt");
	private File NormalFile = new File("NormWord.txt");
	private File HardFile = new File("HardWord.txt");
	private File VeryHardFile = new File("VeryHard.txt");

	boolean wordGuessed = false;

	private String difficulty;

	private ArrayList<String> listofwords = new ArrayList<>();
	private String Chosenword = "Tesla";
	private String userWord = "";

	private char guessletter;
	private int filledLetters = 0;

	private int difficultyInput = 0;

	private Scanner WordScanner;
	private Scanner scanner = new Scanner(System.in);

	public static Hangman getInstance() {
		if (instance == null) {
			instance = new Hangman();
		}

		return instance;
	}

	public void setDifficulty(int difficulty) {
		difficultyInput = difficulty;
		switch (getDifficultyInput()) {
		case 1:
			AssignDifficulty(VeryEZFile, "Very Easy", 18);
			break;
		case 2:
			AssignDifficulty(EZFile, "Easy", 12);
			break;
		case 3:
			AssignDifficulty(NormalFile, "Normal", 6);
			break;
		case 4:
			AssignDifficulty(HardFile, "Hard", 6);
			break;
		case 5:
			AssignDifficulty(VeryHardFile, "Very Hard", 6);
			break;
		default:
			System.out.println("Please input one of the proper difficulty");
			break;
		}
	}

	/**
	 * Scan the file and add all of the words from the text file into the Arraylist
	 * 
	 * @param file
	 */
	private void ListScanner(File file) {
		try {
			WordScanner = new Scanner(file);
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		}

		while (WordScanner.hasNext()) {

			String Word = WordScanner.nextLine();
			listofwords.add(Word);
		}
		while (WordScanner.hasNext());

		WordScanner.close();
	}

	/**
	 * Pick a random word from the list
	 */
	private void chosingword() {
		Random rand = new Random();
		randNum = rand.nextInt(listofwords.size());
		Chosenword = listofwords.get(randNum).toLowerCase();
		
		for (int i = 0; i < Chosenword.length(); i++) {
			userWord = userWord.concat("_");
		}

	}

	/**
	 * Player has to guess
	 */
	public void Guess() {

		guessletter = scanner.next().charAt(0);
		if (Character.isLetter(guessletter)) {
			guessletter = Character.toLowerCase(guessletter);
			for (int i = 0; i < Chosenword.length(); i++) {
				if (Chosenword.charAt(i) == guessletter) {
					filledLetters++;
				}
			}
		} else {
			System.out.println("User guess is not a letter");
		}
	}

	public void Guessing() {
		while (!wordGuessed && currentGuess < maxFailGuess) {

			if (filledLetters == Chosenword.length()) {
				wordGuessed = true;
				System.out.println("You got the word guess right");
				System.out.println("You correctly guess the following word");
				System.out.println(Chosenword);
			} else {
				System.out.println();
				System.out.println("What is the next letter you chose");
				Guess();
			}
		}
	}

	public void AssignDifficulty(File fileName, String Difficulty, int MaxFailGuess) {
		ListScanner(fileName);
		difficulty = Difficulty;
		this.maxFailGuess = MaxFailGuess;
		chosingword();
	}

	public String getDifficulty() {
		return difficulty;
	}

	public int getMaxFailGuess() {
		return maxFailGuess;
	}
	
	public int getCurrentFailGuess() {
		return currentFailGuess;
	}
	
	public int getCurrentGuess() {
		return currentGuess;
	}

	public int getRemainingblanks() {
		return Chosenword.length() - filledLetters;
	}

	public int getNumberOfRestarts() {
		return numberOfRestarts;
	}

	public int getNumberofGiveUp() {
		return numberofGiveUp;
	}

	
	public int getChosenWordLength() {
		return Chosenword.length();
	}

	public int getDifficultyInput() {
		return difficultyInput;
	}
	
	public void guessLetter(String letter) {
		StringBuilder updatedWord = new StringBuilder(userWord);
		if (letter.length() == 1) {

			currentGuess++;
			// User got the letter correct
			if (Chosenword.contains(letter)) {
				System.out.println(userWord);
				for (int i = 0; i < Chosenword.length(); i++) {
					if (Chosenword.charAt(i) == letter.charAt(0)) {
						updatedWord.setCharAt(i, letter.charAt(0));
						userWord = updatedWord.toString();
						filledLetters++;
					} else {
						
					}
				}
				userWord = userWord.trim();
				System.out.println(updatedWord);
			} else { // WRONG!
				currentFailGuess++;
			}
		} else {
			System.out.println("Error");
		}
	}

	public String getuserWord() {
		return userWord;
	}
	
	public String revealAnswer() {
		return Chosenword;
	}
	
	public void resetGame() {
		userWord = "";
		for (int i = 0; i < Chosenword.length(); i++) {
			userWord = userWord.concat("_");
		}
		filledLetters = 0;
		currentGuess = 0;
		currentFailGuess = 0;
	}
	
	public boolean gotCorrectWord() {
		return filledLetters == Chosenword.length();
	}
	
	public boolean containLetter(String letter) {
		return Chosenword.contains(letter);
	}
	
	/**
	 * Let pick a new word at the same difficulty
	 */
	public void newWord()
	{
		userWord = "";
		Random rand = new Random();
		randNum = rand.nextInt(listofwords.size());
		Chosenword = listofwords.get(randNum).toLowerCase();
		for (int i = 0; i < Chosenword.length(); i++) {
			userWord = userWord.concat("_");
		}
		filledLetters = 0;
		currentGuess = 0;
		currentFailGuess = 0;
		System.out.println(Chosenword);
	}
}
