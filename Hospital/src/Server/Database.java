package Server;

import java.sql.*;

public class Database extends AbstractDatabase{
	private Connection conn;
	
	public Database(Connection _conn){
		conn = _conn;
	}

	@Override
	public void test() {
		try{
			Statement stmt = null;
			stmt = conn.createStatement();
			String sql;
			sql = "select * from users";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				System.out.println("Dump: "+rs.getString("name"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
