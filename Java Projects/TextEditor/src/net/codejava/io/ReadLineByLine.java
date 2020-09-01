package net.codejava.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadLineByLine {
	public static void main(String [] args) {
		try {
		    Scanner scanner = new Scanner(new File("C:\\Users\\Thomas Zhang\\eclipse-workspace\\TrainDatabase\\TrainData.txt"));
		    while (scanner.hasNextLine()) {
		        System.out.println(scanner.nextLine());
		    }
		    scanner.close();
		        
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		}
	}
}
