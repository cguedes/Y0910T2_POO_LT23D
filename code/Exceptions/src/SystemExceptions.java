import java.text.MessageFormat;


public class SystemExceptions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Apresentação de vários cenários relativos a excepções geradas por tipos "built-in" do java
		// Para que os exemplos funcionem correctamente, apenas um dos métodos deve estar sem comentário.
		
		//showArrayException();
		//capturedArrayException();
		capturedStringException();
	}


	/**
	 * Exemplo que mostra os efeitos da geração de excepção no acesso a um índice inválido do array
	 * 
	 */
	private static void showArrayException()
	{
		int[] data = { 3, 5, 4, 7, 9 };
		
		// a) Acesso a um índice válido do array não gera erro
		int validIndex = 2;
		int validIndexValue = data[validIndex];
		System.out.println("O valor " + validIndexValue + " está no índice " + validIndex + " do array data.");
		
		// b) Acesso a um índice inválido do array GERA ERRO! (excepção)
		int invalidIndex = 12;
		// A PRÓXIMA INSTRUÇÃO, de indexação, GERA EXCEPÇÃO (java.lang.ArrayIndexOutOfBoundsException)
		int invalidIndexValue = data[invalidIndex];	
		System.out.println("O valor " + invalidIndexValue + " está no índice " + invalidIndex + " do array data.");
	}
	
	/**
	 * Exemplo que mostra a CAPTURA de excepção no acesso a um índice inválido do array
	 */
	private static void capturedArrayException() 
	{
		int[] data = { 3, 5, 4, 7, 9 };
		
		// O bloco try-catch permite a captura de excepções geradas no seu corpo (no exemplo, a excepção ArrayIndexOutOfBoundsException)
		try 
		{
			int index = 123;	// Exprimente colocar aqui diferentes valores. < 5 e >= 5
			int value = data[index];
			System.out.println(MessageFormat.format("O valor {0} está no índice {1} do array data.", value, index));
		}
		catch(ArrayIndexOutOfBoundsException exp) {
			// Este block captura TODAS as excepções do tipo ArrayIndexOutOfBoundsException geradas
			//   dentro do try-catch anterior. Depois de executar o código do "catch", a execução do 
			//   método capturedArrayException continua.
			System.out.println("Ups! Ocorreu excepção.");
			System.out.println(MessageFormat.format("A excepção tem a mensagem: {0}", exp.getMessage()));
			System.out.println("A excepção tem a seguinte descrição técnica:");
			exp.printStackTrace(System.out);
			
			// Se, no bloco try-catch for gerada uma excepção de outro tipo, funciona como no exemplo 
			//  anterior (showArrayException). 
		}
		
		System.out.println("NOTA: reparem que, como foi usado o bloco try-catch, estas ");
		System.out.println("      instruções são executadas, logo aparece este texto na consola.");
		
	}
	
	/**
	 * Exemplo com string 
	 */
	private static void capturedStringException() {

		String text = "Sou uma string com dimensão 30";
		System.out.println(MessageFormat.format("Dimensão da string: {0}", text.length()));
		
		try 
		{
			showCharAt(text, 20);
			
			//String s = null;
			//int x = s.length();
			
			showCharAt(text, 40);
			
		
		} 
		catch(StringIndexOutOfBoundsException strExp) 
		{
			System.out.println("StringIndexOutOfBoundsException catch code!");
		}
		catch(ArrayIndexOutOfBoundsException strExp) 
		{
			// Esta excepção nunca é gerada!! 
			System.out.println("ArrayIndexOutOfBoundsException catch code!");
		}
		finally 
		{ 
			System.out.println("finally code!");
		}
		

		System.out.println("end");
			
	}


	private static void showCharAt(String text, int index) 
	{
		char c = text.charAt(index);
		System.out.println(MessageFormat.format("O char {0} está no índice {1} da string text.", c, index));
	}
}
