import java.io.*;
import java.util.*;;


public final class CollectionUtils {

	/*
	 * Retorna uma colecção (ArrayList) com 
	 * todas as linhas encontradas na stream (Buffered)
	 * recebida como argumento 
	 */
	public static ArrayList<String> getLines(BufferedReader from) {

		ArrayList<String> lines = new ArrayList<String>();
		try 
		{
			String line = null;
			while( (line = from.readLine()) != null )
			{
				// adicionar à colecção
				lines.add(line);
			}
		} 
		catch(IOException e) 
		{
			// Registar erro e continuar a execução
			System.err.println("Erro ao ler da stream: " + e.getMessage());
		}
		
		return lines;		
	}
	
	/**
	 * Retorna uma NOVA colecção apenas com as linhas que contêm a palavra word.
	 * 
	 * @param lines
	 * @param word
	 * @return
	 */
	public static ArrayList<String> filterByWord(ArrayList<String> lines, String word)
	{
		ArrayList<String> newLines = new ArrayList<String>();
		
		word = word.toLowerCase();
		for(int i = 0; i < lines.size(); ++i)
		{
			String line = lines.get(i);
			if(line.toLowerCase().indexOf(word) != -1)
			{
				newLines.add(line);
			}
		}
		
		return newLines;
	}
	
}
