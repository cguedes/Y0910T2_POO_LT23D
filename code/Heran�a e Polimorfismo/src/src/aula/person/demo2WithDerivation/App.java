package aula.person.demo2WithDerivation;

/**
 * Esta demo usa DERIVAÇÃO para relacionar Pessoa e Aluno/Professor.
 * 
 */
public class App {
	
	public static void main(String[] args) {
		
		Student bart = new Student(123, "Bart Simpson", Gender.Male, "bart@acme.org");
		// Mostrar o email do bart (usar método de Student)
		System.out.println(bart.getEmail());
		
		// Como estamos a usar derivação, é possível guardar 
		// referências para alunos (Student) em variáveis do
		// tipo Person.
		Person pBart = new Student(123, "Bart Simpson", Gender.Male, "bart@acme.org");
		System.out.println(pBart);	// uso do polimorfismo (método toString de Object)

		Teacher lisa = new Teacher(321, "Lisa Simpson", Gender.Female, 987654321);
		// Mostrar o nif da lisa (usar método de Teacher)
		System.out.println(lisa.getNif());
		System.out.println(lisa);
		
	}

}
