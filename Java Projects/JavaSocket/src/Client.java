import java.net.*; 
import java.io.*; 
import java.util.Scanner;  
public class Client 
{ 
    private Socket socket            = null; 
    private DataInputStream  input   = null; 
    private DataOutputStream out     = null;
    Scanner obj = new Scanner(System.in);
    public Client(String address, int port) 
    { 
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected"); 
            input  = new DataInputStream(System.in);
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
        String line = ""; 
        while (!line.equals("Over")) 
        { 
            try
            { 
                line = obj.nextLine();
                out.writeUTF(line); 
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
        try
        { 
            input.close(); 
            out.close(); 
            socket.close();
            obj.close();
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
    public static void main(String args[]) 
    { 
        Client client = new Client("192.168.1.70", 32884); 
    } 
} 
