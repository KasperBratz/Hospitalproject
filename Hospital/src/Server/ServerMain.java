package Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.security.KeyStore;
import java.sql.*;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;


public class ServerMain {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/EMP";

	//  Database credentials
	static final String USER = "username";
	static final String PASS = "password";
	
	public static void main (String []args){
		System.out.println("\nServer Started\n");
		
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			System.out.println("Listening...");
			Login log = new Login();
			new Server(log);
			
			conn.close();
		}catch(SQLException e){
			System.out.println("Unable to conenct to the Database: " + e.getMessage());
			e.printStackTrace();
		}catch (IOException e){
            System.out.println("Unable to start Server: " + e.getMessage());
            e.printStackTrace();
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
}
