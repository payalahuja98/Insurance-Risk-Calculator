package insurance_risk;

import java.util.ArrayList;

public class Assessor{
	
	public void getScore(ArrayList<Member> members) {
		ArrayList<InsuranceScore> insuranceScores = new ArrayList<InsuranceScore>();
		for(int i=0; i< members.size(); i++) {
			InsuranceScore is = new InsuranceScore();
			int score = 0;
			if (members.get(i).getAge() < 30) {
				score += 0;
			} else if (members.get(i).getAge() < 45) {
				score += 10;
			} else if (members.get(i).getAge() < 60) {
				score += 20;
			} else {
				score += 30;
			}
			
			double bmi = (members.get(i).getWeight() / members.get(i).getHeight()) ^ 2 * 703;
			
			if ( bmi > 18.5 && bmi < 24.9 ) {
				score += 0;
			} else if (bmi > 25.0 && bmi < 29.9) {
				score += 30; 
			} else {
				score += 75;
			}
			
			if (members.get(i).getbPSyst() < 120 && members.get(i).getbPDias() < 80) {
				score += 0;
			} else if (members.get(i).getbPSyst() == 120 || members.get(i).getbPSyst() <= 129 && members.get(i).getbPDias() < 80) {
				score += 15;
			} else if (members.get(i).getbPSyst() == 130 || members.get(i).getbPSyst() <= 139 || members.get(i).getbPDias() == 80 || members.get(i).getbPDias() <= 89) {
				score += 30;
			} else if (members.get(i).getbPSyst() >= 140 || members.get(i).getbPDias() >= 90) {
				score += 75;
			} else if (members.get(i).getbPSyst() > 180 || members.get(i).getbPDias() > 120) {
				score += 100;
			}
			/*if (members.charAt(i).getHasDiabetes.equals("y")) {
				score += 10;
			} else if (members.charAt(i).getHasCancer.equal("y")) {
				score += 10;
			} else if (members.charAt(i).getHasAlzheimers.equal("y")) {
				score += 10;
			}*/
			
			is.setScore(score);
			if (is.getScore() <= 20) {
				is.setRiskLevel("low risk");
			} else if (is.getScore() <= 50) {
				is.setRiskLevel("moderate risk");
			} else if (is.getScore() <= 75) {
				is.setRiskLevel("low risk");
			} else {
				is.setRiskLevel("uninsurable");
			}
			
		}
		
	}
	
}
