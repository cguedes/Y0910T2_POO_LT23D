import java.io.*;

public class CopyBytesFromFile {

	public static void main(String[] args) throws IOException {
		
		String fileNameIn = "zip/xanadu.zip";
		String fileNameOut = "zip/xanadu.out.zip";
		InputStream in = null;
		OutputStream out = null;
		
		try 
		{
			in = new FileInputStream(fileNameIn);
			out = new FileOutputStream(fileNameOut, true /* append = true */);
			
			int bytesAvailable = in.available();
			System.out.println("O ficheiro tem [" + bytesAvailable + "] bytes disponíveis");
			
			int byteValue;
			while( (byteValue = in.read()) != -1)
			{
				//System.out.print((char)byteValue);
				out.write(byteValue);
			}
			
			System.out.println("Copia realizada com sucesso");
			
		}
		catch(FileNotFoundException fnfExp)
		{
			System.err.println("O ficheiro " + fileNameIn + " não foi encontrado!");
		}
		catch(IOException ioExp)
		{
			System.err.println("Ocorreu um erro inesperado ao ler/escrever o ficheiro.");
			ioExp.printStackTrace();
		}
		finally 
		{
			// Devemos SEMPRE fechar aS streamS
			if(in != null)  { in.close();  }
			if(out != null) { out.close(); }
		}
		
	}
	
}
