package Server;

public enum Group {
	Government("Government", "GOVERNMENT_GID"),
	Nurse("Nurse", "NURSE_GID"),
	Patient("Patient", "PATIENT_GID"),
	Doctor("Doctor", "DOCTOR_GID");
	
	private String name;
	private String GID;
	
	Group(String name, String GID){
		this.name = name;
		this.GID = GID;
	}
	
	public String getName(){
		return name;
	}
	
	public String getGID(){
		return GID;
	}
	
	private boolean equals(Group other) {
		return this.GID.equals(other.GID);
	}
}
