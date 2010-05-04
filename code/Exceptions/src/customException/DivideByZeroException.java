package customException;

public class DivideByZeroException extends Exception {

	public DivideByZeroException() {
		super("Não é possível realizar divisões com divisor igual a ZERO");
	}
	
}
