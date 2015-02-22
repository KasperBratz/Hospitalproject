package Authentication;

import java.util.ArrayList;

import Server.User;

public class ACL {
	private ArrayList<ACE> accessEntries = new ArrayList<>();
	
	public ACL(){
		
	}
	
	public void add(ACE ace){
		accessEntries.add(ace);
	}
	
	public boolean remove(ACE ace){
		return accessEntries.remove(ace);
	}
	
	/**
	 * Evaluates whether the user is to be granted access to object.
	 * @param user, the user to be evaluated for access to object
	 * @return status of evalutation
	 */
	public boolean evaluateAccessRight(User user){
		return false;
	}
}
