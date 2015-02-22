package Server;

import java.sql.*;

public class Database extends AbstractDatabase{
	private static Connection conn;
	
	public Database(){
		super(conn);
	}

	@Override
	public boolean insert(String table, String add) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String table, String field, String target) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
