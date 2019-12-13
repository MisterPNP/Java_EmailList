import java.util.ArrayList;
import java.util.List;

public class EmailList {

	private List<Recipient> recipients = new ArrayList<>();
	private String name;
	
	public EmailList(String name) {
		this.name = name;
	}
	
	public void subscribeToList(Recipient recipient) {
		recipients.add(recipient);
	}
	
	public void unsubscribeToList(Recipient recipient) {
		recipients.remove(recipient);
	}
	
	public void notifyRecipients() throws Exception {
		for(Recipient recipient : recipients) {
			recipient.update();
		}
	}
	
	//GETTERS
	public String getName() {
		return this.name;
	}
	
}