import java.util.ArrayList;
import java.util.List;

public class EmailMessage {

	private String subject;
	private List<String> lines = new ArrayList<String>();
	private String ageRange;
	
	public EmailMessage(String subject, ArrayList<String> lines, String ageRange) {
		this.subject = subject;
		this.lines = lines;
		this.ageRange = ageRange;
	}
	
	// setting content
	public void addLine(String addLine) {
		lines.add("\n"+addLine);
	}
	
	// getters
	public String getLineAtIndex(int index) {
		return lines.get(index);
	}
	
	public List<String> getFullLines() {
		return lines;
	}
	
	public String getAgeRange() {
		return ageRange;
	}
}

