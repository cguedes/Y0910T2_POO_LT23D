public class HanoiSolver {
	
	public static void main(String[] args)
	{
		Tower[] board = { new TowerWithArray('A', true), 
					 	  new TowerWithDynamicArray('B', false),
					 	  new TowerWithArray('C', false) };

		show(board);

		int srcIdx = 0, dstIdx = 2, auxIdx = 1;
		int numberOfDiscsMoved = 
			hanoi(board, srcIdx, dstIdx, auxIdx, TowerWithArray.MAX_DISCS);
		
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
	private static void show(Tower[] board) {
		System.out.println("-------- HANOI --------");
		for (int i = 0; i < board.length; i++) {
			Tower tower = board[i];
			tower.show();
		}
		System.out.println();
	}

	private static int hanoi(Tower[] board, 
						 	  int src, int dst, int aux,
						 	  int nDiscs) 
	{
		Tower srcTower = board[src];
		Tower dstTower = board[dst];

		System.out.println(
				String.format("Mover %d discos de %s para %s",
							  nDiscs,
							  srcTower.getName(),
							  dstTower.getName()
				)
		);
		
		if(nDiscs == 1)
		{
			// mover de facto um disco de src para dst
			// ... ou seja, alterar os valores do array board
			//board[src] -= 1;
			//board[dst] += 1;
			
			int removedDisc = srcTower.removeDisc();
			dstTower.addDisc(removedDisc);

			show(board);

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

