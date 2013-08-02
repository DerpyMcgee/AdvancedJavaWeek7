import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class DateClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the server IP address: ");
		String ip = scan.nextLine();
		
		try {
			Socket sock = new Socket(ip, 9090);
			BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintWriter output = new PrintWriter(sock.getOutputStream(), true);
			
			
			
			while (true) {
			String in = input.readLine();
			if (in != null) {
				System.out.println(in);
			}
			}
			
			
			
		} catch (UnknownHostException e) {
			System.out.println("That's not a valid host!");
		
		} catch (IOException e) {
			System.out.println("Got an IO exception");
	
		}

	}

}
