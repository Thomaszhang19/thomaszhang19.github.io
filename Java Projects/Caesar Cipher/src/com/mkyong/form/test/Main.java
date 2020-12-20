package com.mkyong.form.test;
public class Main extends Cipher
{
	public static void main(String[] args) 
	{
		boolean pass = false;
		boolean b = false;
		String string = null;
		String str;
		int key;
		if (isEncrypt()) 
		{
			int r = rand(1, 25);
			askMsg();
			System.out.println("Enter the number to shift your message or 'r' for a random shift");
			if (ifImpShift()) 
			{
				System.out.print("Your encrypted message will be shifted right " + s + " letters. \n");
				encrypt(msg, Integer.parseInt(s));
			}
			else 
			{
				System.out.print("Your encrypted message will be shifted right " + r + " letters. \n");
				encrypt(msg, r);
			}
		}	
		else 
		{
			while (pass == false)
			{
				System.out.println("Enter your message that needs decryption:");
				string = scanner.nextLine();
				if (string.isEmpty())
					System.out.println("Your message is empty; Please try again.");
				else if (string.matches("^[0-9]*$"))
					System.out.println("Sorry, no numbers are allowed in your message.");
				else 
					pass = true;
			}
			
			while (b == false)
			{
				System.out.println("Enter your key. If you do not have a key, enter 't' to try all 26 possible outcomes.");
				str = scanner.nextLine();
				if (str.equalsIgnoreCase("t"))
				{
					b = true;
					System.out.println("----------------------------------------------------------|");
					for (int i = 0; i < 26; i++)
					{
						decrypt(string, i);
						System.out.println("");
					}
					System.out.println("----------------------------------------------------------|");
				}
				else if (str.matches("^[0-9]*"))
					if (Integer.parseInt(str) < 26 && Integer.parseInt(str) > 0)
					{
						b = true;
						key = Integer.parseInt(str);
						decrypt(string, key);
					}
					else
						System.out.println("Enter a key between 1 and 25. \n");
			}
		}
	}	
}
