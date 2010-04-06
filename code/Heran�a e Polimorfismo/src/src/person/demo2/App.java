package person.demo2;

/**
 * Esta demo2 mostra uma utilização de HERANÇA, com vários tipos derivados.
 * No caso, temos o tipo base Person e os tipos derivados Student e Teacher. 
 * 
 * É também apresentado o operador instanceof
 * 
 */
public class App {
	
	public static void main(String[] args) {

		Person pBart = new Student(123, "Bart Simpson", Gender.Male, "bart@gmail.com");
		Person pHomer = new Teacher(123, "Hommer Simpson", Gender.Male, 123456789);
		
		// Escrita do aluno e professor (string) no standard-output
		System.out.println(pBart.toString());
		System.out.println(pHomer.toString());
		
		// Mais uma vez, como bart e homer são variáveis do tipo Person, e apesar
		// de referirem objectos do tipo Student e Teacher, respectivamente, não
		// é possível usar os seus métodos específicos (getEmail e getNif) através
		// destas variáveis (remover comentário do seguinte código e ver o erro!).

		//System.out.println("Email: " + pBart.getEmail()); // ERRO. pBart é uma variável do tipo Person e o método getEmail apenas está disponível em Student!
		//System.out.println("Nif: "   + pHomer.getNif());  // ERRO. pHomer é uma variável do tipo Person e o método getNif apenas está disponível em Teacher!
		
		// Quando temos a certeza do tipo concreto associado a variáveis de tipos base (no caso Person),
		// é possível fazer uma conversão EXPLICITA da referência para outro tipo
		Student sBart = (Student)pBart;
		Teacher tHomer = (Teacher)pHomer;
		System.out.println("Email: " + sBart.getEmail()); // OK :-)
		System.out.println("Nif: "   + tHomer.getNif());  // OK :-)
		
		// É gerado um erro de execução (excepção ClassCastException) numa 
		// conversão inválida (remover comentário seguinte)
		//Student sBartBum = (Student)pHomer;
		
		// É possível usar o operador instanceof (var instanceof TYPE) 
		// para determinar se determinada variável (var) é  
		// compatível ("afectável") com determinado tipo (TYPE).
		boolean pBartIsPerson  = pBart instanceof Person;
		boolean pBartIsStudent = pBart instanceof Student;
		boolean pBartIsTeacher = pBart instanceof Teacher;
		System.out.println("pBartIsPerson = "  + pBartIsPerson);	// true
		System.out.println("pBartIsStudent = " + pBartIsStudent);	// true
		System.out.println("pBartIsTeacher = " + pBartIsTeacher);	// false (naturalmente)
		
		// Como colocámos a classe Person como ABSTRACTA (abstract), 
		// deixou de ser possível criar instâncias dela.
		//   -> É um conceito abstracto, logo não se pode contretizar (criar instância).
		//   -> Até faz sentido :-)
		//Person dummyPerson = new Person(1, "Dummy Foo Bar", Gender.Male);
		//System.out.println(dummyPerson);
	}

}
