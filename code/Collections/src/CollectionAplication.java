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
			
			Collection<String> lines = CollectionUtils.getLines(fileBufferedReader);
			System.out.println(lines.getClass().toString());
			lines = CollectionUtils.filterByWord(lines, "Alice");
			System.out.println(lines.getClass().toString());
			
			System.out.println("Numero de linhas: " + lines.size());
			// Mostrar as linhas que contêm alice, usando iterador
			// de duas formas distintas:
			//   a) Usando EXPLICITAMENTE o método iterator
			System.out.println("--------------------- Método 1 ---------------------");
			Iterator<String> iter = lines.iterator();
			while( iter.hasNext() )
			{
				String line = iter.next();
				System.out.println(line);
			}
			
			//   b) Usando IMPLICITAMENTE o método iterator (usa-se a interface Iterable<E>)
			System.out.println("--------------------- Método 2 ---------------------");
			for(String line: lines)
			{
				System.out.println(line);
			}
			
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
