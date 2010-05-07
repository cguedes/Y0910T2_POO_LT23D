import java.io.*;

public class ShowBytesFromFile {

	public static void main(String[] args) throws IOException {
		
		String fileName = "xanadu.txt";
		InputStream in = null;
		
		try 
		{
			in = new FileInputStream(fileName);
			
			//in.close();
			
			int bytesAvailable = in.available();
			System.out.println("O ficheiro tem [" + bytesAvailable + "] bytes disponíveis");
			
			//in.close();
			
			int byteValue;
			while( (byteValue = in.read()) != -1)
			{
				System.out.print((char)byteValue);
			}
			
		}
		catch(FileNotFoundException fnfExp)
		{
			System.err.println("O ficheiro " + fileName + " não foi encontrado!");
		}
		catch(IOException ioExp)
		{
			System.err.println("Ocorreu um erro inesperado ao ler o ficheiro.");
			ioExp.printStackTrace();
		}
		finally 
		{
			// Devemos SEMPRE fechar a stream
			if(in != null) 
			{
				in.close();
			}
		}
		
	}
	
}
