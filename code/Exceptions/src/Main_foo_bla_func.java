import java.text.MessageFormat;

/**
 * Este exemplo mostra que as excepções, que não são capturadas,  
 * provocam o fim da execução da aplicação.
 * 
 * No exemplo, o main executa a função foo que por sua vez executa
 * a função bla, que executa a função func que gera excepção. É possível
 * verificar que o código que se encontra APÓS as chamadas às 
 * funções indicadas, não é executado.
 *
 */
public class Main_foo_bla_func {

	public static void main(String[] args) {
		System.out.println("main: início.");

		foo();

		System.out.println("main: fim.");
	}
	
	public static void foo() {
		System.out.println("  foo: início.");
		
		bla(7, 5);
		//bla(1, 2);
		bla(-2, 2);  // Remover o comentário para ver a excepção ser gerada e o programa terminar
		
		System.out.println("  foo: fim.");
	}
	
	
	public static void bla(int x, int y) {
		
		System.out.println();
		System.out.println("    bla: início.");
		System.out.println("     x = " + x + " y = " + y);
		int res;
		if(x > y) {
			res = func(6, x - y);
		} else {
			res = func(6, x + y);
		}
		System.out.println("     res = " + res);
		
		System.out.println("    bla: fim.");
		System.out.println();
		
	}
	
	public static int func(int a, int b) {
		
		System.out.println("       func: início.");
		System.out.println("        a = " + a + " b = " + b);
		
		int x = a / b;	// VAI GERAR Excepção quando b for ZERO
		
		System.out.println("       func: fim.");
		
		return x;
	}


}
