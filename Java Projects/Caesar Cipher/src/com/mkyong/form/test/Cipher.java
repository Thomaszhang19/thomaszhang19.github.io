package com.mkyong.form.test;
import java.util.Random;
import java.util.Scanner;

public class Cipher {
	public static Scanner scanner = new Scanner(System.in);
	public static boolean fail = false;
	public static String s;
	public static String msg;
	
	public static void encrypt(String msg, int shift) 
	{
        String t = "";
        int msgShifted = 0;
        int overflow;
        String encryptedMsg;
        for (int i = 0; i < msg.length(); i++) 
        {
            char ch = msg.charAt(i);
            if (!t.isEmpty())
                t += " ";
            int n = (int)ch - (int)'a' + 1;
            if (Integer.parseInt(String.valueOf(n)) <= 26 || Integer.parseInt(String.valueOf(n)) > 0) 
            {
            	if (Integer.parseInt(String.valueOf(n)) + shift > 26) {
            		overflow = (Integer.parseInt(String.valueOf(n)) + shift) - 26;
            		msgShifted = overflow;
            	}
            	else
            		msgShifted = Integer.parseInt(String.valueOf(n)) + shift;
            }
            encryptedMsg = getCharForNumber(msgShifted);
            try 
            {
            	System.out.print(encryptedMsg.toLowerCase());
            }
            catch (NullPointerException e) 
            {
            	System.out.print(" ");
            }
        }
	}
	
	public static void decrypt(String eMsg, int key)
	{
		String t = "";
		int msgUnShifted = 0;
		String decryptedMsg = null;
		int underflow;
        for (int i = 0; i < eMsg.length(); i++) 
        {   
        	char ch = eMsg.charAt(i);
            if (!t.isEmpty())
                t += " ";
            int n = (int)ch - (int)'a' + 1;
            if (Integer.parseInt(String.valueOf(n)) <= 26 || Integer.parseInt(String.valueOf(n)) > 0) 
            {
            	if (Integer.parseInt(String.valueOf(n)) - key < 1)
            	{
            		underflow = (Integer.parseInt(String.valueOf(n)) - key) + 26;
            		msgUnShifted = underflow;
            	}
            	else
            		msgUnShifted = Integer.parseInt(String.valueOf(n)) - key;
            }
            decryptedMsg = getCharForNumber(msgUnShifted);
            try 
            {
            	System.out.print(decryptedMsg.toLowerCase());
            }
            catch (NullPointerException e) 
            {
            	System.out.print(" ");
            }
        }
	}
	
	public static String getCharForNumber(int i) 
	{
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
	
	public static int rand(int min, int max) 
	{
		Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}
	
	public static boolean ifImpShift() 
	{
		boolean isRand = false;
		boolean pass = false;
		while (pass == false) 
		{
			if (fail == true) 
			{
				System.out.println("Do you not want an encrypted message???");
				System.out.println("Enter the number to shift your message or 'r' for a random shift");
				fail = false;
			}
			s = scanner.nextLine();
			if (s.equalsIgnoreCase("r")) 
			{
				pass = true;
				isRand = true;
			}
			if (s.matches("^[0-9]*$")) 
			{
				int i = Integer.parseInt(s);
				if (i > 0 && i < 26) 
				{
					pass = true;
					isRand = false;
				}
				if (i == 0 || i == 26) 
				{
					fail = true;
					pass = false;
				}
			}
		}
		if (isRand)
			return false;
		else
			return true;
	}	
	
	public static boolean isEncrypt() 
	{
		boolean isEncrypt = false;
		boolean pass = false;
		String s;
		while (pass == false) {
			System.out.println("Enter 'e' to encrypt a message or 'd' to decrypt a message.");
			s = scanner.nextLine();
			if (s.equalsIgnoreCase("e")) 
			{
				isEncrypt = true;
				pass = true;
			}
			else if (s.equalsIgnoreCase("d")) 
			{
				isEncrypt = false;
				pass = true;
			}
			else
				System.out.println("Please try again.");
		}
		return isEncrypt;
	}
	
	public static void askMsg() 
	{
		boolean pass = false;
		while (pass == false) 
		{
			System.out.println("Enter your message that needs encryption:");
			msg = scanner.nextLine();
			if (msg.matches(".*\\d.*")) 
			{
				pass = false;
				System.out.println("Sorry, no numbers are allowed in your message.");
			}
			else
				pass = true;
		}
	}
	
}
