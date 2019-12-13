import java.util.ArrayList;
import java.util.HashMap;

public class MessageSpec {
	
	private EmailList emailList;
	private ArrayList<Recipient> recipientList;
	private ArrayList<EmailMessage> messageList;
	private HashMap<String, EmailMessage> messageHashLinks = new HashMap<String, EmailMessage>();
	
	
	public MessageSpec(EmailList emailList, ArrayList<Recipient> recipientList, ArrayList<EmailMessage> messageList) {
		this.emailList = emailList;
		this.recipientList = recipientList;
		this.messageList = messageList;
		
		messageLinksSetup();
	}
	
	// hashmap
	public void messageLinksSetup() {
		for(EmailMessage message : messageList) {
			messageHashLinks.put(message.getAgeRange(), message);
		}
	}
	
	// recipient message handling
	public void setMessageForRecipients(String ageRange) {
		for(Recipient recipient : recipientList) {
			recipient.setMessage(messageHashLinks.get(recipient.getMessageType()));
		}
	}
	
	// getters
	public ArrayList<Recipient> getRecipients() {
		return recipientList;
	}
	
	public EmailList getEmailList() {
		return emailList;
	}
	
	public ArrayList<EmailMessage> getMessageList() {
		return messageList;
	}
}

