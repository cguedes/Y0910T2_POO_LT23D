
class Axis {
	
	private final int[] discs;
	private final char name;
	private int currentNumDiscs;
	
	public Axis(char name, int totalNumDiscs, int currentNumDiscs) {
		this.name = name;
		this.currentNumDiscs = currentNumDiscs;
		this.discs = new int[totalNumDiscs];
		for (int i = 0; i < currentNumDiscs; i++) {
			discs[i] = i + 1;
		}
	}
	
	public void addDisc(int n) {
		discs[currentNumDiscs++] = n;
	}
	public int removeDisc() {
		int disc = discs[--currentNumDiscs];
		discs[currentNumDiscs] = 0;
		return disc;
	}
	
	public char getName()               { return name;     }
	public int  getDiscAtHeight(int h)  { return h < discs.length ? discs[h] : 0; }
}

public class Aula10_hanoi {

	static int NUM_DISCS = 20;
	public static void main(String[] args) 
	{
		Axis[] discs = { new Axis('A', NUM_DISCS, NUM_DISCS),
						 new Axis('B', NUM_DISCS, 0),
						 new Axis('C', NUM_DISCS, 0) };
		System.out.print("START: ######################"); show(discs);  
		hanoi(discs, 0, 2, 1, NUM_DISCS);
		System.out.print("END: ########################"); show(discs);
	}

	// ##########################################################################################
	// ##########################################################################################
	
	// Mostra os discos de hanoi
	private static void show(Axis[] discs) {
		System.out.println();
		System.out.println("-------- HANOI DISCS --------");
		for(int height = NUM_DISCS; height >= 0; --height) {
			for(int i = 0; i < discs.length; ++i) {
				int discVal = discs[i].getDiscAtHeight(height);
				char disc = (char) (discVal == 0 ? ' ' : ('0' + discVal));
				System.out.print("\t" + disc);
			}
			System.out.println();
		}
		for(int i = 0; i < discs.length; ++i) System.out.print("\t^");
		System.out.println();
		for(int i = 0; i < discs.length; ++i) System.out.print("\t" + discs[i].getName());
		System.out.println();
		System.out.println();
	}
		

	private static void hanoi(Axis[] discs, int from, int to, int tmp, int n) {
		//System.out.println(String.format("%s -> %s %d discs, using %s", (char)('A' + from), (char)('A' + to), n, (char)('A' + tmp)));

		// if there are only one disc, move-it to the [to] axis 
		if(n == 1) {
			int disc = discs[from].removeDisc();  // discs[from] -= 1;
			discs[to].addDisc(disc);              // discs[to] += 1;
			//show(discs);	   // debug
			return;
		}
		// move all the disks but-one to he aux axis
		hanoi(discs, from, tmp, to, n-1);
		// move the remaining disk to the [to] axis
		hanoi(discs, from, to, tmp, 1);
		// move the remaining disks on the aux to [to]
		hanoi(discs, tmp, to, from, n-1);
	}

}
