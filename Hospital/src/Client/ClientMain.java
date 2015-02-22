package Client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;

public class ClientMain {
	
	public static void main (String args[]){
		try {
		SSLSocket socket = Connector.clientSocketFactory();
		socket.startHandshake();
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		//out.flush();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		Sender sender = new Sender(in, out);
        
		GUI gui = new GUI(sender);
		
		
		
        /*in.close();
		out.close();
        socket.close();
        */
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
