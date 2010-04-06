package person.demo4;

/**
 * A demo4 introduz o modificador de acesso protected.
 * 
 * ver: http://java.sun.com/docs/books/tutorial/java/javaOO/accesscontrol.html
 * 
 * ------------------
 * MOTIVAÇÃO
 * ------------------
 * Até agora, os métodos setNumber, setName e setGender têm acesso publico (modificador public).
 * 
 * Q: Será que faz sentido existirem?
 * R: Sim, permite evitar o acesso às respectivas variáveis de instância, 
 *         tornando possível executar código de verificação na escrita dos valores
 *         
 * Q: Faz sentido que todos tenham acesso a estes métodos?
 * R: Não, no caso particular, as pessoas não mudam de número ou nome depois de criadas
 * 
 * Q: Devo colocar acesso privado (private)?
 * R: Sim, tipicamente faz-se isso, mas dessa forma APENAS o código dessa classe 
 *         tem acesso ao método, ou seja, as classes derivadas "perdem" acesso.
 * 
 * Q: Como "contornar" este "problema"?
 * R: Definido o acesso como PROTEGIDO (protected), de forma a que, além da própria classe,
 *    as classes derivadas também tenham acesso, assim como no mesmo package,
 *    continuando a não ser possível aceder ao método do exterior da hierarquia 
 *    (tipo, derivados e mesmo package).
 *    
 * Q: Então devo passar a usar protected em vez private?
 * R: Claro que não! Apenas quando fizer sentido, ou seja, quando não fizer sentido ser
 *    público e quando se pretender dar acesso às classes derivadas. Tipicamente é usado
 *    em métodos utilitários definidos na classe base que serão usados nas derivadas.
 *    
 * Q: É tudo?
 * R: Sim :-)
 * 
 */
public class App {
	
	public static void main(String[] args) {

		Person pBart = new Student(123, "Bart Simpson", Gender.Male);
		Person pHomer = new Teacher(123, "Hommer Simpson", Gender.Male, 123456789);
		
		// Escrita do email do aluno e professor no standard-output
		System.out.println(pBart.getEmail());	
		System.out.println(pHomer.getEmail());
		
		// Reparem que, nesta versão (demo) É POSSÍVEL usar os métodos de setXXX
		// porque este código **está definido no mesmo package que Person**
		pBart.setNumber(999);
		System.out.println(pBart.getEmail());
		
	}

}
