
public class TowerWithTwoValues implements Tower {

	public static final int MAX_DISCS = 5;
	
	private final char name;
	private int greatestDisc;	// maior disco
	private int numDiscs;		// número de discos
	
	public TowerWithTwoValues(char c, boolean isFull) {

		this.name = c;
		if(isFull == true) {
			greatestDisc = MAX_DISCS;
			numDiscs = MAX_DISCS;
		} else {
			greatestDisc = -1;	// tanto faz (numDiscs = 0)
			numDiscs = 0;
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
		
		for (int i = 0; i < numDiscs; i++) {
			System.out.print(' ');
			System.out.print( greatestDisc - i );
		}
		
		System.out.println();
		
	}

	public int removeDisc() {
		if(numDiscs == 0) {
			System.exit(0);	// ISTO NÃO DEVE ACONTECER !
		}
		
		// EX: greatestDisc = 4, numDiscs = 2
		//      -> significa que a torre tem os discos [4, 3]
		//      -> após remoção  fica com [4], ou seja,
		//            greatestDisc = 4 (mantém-se), numDiscs = 1
		
		--numDiscs;
		int removedDisc = greatestDisc - numDiscs;
		return removedDisc;
	}

	public void addDisc(int newDisc) {
		++numDiscs;
	}

	public char getName() {
		return name;
	}
	
}

