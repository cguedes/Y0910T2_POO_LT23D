
public class Aula10_hanoi_arrays {
	
	public static void main(String[] args)
	{
		final int MAX_DISCS = 50;
		int[] board = { MAX_DISCS, 0, 0 };
		show(board);

		int srcIdx = 0, dstIdx = 2, auxIdx = 1;
		int numberOfDiscsMoved = hanoi(board, srcIdx, dstIdx, auxIdx, MAX_DISCS);
		
		show(board);
		
		System.out.println("Foram movidos " + numberOfDiscsMoved + " discos.");
	}

	/**
	 * Mostrar o tabuleiro na forma:
	 * 
	 *   A: # # #
	 *   B:
	 *   C:
	 * 
	 * @param board
	 */
	private static void show(int[] board) {
		System.out.println("-------- HANOI --------");
		char towerChar = 'A';
		for (int i = 0; i < board.length; i++) {
			System.out.print(towerChar);
			System.out.print(':');
			towerChar += 1;
			for (int j = 0; j < board[i]; j++) {
				System.out.print(" #");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int hanoi(int[] board, 
						 	  int src, int dst, int aux,
						 	  int nDiscs) 
	{
		if(nDiscs == 1)
		{
			// mover de facto um disco de src para dst
			// ... ou seja, alterar os valores do array board
			board[src] -= 1;
			board[dst] += 1;
			//show(board);

			return 1;
		}
		
		int n = 0;
		
		// mover todos menos um discos de origem para auxiliar
		n += hanoi(board, src, aux, dst, nDiscs - 1);
		
		// mover um disco para o destino
		n += hanoi(board, src, dst, aux, 1);
		
		// mover os restantes discos de aux para destino
		n += hanoi(board, aux, dst, src, nDiscs - 1);
		
		return n;
	}


}











