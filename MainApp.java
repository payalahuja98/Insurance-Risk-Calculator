import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Payal, Mariana, Rudra
 * This is the main class, responsible for getting user input 
 * and facilitating the actions based on that.
 *
 */
public class MainApp {
	//list of members
	private ArrayList<Member> members = new ArrayList<Member>();
	//list of members' scores and risk levels
	private ArrayList<InsuranceScore> membersScores = new ArrayList<InsuranceScore>();
	
	public static void main(String[] args) {
		printWelcome();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name of member file: ");
		String fileName = sc.nextLine();
		
		ArrayList<Member> members = MemberReader.readData(fileName);
		
		ArrayList<Member> readTxtFile;
		ArrayList<Member> readBinFile;
		ArrayList<Member> readXmlFile;
		boolean success;
		
		int choice;
		
		do {
			showMenu();
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				//List members from the file
				System.out.println("Here are the members:\n");
				for(Member memb: members)
				{
					System.out.println(memb.toString());
				}
				break;
				
			case 2:
				//Add a new member
				addNewMember(members);
				break;
				
			case 3:
				//Save members
				sc.nextLine();
				MemberWriter m = new MemberWriter();
				
				System.out.println("(T)ext, (B)inary, (X)ML?");
				String type = sc.nextLine();
				
				System.out.println("Enter name of output file:");
				String outputFileName = sc.nextLine();
				
				success = false;
				
				//call appropriate method in MemberWriter class
				//returns true if written successfully
				if(type.equals("T")) {
					success = m.writeToText(outputFileName, members);
				}
				
				if(type.equals("B")) {
					success = m.writeToBinary(outputFileName, members);
				}
				
				if(type.equals("X")) {
					success = m.writeToXML(outputFileName, members);
				}
				
				if(success) {
					System.out.println("Members were written successfully");
				} else {
					System.out.println("Something went wrong...");
				}
				
				break;
				
			case 4:
				//Load members
				System.out.print("(T)ext, (B)inary, or (X)ML? ");
				String fileType = sc.next();
				
				//call appropriate method in MemberReader class
				if(fileType.equals("T")) {
					System.out.print("Enter name of input file: ");
					fileName = sc.next();
					
					readTxtFile = MemberReader.readMembersFromTextFile(fileName);
					
					if(readTxtFile == null) {
						System.out.println("Boo. Hiss. Drats.");
					} else {
						System.out.println(readTxtFile.size() + " members were read.");
					}
				} else if(fileType.equals("B")) {
					System.out.print("Enter name of input file: ");
					fileName = sc.next();
					
					readBinFile = MemberReader.readMembersFromBinary(fileName);
					
					if(readBinFile == null) {
						System.out.println("Boo. Hiss. Drats.");
					} else {
						System.out.println(readBinFile.size() + " members were read.");
					}
				} else if(fileType.equals("X")) {
					System.out.print("Enter name of input file: ");
					fileName = sc.next();
					
					readXmlFile = MemberReader.readMembersFromXML(fileName);
					
					if(readXmlFile == null) {
						System.out.println("Boo. Hiss. Drats.");
					} else {
						System.out.println(readXmlFile.size() + " members were read.");
					}
				}
				
				break;
				
			case 5:
				//Assess members
				sc.nextLine();
				InsuranceScoreWriter iWriter = new InsuranceScoreWriter();
				Assessor scoreList = new Assessor();
				//call method in Assessor class to calculate risk levels
				scoreList.getScore(members); 
				
				//call method in InsuranceScoreWriter for printing
				iWriter.writeToScreen(fileName, scoreList.getListScores());
				
				break;
				
			case 6:
				//Save assessments as JSON
				sc.nextLine();
				InsuranceScoreWriter i = new InsuranceScoreWriter();
				
				System.out.println("Enter name of JSON file:");
				String fName = sc.nextLine();
				
				//call method in InsuranceScoreWriter class
				//returns true if written successfully
				success = i.writeToJSON(fName, members);
				
				if(success) {
					System.out.println("The scores were written successfully.");
				} else {
					System.out.println("Something went wrong...");
				}	
				
				break;
			}
		} while(choice != 7); //keep prompting user until they choose to exit
		
		printGoodbye();
	}
	
	/**
	 * 
	 * @param starCount number of stars to display before
	 * and after the description
	 */
	private static void printStars(int starCount) {	
		String starField ="";
		for (int i = 0; i < starCount; i++) {
			starField = starField + "*";
		}
		System.out.println(starField);
	}
	
	private static void printWelcome() {
		printStars(40);
		System.out.println("\tINSURANCE SCORE CARD");
		System.out.println("  This app scores a potential customer");
		System.out.println("  on various health attributes: blood");
		System.out.println("  pressure, age, height, weight, and");
		System.out.println("  family history of disease. It writes");
		System.out.println("  each member's insurance grade to a");
		System.out.println("  JSON file so that they can be easily");
		System.out.println("  shared on a web-based data exchange.");
		printStars(40);
	}
	
	private static void printGoodbye() {
		printStars(40);
		System.out.println("         INSURANCE SCORE CARD");
		System.out.println("               THANK YOU");
		printStars(40);
	}
	
	public static void showMenu() {
		System.out.println("\nHere are your choices:");
		System.out.println("\t1. List members");
		System.out.println("\t2. Add a new member");
		System.out.println("\t3. Save members");
		System.out.println("\t4. Load members");
		System.out.println("\t5. Assess members");
		System.out.println("\t6. Save assessments as JSON");
		System.out.println("\t7. Exit");
		System.out.print("Please enter your choice: ");
	}
	
	/**
	 * 
	 * @param members list of members to add to
	 */
	public static void addNewMember(ArrayList<Member> members) {
		Scanner sc = new Scanner(System.in);
		Member newMember = new Member();
		
		System.out.println("Enter first and last name: ");
		String fullName = sc.nextLine();
		
		String[] fullNameArr  = fullName.split(" ");
		newMember.setFirstName(fullNameArr[0]);
		newMember.setLastName(fullNameArr[1]);
		
		System.out.println("Enter age");
		newMember.setAge(sc.nextInt());
		
		System.out.println("Enter height in inches: ");
		newMember.setHeight(sc.nextInt());
		
		System.out.println("Enter weight in pounds: ");
		newMember.setWeight(sc.nextInt());
		
		System.out.println("Enter blood pressure (sys and dia): ");
		newMember.setBPSyst(sc.nextInt()); 
		newMember.setBPDias(sc.nextInt());
		
		sc.nextLine();
		System.out.println("Has a family member had ...");
		System.out.println("Cancer?");
		newMember.setHasCancer(sc.nextLine());
		
		System.out.println("Diabetes?");
		newMember.setHasDiabetes(sc.nextLine());
		
		System.out.println("Alzheimers?");
		newMember.setHasAlzheimers(sc.nextLine());
		
		members.add(newMember);
		System.out.println("The new member has been added.");		
	}
}