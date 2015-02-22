package Server;

import java.sql.*;

public class LoggingDatabase extends AbstractDatabase{
	private static Connection conn;
	
	public LoggingDatabase(){
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
