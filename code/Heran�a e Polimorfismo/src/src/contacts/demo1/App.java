package contacts.demo1;

public class App {

	public static void main(String[] args) {
		
		// Envio de mensagem para um email
		Email e1 = new Email("e1@gmail.com");
		e1.sendMessage("ex1@gmail.com", "Exemplo 1", "Exemplo de utilização de polimorfismo em Java");
		
		// Envio de mensagem para grupo de 3 contactos de email
		Email e2 = new Email("e2@gmail.com");
		Email e3 = new Email("e3@gmail.com");
		Group group1 = new Group(3);
		group1.addContact(e1);
		group1.addContact(e2);
		group1.addContact(e3);
		group1.sendMessage("ex2@gmail.com", "Exemplo 2", "Exemplo de utilização de polimorfismo em Java");
		
		// Envio de mensagem para grupo que contém um grupo (exemplo anterior) e outro email
		Group group2 = new Group(2);
		group2.addContact(group1);
		group2.addContact(new Email("e4@gmail.com"));
		group2.sendMessage("ex3@gmail.com", "Exemplo 3", "Exemplo de utilização de polimorfismo em Java");
		
	}

}
