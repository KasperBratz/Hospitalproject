package Authentication;

import Server.User;

public class Journal {
	private String text;
	private ACL acl;
	
	public Journal(){
		acl = new ACL();
	}
	
	/**
	 * @param accessRight, the access right which is requested
	 * @param user, the user which is requesting access right
	 */
	public boolean request(ACL.AccessRight accessRight, User user){
		return AccessEvaluator.request(user, accessRight, acl);
	}
	
	public void addAccessPermission(ACL.AccessRight accessRight, User user){
		
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
