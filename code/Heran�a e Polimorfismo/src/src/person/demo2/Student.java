package person.demo2;

public class Student extends Person {

	private String email;
	
	public Student(int number, String name, Gender gender, String email) 
	{
		// Chamada ao construtor da classe base (super)
		//  - TEM que ser o primeiro método a executar num construtor
		//  - Se não existir uma chamada explicita a este método, 
		//    o compilador coloca uma chamada ao construtor por 
		//    omissão (e.g: super()). Note-se que se este construtor
		//    não estiver definido na classe base (neste caso Person),
		//    é gerado erro de compilação.
		super(number, name, gender);
		
		this.email = email;
	}
	
	// Método adicional de alunos (obter um email)
	public String getEmail() {
		return this.email;
	}
	
}
