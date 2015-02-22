package Authentication;

import java.util.ArrayList;
import java.util.Iterator;

import Server.User;

/**
 * @author dat12hba
 */
public class ACL implements Iterable<ACE>{
	private ArrayList<ACE> accessEntries = new ArrayList<>();
	
	/**
	 * @author dat12hba
	 * Simple structure to describe possible access types in the hospital system.
	 */
	public static enum AccessType{
		Allow("ALLOW_TYPE"), Deny("DENY_TYPE");
		
		private String type;
		AccessType(String type){
			this.type = type;
		}
		
		public boolean equals(AccessType other){
			return this.type.equals(other.type);
		}
	}
	
	/**
	 * @author dat12hba
	 * Simple structure to describe possible principal types in the hospital system.
	 */
	public static enum PrincipalType{
		UID("UID_TYPE"), GID("GID_TYPE");
		
		private String type;
		PrincipalType(String type){
			this.type = type;
		}
		
		public boolean equals(PrincipalType other){
			return this.type.equals(other.type);
		}
	}
	
	/**
	 * @author dat12hba
	 * Simple structure to describe possible access rights in the hospital system.
	 */
	public static enum AccessRight {
		Read("Read_ID"), Write("Write_ID");
		
		private String id;
		AccessRight(String id){
			this.id = id;
		}
		
		public boolean equals(AccessRight other){
			return this.id.equals(other.id);
		}
	}
	
	public ACL(){}
	
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

	@Override
	public Iterator<ACE> iterator() {
		return accessEntries.iterator();
	}
}
