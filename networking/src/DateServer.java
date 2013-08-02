import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class DateServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9090);
			System.out.println("Listening on port 9090");
			while (true) {
				Socket client = server.accept();
				System.out.println("Got a connection from" + client.getInetAddress());
				
				DateThread thread = new DateThread(client);
				Thread t = new Thread(thread);
				t.start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
class DateThread implements Runnable {
	BufferedReader input;
	PrintWriter output;
	
	
	public DateThread(Socket s) {
		try {
			input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			System.out.println("Got an IO exception. Dun dun dun");
		} 
	}

	
	public void run() { 
		while(true) {
			Date d = new Date();
			output.println("The current time is " + d);
		}
	}
	
}
