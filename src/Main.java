import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main
 * @author Kevin
 *
 */
public class Main {

	public static void main(String[] args) {
		
		int randNum;
		File VeryEZFile = new File("VeryEZWord.txt");
		File EZFile = new File("EZWord.txt");
		File NormalFile = new File("NormWord.txt");
		File HardFile = new File("HardWord.txt");
		File VeryHardFile = new File("VeryHard.txt");
		
		boolean wordGussed = false;
		
		String Chosenword = "Tesla";
		char[] Userguessword;
		char guessletter;

		int difficultyInput = 0;
		
		Scanner WordScanner;
		Scanner scanner = new Scanner(System.in);
		
		try {
			WordScanner = new Scanner(new File("veryEZwords.txt"));
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		}
		
		try {
			while (difficultyInput == 0) {
				System.out.println("Difficulty: ");
				System.out.println("1 - Very Easy");
				System.out.println("2 - Easy");
				System.out.println("3 - Normal");
				System.out.println("4 - Hard");
				System.out.println("5 - Very Hard");

				difficultyInput = scanner.nextInt();
				
				/*
				switch (difficultyInput) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Please input one of the proper difficulty");
					break;
				}
				*/

			}
		} catch (InputMismatchException e) {
			scanner.nextLine();
		}
		
		Userguessword = new char[Chosenword.length()];
		
		for(int i = 0; i < Chosenword.length(); i++)
		{
			Userguessword[i] = '_';
		}
		
		while(!wordGussed)
		{
			
			for(int i = 0; i < Chosenword.length(); i++)
			{
				System.out.print(Userguessword[i] + " ");
			}
			System.out.println();
			System.out.println("What is the next letter you chose");
			
			guessletter = scanner.next().charAt(0);
			System.out.println(guessletter);
			
			for(int i = 0; i < Chosenword.length(); i++)
			{
				if (Chosenword.charAt(i) == guessletter)
				{
					Userguessword[i] = Chosenword.charAt(i);
				}
			}
			
		}
	}

}
