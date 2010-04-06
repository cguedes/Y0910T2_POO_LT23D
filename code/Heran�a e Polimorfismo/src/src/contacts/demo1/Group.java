package contacts.demo1;

public class Group extends Contact {

	private final Contact[] contacts;
	private int numContacts;
	
	public Group(int maxContacts) {
		contacts = new Contact[maxContacts];
		numContacts = 0;
	}
	
	public boolean addContact(Contact contact) {
		if(numContacts == contacts.length) return false;
		
		contacts[numContacts++] = contact;
		return true;
	}
	
	@Override
	public void sendMessage(String from, String subject, String body) {
		System.out.println("================== INICIO ==================");
		for (int i = 0; i < contacts.length; i++) {
			Contact contact = contacts[i];
			contact.sendMessage(from, subject, body);
		}
		System.out.println("=================== FIM ====================");
	}
	
}
