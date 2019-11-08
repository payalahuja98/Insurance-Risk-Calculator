import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
/**
 * 
 * @author Payal, Mariana, Rudra
 * This class reads member data from a tab-delimited file.
 *
 */
public class MemberReader {
	public static ArrayList<Member> readData(String fname) {
		try{
			Scanner fsc = new Scanner(new File(fname));
			String line;
			ArrayList<Member> members = new ArrayList<Member>();
			while(fsc.hasNextLine()){
				line = fsc.nextLine();
				members.add(memberParser(line));
			}
			fsc.close();
			return members;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	public static Member memberParser(String line){
		String firstName;
		String lastName;
		int age;
		int height;
		int weight;
		int bpSyst;
		int bpDias;
		String cancer;
		String diabetes;
		String alzheimers;
		String[] properties = line.split("\t");
		firstName = properties[0];
		lastName = properties[1];
		age = Integer.parseInt(properties[2]);
		height = Integer.parseInt(properties[3]);
		weight = Integer.parseInt(properties[4]);
		bpSyst = Integer.parseInt(properties[5]);
		bpDias = Integer.parseInt(properties[6]);
		cancer = properties[7];
		diabetes = properties[8];
		alzheimers = properties[9];
		
		return new Member(lastName, firstName, age, height, weight,
			bpSyst, bpDias, cancer, diabetes, alzheimers);
	}
}
