
public class Aula07e08 {

	public static void main(String[] args) 
	{
		showEvenDigits(1234567890); System.out.println();
		int gd = greaterDigit(1281238237); checkValue(8, gd);
		int ed = evenDigits(1234567890);   checkValue(5, ed);
		int cw = countWords("sou uma frase com uma ou mais palavras com a palavra uma", "uma"); checkValue(3, cw);
		int no = numberOfOccurrences(new int[] {4,5,3,4,6,5,6,7,8,7,5}, 5); checkValue(3, no);
	}

	/**
	 * Apresenta os dígitos pares do número number na consola
	 */
	public static void showEvenDigits(int number) 
	{
		if(number < 10 ) { 
			if(number % 2 == 0) System.out.print(number); 
			return; 
		}
		showEvenDigits(number / 10);   // exprimentem trocar estas duas linhas 
		showEvenDigits(number % 10);   // e vejam o resultado obtido. 
		
		/* 
		 * Esta é outra forma de implementar este exercício.
		 * 
		if(number >= 10) showEvenDigits(number / 10);
		int d = number % 10;
		if(d % 2 == 0) System.out.print(d);
		*/
	}

	/**
	 * Retorna o maior dígito do número number
	 */
	public static int greaterDigit(int number) 
	{
		if(number < 10) return number;
		int d = number % 10;
		int max = Math.max(d, greaterDigit(number / 10));
		return max;
	}

	/**
	 * Retorna o número dígitos pares de number
	 */
	public static int evenDigits(int number) 
	{
		// Facto: Sei o que fazer quando o número é apenas um dígito 
		//  -> 1 caso seja par, 0 caso contrário 
		if(number < 10) return number % 2 == 0 ? 1 : 0;

		// soma do número de dígitos pares presentes no dígito das unidades (n%10),
		// com o número de dígitos presentes no resto dos digitos (n/10).
		return evenDigits(number % 10) + evenDigits(number / 10);	 
	}

	/**
	 * Retorna o número de ocorrências de word em phrase
	 * @param phrase 
	 * 	 Conjunto de caracteres que forma uma frase. 
	 *   Não tem necessariamente que cumprir as regras do português :-)
	 * @param word
	 * 	 Palavra a procurar. Deve ser ententido como um conjunto de 
	 *   caracteres de pesquisa, não tendo que ser uma "palavra" do português.
	 *   Em particular, pode estar dentro de outra palavra.
	 */
	public static int countWords(String phrase, String word) 
	{
		int idx = phrase.indexOf(word);
		if(idx == -1) return 0;
		return 1 + countWords(phrase.substring(idx + word.length()), word);
	}

	/**
	 * Retorna o número de ocorrências de ref no array vals
	 * Este método utiliza um método auxiliar que indica a partir 
	 *  de que ponto é que se devem considerar valores no array vals.  
	 */
	public static int numberOfOccurrences(int[] vals, int ref) 
	{
		return numberOfOccurrences(vals, ref, 0);
	}
	
	private static int numberOfOccurrences(int[] vals, int ref, int i) {
		int val = vals[i];
		int counter = val == ref ? 1 : 0;
		if(i == vals.length - 1) return counter;
		return counter + numberOfOccurrences(vals, ref, i + 1);
	}


	/**
	 * Método auxiliar que ajuda a perceber se o valor que 
	 * estamos à espera (expected) é igual ao valor passado 
	 * como segundo parâmetro (value)
	 */
	private static void checkValue(int expected, int value) 
	{
		System.out.println(expected + " == " + value + " ?");
	}

}
