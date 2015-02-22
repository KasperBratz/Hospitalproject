package Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.Random;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;


public class ServerMain {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://puccini.cs.lth.se/db89";

	//  Database credentials
	static final String USER = "db89";
	static final String PASS = "gotroot";
	
	
	public static void main (String []args){
		System.out.println("\nServer Started\n");
		AbstractDatabase db = null;
		
		try{
			System.out.println("Connecting to database...");
			Connection conn = null;
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			db = new Database(conn);
			
			System.out.println("Listening...");
			Login log = new Login();
			new Server(log);
			
		}catch(SQLException e){
			System.out.println("Couldn't connect to the database: "+e.getMessage());
			e.printStackTrace();
		}catch (IOException e){
            System.out.println("Unable to start Server: " + e.getMessage());
            e.printStackTrace();
        }catch(Exception e){
			e.printStackTrace();
		}
		
		db.test();
	}
}
