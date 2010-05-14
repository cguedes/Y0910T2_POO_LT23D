package iterators;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class StringArrayIterator implements Iterator<String> {

	private final String[] input;
	private int pos = 0;
	
	public StringArrayIterator(String[] input) {
		this.input = input;
	}
	
	@Override
	public boolean hasNext() {
		return input != null && pos < input.length;
	}

	@Override
	public String next() {
		if(!hasNext()) throw new NoSuchElementException();
		
		String strReturn = input[pos];
		++pos;
		return strReturn;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
