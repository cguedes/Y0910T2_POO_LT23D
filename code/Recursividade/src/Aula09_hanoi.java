
public class Aula09_hanoi {

	static int NUM_DISCS = 20;
	public static void main(String[] args) 
	{
		int[] discs = {NUM_DISCS, 0, 0};
		show(discs);
		hanoi(discs, 0, 2, 1, NUM_DISCS);
		show(discs);
	}

	// ##########################################################################################
	// ##########################################################################################
	
	// Mostra os discos de hanoi
	private static void show(int[] discs) {
		System.out.println("-------- HANOI DISCS --------");
		for(int line = NUM_DISCS; line > 0; --line) {
			for(int i = 0; i < discs.length; ++i) {
				char disc = discs[i] >= line ? '#' : ' ';
				System.out.print("\t" + disc);
			}
			System.out.println();
		}
		for(int i = 0; i < discs.length; ++i) System.out.print("\t^");
		System.out.println();
		char discLetter = 'A';
		for(int i = 0; i < discs.length; ++i) System.out.print("\t" + discLetter++);
		System.out.println();
		System.out.println();
	}
		

	private static void hanoi(int[] discs, int from, int to, int tmp, int n) {
		System.out.println(String.format("%s -> %s %d discs, using %s", (char)('A' + from), (char)('A' + to), n, (char)('A' + tmp)));

		// if there are only one disc, move-it to the [to] axis 
		if(n == 1) {
			discs[from] -= 1;
			discs[to] += 1;
			show(discs);	   // debug
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
