
class Tower {

	public static final int MAX_DISCS = 5;
	
	private final char name;
	private final int[] discs;
	private int nDiscs;

	private static int numberOfFullTowers = 0;
	

	public Tower(char c, boolean isFull) {
		
		if(isFull) numberOfFullTowers += 1;

		// Verificar se é a segunda chamada a este método 
		// com isFull = true
		if(numberOfFullTowers > 1) {
			System.err.println("ERRO FATAL: Nao podem existir duas torres cheias na sua construcao!");
			System.exit(0);
		}
		
		
		
		this.name = c;
		this.discs = new int[MAX_DISCS];
		if(isFull == false) {
			this.nDiscs = 0;
			return;
		}
		
		this.nDiscs = MAX_DISCS;
		for (int i = 0; i < discs.length; i++) {
			discs[i] = MAX_DISCS - i;
		}
	}

	/**
	 * Mostra uma torre no formato horizontal:
	 * 
	 *  NOME: <discos>
	 *  
	 *  Exemplo (torre 'A' com os discos 2 e 1):
	 *   A: 2 1
	 * 
	 */
	public void show() {
		System.out.print(this.name);
		System.out.print(':');
		
		for (int i = 0; i < nDiscs; i++) {
			System.out.print(' ');
			System.out.print(discs[i]);
		}
		
		System.out.println();
		
	}

	public int removeDisc() {
		int removedDisc = discs[nDiscs-1];  // obter o disco do "topo" da torre
		discs[nDiscs-1] = 0;				// "remover" o disco da torre
		--nDiscs;
		return removedDisc;
	}

	public void addDisc(int newDisc) {
		discs[nDiscs] = newDisc;
		++nDiscs;
	}

	public char getName() {
		return name;
	}
	
}



public class Aula10_hanoi_DiscosV1 {
	
	public static void main(String[] args)
	{
		Tower[] board = { new Tower('A', true), 
					 	  new Tower('B', false),
					 	  new Tower('C', false) };

		show(board);

		int srcIdx = 0, dstIdx = 2, auxIdx = 1;
		int numberOfDiscsMoved = 
			hanoi(board, srcIdx, dstIdx, auxIdx, Tower.MAX_DISCS);
		
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

