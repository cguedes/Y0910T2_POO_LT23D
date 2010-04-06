package person.demo4;

public class Student extends Person {

	public Student(int number, String name, Gender gender) 
	{
		super(number, name, gender);
	}
	
	// @Override é uma marca (anotação JAVA) que indica que 
	//           este método é a definição de um método existente
	//           na classe base (e.g. métodos abstractos)
	@Override
	public String getEmail() {
		// retornar email no formato <NUMALUNO>@alunos.isel.pt
		return String.format("%d@alunos.isel.pt", this.getNumber());
	}
	
}
