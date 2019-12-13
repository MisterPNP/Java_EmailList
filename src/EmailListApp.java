
public class EmailListApp {
	public static void main(String[] args)  throws Exception {
		
		EmailList pnp = new EmailList("pnp email list");
		
		Recipient r1 = new Recipient("Pierre-Nicolas", "Perrin", 10);
		r1.addAddress("");
		r1.addAddress("");
		
		Recipient r2 = new Recipient("Nathaniel", "Perrin", 10);
		r2.addAddress("");
		r2.addAddress("");
		
		Recipient r3 = new Recipient("Jean-Georges", "Perrin", 10);
		r3.addAddress("");
		r3.addAddress("");
		
		pnp.subscribeToList(r1);
		pnp.subscribeToList(r2);
		pnp.subscribeToList(r3);
		
		r1.subscribeList(pnp);
		r2.subscribeList(pnp);
		r3.subscribeList(pnp);
		
		pnp.notifyRecipients();
	}
}

