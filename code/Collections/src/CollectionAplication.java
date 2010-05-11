import java.io.*;
import java.util.*;


public class CollectionAplication {

	public static void main(String[] args) throws IOException {

		BufferedReader fileBufferedReader = null;
		try 
		{
			fileBufferedReader = 
				new BufferedReader( 
						new FileReader("AliceNoPaisDasMaravilhas.txt") );
			
			ArrayList<String> lines = CollectionUtils.getLines(fileBufferedReader);
			lines = CollectionUtils.filterByWord(lines, "Alice");
			System.out.println("Numero de linhas: " + lines.size());
		
		}
		catch(FileNotFoundException e)
		{
			System.err.println("O ficheiro não foi encontrado!");
		}
		finally {
			if(fileBufferedReader != null)
				fileBufferedReader.close();
		}
		
	}
	
}
