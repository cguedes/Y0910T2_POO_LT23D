package aula.person.demo1WithAgregation;

/**
 * Esta demo usa AGREGAÇÃO para relacionar Pessoa e Aluno/Professor.
 * 
 */
public class App {
	
	public static void main(String[] args) {
		
		Student bart = new Student(123, "Bart Simpson", Gender.Male, "bart@acme.org");
		// Mostrar o email do bart (usar método de Student)
		System.out.println(bart.getEmail());
		
		Object bart2 = new Student(123, "Bart Simpson", Gender.Male, "bart@acme.org");
		System.out.println(bart2);	// uso do polimorfismo

		Teacher lisa = new Teacher(321, "Lisa Simpson", Gender.Female, 987654321);
		// Mostrar o nif da lisa (usar método de Teacher)
		System.out.println(lisa.getNif());
		
		
		// Como estamos a usar agregação, um Student (ou Teacher) NÃO É uma Person
		// A próxima linha dá erro de compilação!
		//Person p = new Student(1, "name", Gender.Male, "1@2.3");
		
	}

}
