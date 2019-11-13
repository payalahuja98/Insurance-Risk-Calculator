import org.json.simple.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 * @author Payal, Mariana, Rudra
 * This class is responsible for writing the insurance score
 * information to the screen and to a JSON file.
 *
 */
public class InsuranceScoreWriter {
	public void writeToScreen(String fileName, ArrayList<Member> members) {
		
	}
	
	@SuppressWarnings("unchecked") //what is this for?
	
	/**
	 * 
	 * @param fileName JSON file to write to
	 * @param members list of members
	 * @return true if written successfully, false otherwise
	 */
	public boolean writeToJSON(String fileName, ArrayList<Member> members) {
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(
					new FileWriter(fileName)));
			
			JSONObject memberObj;
			JSONArray array = new JSONArray();
			
			for(Member m: members) {
				memberObj = new JSONObject();
				memberObj.put("name", m.getFirstName() + m.getLastName());
				memberObj.put("age", m.getAge());
				memberObj.put("height", m.getHeight());
				memberObj.put("weight", m.getWeight());
				memberObj.put("blood pressure", m.getBPSyst() + "/" + m.getBPDias());
				memberObj.put("cancer", m.getHasCancer());
				memberObj.put("diabetes", m.getHasDiabetes());
				memberObj.put("alzheimers", m.getHasAlzheimers());
				
				array.add(memberObj);
			}
			
			JSONObject outer = new JSONObject();
			outer.put("members", array);
			writer.println(outer.toString());
			writer.close();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
