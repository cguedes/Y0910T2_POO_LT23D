package customException;

public class DivideByZeroExceptionApplication {

	public static void main(String[] args)
	{
		try 
		{
			double d1 = divide(6, 2);
			System.out.println(d1);
			
			double d2 = divide(6, 0);
			System.out.println(d2);
		}
		catch (DivideByZeroException e) {
			System.err.println("Ups!, divisão por zero: " + e.getMessage());
		}
	}

	/**
	 * returns the a/b result.
	 * If the b value is ZERO throws DivideByZeroException
	 * 
	 */
	public static double divide(int a, int b) 
		throws DivideByZeroException 
	{
	
		if( b == 0) {
			throw new DivideByZeroException();
		}
		
		return a / b;
	}
	
	
}
