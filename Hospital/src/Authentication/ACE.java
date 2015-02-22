package Authentication;

import Authentication.ACL.AccessRight;
import Authentication.ACL.AccessType;
import Authentication.ACL.PrincipalType;
import Server.Group;

public class ACE {
	private AccessType accessType;
	private PrincipalType principalType;
	private AccessRight accessRight;
	private String UID;
	private Group group;
	
	public ACE(AccessType accessType, AccessRight accessRight, String UID){
		this.accessType = accessType;
		this.accessRight = accessRight;
		this.UID = UID;
		principalType = PrincipalType.UID;
	}
	
	public ACE(AccessType accessType, AccessRight accessRight, Group group){
		this.accessType = accessType;
		this.accessRight = accessRight;
		this.group = group;
		principalType = PrincipalType.GID;
	}
	
	public AccessType getAccessType() {
		return accessType;
	}

	public PrincipalType getPrincipalType() {
		return principalType;
	}

	public String getUID() {
		return UID;
	}

	public Group getGroup() {
		return group;
	}
	
	public AccessRight getAccessRight(){
		return accessRight;
	}
}
