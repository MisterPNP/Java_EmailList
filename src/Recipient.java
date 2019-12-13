import java.util.ArrayList;
import java.util.List;

public class Recipient {
	
	private ArrayList<String> emailAddresses = new ArrayList<>();
	private EmailList emailList;
	private String first_name;
	private String last_name;
	private int age;
	private String messageType;
	private EmailMessage message;
	
	public Recipient(String first_name, String last_name, int age) {
		
		if(first_name == null)
			throw new IllegalArgumentException("Set first name");
		if(last_name == null) 
			throw new IllegalArgumentException("Set last name");
		if(age < 0)
			throw new IllegalArgumentException("Set valid age");
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		setMessageType();
	}
	
	// address and subscription handling
	public void addAddress(String email) {
		emailAddresses.add(email);
	}
	
	public void subscribeList(EmailList emailList) {
		this.emailList = emailList;
	}
	
	public void update() throws Exception {
		for(String email : emailAddresses) {
			JavaMailSender.sendMail(email, getFirstName(), getLastName());
		}
	}
	
	// message handling
	public void setMessage(EmailMessage message) {
		this.message = message;
	}
	
	public void setMessageType() {
		if(age < 18) {
			messageType = "child";
		} else if(age < 25) {
			messageType = "millenial";
		} else if(age < 40) {
			messageType = "young adult";
		} else if(age < 60) {
			messageType = "boomer";
		} else {
			messageType = "senior";
		}
	}
	
	// getters
	public String getFirstName() {
		return this.first_name;
	}
	
	public String getLastName() {
		return this.last_name;
	}
	
	public ArrayList<String> getEmailAddresses() {
		return emailAddresses;
	}
	
	public String getEmailAtIndex(int index) {
		return emailAddresses.get(index);
	}
	
	public EmailList getEmailList() {
		return emailList;
	}
	public int getAge() {
		return age;
	}
	
	public String getMessageType() {
		return messageType;
	}
	
	public EmailMessage getMessage() {
		return message;
	}
}
