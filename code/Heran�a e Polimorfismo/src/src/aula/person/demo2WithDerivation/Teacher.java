package aula.person.demo2WithDerivation;

public class Teacher extends Person {

	//private Person person;
	private int nif;
	
	public Teacher(int number, String name, Gender gender, int nif) 
	{
		//this.person = new Person(number, name, gender);
		super(number, name, gender);	// chamada ao construtor da classe base
		this.nif = nif;
	}
	
	// Método adicional de professores (obter o nif)
	public int getNif() {
		return this.nif;
	}
	
	/*
	 * Adicionar e remover comentário para ver o efeito da chamada
	 * polimórfica a bart em App.main()  
	 */ 
	public String toString() {
		// super.toString() serve para chamar EXPLICITAMENTE 
		//  o método toString da classe base (Person)
		return String.format("%s - %s", super.toString(), getNif());
	}
	/* */
}
