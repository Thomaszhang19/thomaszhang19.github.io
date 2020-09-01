import java.net.*;
import java.io.*;
public class EchoClient {
public static void main(String arg[]) throws IOException {
		Socket cls = null;
		BufferedReader br = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			cls = new Socket("192.168.1.70", 32884);
			br = new BufferedReader(new InputStreamReader(cls.getInputStream()));
			in = new DataInputStream(System.in);
			out = new DataOutputStream(cls.getOutputStream());
		}
		catch(UnknownHostException uh) {
			System.out.println("Don't know the server");
			System.exit(0);
		}
		catch(Exception e) {
			System.out.println("Error : " + e);
			System.exit(0);
		}
		System.out.println("Connection established with : " + cls);
		System.out.println("Type \"exit\" to quit.....");
		String inp="",si;
		boolean more=true;
		while (more) {
			si = in.readLine();
			out.writeBytes(si);
			out.write(13);
			out.write(10);
			if (si.equals("exit"))
				break;
			inp = br.readLine();
			System.out.println(inp);
		}
		System.out.println("Disconnected..........");
		br.close();
		cls.close();
	}
}