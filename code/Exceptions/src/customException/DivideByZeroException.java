package customException;

public class DivideByZeroException extends Exception {

	public DivideByZeroException() {
		super("N�o � poss�vel realizar divis�es com divisor igual a ZERO");
	}
	
}
