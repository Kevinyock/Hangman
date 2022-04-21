import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	private static Hangman instance = null;

	int randNum;
	int maxFailGuess;
	int currentFailGuess = 0;
	int numberOfRestarts = 0;
	int numberofGiveUp = 0;

	File VeryEZFile = new File("VeryEZWord.txt");
	File EZFile = new File("EZWord.txt");
	File NormalFile = new File("NormWord.txt");
	File HardFile = new File("HardWord.txt");
	File VeryHardFile = new File("VeryHard.txt");

	boolean wordGuessed = false;

	private String difficulty;

	private ArrayList<String> listofwords = new ArrayList<String>();
	String Chosenword = "Tesla";
	char[] Userguessword;
	char guessletter;
	int filledLetters = 0;

	int difficultyInput = 0;

	Scanner WordScanner;
	Scanner scanner = new Scanner(System.in);

	public static Hangman getInstance() {
		if (instance == null) {
			instance = new Hangman();
		}

		return instance;
	}

	public void setDifficulty(int difficulty) {
		switch (difficulty) {
		case 1:
			AssignDifficulty(VeryEZFile, "Very Easy", 10);
			break;
		case 2:
			AssignDifficulty(EZFile, "Easy", 8);
			break;
		case 3:
			AssignDifficulty(NormalFile, "Normal", 5);
			break;
		case 4:
			AssignDifficulty(HardFile, "Hard", 5);
			break;
		case 5:
			AssignDifficulty(VeryHardFile, "Very Hard", 5);
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
		while (WordScanner.hasNext())
			;
		WordScanner.close();
	}

	/**
	 * Pick a random word from the list
	 */
	private void chosingword() {
		Random rand = new Random();
		randNum = rand.nextInt(listofwords.size());
		Chosenword = listofwords.get(randNum);

		Userguessword = new char[Chosenword.length()];

		for (int i = 0; i < Chosenword.length(); i++) {
			Userguessword[i] = '_';
		}
	}

	/**
	 * Player has to guess
	 */
	public void Guess() {
		for (int i = 0; i < Chosenword.length(); i++) {
			System.out.print(Userguessword[i] + " ");
		}
		System.out.println();

		guessletter = scanner.next().charAt(0);
		if (Character.isLetter(guessletter)) {
			guessletter = Character.toLowerCase(guessletter);
			for (int i = 0; i < Chosenword.length(); i++) {
				if (Chosenword.charAt(i) == guessletter) {
					filledLetters++;
					Userguessword[i] = Chosenword.charAt(i);
				}
			}
		} else {
			System.out.println("User guess is not a letter");
		}
	}

	public void Guessing() {
		while (!wordGuessed && currentFailGuess < maxFailGuess) {

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
	
	public int getCurrentFailGuess() {
		return currentFailGuess;
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
	
	
}
