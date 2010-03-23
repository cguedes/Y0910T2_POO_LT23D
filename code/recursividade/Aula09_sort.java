import java.util.Arrays;

public class Aula09_sort {

	public static void main(String[] args) 
	{
		int[] sortedValues = {1, 4, 5, 8, 9, 12, 13, 14, 15, 18};
		int sidx1 = binarySearch(sortedValues, 9);  checkValue(4, sidx1);
		int sidx2 = binarySearch(sortedValues, 10); checkValue(-1, sidx2);
		
		int[] scrambledValues = {4, 8, 5, 1, 7, 3, 2};
		int[] msSortedValues = mergeSort(scrambledValues);
		for (int i = 0; i < msSortedValues.length; i++) {
			int val = msSortedValues[i];
			System.out.print(val + " ");
		}
		System.out.println();
	}

	// ##########################################################################################
	// ##########################################################################################
	
	/**
	 * Retorna o índice do valor val no array ordenado data. Retorna -1 se o valor não for encontrado
	 */
	private static int binarySearch(int[] vals, int val) {
		return binarySearch(vals, val, 0, vals.length);
	}

	private static int binarySearch(int[] vals, int val, int s, int e) {
		if(e - s <= 0) return -1;
		if(e - s == 1) return vals[s] == val ? s : -1;
		int m = (s + e) / 2;		// middle index
		int ref = vals[m];			// middle value
		if(ref == val) return m;	// return the middle index (m) if the value was found
		if(ref > val) return binarySearch(vals, val, s, m);	// search in the first half
		return binarySearch(vals, val, m+1, e);
	}

	
	// ##########################################################################################
	// ##########################################################################################

	/**
	 * Retorna um array ordenado com os valores de scrambledValues, 
	 *  utilizando o algoritmo recursivo de ordenação mergeSort.
	 */
	private static int[] mergeSort(int[] scrambledValues) {
		// Sorted array
		if(scrambledValues == null || scrambledValues.length <= 1) return scrambledValues;
		
		// split -> sort -> join
		int middle = scrambledValues.length / 2;
		int[] first = Arrays.copyOfRange(scrambledValues, 0, middle); 
		int[] second = Arrays.copyOfRange(scrambledValues, middle, scrambledValues.length);
		
		first = mergeSort(first);
		second = mergeSort(second);
		
		return orderedJoin(first, second);
	}

	private static int[] orderedJoin(int[] first, int[] second) {
		int f = 0, s = 0, to = 0;
		int[] res = new int[first.length + second.length];
		while(f < first.length && s < second.length) 
		{
			if(first[f] < second[s]) res[to++] = first[f++];
			else                     res[to++] = second[s++];
		}
		while(f < first.length)  res[to++] = first[f++];
		while(s < second.length) res[to++] = second[s++];
		
		return res;
	}

	// ##########################################################################################
	// ##########################################################################################

	private static void checkValue(int expected, int value) 
	{
		System.out.println(expected + " == " + value + " ?");
	}

}
