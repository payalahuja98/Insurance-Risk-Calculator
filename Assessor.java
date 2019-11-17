import java.util.ArrayList;

/**
 * 
 * @author Payal, Mariana, Rudra
 * This class takes care of calculating members'
 * scores and risk levels.
 *
 */
public class Assessor{
	
	//list of members and their scores and risk levels
	private ArrayList<InsuranceScore> insScores = new ArrayList<InsuranceScore>();
	
	/**
	 * 
	 * @param members list of members to use for calculation
	 */
	public void getScore(ArrayList<Member> members) {
		//For loop iterates through the Array List members to set the score for each member in the Array List
		for(int i=0; i< members.size(); i++) {
			InsuranceScore is = new InsuranceScore();
			is.setFirstName(members.get(i).getFirstName());
			is.setLastName(members.get(i).getLastName());
			
			int score = 0;
			//Logic for score based on Age
			if (members.get(i).getAge() < 30) {
				score += 0;
			} else if (members.get(i).getAge() < 45) {
				score += 10;
			} else if (members.get(i).getAge() < 60) {
				score += 20;
			} else {
				score += 30;
			}
			
			System.out.println("after age: " + score);
			//Calculates BMI for each member
			double bmi = (703 * members.get(i).getWeight()) / (Math.pow(members.get(i).getHeight(),2));
			//Logic for score based on  BMI
			if (bmi >= 18.5 && bmi <= 24.9) {
				score += 0;
			} else if (bmi >= 25.0 && bmi <= 29.9) {
				score += 30; 
			} else {
				score += 75;
			}
			System.out.println("after bmi: " + score);
			//Logic for score based on BP Syst and BP Dias
			if (members.get(i).getBPSyst() < 120 && members.get(i).getBPDias() < 80) {
				score += 0;
			} else if ((members.get(i).getBPSyst() >= 120 && members.get(i).getBPSyst() <= 129) 
					&& members.get(i).getBPDias() < 80) {
				score += 15;
			} else if ((members.get(i).getBPSyst() >= 130 && members.get(i).getBPSyst() <= 139) 
					|| (members.get(i).getBPDias() >= 80 && members.get(i).getBPDias() <= 89)) {
				score += 30;
			} else if ((members.get(i).getBPSyst() >= 140 && members.get(i).getBPSyst() <= 180) 
					|| ((members.get(i).getBPDias() >= 90) && members.get(i).getBPDias() >= 90)) {
				score += 75;
			} else if (members.get(i).getBPSyst() > 180 || members.get(i).getBPDias() > 120) {
				score += 100;
			}
			System.out.println("after bp: " + score);
			//Logic for score based on family history of Diabetes, Cancer, and Alzheimer's
			if (members.get(i).getHasDiabetes().indexOf("y") == 0) {
				score += 10;
			}  
			
			System.out.println("after diabetes: " + score);
			
			if (members.get(i).getHasCancer().indexOf("y") == 0) {
				score += 10;
			}
			
			System.out.println("after cancer: " + score);
			
			if (members.get(i).getHasAlzheimers().indexOf("y") == 0) {
				score += 10;
			}
			
			System.out.println("after alz: " + score);
			System.out.println();
			//sets total score
			is.setScore(score);
			//Determines if risk level for each member based off score
			if (is.getScore() <= 20) {
				is.setRiskLevel("low risk");
			} else if (is.getScore() <= 50) {
				is.setRiskLevel("moderate risk");
			} else if (is.getScore() <= 75) {
				is.setRiskLevel("high risk");
			} else {
				is.setRiskLevel("uninsurable");
			}
			
			insScores.add(is);
		}
	}
	
	public ArrayList<InsuranceScore> getListScores(){
		return insScores;
	}
	
}
