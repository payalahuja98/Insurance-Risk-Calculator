package insurance_risk;

public class InsuranceScore {
	private String firstName;
	private String lastName;
    private int score;
    private String riskLevel;
    
    //Getters and Setters for each variable
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	
	public String toString(){
		String firstLast = firstName +", "+lastName;
		return String.format("Name:       %20s\n"
				+ "Score:       %20d\n"
				+ "Verdict:       %20s\n",
				
				firstLast, score, riskLevel);
	}
}

