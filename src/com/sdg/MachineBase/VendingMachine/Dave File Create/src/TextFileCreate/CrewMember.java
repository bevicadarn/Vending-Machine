package TextFileCreate;


public class CrewMember extends Person {
	
	private flightCrewJob job;
	
	public CrewMember() {
		super();
	}
	
	public CrewMember(String aName) {
		super(aName);
	}
	
	public CrewMember(String aName, flightCrewJob job) {
		super(aName);
		this.job = job;
	}
	
	public CrewMember(flightCrewJob job) {
		super();
		this.job =job;
	}
	
	
	public void setJob(flightCrewJob job) {
		this.job = job;
	}
	
	
	
	public enum flightCrewJob {
		Pilot, 
		Copilot,
		FlightAttendant,
		AirMarshal
	}

}
