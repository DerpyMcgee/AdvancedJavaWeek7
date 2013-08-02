import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class ChatClient {
	BufferedReader input;
	PrintWriter output;
	boolean initialized = false;
	
	public ChatClient(String ip, int port) {
		try {
			Socket sock = new Socket(ip, port);
			 input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			 output = new PrintWriter(sock.getOutputStream(), true);	
			 initialized = true;
			
		} catch (UnknownHostException e) {
			System.out.println("That's not a valid host!");
		
		} catch (IOException e) {
			System.out.println("Got an IO exception");
	
		}
	}	
	public void send(String message) {
		if (initialized) {
			output.println("Ronak: " + message);
		}
	}
	
	public String receive() {
		if (initialized) {
			try {
				return input.readLine();
			} catch (IOException e) {
			}
		}
		return null;
	}

}
