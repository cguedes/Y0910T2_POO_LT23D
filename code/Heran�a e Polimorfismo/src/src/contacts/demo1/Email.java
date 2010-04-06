package contacts.demo1;

public class Email extends Contact {
	
	private final String email;

	public Email(String email) {
		this.email = email;
		
	}
	
	@Override
	public void sendMessage(String from, String subject, String body) {
		System.out.println(String.format("From [%s] to [%s]", from, email));
		System.out.println("Subject: " + subject);
		System.out.println("Body: " + body);
		System.out.println();
	}
	
}
