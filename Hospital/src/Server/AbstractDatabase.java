package Server;

import java.sql.*;

public abstract class AbstractDatabase {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	
	public AbstractDatabase(Connection conn){
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(SQLException e){
			System.out.println("Couldn't connect to the database: "+e.getMessage());
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public abstract boolean insert(String table, String add);
	public abstract boolean delete(String table, String field, String target);
}
