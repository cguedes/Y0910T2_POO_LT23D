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
public class Main_foo_bla_func_WithThrow {

	public static void main(String[] args) {
		System.out.println("main: início.");

		foo();

		System.out.println("main: fim.");
	}
	
	public static void foo() {
		System.out.println("  foo: início.");
		
		try {
		
			bla(7, 5);
			//bla(1, 2);
			bla(-2, 2);  // Remover o comentário para ver a excepção ser gerada e o programa terminar
		
		} 
		catch(Exception e) {
			System.out.println("Ups! Ocorreu excepção.");
			System.out.println("Mensagem: " + e.getMessage());
			System.out.println("Cause type: " + e.getCause().getClass().toString());
			System.out.println("Cause message: " + e.getCause().getMessage());
			
		}
		
		System.out.println("  foo: fim.");
	}
	
	
	public static void bla(int x, int y) throws Exception {
		
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
	
	public static int func(int a, int b) throws Exception {
		
		System.out.println("       func: início.");
		System.out.println("        a = " + a + " b = " + b);
		
		try 
		{
			int x = a / b;	// VAI GERAR Excepção quando b for ZERO
			return x;
		}
		catch(ArithmeticException ae) 
		{
			System.out.println("Cuidado! O divisor é ZERO!");
			
			//throw new UnsupportedOperationException("Erro na divisão de a e b", ae);
			throw new Exception("Erro na divisão de a por b", ae);
		}
		finally
		{ 
			System.out.println("       func: fim.");
		}
		
	}


}
