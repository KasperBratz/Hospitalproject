package Authentication;
import Server.User;

public class JournalFactory {
	/**
	 * Note that only doctors may treat patients.
	 * @param doctor, doctor treating patient.
	 * @param patient, patient being treated.
	 * @return the new journal for the patient.
	 * @throws AuthenticationException
	 */
	public Journal createJournal(User doctor, User patient) throws AuthenticationException {
		if(!doctor.getGroup().equals(Server.Group.Doctor)){
			throw new AuthenticationException();
		}
		return new Journal();
	}
}
