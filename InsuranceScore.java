/**
 * 
 * @author Payal, Mariana, Rudra
 * This class defines the properties needed
 * to calculate a member's risk.
 *
 */
public class InsuranceScore {
	private String firstName;
	private String lastName;
    private int score;
    private String riskLevel;
    
    public InsuranceScore() {
		this.firstName = "";
		this.lastName = "";
		this.score = 0;
		this.riskLevel = "";
	}
    
    public InsuranceScore(String fName, String lName, int s, String risk) {
		this.firstName = fName;
		this.lastName = lName;
		this.score = s;
		this.riskLevel = risk;
	}
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
}

