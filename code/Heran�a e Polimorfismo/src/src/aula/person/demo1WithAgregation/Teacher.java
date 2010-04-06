package aula.person.demo1WithAgregation;

public class Teacher {

	private Person person;
	private int nif;
	
	public Teacher(int number, String name, Gender gender, int nif) 
	{
		this.person = new Person(number, name, gender);
		this.nif = nif;
	}
	
	// Método adicional de professores (obter o nif)
	public int getNif() {
		return this.nif;
	}
	
	public Person getPerson() { return person; }
	
}
