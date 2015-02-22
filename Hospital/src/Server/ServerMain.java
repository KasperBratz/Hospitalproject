package Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.security.KeyStore;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;


public class ServerMain {
	
	public static void main (String []args){
		System.out.println("\nServer Started\n");
		AbstractDatabase db = new Database();
		
		try{
			System.out.println("Listening...");
			Login log = new Login();
			new Server(log);
		}catch (IOException e){
            System.out.println("Unable to start Server: " + e.getMessage());
            e.printStackTrace();
        }
	}
}
