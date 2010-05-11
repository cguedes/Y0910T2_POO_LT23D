import java.io.*;
import java.util.*;;


public final class CollectionUtils {

	/*
	 * Retorna uma colecção (ArrayList) com 
	 * todas as linhas encontradas na stream (Buffered)
	 * recebida como argumento 
	 */
	public static Collection<String> getLines(BufferedReader from) {

		Collection<String> lines = new ArrayList<String>();
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
	public static Collection<String> filterByWord(Collection<String> lines, String word)
	{
		Collection<String> newLines = new LinkedList<String>();
		
		word = word.toLowerCase();
		
		for(String line: lines)
		{
			if(line.toLowerCase().indexOf(word) != -1)
			{
				newLines.add(line);
			}
		}
		
		return newLines;

		/* ESTE CODIGO APENAS FUNCIONA PARA List<String>
		for(int i = 0; i < lines.size(); ++i)
		{
			String line = lines.get(i);
			
			if(line.toLowerCase().indexOf(word) != -1)
			{
				newLines.add(line);
			}
		}
	    */
		
	}

	
	/**
	 * Retorna a MESMA colecção REMOVENDO as linhas que NÃO contêm a palavra word.
	 * 
	 * @param lines
	 * @param word
	 * @return
	 */
	public static Collection<String> filterByWordWithRemove(Collection<String> lines, String word)
	{
		word = word.toLowerCase();
		
		// Versão a), ineficiente (por cada remove, percorre "toda" a colecção) 
		/*
		for(String line: lines)
		{
			if(line.toLowerCase().indexOf(word) == -1)
			{
				// a palavra word não consta em line, logo remove a linha da colecção
				lines.remove(line);
			}
		}
		*/
		
		// Versão b), eficiente (usa iteradores, na remoção está "posicionado" no local da remoção - não tem que procurar o elemento)
		Iterator<String> iter = lines.iterator();
		while(iter.hasNext())
		{
			String line = iter.next();
			if(line.toLowerCase().indexOf(word) == -1)
			{
				// remover :-)
				iter.remove();
			}
		}
		
		
		return lines;
	}
	
}
