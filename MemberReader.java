import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.beans.XMLDecoder;
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
	
	
	/**
	 * 
	 * @param fname text file to read from
	 * @param lineparts splits up the tab-delimited file 
	 * @return return data;
	 */
	public static ArrayList<Member> readMembersFromTextFile(String fname){ 
        ArrayList<Member> data = new ArrayList<Member>();
        try {
            Scanner fsc = new Scanner(new File(fname));
            String line;
            String[] lineparts;
            Member memb;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                lineparts = line.split("\t");
                memb = new Member(lineparts[0], lineparts[1], Integer.parseInt(lineparts[2]), 
                		Integer.parseInt(lineparts[3]), Integer.parseInt(lineparts[4]), 
                		Integer.parseInt(lineparts[5]), Integer.parseInt(lineparts[6]), 
                		lineparts[7], lineparts[8], lineparts[9]);
                data.add(memb);
            }
            fsc.close();
            return data;
        } catch (Exception ex) {
            return null;
        }
    }
	
	/**
	 * 
	 * @param fname binary file to read from
	 * @param Member list of data will be read
	 * @return return data;
	 */
    public static ArrayList<Member> readMembersFromBinary(String fname) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
            ArrayList<Member> data = (ArrayList<Member>)ois.readObject();
            ois.close();
            return data;
        } catch (Exception ex) {
            return null;
        }
    }
    
    /**
	 * 
	 * @param fname XML file to read from
	 * @param Member list of data will be read
	 * @return return data;
	 */
    public static ArrayList<Member> readMembersFromXML(String fname) {
        try {
            XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new
                    FileInputStream(fname)));
            ArrayList<Member> data = (ArrayList<Member>)dec.readObject();
            dec.close();
            return data;
        } catch (Exception ex) {
            return null;
        }
    }
}
