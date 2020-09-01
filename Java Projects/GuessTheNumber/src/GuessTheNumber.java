import java.lang.Math;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class GuessTheNumber {
	public static int min, max, guess1, guess2;
	static Scanner obj = new Scanner(System.in);
	public static void getMinVal() {
		try {
			System.out.println("Enter the minimum random number limit:");
			min = Integer.parseInt(obj.nextLine());
		}
		catch (NumberFormatException exception) {
			System.out.println("That is not an integer.");
			getMinVal();
		}
	}
	public static void getMaxVal() {
		try {
			System.out.println("Enter the maximum random number limit:");
			max = Integer.parseInt(obj.nextLine());
			if (max <= min) {
				System.out.println("You must enter a greater than your minimum value of " + min);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				getMaxVal();
			}
		}
		catch (NumberFormatException exception) {
			System.out.println("That is not an integer.");
			getMaxVal();
		}
	}
	public static void playerOneGuess() {
		System.out.println("Enter player 1's guess:");
		try {
			guess1 = Integer.parseInt(obj.nextLine());
			if (guess1 > max || guess1 < min) {
				System.out.println("You must enter a number between " + min + " and " + max + ":");
				playerOneGuess();
			}
		}
		catch (NumberFormatException exception) {
			System.out.println("That is not an integer.");
			playerOneGuess();
		}
	}
	public static void playerTwoGuess() {
		System.out.println("Enter player 2's guess:");
		try {
			guess2 = Integer.parseInt(obj.nextLine());
			if (guess2 > max || guess2 < min) {
				System.out.println("You must enter a number between " + min + " and " + max + ":");
				playerTwoGuess();
			}
		}
		catch (NumberFormatException exception) {
			System.out.println("That is not an integer.");
			playerTwoGuess();
		}
	}
	public static void main(String[] args) {
		System.out.println("This game needs 2 players.");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("First, set the range of numbers to guess:");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getMinVal();
		getMaxVal();
		int randNum = (int) (Math.random() * (max - min + 1) + min);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Make two guesses of number between " + min + " and " + max + ":");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		playerOneGuess();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		playerTwoGuess();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int diff1 = Math.abs(randNum - guess1); 
		int diff2 = Math.abs(randNum - guess2);
		if (diff1 < diff2) {
			System.out.println("Player 1 wins!");
		} else if (diff1 > diff2) {
			System.out.println("Player 2 wins!");
		} else {
			System.out.println("It's a tie!");
		}
		System.out.println("The random number was " + randNum);
		obj.close();
	}
}