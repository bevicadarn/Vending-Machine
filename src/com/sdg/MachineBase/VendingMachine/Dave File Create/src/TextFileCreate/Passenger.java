package TextFileCreate;

public class Passenger extends Person {
	private RewardProgram rewardProgram = new RewardProgram();
	public RewardProgram getRewardProgram() {
		return rewardProgram;
	}
	
	public Passenger() {
		super();
	}
	
	public Passenger(String aName) {
		super(aName);
	}

	
	
	public static class RewardProgram {
		private int memberLevel;
		private int memberDays;
		
		
		
		public int getLevel() {return memberLevel;};
		public int getMemberDays() {return memberDays;};
		
		public void setLevel(int level) {memberLevel = level;};
		public void setMemberDays(int days) {memberDays = days;};
		
	}

}
