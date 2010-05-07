import java.io.*;

public class CopyTextFromFile {

	
	public static void main(String[] args) throws IOException {
		
		File xanaduFile = new File("xanadu.txt");
		if(!xanaduFile.exists()) {
			System.out.println("Ups, o ficheiro não existe.");
			System.exit(0);
		}
		
		if(!xanaduFile.canRead()) {
			System.out.println("Ups, não posso ler do ficheiro.");
			System.exit(0);
		}
		
		FileReader xanadu = new FileReader(xanaduFile);
		//PrintWriter xanaduOut = new PrintWriter(System.out);
		//PrintWriter xanaduOut = new PrintWriter( new FileOutputStream("xanaduout.txt", true) );
		StringWriter sw = new StringWriter((int)xanaduFile.length());
		PrintWriter xanaduOut = new PrintWriter(sw);
		
		System.out.println("SW (antes do copy) = " + sw.toString());
		
		copy(xanadu, xanaduOut);
		
		System.out.println("SW (depois do copy) = " + sw.toString());

		// Fecha as streams
        //  No caso da stream bufferizada (PrintWriter), garante que é feito o flush.
		try {
			if(xanadu != null) {
				xanadu.close();
			}
		}
		catch(IOException exp) { System.err.println("Erro ao fechar a stream de leitura.");  }
		
		if(xanaduOut != null) {
			xanaduOut.close();
		}
		
	}

	// Função que le o conteúdo de um reader e escreve num writer
	public static void copy(FileReader fileReader, PrintWriter pw)
	{
		try 
		{
			BufferedReader br = new BufferedReader(fileReader);
			String line;
			while( (line = br.readLine()) != null)
			{
				System.out.println("DEBUG: " + line);
				pw.println(line);
			}
			// pw.flush();
		} 
		catch (IOException e) 
		{
			System.err.println("Ocorreu um erro na leitura.");
			e.printStackTrace();
		}
		
		
	}
	
}
