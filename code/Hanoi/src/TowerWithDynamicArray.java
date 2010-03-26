import java.util.Arrays;


/**
 * Implementação de torre do jogo de Hanoi
 * através de array dinâmico.
 * 
 * @author cguedes
 *
 */
public class TowerWithDynamicArray implements Tower {

	public static final int MAX_DISCS = 5;
	
	private final char name;
	private int[] discs;
	// private int nDiscs; 			// substituido pelo discs.length (agora todos os discos do array contam)

	public TowerWithDynamicArray(char c, boolean isFull) {
		
		this.name = c;
		this.discs = new int[isFull ? MAX_DISCS : 0];

		// Preencher os valores dos discos (MAX_DISCS -> 0)
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
		
		for (int i = 0; i < discs.length; i++) {
			System.out.print(' ');
			System.out.print(discs[i]);
		}
		
		System.out.println();
		
	}

	public int removeDisc() {
		int removedDisc = discs[discs.length-1];  // obter o disco do "topo" da torre
		discs = Arrays.copyOf(discs, discs.length - 1);
		return removedDisc;
	}

	public void addDisc(int newDisc) {
		discs = Arrays.copyOf(discs, discs.length + 1);
		discs[discs.length-1] = newDisc;
	}

	public char getName() {
		return name;
	}

}

