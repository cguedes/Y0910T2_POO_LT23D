package person.demo3;

/**
 * A demo3 apresenta o conceito de POLIMORFISMO.
 * 
 *  ver: http://www.priberam.pt/dlpo/default.aspx?pal=polimorfismo
 *  
 *    "POLIMORFISMO -> O mesmo que polimorfia. -> Particularidade de certas substâncias que tomam formas muito diversas."
 * 
 * A ideia principal do polimorfismo é ser possível executar código diferente
 *  de acordo com o tipo concreto associado a determinada variável. 
 *
 * Por exemplo:
 * ------------------
 * Ter uma variável do tipo Person (que será do tipo concreto Student ou  
 *   Teacher - mas "só sabemos que é uma Pessoa"), e ao executar determinado 
 *   método, o código executado ser dependente do tipo concreto, ou seja,
 *   ser executado o código definido em Student ou Teacher de acordo com 
 *   o tipo contreto da variável.
 *   
 *   
 *   
 * ------------------
 * NOTA
 * ------------------
 * Nesta demo, vamos mudar um pouco a lógica dos tipos existentes.
 *   1) Até agora, só o Student tinha um email, e podia ser definido no construtor. 
 *   2) Agora, vamos admitir que todas as pessoas têm um email, e é da responsabilidade
 *      das classes derivadas gerar o email a partir do seu tipo e dados existentes.
 *   3) Nos alunos, o email segue o formato <NUMALUNO>@alunos.isel.pt
 *   4) Nos docentes, o email segue o formato <NUMDOCENTE>@docentes.isel.pt  
 * 
 */
public class App {
	
	public static void main(String[] args) {

		Person pBart = new Student(123, "Bart Simpson", Gender.Male);
		Person pHomer = new Teacher(123, "Hommer Simpson", Gender.Male, 123456789);
		
		// Escrita do email do aluno e professor no standard-output
		System.out.println(pBart.getEmail());	
		System.out.println(pHomer.getEmail());
		
		// Reparem que, no código anterior, é executado o método getEmail relativo
		// ao tipo concreto Student e Teacher, respectivamente.
	}

}
