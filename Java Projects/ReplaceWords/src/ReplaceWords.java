import java.util.Scanner;
public class ReplaceWords {
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter a sentence that needs modification:");
		String sentence = obj.nextLine();
		System.out.println("Which word do you want to replace?");
		String wrepl = obj.nextLine();	
		if (sentence.toLowerCase().indexOf(wrepl.toLowerCase()) != -1 ) {
			System.out.println("Which word do you want to replace it with?");
			String repl = obj.nextLine();
			System.out.println("Your new sentence is " + "\"" + sentence.replace(wrepl, repl) + "\"");
			obj.close();
		}
		else {
			System.out.println("The word you entered isn't in the sentence.");
			obj.close();
		}
	}
}
