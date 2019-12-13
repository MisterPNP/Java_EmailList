import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailSender {
	
	public static void sendMail(String recipient, String first_name, String last_name) throws Exception {
		
		System.out.println("Preparing to send email to " + first_name + " " + last_name + " (" + recipient + ")");
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "ssl0.ovh.net");
		properties.put("mail.smtp.port", "587");
		
		String myAccountEmail = ""; //look in notes for account email
		String password = ""; //look in notes for account password
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		
		Message message = prepareMessage(session, myAccountEmail, recipient);
		
		Transport.send(message);
		System.out.println("Message sent succesfully to " + first_name + " " + last_name + " (" + recipient + ")");
	}

	private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			//observers for email list
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("Trying out my new Email List Java code (I'm a Nigerian Prince)");
			message.setText("Hey there,\n\nThis is my first try to make an Email List using Observer/Observable design pattern. "
					+ "As I mentionned earlier, I'm a Nigerian prince so you ain't getting cash."
					+ "\n\nThank you for going to my TED Talk. \nSincerely, \n\nPierre-Nicolas Perrin");
			return message;
		} catch (Exception e) {
			Logger.getLogger(JavaMailSender.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
