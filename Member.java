package insurance_risk;

import java.util.ArrayList;
import java.io.Serializable;

public class Member implements Serializable {
	private String firstName;
	private String lastName;
    private int age;
    private int height;
    private int weight;
    private int bPSyst;
    private int bPDias;
    private String hasCancer;
    private String hasDiabetes;
    private String hasAlzheimers;
    
    public Member() {
    	firstName = "";
    	lastName = "";
    	age = 0;
    	height = 0;
    	weight = 0;
    	bPSyst = 0;
    	bPDias = 0;
    	hasCancer = "";
    	hasDiabetes = "";
    	hasAlzheimers = "";
    }
    
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
    public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getbPSyst() {
		return bPSyst;
	}
	public void setbPSyst(int bPSyst) {
		this.bPSyst = bPSyst;
	}
	public int getbPDias() {
		return bPDias;
	}
	public void setbPDias(int bPDias) {
		this.bPDias = bPDias;
	}
	public String getHasCancer() {
		return hasCancer;
	}
	public void setHasCancer(String hasCancer) {
		this.hasCancer = hasCancer;
	}
	public String getHasDiabetes() {
		return hasDiabetes;
	}
	public void setHasDiabetes(String hasDiabetes) {
		this.hasDiabetes = hasDiabetes;
	}
	public String getHasAlzheimers() {
		return hasAlzheimers;
	}
	public void setHasAlzheimers(String hasAlzheimers) {
		this.hasAlzheimers = hasAlzheimers;
	}
	
	Member(String lastName, String firstName, int age, int height, int weight, 
			int bpSyst, int bpDias, String cancer, String diabetes, String alzheimers) {
		setLastName(lastName);
		setFirstName(firstName);
		setAge(age);
		setHeight(height);
		setWeight(weight);
		setbPSyst(bpSyst);
		setbPDias(bpDias);
		setHasCancer(cancer);
		setHasDiabetes(diabetes);
		setHasAlzheimers(alzheimers);	
	}
	
	public String toString(){
		return String.format("%s, %s\n"
				+ "Age           %s\n"
				+ "Height        %s in\n"
				+ "Weight       %s lbs\n"
				+ "BP Syst      %s\n"
				+ "BP Dias       %s\n"
				+ "Cancer         %s\n"
				+ "Diabetes       %s\n"
				+ "Alzheimers     %s\n"
				+ "-----------------------", lastName,
				firstName, age, height, weight, bPSyst,
				bPDias, hasCancer, hasDiabetes, hasAlzheimers);
	}
}
