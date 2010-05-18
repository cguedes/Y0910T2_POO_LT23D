package iterators;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class ObjectArrayIterator implements Iterator<Object> {

	private final Object[] input;
	private int pos = 0;
	
	public ObjectArrayIterator(Object[] input) {
		this.input = input;
	}
	
	@Override
	public boolean hasNext() {
		return input != null && pos < input.length;
	}

	@Override
	public Object next() {
		if(!hasNext()) throw new NoSuchElementException();
		
		Object strReturn = input[pos];
		++pos;
		return strReturn;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
