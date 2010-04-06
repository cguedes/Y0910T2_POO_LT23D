package aula.person.demo1WithAgregation;

public class Student {

	private Person person;
	private String email;
	
	public Student(int number, String name, Gender gender, String email) 
	{
		this.person = new Person(number, name, gender);
		this.email = email;
	}
	
	// Método adicional de alunos (obter um email)
	public String getEmail() {
		return this.email;
	}
	
	public Person getPerson() { return person; }

	/*
	public String toString() {
		return String.format("%s - %s", person.toString(), getEmail());
	}
	*/
	
}
