package Server;

public class User {
	
	public String getUID() {
		return UID;
	}


	public Group getGroup() {
		return group;
	}


	public String getPassword() {
		return password;
	}


	private String UID;
	private Group group;
	private String password;
	
	
	public User(String UID, Group group, String password){
		this.UID=UID;
		this.group=group;
		this.password=password;
	}
	
	
}
