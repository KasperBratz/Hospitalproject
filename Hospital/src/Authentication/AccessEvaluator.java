package Authentication;

import java.util.Iterator;
import Authentication.ACL.AccessType;
import Authentication.ACL.PrincipalType;
import Server.Group;
import Server.User;

public class AccessEvaluator {
	/**
	 * Determines if a subject gets access to an object o. A subject gets access
	 * if: Subject UID/GID in ACE with requested right
	 * 
	 * @param user
	 *            , the user that wishes access
	 * @param requestedRight
	 *            , the access right the subject requests.
	 * @param acl
	 *            , the access control list associated with o.
	 * @return true if access granted, false otherwise.
	 */
	public static boolean request(User user,
			ACL.AccessRight requestedRight, ACL acl) {
		Group group = user.getGroup();
		String UID = user.getUID();
		Iterator<ACE> itr = acl.iterator();
		
		while (itr.hasNext()) {
			ACE ace = itr.next();
			boolean principalMatch = ace.getPrincipalType().equals(
					PrincipalType.UID) ? (UID.equals(ace.getUID())) : (group
					.equals(ace.getGroup()));
			boolean requestRightMatch = requestedRight.equals(ace
					.getAccessRight());
			if (principalMatch & requestRightMatch) {
				return ace.getAccessType().equals(AccessType.Allow);
			}
		}
		return false;
	}
	
	public void emptyToCommit(){
		
	}
}
