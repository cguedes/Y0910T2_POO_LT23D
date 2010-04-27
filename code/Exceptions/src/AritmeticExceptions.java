import java.text.MessageFormat;


public class AritmeticExceptions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Cenários relativo a excepçção aritmética (divisão por zero)
		// NOTA: O texto da excepção pode surgir, na consola, em local arbitrário!
		//       Normalmente é no final.
		int a = 3, b = 4, res;

		res = a / b;
		System.out.println(MessageFormat.format("{0} / {1} = {2}", a, b, res));
		
		a = 0;
		res = a / b;
		System.out.println(MessageFormat.format("{0} / {1} = {2}", a, b, res));

		a = 4;
		b = 0;
		res = a / b;	// Esta linha gera excepção (ArithmeticException)!
		System.out.println(MessageFormat.format("{0} / {1} = {2}", a, b, res));
	}


}
