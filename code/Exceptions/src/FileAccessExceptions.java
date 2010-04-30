import java.io.*;

public class FileAccessExceptions {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("Before try-catch");
		int i = 0;
		try 
		{
			FileReader fr = new FileReader("foo.txt");
			int ch;
			
			System.out.println("-----------------------------------------------------");

			while( (ch = fr.read()) != -1)
			{
				char c = (char)ch;
				System.out.print(c);	// Quiz: Porque é que quando usamos ch, o resultado é diferente?
			}
			
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("last instruction of try catch");
		} 
		catch(IOException ioExp) {
			System.out.println("IOException handling: " + ioExp.getMessage());
		}
		finally {
			System.out.println("Finally code");
		}
		
		System.out.println("Code after try { } catch");
		
	}
}