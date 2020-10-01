/* Java program for managing trains 
 * Requires a text file (.txt)
 * A proper path needs to be specified
*/
package net.codejava.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class TrainDatabase {
	  static boolean quit = false;
	  static Scanner obj = new Scanner(System.in);
	  static String info, infoCat, trainCompany, loadedCondition, cargoType, trainDirection, citySeen, numberOfCars;
	  static boolean isInt(String s) {
		  for (int a = 0; a < s.length(); a++) {
			  if (a == 0 && s.charAt(a) == '-') 
				  continue;
			  if (!Character.isDigit(s.charAt(a))) 
				  return false;
		  }
		  return true;
	 }
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
	  public static void getTC() {
		  System.out.println("Enter train company: (eg. BNSF)");
		  trainCompany = obj.nextLine();
		  	while (trainCompany.equalsIgnoreCase("BNSF") == false && trainCompany.equalsIgnoreCase("CSX") == false 
		  			&& trainCompany.equalsIgnoreCase("NORFOLK SOUTHERN") == false && trainCompany.equalsIgnoreCase("KCS") == false 
		  			&& trainCompany.equalsIgnoreCase("UNION PACIFIC") == false && trainCompany.equalsIgnoreCase("FXE") == false
		  			&& trainCompany.equalsIgnoreCase("CANADIAN PACIFIC") == false && trainCompany.equalsIgnoreCase("CANADIAN NATIONAL") == false && trainCompany.equalsIgnoreCase("AMTRAK") == false) {
		  		System.out.println("Try again");
		  		getTC();
		  	}
	  }
	  public static void getLC() {
		  System.out.println("Enter loaded condition: (eg. empty, loaded, unknown, not applied");
		  loadedCondition = obj.nextLine();
		  while (loadedCondition.equalsIgnoreCase("EMPTY") == false && loadedCondition.equalsIgnoreCase("LOADED") == false 
				  && loadedCondition.equalsIgnoreCase("UNKNOWN") == false && loadedCondition.equalsIgnoreCase("NOT APPLIED") == false) {
			  System.out.println("Try again");
		  	  getLC();
		  }
	  }
	  public static void getCT() {
		  System.out.println("Enter the type of cargo: (eg. grain)");
		  cargoType = obj.nextLine();
		  while (cargoType.equalsIgnoreCase("INTERMODAL") == false && cargoType.equalsIgnoreCase("MIXED FREIGHT") == false
				  && cargoType.equalsIgnoreCase("TRASH") == false && cargoType.equalsIgnoreCase("COAL") == false 
				  && cargoType.equalsIgnoreCase("GRAIN") == false && cargoType.equalsIgnoreCase("SAND") == false
				  && cargoType.equalsIgnoreCase("ROCK") == false && cargoType.equalsIgnoreCase("PASSENGER") == false
				  && cargoType.equalsIgnoreCase("GEO") == false && cargoType.equalsIgnoreCase("STEAM") == false) {
		  		System.out.println("Try again");
		  		getCT();
		 }
	  }
	  public static void getTD() {
		  System.out.println("Enter the direction of the train: (eg. northbound)");
		  trainDirection = obj.nextLine();  
		  	while (trainDirection.equalsIgnoreCase("N") == false && trainDirection.equalsIgnoreCase("NORTH") == false && trainDirection.equalsIgnoreCase("NORTHBOUND") == false
		  			&& trainDirection.equalsIgnoreCase("S") == false && trainDirection.equalsIgnoreCase("SOUTH") == false && trainDirection.equalsIgnoreCase("SOUTHBOUND") == false
		  			&& trainDirection.equalsIgnoreCase("E") == false && trainDirection.equalsIgnoreCase("EAST") == false && trainDirection.equalsIgnoreCase("EASTBOUND") == false
		  			&& trainDirection.equalsIgnoreCase("W") == false && trainDirection.equalsIgnoreCase("WEST") == false && trainDirection.equalsIgnoreCase("WESTBOUND") == false) {
		  		System.out.println("Try again");
		  		getTD();
		  	}
	  }
	  public static void getCS() {
		  System.out.println("Enter the city the train was seen:(eg. Tampa, eg. New Orleans)");
		  citySeen = obj.nextLine();
		  while (citySeen.matches(".*\\d.*")) {
		  		System.out.println("Please enter a valid city.");
		  		getCS();
		  }
	  }
	  public static void getNC() {
		  System.out.println("Enter the number of train cars: (eg. 144)");
		  numberOfCars = obj.nextLine();
		  	while (numberOfCars.isEmpty()) {
		  		System.out.println("Try again");
		  		getNC();
	  		}
		  	while (isInt(numberOfCars) == false) {
		  		System.out.println("Try again");
		  		getNC();
		  	}
	  }
	  public static void getInfo() {
		  try {
			  	getTC();
			  	getLC();
			  	getCT();
			  	getTD();
			  	trainDirection = trainDirection.toUpperCase();
			  	System.out.println(trainDirection);
			  	if (trainDirection == "N") 
			  		trainDirection = trainDirection.replace("N", "NORTHBOUND");
			  	else if (trainDirection.toUpperCase() == "NORTH")
			  		trainDirection = trainDirection.replace("NORTH", "NORTHBOUND");
			  	else if (trainDirection == "S") 
			  		trainDirection = trainDirection.replace("S", "SOUTHBOUND");
			  	else if (trainDirection.toUpperCase() == "SOUTH")
			  		trainDirection = trainDirection.replace("SOUTH", "SOUTHBOUND");
			  	else if (trainDirection == "W") 
			  		trainDirection = trainDirection.replace("W", "WESTBOUND");
			  	else if (trainDirection.toUpperCase() == "WEST")
			  		trainDirection = trainDirection.replace("WEST", "WESTBOUND");
			  	else if (trainDirection == "E") 
			  		trainDirection = trainDirection.replace("E", "EASTBOUND");
			  	else if (trainDirection.toUpperCase() == "EAST")
			  		trainDirection = trainDirection.replace("EAST", "EASTBOUND");
			  	System.out.println(trainDirection);
			  	getCS();
			  	getNC();
		  }
		  catch (StringIndexOutOfBoundsException Exception) {
			  getInfo();
		  }
	  }
	  public static void write() {
	        try {
	            FileWriter writer = new FileWriter("C:\\Users\\Thomas Zhang\\eclipse-workspace\\TrainDatabase\\TrainData.txt", true);
	            getInfo();
	  		    infoCat = trainCompany + '_' + loadedCondition + '_' + cargoType + '_' + trainDirection + '_' + citySeen + '_' + numberOfCars + '_';
	  		    infoCat = infoCat.toUpperCase();
	  		    if (infoCat.contains(" "))
	  		    	infoCat = infoCat.replace(' ', '-');
	  		    if (infoCat.contains("EMPTY")) 
	  		    	infoCat = infoCat.replace("EMPTY", "0");
	  		    if (infoCat.contains("LOADED")) 
	  		    	infoCat = infoCat.replace("LOADED", "1");
	  		    if (infoCat.contains("UNKNOWN")) 
	  		    	infoCat = infoCat.replace("UNKNOWN", "2");
	  		    if (infoCat.contains("NOT-APPLIED")) 
	  		    	infoCat = infoCat.replace("NOT-APPLIED", "3");
	  		    System.out.println(infoCat);
	            writer.write("\r\n");
	            writer.write(infoCat);
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