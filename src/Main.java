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

		/**
		 * 
		 */
		try {
			Scanner wordfile = new Scanner(new File("words.txt"));
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		}
		
		Scanner scanner = new Scanner(System.in);
		
		String Chosenword;
		char[] Userguessword;
		
		int difficultyInput = 0;
		
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

			}
		} catch (InputMismatchException e) {
			scanner.nextLine();
		}
	}

}
