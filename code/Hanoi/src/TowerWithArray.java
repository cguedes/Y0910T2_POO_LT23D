
public class TowerWithArray implements Tower {

	public static final int MAX_DISCS = 5;
	
	private final char name;
	private final int[] discs;
	private int nDiscs;

	private static int numberOfFullTowers = 0;
	

	public TowerWithArray(char c, boolean isFull) {
		
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

