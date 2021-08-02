import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hangman {

	int randNum;
	int MaxFailGuess;
	int currentFailGuess = 0;
	
	File VeryEZFile = new File("VeryEZWord.txt");
	File EZFile = new File("EZWord.txt");
	File NormalFile = new File("NormWord.txt");
	File HardFile = new File("HardWord.txt");
	File VeryHardFile = new File("VeryHard.txt");

	boolean wordGuessed = false;

	private ArrayList<String> listofwords = new ArrayList<String>();
	String Chosenword = "Tesla";
	char[] Userguessword;
	char guessletter;
	int filledLetters = 0;
	
	int difficultyInput = 0;

	Scanner WordScanner;
	Scanner scanner = new Scanner(System.in);

	Hangman() {
		Game();
	}

	private void Game() {
		try {
			while (difficultyInput == 0) {
				System.out.println("Difficulty: ");
				System.out.println("1 - Very Easy");
				System.out.println("2 - Easy");
				System.out.println("3 - Normal");
				System.out.println("4 - Hard");
				System.out.println("5 - Very Hard");

				difficultyInput = scanner.nextInt();

				switch (difficultyInput) {
				case 1:
					ListScanner(VeryEZFile);
					MaxFailGuess = 10;
					break;
				case 2:
					ListScanner(EZFile);
					MaxFailGuess = 8;
					break;
				case 3:
					ListScanner(NormalFile);
					MaxFailGuess = 5;
					break;
				case 4:
					ListScanner(HardFile);
					MaxFailGuess = 5;
					break;
				case 5:
					ListScanner(VeryHardFile);
					MaxFailGuess = 5;
					break;
				default:
					System.out.println("Please input one of the proper difficulty");
					break;
				}

			}
		} catch (InputMismatchException e) {
			scanner.nextLine();
		}
		
		chosingword();
		
		while (!wordGuessed && currentFailGuess < MaxFailGuess) {
			
			if(filledLetters == Chosenword.length())
			{
				wordGuessed = true;
				System.out.println("You got the word guess right");
				System.out.println("You correctly guess the following word");
				System.out.println(Chosenword);
			}
			else
			{
				System.out.println();
				System.out.println("What is the next letter you chose");
				Guess();
			}

		}
	}

	private void ListScanner(File file) {
		try {
			WordScanner = new Scanner(file);
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		}
		
		while(WordScanner.hasNext()) {

			String Word = WordScanner.nextLine();
			listofwords.add(Word);
		}
		while(WordScanner.hasNext());
		WordScanner.close();
	}
	
	private void chosingword()
	{
		randNum = (int)(Math.random() * listofwords.size());
		Chosenword = listofwords.get(randNum);

		Userguessword = new char[Chosenword.length()];	
		
		for (int i = 0; i < Chosenword.length(); i++)
		{
			Userguessword[i] = '_';
		}
	}
	
	public void Guess()
	{
		for (int i = 0; i < Chosenword.length(); i++) {
			System.out.print(Userguessword[i] + " ");
		}
		System.out.println();
		
		guessletter = scanner.next().charAt(0);
		if(Character.isLetter(guessletter))
		{
			guessletter = Character.toLowerCase(guessletter);
			for (int i = 0; i < Chosenword.length(); i++) {
				if (Chosenword.charAt(i) == guessletter) {
					filledLetters++;
					Userguessword[i] = Chosenword.charAt(i);
				}
			}
		}
		else
		{
			System.out.println("User guess is not a letter");
		}
	}
}
