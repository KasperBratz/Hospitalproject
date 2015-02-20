package Client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;

public class ClientMain {
	
	public static void main (String args[]){
		try {
		SSLSocket socket = Client.clientSocketFactory();
		socket.startHandshake();
		
		GUI gui = new GUI();
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
        in.close();
		out.close();
        socket.close();
        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
