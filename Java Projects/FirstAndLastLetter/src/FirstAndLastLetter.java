import java.util.Scanner;
public class FirstAndLastLetter {
	public static void main(String[] args) {
		Scanner obj = new Scanner(System. in );
		String word;
		System.out.println("Enter a word:");
		word = obj.nextLine();
		obj.close();
		firstLastCheck(word); 
	}
	public static void firstLastCheck(String s) {
		char firstLetter;
		char lastLetter;
		firstLetter = s.charAt(0);
		lastLetter = s.charAt(s.length() - 1);
		if (firstLetter == lastLetter) {
			System.out.println("The word " + s + " starts and ends on the same letter!");
		}
		else {
			System.out.println("The word " + s + " doesn't start and end on the same letter!");
		}
	}
}