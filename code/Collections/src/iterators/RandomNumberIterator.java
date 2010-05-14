package iterators;
import java.util.Iterator;
import java.util.Random;

public class RandomNumberIterator implements Iterator<Integer> {

	private Random rand = new Random();
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Integer next() {
		return rand.nextInt();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
