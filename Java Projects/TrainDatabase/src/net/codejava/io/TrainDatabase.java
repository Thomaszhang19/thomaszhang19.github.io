package net.codejava.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class TrainDatabase {
	  static boolean quit = false;
	  static Scanner obj = new Scanner(System.in);
	  static String info, a, trainCompany, loadedCondition, cargoType, trainDirection, citySeen, numberOfCars;
	  public static void read() {
		  try {
			    boolean f = false;
			    Scanner scanner = new Scanner(new File("C:\\Users\\Thomas Zhang\\eclipse-workspace\\TrainDatabase\\TrainData.txt"));
			    System.out.println("Enter a term to search for:");
			    String term = obj.nextLine();
	        	System.out.println("----------------------------------------------------------|");
			    if (term.contains(" "))
			    	term = term.replace(' ', '-');
			    while (scanner.hasNextLine()) {
			    	String string = scanner.nextLine();
			        if (string.contains(term.toUpperCase())) {
			        	decode(string);
			        	System.out.println("----------------------------------------------------------|");
			        	f = true;
			        }   
			    }
			    if (f == false) {
		        	System.out.println("Unable to find a train with that term.");
		        	System.out.println("Terms supported: <Company Name>, <Cargo>, <City>, <Number of Cars>");
		        	System.out.println("----------------------------------------------------------|");
			    }
			    scanner.close();
			        
			} catch (FileNotFoundException ex) {
			    ex.printStackTrace();
			}
	  }
	  public static void getInfo() {
		  try {
			  	System.out.println("Enter train company: (eg. BNSF)");
			  	trainCompany = obj.nextLine();
			    System.out.println("Enter loaded condition: (eg. empty, loaded, unknown, not applied");
			    loadedCondition = obj.nextLine();
			    System.out.println("Enter the type of cargo: (eg. grain)");
			    cargoType = obj.nextLine();	 
			    System.out.println("Enter the direction of the train: (eg. northbound)");
			    trainDirection = obj.nextLine();
			    System.out.println("Enter the city the train was seen:(eg. Tampa. eg. New Orleans)");
			    citySeen = obj.nextLine();
			    System.out.println("Enter the number of train cars: (eg. 144)");
			    numberOfCars = obj.nextLine();
		  }
		  catch (StringIndexOutOfBoundsException Exception) {
			  getInfo();
		  }
	  }
	  public static void write() {
	        try {
	            FileWriter writer = new FileWriter("C:\\Users\\Thomas Zhang\\eclipse-workspace\\TrainDatabase\\TrainData.txt", true);
	            getInfo();
	  		    a = trainCompany + '_' + loadedCondition + '_' + cargoType + '_' + trainDirection + '_' + citySeen + '_' + numberOfCars + '_';
	  		    a = a.toUpperCase();
	  		    if (a.contains(" "))
	  		    	a = a.replace(' ', '-');
	  		    if (a.contains("EMPTY")) 
	  		    	a = a.replace("EMPTY", "0");
	  		    if (a.contains("LOADED")) 
	  		    	a = a.replace("LOADED", "1");
	  		    if (a.contains("UNKNOWN")) 
	  		    	a = a.replace("UNKNOWN", "2");
	  		    if (a.contains("NOT-APPLIED")) 
	  		    	a = a.replace("NOT-APPLIED", "3");
	  		    System.out.println(a);
	            writer.write("\r\n");
	            writer.write(a);
	            writer.close();
	            System.out.println("Added train.");
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	  }
	  public static void decode(String trainInfo) {
		  info = "";
		  int x;
		  int t = -1;
		  for (int i = 0; i < 6; i++) {
			  info = "";
			  t += 1;
			  while (trainInfo.charAt(t) != '_') {
				  String s = String.valueOf(trainInfo.charAt(t));
				  info = info + s;
				  t++;
			  }
			  switch (i) {
			  	case 0:
			  	  if (info.contains("-")) {
			  			info = info.replace('-', ' ');
			  			System.out.println("Company: " + info.toLowerCase());
			  	  }
			  	  else
			  		  System.out.println("Company: " + info.toLowerCase());
				  break;
			  	case 1:
			  		System.out.print("Cargo: ");
			  		if (Integer.parseInt(info) == 0) 
			  			System.out.print("empty ");
			  		else if (Integer.parseInt(info) == 1) 
			  			System.out.print("loaded ");
			  		else if (Integer.parseInt(info) == 2) 
			  			System.out.print("unknown loaded condition ");
			  		break;
			  	case 2:
			  		System.out.print(info.toLowerCase());
			  		System.out.println("");
			  		break;
			  	case 3:
			  		System.out.println("Direction: " + info.toLowerCase());
			  		break;
			  	case 4:
			  		if (info.contains("-")) {
			  			info = info.replace('-', ' ');
			  			System.out.println("City: " + info.toLowerCase());
			  		}
			  		else 
			  			System.out.println("City: " + info.toLowerCase());	
			  		break;
			  	case 5:
			  		x = Integer.parseInt(info);
			  		System.out.println("Number of cars: " + x);
			  		break;
			  }
		  }
	  }
	  public static void readOrWrite() {
		  try {
			  System.out.println("Enter 's' to search for a train, 'a' to add a train, and 'q' to quit.");
			  String s = obj.nextLine();
			  if (s.length() != 1)
				  readOrWrite();
			  char rw = s.charAt(0);
			  if (rw == 's' || rw == 'S') 
				  read();
			  else if (rw == 'a' || rw == 'A')
				  write();
			  else if (rw == 'q' || rw == 'Q') {
				  quit = true;
				  System.out.println("Terminated");
			  }
			  else 
				  readOrWrite();
		  }
		  catch (StringIndexOutOfBoundsException Exception) {
			  readOrWrite();
		  }
	  }
	  public static void main(String[] args) {
		  while (true) {
			  readOrWrite();
			  if (quit == true)
			      break;
		  }
		  obj.close();
	  }
}