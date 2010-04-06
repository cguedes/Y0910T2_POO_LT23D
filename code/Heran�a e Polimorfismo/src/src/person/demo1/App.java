package person.demo1;

/**
 * Esta demo1 mostra uma utilização simples da definição de tipos 
 * Nesta demo está definido o tipo base pessoa [Person]
 * e o tipo derivado [Student] que representa um aluno. 
 * 
 */
public class App {
	
	public static void main(String[] args) {

		Student bart = new Student(123, "Bart Simpson", Gender.Male, "bart@gmail.com");
		
		// Escrita do aluno (string) no standard-output
		System.out.println(bart.toString());
		System.out.println(bart.getEmail());
		
		// Como os alunos também são pessoas, é possível guardar uma referência
		// para o objecto referido pela variável bart (do tipo concreto Student)
		// numa variável do tipo Person.
		Person person = bart;
		
		// Através da variável person APENAS é possível utilizar 
		// "funcionalidades" (métodos) de Person.
		//   -> Pode-se pensar que se está a usar o Student através de um filtro
		//      que "apenas deixar passar" chamadas a métodos definidos em Person
		System.out.println("Número: " + person.getNumber());
		
		// Devido à explicação anterior, é ERRADO aceder ao método getEmail a partir
		// de variáveis do tipo Person, mesmo que o tipo concreto do objecto referido
		// seja do tipo Student (para o qual está definido o método getEmail)
		System.out.println("Email: " + bart.getEmail());     // OK.   bart é uma variável do tipo Student
		//System.out.println("Email: " + person.getEmail()); // ERRO. person é uma variável do tipo Person
		
		// NOTA: Para ajudar a perceber a explicação anterior, imaginem que tinham outro
		//       tipo a derivar de Person (ex: Teacher). Tendo uma referência para Person,
		//       como é que o compilador sabe se o tipo concreto é um Student ou Teacher?
		// 
		// Na demo2 aborda-se novamente este aspecto.
		
		// É possível guardar directamente uma referência para um objecto do tipo Student
		// numa variável de um tipo mais abrangente (no caso, Person).
		Person lisa = new Student(234, "Lisa Simpson", Gender.Female, "lisa@gmail.com");
		System.out.println(lisa);
		
		// Nesta demo é ainda possível criar directamente objectos do tipo Person, 
		// apesar de não fazer sentido! Na próxima demo mostra-se como evitar este 
		// comportamento.
		Person dummyPerson = new Person(1, "Dummy Foo Bar", Gender.Male);
		System.out.println(dummyPerson);
		
	}

}
