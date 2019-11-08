import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 * @author Payal, Mariana, Rudra
 * This class is responsible for saving the members to
 * a text file, a binary file, and an XML file.
 *
 */
public class MemberWriter {
	/**
	 * 
	 * @param fileName text file to write to
	 * @param members list of members
	 * @return true if written successfully, false otherwise
	 */
	public static boolean writeToText(String fileName, ArrayList<Member> members) {
		try {
			//creates text-output stream
			PrintWriter writer = new PrintWriter(new BufferedWriter
					(new FileWriter(fileName)));
			
			for(Member m: members) {
				writer.println(m);
			}
			
			writer.close();
			return true;
		}
		catch(Exception e) {
			return false;
		}		
	}
	
	/**
	 * 
	 * @param fileName binary file to write to
	 * @param members list of members
	 * @return true if written successfully, false otherwise
	 */
	public static boolean writeToBinary(String fileName, ArrayList<Member> members) {
		try {
			//creates object output stream
			ObjectOutputStream writer = new ObjectOutputStream(
					new FileOutputStream(fileName));
			writer.writeObject(members);
			writer.close();
			return true;
		}
		catch(Exception e) {
			return false;
		}		
	}
	
	public static boolean writeToXML() {
		return false;
	}
}
