package net.codejava.io;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class TextEditor {
	static Scanner obj = new Scanner(System.in);
	static char rw;
	public static void readOrWrite() {
		try {
			String s;
			System.out.println("Enter 'r' to read and 'w' to write.");
			s = obj.nextLine();
			if (s.length() > 1) {
				readOrWrite();
			}
			rw = s.charAt(0);
			if (rw == 'r' || rw == 'R') {
		         try {
		             FileReader reader = new FileReader("C:\\Users\\Thomas Zhang\\eclipse-workspace\\TextEditor\\src\\net\\codejava\\io\\Note.txt");
		             int character;
		             while ((character = reader.read()) != -1) {
		                 System.out.print((char) character);
		             }
		             reader.close();
		         } 
		         catch (IOException e) {
		             e.printStackTrace();
		         }
	    	} 
			else if (rw == 'w' || rw == 'W') {
		        try {
		            FileWriter writer = new FileWriter("C:\\Users\\Thomas Zhang\\eclipse-workspace\\TextEditor\\src\\net\\codejava\\io\\Note.txt", true);
		            System.out.println("Enter what you want to write:");
		            String w = obj.nextLine();
		            writer.write("\r\n");
		            writer.write(w);
		            writer.close();
		            System.out.println("Written " + "\"" + w + "\"" + " in the text file!");
		        } 
		        catch (IOException e) {
		            e.printStackTrace();
		        }
	    	}
			else {
				readOrWrite();
			}
		}
		catch (StringIndexOutOfBoundsException Exception) {
			readOrWrite();
		}
	}
    public static void main(String[] args) {
    	readOrWrite();
    }
}
