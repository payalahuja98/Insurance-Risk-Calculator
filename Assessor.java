package insurance_risk;

import java.util.ArrayList;

public class Assessor{
	
	public static ArrayList<InsuranceScore> getScore(ArrayList<Member> members) {
		ArrayList<InsuranceScore> insuranceScores = new ArrayList<InsuranceScore>();
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
			//Calculates BMI for each member
			double bmi = (members.get(i).getWeight() / members.get(i).getHeight()) ^ 2 * 703;
			//Logic for score based on  BMI
			if ( bmi > 18.5 && bmi < 24.9 ) {
				score += 0;
			} else if (bmi > 25.0 && bmi < 29.9) {
				score += 30; 
			} else {
				score += 75;
			}
			//Logic for score based on BP Syst and BP Dias
			if (members.get(i).getBPSyst() < 120 && members.get(i).getBPDias() < 80) {
				score += 0;
			} else if (members.get(i).getBPSyst() == 120 || members.get(i).getBPSyst() <= 129 && members.get(i).getBPDias() < 80) {
				score += 15;
			} else if (members.get(i).getBPSyst() == 130 || members.get(i).getBPSyst() <= 139 || members.get(i).getBPDias() == 80 || members.get(i).getBPDias() <= 89) {
				score += 30;
			} else if (members.get(i).getBPSyst() >= 140 || members.get(i).getBPDias() >= 90) {
				score += 75;
			} else if (members.get(i).getBPSyst() > 180 || members.get(i).getBPDias() > 120) {
				score += 100;
			}
			//Logic for score based on family history of Diabetes, Cancer, and Alzheimer's
			if (members.get(i).getHasDiabetes().indexOf("y") > -1) {
				score += 10;
			} else if (members.get(i).getHasCancer().indexOf("y") > -1) {
				score += 10;
			} else if (members.get(i).getHasAlzheimers().indexOf("y") > -1) {
				score += 10;
			}
			//sets total score
			is.setScore(score);
			System.out.print(score);
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
			insuranceScores.add(is);
		}
		return insuranceScores;
	}
	
}
