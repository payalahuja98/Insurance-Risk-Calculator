package insurance_risk;


import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
	private static ArrayList<Member> members = new ArrayList<Member>();
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
	private static void printGoodBye() {
		printStars(40);
		System.out.println("         INSURANCE SCORE CARD");
		System.out.println("               THANK YOU");
		printStars(40);
	}
	//Menu 
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
		public static void addNewMember(ArrayList<Member> members) {
			String lastName = null, firstName = null, cancer = null, diabetes = null, alzheimers = null;
			int age = 0, height = 0, weight = 0, bpSyst = 0, bpDias = 0; 
			Member newMember = new Member(lastName, firstName, age, height, weight,
					bpSyst, bpDias, cancer, diabetes, alzheimers);
			Scanner sc = new Scanner(System.in);
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
			System.out.println("Has a family member had ...");
			System.out.println("Cancer?");
			newMember.setHasCancer(sc.nextLine());
			newMember.setHasCancer(sc.nextLine());
			System.out.println("Diabetes?");
			newMember.setHasDiabetes(sc.nextLine());
			System.out.println("Alzheimers?");
			newMember.setHasAlzheimers(sc.nextLine());
			members.add(newMember);
			System.out.println("The new member has been added.");
			
		}
		public static void main(String[] args) {
			printWelcome();
			Scanner sc = new Scanner(System.in);
			int choice;
			String fileType;
			System.out.print("Enter name of member file: ");
			String fileName = sc.nextLine();
			ArrayList<Member> members = MemberReader.readData(fileName);
			ArrayList<Member> readTxtFile;
			ArrayList<Member> readBinFile;
			ArrayList<Member> readXmlFile;
			do {
				showMenu();
				choice = sc.nextInt();
				if (choice == 1) {
					//List members from the file
					System.out.println("Here are the members:\n");
					for(Member memb: members)
					{
						System.out.println(memb.toString());
					}
				}
				if (choice == 2) {
					//Add a new member
					addNewMember(members);
				}
				if (choice == 3) {
					sc.nextLine();
					//Save members
					MemberWriter m = new MemberWriter();
					
					System.out.println("(T)ext, (B)inary, (X)ML?");
					String type = sc.nextLine();
					
					System.out.println("Enter name of output file:");
					String outputFileName = sc.nextLine();
					
					boolean success = false;
					
					if(type.equals("T")) {
						success = m.writeToText(outputFileName, members);
					}
					
					if(type.equals("B")) {
						success = m.writeToBinary(outputFileName, members);
					}
					
					if(type.equals("X")) {
						success = m.writeToXML(outputFileName, members);
					}
					
					System.out.println(success);
				}
				if (choice == 4) {
					//Load members
					System.out.print("(T)ext, (B)inary, or (X)ML? ");
					fileType = sc.next();
					if(fileType.equals("T")) {
						System.out.print("Enter name of input file: ");
						fileName = sc.next();
						readTxtFile = MemberReader.readMembersFromTextFile(fileName);
						if(readTxtFile == null) {
							System.out.println("Boo. Hiss. Drats.");
						}else {
							System.out.println(readTxtFile.size() + " members were read.");
						}
					}else if(fileType.equals("B")) {
						System.out.print("Enter name of input file: ");
						fileName = sc.next();
						readBinFile = MemberReader.readMembersFromBinary(fileName);
						if(readBinFile == null) {
							System.out.println("Boo. Hiss. Drats.");
						}else {
							System.out.println(readBinFile.size() + " members were read.");
						}
					}
					else if(fileType.equals("X")) {
						System.out.print("Enter name of input file: ");
						fileName = sc.next();
						readXmlFile = MemberReader.readMembersFromXML(fileName);
						if(readXmlFile == null) {
							System.out.println("Boo. Hiss. Drats.");
						}else {
							System.out.println(readXmlFile.size() + " members were read.");
						}
					}
				}
				if (choice == 5) {
					//Assess members
				}
				if (choice == 6) {
					//Save assessments as JSON
				}
			} while (choice != 7);
			printGoodBye();
		}
}
